package ie.mcwebdeveloper.project.models;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name="Libraries")
public class Library {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String l_name;
    private String location;

    @OneToMany(mappedBy = "Library", cascade = CascadeType.ALL)
    private Set<Book> books;
    @OneToMany(mappedBy = "Library", cascade = CascadeType.ALL)
    private Set<Librarian> librarians;

    protected Library() {};

    public Library(String name, String location) {
        this.l_name = name;
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
        return l_name;
    }
    public void setName(String name) {
        this.l_name = name;
    }
    // Getter and Setter for Location
    public String getLocation() {
        return location;
    }
    public void setLocation(String location) {
        this.location = location;
    }
}