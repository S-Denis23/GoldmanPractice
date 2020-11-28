package essetial_new_structure.map_loader;

import essetial_new_structure.factory.DefaultSymbolObjectGenerator;
import essetial_new_structure.factory.ObjectGeneratorFactory;
import essetial_new_structure.objects.Coordinate;
import essetial_new_structure.objects.abstracts.AbstractGameObject;

/**
 * Created by Asus on 10.09.2020.
 */
public class DafaultMapLoader implements MapLoader {

    private String[][] initialData = {
            {"B", "G", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"GG", "G", "G", "GG", "GG", "GG", "E", "B", "B", "B", "G"},
            {"G", "G", "B", "B", "G", "B", "B", "G", "B", "B", "G"},
            {"G", "G", "B", "B", "G", "B", "B", "G", "B", "B", "G"},
            {"GG", "G", "G", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"},
            {"G", "B", "G", "G", "G", "G", "G", "P", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "GG", "G", "G", "B", "B", "G"},
            {"M", "B", "B", "B", "B", "B", "B", "B", "B", "B", "G"},
            {"M", "B", "G", "G", "G", "G", "G", "G", "B", "B", "G"},
            {"G", "G", "G", "B", "B", "G", "G", "G", "B", "B", "G"},
            {"G", "M", "B", "B", "B", "B", "B", "G", "B", "B", "G"}
    };

    private ObjectGeneratorFactory objectFactory = new DefaultSymbolObjectGenerator();

    @Override
    public AbstractGameObject[][] getData() {
        AbstractGameObject[][] data = new AbstractGameObject[initialData.length][initialData[0].length];

        for (int i = 0; i < initialData.length; i++) {
            for (int j = 0; j < initialData[i].length; j++) {
                String value = initialData[i][j];
                data[i][j] = objectFactory.getObject(value);
                Coordinate coordinate = new Coordinate(i, j);
                data[i][j].setCoordinate(coordinate);
            }
        }

        return data;
    }

}
