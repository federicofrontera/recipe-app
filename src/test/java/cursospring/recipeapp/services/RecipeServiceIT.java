package cursospring.recipeapp.services;

import cursospring.recipeapp.commands.RecipeCommand;
import cursospring.recipeapp.converters.RecipeCommandToRecipe;
import cursospring.recipeapp.converters.RecipeToRecipeCommand;
import cursospring.recipeapp.model.Recipe;
import cursospring.recipeapp.repositories.RecipeRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import static org.junit.Assert.assertEquals;

@RunWith(SpringRunner.class)
@SpringBootTest
public class RecipeServiceIT {
    public static final String NEW_DESCRIPTION = "New description";
    @Autowired
    RecipeService recipeService;
    @Autowired
    RecipeRepository recipeRepository;
    @Autowired
    RecipeCommandToRecipe recipeCommandToRecipe;
    @Autowired
    RecipeToRecipeCommand recipeToRecipeCommand;

    @Transactional
    @Test
    public void testSaveDescription() throws Exception{
        Iterable<Recipe> recipes = recipeRepository.findAll();
        Recipe testRecipe = recipes.iterator().next();
        RecipeCommand testRecipeCommand = recipeToRecipeCommand.convert(testRecipe);

        testRecipeCommand.setDescription(NEW_DESCRIPTION);
        RecipeCommand savedRecipeCommand = recipeService.saveRecipeCommand(testRecipeCommand);

        assertEquals(NEW_DESCRIPTION, savedRecipeCommand.getDescription());
        assertEquals(testRecipe.getId(),savedRecipeCommand.getId());
        assertEquals(testRecipe.getCategories().size(),savedRecipeCommand.getCategories().size());
        assertEquals(testRecipe.getIngredients().size(),savedRecipeCommand.getIngredients().size());
    }
}
