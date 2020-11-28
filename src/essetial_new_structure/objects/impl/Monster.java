package essetial_new_structure.objects.impl;

import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.*;
import essetial_new_structure.objects.enums.Action;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Monster extends MovableObject {

    public Monster(ObjectType type) {
        super(type);
        //setImage(new ImageIcon(getClass().getResource("/images/monster_up.jpg")));

        addImageIcon(0, new ImageIcon(getClass().getResource("/images/monster_up.jpg")));
        addImageIcon(1, new ImageIcon(getClass().getResource("/images/monster_down.jpg")));
        addImageIcon(2, new ImageIcon(getClass().getResource("/images/monster_left.jpg")));
        addImageIcon(3, new ImageIcon(getClass().getResource("/images/monster_right.jpg")));
    }


    @Override
    public Action getAction(AbstractGameObject nextObject) {

        if (nextObject == null) {
            return Action.NOTHING;
        }

        if (nextObject.getType() == ObjectType.GOLDMAN) {
            return Action.DIE;
        }
        return super.getAction(nextObject);
    }
}
