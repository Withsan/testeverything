package com.wyl.designpattern.FactoryPattern.factroy.fatroyImpl;

import com.wyl.designpattern.FactoryPattern.Shape.Shape;
import com.wyl.designpattern.FactoryPattern.Shapes.Circle;
import com.wyl.designpattern.FactoryPattern.factroy.ShapeFactory;

public class CircleFactroy implements ShapeFactory {
	@Override
	public Shape getShape() {
		return new Circle();
	}
}
