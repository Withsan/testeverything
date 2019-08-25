package com.wyl.controller.designcontroller.abstractfactroy;

import com.wyl.designpattern.abstractfactoryPattern.asuscomputer.asusfactroy.AsuaComputerFactroy;
import com.wyl.designpattern.abstractfactoryPattern.dellcomputer.dellfactroy.DellComputerFactroy;
import com.wyl.designpattern.abstractfactoryPattern.icomputer.Computer;
import com.wyl.designpattern.abstractfactoryPattern.icomputerFactory.IComputerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/computer")
public class AbstractFactroyTest {
	@GetMapping(value = "/")
	public Computer getComputer(@RequestParam(value = "id") String id){
		IComputerFactory computerFactory;
		if(id.equals("dell")){
			computerFactory=new DellComputerFactroy();
		}else if(id.equals("'asus")){
			computerFactory=new AsuaComputerFactroy();
		}else {
			computerFactory=new AsuaComputerFactroy();
		}
		Computer computer=computerFactory.createComputer();
		computer.getInfo();
		return computer;
	}

}
