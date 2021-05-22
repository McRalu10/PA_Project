package server.models;

import javax.persistence.*;
import java.util.*;

@Entity
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(columnDefinition = "BINARY(16)")
    private UUID personID;
    private String name;
    private Date creationDate;


    public UUID getPersonID() {
        return personID;
    }

    public void setPersonID(UUID personID) {
        this.personID = personID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }
}
