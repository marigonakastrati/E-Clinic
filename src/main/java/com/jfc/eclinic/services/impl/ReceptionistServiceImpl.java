/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package main.java.com.jfc.eclinic.services.impl;

import com.jfc.eclinic.dao.ReceptionistRepository;
import com.jfc.eclinic.dto.Receptionist;
import com.jfc.eclinic.services.ReceptionistService;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author mk
 */
@Stateless
public class ReceptionistServiceImpl implements ReceptionistService {

    private ReceptionistRepository receptionistRepository;

    @Inject
    public ReceptionistServiceImpl(ReceptionistRepository receptionistRepository) {
        this.receptionistRepository = receptionistRepository;
    }

    public ReceptionistServiceImpl() {
    }

    @Override
    public List<Receptionist> get() throws Exception {
        return receptionistRepository.findAll();
    }

    @Override
    public Receptionist get(int id) throws Exception {
        return receptionistRepository.findById(id);
    }

    @Override
    public void update(Receptionist value) throws Exception {
        receptionistRepository.update(value);
    }

    @Override
    public void create(Receptionist value) throws Exception {
        receptionistRepository.add(value);
    }

    @Override
    public void delete(Receptionist id) throws Exception {
        receptionistRepository.remove(id);
    }

}
