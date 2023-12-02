package pl.wipb.ztp.flies.template;

import java.awt.*;
import java.util.Random;

public class RandomMucha extends Mucha {
    private final Random random = new Random();

    @Override
    protected Color getColor() {
        return Color.BLUE;
    }
    private double getAngle() {
        return Math.toRadians((Math.random() * 20.0) - 10.0); // zakres od -10 do 10 stopni
    }

    @Override
    protected void calculateVector(Mucha mucha) {
        double vectorX = mucha.vx;
        double vectorY = mucha.vy;
        double angle = getAngle();
        // Obrót wektorów o kąt angle
        mucha.vx = Math.cos(angle)*vectorX - Math.sin(angle)*vectorY;
        mucha.vy = Math.sin(angle)*vectorX + Math.cos(angle)*vectorY;
    }
}
