package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "pcConfiguration")
public class PcConfigurationEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Operation system")
    private String operationSystem;

    @Column(name = "Videocard")
    private String videocard;

    @Column(name = "Processor")
    private String processor;

    @Column(name = "Motherboard")
    private String motherboard;

    @Column(name = "SSD")
    private String ssd;

    @Column(name = "Power Supply")
    private String powerSupply;

    @Column(name = " Machinery Id")
    private Integer machineryId;

    public PcConfigurationEntity(Integer id, String operationSystem, String videocard, String processor, String motherboard, String ssd, String powerSupply, Integer machineryId) {
        this.id = id;
        this.operationSystem = operationSystem;
        this.videocard = videocard;
        this.processor = processor;
        this.motherboard = motherboard;
        this.ssd = ssd;
        this.powerSupply = powerSupply;
        this.machineryId = machineryId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOperationSystem() {
        return operationSystem;
    }

    public void setOperationSystem(String operationSystem) {
        this.operationSystem = operationSystem;
    }

    public String getVideocard() {
        return videocard;
    }

    public void setVideocard(String videocard) {
        this.videocard = videocard;
    }

    public String getProcessor() {
        return processor;
    }

    public void setProcessor(String processor) {
        this.processor = processor;
    }

    public String getMotherboard() {
        return motherboard;
    }

    public void setMotherboard(String motherboard) {
        this.motherboard = motherboard;
    }

    public String getSsd() {
        return ssd;
    }

    public void setSsd(String ssd) {
        this.ssd = ssd;
    }

    public String getPowerSupply() {
        return powerSupply;
    }

    public void setPowerSupply(String powerSupply) {
        this.powerSupply = powerSupply;
    }

    public Integer getMachineryId() {
        return machineryId;
    }

    public void setMachineryId(Integer machineryId) {
        this.machineryId = machineryId;
    }
}
