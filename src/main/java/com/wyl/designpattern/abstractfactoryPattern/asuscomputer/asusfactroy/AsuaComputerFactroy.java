package com.wyl.designpattern.abstractfactoryPattern.asuscomputer.asusfactroy;

import com.wyl.designpattern.abstractfactoryPattern.asuscomputer.computer.Y438L;
import com.wyl.designpattern.abstractfactoryPattern.asuscomputer.plugin.AsusKeybord;
import com.wyl.designpattern.abstractfactoryPattern.asuscomputer.plugin.AsusMouse;
import com.wyl.designpattern.abstractfactoryPattern.icomputer.Computer;
import com.wyl.designpattern.abstractfactoryPattern.icomputerFactory.IComputerFactory;

public class AsuaComputerFactroy implements IComputerFactory {
	/**
	 * 生产华硕电脑
	 *
	 * @return
	 */
	@Override
	public Computer createComputer() {
		Y438L y438L=new Y438L();
		y438L.setKeybord(new AsusKeybord());
		y438L.setMouse(new AsusMouse());
		return y438L;
	}
}
