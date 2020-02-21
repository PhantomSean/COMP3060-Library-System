package ie.mcwebdeveloper.project.models;

import javax.persistence.Entity;
import javax.persistence.GenerationValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Libraries")
public class Library {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    private String name;
    private String location;

    protected Library() {};

    public Library(String name, String location) {
        this.name = name;
        this.location = location;
    }

    // Getter and Setter for Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    // Getter and Setter for Name
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }
    // Getter and Setter for Location
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}