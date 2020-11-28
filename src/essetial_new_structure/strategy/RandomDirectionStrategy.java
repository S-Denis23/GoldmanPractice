package essetial_new_structure.strategy;

import essetial_new_structure.collection.GameCollection;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.Direction;

import java.util.Random;

/**
 * Created by admin on 22.10.2020.
 */
public class RandomDirectionStrategy implements MovingStrategy {

    @Override
    public Direction getDirection(MovableObject current, GameCollection collection) {
        Direction[] directions = Direction.values();
        Random random = new Random();
        int rendomIndex = random.nextInt(4);
        return directions[rendomIndex];
    }

}
