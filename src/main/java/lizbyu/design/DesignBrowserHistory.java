package lizbyu.design;

import java.util.ArrayList;
import java.util.List;

public class DesignBrowserHistory {
    private final List<String> history;
    private int currentIndex = -1;

    public DesignBrowserHistory(String homepage) {
        this.history = new ArrayList<>();
        visit(homepage);
    }

    public void visit(String url) {
        if (currentIndex != history.size() - 1) {
            int len = history.size();
            for (int i = 0; i < len - 1 - currentIndex; i++) {
                history.remove(history.size() - 1);
            }
        }
        history.add(url);
        currentIndex++;
    }

    public String back(int steps) {
        if (steps > currentIndex) {
            currentIndex = 0;
        } else {
            currentIndex -= steps;
        }
        return history.get(currentIndex);
    }

    public String forward(int steps) {
        if (steps > history.size() - 1 - currentIndex) {
            currentIndex = history.size() - 1;
        } else {
            currentIndex += steps;
        }
        return history.get(currentIndex);
    }
}
