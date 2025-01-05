package com.example.demo.Codes;

public class CircularSubarraySumUsingKadane {


    public static void main(String[] args) {
        int[] arr1 = {8, -1, 3, 4};
        System.out.println("Maximum Circular Subarray Sum: " + maxCircularSubarraySum(arr1)); // Output: 15

        int[] arr2 = {-2, -3, -1};
        System.out.println("Maximum Circular Subarray Sum: " + maxCircularSubarraySum(arr2)); // Output: -1
    }

    //Time Complexity
    //Kadane's Algorithm:
    //Runs in O(n), as it scans the array once.
    //Total Sum Calculation:
    //Runs in O(n), as it iterates through the array once.
    //Inverted Array Construction:
    //Runs in O(n).
    //Overall:
    //The algorithm runs threeO(n) passes, so the total time complexity is:
    //O(n)
    //
    //Space Complexity
    //Inverted Array:
    //An additional array of size n is used,
    //so the space complexity is O(n).
    //Other Variables:
    //A few scalar variables are used, which contribute
    //O(1) to space complexity.
    //
    //Overall:
    //The total space complexity is:O(n)
    private static int maxCircularSubarraySum(int[] arr) {
        // Step 1: Find the maximum subarray sum using Kadane's algorithm
        int maxSubArraySum=maxUsingKadaneAlgo(arr);
        // Step 2: Find the total sum of the array
        int totalSum=0;
        for(int a:arr){
            totalSum+=a;
        }
        // Step 3: Find the minimum subarray sum using Kadane's algorithm
        int[] invertedArray=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            invertedArray[i]=-arr[i];
        }
        int minSubarraySum=maxUsingKadaneAlgo(invertedArray);
        // Step 4: Handle edge case where all elements are negative
        if(totalSum+minSubarraySum==0){
            return maxSubArraySum;
        }
        // Step 5: Calculate maximum circular subarray sum
        int maxCirucular=totalSum+minSubarraySum;
        // Step 6: Return the maximum of non-circular and circular cases
        return Math.max(maxSubArraySum,maxCirucular);

    }

    private static int maxUsingKadaneAlgo(int[] arr) {
        int maxSofar=arr[0];
        int maxEndingHere=arr[0];
        for(int i=1;i<arr.length;i++){
            maxEndingHere=Math.max(arr[i],maxEndingHere+arr[i]);
            maxSofar=Math.max(maxSofar,maxEndingHere);
        }
        return maxSofar;
    }
}
