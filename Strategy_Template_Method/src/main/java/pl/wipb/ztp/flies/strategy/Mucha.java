package pl.wipb.ztp.flies.strategy;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.awt.geom.Point2D;

class Mucha {
	
	private final double k = 0.01;
	double x, y; // pozycja muchy
	double vx, vy; // predkosc muchy
	private MoveStrategy moveStrategy;

	public Mucha(MoveStrategy moveStrategy) {
		x = Math.random();
		y = Math.random();
		vx = k * (Math.random() - Math.random());
		vy = k * (Math.random() - Math.random());
		this.moveStrategy = moveStrategy;
	}

	public void draw(Graphics g) {
		g.setColor(moveStrategy.getColor()); // zmiana
		Rectangle rc = g.getClipBounds();
		int a = (int)(x*rc.getWidth()),
			b = (int)(y*rc.getHeight());
		g.fillOval(a, b, 8, 8);
	}
	
	public void move() {
		// Metoda push
		Point2D.Double vector = moveStrategy.calculateVectorPush(vx,vy);
		vx=vector.x;
		vy=vector.y;

		// Metoda pull
		//moveStrategy.calculateVectorPull(this);

		x += vx;
		y += vy;
		if(x<0) { x = -x; vx = -vx; }
		if(x>1) { x = 2-x;vx = -vx; }
		if(y<0) { y = -y; vy = -vy; }
		if(y>1) { y = 2-y;vy = -vy; }
	}
}