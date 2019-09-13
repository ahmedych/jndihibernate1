package kz.hiber.model;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "employee", uniqueConstraints = {@UniqueConstraint(columnNames = {"ID"})})
public class Employee {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id", nullable = false, unique = true,length = 11)
    private int id;
    @Column(name = "name", length = 20, nullable = true)
    private String name;
    @Column(name = "role", length = 20, nullable = true)
    private String role;
    @Column(name = "insert_time", nullable = true)
    private Date insertTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public Date getInsertTime() {
        return insertTime;
    }

    public void setInsertTime(Date insertTime) {
        this.insertTime = insertTime;
    }
}
