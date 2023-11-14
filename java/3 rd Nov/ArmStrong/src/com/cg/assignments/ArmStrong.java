package com.cg.assignments;

public class ArmStrong {
	 
	public static void main(String[] args) {
 
		int n=153;
		int t=n;
		int r,sum=0;
		while(n>0) {
			r=n%10;
			sum=sum+(r*r*r);
			n=n/10;	
		}
		if(t==sum) {
			System.out.println("Armstrong Number");
		}else {
			System.out.println("Not an Armstrong Number");
		}
	}
 
}