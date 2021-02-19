package greedy;

import java.util.Arrays;

/*
 * You are given n activities with their start and finish times. 
 * Select the maximum number of activities that can be performed by a single person, assuming that a person can only work on a single activity at a time. 
 */
public class ActivitySelection {
	
	public static int findMaximumActivityDone(int start[],int finish[]) {
		int result=0;
		int n = start.length;
		
		int timeFinished = 0;
		for( int ind=0 ; ind<n ; ++ind ) {
			if( start[ind]>=timeFinished ) {
				++result;
				timeFinished = finish[ind];
			}
		}
		return result;
	}
	public static void main(String[] args) {
		
		int start[]  =  {1, 3, 0, 5, 8, 5};
		int finish[] =  {2, 4, 6, 7, 9, 9};
		
		System.out.println(findMaximumActivityDone(start, finish));
		
	}
}
