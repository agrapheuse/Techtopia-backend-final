package be.kdg.prog6.ticket.adapters.out.db.JPAEntities;

import be.kdg.prog6.enums.Status;
import be.kdg.prog6.ticket.domain.Gender;
import be.kdg.prog6.ticket.domain.TicketAgeType;
import be.kdg.prog6.ticket.domain.TicketOption;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.time.LocalDate;
import java.util.UUID;

@Entity
@Table(name="Ticket")
public class TicketJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    private UUID uuid;
    private LocalDate date;
    private String name;
    private int age;
    @Enumerated(EnumType.STRING)
    private Gender gender;
    @Enumerated(EnumType.STRING)
    private TicketOption ticketOption;
    @Enumerated(EnumType.STRING)
    private TicketAgeType ageType;
    private String email;
    @Enumerated(EnumType.STRING)
    private Status status;

    public TicketJpaEntity(UUID uuid, LocalDate date, String name, int age, Gender gender, TicketOption ticketOption, TicketAgeType ageType, String email, Status status) {
        this.uuid = uuid;
        this.date = date;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ticketOption = ticketOption;
        this.ageType = ageType;
        this.email = email;
        this.status = status;
    }

    public TicketJpaEntity() {
    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public TicketOption getTicketOption() {
        return ticketOption;
    }

    public void setTicketOption(TicketOption option) {
        this.ticketOption = option;
    }

    public TicketAgeType getAgeType() {
        return ageType;
    }

    public void setAgeType(TicketAgeType ageType) {
        this.ageType = ageType;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Status getStatus() {
        return status;
    }

    public void setStatus(Status status) {
        this.status = status;
    }
}
