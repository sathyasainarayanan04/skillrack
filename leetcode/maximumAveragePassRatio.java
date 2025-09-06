class Solution {
    public double maxAverageRatio(int[][] classes, int extraStudents) {
        PriorityQueue<double[]> maxHeap = new PriorityQueue<>(
            (a,b)->Double.compare(b[0],a[0])
        );
        for(int index=0; index<classes.length;index++){
            double currentRatio =(double) classes[index][0]/classes[index][1];
            double newRatio = (double) (classes[index][0]+1)/(classes[index][1]+1);
            double gain = newRatio - currentRatio;
            maxHeap.offer(new double[]{gain,index});
        }
        while(extraStudents > 0){
            double[] classWithMaxGain = maxHeap.poll();
            int classIndex = (int) classWithMaxGain[1];
            classes[classIndex][0]++;
            classes[classIndex][1]++;
            double currentRatio = (double) classes[classIndex][0]/classes[classIndex][1];
            double newRatio = (double) (classes[classIndex][0]+1)/(classes[classIndex][1]+1);
            double gain = newRatio - currentRatio;
            maxHeap.offer(new double[] {gain, (double) classIndex});
            extraStudents--;
        }
        double totalRatio = 0.0;
        for(int index=0;index<classes.length; index++){
            totalRatio += (double) classes[index][0]/classes[index][1];
        }
        return totalRatio/classes.length;
    }
}
