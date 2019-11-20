package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "machinery")
public class MachineryEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Machinery producer")
    private String machineryProducer;

    @Column(name = "Machinery type")
    private String machineryType;

    @Column(name = "Employer id")
    private Integer employerId;

    @Column(name = "Office Id")
    private Integer officeId;

    public MachineryEntity(Integer id, String machineryProducer, String machineryType, Integer employerId, int officeId) {
        this.id = id;
        this.machineryProducer = machineryProducer;
        this.machineryType = machineryType;
        this.employerId = employerId;
        this.officeId = officeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getMachineryProducer() {
        return machineryProducer;
    }

    public void setMachineryProducer(String machineryProducer) {
        this.machineryProducer = machineryProducer;
    }

    public String getMachineryType() {
        return machineryType;
    }

    public void setMachineryType(String machineryType) {
        this.machineryType = machineryType;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

    public int getOfficeId() {
        return officeId;
    }

    public void setOfficeId(int officeId) {
        this.officeId = officeId;
    }


}