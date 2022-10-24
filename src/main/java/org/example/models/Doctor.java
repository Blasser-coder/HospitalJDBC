package org.example.models;

import java.util.List;

public class Doctor {
    private int ID;
    private String Name, LastName, dni, speciality;
    private double Salary;

    private List<Pacient> Patients;

    public Doctor() {
    }

    public Doctor(int ID, String name, String lastName, String dni, String speciality, double salary) {
        this.ID = ID;
        Name = name;
        LastName = lastName;
        this.dni = dni;
        this.speciality = speciality;
        Salary = salary;
    }

    public int getID() {
        return ID;
    }

    public void setID(int ID) {
        this.ID = ID;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public double getSalary() {
        return Salary;
    }

    public void setSalary(double salary) {
        Salary = salary;
    }


    @Override
    public String toString() {
        return "Doctor{" +
                "ID=" + ID +
                ", Name='" + Name + '\'' +
                ", LastName='" + LastName + '\'' +
                ", dni='" + dni + '\'' +
                ", speciality='" + speciality + '\'' +
                ", Salary=" + Salary +
                ", Patients=" + Patients +
                '}';
    }
}
