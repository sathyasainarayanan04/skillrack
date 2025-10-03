class Solution {
    public int maxSatisfied(int[] customers, int[] grumpy, int minutes) {
        int unsatisfiedCustomers = 0;
        for(int index =0; index< minutes; index++){
            unsatisfiedCustomers += (customers[index] * grumpy[index]);
        }
        int maximumUnsatisfiedCustomers = unsatisfiedCustomers;
        int satisfiedCustomers = 0;
        for(int index=0; index < customers.length; index++){
            satisfiedCustomers += (customers[index] * (1-grumpy[index]));
        }
        System.out.println(satisfiedCustomers);
        int left = 0;
        int right = minutes;
        while(right < customers.length){
            unsatisfiedCustomers -= (customers[left] * grumpy[left]);
            unsatisfiedCustomers += (customers[right] * grumpy[right]);
            maximumUnsatisfiedCustomers = Math.max(unsatisfiedCustomers, maximumUnsatisfiedCustomers);
            left++;
            right++;
        }
        return maximumUnsatisfiedCustomers + satisfiedCustomers;
    }
}
