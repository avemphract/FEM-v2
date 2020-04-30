package com.katafrakt.femv2.models;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.materials.Material;
import com.katafrakt.femv2.nodes.Node;
import com.katafrakt.femv2.shapes.FilledRectangle;
import com.katafrakt.femv2.shapes.Shape;

public class TwelveElementsBeam extends Model {

	@Override
	public void setModel() {
		// TODO Auto-generated method stub
		double l=700;
		Node n1=new Node(this, 0, 0, "N1");
		n1.statX=true;
		n1.statY=true;
		n1.statQ=true;
		Node n2=new Node(this, l, 0, "N2");
		Node n3=new Node(this, l*2, 0, "N3");
		Node n4=new Node(this, l*3, 0, "N4");
		
		Node n5=new Node(this, l*4, 0, "N5");
		n5.statY=true;
		n5.addEffect(1600, -1200, 0);
		n5.addEffect(0, -21*700/2, -21*Math.pow(700, 2)/12);
		Node n6=new Node(this, l*5, 0, "N6");
		n6.addEffect(0, -21*700/2,0);
		Node n7=new Node(this, l*6, 0, "N7");
		n7.addEffect(0, -21*700/2,0);
		Node n8=new Node(this, l*7, 0, "N8");
		n8.addEffect(0, -21*700/2,0);
		Node n9=new Node(this, l*8, 0, "N9");
		n9.addEffect(0, -21*700/2,0);
		Node n10=new Node(this, l*9, 0, "N10");
		n10.addEffect(0, -21*700/2,0);
		Node n11=new Node(this, l*10, 0, "N11");
		n11.addEffect(0, -21*700/2, 21*Math.pow(700, 2)/12);
		n11.statX=true;
		n11.statY=true;
		Node n12=new Node(this, l*11, 0, "N12");
		Node n13=new Node(this, l*12, 0, "N13");
		n13.addEffect(0, 0, -420000);
		
		Shape rect=new FilledRectangle(70,90);
		Element e1=new Element(this,Material.aliminium,rect,n1,n2,"E1");
		Element e2=new Element(this,Material.aliminium,rect,n2,n3,"E3");
		Element e3=new Element(this,Material.aliminium,rect,n3,n4,"E4");
		Element e4=new Element(this,Material.aliminium,rect,n4,n5,"E5");

		Element e5=new Element(this,Material.steel,rect,n5,n6,"E6");
		Element e6=new Element(this,Material.steel,rect,n6,n7,"E7");
		Element e7=new Element(this,Material.steel,rect,n7,n8,"E8");
		Element e8=new Element(this,Material.steel,rect,n8,n9,"E9");
		Element e9=new Element(this,Material.steel,rect,n9,n10,"E10");
		Element e10=new Element(this,Material.steel,rect,n10,n11,"E11");

		Element e11=new Element(this,Material.copper,rect,n11,n12,"E11");
		Element e12=new Element(this,Material.copper,rect,n12,n13,"E11");
	}
	@Override
	public String toString() {
		return "TwelveElementBeam";
	}

}
