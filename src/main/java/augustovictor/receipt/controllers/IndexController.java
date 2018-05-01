package augustovictor.receipt.controllers;

import augustovictor.receipt.models.Category;
import augustovictor.receipt.models.UnitOfMeasure;
import augustovictor.receipt.repositories.CategoryRepository;
import augustovictor.receipt.repositories.UnitOfMeasureRepository;
import augustovictor.receipt.services.RecipeService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Optional;

@Controller
public class IndexController {

    private final RecipeService recipeService;

    public IndexController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @RequestMapping({"", "/", "/index"})
    public String getIndex(Model model) {
        model.addAttribute("recipes", recipeService.getRecipes());

        return "index";
    }
}
