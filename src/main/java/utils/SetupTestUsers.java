package utils;


import entities.Ingredient;
import entities.Item;
import entities.Recipe;
import entities.Role;
import entities.Storage;
import entities.User;
import java.util.ArrayList;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

public class SetupTestUsers {

  public static void main(String[] args) {

    EntityManagerFactory emf = EMF_Creator.createEntityManagerFactory(EMF_Creator.DbSelector.DEV, EMF_Creator.Strategy.CREATE);
    EntityManager em = emf.createEntityManager();
    
    // IMPORTAAAAAAAAAANT!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!
    // This breaks one of the MOST fundamental security rules in that it ships with default users and passwords
    // CHANGE the three passwords below, before you uncomment and execute the code below
    // Also, either delete this file, when users are created or rename and add to .gitignore
    // Whatever you do DO NOT COMMIT and PUSH with the real passwords
    
    Item item = new Item("ris", 12, new Storage(8));
    Item item2 = new Item("mel", 11, new Storage(13));
    Item item3 = new Item("sukker", 80, new Storage(1));
    Ingredient ingredient = new Ingredient(item, 7);
    Ingredient ingredient2 = new Ingredient(item2, 5);
    List<Ingredient> ingredients = new ArrayList();
    ingredients.add(ingredient);
    ingredients.add(ingredient2);
    Ingredient ingredient3 = new Ingredient(item3, 99);
    List<Ingredient> ingredients2 = new ArrayList();
    ingredients2.add(ingredient3);
    Recipe recipe = new Recipe("2h4m", "kog ris", ingredients);
    Recipe recipe1 = new Recipe("4m", "steg kød", ingredients);
    Recipe recipe2 = new Recipe("30m", " bag pizza", ingredients);
    Recipe recipe3 = new Recipe("1h4m", "bag kage", ingredients);
    Recipe recipe4 = new Recipe("1h30m", "kog ris", ingredients);
    Recipe recipe5 = new Recipe("5h0m", "smør madder", ingredients);
    Recipe recipe6 = new Recipe("3h6m", "kog pasta", ingredients);
    Recipe recipe7 = new Recipe("2h30m", "bag brød", ingredients);
    Recipe recipe8 = new Recipe("45m", "put i ovenen på 40 grader", ingredients);
    Recipe recipe9 = new Recipe("1h0m", "skær ud", ingredients2);
    

    User user = new User("user", "user");
    User admin = new User("admin", "admin");
    User both = new User("user_admin", "user_admin");
    
    
    if(admin.getUserPass().equals("test")||user.getUserPass().equals("test")||both.getUserPass().equals("test"))
      throw new UnsupportedOperationException("You have not changed the passwords");

    em.getTransaction().begin();
    Role userRole = new Role("user");
    Role adminRole = new Role("admin");
    user.addRole(userRole);
    admin.addRole(adminRole);
    both.addRole(userRole);
    both.addRole(adminRole);
    em.persist(userRole);
    em.persist(adminRole);
    em.persist(user);
    em.persist(admin);
    em.persist(both);
    
    em.persist(item);
    em.persist(item2);
    em.persist(item3);
    em.persist(ingredient);
    em.persist(ingredient2);
    em.persist(ingredient3);
    em.persist(recipe);
    em.persist(recipe1);
    em.persist(recipe2);
    em.persist(recipe3);
    em.persist(recipe4);
    em.persist(recipe5);
    em.persist(recipe6);
    em.persist(recipe7);
    em.persist(recipe8);
    em.persist(recipe9);
    em.getTransaction().commit();
    System.out.println("PW: " + user.getUserPass());
    System.out.println("Testing user with OK password: " + user.verifyPassword("test"));
    System.out.println("Testing user with wrong password: " + user.verifyPassword("test1"));
    System.out.println("Created TEST Users");
   
  }

}
