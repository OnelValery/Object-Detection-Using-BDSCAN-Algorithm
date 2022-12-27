/**
 *  @author Onel Valery Mezil
 *  @Student number 300 260 630
 *  @CSI2510_Devoir_de_programmation_1
 *  @Object_detection_Using_Java_and_DBScan_Algorithm
 */
import java.util.*;

/**
 * Cette classe permet de trouver les voisins d'un point dans la region interne du cercle
 * de rayon epsilone
 */

    /*
     * Constructeur
     * @param newList
     */
	public class NearestNeighbors {
		private List<Point3D> myList;
		public NearestNeighbors(List<Point3D> newList) {
			

			this.myList=newList;
			
		}
		
	/*
	 * Cette methode trouve les voisins du d'un point p
	 * @param p
	 * @param eps
	 * @return  une liste de point se situant a une distance eps ou moins du point recu en parametre
	 */
	public List<Point3D> rangeQuery( Point3D p,double eps){
		List<Point3D> newList;
		newList=new ArrayList<Point3D>();
	
		for(int i=0;i<myList.size();i++) {
			if(p.distance(myList.get(i))<=eps) {
				newList.add(myList.get(i));
			}
		}return newList;
	}
		
}




