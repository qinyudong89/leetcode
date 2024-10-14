package od.real;

import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Scanner;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/1 13:04
 * 描述：手机App防沉迷系统
 */
public class HW12 {
    private static PriorityQueue<App> queue = new PriorityQueue<>(Comparator.comparingInt(o -> o.priority));

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = Integer.parseInt(in.nextLine());
        for (int i = 0; i < n; i++) {
            String[] arr = in.nextLine().split(" ");
            addApp(arr[0], arr[1], arr[2], arr[3]);
        }
        System.out.println(getAvailableApp(in.nextLine()));
    }

    // 时间转换
    private static int timeConvert(String time) {
        String[] times = time.split(":");
        return Integer.parseInt(times[0]) * 60 + Integer.parseInt(times[1]);
    }

    // 添加app
    private static void addApp(String name, String priority, String start, String end) {
        App newApp = new App(name, Integer.parseInt(priority), timeConvert(start), timeConvert(end));
        queue.removeIf(existApp -> checkConflict(existApp, newApp) && existApp.priority < newApp.priority);
        queue.offer(newApp);
    }

    // 检查冲突(只有在新应用程序的优先级更高且时间段有冲突的情况下，旧的应用程序才会被从集合中移除)
    private static boolean checkConflict(App a, App b) {
        return !(a.endTime <= b.startTime || a.startTime >= b.endTime);
    }

    // 根据时间获取可用的app
    public static String getAvailableApp(String timeStr) {
        int time = timeConvert(timeStr);
        for (App app : queue) {
            if (time >= app.startTime && time <= app.endTime) {
                return app.name;
            }
        }
        return "NA";
    }

    public static class App {
        private String name;
        private int priority;
        private int startTime;
        private int endTime;

        public App(String name, int priority, int startTime, int endTime) {
            this.name = name;
            this.priority = priority;
            this.startTime = startTime;
            this.endTime = endTime;
        }
    }
}

