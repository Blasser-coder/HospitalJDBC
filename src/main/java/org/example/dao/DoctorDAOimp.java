package org.example.dao;

import org.example.idao.DoctorDAO;
import org.example.models.Doctor;
import org.example.utils.DatabaseConnection;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class DoctorDAOimp implements DoctorDAO {
    private Connection connection = DatabaseConnection.GetConnection();
    PreparedStatement ps = null;

    @Override
    public int addDoctor(Doctor emp) throws SQLException {
        int queryEx;
        String query = "INSERT INTO Doctor (Name, lastName, DNI, Speciality, Salary) VALUES (?, ?, ?, ? ,?)";
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getDni());
            ps.setString(4, emp.getSpeciality());
            ps.setDouble(5, emp.getSalary());
            queryEx = ps.executeUpdate();
            connection.commit();
        } catch (SQLException e){
            e.printStackTrace();
            connection.rollback();
            queryEx = ps.executeUpdate();
        }
        return queryEx;
    }

    @Override
    public void deleteDoctor(int id) throws SQLException {
        try{
            String query = "DELETE FROM Doctor WHERE ID = ?";
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ps.executeUpdate();
            connection.commit();
            System.out.println("Registro Borrado ID(" + id + ")");
        } catch (SQLException e){
            connection.rollback();
            e.printStackTrace();
        }
    }

    @Override
    public Doctor getDoctor(int id) {
        Boolean check = false;
        Doctor d = new Doctor();
        try {
            String query = "SELECT * FROM Doctor WHERE ID = ?";
            ps = connection.prepareStatement(query);
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();

            while(rs.next()) {
                d.setID(rs.getInt("ID"));
                d.setDni(rs.getString("DNI"));
                d.setName(rs.getString("Name"));
                d.setLastName(rs.getString("LastName"));
                d.setSalary(rs.getFloat("Salary"));
                d.setSpeciality(rs.getString("Speciality"));
            }
            check = true;
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        if (check == true){
            return d;
        }else{
            return null;
        }
    }

    @Override
    public List<Doctor> getAllDoctors(){
        List<Doctor> doctors = new ArrayList<Doctor>();
        String query = "SELECT * FROM Doctor";
        try {
            ps = connection.prepareStatement(query);
            ResultSet rs = ps.executeQuery();
            while(rs.next()) {
                Doctor d = new Doctor();
                d.setID(rs.getInt("ID"));
                d.setName(rs.getString("Name"));
                d.setLastName(rs.getString("LastName"));
                d.setDni(rs.getString("DNI"));
                d.setSalary(rs.getFloat("Salary"));
                d.setSpeciality(rs.getString("Speciality"));
                doctors.add(d);
            }
            rs.close();
        } catch (SQLException e){
            e.printStackTrace();
        }
        return doctors;
    }

    @Override
    public void updateDoctor(Doctor emp) throws SQLException {
        String query = "UPDATE Doctor SET Name = ?, lastName = ?, DNI = ?, Speciality = ?, Salary = ?" +
                " WHERE ID = ?";
        try {
            connection.setAutoCommit(false);
            ps = connection.prepareStatement(query);
            ps.setInt( 6 , emp.getID());
            ps.setString(1, emp.getName());
            ps.setString(2, emp.getLastName());
            ps.setString(3, emp.getDni());
            ps.setString(4, emp.getSpeciality());
            ps.setDouble(5, emp.getSalary());
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
