package com.zycus.cob.ws.mock;

import com.zycus.cob.entities.Customer;
import com.zycus.cob.mock.CustomerOperations;
import com.zycus.cob.mock.CustomerUploadHandler;
import com.zycus.cob.vo.Result;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.servlet.ServletContext;
import javax.ws.rs.Consumes;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import org.glassfish.jersey.media.multipart.FormDataContentDisposition;
import org.glassfish.jersey.media.multipart.FormDataParam;

/**
 * CustomerService.java - a mock class for mimic the web service behavior
 * Provides customer web service with upload and create those can be used to  create a new customer or upload multiple customers 
 * To use this service the user needs to be authenticated and get the JWT token
 * The authentication token need to be supplied along with each request after authentication 
 * <p>
 * The tow methods are used to post the customer data to the application  
 * @author  Vijaya Bhaskar D
 * @version 1.0 
 */
@Path("/customers")
public class CustomerService {
    @Context ServletContext context;
    
    public CustomerService(){
    }
    
/**
 * This consumes the uploaded data from the .xlsx file uploaded through the form and creates the data
 * <p>
 * The data needs to be in .xlsx format and each customer data needs to be separated into different sheet.
 * @param  uploadedInputStream  is the stream of the .xlsx file that is uploaded
 * @param  fileDetail the uploaded file details
 * @return String abut the status of upload for each record
  */    
    @POST
    @Path("/upload")
    @Consumes(MediaType.MULTIPART_FORM_DATA)
    public String upload(
        @FormDataParam("custExcelFile") InputStream uploadedInputStream,
	@FormDataParam("custExcelFile") FormDataContentDisposition fileDetail) {
        try {
            System.out.println("enterd");
            System.out.println(fileDetail.getFileName());
            String uploadPath = context.getInitParameter("FILES_UPLOAD_PATH");
            saveFile(uploadedInputStream, uploadPath+fileDetail.getFileName());
            CustomerUploadHandler cuh = new CustomerUploadHandler();
            List<com.zycus.cob.vo.Result> errors = cuh.upload(uploadPath+fileDetail.getFileName());
            for(com.zycus.cob.vo.Result e: errors){
                System.out.println(e.getErrorCode()+", "+e.getError()+", "+e.getField());
            }
            return "done";
        } catch (IOException ex) {
            Logger.getLogger(CustomerService.class.getName()).log(Level.SEVERE, null, ex);
        }
        return "";
    }

    @POST
    @Path("/create")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Result create(Customer newCustomer) {
        CustomerOperations co = new CustomerOperations();
        com.zycus.cob.vo.Result e = co.createCustomer(newCustomer);
        System.out.println("From web service reading error:"+e.getError());
        return e;
    }

    private void saveFile(InputStream inputStream, String dest) throws FileNotFoundException, IOException {
        OutputStream outputStream = new FileOutputStream(new File( dest));
        int read = 0;
        byte[] bytes = new byte[1024];

        outputStream = new FileOutputStream(new File(dest));
        while ((read = inputStream.read(bytes)) != -1) {
                outputStream.write(bytes, 0, read);
        }
        outputStream.flush();
        outputStream.close();
    }
    
}
