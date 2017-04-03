/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

/*import org.ubt.kiosk.dal.StudentRepository;
import org.ubt.kiosk.entity.Student;
*/

/**
 *
 * @author F
 */
public class AuthenticateUser {
    //Inject
    //private StudentRepository studentRepository = new StudentRepository();
    private PasswordHashing hashing = new PasswordHashing();
    
    public Object authenticate(String user, String password) 
    {
        Object student =null;
        //student =studentRepository.findById(Integer.parseInt(user));
        
        if (student != null && hashing.encodehashPassword(password).equals(student.getPasscode())) 
        {
            return student;
        }
        return null;
    }
}
