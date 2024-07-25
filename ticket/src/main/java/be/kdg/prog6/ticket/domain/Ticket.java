package be.kdg.prog6.ticket.domain;

import java.time.LocalDate;
import java.util.UUID;

public class Ticket {
    public record TicketUuid(UUID uuid) {
    }

    private TicketUuid uuid;
    private LocalDate date;
    private String name;
    private int age;
    private Gender gender;
    private TicketOption option;
    private TicketAgeType ageType;
    private String email;

    public Ticket(TicketUuid uuid, LocalDate date, String name, int age, Gender gender, TicketOption option, TicketAgeType ageType, String email) {
        this.uuid = uuid;
        this.date = date;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.option = option;
        this.ageType = ageType;
        this.email = email;
    }

    public TicketUuid getUuid() {
        return uuid;
    }

    public void setUuid(TicketUuid uuid) {
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

    public TicketOption getOption() {
        return option;
    }

    public void setOption(TicketOption option) {
        this.option = option;
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
}
