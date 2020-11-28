package essetial_new_structure.strategy;

import essetial_new_structure.collection.GameCollection;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.Direction;

/**
 * Created by admin on 22.10.2020.
 */
public interface MovingStrategy {

    Direction getDirection(MovableObject current, GameCollection collection);

}
