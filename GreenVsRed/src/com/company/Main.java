package com.company;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x,y;

        String line;
        String[] separatedLine;
        line = scanner.nextLine();
        separatedLine = line.split(", ");

        x = Integer.parseInt(separatedLine[0]);
        y = Integer.parseInt(separatedLine[1]);

        Grid grid = new Grid(x, y);

        for(int i=0; i<y; i++) {
            line = scanner.nextLine();
            for(int j=0; j<x; j++) {
                Cell cell;
                if(line.getBytes()[j] == '0') {
                    cell = new RedCell();
                } else {
                    cell = new GreenCell();
                }
                Point point = new Point(j, i);
                point.setCell(cell);
                grid.getPoints().add(point);
            }
        }
        line = scanner.nextLine();
        separatedLine = line.split(", ");

        x = Integer.parseInt(separatedLine[0]);
        y = Integer.parseInt(separatedLine[1]);

        int countChange = 0;

        int iterations = Integer.parseInt(separatedLine[2]);
        for(int i=0; i<iterations; i++) {
            if(grid.getPoint(x, y).getCell().isCellType()) {
                countChange++;
            }
            grid.nextGeneration();
        }
        /*I understand that this check is the same as in line 46 and the code is repetitive,
        but I don't think putting it in a separate function would improve the code quality that much*/

        if(grid.getPoint(x, y).getCell().isCellType()) {
            countChange++;
        }

        System.out.println(countChange);

    }
}
