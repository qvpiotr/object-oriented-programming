package main.agh.cs.lab6;



import java.util.*;

public class GrassField extends AbstractWorldMap {
//    public List<main.agh.cs.lab6.Grass> grassPos = new ArrayList<>();


    public GrassField(int number) {
        Random r = new Random();
        for (int i =0; i<number; i++){
            int x = r.nextInt((int) (Math.sqrt(number*10)+1));
            int y = r.nextInt((int) (Math.sqrt(number*10)+1));
            while (isOccupied(new Vector2d(x,y))){
                x = r.nextInt((int) (Math.sqrt(number*10)+1));
                y = r.nextInt((int) (Math.sqrt(number*10)+1));
            }
            grassPos.put(new Vector2d(x,y),new Grass(new Vector2d(x,y)));
        }
    }

    @Override
    public Vector2d upperR(){
        Vector2d firstKey = animals.keySet().stream().findFirst().get();
        Vector2d uR = animals.get(firstKey).getPosition();
        for (Animal animal : animals.values()){
            uR = uR.upperRight(animal.getPosition());
        }
        for (main.agh.cs.lab6.Grass grass : grassPos.values()){
            uR = uR.upperRight(grass.getPosition());
        }

        return uR;

    }

    @Override
    public Vector2d lowerL(){
        Vector2d firstKey = animals.keySet().stream().findFirst().get();
        Vector2d lL = animals.get(firstKey).getPosition();
        for (Animal animal : animals.values()){
            lL = lL.lowerLeft(animal.getPosition());
        }
        for (main.agh.cs.lab6.Grass grass : grassPos.values()){
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
        for (Grass grass : grassPos.values()){
            if (grass.getPosition().equals(position)) return true;
        }
        for (Animal animal : animals.values()){
            if (animal.getPosition().equals(position)) return true;
        }
        return false;
    }

    @Override
    public Object objectAt(Vector2d position){
        for(Animal animal : animals.values()){
            if(animal.getPosition().equals(position))
                return animal;
        }
        for(Grass grass : grassPos.values()){
            if(grass.getPosition().equals(position))
                return grass;
        }
        return null;
    }
}