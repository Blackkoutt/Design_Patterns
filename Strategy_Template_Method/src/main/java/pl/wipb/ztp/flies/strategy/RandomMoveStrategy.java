package pl.wipb.ztp.flies.strategy;

import java.awt.*;
import java.awt.geom.Point2D;
import java.util.Random;

public class RandomMoveStrategy extends MoveStrategy{
    private final Random random = new Random();
    @Override
    public Color getColor() {
        return Color.BLUE;
    }

    private double getAngle() {
        return Math.toRadians((Math.random() * 20.0) - 10.0); // zakres od -10 do 10 stopni
    }
    @Override
    public void calculateVectorPull(Mucha mucha) {
        // Potrzebne w przypadku metody pull
        double vectorX = mucha.vx;
        double vectorY = mucha.vy;
        double angle = getAngle();
        // Obrót wektorów o kąt angle
        mucha.vx = Math.cos(angle)*vectorX - Math.sin(angle)*vectorY;
        mucha.vy = Math.sin(angle)*vectorX + Math.cos(angle)*vectorY;
    }

    @Override
    public Point2D.Double calculateVectorPush(double vx, double vy) {
        double angle = getAngle();
        return new Point2D.Double
                (
                        Math.cos(angle)*vx - Math.sin(angle)*vy,
                        Math.sin(angle)*vx + Math.cos(angle)*vy
                );
    }
}
