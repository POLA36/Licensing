package com.example.Licensing.controller;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.Server;
import com.example.Licensing.service.IServerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import java.net.SocketException;
import java.util.Date;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@RestController
@RequestMapping(value = "/server")
public class ServerController {
    private IServerService serverService;
    @Autowired
    public ServerController(IServerService serverService){
        this.serverService = serverService;
    }

    @CrossOrigin(origins = "http://localhost:3000")
    @PostMapping("/saveServerInfos")
    public ResponseEntity<?> fetchAndStore(@RequestBody Server server) throws SocketException {
        server.setBankUniqueCode(server.getBankUniqueCode());
        server.setValidityDate(server.getValidityDate());
        server.setExtrationDate(new Date());

        // Call the service method with the Server entity
        return ResponseEntity.ok(serverService.fetchServerInfos(server));
    }
}