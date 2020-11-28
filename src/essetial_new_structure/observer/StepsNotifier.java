package essetial_new_structure.observer;


import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.Action;
import essetial_new_structure.objects.impl.Goldman;

/**
 * Created by Asus on 05.10.2020.
 */
public interface StepsNotifier {

    void notifyAllSubribers(MovableObject movableObject, Action action);

    void addSubscriber(StepsSubscriber subscriber);

}
