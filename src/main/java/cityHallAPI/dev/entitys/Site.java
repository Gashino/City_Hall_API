package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.sql.Time;

@Entity
@Table(name = "sitios")
public class Site {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long siteId;
    private Double latitude;
    private Double longitude;
    private String street;
    private int number;
    private String streetA;
    private String streetB;
    private String description;
    private String by;
    private Time Open;
    private Time Close;

    public Site() {
    }

    public Site(Double latitude, Double longitude, String street, int number, String streetA, String streetB, String description, String by, Time open, Time close) {
        this.latitude = latitude;
        this.longitude = longitude;
        this.street = street;
        this.number = number;
        this.streetA = streetA;
        this.streetB = streetB;
        this.description = description;
        this.by = by;
        Open = open;
        Close = close;
    }

    // Getters


    public Long getSiteId() {
        return siteId;
    }

    public Double getLatitude() {
        return latitude;
    }

    public Double getLongitude() {
        return longitude;
    }

    public String getStreet() {
        return street;
    }

    public int getNumber() {
        return number;
    }

    public String getStreetA() {
        return streetA;
    }

    public String getStreetB() {
        return streetB;
    }

    public String getDescription() {
        return description;
    }

    public String getBy() {
        return by;
    }

    public Time getOpen() {
        return Open;
    }

    public Time getClose() {
        return Close;
    }
}
