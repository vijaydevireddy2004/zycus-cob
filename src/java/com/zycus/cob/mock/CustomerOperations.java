package com.zycus.cob.mock;

import com.zycus.cob.entities.Customer;
import com.zycus.cob.vo.Error;
import java.util.ArrayList;
import java.util.List;

public class CustomerOperations {
    
    public Error createCustomer(Customer c){
        if(c.getId().equalsIgnoreCase("1")){
            return new Error("1","Customer first name can not be empty","first name");
        }else if(c.getId().equalsIgnoreCase("2")){
            return new Error("2","Customer mobile can not be empty","mobile");
        }else if(c.getId().equalsIgnoreCase("3")){
            return new Error("3","Customer date of birth is invalid","dob");
        }else if(c.getId().equalsIgnoreCase("4")){
            return new Error("0","success","first name");
        }else{
            return new Error("4","Invalid customer details","first name");
        }
    }

    public List<Error> upload(){
        List<Error> errors = new ArrayList<Error>();
        // process Excel Handler
        return null;
        
    }
}
