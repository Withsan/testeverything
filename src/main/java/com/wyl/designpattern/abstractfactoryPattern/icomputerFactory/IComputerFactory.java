package com.wyl.designpattern.abstractfactoryPattern.icomputerFactory;

import com.wyl.designpattern.abstractfactoryPattern.icomputer.Computer;

public interface IComputerFactory {
	/**
	 * 生产电脑
	 * @return
	 */
	public Computer createComputer();
}
