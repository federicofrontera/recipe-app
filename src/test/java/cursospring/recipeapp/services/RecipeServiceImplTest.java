package cursospring.recipeapp.services;

import cursospring.recipeapp.converters.RecipeCommandToRecipe;
import cursospring.recipeapp.converters.RecipeToRecipeCommand;
import cursospring.recipeapp.model.Recipe;
import cursospring.recipeapp.repositories.RecipeRepository;
import org.junit.Before;
import org.junit.Test;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.Mockito.*;

public class RecipeServiceImplTest {
    RecipeServicesImpl recipeService;

    @Mock
    RecipeRepository recipeRepository;
    @Mock
    RecipeToRecipeCommand recipeToRecipeCommand;
    @Mock
    RecipeCommandToRecipe recipeCommandToRecipe;

    @Before
    public void setUp() throws Exception{
        MockitoAnnotations.initMocks(this);

        recipeService = new RecipeServicesImpl(recipeRepository, recipeCommandToRecipe, recipeToRecipeCommand);
    }

    @Test
    public void getRecipeByID() throws Exception{
        Recipe recipe = new Recipe();
        recipe.setId(1L);
        Optional<Recipe> optionalRecipe = Optional.of(recipe);

        when(recipeRepository.findById(anyLong())).thenReturn(optionalRecipe);

        Recipe returnedRecipe = recipeService.findById(1L);

        assertNotNull("Null recipe returned", returnedRecipe);
        verify(recipeRepository, times(1)).findById(any());
        verify(recipeRepository, never()).findAll();

    }

    @Test
    public void getRecipes() throws Exception{
        Recipe recipe = new Recipe();
        HashSet initialRecipes = new HashSet();
        initialRecipes.add(recipe);

        when(recipeService.getRecipes()).thenReturn(initialRecipes);
        Set<Recipe> recipes = recipeService.getRecipes();

        assertEquals(recipes.size(), 1);
        verify(recipeRepository, times(1)).findAll();
        verify(recipeRepository, never()).findById(anyLong());

    }

    @Test
    public void testDeleteById() throws Exception{
        Long id = Long.valueOf(2);
        recipeService.deleteById(id);

        verify(recipeRepository, times(1)).deleteById(anyLong());
    }
}
