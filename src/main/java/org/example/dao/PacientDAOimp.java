package org.example.dao;

import org.example.idao.PacientDAO;
import org.example.models.Doctor;
import org.example.models.Pacient;
import org.example.utils.DatabaseConnection;

import java.io.IOException;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PacientDAOimp implements PacientDAO {
    private Connection connection = DatabaseConnection.GetConnection();
    PreparedStatement ps;

    @Override
    public int addPacient(Pacient emp) throws SQLException {
        int QueryEx;
        try{
            String query = "INSERT INTO Patients (Name, LastName, DNI, Phone, Age, Disease) VALUES (?,?,?,?,?,?)";
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getLastname());
            ps.setString(3, emp.getDni());
            ps.setString(4, emp.getPhone());
            ps.setInt(5, emp.getAge());
            ps.setString(6, emp.getDisease());
           QueryEx = ps.executeUpdate();
            connection.commit();
        }catch(SQLException exception){
            connection.rollback();
            exception.printStackTrace();
            QueryEx = ps.executeUpdate();
        }
        ps.close();
        return QueryEx;
    }

    @Override
    public void deletePacient(int id) throws SQLException {
        try {
            String query = "DELETE FROM Patients WHERE ID = ?";
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
            System.out.println("Registro Borrado ID(" + id + ")");
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            System.out.println("No se ha podido borrar el registro");
        }
    }

    @Override
    public Pacient getPacient(int id) {
        Pacient p = new Pacient();
        Boolean check = false;
        try {
            String query = "SELECT * FROM Patients WHERE ID = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()){
                p.setDni(rs.getString(4));
                p.setAge(rs.getInt(6));
                p.setName(rs.getString(2));
                p.setLastname(rs.getString(3));
                p.setId(rs.getInt(1));
                p.setPhone(rs.getString(5));
                p.setDisease(rs.getString(7));
            }
            check = true;
        } catch (SQLException e){
            e.printStackTrace();
        }

        if (check){
            return p;
        }else{
            return null;
        }
    }

    @Override
    public List<Pacient> getAllPacients() {
        List<Pacient> pacients = new ArrayList<Pacient>();
        Boolean check = false;
        try {
            String query = "SELECT * FROM Patients";
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery(query);
            while (rs.next()){
                Pacient p = new Pacient();
                p.setDni(rs.getString(4));
                p.setAge(rs.getInt(6));
                p.setName(rs.getString(2));
                p.setLastname(rs.getString(3));
                p.setId(rs.getInt(1));
                p.setPhone(rs.getString(5));
                p.setDisease(rs.getString(7));
                pacients.add(p);
            }
            check = true;
        } catch (SQLException e){
            e.printStackTrace();
        }
        if (check){
            return pacients;
        }else{
            return null;
        }

    }

    @Override
    public void updatePacient(Pacient emp) throws SQLException {
        String query = "UPDATE Patients SET Name = ?, lastName = ?, DNI = ?, Phone = ?, Age = ?, Disease = ?" +
                " WHERE ID = ?";
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            ps.setInt( 7 , emp.getId());
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getLastname());
            ps.setString(3, emp.getDni());
            ps.setString(4, emp.getPhone());
            ps.setInt(5, emp.getAge());
            ps.setString(6, emp.getDisease());
            ps.executeUpdate();
            connection.commit();
            System.out.println("Registro acualizado");
        } catch (SQLException e){
            e.printStackTrace();
            System.out.println("NO se ha podido actualizar el registro");
            connection.rollback();
        }
    }
}
