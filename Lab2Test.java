import java.util.*;
import java.io.*;

public class Lab2Test
{
    public static Date nextArrival(Date prevArrival, double rand, double rate)
    {
        Date d = new Date();
        long millis = prevArrival.getTime();
        millis += (-Math.log(rand)/rate)*1000*60;
        d.setTime(millis);
        return d;
    }

	public static void main(String[] args)
    {
        Lab2Test();
    }

    public static void Lab2Test()
	{
		Lot lot = new Lot(215);
		Street street = new Street();

		System.out.println(lot);

		Date startTime = new Date(117, 1, 16, 6, 0);
		Date startTime2 = new Date(117, 1, 16, 6, 30);

		Date leaveTime = new Date(117, 1, 16, 14, 0);
		Date leaveTime2 = new Date(117, 1, 16, 14, 30);

		studentCar car = new studentCar("resident", startTime, leaveTime);
		for (int i = 0; i < 200; i++)
		{
			System.out.println(i);
			if(!lot.addCar(car))
			{
				street.addCar(car);
			}
		}

		System.out.println(lot);
		System.out.println(street);

		car = new studentCar("resident", startTime2, leaveTime2);
		for (int i = 0; i < 20; i++)
		{
			System.out.println(i);
			if(!lot.addCar(car))
			{
				street.addCar(car);
			}
		}

		System.out.println(lot);
		System.out.println(street);

		Date currentTime = new Date(117, 1, 16, 14, 1);
		lot.update(currentTime);
		street.update(currentTime);

		System.out.println(lot);
		System.out.println(street);

		currentTime = new Date(117, 1, 16, 15, 1);
		lot.update(currentTime);
		street.update(currentTime);

		System.out.println(lot);
		System.out.println(street);

        Random rand = new Random();

        System.out.println(startTime);
        Date d = new Date();
        d = nextArrival(startTime, rand.nextDouble(), 0.5);
        System.out.println(d);
        for(int i = 0; i < 10; i++)
        {
            d = nextArrival(d, rand.nextDouble(), 0.5);
            System.out.println(d);
        }
        //System.out.println(nextArrival(startTime, .5, 2));
	}
}
