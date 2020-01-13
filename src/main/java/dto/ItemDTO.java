/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Item;

/**
 *
 * @author Ulrik
 */
public class ItemDTO {
    
    private long id;
    private String name;

    public ItemDTO() {
    }

    public ItemDTO(String name) {
        this.name = name;
    }
    
    public ItemDTO(Item i) {
        this.id = i.getId();
        this.name = i.getName();
    }

    public ItemDTO(long id, String Name) {
        this.id = id;
        this.name = Name;
    }

    public long getId() {
        return id;
    }

    public String getName() {
        return name;
    }
    
    
    
}
