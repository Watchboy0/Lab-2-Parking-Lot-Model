<<<<<<< HEAD
//Ashley Ritter and Ben Bachmen
//parking lot model
//CMPT440 lab2
=======
>>>>>>> 0ae3cd6cc748c8a579b7b939b20d9123cf1471cc

import java.util.*;
import java.io.*;


public class lab2{
	int spots=0;
	int rez=0;
	int commuters=0;
	public static void main(String[] args)  throws IOException{
		System.out.println(args.length);
		if(args.length==1){
			String input = args[0];

			lab2(input);
		}
	}
	public static void lab2(String input)throws IOException{
		int spots=0;
		int rez=0;
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
					System.out.println("commuters");
				}
				else if(value[0].equals("rez")){
					rez = Integer.parseInt(value[1]);

				}
				else if(value[0].equals("spots")){
					spots= Integer.parseInt(value[1]);

				}
				line=br.readLine();
			}
		}
		catch (IOException e){
			e.printStackTrace();
		}
<<<<<<< HEAD

		System.out.println("res: "+rez+" commuters: "+commuters+" spots: "+spots);

		//time management

		
	}

	
}
=======
		
		System.out.println("res: "+rez+" commuters: "+commuters+" spots: "+spots);
	}

	
}
>>>>>>> 0ae3cd6cc748c8a579b7b939b20d9123cf1471cc
