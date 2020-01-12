/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package entities;

import java.io.Serializable;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;

/**
 *
 * @author Ulrik
 */
@Entity
public class Recipe implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String preperationTime;
    private String directions;
    
    @ManyToMany(mappedBy = "recipies")
    private List<WeekMenu> weekMenus;
    
    @OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.PERSIST)
    @ManyToMany(mappedBy = "recipes")
    private List<Ingredient> ingredients;

    public Recipe() {
    }

    public Recipe(String preperationTime, String directions, List<WeekMenu> weekMenus, List<Ingredient> ingredients) {
        this.preperationTime = preperationTime;
        this.directions = directions;
        this.weekMenus = weekMenus;
        this.ingredients = ingredients;
    }    

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getPreperationTime() {
        return preperationTime;
    }

    public void setPreperationTime(String preperationTime) {
        this.preperationTime = preperationTime;
    }

    public String getDirections() {
        return directions;
    }

    public void setDirections(String directions) {
        this.directions = directions;
    }

    public List<WeekMenu> getWeekMenus() {
        return weekMenus;
    }

    public void setWeekMenus(List<WeekMenu> weekMenus) {
        this.weekMenus = weekMenus;
    }

    public List<Ingredient> getIngredients() {
        return ingredients;
    }

    public void setIngredients(List<Ingredient> ingredients) {
        this.ingredients = ingredients;
    }
    
    

}
