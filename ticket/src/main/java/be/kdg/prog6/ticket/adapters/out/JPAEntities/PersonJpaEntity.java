package be.kdg.prog6.ticket.adapters.out.JPAEntities;

import be.kdg.prog6.ticket.domain.Person;
import jakarta.persistence.*;
import org.hibernate.annotations.JdbcTypeCode;

import java.sql.Types;
import java.util.UUID;

@Entity
@Table(name="Person")
public class PersonJpaEntity {
    @Id
    @JdbcTypeCode(Types.VARCHAR)
    public UUID uuid;
    private String name;
    @Enumerated(EnumType.STRING)
    private Person.Sex sex;
    private int age;

    public PersonJpaEntity(UUID uuid, String name, Person.Sex sex, int age) {
        this.uuid = uuid;
        this.name = name;
        this.sex = sex;
        this.age = age;
    }

    public PersonJpaEntity() {

    }

    public UUID getUuid() {
        return uuid;
    }

    public void setUuid(UUID uuid) {
        this.uuid = uuid;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Person.Sex getSex() {
        return sex;
    }

    public void setSex(Person.Sex sex) {
        this.sex = sex;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }
}
