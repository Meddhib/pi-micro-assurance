package tn.esprit.spring.K_means;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tn.esprit.spring.dao.entities.Insured;
 
public class KMeans {
 
    private int NUM_CLUSTERS = 6;    
    private int NUM_POINTS ;
    private List<Point> points;
    private List<Cluster> clusters;
    
    public KMeans() {
    	this.points = new ArrayList<Point>();
    	this.clusters = new ArrayList<Cluster>();
    	this.NUM_POINTS=points.size();
    }
    
    public static void mainfonction(List<Insured> li) {
    	
    	KMeans kmeans = new KMeans();
    	List<Point> list =new ArrayList<Point>(kmeans.init(li));
    	kmeans.calculate();
    	Point current=kmeans.points.get(0);
    	int i=1;
    	for(Point p : list ){
    		
    		if (p.getCluster()==current.getCluster())
    			li.get(0).setSegment(li.get(i).getSegment());
    		i++;
    	}
    	
    }
    
    //initialization de processus
    public List<Point> init(List<Insured> li) {
    	List<Point> listpo=new ArrayList<Point>() ;
    	for (Insured i:li){
    		Point p = new Point();
    		p.InsuredToPoint(i);
    		listpo.add(p);
    	}
    	for (int i = 0; i < NUM_CLUSTERS; i++) {
    		Random rand = new Random();
    		Cluster cluster = new Cluster(i);
    		Point centroid =listpo.get(rand.nextInt(listpo.size()));
    		cluster.setCentroid(centroid);
    		clusters.add(cluster);
    	}
    	return listpo;
    }

    
    public void calculate() {
        boolean finish = false;
        int iter = 0;
         
        while(!finish) {
        	
        	clearClusters();
        	
        	List<Point> lastCentroids = getCentroids();
        	
        	assignCluster();
     
        	calculateCentroids();
        	
        	iter++;
        	
        	List<Point> currentCentroids = getCentroids();
        	double distance = 0;
        	//double counter;
        	for(int i = 0; i<lastCentroids.size(); i++) {
        		distance += Point.distance(lastCentroids.get(i),currentCentroids.get(i));
        	}
        
       
        	if((distance == 0)||(iter==25)) {
        		finish = true;
        	}
        }
    }
    
    private void clearClusters() {
    	for(Cluster cluster : clusters) {
    		cluster.clear();
    	}
    }
    
    private List<Point> getCentroids() {
    	List<Point> centroids = new ArrayList<Point>(NUM_CLUSTERS);
    	for(Cluster cluster : clusters) {
    		Point aux = cluster.getCentroid();
    		Point point = new Point(aux.getX(),aux.getY(),aux.getZ(),aux.getU(),aux.getV());
    		centroids.add(point);
    	}
    	return centroids;
    }
    
    private void assignCluster() {
        double max = Double.MAX_VALUE;
        double min = max; 
        int cluster = 0;                 
        double distance = 0.0; 
        
        for(Point point : points) {
        	min = max;
            for(int i = 0; i <NUM_CLUSTERS; i++) {
            	Cluster c = clusters.get(i);
                distance = Point.distance(point, c.getCentroid());
                if(distance < min){
                    min = distance;
                    cluster = i;
                }
            }
            point.setCluster(cluster);
            clusters.get(cluster).addPoint(point);
        }
    }
    
    private void calculateCentroids() {
        for(Cluster cluster : clusters) {
            double sumX = 0;
            double sumY = 0;
            double sumZ = 0;
            double sumU = 0;
            double sumV = 0;
            List<Point> list = cluster.getPoints();
            int n_points = list.size();
            
            for(Point point : list) {
            	sumX += point.getX();
                sumY += point.getY();
                sumZ += point.getZ();
                sumU += point.getU();
                sumV += point.getV();
            }
            
            Point centroid = cluster.getCentroid();
            if(n_points> 0) {
            	double newX = sumX / n_points;
            	double newY = sumY / n_points;
            	double newZ = sumZ / n_points;
            	double newU = sumU / n_points;
            	double newV = sumV / n_points;
                centroid.setX(newX);
                centroid.setY(newY);
                centroid.setZ(newZ);
                centroid.setU(newU);
                centroid.setV(newV);
            }
        }
    }
}