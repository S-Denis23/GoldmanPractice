package essetial_new_structure.objects.enums;

/**
 * Created by Asus on 05.10.2020.
 */
public enum Direction {

    UP(0), DOWN(1), LEFT(2), RIGHT(3), NONE(-1);

    Direction(int value) {
        this.value = value;
    }

    private int value;

    public int getValue() {
        return value;
    }

}
