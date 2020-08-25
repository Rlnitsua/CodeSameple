package lizbyu.design;

import java.util.HashMap;
import java.util.Map;

public class DesignFileSystem {
    private final Map<String, Integer> pathInfo;

    public DesignFileSystem() {
        pathInfo = new HashMap<>();
        pathInfo.put("", 0);
    }

    public boolean createPath(String path, int value) {
        if (pathInfo.containsKey(path) || !pathInfo.containsKey(getParentPath(path))) {
            return false;
        } else {
            pathInfo.put(path, value);
            return true;
        }
    }

    private String getParentPath(String path) {
        return path.substring(0, path.lastIndexOf("/"));
    }

    public int get(String path) {
        return pathInfo.getOrDefault(path, -1);
    }
}
