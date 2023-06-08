package model.entitie;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.util.Date;
import java.util.Objects;

@Entity
public class Server {
    private Long id;
    private String cpuInfo;
    private String ipAdresse;
    private Date installationDate;
    private String macAdresse;
    private String bankUniqueCode;
    private Date validityDate;
    private Date extrationDate;

    public void setId(Long id) {
        this.id = id;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    public Long getId() {
        return id;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Server server = (Server) o;
        return Objects.equals(id, server.id) && Objects.equals(cpuInfo, server.cpuInfo) && Objects.equals(ipAdresse, server.ipAdresse) && Objects.equals(installationDate, server.installationDate) && Objects.equals(macAdresse, server.macAdresse) && Objects.equals(bankUniqueCode, server.bankUniqueCode) && Objects.equals(validityDate, server.validityDate) && Objects.equals(extrationDate, server.extrationDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cpuInfo, ipAdresse, installationDate, macAdresse, bankUniqueCode, validityDate, extrationDate);
    }

    @Override
    public String toString() {
        return "Server{" +
                "id=" + id +
                ", cpuInfo='" + cpuInfo + '\'' +
                ", ipAdresse='" + ipAdresse + '\'' +
                ", installationDate=" + installationDate +
                ", macAdresse='" + macAdresse + '\'' +
                ", bankUniqueCode='" + bankUniqueCode + '\'' +
                ", validityDate=" + validityDate +
                ", extrationDate=" + extrationDate +
                '}';
    }
}
