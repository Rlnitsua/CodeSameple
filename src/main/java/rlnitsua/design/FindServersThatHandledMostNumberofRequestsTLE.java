package rlnitsua.design;

import java.util.ArrayList;
import java.util.List;

public class FindServersThatHandledMostNumberofRequestsTLE {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        Server[] serverArr = createServerArr(k);
        handleRequests(serverArr, arrival, load);
        return calculateBusiesServers(serverArr);
    }

    private Server[] createServerArr(int k) {
        Server[] serverArr = new Server[k];
        for (int i = 0; i < serverArr.length; i++) {
            serverArr[i] = new Server();
        }
        return serverArr;
    }

    private void handleRequests(Server[] serverArr, int[] arrival, int[] load) {
        for (int i = 0; i < arrival.length; i++) {
            int target = i % serverArr.length;
            int tryTime = 0;
            while (tryTime <= serverArr.length) {
                if (serverArr[target].isAvailable(arrival[i])) {
                    serverArr[target].startWork(arrival[i] + load[i]);
                    break;
                } else {
                    tryTime++;
                    target = (i + tryTime) % serverArr.length;
                }
            }
        }
    }

    private List<Integer> calculateBusiesServers(Server[] serverArr) {
        List<Integer> busiesServers = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < serverArr.length; i++) {
            if (max < serverArr[i].getHandledNum()) {
                max = serverArr[i].getHandledNum();
                busiesServers.clear();
                busiesServers.add(i);
            } else if (max == serverArr[i].getHandledNum()) {
                busiesServers.add(i);
            }
        }
        return busiesServers;
    }

    private static class Server {
        private int lastEndTime;
        private int handledNum;

        public boolean isAvailable(int startTime) {
            return lastEndTime <= startTime;
        }

        public void startWork(int endTime) {
            this.lastEndTime = endTime;
            handledNum++;
        }

        public int getHandledNum() {
            return handledNum;
        }
    }
}
