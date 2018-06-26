package com.zycus.cob.ws.mock;

import com.zycus.cob.entities.Customer;
import com.zycus.cob.mock.CustomerOperations;
import com.zycus.cob.mock.CustomerUploadHandler;
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

@Path("/customers")
public class CustomerService {
    @Context ServletContext context;
    
    public CustomerService(){
    }
    
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
            List<com.zycus.cob.vo.Error> errors = cuh.upload(uploadPath+fileDetail.getFileName());
            for(com.zycus.cob.vo.Error e: errors){
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
    public com.zycus.cob.vo.Error create(Customer newCustomer) {
        CustomerOperations co = new CustomerOperations();
        com.zycus.cob.vo.Error e = co.createCustomer(newCustomer);
        System.out.println(e);
        System.out.println(e.getError());
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
