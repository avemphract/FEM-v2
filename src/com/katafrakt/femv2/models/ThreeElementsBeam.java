package com.katafrakt.femv2.models;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.materials.Material;
import com.katafrakt.femv2.nodes.Node;
import com.katafrakt.femv2.shapes.FilledRectangle;
import com.katafrakt.femv2.shapes.Shape;

public class ThreeElementsBeam extends Model {

	@Override
	public void setModel() {
		double l=1400;
		Node node1=new Node(this, 0, 0, "N1");
		node1.statX=true;
		node1.statY=true;
		node1.statQ=true;
		
		Node node2=new Node(this,2*l,0,"N2");
		node2.statY=true;
		node2.addEffect(1600, -1200, 0);
		node2.addEffect(0,-21*(3*1400)/2,-21*Math.pow(3*1400, 2)/12);
		
		Node node3=new Node(this,5*l,0,"N3");
		node3.statX=true;
		node3.statY=true;
		node3.addEffect(0,-21*(3*1400)/2,21*Math.pow(3*1400, 2)/12);
		
		Node node4=new Node(this,6*l,0,"N4");
		node4.addEffect(0, 0, -420000);
		
		Shape rect=new FilledRectangle(70,90);
		
		Element e1=new Element(this,Material.aliminium,rect,node1,node2,"E1");
		Element e2=new Element(this,Material.steel,rect,node2,node3,"E2");
		Element e3=new Element(this,Material.copper,rect,node3,node4,"E3");
	}

	@Override
	public String toString() {
		return "ThreeElementBeam";
	}
	

}
