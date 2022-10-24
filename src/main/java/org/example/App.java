package org.example;

import org.example.Repositories.PatientRepositoriesImp;
import org.example.dao.DoctorDAOimp;
import org.example.dao.PacientDAOimp;
import org.example.idao.PacientDAO;
import org.example.models.Doctor;
import org.example.models.Pacient;

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
        List<Pacient> pp = new ArrayList<Pacient>();
        DoctorDAOimp d = new DoctorDAOimp();
        PacientDAOimp p = new PacientDAOimp();
        PatientRepositoriesImp PRI = new PatientRepositoriesImp();
        Doctor d1 = new Doctor();
        Pacient p1 = new Pacient(7, "Pepe", "Martinez", "12345678L", 23, "234567890", "Le duele el culo");
        d1 = d.getDoctorByPatientId(7);
        System.out.println(d1.toString());

        Pacient p11 = PRI.GetPatient(p1.getId());
        System.out.println(p11.toString());


        /*Doctor dp = new Doctor();
        Pacient pd = new Pacient();
        System.out.println("---------------------------------------------------------");
        d.addDoctor(d1);
        p.addPacient(p1);
        System.out.println("---------------------------------------------------------");
       dd = d.getAllDoctors();
       pp = p.getAllPacients();
       listDeList(dd);
       listDeList(pp);
        System.out.println("---------------------------------------------------------");
        dp = d.getDoctor(28);
        pd = p.getPacient(9);
        System.out.println(dp.toString());
        System.out.println(pd.toString());
        System.out.println("---------------------------------------------------------");
        d.deleteDoctor(29);
        p.deletePacient(10);
        dp = d.getDoctor(29);
        pd = p.getPacient(10);
        System.out.println(dp.toString());
        System.out.println(pd.toString());
        System.out.println("---------------------------------------------------------");
        d1 = new Doctor(26, "Paco1", "Fiestas", "12345678J", "Dermatologia", 2000.0);
        p1 = new Pacient(6, "Pepe2", "Martinez", "12345678L", 23, "234567890", "Le duele el culo");
        d.updateDoctor(d1);
        p.updatePacient(p1);
        dd = d.getAllDoctors();
        pp = p.getAllPacients();
        listDeList(dd);
        listDeList(pp);
        System.out.println("---------------------------------------------------------");




    }


    private static void listDeList(List E){
        for (int i = 0; i < E.size(); i++) {
            System.out.println(E.get(i).toString());
        }
    }*/
    }
}
