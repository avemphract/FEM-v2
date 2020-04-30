package com.katafrakt.femv2.maths;

public class Maths {
	public static double[][] crossProduct(double[][] array1,double[][] array2){
		double[][] result=new double[array1[0].length][array1[0].length];
		for(int k=0;k<array1[0].length;k++)
			for(int i=0;i<array1[0].length;i++)
				for(int j=0;j<array1[0].length;j++){
					result[k][i]+=array1[k][j]*array2[j][i];
				}
		return result;
	}
	public static double[][] dof6RotationMatrixF(double a){
		double[][] result=new double[6][6];
		result[0][0]= Math.cos(a);
		result[0][1]= Math.sin(a);
		result[1][0]= -Math.sin(a);
		result[1][1]= Math.cos(a);
		result[2][2]=1;
		
		result[3][3]= Math.cos(a);
		result[3][4]= Math.sin(a);
		result[4][3]= -Math.sin(a);
		result[4][4]= Math.cos(a);
		result[5][5]=1;
		return result;
	}
	public static double[][] dof6RotationMatrixI(double a){
		
		double[][] result=new double[6][6];
		result[0][0]= Math.cos(a);
		result[0][1]= -Math.sin(a);
		result[1][0]= Math.sin(a);
		result[1][1]= Math.cos(a);
		result[2][2]=1;
		
		result[3][3]= Math.cos(a);
		result[3][4]= -Math.sin(a);
		result[4][3]= Math.sin(a);
		result[4][4]= Math.cos(a);
		result[5][5]=1;
		return result;
	}
}
