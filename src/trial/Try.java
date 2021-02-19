package trial;

import java.util.Scanner;

public class Try {
	
	
	
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for( int case=1 ; case<=t ; ++case ){
            int n = sc.nextInt();
            int k = sc.nextInt();
            int arr[] = new int[n];
            int res[] = new int[n];
            int resInd;
            for( int ind=0 ; ind<n ; ++ind ){

                arr[ind]. sc.nextInt();
                resInd = ind+k;
                if( resInd>=n ){
                    resInd %= n;
                }
                res[resInd] = arr[ind];
            }
            for( int ind=0 ; ind<n ; ++ind ){
                System.out.print(res[ind]+" ");
            }
            System.out.println();
        
        }

		
	}	
}
