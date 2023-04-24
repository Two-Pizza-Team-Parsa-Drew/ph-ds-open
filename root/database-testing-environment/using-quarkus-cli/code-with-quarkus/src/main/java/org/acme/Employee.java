package org.acme;

import io.quarkus.hibernate.orm.panache.PanacheEntity;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.UUID;
import jakarta.persistence.Entity;

@Entity
@Table(name = "employee", schema = "employee")
public class Employee extends PanacheEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    public UUID PFNo;

    @Column(name = "nationalID", unique = true)
    public String nationalID;

    @Column(name = "KRApin", unique = true)
    public String KRApin;

    @Column(name = "birthDate")
    public LocalDate birthDate;

    @OneToOne(mappedBy = "employee",cascade = CascadeType.ALL, optional = false)
    @JoinColumn(name = "empProfileID", referencedColumnName = "id")
    public EmployeeProfile empProfile;

    // Default Constructor
    public Employee(){}

    // Constructor with parameters
    public Employee(String nationalID, String KRApin, LocalDate birthDate) {
        this.nationalID = nationalID;
        this.KRApin = KRApin;
        this.birthDate = birthDate;
    }

    // Getters and setter
    public String getNationalID() {
        return nationalID;
    }

    public void setNationalID(String nationalID) {
        this.nationalID = nationalID;
    }

    public String getKRAPin() {
        return KRApin;
    }

    public void setKRApin(String kraPin) {
        this.KRApin = kraPin;
    }

    public LocalDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(LocalDate birthDate) {
        this.birthDate = birthDate;
    }

}
