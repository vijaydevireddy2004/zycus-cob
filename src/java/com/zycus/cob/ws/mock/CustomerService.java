package com.zycus.cob.ws.mock;

import com.zycus.cob.entities.Customer;
import java.util.List;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/customers")
public class CustomerService {

    
    public CustomerService(){
    }
    
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public List<Customer> upload() {
        return null;
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer create(Customer newCustomer) {
        return newCustomer;
    }

}
