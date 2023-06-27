package com.example.Licensing.service;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.Server;

import java.net.SocketException;
import java.util.Date;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

public interface IServerService {
    public ResponseMessage<Server> fetchServerInfos(Server server) throws SocketException;

    String generateLicenseKey(Server server);

    String formatDate(Date date);
}
