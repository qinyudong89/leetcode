package od.base;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedHashMap;
import java.util.Map;

/**
 * @author Morgan.Qin
 * @version 1.0
 * @description
 * @date 2024/9/18 12:31:39
 */
public class HJ19 {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new InputStreamReader(System.in));
        LinkedHashMap<String, Integer> map = new LinkedHashMap<>();
        String s = null;
        while ((s = bf.readLine()) != null && !s.equals("")) {
            String[] arr = s.split(" ");
            // 获取文件名称
            String fname = arr[0].substring(arr[0].lastIndexOf("\\") + 1);
            // 文件名长度超过16位，截取后16位
            fname = fname.substring(Math.max(fname.length() -16,0));
            String lineNumber = arr[1];
            String key = fname + " " + lineNumber;

            if (map.containsKey(key)) {
                map.put(key, map.get(key) + 1);
            } else {
                map.put(key, 1);
            }
        }
        int count = 0;
        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            // 只输出最后8个
            if (map.size() - count <= 8) {
                System.out.println(entry.getKey() + " " + entry.getValue());
            }
            count++;
        }
    }
}
