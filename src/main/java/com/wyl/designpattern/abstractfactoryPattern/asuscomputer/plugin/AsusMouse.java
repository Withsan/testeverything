package com.wyl.designpattern.abstractfactoryPattern.asuscomputer.plugin;

import com.wyl.designpattern.abstractfactoryPattern.iplugin.Mouse;

public class AsusMouse extends Mouse {
	/**
	 * 获取插件功能
	 *
	 * @return
	 */
	@Override
	public String getFunction() {
		return "华硕鼠标";
	}
}
