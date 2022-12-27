import java.util.*;
public class KDtree {
	private final int DIM=3;
	
	// The KDnode Class
	public class KDnode {
		 
		public Point3D point;
		public int axis;
		public double value;
		public KDnode left;
		public KDnode right;
		public KDnode(Point3D pt, int axis) { 
		 this.point= pt;
		 this.axis= axis;
		 this.value= pt.get(axis);
		 left= right= null;
		}
		 }
		 private KDnode root; 
		 // construct empty tree
		 public KDtree() {
		 
		root= null;
		 }
		 
		 public KDnode root() {
			 return this.root;
		 }
		 
		 /*
		  * Add a point o the KDtree
		  * @param un point Point3D
		  */
		 public void add(Point3D pt) {
			   
			 if (this.root==null)
				 root=insert (pt,root,0);
			 else
				 insert (pt,root,0);
				 
			 
		 }
		 
		 /*
		  * This methode find the right position to add a point to the KDtree 
		  * @param un point Point3D, un KDnode et un entier axis
		  * @return un noeud node
		  */
		 public KDnode insert(Point3D p,  KDnode node, int axis) {
			 if (node==null) {
				 node=new KDnode(p,axis);
			    }
			 else if (p.get(axis)< node.value)
				 node.left=insert(p, node.left,(axis+1)% DIM);
			 else
				 node.right = insert(p,node.right,(axis+1)%DIM);
			 return node;
		 }
		 /*
		  * This methode find find the neighbors using the KDtree 
		  * @param un point Point3D, a double eps, a KDnode and a list.
		  * 
		  */
		 
		public void rangeQuery(Point3D P, double eps ,List<Point3D> N, KDnode node) {
			 if (node == null)
			     return ;
			 if (P.distance(node.point) < eps)
			     N.add(node.point);
			 if ((P.get(node.axis)-eps) <= node.value)
			      rangeQuery(P, eps, N, node.left);
			 if (P.get(node.axis) + eps > node.value)
			      rangeQuery(P, eps, N, node.right);   
			 return ;
		}

}
