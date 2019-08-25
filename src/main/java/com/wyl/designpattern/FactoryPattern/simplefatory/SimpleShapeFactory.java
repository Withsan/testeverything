package com.wyl.designpattern.FactoryPattern.simplefatory;

import com.wyl.designpattern.FactoryPattern.Shape.Shape;
import com.wyl.designpattern.FactoryPattern.Shapes.Circle;
import com.wyl.designpattern.FactoryPattern.Shapes.Rectangle;
import com.wyl.designpattern.FactoryPattern.Shapes.Square;


public class SimpleShapeFactory {
	public static String SQUARE="SQUARE";
	public static String CIRCLE="CIRCLE";
	public static String RECTANGLE="RECTANGLE";
	public Shape getShape(String shape){
		if(SQUARE.equalsIgnoreCase(shape)){
			return new Square();
		}else if(CIRCLE.equalsIgnoreCase(shape)){
			return new Circle();
		}else if(RECTANGLE.equalsIgnoreCase(shape)){
			return new Rectangle();
		}
			return null;
	}
}
