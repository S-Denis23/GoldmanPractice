package essetial_new_structure.collection;


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

import java.util.*;
import java.util.Map;

/**
 * Created by Asus on 05.10.2020.
 */
public class MapCollection extends AbstractGameCollection {

    private Map<Coordinate, AbstractGameObject> objects = new HashMap<>();
    private Map<ObjectType, List<MovableObject>> movableObjects = new HashMap<>();

    private int columnsCount;
    private int rowsCount;

    public MapCollection() {
        initData();
    }

    private void initData() {
        AbstractGameObject[][] data = getData();

        columnsCount = data.length;
        rowsCount = data[0].length;

        for (AbstractGameObject[] currentColumn : data) {
            for (AbstractGameObject currentObject : currentColumn) {
                Coordinate coordinate = currentObject.getCoordinate();
                objects.put(coordinate, currentObject);

                if (currentObject instanceof MovableObject) {
                    List<MovableObject> listMovable = movableObjects.get(currentObject.getType());

                    if (listMovable == null) {
                        listMovable = new ArrayList<>();
                        movableObjects.put(currentObject.getType(), listMovable);
                    }

                    MovableObject movableObject = (MovableObject) currentObject;
                    listMovable.add(movableObject);
                }

            }
        }
    }

    @Override
    public AbstractGameObject[][] getModel() {
        AbstractGameObject[][] data = new AbstractGameObject[columnsCount][rowsCount];

        Set< Map.Entry<Coordinate, AbstractGameObject> > allObjects = objects.entrySet();

        for (Map.Entry<Coordinate, AbstractGameObject> entry : allObjects) {
            Coordinate coordinate = entry.getKey();
            AbstractGameObject object = entry.getValue();
            data[coordinate.getY()][coordinate.getX()] = object;
        }

        return data;
    }

    @Override
    public void moveMovableObject(Direction direction, ObjectType type) {

        List<MovableObject> listMovable = movableObjects.get(type);

        for (MovableObject movableObject : listMovable) {
            actionMovableObjectByDirection(movableObject, direction);
        }

    }





    @Override
    public void moveMovableObject(MovingStrategy strategy, ObjectType type) {

    }

    @Override
    public void setObjectByCoordinate(Coordinate coordinate, AbstractGameObject object) {

    }

    @Override
    public void setObject(AbstractGameObject object) {

    }

    @Override
    public AbstractGameObject getObjectByCoordinate(Coordinate coordinate) {
        return objects.get(coordinate);
    }

    @Override
    public Goldman getGoldman() {
        List<MovableObject> all = movableObjects.get(ObjectType.GOLDMAN);
        return (Goldman) all.get(0);
    }


}
