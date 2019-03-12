package entity;

import javax.persistence.*;

@Entity
@Table(name = "department")
public class Department {

    public Department() {}

    public Department(String name, boolean status) {
        this.name = name;
        this.status = status;
    }

    @Id
    @GeneratedValue(generator = "increment")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status")
    private boolean status;

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }
}
