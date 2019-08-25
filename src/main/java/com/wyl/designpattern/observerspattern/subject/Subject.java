package com.wyl.designpattern.observerspattern.subject;

import com.wyl.designpattern.observerspattern.observer.Observer;

import java.util.ArrayList;
import java.util.List;

/**
 * 主题，被观察者观察
 */
public abstract class Subject {
	/**
	 * 观察者注册到这个主题，从而使得能够观察到这个主题的变化
	 * @param observer
	 */
	public abstract void attach(Observer observer);
	/**
	 * 这里存放所有观察subject 的观察者
	 */
	protected List<Observer> observers=new ArrayList<>();
	public String msg;
	public abstract void setMsg(String msg);
	public StringBuilder returnMsg=new StringBuilder();
}
