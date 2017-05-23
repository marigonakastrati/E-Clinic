/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.dto.PersonArchive;

/**
 *
 * @author F
 */
public class PersonArchiveService {

    private SQLRepository sqlRepository;


    public PersonArchiveService() {
        sqlRepository = new SQLRepository();
    }

    public void persistPersonArchive(PersonArchive personArchive) {

        sqlRepository.add(personArchive);

        
    }

}
