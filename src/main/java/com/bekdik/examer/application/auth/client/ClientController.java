package com.bekdik.examer.application.auth.client;


import org.springframework.data.rest.webmvc.BasePathAwareController;
import org.springframework.http.*;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.Base64;
import java.util.Optional;

@CrossOrigin(origins = "http://localhost:5173", maxAge = 3600, methods = {RequestMethod.HEAD, RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT})
@BasePathAwareController("client")
public class ClientController {
    private ClientRepository clientRepository;
    public ClientController(ClientRepository clientRepository){
        this.clientRepository=clientRepository;
    }
@GetMapping("/login")
@PreAuthorize("havingRole('ADMIN')")
    public String login (@RequestHeader("clientName") String username,  @RequestHeader("clientSecret") String password){

       Optional<Client> client= clientRepository.findByClientId(username);
      if(client.isPresent()) {
          if(password.equals(client.get().getClientSecret())){
              //tokjenı al ve dönder
              RestTemplate restTemplate=new RestTemplate();
              ResponseEntity<String> response = null;
              // According OAuth documentation we need to send the client id and secret key in the header for authentication
              String credentials = "admin-client:secret";
              String encodedCredentials = new String(Base64.getEncoder().encode(credentials.getBytes()));

              HttpHeaders headers = new HttpHeaders();
              headers.setAccept(Arrays.asList(MediaType.APPLICATION_JSON));
              headers.add("Authorization", "Basic " + encodedCredentials);
              HttpEntity<String> request = new HttpEntity<>("");
              String access_token_url = "http://localhost:8080/oauth2/token";
              access_token_url += "?scope=" + "user.read";
              access_token_url += "&grant_type=client_credentials";
              //access_token_url += "&redirect_uri=http://localhost:8080/examer/questions";
              response = restTemplate.exchange(access_token_url, HttpMethod.POST, request, String.class);
              return response.getBody();
          }
      }
      return null;
    }
}
