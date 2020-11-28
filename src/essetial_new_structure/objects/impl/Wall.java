package essetial_new_structure.objects.impl;

import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.enums.ObjectType;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Wall extends AbstractGameObject {

    public Wall(ObjectType type) {
        super(type);
        setImage(new ImageIcon(getClass().getResource("/images/wall.png")));
    }

}
