package com.wyl.designpattern.singletonpattern;

/**
 * 一般情况下推荐使用这种
 */
public class SingletonNotLazy {
	private SingletonNotLazy(){}
	private static SingletonNotLazy singletonNotLazy=new SingletonNotLazy();
	public static SingletonNotLazy getInsteance(){
		return singletonNotLazy;
	}
}
