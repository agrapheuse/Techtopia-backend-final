package be.kdg.prog6.parkplanning.ports.out;

import be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities.StaffMemberJpaEntity;
import be.kdg.prog6.parkplanning.domain.StaffMember;

import java.util.List;

public interface StaffMemberConversionPort {
    List<StaffMember> convert(List<StaffMemberJpaEntity> staffMembers);
}