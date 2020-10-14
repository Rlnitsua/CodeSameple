package lizbyu.hash;

import lizbyu.utils.log.LogUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class FindDuplicateFileinSystem {
    private static final String TAG = "FindDuplicateFileinSystem";

    public List<List<String>> findDuplicate(String[] paths) {
        List<List<String>> res = new ArrayList<>();
        Map<String, List<String>> contentAbsAddrFileNameMap = getContentAbsAddrFileNameMap(paths);
        for (String content : contentAbsAddrFileNameMap.keySet()) {
            if (contentAbsAddrFileNameMap.get(content).size() > 1) {
                res.add(contentAbsAddrFileNameMap.get(content));
            }
        }
        return res;
    }

    private Map<String, List<String>> getContentAbsAddrFileNameMap(String[] paths) {
        Map<String, List<String>> contentAbsAddrMap = new HashMap<>();
        Map<String, String> absAddrContentMap = getAbsAddrContentMap(paths);
        for (String absAddr : absAddrContentMap.keySet()) {
            String content = absAddrContentMap.get(absAddr);
            if (contentAbsAddrMap.containsKey(content)) {
                contentAbsAddrMap.get(content).add(absAddr);
            } else {
                List<String> absAddrList = new ArrayList<>();
                absAddrList.add(absAddr);
                contentAbsAddrMap.put(content, absAddrList);
            }
        }
        return contentAbsAddrMap;
    }

    private Map<String, String> getAbsAddrContentMap(String[] paths) {
        Map<String, String> absAddrContentMap = new HashMap<>();
        for (String path : paths) {
            String[] pathItemArr = path.split(" ");
            for (int i = 1; i < pathItemArr.length; i++) {
                int leftBracketIndex = pathItemArr[i].indexOf('(');
                String content = pathItemArr[i].substring(leftBracketIndex + 1, pathItemArr[i].length() - 1);
                String fileName = pathItemArr[i].split("\\(")[0];
                absAddrContentMap.put(pathItemArr[0] + "/" + fileName, content);
            }
        }
        return absAddrContentMap;
    }

    public static void main(String[] args) {
        String[] paths = new String[]{"root/a 1.txt(abcd) 2.txt(efgh)", "root/c 3.txt(abcd)", "root/c/d 4.txt(efgh)",
                "root 4.txt(efgh)"};
        String[] paths1 = new String[]{"root/a 1.txt(abcd) 2.txt(efsfgh) 3.txt(efsfgh)", "root/c 3.txt(abdfcd)", "root/c/d 4.txt(efggdfh)"};
        LogUtils.d(TAG, "start");
        LogUtils.d(TAG, new FindDuplicateFileinSystem().findDuplicate(paths));
        LogUtils.d(TAG, new FindDuplicateFileinSystem().findDuplicate(paths1));
        LogUtils.d(TAG, "end");
    }
}
