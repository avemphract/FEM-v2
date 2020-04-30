package com.katafrakt.femv2.materials;

public class Material {
	public static final Material steel=new Material(200000,350,78000);
	public static final Material aliminium=new Material(77000,276,27000);
	public static final Material copper=new Material(117000,33.3d,40000);
		
	public double elasticityModul;
	public double tensileStrenght;
	public double shearModulus;
	
	public Material(double elasticModul,double tensile,double shearModulus){
		this.elasticityModul=elasticModul;
		this.tensileStrenght=tensile;
		this.shearModulus=shearModulus;
	}
}
