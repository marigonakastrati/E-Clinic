/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

import com.ubt.healthcare.dao.SQLRepository;
import com.ubt.healthcare.entity.AdminClinic;
import com.ubt.healthcare.entity.Person;

/*import org.ubt.kiosk.dal.StudentRepository;
import org.ubt.kiosk.entity.Student;
*/

/**
 *
 * @author F
 */
public class AuthenticateUser {
    //Inject
    private SQLRepository sqlRepository = new SQLRepository();
    private PasswordHashing hashing = new PasswordHashing();
    
    public Object authenticate(String user, String password) 
    {
        AdminClinic adminClinic =null;
        adminClinic =(AdminClinic)sqlRepository.findById(Integer.parseInt(user));// typecast based on its type
        
        if (adminClinic != null && hashing.encodehashPassword(password).equals(adminClinic.getPassCode())) 
        {
            return adminClinic;
        }
        return null;
    }
}
