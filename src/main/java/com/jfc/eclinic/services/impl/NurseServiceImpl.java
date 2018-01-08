/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.services.impl;

import com.jfc.eclinic.dao.NurseRepository;
import com.jfc.eclinic.dto.Nurse;
import com.jfc.eclinic.services.NurseService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author mk
 */
@Stateless
public class NurseServiceImpl implements NurseService {

    private NurseRepository nurseRepository;

    @Inject
    public NurseServiceImpl(NurseRepository nurseRepository) {
        this.nurseRepository = nurseRepository;
    }

    public NurseServiceImpl() {
    }

    @Override
    public List<Nurse> get() throws Exception {
        return nurseRepository.findAll();
    }

    @Override
    public Nurse get(int id) throws Exception {
        return nurseRepository.findById(id);
    }

    @Override
    public void update(Nurse value) throws Exception {
        nurseRepository.update(value);
    }

    @Override
    public void create(Nurse value) throws Exception {
        nurseRepository.add(value);
    }

    @Override
    public void delete(Nurse id) throws Exception {
        nurseRepository.remove(id);
    }

    @Override
    public void updateName(Nurse value) throws Exception {
        //TODO
    }

    public void updatePassword(Nurse value) throws Exception{
        //TODO
    }
    
}
