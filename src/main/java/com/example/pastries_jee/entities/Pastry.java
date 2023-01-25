package com.example.pastries_jee.entities;

import jakarta.persistence.*;

@Entity
public class Pastry {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String description;
    @Column(name = "img_name")
    private String imgName;

    public Pastry() {}

    public Long getId() {

        return id;
    }

    public String getName() {

        return name;
    }

    public void setName(String name) {

        this.name = name;
    }

    public String getDescription() {

        return description;
    }

    public void setDescription(String description) {

        this.description = description;
    }

    public String getImgName() {
        return imgName;
    }

    public void setImgName(String imgName) {
        this.imgName = imgName;
    }

    @Override
    public String toString() {
        final StringBuffer sb = new StringBuffer("Pastry{");
        sb.append("id=").append(id);
        sb.append(", name='").append(name).append('\'');
        sb.append(", description='").append(description).append('\'');
        sb.append(", imgName='").append(imgName).append('\'');
        sb.append('}');
        return sb.toString();
    }
}
