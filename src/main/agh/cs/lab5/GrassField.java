package main.agh.cs.lab5;

import main.agh.cs.lab2.Vector2d;
import main.agh.cs.lab4.Animal;


import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class GrassField extends AbstractWorldMap {
    public List<Grass> grassPos = new ArrayList<>();

    public GrassField(int number) {
        Random r = new Random();
        for (int i =0; i<number; i++){
            int x = r.nextInt((int) (Math.sqrt(number*10)+1));
            int y = r.nextInt((int) (Math.sqrt(number*10)+1));
            while (isOccupied(new Vector2d(x,y))){
                x = r.nextInt((int) (Math.sqrt(number*10)+1));
                y = r.nextInt((int) (Math.sqrt(number*10)+1));
            }
            grassPos.add(new Grass(new Vector2d(x,y)));
        }
    }

    @Override
    public Vector2d upperR(){
        Vector2d uR = animals.get(0).getPosition();
        for (Animal animal : animals){
            uR = uR.upperRight(animal.getPosition());
        }
        for (Grass grass : grassPos){
            uR = uR.upperRight(grass.getPosition());
        }

        return uR;

    }

    @Override
    public Vector2d lowerL(){
        Vector2d lL = animals.get(0).getPosition();
        for (Animal animal : animals){
            lL = lL.lowerLeft(animal.getPosition());
        }
        for (Grass grass : grassPos){
            lL = lL.lowerLeft(grass.getPosition());
        }
        return lL;
    }


    @Override
    public boolean canMoveTo(Vector2d position) {
        return !(objectAt(position) instanceof Animal);
    }


    @Override
    public boolean isOccupied(Vector2d position) {
        for (Grass grass : grassPos){
            if (grass.getPosition().equals(position)) return true;
        }
        for (Animal animal : animals){
            if (animal.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for(Animal animal : animals){
            if(animal.getPosition().equals(position))
                return animal;
        }
        for(Grass grass : grassPos){
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }
}