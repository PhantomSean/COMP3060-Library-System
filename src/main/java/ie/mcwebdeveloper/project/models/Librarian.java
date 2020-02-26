package ie.mcwebdeveloper.project.models;

import javax.persistence.*;

@Entity
@Table(name="Librarians")
public class Librarian {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;
    private String name;

    private String password;

//    @ManyToOne
//    @JoinColumn(name = "library_id")
//    private Library library; // Foreign key referencing what library they are employed by

    protected Librarian() {};

    public Librarian(String name, String password/*, Library library*/) {
        this.name = name;
        this.password = password;
//        this.library = library;
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
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
    // Getter and Setter for Library Id
//    public Library getLibrary() {
//        return library;
//    }
//    public void setLibrary(Library library) {
//        this.library = library;
//    }
}