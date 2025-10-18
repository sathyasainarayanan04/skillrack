class Solution {
    public List<String> findAllRecipes(
        String[] recipes,
     List<List<String>> ingredients, 
     String[] supplies) {
        Set<String> RecipeList = new HashSet<>(Arrays.asList(recipes));
        Set<String> available = new HashSet<>(Arrays.asList(supplies));
        Map<String, List<String>> graph = new HashMap<>();
        Map<String, Integer> inDegree = new HashMap<>();
        for(int index =0; index < recipes.length; index++){
            String recipe = recipes[index];
            List<String> requiredIngredients = ingredients.get(index);
            int count = 0;
            for(String ingredient : requiredIngredients){
                if(!available.contains(ingredient)){
                    count++;
                    if(RecipeList.contains(ingredient)){
                        if(!graph.containsKey(ingredient)){
                            graph.put(ingredient, new ArrayList<>());
                        }
                        graph.get(ingredient).add(recipe);
                    }
                }
            }
            inDegree.put(recipe,count);
        }
        Queue<String> queue = new LinkedList<>();
        for(String recipe : recipes){
            if(inDegree.get(recipe) == 0){
                queue.offer(recipe);
            }
        }
        List<String> allMakeableRecipes = new ArrayList<>();
        while(!queue.isEmpty()){
            String recipe = queue.poll();
            allMakeableRecipes.add(recipe);
            available.add(recipe);
            for(String dependent : graph.getOrDefault(recipe, new ArrayList<>())){
                inDegree.put(dependent, inDegree.get(dependent)-1);
                if(inDegree.get(dependent) == 0)
                queue.offer(dependent);
            }
        }
        return allMakeableRecipes;
    }
}
