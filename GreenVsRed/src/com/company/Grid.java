package com.company;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Grid {
    private final List<Point> Points;
    private final int x,y;

    public Grid(int x, int y) {
        this.x = x;
        this.y = y;
        Points = new ArrayList<>(x*y);
    }

    public List getPoints() {
        return Points;
    }

    public void nextGeneration() {
        List<Point> toFlip = new ArrayList<>(x*y);
        for(Point p: Points) {
            Point tl = getPoint(p.getX()-1, p.getY()-1);
            Point t = getPoint(p.getX(), p.getY()-1);
            Point tr = getPoint(p.getX()+1, p.getY()-1);
            Point l = getPoint(p.getX()-1, p.getY());
            Point r = getPoint(p.getX()+1, p.getY());
            Point bl = getPoint(p.getX()-1, p.getY()+1);
            Point b = getPoint(p.getX(), p.getY()+1);
            Point br = getPoint(p.getX()+1, p.getY()+1);

            List<Point> neighbours = Arrays.asList(tl, t, tr, l, r, bl, b, br);

            if(updateCell(neighbours, p)) {
                toFlip.add(p);
            }
        }

        for(Point p: toFlip) {
            p.getCell().flip();
        }
    }

    private boolean updateCell(List<Point> neighbours, Point p) {
       Integer greenCount = 0;
        for(Point neighbour: neighbours) {
            if(!(neighbour.getY() == -1)) {
                if(neighbour.getCell().isCellType()) {
                    greenCount = greenCount + 1;
                }
            }
        }

        if(p.getCell().isCellType()) {
            return !(greenCount.equals(2) || greenCount.equals(3) || greenCount.equals(6));
        } else {
            return greenCount.equals(3) || greenCount.equals(6);
        }

    }


    public Point getPoint(int x, int y) {
        for(Point p: Points) {
            if(p.getX() == x && p.getY() == y) {
                return p;
            }
        }
        return new Point(-1, -1);
    }

}
