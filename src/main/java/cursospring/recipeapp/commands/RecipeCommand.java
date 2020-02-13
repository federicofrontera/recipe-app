package cursospring.recipeapp.commands;

import cursospring.recipeapp.model.Difficulty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
@NoArgsConstructor
public class RecipeCommand {
    private Long id;
    private String description;
    private Integer prepTime;
    private Integer cookTime;
    private Integer servings;
    private String source;
    private String url;
    private String directions;
    private Set<IngredientCommand> ingredients = new HashSet<>();
    private Difficulty difficulty;
    /* look here if it stops working later*/
    private NotesCommand notes = new NotesCommand();
    /* look here if it stops working later*/
    private Set<CategoryCommand> categories = new HashSet<>();
}
