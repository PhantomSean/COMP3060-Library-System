package ie.mcwebdeveloper.project.models;

import javax.persistence.*;

@Entity
@Table(name="Catalogue")
public class Catalogue {
    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)

    private long library_id;

    protected Catalogue() {};

    public Catalogue(long library_id) {
        this.library_id = library_id;
    }

    public long getId() {
        return library_id;
    }
    public void setId(long library_id) {
        this.library_id = library_id;
    }
}
