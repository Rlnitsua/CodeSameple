package rlnitsua.contest;

import java.util.*;

public class AssignTasks {
    public int[] assignTasks(int[] servers, int[] tasks) {
        int[] res = new int[tasks.length];
        // 空闲队列，已(priority + id)为优先级
        Queue<Server> idleQueue = initialIdleQueue(servers);
        // 工作队列，已(time)为优先级
        Queue<Server> workingQueue = initialWorkingQueue();
        // 缓存队列，先进先出
        Queue<Task> cacheTasks = new LinkedList<>();

        // 添加新任务
        for (int i = 0; i < tasks.length; i++) {
            while (!workingQueue.isEmpty() && workingQueue.peek().isIdle(i)) {
                idleQueue.add(workingQueue.poll());
            }
            if (idleQueue.size() >= cacheTasks.size() + 1) {
                while (!cacheTasks.isEmpty()) {
                    work(idleQueue, workingQueue, cacheTasks.poll(), res);
                }
                work(idleQueue, workingQueue, new Task(i, tasks[i]), res);
            } else {
                cacheTasks.add(new Task(i, tasks[i]));
                while (!idleQueue.isEmpty()) {
                    work(idleQueue, workingQueue, cacheTasks.poll(), res);
                }
            }
        }

        // 时间不知道怎么判断
        return res;
    }

    private Queue<Server> initialIdleQueue(int[] servers) {
        Queue<Server> idleQueue = new PriorityQueue<>((o1, o2) ->
                o1.getPriority() - o2.getPriority() == 0
                        ? o1.getId() - o2.getPriority()
                        : o1.getPriority() - o2.getPriority());

        for (int i = 0; i < servers.length; i++) {
            idleQueue.add(new Server(i, servers[i]));
        }
        return idleQueue;
    }

    private Queue<Server> initialWorkingQueue() {
        return new PriorityQueue<>(Comparator.comparingInt(Server::getTime));
    }

    private void work(Queue<Server> idleQueue, Queue<Server> workingQueue, Task task, int[] res) {
        if (!idleQueue.isEmpty()) {
            Server server = idleQueue.poll();
            server.work(task, res);
            if (workingQueue != null) {
                workingQueue.add(server);
            }
        }
    }

    private static class Server {
        private final int id;
        private final int priority;
        private int time = 0;

        public Server(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

        public int getId() {
            return id;
        }

        public int getPriority() {
            return priority;
        }

        public int getTime() {
            return time;
        }

        public void work(Task task, int[] res) {
            time += task.getDuring();
            res[task.getId()] = this.id;
        }

        public boolean isIdle(int targetTime) {
            return time <= targetTime;
        }
    }

    private static class Task {
        private final int id;
        private final int during;

        public Task(int id, int during) {
            this.id = id;
            this.during = during;
        }

        public int getId() {
            return id;
        }

        public int getDuring() {
            return during;
        }
    }
}
