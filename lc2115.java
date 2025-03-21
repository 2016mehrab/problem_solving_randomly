import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class LC2115 {
    public List<String> findAllRecipes(String[] recipes, List<List<String>> ingredients, String[] supplies) {
        Set<String> set = new HashSet<>();
        Set<String> visited = new HashSet<>();
        List<String> possible_recipes = new ArrayList<>();
        Map<String, List<String>> recipe_ingredients = new HashMap<>();
        for (int i = 0; i < recipes.length; ++i) {
            recipe_ingredients.put(recipes[i], ingredients.get(i));
        }
        for (var s : supplies) {
            set.add(s);
        }
        for (var recipe : recipes) {
            if (canMake(recipe, recipe_ingredients, set, visited)) {
                possible_recipes.add(recipe);
            }

        }
        System.out.println(possible_recipes);
        return possible_recipes;
    }

    private boolean canMake(String recipe, Map<String, List<String>> recipe_to_ingredients, Set<String> set,
            Set<String> visited) {
        if (!recipe_to_ingredients.containsKey(recipe) || visited.contains(recipe))
            return false;
        visited.add(recipe);
        List<String> req_ingrds = recipe_to_ingredients.get(recipe);
        for (var ing : req_ingrds) {
            if (!set.contains(ing)) {
                if (!canMake(ing, recipe_to_ingredients, set, visited)) {
                    visited.remove(recipe);
                    return false;
                }
            }
        }
        set.add(recipe);
        visited.remove(recipe);
        return true;

    }

    public static void main(String[] args) {
        LC2115 solution = new LC2115();
        solution.findAllRecipes(new String[] { "bread" }, List.of(List.of("yeast", "flour")),
                new String[] { "yeast", "flour", "corn" });
        solution.findAllRecipes(new String[] { "bread", "sandwich" },
                List.of(List.of("yeast", "flour"), List.of("bread", "meat")),
                new String[] { "yeast", "flour", "meat" });

    }
}
