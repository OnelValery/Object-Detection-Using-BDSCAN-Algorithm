
import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  

public class Exp2 {
  
  // reads a csv file of 3D points (rethrow exceptions!)
  public static List<Point3D> read(String filename) throws Exception {
	  
    List<Point3D> points= new ArrayList<Point3D>(); 
	double x,y,z;
	
	Scanner sc = new Scanner(new File(filename));  
	// sets the delimiter pattern to be , or \n \r
	sc.useDelimiter(",|\n|\r");  

	// skipping the first line x y z
	sc.next(); sc.next(); sc.next();
	
	// read points
	while (sc.hasNext())  
	{  
		x= Double.parseDouble(sc.next());
		y= Double.parseDouble(sc.next());
		z= Double.parseDouble(sc.next());
		points.add(new Point3D(x,y,z));  
	}   
	
	sc.close();  //closes the scanner  
	
	return points;
  }
  // Methode to write points in the file
  public static void save(String givenfileName, String filename, List<String> message) {
		
	     try {
	      File csvfile = new File(filename);
	
	       // Creates a PrintWriter
	       PrintWriter output = new PrintWriter(csvfile);
	      
	       output.println("Ce fichier contient les calculs de temps demander pour le ficher "+givenfileName);
	       for (String msg:message) {
	    	   output.println(msg);
	       }
	       // Close the writer
	       output.close();
	     }catch(FileNotFoundException e) {
		    	e.printStackTrace();
		    }
  }
  public static void main(String[] args) throws Exception {  
  
    // not reading args[0]
	double eps= Double.parseDouble(args[1]);
  
    // reads the csv file
    List<Point3D> points= Exp2.read(args[2]);
    
    // read the step parameter
    int stepParam=Integer.parseInt(args[3]);
	
	
	
	
	/*
	 * Experience 2 KDTree
	 */
	
	int count=1;
	double sum=0;
	double startTime;
	double endTime;
	double duration;
	List<String> time= new ArrayList<>();
	
	if (args[0].equals("lin")) {
		// creates the NearestNeighbor instance
		NearestNeighbors nn= new NearestNeighbors(points);
		for(Point3D p: points) {
			//Time calculation with the linear method
			startTime = System.nanoTime();
			nn.rangeQuery(p,eps);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000; // in milliseconds.
			sum+=duration;
			if (count % stepParam ==0) {
			     //store the time calculations inside a list before printing them in a file
				String mgs= "Le temps requis afin de trouver les voisins du "+count+"ieme point est : "+duration+".";
				time.add(mgs);
			}
			count++;
		}
	}
	else if (args[0].equals("kd")) {
		NearestNeighborsKD mm= new NearestNeighborsKD(points);
		for(Point3D p: points) {
			//Time calculation with the KDtree method
			startTime = System.nanoTime();
			mm.rangeQuery(p,eps);
			endTime = System.nanoTime();
			duration = (endTime - startTime)/1000000; // in milliseconds.
			sum+=duration;
			if (count % stepParam ==0) {
				//store the time calculations inside a list before printing them in a file
				String mgs= "Le temps requis afin de trouver les voisins du "+count+" ieme point est : "+duration+".";
				time.add(mgs);
			}
			count++;
		}
	}
	else {
			System.out.println("You have chose a wrong method to do the experiment.");
			System.exit(0);
			}

	//Print out time calculations for the linear method in a files
	String fileName = args[2]+"_time for every "+stepParam+" points_"+args[0]+".txt";
	Exp2.save(args[2],fileName,time );
	System.out.println("The average time to find neighbors from the list od points is: "+ sum/(points.size()));
	
	System.out.println("NB: See the output file named: ' "+ fileName+"+ ' for the compute the time required (in ms) to \r\n"
			+ "find the neighbors of every 10 points in a file, using the eps value 0.5");
	
	
	
	
  }   
}