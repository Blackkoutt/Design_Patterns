package pl.wipb.ztp.flies.template;

import java.awt.*;

public class RoundMucha extends Mucha{
    private static final double angle = Math.toRadians(10);
    @Override
    protected Color getColor() {
        return Color.RED;
    }

    @Override
    protected void calculateVector(Mucha mucha) {
        double vectorX = mucha.vx;
        double vectorY = mucha.vy;
        // Obrót wektorów o kąt angle
        mucha.vx = Math.cos(angle)*vectorX - Math.sin(angle)*vectorY;
        mucha.vy = Math.sin(angle)*vectorX + Math.cos(angle)*vectorY;
    }
}
