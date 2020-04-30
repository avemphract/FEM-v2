package com.katafrakt.femv2.maths;

import java.util.ArrayList;

public class Matrix {
	public double[][] array;
	public ArrayList<Integer> eliminated=new ArrayList<Integer>();
	
	public Matrix(double[][] array){
		this.array=array.clone();
	}
	public void addElim(int a){
		this.eliminated.add(a);
		if(array!=null)
			array = degraArray(getArrayIndex(a), getArrayIndex(a), array);
	}
	public int getArrayIndex(int b){
		int k=b;
		if(!eliminated.isEmpty()){
			for(int i:eliminated){
				if(b>i)
					k--;
			}
		}
		return k;
	}
	
	public static double[][] degraArray(int x,int y,double[][] array){
		int m = 0,n = 0;
		int size= array[0].length;
		double[][] result=new double[size-1][size-1];
		for(int i=0;i<size;i++){
			if(i==y)
				continue;
		
			for(int j=0;j<size;j++){
				if(j==x)
					continue;
				result[m][n]=array[j][i];
				m++;
			}
		m=0;
		n++;
	}
	return result;}
}