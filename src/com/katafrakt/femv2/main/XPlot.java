package com.katafrakt.femv2.main;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.JPanel;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.models.Model;
import com.katafrakt.femv2.models.Question2;
import com.katafrakt.femv2.models.ThreeElementsBeam;
import com.katafrakt.femv2.models.TwelveElementsBeam;
import com.katafrakt.femv2.models.TwentyOneElementsBeam;

public class XPlot extends JPanel {
	public final int x,y,width,height;
	public final int frame=10;
	public double yMax=380,yMin=-250;
	public double xMax=8400,xMin=0;
	private ModelDetail details;
	
	public XPlot(int x,int y,int width,int height,ModelDetail details){
		this.x=x;
		this.y=y;
		this.width=width;
		this.height=height;
		this.details=details;
		setPreferredSize(new Dimension(width,height));
	}

	@Override
	protected void paintComponent(Graphics arg0) {
		// TODO Auto-generated method stub
		super.paintComponent(arg0);
		arg0.setColor(Color.RED);
		((Graphics2D) arg0).setStroke(new BasicStroke(3));
		arg0.drawLine(0, 0, 0, height);
		arg0.setColor(Color.GREEN);
		((Graphics2D) arg0).setStroke(new BasicStroke(3));
		arg0.drawLine(0, getPixelHeight(0), width, getPixelHeight(0));
		arg0.setColor(Color.BLACK);
		if(Model.currentModel.toString()!="Question2")
			plotGraph(arg0);
	}
	public void plotGraph(Graphics arg0){
		((Graphics2D) arg0).setStroke(new BasicStroke(1));
		int step=10;
		for(int i=0;i<xMax-step;i+=step){
			Element e0=Model.currentModel.getElementFromX(i);
			Element e1=Model.currentModel.getElementFromX(i+step);
			double s0=e0.getTopStress(i-e0.node1.x);
			double s1=e1.getTopStress(i+step-e1.node1.x);
			arg0.drawLine(getPixelLenght(i), getPixelHeight(s0), getPixelLenght(i+step), getPixelHeight(s1));
		}
		double maxStress=0;
		double minStress=0;
		for(int i=0;i<xMax;i+=step){
			if(maxStress<Model.currentModel.getElementFromX(i).getTopStress(i-Model.currentModel.getElementFromX(i).node1.x))
				maxStress=Model.currentModel.getElementFromX(i).getTopStress(i-Model.currentModel.getElementFromX(i).node1.x);
			if(minStress>Model.currentModel.getElementFromX(i).getTopStress(i-Model.currentModel.getElementFromX(i).node1.x))
				minStress=Model.currentModel.getElementFromX(i).getTopStress(i-Model.currentModel.getElementFromX(i).node1.x);
		}
		arg0.drawString((int)maxStress+" N/mm2", 10, getPixelHeight(maxStress));
		arg0.drawString((int)minStress+" N/mm2", 10, getPixelHeight(minStress));
	}
	public int getPixelHeight(double d){
		double r= (d-yMin)/(yMax-yMin);
		return (int)(height-r*height);
	}
	public int getPixelLenght(double d){
		double r= (d-xMin+1)/(xMax-xMin+1);
		return (int)(r*width);
	}
	
}
