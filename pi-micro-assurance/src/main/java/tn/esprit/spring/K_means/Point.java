package tn.esprit.spring.K_means;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import tn.esprit.spring.dao.entities.Insured;
import tn.esprit.spring.dao.entities.Segment;
 
public class Point {
 
    private double x ;
    private double y ;
    private double z ;
    private double u ;
    private double v ;
    private int cluster_number = 0;

    
    
    public Point(){} 
    
    public void InsuredToPoint(Insured ind){
    	
    	this.x=ind.getAge()*2;
    	this.y=ind.getSinsterNumber()*10;
    	switch(ind.getGender()){
		case F:
			this.z=1;
			break;
		case M:
			this.z=4;
			break;
		case O:
			this.z=8;
			break;
		default:
			this.z=0;
			break;
    	}
    	this.u=ind.getIncome()*2;
    	this.v=ind.getHealthStatus()*10;
    	
    	//return null;
    }
    public Point(double x,double y,double z,double u,double v)
    {
        this.setX(x);
        this.setY(y);
        this.setZ(z);
        this.setU(u);
        this.setV(v);
       
    }
    
    public void setX(double x) {
        this.x = x;
    }
    
    public double getX()  {
        return this.x;
    }
    
    public void setY(double y) {
        this.y = y;
    }
    
    public double getY() {
        return this.y;
    }
    
    public void setCluster(int n) {
    	
        this.cluster_number = n;
    }
    
    public int getCluster() {
        return this.cluster_number;
    }
    
    
    public double getZ() {
		return z;
	}

	public void setZ(double z) {
		this.z = z;
	}

	public double getU() {
		return u;
	}

	public void setU(double u) {
		this.u = u;
	}

	public double getV() {
		return v;
	}

	public void setV(double v) {
		this.v = v;
	}

	

	
    protected static double distance(Point p, Point centroid) {
        return Math.sqrt(Math.pow((centroid.getY() - p.getY()), 2) + Math.pow((centroid.getX() - p.getX()), 2)+ Math.pow((centroid.getZ() - p.getZ()), 2)+ Math.pow((centroid.getU() - p.getU()), 2)+ Math.pow((centroid.getV() - p.getV()), 2));
    }
    
    
    protected static Point createRandomPoint(int min, int max) {
    	Random r = new Random();
    	double x = min + (max - min) * r.nextDouble();
    	double y = min + (max - min) * r.nextDouble();
    	double z = min + (max - min) * r.nextDouble();
    	double u = min + (max - min) * r.nextDouble();
    	double v = min + (max - min) * r.nextDouble();
    	return new Point(x,y, z, u, v);
    }
    
    protected static List<Point> createRandomPoints(int min, int max, int number) {
    	List<Point> points = new ArrayList<Point>(number);
    	for(int i = 0; i < number; i++) {
    		points.add(createRandomPoint(min,max));
    	}
    	return points;
    }
    
}