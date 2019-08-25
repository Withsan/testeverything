package com.wyl.controller.designcontroller.fatory;


import com.wyl.designpattern.FactoryPattern.Shape.Shape;
import com.wyl.designpattern.FactoryPattern.factroy.ShapeFactory;
import com.wyl.designpattern.FactoryPattern.factroy.fatroyImpl.CircleFactroy;
import com.wyl.designpattern.FactoryPattern.factroy.fatroyImpl.RectangleFactroy;
import com.wyl.designpattern.FactoryPattern.factroy.fatroyImpl.SuaqreFactroy;
import com.wyl.designpattern.FactoryPattern.simplefatory.SimpleShapeFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController()
public class FactoryPatternTest {
	/**
	 * 简单工厂模式
	 * @return
	 */
	@RequestMapping("/getSimpleShape")
	public String getSimpleShape() {
		SimpleShapeFactory simpleShapeFactory = new SimpleShapeFactory();
		//获取 Circle 的对象，并调用它的 draw 方法
		Shape shape1 = simpleShapeFactory.getShape(SimpleShapeFactory.CIRCLE);

		//调用 Circle 的 draw 方法
		shape1.drwa();

		//获取 Rectangle 的对象，并调用它的 draw 方法
		Shape shape2 = simpleShapeFactory.getShape(SimpleShapeFactory.RECTANGLE);

		//调用 Rectangle 的 draw 方法
		shape2.drwa();

		//获取 Square 的对象，并调用它的 draw 方法
		Shape shape3 = simpleShapeFactory.getShape(SimpleShapeFactory.SQUARE);

		//调用 Square 的 draw 方法
		shape3.drwa();
		return shape3.drwa();
	}

	/**
	 * 正宗工厂模式
	 * @return
	 */
	@RequestMapping("/getShape")
	public String getShape() {
		StringBuffer shape=new StringBuffer();
		ShapeFactory circleFactory=new CircleFactroy();
		Shape circle=circleFactory.getShape();
		shape.append(circle.drwa());
		ShapeFactory rectangleFactory=new RectangleFactroy();
		Shape rectangle=rectangleFactory.getShape();
		shape.append(rectangle.drwa());
		ShapeFactory squareFactory=new SuaqreFactroy();
		Shape suqare=squareFactory.getShape();
		shape.append(suqare.drwa());
		return shape.toString();
	}




}
