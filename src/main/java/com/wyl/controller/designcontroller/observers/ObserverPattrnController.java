package com.wyl.controller.designcontroller.observers;

import com.wyl.designpattern.observerspattern.observer.observerimpl.BinaryObserver;
import com.wyl.designpattern.observerspattern.observer.observerimpl.HexaObserver;
import com.wyl.designpattern.observerspattern.observer.observerimpl.OctalObserver;
import com.wyl.designpattern.observerspattern.subject.Subject;
import com.wyl.designpattern.observerspattern.subject.subjectimpl.NumberSubject;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.PostConstruct;

@RequestMapping(value = "/sendMsg")
@RestController
public class ObserverPattrnController {

	@RequestMapping(value = "{msg}",method = RequestMethod.GET)
	public String sendMsg(@PathVariable(value="msg") String value){
		Subject subject=new NumberSubject();
		BinaryObserver binaryObserver=new BinaryObserver(subject);
		HexaObserver hexaObserver=new HexaObserver(subject);
		OctalObserver octalObserver=new OctalObserver(subject);
		subject.setMsg(value);
		StringBuilder s=subject.returnMsg;
		System.out.println(s);
		return "发送成功";
	}
}
