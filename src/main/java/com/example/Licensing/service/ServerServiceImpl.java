package com.example.Licensing.service;

import ch.qos.logback.core.util.SystemInfo;
import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.dto.ServerDTO;
import com.example.Licensing.model.entitie.License;
import com.example.Licensing.model.entitie.Server;
import com.example.Licensing.repository.LicenceRepo;
import com.example.Licensing.repository.ServerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import oshi.hardware.CentralProcessor;
import oshi.hardware.HardwareAbstractionLayer;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;
import java.util.List;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */
@Service
public class ServerServiceImpl implements IServerService {

    private ServerRepo serverRepo;
    private LicenceRepo licenceRepo;
    @Autowired
    public ServerServiceImpl(ServerRepo serverRepo, LicenceRepo licenceRepo){
        this.serverRepo = serverRepo;
        this.licenceRepo = licenceRepo;
    }

    @Override
    public ResponseMessage<Server> fetchServerInfos(Server server) throws SocketException {
        try {
            // Fetch MAC Address
            Enumeration<NetworkInterface> networkInterfaces = NetworkInterface.getNetworkInterfaces();
            while (networkInterfaces.hasMoreElements()) {
                NetworkInterface networkInterface = networkInterfaces.nextElement();
                byte[] macAddressBytes = networkInterface.getHardwareAddress();
                if (macAddressBytes != null) {
                    StringBuilder macAddress = new StringBuilder();
                    for (byte b : macAddressBytes) {
                        macAddress.append(String.format("%02X:", b));
                    }
                    if (macAddress.length() > 0) {
                        macAddress.deleteCharAt(macAddress.length() - 1);
                    }
                    server.setMacAdresse(macAddress.toString());
                }
            }

            // Fetch IP Address
            InetAddress localHost = InetAddress.getLocalHost();
            String ipAddress = localHost.getHostAddress();
            server.setIpAdresse(ipAddress);

            // Set installation date
            server.setInstallationDate(new Date());

            server.setCpuInfo("cpu");

            // Set the expiration date based on the user input from serverDTO
            Date expirationDate = server.getValidityDate();

            // Generate the license key based on the server information
            String licenseKey = generateLicenseKey(server);

            //Save the licence  in the licence entity
            License licence = new License();
            licence.setLicenceKey(licenseKey);
            licence.setGenreratedDate(new Date());
            licence.setExpirationDate(expirationDate);
            licenceRepo.save(licence);
            serverRepo.save(server);
            // Return success response with the populated server information
            return new ResponseMessage(HttpStatus.OK,"UServer infos fetch successfully",server);
        } catch (UnknownHostException e) {
            e.printStackTrace();
            // Return error response if an exception occurs
            return new ResponseMessage(HttpStatus.BAD_REQUEST,"Error occurred while fetching server information");
        }
    }

    @Override
    public String generateLicenseKey(Server server) {
        // Get relevant server information
        String bankUniqueCode = server.getBankUniqueCode();
        Date validityDate = server.getValidityDate();
        Date extractionDate = server.getExtrationDate();

        // Generate license key using a combination of server information
        String licenseKey = bankUniqueCode + "_" + formatDate(validityDate) + "_" + formatDate(extractionDate);

        return licenseKey;
    }

    @Override
    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }
}
