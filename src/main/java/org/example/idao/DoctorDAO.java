package org.example.idao;

import org.example.models.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface DoctorDAO {
    public int addDoctor(Doctor emp) throws SQLException;
    public void deleteDoctor(int id) throws SQLException;
    public Doctor getDoctor(int id);
    public List<Doctor> getAllDoctors();
    public void updateDoctor(Doctor emp) throws SQLException;

}
