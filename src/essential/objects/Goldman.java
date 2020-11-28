package essential.objects;

import essential.Map;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Goldman extends AbstractGameObject {

    public Goldman(Map map) {
        super(map);
        setImage(new ImageIcon(getClass().getResource("/images/goldman_up.png")));
    }

    public void move(int direction) throws Exception {

        int x = getX();
        int y = getY();

        Ground ground = new Ground(getMap());

        getMap().setObjectByCoordinate(getY(), getX(), ground);


        switch (direction) {
            case 1:
                y--;
                break;
            case 2:
                y++;
                break;
            case 3:
                x--;
                break;
            case 4:
                x++;
                break;
        }

        getMap().setObjectByCoordinate(y, x, this);
        getMap().drawTable();
        Thread.sleep(1500);
    }

}
