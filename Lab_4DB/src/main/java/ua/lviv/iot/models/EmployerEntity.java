package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "employer")
public class EmployerEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Employer name")
    private String  employerName;

    @Column(name = "Employer post")
    private String employerPost;

    public EmployerEntity(Integer id, String employerName, String employerPost) {
        this.id = id;
        this.employerName = employerName;
        this.employerPost = employerPost;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String  getEmployerName() {
        return employerName;
    }

    public void setEmployerName(String  employerName) {
        this.employerName = employerName;
    }

    public String getEmployerPost() {
        return employerPost;
    }

    public void setEmployerPost(String employerPost) {
        this.employerPost = employerPost;
    }
}
