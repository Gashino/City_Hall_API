package cityHallAPI.dev.entitys;

import jakarta.persistence.*;

@Entity
@Table(name = "changes")
public class Change {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idcambio")
    private int id;

    @Column(name = "expopushtoken")
    private String expoPushToken;

    @Column(name = "notified")
    private boolean notified;

    @Column(name = "tipo")
    private String type;

    @Column(name = "idtipo")
    private int idType;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getExpoPushToken() {
        return expoPushToken;
    }

    public void setExpoPushToken(String expoPushToken) {
        this.expoPushToken = expoPushToken;
    }

    public boolean isNotified() {
        return notified;
    }

    public void setNotified(boolean notified) {
        this.notified = notified;
    }

    public int getIdType() {
        return idType;
    }

    public void setIdType(int idType) {
        this.idType = idType;
    }

    public Change(String type, int id, String expoPushToken, boolean notified, int idType) {
        this.type = type;
        this.id = id;
        this.expoPushToken = expoPushToken;
        this.notified = notified;
        this.idType = idType;
    }

    public Change(){}


}
