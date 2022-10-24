package org.example.IRepositories;

import org.example.models.Pacient;

public interface PatientRepository {
    Pacient GetPatient(int ID);
}
