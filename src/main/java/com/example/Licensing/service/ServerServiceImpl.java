package com.example.Licensing.service;

import com.example.Licensing.ReponseMessage.ResponseMessage;
import com.example.Licensing.model.entitie.Admin;
import com.example.Licensing.model.entitie.License;
import com.example.Licensing.model.entitie.Server;
import com.example.Licensing.repository.LicenceRepo;
import com.example.Licensing.repository.ServerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.net.InetAddress;
import java.net.NetworkInterface;
import java.net.SocketException;
import java.net.UnknownHostException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Enumeration;

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
    public String fetchServerInfos(Server server) throws SocketException {
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

            // Calculate the number of days left
            int numberOfDaysLeft = calculateNumberOfDaysLeft(expirationDate);

            // Generate the license key based on the server information
            String licenseKey = generateLicenseKey(server);

            //Save the licence  in the licence entity
            License licence = new License();
            licence.setLicenceKey(licenseKey);
            licence.setGenreratedDate(new Date());
            licence.setExpirationDate(expirationDate);

            Server fetchExistingServer = serverRepo.findByMacAdresse(server.getMacAdresse());
            if (fetchExistingServer == null) {
                licenceRepo.save(licence);
                serverRepo.save(server);
                return licenseKey;
            } else {
                return "Server information already exists.";
            }
            // Return success response with the populated server information
        } catch (UnknownHostException e) {
            e.printStackTrace();
            // Return error response if an exception occurs
            return "Error occurred while generating key";
        }
    }

    @Override
    public String generateLicenseKey(Server server) {
        // Get relevant server information
        String bankUniqueCode = server.getBankUniqueCode();
        Date validityDate = server.getValidityDate();
        Date extractionDate = server.getExtrationDate();
        String macAdresse = server.getMacAdresse();
        String ipAdresse = server.getIpAdresse();

        // Generate license key using a combination of server information
        String licenseKey = bankUniqueCode + "_" + formatDate(validityDate) +  "_" + macAdresse + "_" + ipAdresse +"_" + formatDate(extractionDate);

        return licenseKey;
    }

    @Override
    public String formatDate(Date date) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        return dateFormat.format(date);
    }

    @Override
    public int calculateNumberOfDaysLeft(Date expirationDate) {
        // Calculate the number of days left based on the current date and expiration date
        Date currentDate = new Date();
        long differenceInMillis = expirationDate.getTime() - currentDate.getTime();
        long numberOfDaysLeft = differenceInMillis / (24 * 60 * 60 * 1000);
        return (int) numberOfDaysLeft;
    }
}
