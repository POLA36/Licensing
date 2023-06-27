package com.example.Licensing.model.dto;

import com.example.Licensing.model.entitie.Server;

import java.util.Date;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

public class ServerDTO {

    private Long id;
    private String cpuInfo;
    private String ipAdresse;
    private Date installationDate;
    private String macAdresse;
    private String bankUniqueCode;
    private Date validityDate;
    private Date extrationDate;

    public ServerDTO() {
    }

    public ServerDTO(Long id, String cpuInfo, String ipAdresse, Date installationDate, String macAdresse, String bankUniqueCode, Date validityDate, Date extrationDate) {
        this.id = id;
        this.cpuInfo = cpuInfo;
        this.ipAdresse = ipAdresse;
        this.installationDate = installationDate;
        this.macAdresse = macAdresse;
        this.bankUniqueCode = bankUniqueCode;
        this.validityDate = validityDate;
        this.extrationDate = extrationDate;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCpuInfo() {
        return cpuInfo;
    }

    public void setCpuInfo(String cpuInfo) {
        this.cpuInfo = cpuInfo;
    }

    public String getIpAdresse() {
        return ipAdresse;
    }

    public void setIpAdresse(String ipAdresse) {
        this.ipAdresse = ipAdresse;
    }

    public Date getInstallationDate() {
        return installationDate;
    }

    public void setInstallationDate(Date installationDate) {
        this.installationDate = installationDate;
    }

    public String getMacAdresse() {
        return macAdresse;
    }

    public void setMacAdresse(String macAdresse) {
        this.macAdresse = macAdresse;
    }

    public String getBankUniqueCode() {
        return bankUniqueCode;
    }

    public void setBankUniqueCode(String bankUniqueCode) {
        this.bankUniqueCode = bankUniqueCode;
    }

    public Date getValidityDate() {
        return validityDate;
    }

    public void setValidityDate(Date validityDate) {
        this.validityDate = validityDate;
    }

    public Date getExtrationDate() {
        return extrationDate;
    }

    public void setExtrationDate(Date extrationDate) {
        this.extrationDate = extrationDate;
    }

    public ServerDTO(Server server){
        this.id = server.getId();
        this.cpuInfo = server.getCpuInfo();
        this.ipAdresse = server.getIpAdresse();
        this.installationDate = server.getInstallationDate();
        this.macAdresse = server.getMacAdresse();
        this.bankUniqueCode = server.getBankUniqueCode();
        this.validityDate = server.getValidityDate();
    }

    public Server toEntity(){
        Server server = new Server();
        server.setId(this.id);
        server.setCpuInfo(this.cpuInfo);
        server.setIpAdresse(this.ipAdresse);
        server.setInstallationDate(this.installationDate);
        server.setMacAdresse(this.macAdresse);
        server.setBankUniqueCode(this.bankUniqueCode);
        server.setValidityDate(this.validityDate);
        server.setExtrationDate(this.extrationDate);
        return server;
    }
}
