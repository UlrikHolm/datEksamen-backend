/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import dto.IngredientDTO;
import dto.ItemDTO;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

/**
 *
 * @author Ulrik
 */
@Entity
public class Ingredient implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
//    @GeneratedValue(strategy = GenerationType.IDENTITY)
//    private Long id;
    @ManyToOne
    private Item item;
    private int amount;
//    private List<Recipe> recipes = new ArrayList();

    public Ingredient() {
    }

//    public Ingredient(Item item, int amount) {
//        this.item = item;
//        this.amount = amount;
////        this.recipes = recipes;
//    }

    public Ingredient(Item item, int amount) {
        this.item = item;
        this.amount = amount;
    }

//    public Ingredient(IngredientDTO i) {
//        this.item = i.getItem();
//        this.amount = i.getAmount();
//    }

//    public Long getId() {
//        return id;
//    }
//
//    public void setId(Long id) {
//        this.id = id;
//    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }

//    public List<Recipe> getRecipes() {
//        return recipes;
//    }
//
//    public void setRecipes(List<Recipe> recipes) {
//        this.recipes = recipes;
//    }

}
