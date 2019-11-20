package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "office")
public class OfficeEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Office name")
    private String officeName;

    @Column(name = "Count of Workspace")
    private Integer countOfWorkspace;

    @Column(name = "Count of Computers")
    private Integer countOfComputers;

    @Column(name = "Count of Laptops")
    private Integer countOfLaptops;

    @Column(name = "Count of Routers")
    private Integer countOfRouters;

    @Column(name = "Count of Printers")
    private Integer countOfPrinters;


    public OfficeEntity(Integer id, String officeName, Integer countOfWorkspace, Integer countOfComputers, Integer officeId, Integer countOfLaptops, Integer countOfRouters, Integer countOfPrinters) {
        this.id = id;
        this.officeName = officeName;
        this.countOfWorkspace = countOfWorkspace;
        this.countOfComputers = countOfComputers;
        this.countOfLaptops = countOfLaptops;
        this.countOfRouters = countOfRouters;
        this.countOfPrinters = countOfPrinters;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getOfficeName() {
        return officeName;
    }

    public void setOfficeName(String officeName) {
        this.officeName = officeName;
    }

    public Integer getCountOfWorkspace() {
        return countOfWorkspace;
    }

    public void setCountOfWorkspace(Integer countOfWorkspace) {
        this.countOfWorkspace = countOfWorkspace;
    }

    public Integer getCountOfComputers() {
        return countOfComputers;
    }

    public void setCountOfComputers(Integer countOfComputers) {
        this.countOfComputers = countOfComputers;
    }

    public Integer getCountOfRouters() {
        return countOfRouters;
    }

    public void setCountOfRouters(Integer countOfRouters) {
        this.countOfRouters = countOfRouters;
    }

    public Integer getCountOfPrinters() {
        return countOfPrinters;
    }

    public void setCountOfPrinters(Integer countOfPrinters) {
        this.countOfPrinters = countOfPrinters;
    }

    public Integer getCountOfLaptops() {
        return countOfLaptops;
    }

    public void setCountOfLaptops(Integer countOfLaptops) {
        this.countOfLaptops = countOfLaptops;
    }
}

