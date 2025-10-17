class Solution {
    private List<Integer> topologicalSortGroups(Map<Integer,List<Integer>> groupToSuccessors, int[] groupInDegree){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int group : groupToSuccessors.keySet()){
            if(groupInDegree[group] == 0){
                queue.offer(group);
            }
        }
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int index =0; index < levelSize; index++){
                int currentGroup = queue.poll();
                result.add(currentGroup);
                for(int neighborGroup : groupToSuccessors.getOrDefault(currentGroup, new ArrayList<>())){
                    groupInDegree[neighborGroup]--;
                    if(groupInDegree[neighborGroup] == 0){
                        queue.offer(neighborGroup);
                    }
                }
            }
        }
        return result;
    }
    private List<Integer> topologicalSortByItems(Map<Integer, List<Integer>> itemToSuccessorsMap, int[] itemInDegree, List<Integer> itemsToSort){
        List<Integer> result = new ArrayList<>();
        Queue<Integer> queue = new LinkedList<>();
        for(int item : itemsToSort){
            if(itemInDegree[item] == 0)queue.offer(item);
        }
        Set<Integer> itemSet = new HashSet<>(itemsToSort);
        while(!queue.isEmpty()){
            int levelSize = queue.size();
            for(int index =0; index < levelSize; index++){
                int currentItem = queue.poll();
                result.add(currentItem);
                for(int neighbor : itemToSuccessorsMap.getOrDefault(currentItem, new ArrayList<>())){
                    itemInDegree[neighbor]--;
                    if(itemInDegree[neighbor] == 0 && itemSet.contains(neighbor)){
                        queue.offer(neighbor);
                    }
                }
            }
        }
        return result;
    }
    public int[] sortItems(int numberOfItems, int numberOfGroups, int[] group, List<List<Integer>> itemPreRequisites) {
        int nextGroupId = numberOfGroups;
        for(int item =0; item < group.length; item++){
            if(group[item] == -1)
               group[item] = nextGroupId++;
        }
        Map<Integer, List<Integer>> itemToSuccessorsMap = new HashMap<>();
        int[] itemInDegree = new int[numberOfItems];
        for(int item =0; item < numberOfItems; item++){
            itemToSuccessorsMap.put(item, new ArrayList<>());
        }
        Map<Integer, List<Integer>> groupToSuccessorsMap = new HashMap<>();
        int[] groupInDegree = new int[nextGroupId];
        for(int gp = 0; gp < nextGroupId; gp++){
            groupToSuccessorsMap.put(gp, new ArrayList<>());
        }
        for(int currentItem =0; currentItem < numberOfItems; currentItem++){
            for(int preReqItem : itemPreRequisites.get(currentItem)){
                int preReqGroup = group[preReqItem];
                int currentItemGroup = group[currentItem];
                if(preReqGroup == currentItemGroup){
                    itemToSuccessorsMap.get(preReqItem).add(currentItem);
                    itemInDegree[currentItem]++;
                }
                else{
                    if(!groupToSuccessorsMap.get(preReqGroup).contains(currentItemGroup)){
                        groupToSuccessorsMap.get(preReqGroup).add(currentItemGroup);
                        groupInDegree[currentItemGroup]++;
                    }
                }
            }
        }
        List<Integer> sortedGroups = topologicalSortGroups(groupToSuccessorsMap, groupInDegree);
        if(sortedGroups.size() < nextGroupId)return new int[0];
        Map<Integer, List<Integer>> itemPartitionedByGroup = new HashMap<>();
        for(int item = 0; item < numberOfItems; item++){
            if(!itemPartitionedByGroup.containsKey(group[item])){
                itemPartitionedByGroup.put(group[item], new ArrayList<>());
            }
            itemPartitionedByGroup.get(group[item]).add(item);
        }
        List<Integer> finalResult = new ArrayList<>();
        for(int groupId : sortedGroups){
            List<Integer> items = itemPartitionedByGroup.getOrDefault(groupId, new ArrayList<>());
            if(!items.isEmpty()){
                List<Integer> sortedItems = topologicalSortByItems(itemToSuccessorsMap, itemInDegree, items);
                if(sortedItems.size() < items.size())return new int[0];
                finalResult.addAll(sortedItems);
            }
        }
        int[] array = new int[finalResult.size()];
        for(int index =0; index < finalResult.size(); index++){
            array[index] = finalResult.get(index);
        }
        return array;
    }
}



























