package com.wyl.designpattern.FactoryPattern.factroy.fatroyImpl;

import com.wyl.designpattern.FactoryPattern.Shape.Shape;
import com.wyl.designpattern.FactoryPattern.Shapes.Square;
import com.wyl.designpattern.FactoryPattern.factroy.ShapeFactory;

public class SuaqreFactroy  implements ShapeFactory {
	@Override
	public Shape getShape() {
		return new Square();
	}
}
