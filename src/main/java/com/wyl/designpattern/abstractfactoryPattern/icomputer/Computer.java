package com.wyl.designpattern.abstractfactoryPattern.icomputer;

import com.wyl.designpattern.abstractfactoryPattern.iplugin.Keybord;
import com.wyl.designpattern.abstractfactoryPattern.iplugin.Mouse;

public abstract class Computer {
	   private Keybord keybord;
	   private Mouse mouse;
	   public  String info;

	public Keybord getKeybord() {
		return keybord;
	}

	public void setKeybord(Keybord keybord) {
		this.keybord = keybord;
	}

	public Mouse getMouse() {
		return mouse;
	}

	public void setMouse(Mouse mouse) {
		this.mouse = mouse;
	}
	public abstract String getInfo();
}
