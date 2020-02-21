package com.bushemi;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class AstarServiceImpl implements AstarService {

    private AStar aStar = new AStar();

    //unsafe sharing map
    private Map2D map2D;

    @Override
    public MapCell getStartCell(int x, int y) {
        return getMapCell(x, y);
    }

    @Override
    public MapCell getFinishCell(int x, int y) {
        return getMapCell(x, y);
    }

    private MapCell getMapCell(int x, int y) {
        MapCell mapCell;
        if (map2D != null) {
            mapCell = map2D.getMapCell(x, y);
        } else {
            mapCell = new MapCell(x, y);
        }
        return mapCell;
    }

    @Override
    public Collection<MapCell> generateNewMap(int x, int y) {
        map2D = new Map2D(x, y);
        return getMapCells(map2D);
    }

    private List<MapCell> getMapCells(Map2D map2D) {
        List<MapCell> mapCells = new ArrayList<>();
        for (int i = 0; i < map2D.getMaxX(); i++) {
            for (int j = 0; j < map2D.getMaxY(); j++) {
                mapCells.add(map2D.getMapCell(i, j));
            }
        }
        return mapCells;
    }

    @Override
    public Collection<MapCell> generateObstacles(int percentOfTotalCells) {
        map2D.regenerateObstacles(percentOfTotalCells);
        return getMapCells(map2D);
    }

    @Override
    public List<MapCell> getPath(MapCell start, MapCell finish) {
        return aStar.getPath(map2D, start, finish).stream()
                .map(cell -> (MapCell) cell)
                .collect(Collectors.toList());
    }
}
