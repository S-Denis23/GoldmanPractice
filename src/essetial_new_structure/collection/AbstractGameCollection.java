package essetial_new_structure.collection;

import essetial_new_structure.map_loader.DafaultMapLoader;
import essetial_new_structure.map_loader.MapLoader;
import essetial_new_structure.objects.Coordinate;
import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.Action;
import essetial_new_structure.objects.enums.Direction;
import essetial_new_structure.objects.enums.ObjectType;
import essetial_new_structure.objects.impl.Ground;
import essetial_new_structure.observer.StepsSubscriber;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by admin on 10.11.2020.
 */
public abstract class AbstractGameCollection implements GameCollection {

    private List<StepsSubscriber> subscribers = new ArrayList<>();
    private MapLoader mapLoader = new DafaultMapLoader();

    @Override
    public void notifyAllSubribers(MovableObject movableObject, Action action) {
        for (StepsSubscriber subscriber : subscribers) {
            subscriber.notify(movableObject, action);
        }
    }

    @Override
    public void addSubscriber(StepsSubscriber subscriber) {
        subscribers.add(subscriber);
    }

    protected AbstractGameObject[][] getData() {
        return mapLoader.getData();
    }

    protected void swapObjects(Coordinate nextCoordinate,
                             AbstractGameObject nextObject, AbstractGameObject currentObject) {
        setObjectByCoordinate(
                new Coordinate(currentObject.getCoordinate().getY(), currentObject.getCoordinate().getX()),
                nextObject);
        setObjectByCoordinate(nextCoordinate, currentObject);
    }

    protected void actionMovableObjectByDirection(MovableObject movableObject, Direction direction) {
        movableObject.setDirection(direction);
        Coordinate nextCoordinate = movableObject.getCoordinateNextObject(direction);
        AbstractGameObject nextObj = getObjectByCoordinate(nextCoordinate);
        Action action = movableObject.getAction(nextObj);

        switch (action) {
            case MOVE:
                swapObjects(nextCoordinate, nextObj, movableObject);
            case GIVE_GOLD:
                swapObjects(nextCoordinate, new Ground(ObjectType.GROUND), movableObject);

        }

        notifyAllSubribers(movableObject, action);
    }

}
