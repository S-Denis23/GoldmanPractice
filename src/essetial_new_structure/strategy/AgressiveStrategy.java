package essetial_new_structure.strategy;

import essetial_new_structure.collection.GameCollection;
import essetial_new_structure.objects.Coordinate;
import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.Direction;
import essetial_new_structure.objects.enums.ObjectType;

import java.util.Random;

/**
 * Created by Asus on 24.10.2020.
 */
public class AgressiveStrategy implements MovingStrategy {

    @Override
    public Direction getDirection(MovableObject current, GameCollection collection) {

        Direction[] directions = Direction.values();

        Direction resultDirection;

        for (Direction direction : directions) {
            resultDirection = getDirection(collection, current, direction);

            if (resultDirection != Direction.NONE) {
                return resultDirection;
            }

        }

        int counter = 0;

        do {
            Random random = new Random();
            int rendomIndex = random.nextInt(4);
            resultDirection = directions[rendomIndex];
            System.out.println(resultDirection + " " + current);
            counter++;
        } while (!isGround(collection, current, resultDirection) && counter < 20);


        return resultDirection;
    }

    private Direction getDirection(GameCollection collection, MovableObject movableObject, Direction direction) {
        Coordinate coordinate = movableObject.getCoordinateNextObject(direction);
        AbstractGameObject object = collection.getObjectByCoordinate(coordinate);

        if (object != null && object.getType() == ObjectType.GOLDMAN) {
            return direction;
        }

        return Direction.NONE;
    }

    private boolean isGround(GameCollection collection, MovableObject movableObject, Direction direction) {
        Coordinate coordinate = movableObject.getCoordinateNextObject(direction);
        AbstractGameObject object = collection.getObjectByCoordinate(coordinate);

        if (object != null && object.getType() == ObjectType.GROUND) {
            return true;
        }

        return false;
    }

}
