//Ashley Ritter 130149 and Ben Bachmen
//student's car class 
//holds whether the car belongs to a commuter or a rez student

import java.util.*;

public class studentCar{
	private String type = "";
	private Date arrival;
	private Date departure;

	studentCar(String type, Date arrival, Date departure){
		this.type=type;
		this.arrival = arrival;
		this.departure = departure;
	}

	public Date getArrival(){
		return arrival;
	}

	public Date getDeparture(){
		return departure;
	}

}
