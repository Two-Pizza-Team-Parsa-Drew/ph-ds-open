package org.acme;

import jakarta.persistence.*;

@Entity
@Table(name = "employeeProfile")
public class EmployeeProfile {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long empProfileID;

    @Column(name = "firstName", nullable = false)
    private String firstName;

    @Column(name = "lastName", nullable = false)
    private String lastName;

    @Column(name = "emailAddress")
    private String emailAddress;

    @OneToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "empProfileID", nullable = false)
    private Employee employee;

    // Constructors, getters, and setters
    // Default constructor
    public EmployeeProfile() {}

    // Constructor with parameters
    public EmployeeProfile(String firstName, String lastName, String emailAddress) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.emailAddress = emailAddress;
    }
}
