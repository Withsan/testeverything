package com.wyl.designpattern.abstractfactoryPattern.asuscomputer.plugin;

import com.wyl.designpattern.abstractfactoryPattern.iplugin.Keybord;

public class AsusKeybord extends Keybord {
	/**
	 * 获取插件功能
	 *
	 * @return
	 */
	@Override
	public String getFunction() {
		return "华硕键盘";
	}
}
