package be.kdg.prog6.ticket.domain;

import be.kdg.prog6.enums.Status;

import java.time.LocalDate;
import java.util.Objects;
import java.util.UUID;

public class Ticket {
    public record TicketUuid(UUID uuid) {
    }

    private TicketUuid uuid;
    private LocalDate date;
    private String name;
    private int age;
    private Gender gender;
    private TicketOption ticketOption;
    private TicketAgeType ageType;
    private String email;
    private Status status;

    public Ticket(TicketUuid uuid, LocalDate date, String name, int age, Gender gender, TicketOption option, TicketAgeType ageType, String email, Status status) {
        this.uuid = uuid;
        this.date = date;
        this.name = name;
        this.age = age;
        this.gender = gender;
        this.ticketOption = option;
        this.ageType = ageType;
        this.email = email;
        this.status = status;
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

    public TicketOption getTicketOption() {
        return ticketOption;
    }

    public void setTicketOption(TicketOption ticketOption) {
        this.ticketOption = ticketOption;
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

    @Override
    public String toString() {
        return "Ticket{" +
                "uuid=" + uuid +
                ", date=" + date +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", gender=" + gender +
                ", ticketOption=" + ticketOption +
                ", ageType=" + ageType +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Ticket ticket = (Ticket) o;
        return Objects.equals(uuid, ticket.uuid) && Objects.equals(email, ticket.email);
    }

    @Override
    public int hashCode() {
        return Objects.hash(uuid, email);
    }
}
