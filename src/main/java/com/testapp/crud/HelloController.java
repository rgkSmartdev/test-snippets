package com.testapp.crud;

import java.io.IOException;

import org.apache.http.HttpResponse;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClients;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HelloController {

    @GetMapping("/")
    public String index() {
        // return "Hello World! from Crud app!";
         HttpClient httpClient = HttpClients.createDefault();
         HttpGet httpGet = new HttpGet("https://www.google.com");
         HttpResponse response = null;
        try {
            response = httpClient.execute(httpGet);
        } catch (ClientProtocolException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        } catch (IOException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
         if (response != null) {
             return response.toString();
         } else {
             return "Failed to get response";
         }
    }
}
