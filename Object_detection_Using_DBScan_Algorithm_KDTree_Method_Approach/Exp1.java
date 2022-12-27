
import java.util.List;
import java.util.ArrayList;

import java.io.*;  
import java.util.Scanner;  

public class Exp1 {
  
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
  public static void save(String filename, List<Point3D> neighbors) {
		
	     try {
	      File csvfile = new File(filename);
	
	       // Creates a PrintWriter
	       PrintWriter output = new PrintWriter(csvfile);
	      
	       output.println("x"+","+"y"+","+"z");
	       for (Point3D pt:neighbors) {
	    	   output.println(pt.toString());
	       }
	       // Close the writer
	       output.close();
	     
	     }catch(FileNotFoundException e) {
		    	e.printStackTrace();
		    }
}
  
  public static void main(String[] args) throws Exception {  
	  
	  String Categorie=args[0];
  
    // not reading args[0]
	double eps= Double.parseDouble(args[1]);
  
    // reads the csv file
    List<Point3D> points= Exp1.read(args[2]);
	
	Point3D query= new Point3D(Double.parseDouble(args[3]),
								Double.parseDouble(args[4]),
								Double.parseDouble(args[5]));
	
	List<Point3D> neighbors=new ArrayList<Point3D>();
	// creates the NearestNeighbor instance
	if (args[0].equals("lin")) {
		NearestNeighbors nn= new NearestNeighbors(points);
		neighbors= nn.rangeQuery(query,eps);
		
		
		// Print out the neighbors for the linear methode in a txt file
		String fileName ="pt_lin.txt";
		Exp1.save(fileName, neighbors);
	}
	else if (args[0].equals("kd")) {
		// creates the NearestNeighborKD instance
		NearestNeighborsKD mm= new NearestNeighborsKD(points);
		 neighbors= mm.rangeQuery(query,eps);
		
		// Print out the neighbors for the KD methode in a txt file
		String fileNameKD ="pt_kd.txt";
		Exp1.save(fileNameKD, neighbors);
	}
	else {
		
	}
    
	System.out.println("The number of neighbors= "+neighbors.size());
	System.out.println("Here's the list of found neighbors: ");
	for (Point3D p:neighbors) {
		System.out.println(p.toString());
	}
	
	




  }  
}
