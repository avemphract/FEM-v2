package com.katafrakt.femv2.nodes;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.util.ArrayList;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.main.ModelVisualization;
import com.katafrakt.femv2.models.Model;


public class Node {
	public int nodeSize=22;
	
	public Model model;
	ArrayList<Element> elements;
	public int index;
	
	public double x;
	public boolean statX;
	public double dx;
	public double forceX;
	
	public double y;
	public boolean statY;
	public double dy;
	public double forceY;
	
	public double q;
	public boolean statQ;
	public double dq;
	public double moment;
	public String name;
	
	public Node(Model model,double x,double y, String name){
		elements=new ArrayList<Element>();
		this.model=model;
		index=model.nodeList.size();
		model.nodeList.add(this);
		this.x=x;
		this.y=y;
		this.name=name;
		
	}
	public void addEffect(double forceX,double forceY,double moment) {
		this.forceX+=forceX;
		this.forceY+=forceY;
		this.moment+=moment;
	}
	public double getElementForceX(Element el){
		ArrayList<Element> temp=(ArrayList<Element>)elements.clone();
		temp.remove(el);
		double nodeForce=0;
		if(temp.size()!=0)
			for(Element e:temp){
				
			}
		return nodeForce;
	}
	
	@Override
	public String toString() {
		return "Node [" + name + "]";
	}
	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke(3));
		g2.setColor(Color.BLACK);
		g2.drawOval(getPixel(x)-nodeSize/2, getPixel(y)-nodeSize/2, nodeSize, nodeSize);
		g2.setColor(Color.LIGHT_GRAY);
		g2.fillOval(getPixel(x)-nodeSize/2+2, getPixel(y)-nodeSize/2+2, nodeSize-4, nodeSize-4);
		if(statX==true){
			g2.setColor(Color.WHITE);
			g2.drawLine(getPixel(x), getPixel(y)-35, getPixel(x), getPixel(y)+35);
		}
		if(statY==true){
			g2.setColor(Color.WHITE);
			g2.drawLine(getPixel(x)-35, getPixel(y), getPixel(x)+35, getPixel(y));
		}
		if(statQ==true){
			g2.setColor(Color.WHITE);
			g2.drawOval(getPixel(x)-nodeSize/2-5, getPixel(x)-nodeSize/2-5,nodeSize+10,nodeSize+10);
		}
		if(forceX!=0||forceY!=00){
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.CYAN);
			g2.drawString((int)(Math.pow(Math.pow(forceX, 2)+Math.pow(forceY,2), 0.5d)/1000)+" kN", getPixel(x)+5, getPixel(y)-25);
			g2.drawLine(getPixel(x), getPixel(y)-50, getPixel(x), getPixel(y));
			g2.fillOval(getPixel(x)-5, getPixel(y)-5, 10, 10);
		}
		if(moment>0){
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.MAGENTA);
			g2.drawOval(getPixel(x)-15, getPixel(y)-15, 30, 30);
			g2.fillOval(getPixel(x)-5, getPixel(y)-5, 10, 10);
			g2.drawString((int)moment+"Nmm", getPixel(x)-40, getPixel(y)+40);
		}
		if(moment<0){
			g2.setStroke(new BasicStroke(3));
			g2.setColor(Color.MAGENTA);
			g2.drawOval(getPixel(x)-15, getPixel(y)-15, 30, 30);
			g2.drawLine(getPixel(x)-10, getPixel(y)-10, getPixel(x)+10, getPixel(y)+10);
			g2.drawLine(getPixel(x)-10, getPixel(y)+10, getPixel(x)+10, getPixel(y)-10);
			g2.drawString((int)moment+"Nmm", getPixel(x)-40, getPixel(y)+40);
		}
		g2.setColor(Color.BLACK);
		g2.drawString(name,getPixel(x)-4,getPixel(y)-15);
	}
	public int getPixel(double lenght){
		return (int)(lenght*ModelVisualization.scale+ModelVisualization.frame);
	}
	public static double getMaxX(Model model){
		double x=0;
		for(Node nod:model.nodeList){
			if(nod.x>x)
				x=nod.x;
		}
		return x;
	}
	public static double getMaxY(Model model){
		double y=0;
		for(Node nod:model.nodeList){
			if(nod.y>y)
				y=nod.y;
		}
		return y;
		
	}
}
