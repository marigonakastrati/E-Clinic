/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ubt.healthcare.business;

/**
 *
 * @author F
 */
public class InputValidation 
{
    
    private boolean checkForEmptyString(String str)
    {
        return !str.trim().isEmpty();
    }
    
    public boolean validateInput(String msg)
    {
        return checkForEmptyString(msg);
    }
}
