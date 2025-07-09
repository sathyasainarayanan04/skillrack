package leetcode;
import java.util.*;
public class kthSmallestElementInSortedMatrix {
    static class MatrixElement{
        int value;
        int rowIndex;
        int colIndex;
        public MatrixElement(int value,int rowIndex, int colIndex){
            this.value = value;
            this.rowIndex = rowIndex;
            this.colIndex = colIndex;
        }
    }
    public int kthSmallestElement(int[][] matrix, int k){
        PriorityQueue<MatrixElement> minHeap = new PriorityQueue<>(
        (a,b)->Integer.compare(a.value,b.value));
        int matrixSize = matrix.length;
        for(int row=0;row<matrixSize;row++){
            int value = matrix[row][0];
            minHeap.offer(new MatrixElement(value,row,0));
        }
        if(k>matrix.length * matrix[0].length){
             throw new IllegalArgumentException("k is larger than the total number of elements");
        }
        int kthSmallest = 0;
        for(int i=0;i<k;i++){
            MatrixElement current = minHeap.poll();
            kthSmallest = current.value;
            if(current.colIndex+1<matrixSize){
                minHeap.offer(new MatrixElement(matrix[current.rowIndex][current.colIndex+1],current.rowIndex,current.colIndex+1));
            }
        }
        return kthSmallest;
    }
    public static void main(String[] args){
        kthSmallestElementInSortedMatrix obj = new kthSmallestElementInSortedMatrix();
        int[][] matrix = {{-5}};
        System.out.println(obj.kthSmallestElement(matrix,2));
    }
}
