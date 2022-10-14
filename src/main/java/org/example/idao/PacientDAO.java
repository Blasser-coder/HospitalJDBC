package org.example.idao;

import org.example.models.Doctor;

import java.sql.SQLException;
import java.util.List;

public interface PacientDAO {
    public int addPacient(Doctor emp) throws SQLException;
    public void deletePacient(int id) throws SQLException;
    public Doctor getPacient(int id);
    public List<Doctor> getAllPacients();
    public void updatePacient(Doctor emp) throws SQLException;
}
