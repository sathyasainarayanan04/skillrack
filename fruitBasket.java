class Solution {
    public int totalFruit(int[] fruits) {
        Map<Integer, Integer> frequencyMap = new HashMap<>();
       
        int left = 0;
        int maximumFruitsPicked = 0;
        for(int right=0;right<fruits.length; right++){
            int fruit = fruits[right];
            frequencyMap.put(fruit, frequencyMap.getOrDefault(fruit,0)+1);
            while(frequencyMap.size()>2){
                int fruitToBeRemoved = fruits[left];
                if(frequencyMap.get(fruitToBeRemoved)==1)
                frequencyMap.remove(fruitToBeRemoved);
                else
                frequencyMap.put(fruitToBeRemoved,frequencyMap.get(fruitToBeRemoved)-1);
                left++;
            }
            maximumFruitsPicked = Math.max(maximumFruitsPicked,right-left+1);
        }
        return maximumFruitsPicked;
    }
}
