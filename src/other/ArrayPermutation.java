package other;

import java.util.ArrayList;
import java.util.List;

public class ArrayPermutation {

    public static void permuteDriver(int[] arr, boolean visited[], List<List<Integer>> permutationList,
                                     List<Integer> curPermutation, int permLen){
        if( permLen==arr.length ){
            permutationList.add(curPermutation);
        }

        for( int ind=0 ; ind<arr.length ; ++ind ){
            if( !visited[ind]){
                ArrayList<Integer> nextPerm = new ArrayList<>(curPermutation);
                nextPerm.add(arr[ind]);
                visited[ind]=true;
                permuteDriver(arr,visited,permutationList,nextPerm,permLen+1);
                visited[ind]=false;
            }
        }
    }

    public static List<List<Integer>> permute(int[] arr){
        ArrayList<List<Integer>> permutationList = new ArrayList<List<Integer>>();

        permuteDriver(arr, new boolean[arr.length], permutationList, new ArrayList<Integer>(), 0);
        return permutationList;
    }
    public static void main(String args[]){
        int arr[] = {1, 2, 3};

        System.out.println(permute(arr));
    }
}
