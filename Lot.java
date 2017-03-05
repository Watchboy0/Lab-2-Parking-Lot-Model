import java.util.*;

public class Lot
{
	private int numSpots; // 215
	private studentCar[] parkingSpots;

	public Lot(int numSpots)
	{
		this.numSpots = numSpots;
		this.parkingSpots = new studentCar[numSpots];
	}

	public int getNumSpots()
	{
		return numSpots;
	}

	// Finds the number of empty spots in the lot
	public int getRemainingSpots()
	{
		int remainingSpots = 0;
		// Iterates over array, looking for null spaces
		for (int i = 0; i < parkingSpots.length; i++)
		{
			if (parkingSpots[i] == null)
			{
				remainingSpots++;
			}
		}
		return remainingSpots;
	}

	// Finds the number of taken spots in the lot
	public int getNumCars()
	{
		int numCars = 0;
		// Iterates over array, looking for null spaces
		for (int i = 0; i < parkingSpots.length; i++)
		{
			if (parkingSpots[i] != null)
			{
				numCars++;
			}
		}
		return numCars;
	}	

	public int getNumCars(Date currentTime)
	{
		this.update(currentTime);
		return getNumCars();
	}

	// Checks if any cars would have left before the specified time and removes them
	public void update(Date currentTime)
	{
		for (int i = 0; i < parkingSpots.length; i++)
		{
			if (parkingSpots[i] != null && parkingSpots[i].getDeparture().before(currentTime)) // current time is after leaving time of car
			{
				parkingSpots[i] = null;
			}
		}
	}

	// Returns the index of the first empty spot found in the array
	// returns -1 if no spots found
	public int findEmptySpot()
	{
		for (int i = 0; i < parkingSpots.length; i++)
		{
			if (parkingSpots[i] == null)
			{
				return i;
			}
		}
		return -1;
	}

	// 
	public boolean addCar(studentCar car, Date currentTime)
	{
		// Checks if any cars would have left and removes them
		this.update(currentTime);
		
		// Returns false if no available spaces
		if (this.getRemainingSpots() == 0)
		{
			return false;
		}
		// If spot is found, adds car to array and returns true
		else
		{
			parkingSpots[findEmptySpot()] = car;
			return true;
		}
	}

	public boolean addCar(studentCar car)
	{
		return this.addCar(car, car.getArrival());
	}

	public String toString()
	{
		String returnString = ""+getNumCars()+" cars in the lot, ";
		returnString += ""+getRemainingSpots();
		returnString += " out of "+numSpots+" spots available";

		return returnString;
	}
}