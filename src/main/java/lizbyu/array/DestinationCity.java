package lizbyu.array;

import java.util.ArrayList;
import java.util.List;

public class DestinationCity {
    public String destCity(List<List<String>> paths) {
        List<String> list = new ArrayList<>();
        for (List<String> path : paths) {
            list.add(path.get(1));
        }
        for (List<String> path : paths) {
            list.remove(path.get(0));
        }
        return list.get(0);
    }
}
