/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Ingredient;
import entities.Item;

/**
 *
 * @author Ulrik
 */
public class IngredientDTO {
    
    private Item item;
    private int amount;

    public IngredientDTO() {
    }

    public IngredientDTO(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

    IngredientDTO(Ingredient i) {
        //this.item = i.getItem();
        this.amount = i.getAmount();
    }

    public Item getItem() {
        return item;
    }

    public int getAmount() {
        return amount;
    }
    
}
