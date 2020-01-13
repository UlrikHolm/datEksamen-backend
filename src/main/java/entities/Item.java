/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.ItemDTO;
import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class Item implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private double pricePrKilo;
    @ManyToOne(fetch=FetchType.LAZY, cascade = CascadeType.PERSIST)
    private Storage storage;

    public Item() {
    }
    
    public Item(ItemDTO i) {
        this.id = i.getId();
        this.name = i.getName();
    }

    public Item(String name, double pricePrKilo, Storage storage) {
        this.name = name;
        this.pricePrKilo = pricePrKilo;
        this.storage = storage;
    }

    public Storage getStorage() {
        return storage;
    }

    public void setStorage(Storage storage) {
        this.storage = storage;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPricePrKilo() {
        return pricePrKilo;
    }

    public void setPricePrKilo(double pricePrKilo) {
        this.pricePrKilo = pricePrKilo;
    }

    
    
}
