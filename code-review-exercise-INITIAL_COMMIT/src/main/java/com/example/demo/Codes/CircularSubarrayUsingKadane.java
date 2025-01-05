package com.example.demo.Codes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CircularSubarrayUsingKadane {

    public static void main(String[] args) {
        int[] arr1 = {8, -1, 3, 4};
        List<Object> result1 = maxCircularSubarraySum(arr1);
        System.out.println("Maximum Circular Subarray Sum: " + result1.get(0));
        System.out.println("Circular Subarray: " + result1.get(1));

        int[] arr2 = {-2, -3, -1};
        List<Object> result2 = maxCircularSubarraySum(arr2);
        System.out.println("Maximum Circular Subarray Sum: " + result2.get(0));
        System.out.println("Circular Subarray: " + result2.get(1));

    }

    private static List<Object> maxCircularSubarraySum(int[] arr) {
        // Step 1: Find maximum subarray sum and its indices using Kadane's algorithm
        int[] kadaneresult=kadane(arr);
        int maxSubArraySum=kadaneresult[0];
        int maxKadaneStart=kadaneresult[1];
        int maxKadaneEnd=kadaneresult[2];
        // Step 2: Find total sum of the array
        int totalSum=0;
        for(int n:arr){
            totalSum+=n;
        }
        // Step 3: Find minimum subarray sum using Kadane's on inverted array
        int[] invertedArray=new int[arr.length];
        for(int i=0;i<arr.length;i++){
            invertedArray[i]=-arr[i];
        }
        int[] kadaninvertederesult=kadane(invertedArray);
        int minSubArraySum=kadaninvertederesult[0];
        int minKadaneStart=kadaninvertederesult[1];
        int minKadaneEnd=kadaninvertederesult[2];
        // Handle edge case: If all elements are negative
        if(totalSum+minSubArraySum==0){
            return Arrays.asList(maxSubArraySum,Arrays.copyOfRange(arr,maxKadaneStart,maxKadaneEnd+1));
        }
        // Step 4: Calculate maximum circular subarray sum
        int maxCircularSum = totalSum + minSubArraySum;
        // Step 5: Determine whether Kadane's result or circular result is better
        if(maxSubArraySum>=maxCircularSum){
            return Arrays.asList(maxSubArraySum,Arrays.copyOfRange(arr,maxKadaneStart,maxKadaneEnd+1));
        }else{
            // Circular case: Combine the parts outside the minimum subarray

            List<Integer> circularSubarray = new ArrayList<>();
            for(int i=0;i<=minKadaneStart-1;i++){
                circularSubarray.add(arr[i]);
            }
            for(int i=minKadaneEnd+1;i<arr.length;i++){
                circularSubarray.add(arr[i]);
            }

            return Arrays.asList(maxCircularSum,circularSubarray);
        }
    }

    private static int[] kadane(int[] arr) {
        int maxSofar=arr[0];
        int maxEndingHere=arr[0];
        int start=0, end=0 , tempstart=0;

        for(int i=1;i<arr.length;i++){
            if(arr[i]>maxEndingHere+arr[i]){
                maxEndingHere=arr[i];
                tempstart=i;
            }else{
                maxEndingHere+=arr[i];
            }
            if(maxEndingHere>maxSofar){
                maxSofar=maxEndingHere;
                start=tempstart;
                end=i;

            }
        }

        return new int[]{maxSofar,start,end};
    }
}
