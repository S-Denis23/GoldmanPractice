package essetial_new_structure.collection;

import essetial_new_structure.objects.Coordinate;
import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.enums.Direction;
import essetial_new_structure.objects.enums.ObjectType;
import essetial_new_structure.objects.impl.Goldman;
import essetial_new_structure.observer.StepsNotifier;
import essetial_new_structure.strategy.MovingStrategy;

/**
 * Created by Asus on 10.09.2020.
 */
public interface GameCollection extends StepsNotifier {

    AbstractGameObject[][] getModel();

    void moveMovableObject(Direction direction, ObjectType type);

    void moveMovableObject(MovingStrategy strategy, ObjectType type);

    void setObjectByCoordinate(Coordinate coordinate, AbstractGameObject object);

    void setObject(AbstractGameObject object);

    AbstractGameObject getObjectByCoordinate(Coordinate coordinate);

    Goldman getGoldman();


}
