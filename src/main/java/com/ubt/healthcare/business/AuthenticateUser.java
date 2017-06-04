/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.Nurse;
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
        final String adminClinicid = "adminClinicId";
        AdminClinic adminClinic = (AdminClinic) authenticate(user, AdminClinicFindById, adminClinicid);
        if (adminClinic.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return adminClinic;
        }

        return null;
    }

    public Doctor authenticateDoctor(String user, String password) 
    {
        final String DoctorFindById = "Doctor.findByDoctorId";
        final String doctorID = "doctorId";
        Doctor doctor = (Doctor) authenticate(user, DoctorFindById, doctorID);
        if (doctor.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return doctor;
        }

        return null;
    }

    public Patient authenticatePatient(String user, String password) 
    {
        final String PatientFindById = "Patient.findByPatientId";
        final String patientId = "patientId";
        Patient patient = (Patient) authenticate(user, PatientFindById, patientId);
        if (patient.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return patient;
        }

        return null;
    }

    public Pharmacist authenticatePharmacist(String user, String password) 
    {
        final String PharmacistFindById = "Pharmacist.findByPharmacistId";
        final String pharmacistId = "pharmacistId";
        Pharmacist pharmacist = (Pharmacist) authenticate(user, PharmacistFindById, pharmacistId);
        if (pharmacist.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return pharmacist;
        }

        return null;
    }

    public PharmacyManager authenticatePharmacyManager(String user, String password) 
    {
        final String PharmacyManagerFindById = "PharmacyManager.findByPharmacyManagerId";
        final String pharmacyManagerId = "pharmacyManagerId";
        PharmacyManager pharmacyManager = (PharmacyManager) authenticate(user, PharmacyManagerFindById, pharmacyManagerId);
        if (pharmacyManager.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return pharmacyManager;
        }

        return null;
    }
    
    public Nurse authenticateNurse(String user, String password) 
    {
        final String NurseFindById = "Nurse.findByNurseId";
        final String nurseId = "nurseId";
        Nurse nurse = (Nurse) authenticate(user, NurseFindById, nurseId);
        if (nurse.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return nurse;
        }

        return null;
    }
}
