package main.agh.cs.lab5;

import main.agh.cs.lab2.Vector2d;


public class RectangularMap extends AbstractWorldMap {
    private int width;
    private int height;

    public RectangularMap(int width, int height){
        this.width = width;
        this.height = height;
    }

    @Override
    public Vector2d upperR() {
        return new Vector2d(this.width-1,this.height-1);
    }

    @Override
    public Vector2d lowerL() {
        return new Vector2d(0,0);
    }

    @Override
    public boolean canMoveTo(Vector2d position) {
        return position.follows(new Vector2d(0,0)) && position.precedes(new Vector2d(this.width-1,this.height-1))
                && !isOccupied(position);
    }



}