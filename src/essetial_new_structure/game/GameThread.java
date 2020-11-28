package essetial_new_structure.game;

import essetial_new_structure.collection.GameCollection;
import essetial_new_structure.objects.enums.ObjectType;
import essetial_new_structure.strategy.AgressiveStrategy;
import essetial_new_structure.strategy.RandomDirectionStrategy;

/**
 * Created by Asus on 24.10.2020.
 */
public class GameThread extends Thread {

    private GameCollection collection;
    private volatile boolean runTheGame = true;

    public GameThread(GameCollection collection) {
        this.collection = collection;
    }

    public void stopGame() {
        runTheGame = false;
    }

    @Override
    public void start() {
        while (runTheGame) {
            collection.moveMovableObject(new AgressiveStrategy(), ObjectType.MONSTER);

            try {
                Thread.sleep(300);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

        }
    }

}
