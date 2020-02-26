package ie.mcwebdeveloper.project.models;

import javax.persistence.*;

@Entity
@Table(name="Members")
public class Member {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long id;
    private String first_name;
    private String surname;
    private String email;
    private String password;

    protected Member() {};

    public Member(String first_name, String surname, String email, String password) {
        this.first_name = first_name;
        this.surname = surname;
        this.email = email;
        this.password = password;
    }

    // Getter and Setter for Id
    public long getId() {
        return id;
    }
    public void setId(long id) {
        this.id = id;
    }
    // Getter and Setter for First Name
    public String getFirstName() {
        return first_name;
    }
    public void setFirstName(String first_name) {
        this.first_name = first_name;
    }
    // Getter and Setter for Surname
    public String getSurname() {
        return surname;
    }
    public void setSurame(String surname) {
        this.surname = surname;
    }
    // Getter and Setter for Email
    public String getName() {
        return email;
    }
    public void setName(String email) {
        this.email = email;
    }
    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }
}