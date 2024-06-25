package be.kdg.prog6.parkplanning.PointOfInterest.db;

import be.kdg.prog6.parkplanning.PointOfInterest.addStaffMember.ports.StaffMemberAddedPort;
import be.kdg.prog6.parkplanning.PointOfInterest.close.ports.POIClosedPort;
import be.kdg.prog6.parkplanning.PointOfInterest.deductStaffMember.ports.StaffMemberRemovedPort;
import be.kdg.prog6.parkplanning.PointOfInterest.open.ports.POIOpenedPort;
import be.kdg.prog6.parkplanning.StaffMember.db.StaffMemberJpaEntity;
import be.kdg.prog6.parkplanning.StaffMember.db.StaffMemberJpaRepository;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Repository
public class POIDBAdapter implements POIOpenedPort, POIClosedPort, StaffMemberAddedPort, StaffMemberRemovedPort {
    private final POIJpaRepository poiJpaRepository;
    private final StaffMemberJpaRepository staffMemberJpaRepository;

    public static final Logger log = LoggerFactory.getLogger(POIDBAdapter.class);

    public POIDBAdapter(POIJpaRepository poiJpaRepository, StaffMemberJpaRepository staffMemberJpaRepository) {
        this.poiJpaRepository = poiJpaRepository;
        this.staffMemberJpaRepository = staffMemberJpaRepository;
    }

    @Override
    public void openPOI(UUID uuid) {
        log.info("updating DB");
        poiJpaRepository.updateOpenByUuid(uuid);
    }

    @Override
    public void closePOI(UUID uuid) {
        poiJpaRepository.updateCloseByUuid(uuid);
    }

    @Override
    @Transactional
    @Modifying
    public void addStaffMember(UUID poiUuid, UUID staffMemberUuid) {
        Optional<POIJpaEntity> poi = poiJpaRepository.findById(poiUuid);
        Optional<StaffMemberJpaEntity> staffMember = staffMemberJpaRepository.findById(staffMemberUuid);
        if (poi.isPresent() && staffMember.isPresent()) {
            List<StaffMemberJpaEntity> staffMembers = poi.get().getStaff();
            staffMembers.add(staffMember.get());
            poi.get().setStaff(staffMembers);
            poiJpaRepository.save(poi.get());
        }
    }

    @Override
    @Transactional
    @Modifying
    public void removeStaffMember(UUID poiUuid, UUID staffMemberUuid) {
        Optional<POIJpaEntity> poi = poiJpaRepository.findById(poiUuid);
        Optional<StaffMemberJpaEntity> staffMember = staffMemberJpaRepository.findById(staffMemberUuid);
        if (poi.isPresent() && staffMember.isPresent() && poi.get().getStaff().contains(staffMember.get())) {
            List<StaffMemberJpaEntity> staffMembers = poi.get().getStaff();
            staffMembers.remove(staffMember.get());
            poi.get().setStaff(staffMembers);
            poiJpaRepository.save(poi.get());
        }
    }
}
