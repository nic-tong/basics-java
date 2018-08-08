package com.weidai.study.parttendesign.factory;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午5:26:36
 */
public class Default4SFactory extends AbstractFactory {

	@Override
	protected Car getCar() {
		// TODO Auto-generated method stub
		return new AudiFactory().getCar();
	}

	public Car getCar(String name) {
		if ("benz".equalsIgnoreCase(name)) {
			return new BenzFactory().getCar();
		} else if ("Bmw".equalsIgnoreCase(name)) {
			return new BmwFactory().getCar();
		} else if ("Audi".equalsIgnoreCase(name)) {
			return new AudiFactory().getCar();
		} else {
			return null;
		}
	}
}
