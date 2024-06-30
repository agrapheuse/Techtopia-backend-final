package be.kdg.prog6.ticket.domain;

import java.util.UUID;

public class Person {
    public record PersonUUID(UUID uuid) {}
    public enum Sex {M, MME, OTHER}

    private PersonUUID uuid;
    private String name;
    private Sex sex;
    private int age;

    public Person(PersonUUID uuid, String name, Sex sex, int age) {
        this.uuid = uuid;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public PersonUUID getUuid() {
        return uuid;
    }

    public void setUuid(PersonUUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Sex getSex() {
        return sex;
    }

    public void setSex(Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
