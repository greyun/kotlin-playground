package kotlininaction.ch03.part1;

import java.util.List;
import java.util.Map;
import java.util.Set;

public class CellectionJava {
    public static void main(String[] args) {
        var set = Set.of(1, 7, 53);
        var list = List.of(1, 7, 53);
        var map = Map.of(1, "one", 7, "seven", 53, "fifty-three");

        System.out.println(set);
        System.out.println(list);
        System.out.println(map);
    }
}
