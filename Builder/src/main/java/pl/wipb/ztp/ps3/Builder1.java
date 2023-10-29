package pl.wipb.ztp.ps3;

public class Builder1 extends Builder{

    @Override
    public void createX(int value) {
        x += value * TILESIZE;
    }

    @Override
    public void createSegmentA() {
        Segment s = new SegmentBlock(x, y, "block1.png");
        board.add(s);
        x += TILESIZE;
    }

    @Override
    public void createSegmentB() {
        Segment s = new SegmentBlockV(x, y, "block2.png");
        board.add(s);
        x += TILESIZE;
    }

    @Override
    public void createSegmentC() {
        Segment s = new Segment(x, y, "block3.png");
        board.add(s);
        x += TILESIZE;
    }

    @Override
    public void createSegmentG() {
        Segment s = new SegmentAnim(x, y, "bonus.png", new int[]{0, 0, 0, 1, 1, 1, 2, 2, 3, 3, 2, 2, 1, 1, 1, 0, 0});
        board.add(s);
        x += TILESIZE;
    }
}
