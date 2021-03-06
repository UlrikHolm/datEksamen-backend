package facades;

import dto.IngredientDTO;
import dto.RecipeDTO;
import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.RenameMe;
import entities.Storage;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.TypedQuery;

/**
 *
 * Rename Class to a relevant name Add add relevant facade methods
 */
public class StorageFacade {

    private static StorageFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private StorageFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static StorageFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new StorageFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public long getItemStorage(Item item){
        EntityManager em = emf.createEntityManager();
        try{
            long recipeCount = (long)em.createQuery("SELECT s.amount FROM Storage s WHERE s.item = :item")
                    .setParameter("item", item)
                    .getSingleResult();
            return recipeCount;
        }finally{  
            em.close();
        }
        
    }
    
    public String checkStorage(Recipe recipe, Storage storage){
        for (int i = 0; i < recipe.getIngredients().size(); i++) {
            if (recipe.getIngredients().get(i).getAmount() > storage.getAmount()) {
                return "For lidt";
            }            
        }
        return "ok";
        
//        for (Ingredient in : recipe.getIngredients()){ 
//            if (recipe.getIngredients().get(0).getAmount() > storage.getAmount()) {
//                return "Forl idt";
//            }
//        }
    }
    
}
