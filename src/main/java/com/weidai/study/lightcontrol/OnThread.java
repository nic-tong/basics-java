/**
 * 
 */
package com.weidai.study.lightcontrol;

/**
 * @Description: TODO
 * @ClassName: OnThread
 * @author nic
 * @date: 2018年8月7日 下午11:29:43
 */
public class OnThread implements Runnable {

	Light light;
	
	 /**
	 * 
	 */
	public OnThread(Light light) {
		this.light = light;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while(true) {
			synchronized (light) {
				if (!light.on) {
					light.on();
					light.on = true;
					light.notify();
				} else {
					try {
						light.wait();
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}
		}
	}

}
