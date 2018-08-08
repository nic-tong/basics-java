package com.weidai.study.parttendesign.delegale;


/**
 * @描述
 * @author nic 
 * @time：2018年6月10日 下午5:45:44
 */
public class BossTest {

	public static void main(String[] args) {
		ProjectLeader leader = new ProjectLeader(new LoginBuilder());
		leader.building();
	}
}
