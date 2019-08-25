package com.wyl.designpattern.observerspattern.observer.observerimpl;

import com.wyl.designpattern.observerspattern.observer.Observer;
import com.wyl.designpattern.observerspattern.subject.Subject;

import java.util.HashMap;

public class BinaryObserver extends Observer {
	/**
	 * 绑定一个主题
	 *
	 * @param subject
	 */
	public BinaryObserver(Subject subject) {
		this.subject = subject;
		this.subject.attach(this);
	}

	@Override
	public String update() {
		subject.returnMsg.append("Binary接收到消息" + Integer.toBinaryString(Integer.valueOf(subject.msg)) + "\\n");
		System.out.println("Binary接收到消息" + Integer.toBinaryString(Integer.valueOf(subject.msg)));
		return ("Binary接收到消息" + Integer.toBinaryString(Integer.valueOf(subject.msg)));
	}
}
