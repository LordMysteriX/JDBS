package ua.lviv.iot.models;

import ua.lviv.iot.models.Annotation.Column;
import ua.lviv.iot.models.Annotation.PrimaryKey;
import ua.lviv.iot.models.Annotation.Table;

@Table(name = "stuff")
public class StuffEntity {
    @PrimaryKey
    @Column(name = "id")
    private Integer id;

    @Column(name = "Post name")
    private String postName;

    @Column(name = "Stuff name")
    private String stuffName;

    @Column(name = "Office Id")
    private Integer officeId;

    public StuffEntity(Integer id, String postName, String stuffName, Integer officeId) {
        this.id = id;
        this.postName = postName;
        this.stuffName = stuffName;
        this.officeId = officeId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getPostName() {
        return postName;
    }

    public void setPostName(String postName) {
        this.postName = postName;
    }

    public String getStuffName() {
        return stuffName;
    }

    public void setStuffName(String stuffName) {
        this.stuffName = stuffName;
    }

    public Integer getOfficeId() {
        return officeId;
    }

    public void setOfficeId(Integer officeId) {
        this.officeId = officeId;
    }
}
