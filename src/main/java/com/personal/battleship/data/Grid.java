package com.personal.battleship.data;

import java.util.HashMap;
import java.util.List;
import java.util.Map;


public class Grid {
    int battleshipsAlive = 10;
    Map<Point, Boolean> shotPoints = new HashMap<>();
    Map<Point, Battleship> ships = new HashMap<>();

    Map<Integer, Integer> shipsCount = new HashMap<>();

    Grid() {
        shipsCount.put(1, 4);
        shipsCount.put(2, 3);
        shipsCount.put(3, 2);
        shipsCount.put(4, 1);
    }

    public Boolean deployBattleship(Battleship ship) {

        try {
            List<Point> area = ship.areaOfShip();

            int shipsLeft = shipsCount.getOrDefault(ship.size, 0);

            boolean canBeDeployed = area.stream().noneMatch((p) -> ships.containsKey(p)) && shipsLeft > 0;


            if (canBeDeployed) {
                shipsCount.replace(ship.size, shipsLeft - 1);
                    if (ship.isVertical) {
                        for(int i = ship.startPoint.x(); i < ship.startPoint.x() + ship.size; i++) {
                            ships.put(new Point(i, ship.startPoint.y()), ship);
                        }
                    } else {
                        for(int i = ship.startPoint.y(); i < ship.startPoint.y() + ship.size; i++) {
                            ships.put(new Point(ship.startPoint.x(), i), ship);
                        }
                    }
                }

            return canBeDeployed;


        } catch (Exception exception) {
            return false;
        }

    }

    public Boolean isAnyBattleshipAlive() {

        return battleshipsAlive > 0;
    }

    public String toAllyGrid() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                Point p = new Point(i,j);

                if (shotPoints.containsKey(p)) {

                    if (shotPoints.get(p)) {
                        result.append("x");
                    } else {
                        result.append("o");
                    }
                } else {
                    if (ships.containsKey(p)) {
                        result.append("@");
                    } else {
                        result.append(".");
                    }
                }

            }
            result.append("\n");
        }

        return result.toString();
    }

    public String toEnemyGrid() {
        StringBuilder result = new StringBuilder();
        for (int i = 0; i < 10; i++) {

            for (int j = 0; j < 10; j++) {

                Point p = new Point(i,j);

                if (shotPoints.containsKey(p)) {

                    if (shotPoints.get(p)) {
                        result.append("x");
                    } else {
                        result.append("o");
                    }
                } else {
                    result.append(".");
                }

            }
            result.append("\n");
        }

        return result.toString();
    }

    public void returnShip(Point point) {
        if (ships.containsKey(point)) {
            Battleship ship = ships.get(point);

            for (int i = 0; i < ship.size; i++) {
                Point p;
                if (ship.isVertical) {
                    p = new Point(point.x() + i,point.y());
                } else {
                    p = new Point(point.x(),point.y() + i);
                }
                ships.remove(p);

            }
            shipsCount.replace(ship.size, shipsCount.get(ship.size) + 1);
        }
    }



}
