package essetial_new_structure.collection;

import essetial_new_structure.exception.GoldmanNotFoundException;
import essetial_new_structure.map_loader.DafaultMapLoader;
import essetial_new_structure.map_loader.MapLoader;
import essetial_new_structure.objects.Coordinate;
import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.Action;
import essetial_new_structure.objects.enums.Direction;
import essetial_new_structure.objects.enums.ObjectType;
import essetial_new_structure.objects.impl.Goldman;
import essetial_new_structure.objects.impl.Ground;
import essetial_new_structure.strategy.MovingStrategy;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Asus on 10.09.2020.
 */
public class ArrayCollection extends AbstractGameCollection{

    private AbstractGameObject[][] data;
    private List<MovableObject> movableObjects = new ArrayList<>();

    public ArrayCollection() {
        initData();

        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] instanceof MovableObject) {
                    MovableObject movableObject = (MovableObject) data[i][j];
                    movableObjects.add(movableObject);
                }
            }
        }

    }

    private void initData() {
        data = getData();
    }

    @Override
    public AbstractGameObject[][] getModel() {
        return data;
    }

    @Override
    public void moveMovableObject(Direction direction, ObjectType type) {

        for (MovableObject movableObject : movableObjects) {

            if (type == movableObject.getType()) {
                actionMovableObjectByDirection(movableObject, direction);
            }

        }

    }


    @Override
    public void moveMovableObject(MovingStrategy strategy, ObjectType type) {

        for (MovableObject movableObject : movableObjects) {

            if (type == movableObject.getType()) {
                Direction direction = strategy.getDirection(movableObject,this);
                actionMovableObjectByDirection(movableObject, direction);
            }
        }
    }

    @Override
    public void setObjectByCoordinate(Coordinate coordinate, AbstractGameObject object) {
        object.setCoordinate(coordinate);
        data[coordinate.getY()][coordinate.getX()] = object;
    }


    @Override
    public void setObject(AbstractGameObject object) {
        data[object.getCoordinate().getY()][object.getCoordinate().getX()] = object;
    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        try {
            return data[coordinate.getY()][coordinate.getX()];
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public Goldman getGoldman() {
        for (MovableObject movableObject : movableObjects) {
           if (movableObject.getType() == ObjectType.GOLDMAN) {
               return (Goldman) movableObject;
           }
        }
        throw new GoldmanNotFoundException("Goldman must be in the map");
    }




}
