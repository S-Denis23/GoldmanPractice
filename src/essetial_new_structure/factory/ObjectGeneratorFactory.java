package essetial_new_structure.factory;


import essetial_new_structure.objects.abstracts.AbstractGameObject;

/**
 * Created by Asus on 10.09.2020.
 */
public interface ObjectGeneratorFactory {

    AbstractGameObject getObject(String symbol);
}
