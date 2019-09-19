package com.fulianjie;

import java.awt.Graphics;
import java.awt.Rectangle;

public class Bullet {
	private int x,y;
	private int SPEED = 30;
	private Dir dir = Dir.UP;
	private int WIDTH = 10;
	private int HEIGHT = 10;
	private TankFrame tf;
	
	Bullet(int x,int y,Dir dir,TankFrame tf){
		this.x = x;
		this.y = y;
		this.dir = dir;
		this.tf = tf;
	}
	
	public void paint(Graphics g) {
	//	g.fillOval(x, y, WIDTH, HEIGHT);
		g.drawImage(ResourceMgr.bullet, x, y, null);
		move();
		
		if(x < 0 || y < 0 || x > tf.WIDTH || y > tf.HEIGHT) {
			die();
			
		}
		
		
	}
	
	
	public void move() {
		
		/*
		switch(dir) {
		case UP:
			y -= SPEED;
		    break;
		case DOWN:
			y -= SPEED;
			break;
		case LEFT:
			y -= SPEED;
			break;
		case RIGHT:
			y -= SPEED;
			break;
			
		default:
			break;
		}
		
		*/
		
		y -= SPEED;
		
	}
	
	
	
	public void die() {
		tf.bullets.remove(this);
		
	}
	
	
	public void collideWith(Tank tank) {
		Rectangle rect1 = new Rectangle(this.x,this.y,WIDTH,HEIGHT);
		Rectangle rect2 = new Rectangle(tank.getX(),tank.getY(),Tank.WIDTH,Tank.HEIGHT);
		
		if(rect1.intersects(rect2)) {
			tank.die();
			this.die();
		}
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	
	

}
