package ie.mcwebdeveloper.project.models;

import javax.persistence.*;
import java.util.Date;

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
    private long userId;
    private long reservedId;
    private Date dueDate;

    protected Book() {};

    public Book(String title, String author, boolean available, boolean reserved, long userId, long reservedId, Date dueDate) {
        this.title = title;
        this.author = author;
        this.available = available;
        this.reserved = reserved;
        this.userId = userId;
        this.reservedId = reservedId;
        this.dueDate = dueDate;
    }

    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }

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

    public boolean isAvailable() {
        return available;
    }
    public void setAvailable(boolean available) {
        this.available = available;
    }

    public boolean isReserved() {
        return reserved;
    }
    public void setReserved(boolean reserved) {
        this.reserved = reserved;
    }

    public long getUserID() {
        return userId;
    }
    public void setUserID(long userID) {
        this.userId = userID;
    }

    public long getReservedID() {
        return reservedId;
    }
    public void setReservedID(long reservedID) {
        this.reservedId = reservedID;
    }

    public Date getDueDate() {
        return dueDate;
    }
    public void setDueDate(Date dueDate) {
        this.dueDate = dueDate;
    }
}
