package essential;

import essential.objects.*;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import java.awt.*;

public class Map extends JPanel {

    final int BF_WIDTH = 576;
    final int BF_HEIGHT = 576;

    private Goldman goldman;

    int score = 0;
    int countSteps = 50;
    String gameStatus = "Play Game :)";

// B - Brick, GG - Gold, P - Player, G - Ground, E - Exit
    String[][] initialData = {
            {"B", "G", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"GG", "G", "G", "GG", "GG", "GG", "E", "B", "B", "B", "G"},
            {"G", "G", "B", "B", "G", "B", "B", "G", "B", "B", "G"},
            {"G", "G", "B", "B", "M", "B", "B", "M", "B", "B", "G"},
            {"GG", "G", "G", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "B", "G", "G", "G", "G", "G", "P", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "GG", "G", "GG", "B", "B", "G"},
            {"M", "B", "B", "B", "B", "B", "B", "B", "B", "B", "G"},
            {"M", "B", "G", "G", "G", "G", "G", "G", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "G", "G", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"}
    };

    private AbstractGameObject[][] data;

    public void setObjectByCoordinate(int y, int x, AbstractGameObject object) {
        object.setX(x);
        object.setY(y);
        data[y][x] = object;
    }

    private void initData() {
        data = new AbstractGameObject[initialData.length][initialData[0].length];

        for (int i = 0; i < initialData.length; i++) {
            for (int j = 0; j < initialData[i].length; j++) {
               String value = initialData[i][j];

               if (value.equals("B")) {
                   data[i][j] = new Wall(this);
               } else if (value.equals("G")) {
                   data[i][j] = new Ground(this);
               } else if (value.equals("GG")) {
                   data[i][j] = new Gold(this);
               } else if (value.equals("P")) {
                   goldman = new Goldman(this);
                   data[i][j] = goldman;
               } else if (value.equals("E")) {
                   data[i][j] = new Exit(this);
               } else if (value.equals("M")) {
                   data[i][j] = new Monster(this);
               }

               data[i][j].setY(i);
               data[i][j].setX(j);
            }
        }

    }



    void runTheGame() throws Exception {
        for (int i = 0; i < 6; i++) {
            goldman.move(1);
        }
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
    JLabel labelGameStatus = new JLabel();


    public Map() {

        initData();
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
        add(labelGameStatus);
        frame.setMinimumSize(new Dimension(BF_WIDTH,BF_HEIGHT + 22));
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.getContentPane().add(this);
        frame.setVisible(true);
    }

    private void score() {
        labelScore.setText("Score: " + score);
    }

    private void countSteps() {
        labelSteps.setText("Count steps: " + countSteps);
    }

    private void gameStatus() {
        labelGameStatus.setText(gameStatus);
    }

    public void drawTable() {


        table.setModel(new DefaultTableModel(data, column));

        for (int i = 0; i < table.getColumnCount(); i++) {
            table.getColumnModel().getColumn(i).setCellRenderer(new ImageRenderer());
            TableColumn a = table.getColumnModel().getColumn(i);
            a.setPreferredWidth(26);
        }

        score();
        countSteps();
        gameStatus();

    }

}
