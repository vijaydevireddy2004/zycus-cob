package com.zycus.cob.mock;

import com.zycus.cob.entities.Customer;
import com.zycus.cob.vo.Result;
import java.util.ArrayList;
import java.util.List;

public class CustomerOperations {
    
    public Result createCustomer(Customer c){
        if(c.getId().equalsIgnoreCase("1")){
            return new Result("1","Customer first name can not be empty","first name");
        }else if(c.getId().equalsIgnoreCase("2")){
            return new Result("2","Customer mobile can not be empty","mobile");
        }else if(c.getId().equalsIgnoreCase("3")){
            return new Result("3","Customer date of birth is invalid","dob");
        }else if(c.getId().equalsIgnoreCase("4")){
            return new Result("0","success","first name");
        }else{
            return new Result("4","Invalid customer details","first name");
        }
    }

    public List<Result> upload(){
        List<Result> errors = new ArrayList<Result>();
        // process Excel Handler
        return null;
        
    }
}
