package rest;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import dto.RecipeDTO;
import entities.Recipe;
import utils.EMF_Creator;
import facades.RecipeFacade;
import java.util.List;
import javax.persistence.EntityManagerFactory;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;

//Todo Remove or change relevant parts before ACTUAL use
@Path("recipe")
public class RenameMeResource {

    private static final EntityManagerFactory EMF = EMF_Creator.createEntityManagerFactory(
                "pu",
                "jdbc:mysql://localhost:3307/dateksamen",
                "dev",
                "ax2",
                EMF_Creator.Strategy.CREATE);
    private static final RecipeFacade FACADE =  RecipeFacade.getFacadeExample(EMF);
    private static final Gson GSON = new GsonBuilder().setPrettyPrinting().create();
            
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String demo() {
        return "{\"msg\":\"Hello World\"}";
    }
    @Path("all")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getAllRecipe() {
        System.out.println("HELLLO");
        List<RecipeDTO> rdto = FACADE.getAllRecipe();
        return GSON.toJson(rdto);
    }
    
    @Path("count")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getRenameMeCount() {
        long count = FACADE.getRecipeCount();
        //System.out.println("--------------->"+count);
        return "{\"count\":"+count+"}";  //Done manually so no need for a DTO
    }
    
    @Path("{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getPerson(Recipe entity, @PathParam("id") long id) {
        Recipe r = FACADE.getRecipeById(id);
        return GSON.toJson(new RecipeDTO(r));
    }
    
    @Path("stor/{id}")
    @GET
    @Produces({MediaType.APPLICATION_JSON})
    public String getStorage(Recipe entity, @PathParam("id") long id) {
        int r = FACADE.getItemStorage(id);
        return GSON.toJson(r);
    }

 
}
