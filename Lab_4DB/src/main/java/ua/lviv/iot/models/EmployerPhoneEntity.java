package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "employerPhone")
public class EmployerPhoneEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Employer phone")
    private Integer employerPhone;

    @Column(name = "Employer Id")
    private Integer employerId;

    public EmployerPhoneEntity(Integer id, Integer employerPhone, Integer employerId) {
        this.id = id;
        this.employerPhone = employerPhone;
        this.employerId = employerId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getEmployerPhone() {
        return employerPhone;
    }

    public void setEmployerPhone(Integer employerPhone) {
        this.employerPhone = employerPhone;
    }

    public Integer getEmployerId() {
        return employerId;
    }

    public void setEmployerId(Integer employerId) {
        this.employerId = employerId;
    }

}

