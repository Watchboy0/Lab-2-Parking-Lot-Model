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

	// Checks if any cars would have left before the specified time and removes them
	public void update(Date currentTime)
	{
		for (int i = 0; i < parkingSpots.length; i++)
		{
			if (parkingSpots[i].getDeparture().before(currentTime)) // current time is after leaving time of car
			{
				parkingSpots[i] = null;
			}
		}
	}

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

	public boolean addCar(studentCar car, Date currentTime)
	{
		this.update(currentTime);
		if (this.getRemainingSpots() == 0)
		{
			return false;
		}
		else
		{
			parkingSpots[findEmptySpot()] = car;
			return true;
		}
	}

	public String toString()
	{
		String returnString = ""+getRemainingSpots();
		returnString += " out of "+numSpots+" spots available";

		return returnString;
	}
}