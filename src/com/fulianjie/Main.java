package com.fulianjie;

import java.awt.Frame;

public class Main {
	
	

	public static void main(String[] args) throws InterruptedException {
		// TODO Auto-generated method stub
	
		
		
		TankFrame tf = new TankFrame();
		for(int i = 0;i<5;i++) {
			tf.tanks.add(new Tank(50+(100*i),200,Dir.DOWN,tf));
			
		}
	   while(true) {
		   Thread.sleep(50);
		   tf.repaint();
	   }
		
		
		

	}

}
