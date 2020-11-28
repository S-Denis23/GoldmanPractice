package essetial_new_structure.gui;

import essetial_new_structure.ImageRenderer;
import essetial_new_structure.collection.ArrayCollection;
import essetial_new_structure.collection.GameCollection;
import essetial_new_structure.collection.MapCollection;
import essetial_new_structure.exception.GoldmanNotFoundException;
import essetial_new_structure.game.GameThread;
import essetial_new_structure.objects.abstracts.MovableObject;
import essetial_new_structure.objects.enums.*;
import essetial_new_structure.objects.enums.Action;
import essetial_new_structure.objects.impl.Goldman;
import essetial_new_structure.observer.StepsSubscriber;
import essetial_new_structure.strategy.RandomDirectionStrategy;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class Map extends JPanel implements StepsSubscriber, KeyListener {

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;


    private GameCollection collection = new ArrayCollection();

    {
        collection.addSubscriber(this);
    }

    private GameThread gameThread;


    private void runTheGame() throws Exception {
        gameThread = new GameThread(collection);
        gameThread.start();
    }


    // Не смотрите код, что написан ниже. Со временем Вы будете понимать этот код.


    public static void main(String[] args) throws Exception {
        Map main = new Map();
        main.runTheGame();
    }


    JTable table;
    String[] column = new String[11];
    JLabel labelScore = new JLabel();
    JLabel labelSteps = new JLabel();


    public Map() {
        JFrame frame = new JFrame("Goldman");

        table = new JTable();

        table.setTableHeader(null);
        table.setEnabled(false);
        table.setSize(new Dimension(300, 300));
        table.setRowHeight(26);
        table.setRowSelectionAllowed(false);
        table.setShowHorizontalLines(false);
        table.setShowVerticalLines(false);
        table.setUpdateSelectionOnSort(false);
        table.setVerifyInputWhenFocusTarget(false);

        for (int i = 0; i < column.length; i++) {
            column[i] = "";
        }

        drawTable();

        add(table);
        add(labelScore);
        add(labelSteps);
        frame.setMinimumSize(new Dimension(BF_WIDTH,BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
        initGoldmanData();
        frame.addKeyListener(this);
    }

    private void initGoldmanData() {
        try {
            Goldman goldman = collection.getGoldman();
            labelSteps.setText("Count steps: " + goldman.getCountSteps());
            labelScore.setText("Score: " + goldman.getScore());
        } catch (GoldmanNotFoundException e) {
            showMessage(e.getMessage());
        }
    }




    public void drawTable() {

        table.setModel(new DefaultTableModel(collection.getModel(), column));

        System.out.println(table.getColumnCount());

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
            TableColumn a = table.getColumnModel().getColumn(i);
            a.setPreferredWidth(26);
        }

    }

    @Override
    public void notify(MovableObject movableObject, Action action) {

        switch (action) {
            case MOVE:
                if (movableObject.getType() == ObjectType.GOLDMAN) {
                    Goldman goldman = (Goldman) movableObject;
                    goldman.updateCountSteps();
                    labelSteps.setText("Count steps: " + goldman.getCountSteps());

                    if (goldman.getCountSteps() == 0) {
                        showMessage("Game Over :(");
                    }

                }
                break;
            case GIVE_GOLD:
                updateGoldmanScore(movableObject, 5);
                break;
            case DIE:
                showMessage("Game Over :(");
                break;
            case WIN:
                Goldman goldman = (Goldman) movableObject;
                showMessage("You Win!!! " + goldman.getScore() + " scores");
                updateGoldmanScore(movableObject, 10);

        }


        drawTable();
    }

    private void showMessage(String message) {
        gameThread.stopGame();
        SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {
                JOptionPane.showMessageDialog(null, message, "Сообщение", JOptionPane.PLAIN_MESSAGE);
            }
        });
    }


    private void updateGoldmanScore(MovableObject movableObject, int score) {
        Goldman man = (Goldman) movableObject;
        man.upadateScore(score);
        labelScore.setText("Your score: " + man.getScore());
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        switch (e.getKeyCode()) {
            case KeyEvent.VK_UP :
                collection.moveMovableObject(Direction.UP, ObjectType.GOLDMAN);
                break;
            case KeyEvent.VK_DOWN :
                collection.moveMovableObject(Direction.DOWN, ObjectType.GOLDMAN);
                break;
            case KeyEvent.VK_LEFT :
                collection.moveMovableObject(Direction.LEFT, ObjectType.GOLDMAN);
                break;
            case KeyEvent.VK_RIGHT :
                collection.moveMovableObject(Direction.RIGHT, ObjectType.GOLDMAN);
                break;
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

}
