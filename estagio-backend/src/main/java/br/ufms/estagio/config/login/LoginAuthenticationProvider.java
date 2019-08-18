package br.ufms.estagio.config.login;


import br.ufms.estagio.config.login.UserCredentials;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Component;

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

@Component
public class LoginAuthenticationProvider implements AuthenticationProvider {

    private String line = "";
    private String dn = "";
    private static List<UserCredentials> users = new ArrayList<>();

    @Override
    public Authentication authenticate(Authentication authentication)
            throws AuthenticationException {
        Gson gson = new Gson();
        String name = authentication.getName();
        String password = authentication.getCredentials().toString();

        try {
            String response = sendingGetRequest(name,password);
            try {
                JsonElement element = gson.fromJson(response, JsonElement.class);
                JsonObject jsonObject = element.getAsJsonObject();
                dn = jsonObject.get("dn").getAsString();
                if (!password.equals(dn)) {
                    throw new BadCredentialsException("Bad Credentials");
                }
            } catch (Exception e) {
                throw new BadCredentialsException("Bad Credentials");
            }

        } catch (Exception e) {
            throw new BadCredentialsException("Bad Credentials");
        }

        UserCredentials user = new UserCredentials(name,dn);
        users.add(user);
        Optional<UserCredentials> userOptional = users.stream()
                .filter(u -> u.match(dn))
                .findFirst();

        if (!userOptional.isPresent()) {
            throw new BadCredentialsException("Authentication failed");
        }

        List<GrantedAuthority> grantedAuthorities = new ArrayList<>();
        grantedAuthorities.add(new SimpleGrantedAuthority(userOptional.get().getRole()));
        Authentication auth = new
                UsernamePasswordAuthenticationToken(name,dn, Collections.emptyList());
        return auth;
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

    @Override
    public boolean supports(Class<?> authentication) {
        return authentication.equals(UsernamePasswordAuthenticationToken.class);
    }
}