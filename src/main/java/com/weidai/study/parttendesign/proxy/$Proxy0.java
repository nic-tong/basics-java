package com.weidai.study.parttendesign.proxy;
import java.lang.reflect.Method;
public final class $Proxy0 implements com.weidai.study.parttendesign.proxy.Person{
MyInvocationHandler h;
public $Proxy0(MyInvocationHandler h) {
this.h = h;
}
public void buyTicket() {
try {
Method m = com.weidai.study.parttendesign.proxy.Person.class.getMethod("buyTicket", new Class[]{});
this.h.invoke(this, m, null);
} catch(Throwable e){}}
}
