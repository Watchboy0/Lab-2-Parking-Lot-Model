//Ashley Ritter and Ben Bachmen
//parking lot model
//CMPT440 lab2
import java.util.*;
import java.io.*;


public class lab2{
	static int maxIterations=1000;
	public static void main(String[] args)  throws IOException{
		System.out.println(args.length);
		if(args.length==1){
			String input = args[0];

			lab2(input);
		}
	}
	public static void lab2(String input)throws IOException{
		int seed=0;
		int spots=0;
		int tower=0;
		int apartment=0;
		int commuters=0;


		File file = new File(input);
		FileReader fileReader= new FileReader(file);
		System.out.println(file);

		
		try{
			BufferedReader br = new BufferedReader(fileReader);
			String line = br.readLine();

			while(line != null){
				String[] value= line.split(" ");
				System.out.println(value[0]);
				if(value[0].equals("commuters")){
					commuters= Integer.parseInt(value[1]);
					// System.out.println("commuters");
				}
				else if(value[0].equals("tower")){
					tower = Integer.parseInt(value[1]);

				}
				else if(value[0].equals("apartment")){
					apartment = Integer.parseInt(value[1]);

				}
				else if(value[0].equals("spots")){
					spots= Integer.parseInt(value[1]);

				}
				else if(value[0].equals("seed")){
					seed= Integer.parseInt(value[1]);

				}
				line=br.readLine();
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
		System.out.println("tower: "+tower+" apartment: "+apartment+" commuters: "+commuters+" spots: "+spots);

		File log = new File("log_"+input);
		PrintWriter logger = new PrintWriter(log);
		logger.println("#, time, lot, street");

		Date startTime = new Date(117, 1, 16, 7, 0);
		Date endTime = new Date(117, 1, 16, 23, 59);
		Date leavingTime = new Date(117, 1, 17, 23, 59);

		Lot lot = new Lot(spots);
		Street street = new Street();

		wanderingmonster stayTimes = new wanderingmonster();

		for (int i = 0; i < apartment; i++) // Adds resident students to street and lot
		{
			studentCar car = new studentCar("resident", startTime, leavingTime);
			street.addCar(car);
		}

		for (int i = 0; i < tower; i++) // Adds resident students to street and lot
		{
			studentCar car = new studentCar("resident", startTime, leavingTime);
			if(!lot.addCar(car))
			{
				street.addCar(car);
			}
		}

		System.out.println(lot);
		System.out.println(street);

		//time management
		Random rand = new Random();
		if (seed > 0)
		{
			rand = new Random(seed);
		}
		Date d = new Date();
		d = nextArrival(startTime, rand.nextDouble(), 0.25);
		int count = 0;
		////int[] a = {0,0,0,0,0,0,0,0,0,0};
		while (d.before(endTime) && count < maxIterations)
		{
			long millis = d.getTime();
			millis += stayTimes.getStayTime()*60*60*1000; // Converts from hours to milliseconds
			Date leave = new Date();
			leave.setTime(millis);

			studentCar car = new studentCar("commuter", d, leave);
			// System.out.println(d);
			// System.out.println(leave);
			if(!lot.addCar(car))
			{
				street.addCar(car);
			}
			d = nextArrival(d, rand.nextDouble(), 0.25);

			// System.out.println(""+count+" "+d);
			// System.out.println(lot);
			// System.out.println(street);
			String output = ""+count+", "+d.getHours()+":";
			if (d.getMinutes() < 10) output += "0";
			output += d.getMinutes()+", "+lot.getNumCars(d)+", "+street.getNumCars(d);
			
			System.out.println(output);
			logger.println(output);

			// System.out.println(""+count+", "+d.getHours()+":"+d.getMinutes()+", "+lot.getNumCars(d)+", "+street.getNumCars(d));
			// logger.println(""+count+", "+d.getHours()+":"+d.getMinutes()+", "+lot.getNumCars(d)+", "+street.getNumCars(d));
			// System.out.println(stayTimes.getStayTime());
			////a[stayTimes.getStayTime()]++;

			count++;
		}
		/////for (int i = 0; i < a.length; i++)
			////System.out.println(""+i+" "+a[i]);

		logger.close();
	}
    // Calculates time of arrival of next car
    // Takes the previous arrival time, a random number and the average number of cars arriving per minute
    public static Date nextArrival(Date prevArrival, double rand, double rate)
    {
        Date d = new Date();
        long millis = prevArrival.getTime();
        // Adds time until next car (converts from milliseconds to minutes)
        millis += (-Math.log(rand)/rate)*1000*60; // Using algorithm from store queueing model
        d.setTime(millis);
        return d;
    }

	
}
