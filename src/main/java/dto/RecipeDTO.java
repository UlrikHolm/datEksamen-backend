/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dto;

import entities.Ingredient;
import entities.Recipe;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Ulrik
 */
public class RecipeDTO {
    
    private long id;
    private String preperationTime;
    private String directions;
    private List<IngredientDTO> ingredients = new ArrayList();

    public RecipeDTO() {
    }    

    public RecipeDTO(Recipe r) {
        this.id = r.getId();
        this.preperationTime = r.getPreperationTime();
        this.directions = r.getDirections();
     //   this.ingredients = ingredients;
        for (Ingredient i : r.getIngredients()){ 
            this.ingredients.add(new IngredientDTO(i));
        }
    }
    
}
