package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "phoneIpEntity")
public class PhoneIpEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Phone Ip")
    private Integer phoneIp;

    @Column(name = "Machinery Id")
    private Integer machineryId;

    public PhoneIpEntity(Integer id, Integer phoneIp, Integer machineryId) {
        this.id = id;
        this.phoneIp = phoneIp;
        this.machineryId = machineryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getPhoneIp() {
        return phoneIp;
    }

    public void setPhoneIp(Integer phoneIp) {
        this.phoneIp = phoneIp;
    }

    public Integer getMachineryId() {
        return machineryId;
    }

    public void setMachineryId(Integer machineryId) {
        this.machineryId = machineryId;
    }
}
