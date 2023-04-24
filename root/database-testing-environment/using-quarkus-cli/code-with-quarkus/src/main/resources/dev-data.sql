-- Create the 'employee' schema
CREATE SCHEMA employee;

-- Create the 'employee' table
CREATE TABLE employee (
    PFNo UUID NOT NULL PRIMARY KEY,
    NationalID VARCHAR(50) NOT NULL UNIQUE,
    KRApin VARCHAR(50) NOT NULL UNIQUE,
    birthDate DATE NOT NULL
);

-- Create the 'employeeProfile' table
CREATE TABLE employeeProfile (
    empProfileID SERIAL PRIMARY KEY,
    firstName VARCHAR(100) NOT NULL,
    lastName VARCHAR(100) NOT NULL,
    emailAddress VARCHAR(100)
);

-- Add a foreign key to enforce the one-to-one relationship between the tables
ALTER TABLE employeeProfile
ADD CONSTRAINT fk_employeeProfile_emp
FOREIGN KEY (empProfileID)
REFERENCES employee (PFNo);

-- Add a unique constraint to ensure one-to-one mapping
ALTER TABLE employeeProfile
ADD CONSTRAINT uq_employeeProfile_emp UNIQUE (empProfileID);
