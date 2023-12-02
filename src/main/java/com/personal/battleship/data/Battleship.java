package com.personal.battleship.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class Battleship {
    int size;
    int heathPoints;

    boolean isVertical;

    Point startPoint;

     List<Point> areaOfShip() throws Exception {
        List<Point> area = new ArrayList<>(Collections.emptyList());

        if(this.startPoint.x() < 0 || this.startPoint.x() > 9 || this.startPoint.y() < 0 || this.startPoint.y() > 9) {
            throw new Exception("NE TUDA ZELEZ");
        }

        int minX = Math.max(0, this.startPoint.x() - 1);
        int minY = Math.max(0, this.startPoint.y() - 1);
        int maxX;
        int maxY;

        if (this.isVertical) {
            maxX = Math.min(9, this.startPoint.x() + this.size);
            maxY = Math.min(9, this.startPoint.y() + 1);
        } else {
            maxX = Math.min(9, this.startPoint.x() + 1);
            maxY = Math.min(9, this.startPoint.y() + this.size);
        }


        for (int i = minX; i < maxX + 1; i++) {
            for (int j = minY; j < maxY + 1; j++) {
                area.add(new Point(i, j));
            }
        }
        return area;
    }
    public Battleship(int size, boolean isVertical, Point startPoint) {
        this.size = size;
        this.isVertical = isVertical;
        this.startPoint = startPoint;
        this.heathPoints = size;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Battleship that = (Battleship) o;
        return size == that.size && heathPoints == that.heathPoints && isVertical == that.isVertical && Objects.equals(startPoint, that.startPoint);
    }

    @Override
    public int hashCode() {
        return Objects.hash(size, heathPoints, isVertical, startPoint);
    }
}
