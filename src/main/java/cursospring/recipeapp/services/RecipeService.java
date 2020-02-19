package cursospring.recipeapp.services;

import cursospring.recipeapp.commands.RecipeCommand;
import cursospring.recipeapp.model.Recipe;

import java.util.Set;

public interface RecipeService {

    Set<Recipe> getRecipes();
    Recipe findById(Long l);
    RecipeCommand saveRecipeCommand(RecipeCommand command);
    RecipeCommand findCommandById(long l);

    void deleteById(Long id);
}
