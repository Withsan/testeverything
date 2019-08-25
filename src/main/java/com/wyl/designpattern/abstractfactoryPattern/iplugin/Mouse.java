package com.wyl.designpattern.abstractfactoryPattern.iplugin;

public abstract  class Mouse  implements Plugin {
	/**
	 * 获取插件功能
	 *
	 * @return
	 */
	@Override
	public abstract String getFunction();
}