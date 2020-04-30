package com.katafrakt.femv2.models;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.materials.Material;
import com.katafrakt.femv2.maths.Maths;
import com.katafrakt.femv2.maths.Matrix;
import com.katafrakt.femv2.nodes.Node;
import com.katafrakt.femv2.shapes.Circle;
import com.katafrakt.femv2.shapes.Shape;
import com.katafrakt.framework.util.Yazdýr;


public class Question2 extends Model {

	
	final double t=1000;
	public void setModel(){
		Material st=Material.steel;
		
		Node U=new Node(this,0, 0,"U");
		U.statX=true;
		U.statY=true;
		//U.statQ=true;
		Node N=new Node(this,0,10*t,"N");
		Node O=new Node(this,0,12.5f*t,"O");
		Node A=new Node(this,0,15*t,"A");
		
		Node M=new Node(this,4*t,10*t,"M");
		Node P=new Node(this,4*t,12.5f*t,"P");
		Node B=new Node(this,4*t,15*t,"B");
		
		Node L=new Node(this,8*t,10*t,"C");
		L.addEffect(0, -5*t,0);
		Node Q=new Node(this,8*t,12.5f*t,"Q");
		Node C=new Node(this,8*t,15*t,"L");
		
		Node K=new Node(this,12*t,10*t,"K");
		K.addEffect(0, -10*t,0);
		Node D=new Node(this,12*t,15*t,"D");
		
		Node J=new Node(this,16*t,10*t,"J");
		J.addEffect(0, -20*t,0);
		Node R=new Node(this,16*t,12.5f*t,"R");
		Node E=new Node(this,16*t,15*t,"E");
		
		Node I=new Node(this,20*t,10*t,"I");
		Node S=new Node(this,20*t,12.5f*t,"S");
		Node F=new Node(this,20*t,15*t,"F");
		
		Node V=new Node(this,24*t,0,"V");
		V.statY=true;
		Node H=new Node(this,24*t,10*t,"H");
		Node T=new Node(this,24*t,12.5f*t,"T");
		Node G=new Node(this,24*t,15*t,"G");
		
		Shape big=new Circle(80,100);
		Shape sma=new Circle(70,60);
		
		Element e1=new Element(this,Material.steel,big,U, N);
		Element e2=new Element(this,Material.steel,big,U, M);
		
		Element e3=new Element(this,Material.steel,sma,N, O);
		Element e4=new Element(this,Material.steel,sma,O, A) ;

		Element e6=new Element(this,Material.steel,sma,N, M) ;
		Element e7=new Element(this,Material.steel,sma,O, M) ;
		Element e8=new Element(this,Material.steel,sma,O, B) ;	
		Element e9=new Element(this,Material.steel,sma,A, B) ;

		Element e10=new Element(this,Material.steel,sma,M, P);
		Element e11=new Element(this,Material.steel,sma,P, B);

		Element e12=new Element(this,Material.steel,sma,M, L);
		Element e13=new Element(this,Material.steel,sma,P, L);
		Element e14=new Element(this,Material.steel,sma,P, C);
		Element e15=new Element(this,Material.steel,sma,B, C);

		Element e16=new Element(this,Material.steel,sma,L, Q);
		Element e17=new Element(this,Material.steel,sma,Q, C);

		Element e18=new Element(this,Material.steel,sma,L, K);
		Element e19=new Element(this,Material.steel,sma,Q, K);
		Element e20=new Element(this,Material.steel,sma,Q, D);
		Element e21=new Element(this,Material.steel,sma,C, D);
		
		Element e22=new Element(this,Material.steel,sma,K, J);
		Element e23=new Element(this,Material.steel,sma,K, R);
		Element e24=new Element(this,Material.steel,sma,D, R);
		Element e25=new Element(this,Material.steel,sma,D, E);
		
		Element ee=new Element(this,Material.steel,sma,K,D);
		
		Element e26=new Element(this,Material.steel,sma,J, R);
		Element e27=new Element(this,Material.steel,sma,R, E);
		
		Element e28=new Element(this,Material.steel,sma,J, I);
		Element e29=new Element(this,Material.steel,sma,J, S);
		Element e30=new Element(this,Material.steel,sma,E, S);
		Element e31=new Element(this,Material.steel,sma,E, F);
		
		Element e32=new Element(this,Material.steel,sma,I, S);
		Element e33=new Element(this,Material.steel,sma,S, F);
		
		Element e34=new Element(this,Material.steel,sma,I, H);
		Element e35=new Element(this,Material.steel,sma,I, T);
		Element e36=new Element(this,Material.steel,sma,F, T);
		Element e37=new Element(this,Material.steel,sma,F, G);
		
		Element e38=new Element(this,Material.steel,sma,H, T);
		Element e39=new Element(this,Material.steel,sma,T, G);
		
		Element e40=new Element(this,Material.steel,big,I, V);
		Element e41=new Element(this,Material.steel,big,V, H);
	}
	
	
	@Override
	public void createStiffness() {
		double[][] tempStiffness=new double[nodeList.size()*3][nodeList.size()*3];
		for(Element e:elementList){
			double eI=e.material.elasticityModul*e.shape.inertia;
			double[][] array=new double[6][6];
			array[0][0]=e.material.elasticityModul*(e.shape.area/e.lenght);
			array[1][1]=12*eI/Math.pow(e.lenght, 3);
			array[1][2]=6*eI/Math.pow(e.lenght, 2);
			array[2][1]=6*eI/Math.pow(e.lenght, 2);
			array[2][2]=4*eI/e.lenght;
					
			array[3][0]=-e.material.elasticityModul*(e.shape.area/e.lenght);
			array[4][1]=-12*eI/Math.pow(e.lenght, 3);
			array[4][2]=6*eI/Math.pow(e.lenght, 2);
			array[5][1]=-6*eI/Math.pow(e.lenght, 2);
			array[5][2]=2*eI/e.lenght;
			
			array[0][3]=-e.material.elasticityModul*(e.shape.area/e.lenght);
			array[1][4]=-12*eI/Math.pow(e.lenght, 3);
			array[1][5]=6*eI/Math.pow(e.lenght, 2);
			array[2][4]=-6*eI/Math.pow(e.lenght, 2);
			array[2][5]=2*eI/e.lenght;
			
			array[3][3]=e.material.elasticityModul*(e.shape.area/e.lenght);
			array[4][4]=12*eI/Math.pow(e.lenght, 3);
			array[4][5]=-6*eI/Math.pow(e.lenght, 2);
			array[5][4]=-6*eI/Math.pow(e.lenght, 2);
			array[5][5]=4*eI/e.lenght;
			
			double[][] temparray=Maths.crossProduct(Maths.dof6RotationMatrixI(e.angle), array);
			double[][] last=Maths.crossProduct(temparray, Maths.dof6RotationMatrixF(e.angle));
			
			//System.out.println(e.node1.index+" "+(e.node1.index+1)+" "+(e.node1.index+2)+" "+e.node2.index+" "+(e.node2.index+1)+" "+(e.node2.index+2)+"");
			
			tempStiffness[e.node1.index*3][e.node1.index*3]+=last[0][0];
			tempStiffness[e.node1.index*3+1][e.node1.index*3+1]+=last[1][1];
			tempStiffness[e.node1.index*3+1][e.node1.index*3+2]+=last[1][2];
			tempStiffness[e.node1.index*3+2][e.node1.index*3+1]+=last[2][1];
			tempStiffness[e.node1.index*3+2][e.node1.index*3+2]+=last[2][2];
			
			tempStiffness[e.node1.index*3][e.node2.index*3]+=last[0][3];
			tempStiffness[e.node1.index*3+1][e.node2.index*3+1]+=last[1][4];
			tempStiffness[e.node1.index*3+1][e.node2.index*3+2]+=last[1][5];
			tempStiffness[e.node1.index*3+2][e.node2.index*3+1]+=last[2][4];
			tempStiffness[e.node1.index*3+2][e.node2.index*3+2]+=last[2][5];
			
			tempStiffness[e.node2.index*3][e.node1.index*3]+=last[3][0];
			tempStiffness[e.node2.index*3+1][e.node1.index*3+1]+=last[4][1];
			tempStiffness[e.node2.index*3+1][e.node1.index*3+2]+=last[4][2];
			tempStiffness[e.node2.index*3+2][e.node1.index*3+1]+=last[5][1];
			tempStiffness[e.node2.index*3+2][e.node1.index*3+2]+=last[5][2];
			
			tempStiffness[e.node2.index*3][e.node2.index*3]+=last[3][3];
			tempStiffness[e.node2.index*3+1][e.node2.index*3+1]+=last[4][4];
			tempStiffness[e.node2.index*3+1][e.node2.index*3+2]+=last[4][5];
			tempStiffness[e.node2.index*3+2][e.node2.index*3+1]+=last[5][4];
			tempStiffness[e.node2.index*3+2][e.node2.index*3+2]+=last[5][5];
			
			//Yazdýr.printArray(last);
			
		}
		stiffness=new Matrix(tempStiffness);
	}


	@Override
	public String toString() {
		return "Question2";
	}
	
}
