package com.example.Licensing.model.entitie;

import jakarta.persistence.*;
import java.util.Date;
import java.util.Objects;

/*@Licensing (c) 2023 PKFOKAM RESEARCH CENTER
 * @author LITA POLA ABDEL AZIZ - litapo489@gmail.com
 * */

@Entity
@Table(name = "Licence")
public class License {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String licenceKey;
    private Date expirationDate;
    private Date genreratedDate;

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "server_id")
    private Server server;

    private Integer daysLeft=0;

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public String getLicenceKey() {
        return licenceKey;
    }

    public void setLicenceKey(String licenceKey) {
        this.licenceKey = licenceKey;
    }

    public Date getExpirationDate() {
        return expirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        this.expirationDate = expirationDate;
    }

    public Date getGenreratedDate() {
        return genreratedDate;
    }

    public void setGenreratedDate(Date genreratedDate) {
        this.genreratedDate = genreratedDate;
    }

    public Server getServer() {
        return server;
    }

    public void setServer(Server server) {
        this.server = server;
    }

    public Integer getDaysLeft() {
        return daysLeft;
    }

    public void setDaysLeft(Integer daysLeft) {
        this.daysLeft = daysLeft;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        License license = (License) o;
        return Objects.equals(id, license.id) && Objects.equals(licenceKey, license.licenceKey) && Objects.equals(expirationDate, license.expirationDate) && Objects.equals(genreratedDate, license.genreratedDate) && Objects.equals(server, license.server) && Objects.equals(daysLeft, license.daysLeft);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, licenceKey, expirationDate, genreratedDate, server, daysLeft);
    }

    @Override
    public String toString() {
        return "License{" +
                "id=" + id +
                ", licenceKey='" + licenceKey + '\'' +
                ", expirationDate=" + expirationDate +
                ", genreratedDate=" + genreratedDate +
                ", server=" + server +
                ", daysLeft=" + daysLeft +
                '}';
    }
}
