package com.katafrakt.femv2.elements;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;

import com.katafrakt.femv2.main.ModelVisualization;
import com.katafrakt.femv2.materials.Material;
import com.katafrakt.femv2.maths.Polynomial;
import com.katafrakt.femv2.models.Model;
import com.katafrakt.femv2.models.Question2;
import com.katafrakt.femv2.nodes.Node;
import com.katafrakt.femv2.shapes.Shape;

public class Element {
	Model model;
	public int index;
	
	public Material material;
	public Shape shape;
	public Node node1;
	public Node node2;
	public String name;
	
	public double lenght;
	public double angle;
	public double elongation;
	public double stress;
	
	public Polynomial polynome;
	public Polynomial moment;
	
	public Element(Model model,Material material,Shape shape,Node node1,Node node2,String name){
		this.model=model;
		index=model.elementList.size();
		model.elementList.add(this);
		this.material=material;
		this.shape=shape;
		this.name=name;
		this.node1=node1;
		this.node2=node2;
		angle=Math.atan((node2.y-node1.y)/(node2.x-node1.x));
		lenght=Math.pow(Math.pow(node2.x-node1.x,2)+Math.pow(node2.y-node1.y, 2),0.5d);
		//System.out.println("k"+index+"=["+(int)node1.x+":1:"+(int)node2.x+"];");
	}
	public Element(Model model,Material material,Shape shape,Node node1,Node node2){
		this.model=model;
		model.elementList.add(this);
		this.material=material;
		this.shape=shape;
		name=node1.name+node2.name;
		this.node1=node1;
		this.node2=node2;
		angle=Math.atan((node2.y-node1.y)/(node2.x-node1.x));
		lenght=Math.pow(Math.pow(node2.x-node1.x,2)+Math.pow(node2.y-node1.y, 2),0.5d);
	}

	@Override
	public String toString() {
		return "Element ["+node1.name+","+node2.name+"]";
	}

	public void render(Graphics g) {
		Graphics2D g2 = (Graphics2D) g;
	    g2.setStroke(new BasicStroke((int)(6)));
	    if(model instanceof Question2){
	    	g2.setColor(getElementColor());
	    }
	    else
	    	g2.setColor(Color.BLACK);
		g2.drawLine(getPixel(node1.x), getPixel(node1.y), getPixel(node2.x), getPixel(node2.y));
		g2.setColor(Color.BLACK);
		//g2.drawString(node1.name+"-"+node2.name, getPixel(node2.x-(node2.x-node1.x)/2), getPixel(node2.y-(node2.y-node1.y)/2)-10);
		node1.render(g);
		node2.render(g);
	}
	public Color getElementColor(){
		float factorT=(float) (tensileTest());
		float factorB=(float) (bucklingTest());
		float factor;
		if(factorT>factorB)
			factor=factorT;
		else
			factor=factorB;
		Color color;
		if(factor<0.125f)
			color=new Color(factor*8f,1f-factor*8f,0);
		else if(factor<1f)
			color=new Color(1.333f-factor*1/0.75f,0,0);
		else
			color=Color.BLACK;
		return color;
	}
	public int getPixel(double lenght){
		return (int)(lenght*ModelVisualization.scale+ModelVisualization.frame);
	}
	public void setPolynomials(){
		double array[]=new double[4];
		array[3]=2/Math.pow(lenght, 3)*(node1.dy-node2.dy)+1/Math.pow(lenght, 2)*(node1.dq+node2.dq);
		array[2]=-3/Math.pow(lenght, 2)*(node1.dy-node2.dy)-1/lenght*(2*node1.dq+node2.dq);
		array[1]=node1.dq;
		array[0]=node1.dy;
		polynome=new Polynomial(array);
		moment=polynome.getDerivative().getDerivative().product(material.elasticityModul*shape.inertia);
		for(int i=0;i<lenght;i++){
			if(Math.abs(getTopStress(i))>Math.abs(stress))
				stress=getTopStress(i);
		}
		//System.out.println("y"+index+"=k"+index+".*0+"+node2.dx+";");
		//System.out.println("y"+index+"=k"+index+".*0+"+node2.dy+";");

		//System.out.println(name+"   "+stress);
	}
	public double tensileTest(){
		return Math.abs(stress/material.elasticityModul);
	}
	public double bucklingTest(){
		double sigmakare;
		if(node1.statY||node2.statY)
			sigmakare=shape.area*Math.pow(lenght,2)*0.5d/shape.inertia;
		else
			sigmakare=shape.area*Math.pow(lenght,2)*0.25d/shape.inertia;
		double critStress=material.elasticityModul*Math.pow(Math.PI,2)/sigmakare;
		//System.out.print(critStress);
		return Math.abs(stress/critStress);
	}

	public double getTopStress(double d){
		if(d>=0&&d<=lenght){
			double stress= moment.getValue(d)*shape.ySize/shape.inertia/2;
			double itme=(node1.dx-node2.dx)*material.elasticityModul/lenght;
			return stress+itme;
		}
		return -1;
	}

}
