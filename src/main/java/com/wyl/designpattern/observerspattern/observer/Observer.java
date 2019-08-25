package com.wyl.designpattern.observerspattern.observer;

import com.wyl.designpattern.observerspattern.subject.Subject;

/**
 * 观察者，观察主题
 */
public abstract class Observer {
     protected Subject subject;
     public abstract String update();
}

