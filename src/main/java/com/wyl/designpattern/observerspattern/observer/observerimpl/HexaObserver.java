package com.wyl.designpattern.observerspattern.observer.observerimpl;

import com.wyl.designpattern.observerspattern.observer.Observer;
import com.wyl.designpattern.observerspattern.subject.Subject;

public class HexaObserver extends Observer {
	/**
	 * 绑定一个主题
	 * @param subject
	 */
	public HexaObserver(Subject subject){
		this.subject=subject;
		this.subject.attach(this);
	}
	@Override
	public String update() {
		subject.returnMsg.append("Hex接收到消息"+Integer.toHexString(Integer.valueOf(subject.msg))+"\\n");
		System.out.println("Hex接收到消息"+Integer.toHexString(Integer.valueOf(subject.msg)));
		return  ("Hex接收到消息"+Integer.toHexString(Integer.valueOf(subject.msg)));
	}
}
