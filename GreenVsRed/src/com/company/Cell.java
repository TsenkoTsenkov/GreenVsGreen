package com.company;

public abstract class Cell{
    private boolean CellType;

    public Cell(boolean CellType) {
        this.CellType = CellType;
    }

    public boolean isCellType() {
        return CellType;
    }

    void flip() {
        CellType = !CellType;
    }
}
