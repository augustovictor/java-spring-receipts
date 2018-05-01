package augustovictor.receipt.bootstrap;

import augustovictor.receipt.models.*;
import augustovictor.receipt.repositories.CategoryRepository;
import augustovictor.receipt.repositories.RecipeRepository;
import augustovictor.receipt.repositories.UnitOfMeasureRepository;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

@Component
public class RecipeBootstrap implements ApplicationListener<ContextRefreshedEvent> {

    private final RecipeRepository recipeRepository;
    private final CategoryRepository categoryRepository;
    private final UnitOfMeasureRepository unitOfMeasureRepository;

    public RecipeBootstrap(RecipeRepository recipeRepository, CategoryRepository categoryRepository, UnitOfMeasureRepository unitOfMeasureRepository) {
        this.recipeRepository = recipeRepository;
        this.categoryRepository = categoryRepository;
        this.unitOfMeasureRepository = unitOfMeasureRepository;
    }

    @Override
    public void onApplicationEvent(ContextRefreshedEvent event) {
        recipeRepository.saveAll(getMockRecipes());
    }

    private Set<Recipe> getMockRecipes() {
        Set<Recipe> recipes = new HashSet<>();

        // Get UOMs
        Optional<UnitOfMeasure> uom = unitOfMeasureRepository.findByUom("Teaspoon");

        if (!uom.isPresent()) {
            throw new RuntimeException("No uom found!");
        }

        // Get Categories
        Optional<Category> americanCategory = categoryRepository.findByDescription("American");

        if(!americanCategory.isPresent()) {
            throw new RuntimeException("Category not found in db");
        }

        // Create Recipe
        Recipe americanRecipe = new Recipe();
        americanRecipe.addCategory(americanCategory.get());
        americanRecipe.setDescription("The best american recipe");
        americanRecipe.setDirections("Mix all together");
        americanRecipe.setPrepTime(10);
        americanRecipe.setServings(2);
        americanRecipe.getIngredients().add(new Ingredient("tacos", 20, americanRecipe, uom.get()));
        americanRecipe.setNotes(new Notes(americanRecipe, "This is a great recipe note!"));

        recipes.add(americanRecipe);

        return recipes;
    }


}
