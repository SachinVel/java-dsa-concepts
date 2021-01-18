package search;

public class JumpSearch {
	public static void main(String[] args) {
		int arr[] = {1,2};
		int searchVal = 2;
		int jumpSize = (int)Math.floor(Math.sqrt(arr.length));
		int totalItr = arr.length/jumpSize-1;
		int blockLastInd;
		int startInd=0,endInd=jumpSize-1;
		int resultInd=-1;
		boolean isFound=false;
		
		for( int itr=1 ; itr<=totalItr ; ++itr ) {
			if( arr[endInd]==searchVal ) {
				isFound = true;
				resultInd=endInd;
				break;
			}else if( searchVal<arr[endInd] ) {
				break;
			}
			startInd = endInd+1;
			endInd += jumpSize;
		}
		if( !isFound ) {
			for( int ind=startInd ; ind<=endInd ; ++ind ) {
				if( arr[ind]==searchVal ) {
					resultInd = ind;
					break;
				}
			}
		}
		
		if( resultInd!=-1 ) {
			System.out.println("element found at position "+resultInd);
		}else {
			System.out.println("element is not found");
		}
		
	}
}
