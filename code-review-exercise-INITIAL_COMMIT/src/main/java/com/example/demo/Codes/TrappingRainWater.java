package com.example.demo.Codes;

import java.util.Arrays;

//Time complexity: O(n) for both approaches

public class TrappingRainWater {


    //Space complexity:O(n) for the precomputed arrays approach.
    public static int trappingWater(int arr[]) {
        // code here
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];

        int watertrap = 0;

        // Compute left max for each index

        left[0] = arr[0];
        for (int i = 1; i < n; i++) {
            left[i] = Math.max(left[i - 1], arr[i]);
        }

        // Compute right max for each index

        right[n-1] = arr[n - 1];
        for (int i = n - 2; i >= 0; i--) {
            right[i] = Math.max(right[i + 1], arr[i]);
        }

        System.out.println(Arrays.toString(left));
        System.out.println(Arrays.toString(right));
        System.out.println(Arrays.toString(arr));


        // Calculate trapped water
        for (int i = 0; i < n; i++) {
            watertrap += Math.max(0, Math.min(left[i], right[i]) - arr[i]);
            System.out.println("watertrap"+watertrap);
        }


        return watertrap;

    }


    //Space complexity: O(1) for the two-pointer approach.
    public static int trapWater(int[] height) {
        int waterTrap=0;
        int n=height.length;
        int left =0, right =n-1;
        int leftMax=0, rightMax=0;

        while(left<right){
            if(height[left]<height[right]){
                if(height[left]>=leftMax){
                    leftMax=height[left];
                }else{
                    waterTrap+=leftMax-height[left];
                }
                left++;
            }else{
                if(height[right]>=rightMax){
                    rightMax=height[right];
                }else{
                    waterTrap+=rightMax=height[right];
                }
                right--;

            }
        }

        return waterTrap;
    }
    public static void main(String[] args) {
        int[] height = {3, 0, 0, 2, 0, 4};
        System.out.println("Trapped Water: " + trappingWater(height));
        System.out.println("Trapped Water: " + trapWater(height));

    }

}