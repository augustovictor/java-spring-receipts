package augustovictor.receipt.services;

import augustovictor.receipt.models.Recipe;

import java.util.Set;

public interface RecipeService {
    Set<Recipe> getRecipes();
}
