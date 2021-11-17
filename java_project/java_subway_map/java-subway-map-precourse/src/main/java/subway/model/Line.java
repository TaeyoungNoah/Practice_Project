package subway.model;

import java.util.ArrayList;

public class Line {
    private String name;
    private ArrayList<Station> lineStations = new ArrayList<>();
    public Line(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void addLineStations(Station station){
        lineStations.add(station);
    }
}
