package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.sql.Time;


@Entity
@Table(name = "sitios")
public class Site {
    @Id
    @Column(name = "idsitio")
    private int siteId;

    @Column(name = "latitud")
    private double latitude;

    @Column(name = "longitud")
    private double longitude;

    @Column(name = "calle")
    private String street;

    @Column(name = "numero")
    private int number;

    @Column(name = "entrecallea")
    private String streetA;

    @Column(name = "entrecalleb")
    private String streetB;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "acargode")
    private String by;

    @Column(name = "apertura")
    private Time open;

    @Column(name = "cierre")
    private Time close;

    @Column(name = "comentarios")
    private String comments;

    public Site() {
    }

    public int getSiteId() {
        return siteId;
    }

    public void setSiteId(int siteId) {
        this.siteId = siteId;
    }

    public double getLatitude() {
        return latitude;
    }

    public void setLatitude(double latitude) {
        this.latitude = latitude;
    }

    public double getLongitude() {
        return longitude;
    }

    public void setLongitude(double longitude) {
        this.longitude = longitude;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public int getNumber() {
        return number;
    }

    public void setNumber(int number) {
        this.number = number;
    }

    public String getStreetA() {
        return streetA;
    }

    public void setStreetA(String streetA) {
        this.streetA = streetA;
    }

    public String getStreetB() {
        return streetB;
    }

    public void setStreetB(String streetB) {
        this.streetB = streetB;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getBy() {
        return by;
    }

    public void setBy(String by) {
        this.by = by;
    }

    public Time getOpen() {
        return open;
    }

    public void setOpen(Time open) {
        this.open = open;
    }

    public Time getClose() {
        return close;
    }

    public void setClose(Time close) {
        this.close = close;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }
}