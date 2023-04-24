package org.acme;

public interface EmployeeCreateService {
    Employee create(String nationalID, String KRApin, LocalDate birthDate, String firstName, String lastName, String emailAddress);
}
