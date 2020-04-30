package com.katafrakt.femv2.models;

import java.awt.Color;
import java.awt.Graphics;
import java.util.ArrayList;

import org.apache.commons.math3.linear.Array2DRowRealMatrix;
import org.apache.commons.math3.linear.ArrayRealVector;
import org.apache.commons.math3.linear.DecompositionSolver;
import org.apache.commons.math3.linear.LUDecomposition;
import org.apache.commons.math3.linear.RealMatrix;
import org.apache.commons.math3.linear.RealVector;

import com.katafrakt.femv2.elements.Element;
import com.katafrakt.femv2.main.Main;
import com.katafrakt.femv2.main.ModelVisualization;
import com.katafrakt.femv2.maths.Matrix;
import com.katafrakt.femv2.maths.Vector;
import com.katafrakt.femv2.nodes.Node;
import com.katafrakt.framework.util.Yazdýr;

public abstract class Model {
	public static ArrayList<Model> modelList=new ArrayList<Model>();
	public static Model currentModel;
	
	public Matrix stiffness;
	public Vector forces;
	public Vector displacements;
	
	public ArrayList<Node> nodeList;
	public ArrayList<Element> elementList;
	public Model(){
		currentModel=this;
		modelList.add(this);
		elementList=new ArrayList<Element>();
		nodeList=new ArrayList<Node>();
		setModel();
		createStiffness();
		createForces();
		modifyMatrices();
		solveDisplacement();
		placeDisplacement();
		for(Element e:elementList)
			e.setPolynomials();
		System.out.println();
		
	}
	public abstract void setModel();
	public void createStiffness(){
		double[][] tempStiffness=new double[nodeList.size()*3][nodeList.size()*3];
		for(Element e:elementList){
			double eI=e.material.elasticityModul*e.shape.inertia;
			tempStiffness[e.node1.index*3][e.node1.index*3]+=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node1.index*3+1][e.node1.index*3+1]+=12*eI/Math.pow(e.lenght, 3);
			tempStiffness[e.node1.index*3+1][e.node1.index*3+2]+=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node1.index*3+2][e.node1.index*3+1]+=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node1.index*3+2][e.node1.index*3+2]+=4*eI/e.lenght;
			
			tempStiffness[e.node1.index*3][e.node2.index*3]-=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node1.index*3+1][e.node2.index*3+1]-=12*eI/Math.pow(e.lenght, 3);
			tempStiffness[e.node1.index*3+1][e.node2.index*3+2]+=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node1.index*3+2][e.node2.index*3+1]-=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node1.index*3+2][e.node2.index*3+2]+=2*eI/e.lenght;
			
			tempStiffness[e.node2.index*3][e.node1.index*3]-=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node2.index*3+1][e.node1.index*3+1]-=12*eI/Math.pow(e.lenght, 3);
			tempStiffness[e.node2.index*3+1][e.node1.index*3+2]-=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node2.index*3+2][e.node1.index*3+1]+=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node2.index*3+2][e.node1.index*3+2]+=2*eI/e.lenght;
			
			tempStiffness[e.node2.index*3][e.node2.index*3]+=e.material.elasticityModul*(e.shape.area/e.lenght);
			tempStiffness[e.node2.index*3+1][e.node2.index*3+1]+=12*eI/Math.pow(e.lenght, 3);
			tempStiffness[e.node2.index*3+1][e.node2.index*3+2]-=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node2.index*3+2][e.node2.index*3+1]-=6*eI/Math.pow(e.lenght, 2);
			tempStiffness[e.node2.index*3+2][e.node2.index*3+2]+=4*eI/e.lenght;
			
			
			
			double[][] array=new double[6][6];
			
			array[0][0]+=e.material.elasticityModul*(e.shape.area/e.lenght);
			array[+1][+1]+=12*eI/Math.pow(e.lenght, 3);
			array[+1][+2]+=6*eI/Math.pow(e.lenght, 2);
			array[+2][+1]+=6*eI/Math.pow(e.lenght, 2);
			array[+2][+2]+=4*eI/e.lenght;
			
			array[0][3]-=e.material.elasticityModul*(e.shape.area/e.lenght);
			array[+1][3+1]-=12*eI/Math.pow(e.lenght, 3);
			array[+1][3+2]+=6*eI/Math.pow(e.lenght, 2);
			array[+2][3+1]-=6*eI/Math.pow(e.lenght, 2);
			array[+2][3+2]+=2*eI/e.lenght;
			
			array[3][0]-=e.material.elasticityModul*(e.shape.area/e.lenght);
			array[3+1][+1]-=12*eI/Math.pow(e.lenght, 3);
			array[3+1][+2]-=6*eI/Math.pow(e.lenght, 2);
			array[3+2][+1]+=6*eI/Math.pow(e.lenght, 2);
			array[3+2][+2]+=2*eI/e.lenght;
			
			array[3][3]+=e.material.elasticityModul*(e.shape.area/e.lenght);
			array[3+1][3+1]+=12*eI/Math.pow(e.lenght, 3);
			array[3+1][3+2]-=6*eI/Math.pow(e.lenght, 2);
			array[3+2][3+1]-=6*eI/Math.pow(e.lenght, 2);
			array[3+2][3+2]+=4*eI/e.lenght;

		}
		stiffness=new Matrix(tempStiffness);
	}
	
	public void createForces(){
		double[] tempForces=new double[nodeList.size()*3];
		for(Node n:nodeList){
			tempForces[n.index*3]=n.forceX;
			tempForces[n.index*3+1]=n.forceY;
			tempForces[n.index*3+2]=n.moment;
		}
		forces=new Vector(tempForces);
		
	}
	
	public void modifyMatrices(){
		for(Node n:nodeList){
			if(n.statX){
				stiffness.addElim(3*n.index);
				forces.addElim(3*n.index);
			}
			if(n.statY){
				stiffness.addElim(3*n.index+1);
				forces.addElim(3*n.index+1);
			}
			if(n.statQ){
				stiffness.addElim(3*n.index+2);
				forces.addElim(3*n.index+2);
			}
		}
	}
	
	public void solveDisplacement(){
		RealMatrix coefficient=new Array2DRowRealMatrix(stiffness.array);
		//delta=Maths.getDeterminant(stiffnessMatrix.array);
		DecompositionSolver solver = new LUDecomposition(coefficient).getSolver();
		RealVector constant=new ArrayRealVector(forces.vector);
		RealVector solution = solver.solve(constant);
		displacements=new Vector(solution.toArray());
		
	}
	
	public void placeDisplacement(){
		int k=0;
		for(Node n:nodeList){
			if(!stiffness.eliminated.contains(n.index*3)){
				n.dx=displacements.vector[k];
				k++;
			}
			if(!stiffness.eliminated.contains(n.index*3+1)){
				n.dy=displacements.vector[k];
				k++;
			}
			if(!stiffness.eliminated.contains(n.index*3+2)){
				n.dq=displacements.vector[k];
				k++;
			}
			//System.out.println(n.name+"   "+n.dx+"   "+n.dy+"   "+n.dq);
		}
	}
	public Element getElementFromX(double d){
		for(Element e:elementList){
			if(e.node1.x<=d&&e.node2.x>=d){
				return e;
			}
		}
		return null;
	}
	
	public void render(Graphics g){
	{
		g.setColor(Color.GREEN);
		g.drawLine(ModelVisualization.frame, ModelVisualization.frame, Main.width, ModelVisualization.frame);
		g.setColor(Color.RED);
		g.drawLine(ModelVisualization.frame, ModelVisualization.frame, ModelVisualization.frame,Main.height);
		for(Element e:elementList)
			e.render(g);
	}
	}
}
