package be.kdg.prog6.parkplanning.adapters.out.db.DBAdapters;

import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.POIJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.StaffMemberJpaEntity;
import be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories.StaffMemberJpaRepository;
import be.kdg.prog6.parkplanning.domain.PointOfInterest;
import be.kdg.prog6.parkplanning.ports.out.*;
import be.kdg.prog6.parkplanning.adapters.out.db.JPARepositories.POIJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class POIDBAdapter implements StaffMemberRemovedPort, POIOpenedStatusChangedPort, POILoadPort, POIUpdatePort {
    private final POIJpaRepository poiJpaRepository;
    private final StaffMemberJpaRepository staffMemberJpaRepository;
    private final StaffMemberConversionPort staffMemberConversionPort;

    public static final Logger log = LoggerFactory.getLogger(POIDBAdapter.class);

    public POIDBAdapter(POIJpaRepository poiJpaRepository, StaffMemberJpaRepository staffMemberJpaRepository, StaffMemberConversionPort staffMemberConversionPort) {
        this.poiJpaRepository = poiJpaRepository;
        this.staffMemberJpaRepository = staffMemberJpaRepository;
        this.staffMemberConversionPort = staffMemberConversionPort;
    }

    @Override
    @Transactional
    @Modifying
    public void removeStaffMember(UUID poiUuid, UUID staffMemberUuid) {
        log.debug("remove staff member called, POI with UUID {} will have staff member with uuid {} removed from it", poiUuid, staffMemberUuid);
        Optional<POIJpaEntity> poi = poiJpaRepository.findById(poiUuid);
        Optional<StaffMemberJpaEntity> staffMember = staffMemberJpaRepository.findById(staffMemberUuid);
        if (poi.isPresent() && staffMember.isPresent() && poi.get().getStaff().contains(staffMember.get())) {
            List<StaffMemberJpaEntity> staffMembers = poi.get().getStaff();
            staffMembers.remove(staffMember.get());
            poi.get().setStaff(staffMembers);
            poiJpaRepository.save(poi.get());
        }
    }

    @Override
    @Transactional
    @Modifying
    public void openStatusChanged(UUID uuid, boolean open) {
        log.debug("change open status called, POI with UUID {} will have its open status changed to {}", uuid, open);
        poiJpaRepository.updateOpenStatusByUuid(uuid, open);
    }

    @Override
    public PointOfInterest loadPointOfInterest(UUID uuid) {
        log.debug("loading POI with UUID {}", uuid);
        Optional<POIJpaEntity> pointOfInterest = poiJpaRepository.findById(uuid);
        //TODO: add exception: POINotFoundException
        return pointOfInterest.map(poiJpaEntity -> new PointOfInterest(
                new PointOfInterest.PointOfInterestUUID(poiJpaEntity.getUuid()),
                staffMemberConversionPort.convert(pointOfInterest.get().getStaff()),
                poiJpaEntity.isOpen()
        )).orElse(null);
    }

    @Override
    public void updatePOI(PointOfInterest pointOfInterest) {
        List<StaffMemberJpaEntity> staffMembers = new ArrayList<>();
        pointOfInterest.getStaff().forEach(staffMember -> staffMembers.add(new StaffMemberJpaEntity(staffMember)));
        POIJpaEntity poiJpaEntity = new POIJpaEntity(
                pointOfInterest.getUuid().uuid(),
                staffMembers,
                pointOfInterest.isOpen()
        );
        poiJpaRepository.save(poiJpaEntity);
    }
}
