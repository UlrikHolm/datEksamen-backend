package facades;

import dto.RecipeDTO;
import entities.Item;
import entities.Recipe;
import entities.RenameMe;
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
public class RecipeFacade {

    private static RecipeFacade instance;
    private static EntityManagerFactory emf;
    
    //Private Constructor to ensure Singleton
    private RecipeFacade() {}
    
    
    /**
     * 
     * @param _emf
     * @return an instance of this facade class.
     */
    public static RecipeFacade getFacadeExample(EntityManagerFactory _emf) {
        if (instance == null) {
            emf = _emf;
            instance = new RecipeFacade();
        }
        return instance;
    }

    private EntityManager getEntityManager() {
        return emf.createEntityManager();
    }
    
    public long getRecipeCount(){
        EntityManager em = emf.createEntityManager();
        try{
            long recipeCount = (long)em.createQuery("SELECT COUNT(r) FROM Recipe r").getSingleResult();
            return recipeCount;
        }finally{  
            em.close();
        }
        
    }
    
        public long getRequestCategoryCount(String category){
        EntityManager em = emf.createEntityManager();
        try{
            long RequestCount = (long)em.createQuery("SELECT COUNT(r) FROM Reguest r JOIN r.categoryList c WHERE c.name = :category")
                    .setParameter("category", category)
                    .getSingleResult();
            return RequestCount;
        }finally{  
            em.close();
        }   
    }
        
    public Recipe getRecipeById(long id) {
        EntityManager em = getEntityManager();
        try {
            Recipe recipe = em.find(Recipe.class, id);
            return recipe;
        } finally {
            em.close();
        }
    }
        
    public List<RecipeDTO> getAllRecipe() {
        EntityManager em = getEntityManager();
        TypedQuery<Recipe> tq = em.createQuery("SELECT r FROM Recipe r", Recipe.class);
        List<Recipe> recipes = tq.getResultList();
        List<RecipeDTO> RecipeDTO = new ArrayList<>();
        em.close();
        for (Recipe recipe : recipes) {
            RecipeDTO.add(new RecipeDTO(recipe));
        }
        return RecipeDTO;
    }
    
        public int getItemStorage(long item){
        EntityManager em = emf.createEntityManager();
        try{
            int recipeCount = (int)em.createQuery("SELECT s.amount FROM Storage s WHERE s.item.id = :item")
                    .setParameter("item", item)
                    .getSingleResult();
            return recipeCount;
        }finally{  
            em.close();
        }
        
    }

}
