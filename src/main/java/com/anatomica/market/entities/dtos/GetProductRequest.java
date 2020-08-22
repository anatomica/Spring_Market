package com.anatomica.market.entities.dtos;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"title"})
public class GetProductRequest {

    @XmlElement(required = true)
    protected String title;

    @XmlElement(required = true)
    protected Long Id;

    public String getName() {
        return title;
    }

    public void setName(String title) {
        this.title = title;
    }

    public Long getId() {
        return Id;
    }

    public void setId(Long id) {
        Id = id;
    }
}
