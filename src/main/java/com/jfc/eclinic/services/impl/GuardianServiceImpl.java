/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.jfc.eclinic.services.impl;

import com.jfc.eclinic.dao.GuardianRepository;
import com.jfc.eclinic.dao.exception.RepositoryException;
import com.jfc.eclinic.dto.Guardian;
import com.jfc.eclinic.services.GuardianService;
import com.jfc.eclinic.services.exception.PasswordException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;
import javax.ejb.Stateless;
import javax.inject.Inject;
import javax.xml.bind.DatatypeConverter;

/**
 *
 * @author mk
 */
@Stateless
public class GuardianServiceImpl implements GuardianService {

    private GuardianRepository guardianRepository;

    @Inject
    public GuardianServiceImpl(GuardianRepository guardianRepository) {
        this.guardianRepository = guardianRepository;
    }

    public GuardianServiceImpl() {
    }

    @Override
    public List<Guardian> get() throws Exception {
        return guardianRepository.findAll();
    }

    @Override
    public Guardian get(int id) throws Exception {
        return guardianRepository.findById(id);
    }

    @Override
    public void update(Guardian value) throws Exception {
        guardianRepository.update(value);
    }

    @Override
    public void create(Guardian value) throws Exception {
        guardianRepository.add(value);
    }

    @Override
    public void delete(Guardian id) throws Exception {
        guardianRepository.remove(id);
    }

    @Override
    public void updateName(Guardian value) throws Exception {
        //TODO
    }

    @Override
    public void updatePassword(Guardian value) throws PasswordException, RepositoryException, NoSuchAlgorithmException {
        //TODO
    }

    private String encodehashPassword(String password) throws NoSuchAlgorithmException {
        MessageDigest md = MessageDigest.getInstance("MD5");// SHA-512m SHA-256
        byte[] message = password.getBytes();
        md.update(message);
        byte[] digestbyte = md.digest();
        password = DatatypeConverter.printHexBinary(digestbyte).toLowerCase();

        return password;
    }

}
