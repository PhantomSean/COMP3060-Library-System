package ie.mcwebdeveloper.project.models;

import javax.persistence.*;

@Entity
@Table(name="Books")
public class Book {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private long id;

    private String title;
    private String author;
    private boolean available;
    private boolean reserved;
    private long userID;

    protected Book() {};

    public Book(String title, String author, boolean available, boolean reserved) {
        this.title = title;
        this.author = author;
        this.available = available;
        this.reserved = reserved;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

//    public Library getLibrary() {
//        return library;
//    }
//    public void setLibrary(Library library) {
//        this.library = library;
//    }

    public String getTitle() {
        return title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }
    public void setAuthor(String author) {
        this.author = author;
    }

    public boolean getAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean getReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }
}
