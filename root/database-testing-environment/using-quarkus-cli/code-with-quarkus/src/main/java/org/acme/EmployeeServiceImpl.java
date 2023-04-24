package org.acme;

import jakarta.inject.Inject;
import jakarta.transaction.Transactional;

import java.time.LocalDate;

import jakarta.enterprise.context.ApplicationScoped;

@ApplicationScoped
public class EmployeeServiceImpl implements EmployeeCreateService {

    @Inject
    EmployeeRepository employeeRepository;

    @Transactional
    @Override
    public Employee create(String nationalID, String KRApin, LocalDate birthDate,
            String firstName, String lastName, String emailAddress) {
        
        // create a new employee object and set its attributes
        Employee employee = new Employee();
        employee.setNationalID(nationalID);
        employee.setKRApin(KRApin);
        employee.setBirthDate(birthDate);
        
        // create a new employee profile object and set its attributes
        EmployeeProfile employeeProfile = new EmployeeProfile();
        employeeProfile.setFirstName(firstName);
        employeeProfile.setLastName(lastName);
        employeeProfile.setEmailAddress(emailAddress);
        
        // persist the employee and employee profile to the database
        employeeRepository.persist(employee);
        return employee;
    }
}
