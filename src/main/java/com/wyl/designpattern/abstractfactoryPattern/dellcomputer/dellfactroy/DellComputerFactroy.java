package com.wyl.designpattern.abstractfactoryPattern.dellcomputer.dellfactroy;

import com.wyl.designpattern.abstractfactoryPattern.dellcomputer.computer.Flyer;
import com.wyl.designpattern.abstractfactoryPattern.dellcomputer.plugin.DellKeybord;
import com.wyl.designpattern.abstractfactoryPattern.dellcomputer.plugin.DellMouse;
import com.wyl.designpattern.abstractfactoryPattern.icomputer.Computer;
import com.wyl.designpattern.abstractfactoryPattern.icomputerFactory.IComputerFactory;

public class DellComputerFactroy implements IComputerFactory {
	/**
	 * 生产电脑
	 *
	 * @return
	 */
	@Override
	public Computer createComputer() {
		Flyer flyer=new Flyer();
		flyer.setKeybord(new DellKeybord());
		flyer.setMouse(new DellMouse());
		return flyer;
	}
}
