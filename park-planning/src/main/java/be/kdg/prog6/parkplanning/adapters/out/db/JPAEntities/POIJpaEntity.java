package be.kdg.prog6.parkplanning.adapters.out.db.JPAEntities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.List;
import java.util.UUID;

@Table(name="PointOfInterestParkPlanning")
@Entity
public class POIJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;

    @OneToMany
    private List<StaffMemberJpaEntity> staff;

    private boolean open;
    private int amountOfPeople;

    public POIJpaEntity(UUID uuid, List<StaffMemberJpaEntity> staff, boolean open, int amountOfPeople) {
        this.uuid = uuid;
        this.staff = staff;
        this.open = open;
        this.amountOfPeople = amountOfPeople;
    }

    public POIJpaEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public List<StaffMemberJpaEntity> getStaff() {
        return staff;
    }

    public void setStaff(List<StaffMemberJpaEntity> staff) {
        this.staff = staff;
    }

    public boolean isOpen() {
        return open;
    }

    public void setOpen(boolean open) {
        this.open = open;
    }

    public int getAmountOfPeople() {
        return amountOfPeople;
    }

    public void setAmountOfPeople(int queueLength) {
        this.amountOfPeople = queueLength;
    }

    @Override
    public String toString() {
        return "POIJpaEntity{" +
                "uuid=" + uuid +
                ", staff=" + staff +
                ", open=" + open +
                '}';
    }
}
