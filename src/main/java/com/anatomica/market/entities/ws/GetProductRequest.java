package com.anatomica.market.entities.ws;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "", propOrder = {"id"})
public class GetProductRequest {

    @XmlElement(required = true)
    protected Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
