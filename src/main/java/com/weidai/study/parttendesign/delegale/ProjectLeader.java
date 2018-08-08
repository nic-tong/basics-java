package com.weidai.study.parttendesign.delegale;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午5:44:27
 */
public class ProjectLeader implements ISystemBuild {

	ISystemBuild builder;
	
	public ProjectLeader(ISystemBuild builder) {
		this.builder = builder;
	}
	@Override
	public void building() {
		this.builder.building();
	}
}
