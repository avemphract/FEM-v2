package com.katafrakt.femv2.main;

import java.awt.BorderLayout;
import java.util.ArrayList;

import javax.swing.JFrame;

import com.katafrakt.femv2.maths.Maths;
import com.katafrakt.femv2.maths.Polynomial;
import com.katafrakt.femv2.models.Question2;
import com.katafrakt.femv2.models.ThreeElementsBeam;
import com.katafrakt.femv2.models.ThreeElementsTimo;
import com.katafrakt.femv2.models.TwelveElementsBeam;
import com.katafrakt.femv2.models.TwelveElementsTimo;
import com.katafrakt.femv2.models.TwentyOneElementsBeam;
import com.katafrakt.femv2.models.TwentyOneElementsTimo;
import com.katafrakt.framework.util.Yazdýr;

public class Main {
	
	public final static int height=800;
	public final static int width=1400;
	
	public static ModelVisualization visual;
	public static ModelDetail detail;
	
	public static ThreeElementsBeam beamA;
	public static TwelveElementsBeam beamB;
	public static TwentyOneElementsBeam beamC;
	public static ThreeElementsTimo timoA;
	public static TwelveElementsTimo timoB;
	public static TwentyOneElementsTimo timoC;
	public static Question2 q2;
	
	public static void main(String[] args){
		JFrame frame = new JFrame("Emre Çatalkaya");
		frame.setSize(width,height);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setResizable(false);
		
		beamA=new ThreeElementsBeam();
		beamB=new TwelveElementsBeam();
		beamC=new TwentyOneElementsBeam();
		
		timoA=new ThreeElementsTimo();
		timoB=new TwelveElementsTimo();
		timoC=new TwentyOneElementsTimo();
		
		/*double[][] array=new double[6][6];
		array[0][0]=1;array[0][1]=2;array[0][2]=4;array[0][3]=5;array[0][4]=6;
		array[1][0]=3;
		
		double[][] brray=new double[6][6];
		brray[0][0]=9;brray[0][1]=8;brray[0][2]=7;brray[1][0]=5;brray[1][1]=6;
		brray[2][0]=1;brray[3][0]=2;brray[4][0]=1;brray[5][0]=1;
		Yazdýr.printArray(Maths.crossProduct(array, brray));*/
		
		q2=new Question2();
		
		visual = new ModelVisualization(800, height);
		frame.add(visual,BorderLayout.WEST);
		
		detail=new ModelDetail(600,height);
		frame.add(detail);
		
		frame.setVisible(true);
	}
	

}