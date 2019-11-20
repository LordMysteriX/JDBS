package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "accesPoint")
public class AccesPointEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Ip adress")
    private Integer ipAdress;

    @Column(name = "Wifi password")
    private String  wifiPassword;

    @Column(name = "Name")
    private String name;

    @Column(name = " Machinery Ip")
    private Integer machineryIp;

    public AccesPointEntity(Integer id, Integer ipAdress, String wifiPassword, String name, Integer machineryIp) {
        this.id = id;
        this.ipAdress = ipAdress;
        this.wifiPassword = wifiPassword;
        this.name = name;
        this.machineryIp = machineryIp;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getIpAdress() {
        return ipAdress;
    }

    public void setIpAdress(Integer ipAdress) {
        this.ipAdress = ipAdress;
    }

    public String getWifiPassword() {
        return wifiPassword;
    }

    public void setWifiPassword(String wifiPassword) {
        this.wifiPassword = wifiPassword;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getMachineryIp() {
        return machineryIp;
    }

    public void setMachineryIp(Integer machineryIp) {
        this.machineryIp = machineryIp;
    }
}