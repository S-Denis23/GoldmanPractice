package essential.objects;

import essential.Map;

import javax.swing.*;

/**
 * Created by Asus on 10.09.2020.
 */
public class Monster extends AbstractGameObject {

    public Monster(Map map) {
        super(map);
        setImage(new ImageIcon(getClass().getResource("/images/monster_up.jpg")));
    }

}
