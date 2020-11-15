package rlnitsua.design;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class DesignanOrderedStream {
    private final String[] stream;
    private int index;

    public DesignanOrderedStream(int n) {
        stream = new String[n];
    }

    public List<String> insert(int id, String value) {
        id--;
        List<String> list = new ArrayList<>();
        stream[id] = value;

        if (index < stream.length && stream[index] != null) {
            while (index < stream.length) {
                if (stream[index] != null) {
                    list.add(stream[index++]);
                } else {
                    break;
                }
            }
        }
        return list;
    }
}
