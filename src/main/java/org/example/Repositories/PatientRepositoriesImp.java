package org.example.Repositories;

import org.example.IRepositories.PatientRepository;
import org.example.dao.DoctorDAOimp;
import org.example.dao.PacientDAOimp;
import org.example.models.Doctor;
import org.example.models.Pacient;

public class PatientRepositoriesImp implements PatientRepository {
    DoctorDAOimp d = new DoctorDAOimp();
    PacientDAOimp p = new PacientDAOimp();

    @Override
    public Pacient GetPatient(int ID) {
        Pacient P = p.getPacient(ID);
        Doctor D = d.getDoctorByPatientId(P.getId());
        P.setDoctor_ID(D);
        return P;
    }
}
