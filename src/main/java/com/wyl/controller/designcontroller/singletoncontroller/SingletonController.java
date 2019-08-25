package com.wyl.controller.designcontroller.singletoncontroller;

import com.wyl.designpattern.singletonpattern.StaticSingleton;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/singleton",method = RequestMethod.GET)
public class SingletonController  {
	@RequestMapping(value = "{type}",method = RequestMethod.GET)
	public Boolean getSinggleton(@PathVariable(value = "type") String type){
		StaticSingleton staticSingletonNo1=StaticSingleton.getInsteance();
		StaticSingleton staticSingletonNo2=StaticSingleton.getInsteance();
		return staticSingletonNo1==staticSingletonNo2;
	}
}
