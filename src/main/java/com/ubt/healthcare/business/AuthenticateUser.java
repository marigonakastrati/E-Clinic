/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Patient;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.PharmacyManager;

/**
 *
 * @author F
 */
public class AuthenticateUser {

    //Inject
    private SQLRepository sqlRepository = new SQLRepository();
    private PasswordHashing hashing = new PasswordHashing();

    private Object authenticate(String user, String entity, String attribute) 
    {
        Object ob = sqlRepository.findById(Integer.parseInt(user), entity, attribute);

        return ob != null ? ob : null;
    }

    public AdminClinic authenticateAdminClinic(String user, String password) 
    {
        final String AdminClinicFindById = "AdminClinic.findByAdminClinicId";
        final String ATTRIBUTE = "adminClinicId";
        AdminClinic adminClinic = (AdminClinic) authenticate(user, AdminClinicFindById, ATTRIBUTE);
        if (adminClinic.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return adminClinic;
        }

        return null;
    }

    public Doctor authenticateDoctor(String user, String password) 
    {
        final String AdminClinicFindById = "Doctor.findByDoctorId";
        final String ATTRIBUTE = "doctorId";
        Doctor doctor = (Doctor) authenticate(user, AdminClinicFindById, ATTRIBUTE);
        if (doctor.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return doctor;
        }

        return null;
    }

    public Patient authenticatePatient(String user, String password) 
    {
        final String AdminClinicFindById = "Patient.findByPatientId";
        final String ATTRIBUTE = "patientId";
        Patient patient = (Patient) authenticate(user, AdminClinicFindById, ATTRIBUTE);
        if (patient.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return patient;
        }

        return null;
    }

    public Pharmacist authenticatePharmacist(String user, String password) 
    {
        final String AdminClinicFindById = "Pharmacist.findByPharmacistId";
        final String ATTRIBUTE = "pharmacistId";
        Pharmacist pharmacist = (Pharmacist) authenticate(user, AdminClinicFindById, ATTRIBUTE);
        if (pharmacist.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return pharmacist;
        }

        return null;
    }

    public PharmacyManager authenticatePharmacyManager(String user, String password) 
    {
        final String AdminClinicFindById = "PharmacyManager.findByPharmacyManagerId";
        final String ATTRIBUTE = "pharmacyManagerId";
        PharmacyManager pharmacyManager = (PharmacyManager) authenticate(user, AdminClinicFindById, ATTRIBUTE);
        if (pharmacyManager.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return pharmacyManager;
        }

        return null;
    }
}
