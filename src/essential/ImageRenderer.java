package essential;

import essential.objects.AbstractGameObject;

import javax.swing.*;
import javax.swing.table.DefaultTableCellRenderer;
import java.awt.*;

/**
 * Created by Asus on 17.08.2020.
 */
public class ImageRenderer extends DefaultTableCellRenderer {

    private JLabel lbl = new JLabel();

    @Override
    public Component getTableCellRendererComponent(JTable table, Object value, boolean isSelected,
                                                   boolean hasFocus, int row, int column) {

        lbl.setText(null);

        AbstractGameObject object = (AbstractGameObject) value;

        lbl.setIcon(object.getImage());

        return lbl;
    }

}
