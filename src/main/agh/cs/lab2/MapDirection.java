package main.agh.cs.lab2;

import java.util.Map;

public enum MapDirection {
    NORTH,
    EAST,
    SOUTH,
    WEST;

    public String toString(){
        switch(this) {
            case NORTH:
                return "Północ";
            case SOUTH:
                return "Południe";
            case WEST:
                return "Zachód";
            case EAST:
                return "Wschód";
            default:
                return "Error";

        }
    }

    public MapDirection next(){
            return MapDirection.values()[(this.ordinal()+1) % MapDirection.values().length];
    }

    public MapDirection previous(){
        return MapDirection.values()[(this.ordinal()+3) % MapDirection.values().length];
    }

    public Vector2d toUnitVector(){
        switch(this){
            case NORTH:
                return new Vector2d(0,1);
            case SOUTH:
                return new Vector2d(0,-1);
            case EAST:
                return new Vector2d(1,0);
            case WEST:
                return new Vector2d(-1,0);
            default:
                return null;
        }
    }


}
