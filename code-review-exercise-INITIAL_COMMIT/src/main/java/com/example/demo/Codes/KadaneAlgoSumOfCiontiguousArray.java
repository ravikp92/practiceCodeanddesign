package com.example.demo.Codes;

import java.util.Arrays;
//maximum sum of a contiguous subarray in a given array.
public class KadaneAlgoSumOfCiontiguousArray {
    //Kadane's algorithm to return the subarray that yields the maximum sum,
    // we need to track the indices of the start and end of the maximum subarray.

    public static void main(String[] args) {
        int[] arr = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
        int[] result = kadaneWithSubarray(arr);

        // Print the maximum sum
        System.out.println("Maximum Sum: " + result[0]);

        // Print the subarray
        System.out.println("Subarray: " + Arrays.toString(Arrays.copyOfRange(result, 1, result.length)));
    }

    //Time complexity : O(N)
    //Space complexity:: O(K) .. K is the size of the resulting subarray
    private static int[] kadaneWithSubarray(int[] arr) {
        int maxEndingHere=arr[0];
        int maxSofar=arr[0];

        int start=0;
        int end=0;
        int tempStart=0;

        //Use two additional variables:
        //start: Tracks where the current subarray starts.
        //end: Tracks where the maximum subarray ends.
        //Update start whenever starting a new subarray.
        //Update end whenever a new maximum is found.

        for(int i=0;i<arr.length;i++){
            if(arr[i]>maxEndingHere+arr[i]){
                maxEndingHere=arr[i];
                tempStart=i;
            }else{
                maxEndingHere+=arr[i];
            }

            if(maxEndingHere>maxSofar){
                maxSofar=maxEndingHere;
                start=tempStart;
                end=i;
            }
        }

        int[] resultSubArray=Arrays.copyOfRange(arr,start,end+1);

        int[] result=new int[resultSubArray.length+1];
        result[0]=maxSofar;
        for (int i = 0; i < resultSubArray.length; i++) {
            result[i + 1] = resultSubArray[i];
        }
        return result;

    }

    //only to get sum use below
    //Time complexity : O(N)
    //Space complexity:: O(1) ..
    public static int kadane(int[] arr) {
        int maxEndingHere = arr[0];
        int maxSoFar = arr[0];

        for (int i = 1; i < arr.length; i++) {
            maxEndingHere = Math.max(arr[i], maxEndingHere + arr[i]);
            maxSoFar = Math.max(maxSoFar, maxEndingHere);
        }
        return maxSoFar;
    }
}
