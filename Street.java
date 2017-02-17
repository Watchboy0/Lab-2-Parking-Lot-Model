import java.util.*;

public class Street
{
	// private ArrayList<studentCar> parkingSpots;
	private ArrayList<studentCar> parkingSpots = new ArrayList<studentCar>();


	public Street()
	{
		ArrayList<studentCar> parkingSpots = new ArrayList<studentCar>();
	}

	// Adds a car to the street and removes any cars that would have left
	public void addCar(studentCar car, Date currentTime)
	{
		this.update(currentTime);
		parkingSpots.add(car);
	}

	public void addCar(studentCar car)
	{
		this.addCar(car, car.getArrival());
	}

	// Checks the departure time of each car with the current time and removes any that would have left
	public void update(Date currentTime)
	{
		// parkingSpots.forEach((car) ->
		// {
		// 	if (car.getDeparture().before(currentTime)) // current time is after leaving time of car
		// 	{
		// 		parkingSpots.remove(car);
		// 	}
		// });

		for (Iterator<studentCar> iterator = parkingSpots.iterator(); iterator.hasNext(); )
		{
			studentCar car = iterator.next();
			if (car.getDeparture().before(currentTime))
			{
				iterator.remove();
			}
		}
	}

	// Returns number of cars on street
	public int getNumCars()
	{
		return parkingSpots.size();
	}

	// Firsts checks if any cars have left before returning number of cars parked.
	public int getNumCars(Date currentTime)
	{
		this.update(currentTime);
		return parkingSpots.size();
	}

	public String toString()
	{
		return ""+getNumCars()+" cars on the street";
	}
}