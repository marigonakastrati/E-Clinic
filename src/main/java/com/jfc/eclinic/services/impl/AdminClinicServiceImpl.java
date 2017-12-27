/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.services.impl;

import com.jfc.eclinic.dao.AdminClinicRepository;
import com.jfc.eclinic.dto.Adminclinic;
import com.jfc.eclinic.services.AdminClinicService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author mk
 */
@Stateless
public class AdminClinicServiceImpl implements AdminClinicService {

    private AdminClinicRepository adminClinicRepository;

    @Inject
    public AdminClinicServiceImpl(AdminClinicRepository adminClinicRepository) {
        this.adminClinicRepository = adminClinicRepository;
    }

    public AdminClinicServiceImpl() {
    }

    @Override
    public List<Adminclinic> get() throws Exception {
        return adminClinicRepository.findAll();
    }

    @Override
    public Adminclinic get(int id) throws Exception {
        return adminClinicRepository.findById(id);
    }

    @Override
    public void update(Adminclinic value) throws Exception {
        adminClinicRepository.update(value);
    }

    @Override
    public void create(Adminclinic value) throws Exception {
        adminClinicRepository.add(value);
    }

    @Override
    public void delete(Adminclinic id) throws Exception {
        adminClinicRepository.remove(id);
    }

}
