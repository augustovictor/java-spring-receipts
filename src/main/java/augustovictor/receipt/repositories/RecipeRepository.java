package augustovictor.receipt.repositories;

import augustovictor.receipt.models.Recipe;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

public interface RecipeRepository  extends CrudRepository<Recipe, Long> {}
