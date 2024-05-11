package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

import java.sql.Time;


@Entity
@Table(name = "sitios")
public class Site {
    @Id
    @Column(name = "idSitio")
    private int siteId;

    @Column(name = "latitud")
    private double latitude;

    @Column(name = "longitud")
    private double longitude;

    @Column(name = "calle")
    private String street;

    @Column(name = "numero")
    private int number;

    @Column(name = "entreAalleA")
    private String streetA;

    @Column(name = "entreCalleB")
    private String streetB;

    @Column(name = "descripcion")
    private String description;

    @Column(name = "acargoDe")
    private String by;

    @Column(name = "apertura")
    private Time open;

    @Column(name = "cierre")
    private Time close;

    @Column(name = "comentarios")
    private String comments;

    public Site() {
    }
}