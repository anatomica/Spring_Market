package com.anatomica.market.entities.ws;

import lombok.Getter;
import lombok.Setter;
import javax.xml.bind.annotation.*;

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "product", propOrder = {
        "id",
        "title",
        "description",
        "price"
})
@Setter
@Getter
public class ProductWS {

    @XmlElement(required = true)
    protected int id;
    @XmlElement(required = true)
    protected String title;
    @XmlElement(required = true)
    protected String description;
    @XmlElement(required = true)
    protected int price;

}
