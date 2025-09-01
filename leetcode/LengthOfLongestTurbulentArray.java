class Solution {
    private boolean isTurbulent(int index, int arr[]){
         return ((arr[index-1] > arr[index]) && (arr[index+1]>arr[index])) ||
                ((arr[index-1] < arr[index]) && (arr[index+1] < arr[index]));
    }
    public int maxTurbulenceSize(int[] arr) {
        int maxLength=1;
        int windowStart=0;
        int windowEnd = 0;
        int size = arr.length;
        if(size < 2){
            return size;
        }
        while(windowStart+1 < size){
            if(arr[windowStart]==arr[windowStart+1]){
                windowStart++;
                maxLength = Math.max(maxLength, windowEnd-windowStart+1);
                continue;
            }
            windowEnd = windowStart+1;
            while(windowEnd +1  < size && isTurbulent(windowEnd, arr)){
                windowEnd++;
            }
            maxLength = Math.max(maxLength, windowEnd-windowStart+1);
            windowStart = windowEnd;
        }
        return maxLength;
    }
}

/*
📝 Notes for Dry Run: arr = [9, 4, 2, 10, 7, 8, 8, 1, 9]
🔹 Initial Setup
Variable	Value
maxLength	1
windowStart	0
windowEnd	0
n	9
🔹 Step 1

windowStart = 0

Compare arr[0] and arr[1]: 9 != 4 ✅ → start turbulent window

windowEnd = windowStart + 1 = 1

Check isTurbulentAtIndex(1) → cannot extend further (needs 3 elements)

Subarray: [9, 4] → length = 2

Update maxLength = 2

Move windowStart = windowEnd = 1

🔹 Step 2

windowStart = 1

Compare arr[1] and arr[2]: 4 != 2 ✅

windowEnd = 2

Expand turbulent window:

arr[2] = 2, neighbors 4,10 → turbulent ✅ → windowEnd = 3

arr[3] = 10, neighbors 2,7 → turbulent ✅ → windowEnd = 4

arr[4] = 7, neighbors 10,8 → turbulent ✅ → windowEnd = 5

arr[5] = 8, neighbors 7,8 → not turbulent ❌ → stop

Subarray: [4, 2, 10, 7, 8] → length = 5

Update maxLength = 5

Move windowStart = windowEnd = 5

🔹 Step 3

windowStart = 5

Compare arr[5] and arr[6]: 8 == 8 ❌ → cannot start turbulence

Move windowStart = 6

🔹 Step 4

windowStart = 6

Compare arr[6] and arr[7]: 8 != 1 ✅

windowEnd = 7

Expand turbulent window:

arr[7] = 1, neighbors 8,9 → turbulent ✅ → windowEnd = 8

Subarray: [8, 1, 9] → length = 3

maxLength = max(5,3) = 5

Move windowStart = windowEnd = 8

🔹 End

windowStart + 1 = 9 → loop ends

✅ Longest turbulent subarray length = 5

Subarray = [4, 2, 10, 7, 8]
*/
