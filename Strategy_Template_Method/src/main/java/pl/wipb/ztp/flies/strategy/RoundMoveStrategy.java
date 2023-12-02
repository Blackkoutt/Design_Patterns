package pl.wipb.ztp.flies.strategy;

import java.awt.*;
import java.awt.geom.Point2D;

public class RoundMoveStrategy extends MoveStrategy{
    private static final double angle = Math.toRadians(10);
    @Override
    public Color getColor() {
        return Color.RED;
    }

    @Override
    public void calculateVectorPull(Mucha mucha) {
        // Potrzebne w przypadku metody pull
        double vectorX = mucha.vx;
        double vectorY = mucha.vy;
        // Obrót wektorów o kąt angle
        mucha.vx = Math.cos(angle)*vectorX - Math.sin(angle)*vectorY;
        mucha.vy = Math.sin(angle)*vectorX + Math.cos(angle)*vectorY;
    }

    @Override
    public Point2D.Double calculateVectorPush(double vx, double vy) {
        return new Point2D.Double
                (
                        Math.cos(angle)*vx - Math.sin(angle)*vy,
                        Math.sin(angle)*vx + Math.cos(angle)*vy
                );
    }
}
