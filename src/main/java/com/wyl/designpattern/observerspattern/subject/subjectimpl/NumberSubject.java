package com.wyl.designpattern.observerspattern.subject.subjectimpl;

import com.wyl.designpattern.observerspattern.observer.Observer;
import com.wyl.designpattern.observerspattern.subject.Subject;

import java.util.ArrayList;

public class NumberSubject extends Subject {
	/**
	 * 初始化
	 */
    public NumberSubject(){
    	this.observers=new ArrayList<>();
	}
	public void setMsg(String msg){
    	this.msg=msg+"";
    	notifyAllObserver();
	}



	/**
	 * 观察者注册到这个主题，从而使得能够观察到这个主题的变化
	 * @param observer
	 */
	public void attach(Observer observer){
		observers.add(observer);
	}
	/**
	 * 通知所有观察者
	 */
	public void notifyAllObserver(){
		for (Observer observer:observers){
			observer.update();
		}
	}
}
