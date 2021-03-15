package ru.ifmo.soa_lab2_servcie1.models;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;
import java.util.ArrayList;
import java.util.List;

@XmlRootElement(name = "products")
@XmlAccessorType(XmlAccessType.FIELD)
public class ProductsList {
    @XmlElement(name = "product")
    public List<ru.ifmo.soa_lab2_servcie1.models.Product> products = new ArrayList<>();

    public List<ru.ifmo.soa_lab2_servcie1.models.Product> getProducts() {
        return products;
    }

    public void setProducts(List<ru.ifmo.soa_lab2_servcie1.models.Product> products) {
        this.products = products;
    }
}
