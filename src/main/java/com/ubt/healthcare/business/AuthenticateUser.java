/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.ui.util.PasswordHashing;
import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.AdminClinic;
import com.ubt.healthcare.dto.Doctor;
import com.ubt.healthcare.dto.HRManager;
import com.ubt.healthcare.dto.Nurse;
import com.ubt.healthcare.dto.Patient;
import com.ubt.healthcare.dto.Pharmacist;
import com.ubt.healthcare.dto.PharmacyManager;

/**
 *
 * @author F
 */
public class AuthenticateUser {

    private SQLRepository sqlRepository = new SQLRepository();
    private PasswordHashing hashing = new PasswordHashing();

    private Object authenticate(String user, String entity, String attribute) throws Exception
    {
        Object ob = sqlRepository.findById(Integer.parseInt(user), entity, attribute);

        return ob != null ? ob : null;
    }

    public AdminClinic authenticateAdminClinic(String user, String password) throws Exception
    {
        AdminClinic adminClinic = (AdminClinic) authenticate(user, "AdminClinic.findByAdminClinicId", "adminClinicId");
        if (adminClinic.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return adminClinic;
        }

        return null;
    }

    public Doctor authenticateDoctor(String user, String password) throws Exception
    {
        Doctor doctor = (Doctor) authenticate(user, "Doctor.findByDoctorId", "doctorId");
        if (doctor.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return doctor;
        }

        return null;
    }

    public Patient authenticatePatient(String user, String password) throws Exception
    {
        Patient patient = (Patient) authenticate(user, "Patient.findByPatientId", "patientId");
        if (patient.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return patient;
        }

        return null;
    }

    public Pharmacist authenticatePharmacist(String user, String password) throws Exception
    {
        Pharmacist pharmacist = (Pharmacist) authenticate(user, "Pharmacist.findByPharmacistId", "pharmacistId");
        if (pharmacist.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return pharmacist;
        }

        return null;
    }

    public PharmacyManager authenticatePharmacyManager(String user, String password) throws Exception
    {
        PharmacyManager pharmacyManager = (PharmacyManager) authenticate(user, "PharmacyManager.findByPharmacyManagerId", "pharmacyManagerId");
        if (pharmacyManager.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return pharmacyManager;
        }

        return null;
    }
    
    public Nurse authenticateNurse(String user, String password) throws Exception
    {
        Nurse nurse = (Nurse) authenticate(user, "Nurse.findByNurseId", "nurseId");
        if (nurse.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return nurse;
        }

        return null;
    }
    
    
    public HRManager authenticateHRManager(String user, String password) throws Exception
    {
        HRManager hrManager = (HRManager) authenticate(user, "HRManager.findByManagerId", "findByManagerId");
        if (hrManager.getPassCode().equals(hashing.encodehashPassword(password))) 
        {
            return hrManager;
        }

        return null;
    }
}
