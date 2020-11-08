package main.agh.cs.lab2;

public class Vector2d {
    public final int x;
    public final int y;

    public Vector2d(int x, int y){
        this.x = x;
        this.y = y;
    }

    public String toString(){
        return "(" + this.x + "," + this.y +")";
    }

    public boolean precedes(Vector2d other){
        return (this.x <= other.x && this.y <= other.y);
    }

    public boolean follows(Vector2d other){
        return(this.x >= other.x && this.y >= other.y);
    }

    public Vector2d upperRight(Vector2d other){
        int a;
        int b;
        if (this.x >= other.x)
            a = this.x;
        else
            a = other.x;
        if (this.y >= other.y)
            b = this.y;
        else
            b = other.y;
        return new Vector2d(a,b);
    }

    public Vector2d lowerLeft(Vector2d other){
        int a;
        int b;
        if (this.x <= other.x)
            a = this.x;
        else
            a = other.x;
        if (this.y <= other.y)
            b = this.y;
        else
            b = other.y;
        return new Vector2d(a,b);
    }

    public Vector2d add(Vector2d other){
        return new Vector2d(this.x + other.x,this.y + other.y);
    }

    public Vector2d substract(Vector2d other){
        return new Vector2d(this.x - other.x,this.y - other.y);
    }

    public boolean equals(Object other){
        if (this == other)
            return true;
        if (!(other instanceof Vector2d))
            return false;
        Vector2d vector = (Vector2d) other;
        return (this.x == vector.x && this.y == vector.y);
    }

    public Vector2d opposite(){
        return new Vector2d(-this.x, -this.y);
    }

}


