package ie.mcwebdeveloper.project.model;

import javax.persistence.Entity;
import javax.persistence.GenerationValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="Librarians")
public class Librarian {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    private String name;
    private long library_id;

    protected Librarian() {};

    public Librarian(String name, long library_id) {
        this.name = name;
        this.library_id = library_id;
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
    // Getter and Setter for Library Id
    public long getLocation() {
        return library_id;
    }
    public void setLocation(long library_id) {
        this.library_id = library_id;
    }
}