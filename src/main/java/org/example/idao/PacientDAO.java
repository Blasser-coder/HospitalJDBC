package org.example.idao;

import org.example.models.Doctor;
import org.example.models.Pacient;

import java.sql.SQLException;
import java.util.List;

public interface PacientDAO {
    public int addPacient(Pacient emp) throws SQLException;
    public void deletePacient(int id) throws SQLException;
    public Pacient getPacient(int id);
    public List<Pacient> getAllPacients();
    public void updatePacient(Pacient emp) throws SQLException;
}
