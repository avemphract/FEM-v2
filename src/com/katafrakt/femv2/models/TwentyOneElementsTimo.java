package com.katafrakt.femv2.models;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.maths.Matrix;

public class TwentyOneElementsTimo extends TwentyOneElementsBeam {
	public void createStiffness(){
		double[][] tempStiffness=new double[nodeList.size()*3][nodeList.size()*3];
		for(Element e:elementList){
			double eI=e.material.elasticityModul*e.shape.inertia;
			double b=12*eI/(e.material.shearModulus*e.shape.area*Math.pow(e.lenght, 2));
			double k=eI/(Math.pow(e.lenght, 2)*(1+b));
			tempStiffness[e.node1.index*3][e.node1.index*3]+=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node1.index*3+1][e.node1.index*3+1]+=k*12/e.lenght;
			tempStiffness[e.node1.index*3+1][e.node1.index*3+2]+=6*k;
			tempStiffness[e.node1.index*3+2][e.node1.index*3+1]+=6*k;
			tempStiffness[e.node1.index*3+2][e.node1.index*3+2]+=(4+b)*k*e.lenght;
			
			tempStiffness[e.node1.index*3][e.node2.index*3]-=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node1.index*3+1][e.node2.index*3+1]-=12*k/e.lenght;
			tempStiffness[e.node1.index*3+1][e.node2.index*3+2]+=6*k;
			tempStiffness[e.node1.index*3+2][e.node2.index*3+1]-=6*k;
			tempStiffness[e.node1.index*3+2][e.node2.index*3+2]+=(2-b)*k*e.lenght;
			
			tempStiffness[e.node2.index*3][e.node1.index*3]-=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node2.index*3+1][e.node1.index*3+1]-=12*k/e.lenght;
			tempStiffness[e.node2.index*3+1][e.node1.index*3+2]-=6*k;
			tempStiffness[e.node2.index*3+2][e.node1.index*3+1]+=6*k;
			tempStiffness[e.node2.index*3+2][e.node1.index*3+2]+=(2-b)*k*e.lenght;
			
			tempStiffness[e.node2.index*3][e.node2.index*3]+=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node2.index*3+1][e.node2.index*3+1]+=12*k/e.lenght;
			tempStiffness[e.node2.index*3+1][e.node2.index*3+2]-=6*k;
			tempStiffness[e.node2.index*3+2][e.node2.index*3+1]-=6*k;
			tempStiffness[e.node2.index*3+2][e.node2.index*3+2]+=(4+b)*k*e.lenght;
		}
		stiffness=new Matrix(tempStiffness);
	}
	public String toString() {
		return "TwentyOneElementTimo";
	}
}
