import java.util.List;
import java.util.ArrayList;

public class NearestNeighborsKD {
	 protected java.util.List<Point3D> points; 
	  // construct with list of points
	public  KDtree kdTree;
	
	  public NearestNeighborsKD(List<Point3D> list) {
		  this.kdTree = new KDtree();
		  for (Point3D p : list) {
		  kdTree.add(p); // the add method should call the
		  // insert method given in pseudo-code
		   }
		  // plus possibly other initializations
		  
		  }

	 // gets the neighbors of p (at a distance less than eps
	public List<Point3D> rangeQuery(Point3D p, double eps) {
		List<Point3D> neighbors;
		neighbors=new ArrayList<Point3D>();
		kdTree.rangeQuery(p, eps, neighbors, kdTree.root());
		return neighbors;
		
		
	}


	   
		
	   
	  
}
