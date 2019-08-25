package com.wyl.designpattern.singletonpattern;

/**
 * 特殊情况下用这个，比如说多线程情况下
 */
public class SingletonDcl {
	private volatile static SingletonDcl singletonDcl;
	private SingletonDcl(){}
	public SingletonDcl getInsteance(){
		if (singletonDcl==null){
			synchronized (SingletonDcl.class){
				if(singletonDcl==null){//多线程情况下先锁住再检查
					singletonDcl= new SingletonDcl();
				}
			}
		}
		return singletonDcl;
	}
}
