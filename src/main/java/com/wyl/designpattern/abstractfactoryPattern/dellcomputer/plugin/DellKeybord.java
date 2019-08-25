package com.wyl.designpattern.abstractfactoryPattern.dellcomputer.plugin;

import com.wyl.designpattern.abstractfactoryPattern.iplugin.Keybord;

public class DellKeybord extends Keybord {
	/**
	 * 获取插件功能
	 *
	 * @return
	 */
	@Override
	public String getFunction() {
		return "戴尔键盘";
	}
}
