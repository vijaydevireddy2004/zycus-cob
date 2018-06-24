package com.zycus.cob.ws.mock;

import com.zycus.cob.entities.Customer;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

@Path("/tenants")
public class TenantService {

    public TenantService(){
    }
    
    @GET
    @Path("/{id}/confog")
    @Produces(MediaType.APPLICATION_JSON)
    public Customer create(Customer newCustomer) {
        return newCustomer;
    }

}
