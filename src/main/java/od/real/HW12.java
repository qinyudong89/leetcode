package od.real;

import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/1 13:04
 */
public class HW12 {

    private PriorityQueue<App> apps = new PriorityQueue<>(Comparator.comparingInt(a -> -a.priority));

    private int timeToMinutes(String time) {
        String[] parts = time.split(":");
        return Integer.parseInt(parts[0]) * 60 + Integer.parseInt(parts[1]);
    }

    public void addApp(String name, int priority, String start, String end) {
        int startTime = timeToMinutes(start);
        int endTime = timeToMinutes(end);
        if (startTime >= endTime) return; // 注册失败

        App newApp = new App(name, priority, startTime, endTime);
        // 检查冲突并调整应用
        apps.removeIf(existingApp -> conflicts(existingApp, newApp) && existingApp.priority < newApp.priority);
        apps.offer(newApp); // 注册新应用
    }

    private boolean conflicts(App a, App b) {
        return !(a.endTime <= b.startTime || b.endTime <= a.startTime);
    }

    public String getAvailableApp(String currentTime) {
        int currTime = timeToMinutes(currentTime);
        for (App app : apps) {
            if (currTime >= app.startTime && currTime < app.endTime) {
                return app.name; // 返回可用的应用
            }
        }
        return "NA"; // 没有可用应用
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        HW12 manager = new HW12();

        int n = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < n; i++) {
            String[] input = scanner.nextLine().split(" ");
            manager.addApp(input[0], Integer.parseInt(input[1]), input[2], input[3]);
        }
        System.out.println(manager.getAvailableApp(scanner.nextLine()));
    }

    public static class App {
        String name;
        int priority;
        int startTime; // 时间以分钟为单位
        int endTime;

        App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}

