package essetial_new_structure.objects.abstracts;

import essetial_new_structure.objects.Coordinate;
import essetial_new_structure.objects.enums.Action;
import essetial_new_structure.objects.enums.Direction;
import essetial_new_structure.objects.enums.ObjectType;
import essetial_new_structure.objects.impl.Gold;
import essetial_new_structure.objects.impl.Ground;

import javax.swing.*;
import java.awt.*;

/**
 * Created by Asus on 10.09.2020.
 */
public abstract class MovableObject extends AbstractGameObject {

    private ImageIcon[] icons = new ImageIcon[4];
    private Direction direction = Direction.UP;

    public MovableObject(ObjectType type) {
        super(type);
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }

    @Override
    public ImageIcon getImage() {
        try {
            return icons[direction.getValue()];
        } catch (Exception e) {
            return icons[0];
        }
    }

    protected void addImageIcon(int index, ImageIcon icon) {
        icons[index] = icon;
    }

    public boolean checkToGo(AbstractGameObject nextObject) {

        if (nextObject == null) {
            return false;
        }

        switch (nextObject.getType()){
            case GROUND:
            case GOLD:
             return true;
        }

        return false;
    }

    public Action getAction(AbstractGameObject nextObject) {

        if (nextObject == null) {
            return Action.NOTHING;
        }

        if (nextObject.getType() == ObjectType.GROUND) {
            return Action.MOVE;
        }

        return Action.NOTHING;
    }

    public Coordinate getCoordinateNextObject(Direction direction) {
        int x = getCoordinate().getX();
        int y = getCoordinate().getY();


        switch (direction) {
            case UP:
                y--;
                break;
            case DOWN:
                y++;
                break;
            case LEFT:
                x--;
                break;
            case RIGHT:
                x++;
                break;
        }

        Coordinate coordinate = new Coordinate(y, x);

        return coordinate;

    }

}
