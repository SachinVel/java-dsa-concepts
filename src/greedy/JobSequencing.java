package greedy;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/*
 * Given an array of jobs where every job has a deadline and associated profit if the job is finished before the deadline.
 * It is also given that every job takes the single unit of time, so the minimum possible deadline for any job is 1.
 *  How to maximize total profit if only one job can be scheduled at a time.
 */

public class JobSequencing {
	static class Job implements Comparable<Job>{
		String name;
		int deadline;
		int profit;
		public Job(String name,int deadline,int profit) {
			this.name = name;
			this.deadline = deadline;
			this.profit = profit;
		}
		
		@Override
		public int compareTo(Job job2) {
			return job2.profit-this.profit;
		}
		
		@Override
		public String toString() {
			return this.name;
		}
		
	}
	
	public static void printJobSequencing( List<Job> jobs ) {
		Collections.sort(jobs);
		int timePassed = 0;
		for( Job job : jobs ) {
			if( job.deadline>timePassed ) {
				++timePassed;
				System.out.println("select job : "+job);
			}
		}
	}
	
	public static void main(String[] args) {
		ArrayList<Job> jobs = new ArrayList<Job>();
		jobs.add(new Job("a", 2, 100));
		jobs.add(new Job("b", 1, 19));
		jobs.add(new Job("c", 2,27));
		jobs.add(new Job("d", 1, 25));
		jobs.add(new Job("e", 3, 15));
		printJobSequencing(jobs);
	}
	
	

}
