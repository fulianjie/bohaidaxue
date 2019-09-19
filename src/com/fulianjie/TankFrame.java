package com.fulianjie;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.util.ArrayList;
import java.util.List;

public class TankFrame extends Frame{
	
	public int WIDTH = 800;
	public int HEIGHT = 600;
	Tank myTank = new Tank(300,300,Dir.DOWN,this);
	//Bullet b = new Bullet(300,300,Dir.DOWN);
	
	List<Bullet> bullets = new ArrayList<>();
	List<Tank> tanks = new ArrayList<>();
	
	TankFrame(){
		setSize(WIDTH,HEIGHT);
		setTitle("tank war");
		setResizable(false);
		setVisible(true);
		
		
		addKeyListener(new MyKeyListener());
		addWindowListener(new WindowAdapter() {
			
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		
	

	}
	
	public void paint(Graphics g) {
		g.drawString("子弹的数量"+bullets.size(), 10, 60);
		myTank.paint(g);
		for(int i = 0;i<bullets.size();i++) {
			bullets.get(i).paint(g);
		}
		for(int i = 0;i<tanks.size();i++) {
			tanks.get(i).paint(g);
		}
		
		for(int i = 0;i<bullets.size();i++) {
			for(int j = 0;j<tanks.size();j++) {
				bullets.get(i).collideWith(tanks.get(j));
			}
		}
		
		
		
		
		
	}
	
	class MyKeyListener extends KeyAdapter{
		boolean U = false;
		boolean D = false;
		boolean L = false;
		boolean R = false;

		@Override
		public void keyPressed(KeyEvent e) {
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_UP:
				U = true;
				break;
			case KeyEvent.VK_DOWN:
				D = true;
				break;
			case KeyEvent.VK_LEFT:
				L = true;
				break;
			case KeyEvent.VK_RIGHT:
				R = true;
				break;
				
			default:
				break;
				
			}
			
			setTankDir();
			

		}

		@Override
		public void keyReleased(KeyEvent e) {
			
		
			int key = e.getKeyCode();
			switch(key) {
			case KeyEvent.VK_UP:
				U = false;
				break;
			case KeyEvent.VK_DOWN:
				D = false;
				break;
			case KeyEvent.VK_LEFT:
				L = false;
				break;
			case KeyEvent.VK_RIGHT:
				R = false;
				break;
			case KeyEvent.VK_CONTROL:
				myTank.fire();
				
			default:
				break;

		}
		
			setTankDir();
		
		
	}
		public void setTankDir() {
			if(!L && !U && !R && !D) myTank.setMoving(false);
			else {
				myTank.setMoving(true);
				
				if(L) myTank.setDir(Dir.LEFT);
				if(U) myTank.setDir(Dir.UP);
				if(R) myTank.setDir(Dir.RIGHT);
				if(D) myTank.setDir(Dir.DOWN);
			}
		}
	}
}
