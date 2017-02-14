//Ashley Ritter 130149 and Ben Bachmen
//student's car class 
//holds wether the car belongs to a commuter or a rez student

import java.util.*;

public class studentCar{
	private String type = "";
	private Date arrival;
	private Date departure;

	studentCar(String type){
		this.type=type;
	}

	public Date getArrival(){
		return arrival;
	}

	public Date getDeparture(){
		return departure;
	}

}
