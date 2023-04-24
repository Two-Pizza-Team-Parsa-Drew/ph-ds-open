package org.acme;

import jakarta.enterprise.context.ApplicationScoped;

import java.sql.Date;
import java.util.List;

import io.quarkus.hibernate.orm.panache.PanacheRepository;

@ApplicationScoped
public class EmployeeRepository implements PanacheRepository<Employee> {

    public List<Employee> findByNationalID(String nationalID) {
        return list("nationalID", nationalID);
    }

    public List<Employee> findByBirthDate(Date birthDate) {
        return list("birthDate", birthDate);
    }

    // Define more convininet methods here if needed
}
