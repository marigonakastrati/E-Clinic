/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

/**
 *
 * @author F
 * REGEX
 */
public class UserValidation 
{
    
    public String validateUser(String user)
    {
        String msg = null;
        if(user.trim().isEmpty())
        {
            msg = "The user is empty";
        }
        else if (user.equals("Some criteria"))
        {
            // msg = You have typed some wrong text
        }
        else
        {
            msg = "Validated";
        }
        
        return msg;
    }
}
