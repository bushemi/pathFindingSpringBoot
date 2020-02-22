package com.bushemi;

import java.util.Collection;
import java.util.List;

public interface AstarService {

    MapCell getStartCell(int x, int y);

    MapCell getFinishCell(int x, int y);

    MapCell togglePassableCell(int x, int y);

    Collection<MapCell> generateNewMap(int x, int y);

    Collection<MapCell> generateObstacles(int percentOfTotalCells);

    List<MapCell> getPath(MapCell start, MapCell finish);

}
