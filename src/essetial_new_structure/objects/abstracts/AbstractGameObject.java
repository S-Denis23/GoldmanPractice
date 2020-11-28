package essetial_new_structure.objects.abstracts;

import essetial_new_structure.gui.Map;
import essetial_new_structure.objects.Coordinate;
import essetial_new_structure.objects.enums.ObjectType;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public abstract class AbstractGameObject {

    Coordinate coordinate;
    private ImageIcon image;
    private ObjectType type;

    public AbstractGameObject(ObjectType type) {
        this.type = type;
    }

    public AbstractGameObject() {

    }

    public Coordinate getCoordinate() {
        return coordinate;
    }

    public void setCoordinate(Coordinate coordinate) {
        this.coordinate = coordinate;
    }

    public ImageIcon getImage() {
        return image;
    }

    public void setImage(ImageIcon image) {
        this.image = image;
    }

    public ObjectType getType() {
        return type;
    }


}
