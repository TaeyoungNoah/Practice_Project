package subway.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Line {
    private String name;
    private static List<Station> lineStations = new ArrayList<>();

    public Line(String name) {
        this.name = name;
    }
    public static List<Station> stations() {
        return Collections.unmodifiableList(lineStations);
    }
    public String getName() {
        return name;
    }

    public void addLineStations(Station station){
        lineStations.add(station);
    }
}
