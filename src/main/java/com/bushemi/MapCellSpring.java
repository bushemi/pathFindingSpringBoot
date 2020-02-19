package com.bushemi;

public class MapCellSpring  extends MapCell{
    public MapCellSpring() {
        super(0, 0);
    }

    public MapCellSpring(int x, int y) {
        super(x, y);
    }

    public MapCellSpring(int x, int y, boolean isPassable) {
        super(x, y, isPassable);
    }
}
