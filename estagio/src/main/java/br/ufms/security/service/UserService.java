package br.ufms.security.service;


import br.ufms.security.jwt.JwtResponse;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.authentication.UserCredentials;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.web.authentication.AbstractAuthenticationProcessingFilter;
import org.springframework.security.web.util.matcher.AntPathRequestMatcher;
import org.springframework.web.client.RestTemplate;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Optional;


public class UserService {
    private String line = "";
    private String dn = "";

    public void Authentication(){
        Gson gson = new Gson();

//        JwtResponse creds = new ObjectMapper().readValue(req.getInputStream(), UserCredentials.class);
        try {
            String response = sendingGetRequest("TOKEN","DN");
            try {
                JsonElement element = gson.fromJson(response, JsonElement.class);
                JsonObject jsonObject = element.getAsJsonObject();
                String creds = "DN";
                dn = jsonObject.get("dn").getAsString();
                if (!creds.equals(dn)) {
                    throw new BadCredentialsException("Bad Credentials");
                }
            } catch (Exception e) {
                throw new BadCredentialsException("Bad Credentials");
            }

        } catch (Exception e) {
            throw new BadCredentialsException("Bad Credentials");
        }
    }




    private String sendingGetRequest(String token, String dn) throws Exception {
        dn = dn.replace(" ", "%20");
        String myurl = "https://sistemas5.ufms.br/passaporte-ws/api/ad/" + dn;
        HttpClient client = HttpClientBuilder.create().build();
        HttpGet request = new HttpGet(myurl);
        request.setHeader("X-AUTH-TOKEN", token);
        try {
            HttpResponse response = client.execute(request);
            HttpEntity entity = response.getEntity();
            if (entity != null) {
                try (InputStream stream = entity.getContent()) {
                    BufferedReader reader =
                            new BufferedReader(new InputStreamReader(stream));
                    while ((line = reader.readLine()) != null) {
                        return line;
                    }
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return line;
    }
}
