package recipes;

import java.util.ArrayList;
import java.util.List;

public class RecipeBook {
    private final List<Recipe> recipes;

    RecipeBook (Recipe recipes){
        this.recipes = new ArrayList<>();
        addRecipe(recipes);
    }

    private boolean isSameRecipe(Recipe recipe){
        return recipes.stream().anyMatch(r-> r.getRecipeName().equals(recipe.getRecipeName()));
    }

    public void addRecipe(Recipe recipe){
        if(isSameRecipe(recipe)){
            throw new IllegalArgumentException("Вы пытаетесь доваить рецепт с одинаковым названием");
        } else {
            this.recipes.add(recipe);
        }
    }
}
