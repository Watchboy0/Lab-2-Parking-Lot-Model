import java.util.*;
import java.io.*;

public class Lab2Test
{
	public static void main(String[] args)
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
	}
}