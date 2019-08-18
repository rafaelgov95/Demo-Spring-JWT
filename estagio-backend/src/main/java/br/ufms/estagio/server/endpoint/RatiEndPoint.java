/*
 * Copyright (C) 2017 Universidade Federal de Mato Grosso do Sul
 *
 * This program is free software: you can redistribute it and/or modify
 * it under the terms of the GNU General Public License as published by
 * the Free Software Foundation, either version 3 of the License, or
 * (at your option) any later version.
 *
 * This program is distributed in the hope that it will be useful,
 * but WITHOUT ANY WARRANTY; without even the implied warranty of
 * MERCHANTABILITY or FITNESS FOR A PARTICULAR PURPOSE.  See the
 * GNU General Public License for more details.
 *
 * You should have received a copy of the GNU General Public License
 * along with this program.  If not, see <http://www.gnu.org/licenses/>.
 */
package br.ufms.estagio.server.endpoint;

import br.ufms.estagio.server.repository.RatiRepository;
import br.ufms.estagio.server.resource.entity.Rati;
import br.ufms.estagio.server.service.RatiService;
import br.ufms.estagio.springbootlib.endpoint.ReadWriteEndPoint;
import com.google.gson.Gson;
import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import org.apache.commons.codec.binary.Base64;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 *
 * @author Rafael Viana
 */
@RestController
@RequestMapping(path = "rati")
public class RatiEndPoint extends ReadWriteEndPoint<Rati,Long, RatiService> {

    @Autowired
    RatiRepository ratiRepository;
    Logger logger = LoggerFactory.getLogger(this.getClass());

    @RequestMapping(path = "/",method = RequestMethod.POST)
    public ResponseEntity cadastrar(@RequestBody String body){
        Gson g = new Gson();
        Rati rati = new Rati();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();

        rati.setNome(g.fromJson(body,JsonElement.class).getAsJsonObject().get("nomeCompleto").getAsString());
        rati.setCpf(g.fromJson(body,JsonElement.class).getAsJsonObject().get("cpf").getAsString());
        rati.setEmail(g.fromJson(body,JsonElement.class).getAsJsonObject().get("email").getAsString());
        rati.setTipo(g.fromJson(body,JsonElement.class).getAsJsonObject().get("tipo").getAsString());
        rati.setTitulo(g.fromJson(body,JsonElement.class).getAsJsonObject().get("titulo").getAsString());
        rati.setPrioridade(g.fromJson(body,JsonElement.class).getAsJsonObject().get("prioridade").getAsString());
        rati.setMensagem(g.fromJson(body,JsonElement.class).getAsJsonObject().get("mensagem").getAsString());

        rati.setData_at(dateFormat.format(date));
        rati.setSituacao("PENDENTE");
        rati.setResposta("");
        rati.setNome_ti("");
       return ResponseEntity.ok(ratiRepository.save(rati));
    }
    @GetMapping(path ="/")
    public List<Rati> alsl() {
        return ratiRepository.findAll();
    }

    @RequestMapping(path = "/admin/resposta",method = RequestMethod.POST)
    public Rati resposta(@RequestHeader(value="Authorization") String Token, @RequestBody String body){
        Gson g = new Gson();
        DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
        Date date = new Date();
        String[] split_string = Token.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String tokendecoder = new String(base64Url.decode(base64EncodedBody));
        JsonElement element = g.fromJson(tokendecoder, JsonElement.class);
        JsonObject jsonObject = element.getAsJsonObject();
        JsonElement element2 =g.fromJson(jsonObject.get("sub").getAsString(), JsonElement.class);

        if(element2.getAsJsonObject().get("cpf").getAsString().equals("04634501163")){
           Rati r =  g.fromJson(body,Rati.class);
            r.setResposta_data_at(dateFormat.format(date));
            r.setNome_ti(element2.getAsJsonObject().get("nomeCompleto").getAsString());
            ratiRepository.save(r);
            return r;
        }
        return null;

    }


    @RequestMapping(path = "/admin/autenticati",method = RequestMethod.GET)
    public Boolean autenticati(@RequestHeader(value="Authorization") String Token){
        Gson g = new Gson();
        String[] split_string = Token.split("\\.");
        String base64EncodedBody = split_string[1];
        Base64 base64Url = new Base64(true);
        String tokendecoder = new String(base64Url.decode(base64EncodedBody));
        JsonElement element = g.fromJson(tokendecoder, JsonElement.class);
        JsonObject jsonObject = element.getAsJsonObject();
        JsonElement element2 =g.fromJson(jsonObject.get("sub").getAsString(), JsonElement.class);
        if(element2.getAsJsonObject().get("cpf").getAsString().equals("04634501163")){
            return true;
        }
        return false;

    }

}
