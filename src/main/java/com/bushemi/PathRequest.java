package com.bushemi;

public class PathRequest {
    private MapCellSpring start;
    private MapCellSpring finish;

    public PathRequest() {
    }

    public MapCellSpring getStart() {
        return start;
    }

    public void setStart(MapCellSpring start) {
        this.start = start;
    }

    public MapCellSpring getFinish() {
        return finish;
    }

    public void setFinish(MapCellSpring finish) {
        this.finish = finish;
    }

    @Override
    public String toString() {
        return "PathRequest{" +
                "start=" + start +
                ", finish=" + finish +
                '}';
    }
}
