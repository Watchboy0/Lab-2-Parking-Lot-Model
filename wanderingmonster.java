//wandering monster table

import java.util.*;

public class wanderingmonster{
	public double[] time = new double[9];
	public static void main(String[] args){
		System.out.println("starting program");
		wanderingmonster monster = new wanderingmonster();
		// setTable();
		// double[] time = {25,50,80,100,115,125,135,140,145};
		// for(int i =0; i<time.length; i++){
		// 	time[i]=time[i]/145;
		// 	System.out.println(time[i]);
		// }
		// //Random rand = new Random();
		// int[] percentages = new int[9];
		// // for(int j=0; j<100; j++){
		// 	double amount = Math.random();
		// 	//System.out.println(amount);

		// 	int hours=0;
		// 	if(amount<time[0]){
		// 		hours=1;
		// 		// percentages[0]++;
		// 	}
		// 	for(int i =0; i<time.length-1; i++){
		// 		if(amount>time[i]&&amount<=time[i+1]){
		// 			hours=i+2;
		// 			// percentages[i+1]++;
		// 		}
		// 	}
		// 	System.out.println("hours parked: " +hours);
		// // }
		// // System.out.println(Arrays.toString(percentages));
		System.out.println("ending program");
	}
	public wanderingmonster(){
		setTable();
		// System.out.println("get Stay time");
		// for(int i =0 ;i<100; i++){
			// int stay = getStayTime();
			// System.out.println("stay time = "+stay);
		// }
	}
	private void setTable(){
		double[] table = {25,50,80,100,115,125,135,140,145};
		// double[] table = {5,25,40,90,115,125,135,140,145};
		for(int i =0; i<time.length; i++){
			time[i]=table[i]/145;
			// System.out.println(time[i]);
		}
	}

	public int getStayTime(){
		double amount = Math.random();
		int hours=0;
		if(amount<time[0]){
			hours=1;
			
		}
		for(int i =0; i<time.length-1; i++){
			if(amount>time[i]&&amount<=time[i+1]){
				hours=i+2;
				
			}
		}
		return hours;
	}

}
