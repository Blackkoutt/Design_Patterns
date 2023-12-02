package pl.wipb.ztp.flies.strategy;

import java.awt.Dimension;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;

public class Muchy extends JPanel implements Runnable {

	private Mucha[] ar;

	public Muchy() {
		this.setPreferredSize(new Dimension(640, 480));
		ar = new Mucha[30];

		// Losowy wybór strategii
		Random random = new Random();
		MoveStrategy moveStrategy;
		for (int i = 0; i < ar.length; ++i)
		{
			int rnd = random.nextInt(2);
			if(rnd == 0){
				moveStrategy = new RandomMoveStrategy();
			}
			else{
				moveStrategy = new RoundMoveStrategy();
			}
			ar[i] = new Mucha(moveStrategy);
		}

	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		for (int i = 0; i < ar.length; ++i) {
			ar[i].draw(g);
		}
	}

	@Override
	public void run() {
		while (true) {
			for (int i = 0; i < ar.length; ++i) {
				ar[i].move();
			}
			repaint();
			try {
				Thread.sleep(20);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

	public static void main(String[] args) {
		System.setProperty("sun.java2d.opengl", "true");

		JFrame frame = new JFrame("Muchy");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Muchy m = new Muchy();
		frame.getContentPane().add(m);
		frame.pack();
		frame.setVisible(true);
		new Thread(m).start();
	}
}