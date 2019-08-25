package com.wyl.designpattern.FactoryPattern.factroy.fatroyImpl;

import com.wyl.designpattern.FactoryPattern.Shape.Shape;
import com.wyl.designpattern.FactoryPattern.Shapes.Rectangle;
import com.wyl.designpattern.FactoryPattern.factroy.ShapeFactory;

public class RectangleFactroy implements ShapeFactory {
	@Override
	public Shape getShape() {
		return new Rectangle();
	}
}
