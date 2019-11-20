package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "officeHasEmployer")
public class OfficeHasEmployersEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Employer Id")
    private Integer employerId;

    public OfficeHasEmployersEntity(Integer id, Integer employerId) {
        this.id = id;
        this.employerId = employerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }
}
