package subway.model;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

public class LineRepository {
    private static final List<Line> lines = new ArrayList<>();

    public static List<Line> lines() {
        return Collections.unmodifiableList(lines);
    }
    // lines 에 노선을 추가하는 메서드
    public static void addLine(Line line) {
        lines.add(line);
    }

    // Line 객체의 이름으로 부터 lines 의 Line 객체를 찾아서 반환하는 메서드
    public static Line getLine(String lineName) {
        for(Line i : lines){
            if(i.getName().equals(lineName)){
                return i;
            }
        }
        return null;
    }

    public static boolean deleteLineByName(String name) {
        return lines.removeIf(line -> Objects.equals(line.getName(), name));
    }

}
