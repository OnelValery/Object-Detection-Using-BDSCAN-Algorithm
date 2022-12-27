/**
 *  
 *  @author Onel Valery Mezil
 *  @Student number 300 260 630
 *  @CSI2510_Devoir_de_programmation_1
 *  @Object_detection_Using_Java_and_DBScan_Algorithm
 */

/*
 *  Classe pour representer un point en 3 dimensions
 *  @param x coordonnee x du point
 *  @param y coordonnee y du point
 *  @param z coordonnee z du point
 */
public class Point3D {
	
	// Variable d'insatnce******************************
	private double x,y,z;
	public int label;   // a cluster label
	
	// Constructeur
	public Point3D(double x, double y, double z) {
		this.x=x;
		this.y=y;
		this.z=z;
		this.label=-1;
		
	}
	/*
	 * Contains the current value of X 
	 */
	public double getX() {
		return this.x;
	}
	/*
	 * Contains the current value of X 
	 */
	public double getY() {
		return this.y;
	}
	/*
	 * Contains the current value of X 
	 */
	public double getZ() {
		return this.z;
	}
	/**
	   * Calculates the distance in between two points using the Pythagorean
	   * theorem  (C ^ 2 = A ^ 2 + B ^ 2 ). 
	   *
	   * @param pointA The first point.
	   * @param pointB The second point.
	   * @return The distance between the two points.
	   */
	public double distance(Point3D pt) {
		 double deltaX = this.getX() - pt.getX();
		 double deltaY = this.getY() - pt.getY();
		 double deltaZ = this.getZ() - pt.getZ();
		    
		 return Math.sqrt((Math.pow(deltaX, 2) + Math.pow(deltaY, 2) + Math.pow(deltaZ, 2)));
	
	}
	

}
