package com.wyl.designpattern.abstractfactoryPattern.asuscomputer.computer;

import com.wyl.designpattern.abstractfactoryPattern.icomputer.Computer;

public class Y438L extends Computer {

	@Override
	public String getInfo() {
		this.info="华硕Y438L电脑";
		String keybordInfo=getKeybord().getFunction();
		String mpuseInfo=getMouse().getFunction();
		return info+keybordInfo+mpuseInfo;
	}
}
