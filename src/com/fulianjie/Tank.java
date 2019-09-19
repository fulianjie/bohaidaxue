package com.fulianjie;

import java.awt.Graphics;

public class Tank {
	private int x,y;
	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}


	public static int WIDTH = 50;
	public static int HEIGHT = 50;
	private int SPEED = 25;
	private Dir dir = Dir.DOWN;
	private boolean moving = false;
	private TankFrame tf;
	public boolean isMoving() {
		return moving;
	}

	public void setMoving(boolean moving) {
		this.moving = moving;
	}

	public Dir getDir() {
		return dir;
	}

	public void setDir(Dir dir) {
		this.dir = dir;
	}

	Tank(int x,int y,Dir dir,TankFrame tf){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
		g.drawImage(ResourceMgr.plane, x, y, null);
 
		move();
		
		
		
	}
	
	
	public void move() {
		if(!moving) return ;
		
		switch(dir) {
		case UP:
			y -= SPEED;
			break;
		case DOWN:
			y += SPEED;
			break;
		case LEFT:
			x -= SPEED;
			break;
		case RIGHT:
			x += SPEED;
			break;
			
		default:
			break;
			
		
		}
			
		
		
	}
	

	public void fire() {
		tf.bullets.add(new Bullet(this.x,this.y,this.dir,this.tf));
		
	}
	
	public void die() {
		tf.tanks.remove(this);
	}
	

}
