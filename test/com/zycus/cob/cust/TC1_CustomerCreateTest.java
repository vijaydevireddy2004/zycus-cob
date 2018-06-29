package com.zycus.cob.cust;

import com.zycus.cob.vo.Result;
import com.zycus.com.entities.Customer;
import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Date;
import javax.ws.rs.client.Client;
import javax.ws.rs.client.ClientBuilder;
import javax.ws.rs.client.Entity;
import javax.ws.rs.client.Invocation;
import javax.ws.rs.client.WebTarget;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;
import org.glassfish.jersey.client.ClientConfig;
import org.glassfish.jersey.filter.LoggingFilter;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

/**
 *
 * @author Vijaya Bhaskar
 */
public class TC1_CustomerCreateTest {

    @Test
    public void multiplicationOfZeroIntegersShouldReturnZero() {
        Client client = ClientBuilder.newClient(new ClientConfig().register(LoggingFilter.class));
        WebTarget webTarget = client.target("http://localhost:8080/zycus-cob/rest/").path("customers/create");
        Invocation.Builder invocationBuilder = webTarget.request(MediaType.APPLICATION_JSON);

        // Build customer object to post to web service
        Customer c = new Customer("1");
        c.setFirstName("Vijay");
        c.setMiddleName("Bhaskar");
        c.setLastName("D");
        c.setDescription("none");
        c.setDob(new Date());

        Response response = invocationBuilder.post(Entity.entity(c, MediaType.APPLICATION_JSON));
        System.out.println("response:" + response.hasEntity());
//        Result e = (Result) response.getEntity();
        String r = readInputStreamAsString((InputStream) response.getEntity());
        System.out.println(r);
//        assertEquals(0, e.getErrorCode());
    }

    public static String readInputStreamAsString(InputStream in) {
        try {
            BufferedInputStream bis = new BufferedInputStream(in);
            ByteArrayOutputStream buf = new ByteArrayOutputStream();
            int result = bis.read();
            while (result != -1) {
                byte b = (byte) result;
                buf.write(b);
                result = bis.read();
            }
            return buf.toString();
        } catch (IOException ex) {
            return null;
        }
    }
}
