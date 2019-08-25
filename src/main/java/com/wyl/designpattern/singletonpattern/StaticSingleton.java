package com.wyl.designpattern.singletonpattern;

/**
 * 只有在要明确实现 lazy loading 效果时，才会使用第这种登记方式
 */
public class StaticSingleton {
	private static class SingltonHolder{
		public static final StaticSingleton INSTANCE  =new StaticSingleton();
	}
	private StaticSingleton(){};
	public static StaticSingleton getInsteance(){
		return SingltonHolder.INSTANCE ;
	}
	public static String getName(){
		return "我是静态内部类的单例模式";
	}
}
