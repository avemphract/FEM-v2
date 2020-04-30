package com.katafrakt.femv2.models;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.materials.Material;
import com.katafrakt.femv2.nodes.Node;
import com.katafrakt.femv2.shapes.FilledRectangle;
import com.katafrakt.femv2.shapes.Shape;

public class TwentyOneElementsBeam extends Model {

	@Override
	public void setModel() {
		
		double s1=400;
		Node n1=new Node(this, 0, 0, "N1");
		n1.statQ=true; n1.statX=true; n1.statY=true;
		Node n2=new Node(this, s1, 0, "N2");
		Node n3=new Node(this, s1*2, 0, "N3");
		Node n4=new Node(this, s1*3, 0, "N4");
		Node n5=new Node(this, s1*4, 0, "N5");
		Node n6=new Node(this, s1*5, 0, "N6");
		Node n7=new Node(this, s1*6, 0, "N7");
		Node n8=new Node(this, s1*7, 0, "N8");
		n8.statY=true;
		double s2=420;
		n8.addEffect(1600, -1200, 0);
		n8.addEffect(0, -21*s2/2, -21*Math.pow(s2, 2)/12);
		
		Node t1=new Node(this, s1*7+s2*1, 0, "T1");
		t1.addEffect(0, -21*s2/2,0);
		Node t2=new Node(this, s1*7+s2*2, 0, "T2");
		t2.addEffect(0, -21*s2/2,0);
		Node t3=new Node(this, s1*7+s2*3, 0, "T3");
		t3.addEffect(0, -21*s2/2,0);
		Node t4=new Node(this, s1*7+s2*4, 0, "T4");
		t4.addEffect(0, -21*s2/2,0);
		Node t5=new Node(this, s1*7+s2*5, 0, "T5");
		t5.addEffect(0, -21*s2/2,0);
		Node t6=new Node(this, s1*7+s2*6, 0, "T6");
		t6.addEffect(0, -21*s2/2,0);
		Node t7=new Node(this, s1*7+s2*7, 0, "T7");
		t7.addEffect(0, -21*s2/2,0);
		Node t8=new Node(this, s1*7+s2*8, 0, "T8");
		t8.addEffect(0, -21*s2/2,0);
		Node t9=new Node(this, s1*7+s2*9, 0, "T9");
		t9.addEffect(0, -21*s2/2,0);
		Node t10=new Node(this, s1*7+s2*10, 0, "T10");
		t10.addEffect(0, -21*s2/2,0);
		
		double s3=466;
		Node c1=new Node(this, s1*7+s2*10+s3*1, 0, "C1");
		c1.addEffect(0, -21*s2/2, +21*Math.pow(s2, 2)/12);
		c1.statX=true; c1.statY=true;
		Node c2=new Node(this, s1*7+s2*10+s3*2, 0, "C2");
		Node c3=new Node(this, s1*7+s2*10+s3*3, 0, "C3");
		Node c4=new Node(this, s1*7+s2*10+s3*4, 0, "C4");
		c4.addEffect(0, 0, -420000);

		Shape rect=new FilledRectangle(70,90);
		Element e1=new Element(this,Material.aliminium,rect,n1,n2,"E1");
		Element e2=new Element(this,Material.aliminium,rect,n2,n3,"E2");
		Element e3=new Element(this,Material.aliminium,rect,n3,n4,"E3");
		Element e4=new Element(this,Material.aliminium,rect,n4,n5,"E4");
		Element e5=new Element(this,Material.aliminium,rect,n5,n6,"E5");
		Element e6=new Element(this,Material.aliminium,rect,n6,n7,"E6");
		Element e7=new Element(this,Material.aliminium,rect,n7,n8,"E7");
		
		Element e8=new Element(this,Material.steel,rect,n8,t1,"E8");
		Element e9=new Element(this,Material.steel,rect,t1,t2,"E9");
		Element e10=new Element(this,Material.steel,rect,t2,t3,"E10");
		Element e11=new Element(this,Material.steel,rect,t3,t4,"E11");
		Element e12=new Element(this,Material.steel,rect,t4,t5,"E12");
		Element e13=new Element(this,Material.steel,rect,t5,t6,"E13");
		Element e14=new Element(this,Material.steel,rect,t6,t7,"E14");
		Element e15=new Element(this,Material.steel,rect,t7,t8,"E15");
		Element e16=new Element(this,Material.steel,rect,t8,t9,"E16");
		Element e17=new Element(this,Material.steel,rect,t9,t10,"E17");
		
		Element e18=new Element(this,Material.copper,rect,t10,c1,"E18");
		Element e19=new Element(this,Material.copper,rect,c1,c2,"E19");
		Element e20=new Element(this,Material.copper,rect,c2,c3,"E20");
		Element e21=new Element(this,Material.copper,rect,c3,c4,"E21");

	}
	public String toString() {
		return "TwentyOneElementBeam";
	}

}
