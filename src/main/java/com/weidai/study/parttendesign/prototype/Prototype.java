package com.weidai.study.parttendesign.prototype;


/**
 * @描述
 * @author nic 
 * @time：2018年6月11日 上午9:37:02
 */
public abstract class Prototype implements Cloneable {

	String address = "杭州市民中心";
	String name = "杭州市政府";
	
	public Prototype clone() {
		Prototype p = null;
		try {
			 p = (Prototype) super.clone();
		} catch (CloneNotSupportedException e) {
			e.printStackTrace();
		}
		return p;
	}
	
	abstract public void show();
}
