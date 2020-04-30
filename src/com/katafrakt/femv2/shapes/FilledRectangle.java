package com.katafrakt.femv2.shapes;

public class FilledRectangle extends Shape {
	public FilledRectangle(double width,double height){
		area=width*height;
		inertia=Math.pow(height,3)*width/12;
		ySize=height;
	}

}
