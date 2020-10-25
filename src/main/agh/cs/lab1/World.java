package agh.cs.lab1;

public class World {

//    public static void run(String[] args){
//        System.out.println(String.join(", ", args));
//        for(String argument: args){
//            switch(argument){
//                case "f":
//                    System.out.println("Do przodu");
//                    break;
//                case "b":
//                    System.out.println("Do tyłu");
//                    break;
//                case "l":
//                    System.out.println("W lewo");
//                    break;
//                case "r":
//                    System.out.println("W prawo");
//                    break;
//                default:
//            }
//        }
//    }


    public static void run(Direction[] args){
        for(Direction argument: args){
            switch(argument){
                case FORWARD:
                    System.out.println("Zwierzak idzie do przodu");
                    break;
                case BACKWARD:
                    System.out.println("Zwierzak idzie do tyłu");
                    break;
                case LEFT:
                    System.out.println("Zwierzak idzie w lewo");
                    break;
                case RIGHT:
                    System.out.println("Zwierzak idzie w prawo");
                    break;
                default:
            }
        }
    }

    public static Direction[] toDirection(String[] args){
        Direction[] direction = new Direction[args.length];
        int i = 0;
        for (String argument: args){
            switch(argument){
                case("f"):
                    direction[i] = Direction.FORWARD;
                    break;
                case("b"):
                    direction[i] = Direction.BACKWARD;
                    break;
                case("l"):
                    direction[i] = Direction.LEFT;
                    break;
                case("r"):
                    direction[i] = Direction.RIGHT;
                    break;
                default:

            }
            i++;
        }
        return direction;
    }

    public static void main(String[] args) {
        // write your code here
        System.out.println("Start");
        String array[] =new String[] {"f","b","r", "l"};
//        run(array);
//        run(new String[]{"f", "f", "g"});

        run(toDirection(new String[] {"f","f","b","r"}));

        System.out.println("Stop");
    }

}
