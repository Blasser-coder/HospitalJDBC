package org.example;

import org.example.dao.DoctorDAOimp;
import org.example.models.Doctor;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        List<Doctor> dd = new ArrayList<Doctor>();
        DoctorDAOimp d = new DoctorDAOimp();
        Doctor d1 = new Doctor();
        d1 = d.getDoctor(1);
        System.out.println(d1.toString());
        d.deleteDoctor(6);
        dd = d.getAllDoctors();
        for (int i = 0; i < dd.size(); i++) {
            Doctor dp = new Doctor();
            dp = dd.get(i);
            System.out.println(dp.toString());
        }
        Doctor d2 = new Doctor(10, "pac2o312423qqwqwqwqwqwswwwwww4", "fiestas", "12345678h", "2", 1);
        System.out.println(d.addDoctor(d2));


        Doctor d3 = new Doctor();
        d3 = d.getDoctor(13);
        d3.setName("pepepito");
        d.updateDoctor(d3);

        d.getAllDoctors();

    }
}
