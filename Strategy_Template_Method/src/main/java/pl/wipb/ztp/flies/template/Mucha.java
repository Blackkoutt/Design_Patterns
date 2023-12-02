package pl.wipb.ztp.flies.template;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;

abstract class Mucha {
	
	private final double k = 0.01;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy

	public Mucha() {
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
	}

	public void draw(Graphics g) {
		g.setColor(getColor());
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 8, 8);
	}
	
	public void move() {
		calculateVector(this);
		x += vx;
		y += vy;
		if(x<0) { x = -x; vx = -vx; }
		if(x>1) { x = 2-x;vx = -vx; }
		if(y<0) { y = -y; vy = -vy; }
		if(y>1) { y = 2-y;vy = -vy; }
	}
	protected abstract Color getColor();
	protected abstract void calculateVector(Mucha mucha);
}