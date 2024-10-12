package od.e24;

import java.util.*;

/**
 * @Author : Morgan.Qin
 * @create 2024/10/12 11:27
 * @desc:斗地主
 */
public class E1 {
    // 映射扑克牌面值
    private static Map<String, Integer> faceMap = new HashMap<>();

    static {
        faceMap.put("2", 2);
        faceMap.put("3", 3);
        faceMap.put("4", 4);
        faceMap.put("5", 5);
        faceMap.put("6", 6);
        faceMap.put("7", 7);
        faceMap.put("8", 8);
        faceMap.put("9", 9);
        faceMap.put("10", 10);
        faceMap.put("J", 11);
        faceMap.put("Q", 12);
        faceMap.put("K", 13);
        faceMap.put("A", 14);
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String[] input = in.nextLine().split(" ");
        List<Integer> cards = new ArrayList<>();
        // 存储数字的牌面
        for (String s : input) {
            int face = faceMap.get(s);
            if (face != 2) {
                cards.add(face);
            }
        }
        // 排序
        Collections.sort(cards);

        // 是否是顺子
        boolean isShunzi = false;
        // 当前顺子
        List<Integer> currShunzi = new ArrayList<>();
        for (int i = 0; i < cards.size(); i++) {
            int currface = cards.get(i);
            if (currface == 2) {
                continue;
            }

            // 顺子( currShunzi.get(currShunzi.size() - 1) 为前一个牌面)
            if (currShunzi.isEmpty() || currface == currShunzi.get(currShunzi.size() - 1) + 1) {
                currShunzi.add(currface);
            }
            // 当前的牌面与前一张牌面没有连续，则不算顺子
            else if (currface != currShunzi.get(currShunzi.size() - 1) + 1) {
                if (currShunzi.size() >= 5) {
                    isShunzi = true;
                    print(currShunzi);
                }
                // 清空，重新开始找下一个顺子
                currShunzi.clear();
                currShunzi.add(currface);

            }
        }

        // 处理最后一个顺子
        if (currShunzi.size() >= 5) {
            isShunzi = true;
            print(currShunzi);
        }
        if (!isShunzi) {
            System.out.println("NO");
        }
    }

    // 输出顺子
    private static void print(List<Integer> currShunzi) {
        for (Integer card : currShunzi) {
            if (card == 11) {
                System.out.print("J");
            } else if (card == 12) {
                System.out.print("Q");
            } else if (card == 13) {
                System.out.print("K");
            } else if (card == 14) {
                System.out.print("A");
            } else {
                System.out.print(card);
            }
            System.out.print(" ");
//            if (i < currShunzi.size() - 1) {
//            }
        }
        System.out.println();
    }
}

