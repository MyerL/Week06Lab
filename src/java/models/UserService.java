/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package models;

/**
 *
 * @author 738409
 */
public class UserService 
{
    public static User login(User myer)
    {
        
        if((myer.getUsername().equalsIgnoreCase("adam")||myer.getUsername().equalsIgnoreCase("betty")) && myer.getPassword().equalsIgnoreCase("password"))
        {
                return myer;
        }
        else
        {
                return null;
        }
        
    }
    
}
