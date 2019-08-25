package com.wyl.designpattern.abstractfactoryPattern.dellcomputer.plugin;

import com.wyl.designpattern.abstractfactoryPattern.iplugin.Mouse;

public class DellMouse  extends Mouse {
	/**
	 * 获取插件功能
	 *
	 * @return
	 */
	@Override
	public String getFunction() {
		return "戴尔鼠标";
	}
}
