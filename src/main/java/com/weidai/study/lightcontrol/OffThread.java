/**
 * 
 */
package com.weidai.study.lightcontrol;

/**
 * @Description: TODO
 * @ClassName: OffThread
 * @author nic
 * @date: 2018年8月7日 下午11:31:39
 */
public class OffThread implements Runnable {

	
	Light light;
	
	public OffThread(Light light) {
		this.light = light;
	}
	/* (non-Javadoc)
	 * @see java.lang.Runnable#run()
	 */
	@Override
	public void run() {
		while (true) {
			synchronized (light) {
				if (light.on) {
					light.off();
					light.on = false;
					light.notify();
				} else {
					try {
						light.wait();
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			}
		}
	}

}
