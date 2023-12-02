package pl.wipb.ztp.flies.strategy;

import java.awt.*;
import java.awt.geom.Point2D;

public abstract class MoveStrategy {

    public abstract Color getColor();
    public abstract  void calculateVectorPull(Mucha mucha);
    public abstract Point2D.Double calculateVectorPush(double vx, double vy);
}
