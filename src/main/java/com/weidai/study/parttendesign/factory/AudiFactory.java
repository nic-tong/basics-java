package com.weidai.study.parttendesign.factory;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午3:58:12
 */
public class AudiFactory extends AbstractFactory {

	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new Audi();
	}
}
