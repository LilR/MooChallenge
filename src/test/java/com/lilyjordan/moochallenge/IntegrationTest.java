package com.lilyjordan.moochallenge;

import com.google.gson.Gson;
import com.lilyjordan.moochallenge.entity.Customer;
import org.apache.commons.io.IOUtils;
import org.apache.http.HttpEntity;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.junit.Before;
import org.junit.Test;

import java.io.IOException;
import java.net.URI;
import java.net.URISyntaxException;
import java.nio.charset.Charset;

import static org.junit.Assert.assertEquals;

/**
 * Created by Lily on 30/06/2019.
 */
public class IntegrationTest {


    private Customer bobSmith;

    @Before
    public void setUp() throws Exception {
        bobSmith = new Customer();
        bobSmith.setId(1L);
        bobSmith.setFirstName("Bob");
        bobSmith.setSurname("Smith");
        bobSmith.setPhoneNumber("+447123456789");
        bobSmith.setEmailAddress("bob@bobsmith.com");
        bobSmith.setPostalAddress("5 Drury Lane");
    }

    @Test
    public void testGetCustomerBySurnameAPI() throws Exception {
        HttpEntity httpEntity = executeGet("http://localhost:8080/customer/Smith");
        String json = IOUtils.toString(httpEntity.getContent(), Charset.defaultCharset());
        System.out.println(json);
        Customer responseCustomer = new Gson().fromJson(json, Customer.class);
        assertEquals(bobSmith, responseCustomer);
    }

    private HttpEntity executeGet(String s) throws IOException, URISyntaxException {
        CloseableHttpClient httpclient = HttpClients.createDefault();
        URI uri = new URI(s);
        HttpGet httpget = new HttpGet(uri);
        CloseableHttpResponse execute = httpclient.execute(httpget);
        return execute.getEntity();
    }
}
