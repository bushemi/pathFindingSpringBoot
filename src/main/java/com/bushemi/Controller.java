package com.bushemi;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    private final AstarService service;

    public Controller(AstarService service) {
        this.service = service;
    }

    @PostMapping(value = "/generateNewMap")
    public Object generateNewMap(@RequestBody MapCellSpring cell) {
        System.out.println("Controller.generateNewMap");
        System.out.println("cell = [" + cell + "]");

        service.generateNewMap(cell.getX(), cell.getY());
        return service.generateObstacles(20);
    }

    @PostMapping(value = "/togglePassable")
    public Object togglePassableCell(@RequestBody MapCellSpring cell) {
        System.out.println("Controller.togglePassableCell");
        System.out.println("cell = [" + cell + "]");

        return service.togglePassableCell(cell.getX(), cell.getY());
    }

    @PostMapping(value = "/generateObstacles")
    public Object generateObstacles(@RequestBody int percentOfTotalCells) {
        System.out.println("Controller.generateObstacles");
        System.out.println("percentOfTotalCells = [" + percentOfTotalCells + "]");
        return service.generateObstacles(percentOfTotalCells);
    }

    @PostMapping(value = "/getPath")
    public Object getPath(@RequestBody PathRequest request) {
        System.out.println("Controller.getPath");
        MapCellSpring start = request.getStart();
        MapCellSpring finish = request.getFinish();
        System.out.println("start = [" + start + "], finish = [" + finish + "]");
        MapCell startCell = service.getStartCell(start.getX(), start.getY());
        MapCell finishCell = service.getFinishCell(finish.getX(), finish.getY());
        return service.getPath(startCell, finishCell);
    }


}
