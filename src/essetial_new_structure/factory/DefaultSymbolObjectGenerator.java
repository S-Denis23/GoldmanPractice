package essetial_new_structure.factory;


import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.enums.ObjectType;
import essetial_new_structure.objects.impl.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class DefaultSymbolObjectGenerator implements ObjectGeneratorFactory {

    @Override
    public AbstractGameObject getObject(String symbol) {

        if (symbol.equals("B")) {
            return new Wall(ObjectType.WALL);
        } else if (symbol.equals("G")) {
            return new Ground(ObjectType.GROUND);
        } else if (symbol.equals("GG")) {
            return new Gold(ObjectType.GOLD);
        } else if (symbol.equals("P")) {
            return new Goldman(ObjectType.GOLDMAN);
        } else if (symbol.equals("E")) {
            return new Exit(ObjectType.EXIT);
        } else if (symbol.equals("M")) {
            return new Monster(ObjectType.MONSTER);
        }

        return null;
    }
}
