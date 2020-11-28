package essetial_new_structure.objects.impl;

import essetial_new_structure.objects.abstracts.AbstractGameObject;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.*;
import essetial_new_structure.objects.enums.Action;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Goldman extends MovableObject {

    private int score = 0;
    private int countSteps = 50;

    public Goldman(ObjectType type) {
        super(type);
        //setImage(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
        addImageIcon(0, new ImageIcon(getClass().getResource("/images/goldman_up.png")));
        addImageIcon(1, new ImageIcon(getClass().getResource("/images/goldman_down.png")));
        addImageIcon(2, new ImageIcon(getClass().getResource("/images/goldman_left.png")));
        addImageIcon(3, new ImageIcon(getClass().getResource("/images/goldman_right.png")));
    }

    public void upadateScore(int score) {
        this.score += score;
    }

    public void updateCountSteps() {
        countSteps--;
    }

    public int getScore() {
        return score;
    }

    public int getCountSteps() {
        return countSteps;
    }

    @Override
    public Action getAction(AbstractGameObject nextObject) {

        if (nextObject == null) {
            return Action.NOTHING;
        }

        switch (nextObject.getType()) {
            case GOLD:
                return Action.GIVE_GOLD;
            case MONSTER:
                return Action.DIE;
            case EXIT:
                return Action.WIN;
        }

        return super.getAction(nextObject);
    }
}
