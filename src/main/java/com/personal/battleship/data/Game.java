package com.personal.battleship.data;

public class Game {

    Grid grid1 = new Grid();
    Grid grid2 = new Grid();

    Boolean isGameOver = false;

    Integer turn = 0;

    public Boolean attack(Point point) {

        boolean isFirstPlayerTurn = turn % 2 == 0;
        turn += 1;
        Grid activeGrid;
            if (isFirstPlayerTurn) {
                activeGrid = grid2;
            }
            else activeGrid = grid1;

        if (activeGrid.ships.containsKey(point)) {
            Battleship ship = activeGrid.ships.get(point);
            ship.heathPoints -= 1;
            activeGrid.shotPoints.put(point, true);
            if (ship.heathPoints == 0) {
                activeGrid.battleshipsAlive -= 1;
                isGameOver = activeGrid.isAnyBattleshipAlive();
                try {
                    ship.areaOfShip().forEach(p -> {if (!activeGrid.shotPoints.containsKey(p)) {activeGrid.shotPoints.put(p, false);}});

                } catch (Exception exception) {
                    return false;
                }
            }
        } else {
            activeGrid.shotPoints.put(point, false);
            return false;
        }
        return true;
    }


}
