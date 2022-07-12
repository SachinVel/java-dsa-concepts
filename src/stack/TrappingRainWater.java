package src.stack;

import java.util.Stack;

/*
    leetcode : https://leetcode.com/problems/trapping-rain-water/
    GFG : https://www.geeksforgeeks.org/trapping-rain-water/
 */

public class TrappingRainWater {

    public static int maxWater(int[] elevationMap) {
        int rainWaterCollection = 0;
        Stack<Integer> previousElevationIndex = new Stack<Integer>();
        for (int ind = 0; ind < elevationMap.length; ++ind) {
            while (previousElevationIndex.size() > 0 && elevationMap[ind] > elevationMap[previousElevationIndex.peek()]) {
                int middleElemsHeight = elevationMap[previousElevationIndex.peek()];
                previousElevationIndex.pop();
                if( previousElevationIndex.isEmpty() ){
                    break;
                }
                int leftClosingBarInd = previousElevationIndex.peek();
                int leftClosingBarHeight = elevationMap[leftClosingBarInd];
                int rightClosingBarHeight = elevationMap[ind];
                int middleDistance = ind-leftClosingBarInd-1;
                int heightDif = Math.min(leftClosingBarHeight,rightClosingBarHeight)-middleElemsHeight;
                rainWaterCollection += middleDistance*heightDif;
            }
            previousElevationIndex.push(ind);
        }

        return rainWaterCollection;

    }

    // Driver code
    public static void main(String[] args) {
        int arr[] = {0, 1, 0, 2, 1, 0, 1, 3, 2, 1, 2, 1};
        System.out.print(maxWater(arr));
    }
}
