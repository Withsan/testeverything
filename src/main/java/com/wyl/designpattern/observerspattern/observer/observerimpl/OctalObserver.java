package com.wyl.designpattern.observerspattern.observer.observerimpl;

import com.wyl.designpattern.observerspattern.observer.Observer;
import com.wyl.designpattern.observerspattern.subject.Subject;

public class OctalObserver extends Observer {
	/**
	 * 绑定一个主题
	 * @param subject
	 */
	public  OctalObserver(Subject subject){
		this.subject=subject;
		this.subject.attach(this);
	}
	@Override
	public String update() {
		subject.returnMsg.append("Octal接收到消息"+Integer.toOctalString(Integer.valueOf(subject.msg))+"\\n");
		System.out.println("Octal接收到消息"+Integer.toOctalString(Integer.valueOf(subject.msg)));
     return ("Octal接收到消息"+Integer.toOctalString(Integer.valueOf(subject.msg)));
	}
}
