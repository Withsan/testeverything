package com.wyl.designpattern.abstractfactoryPattern.dellcomputer.computer;

import com.wyl.designpattern.abstractfactoryPattern.icomputer.Computer;

public class Flyer extends Computer {
	@Override
	public String getInfo() {

		this.info="戴尔飞行者电脑";
		String keybordInfo=getKeybord().getFunction();
		String mpuseInfo=getMouse().getFunction();
		return info+keybordInfo+mpuseInfo;
	}
}
