/*
 * Copyright: 2019 dingxiang-inc.com Inc. All rights reserved.
 */

import java.util.ArrayList;
import java.util.List;

/**
 * @FileName: test.java
 * @Description: test.java类说明
 * @Author: guohao
 * @Date: 2019/6/10 15:41
 */
public class test {
    public static void main(String[] args) {
        List<String> list1 = new ArrayList<String>();
        list1.add("A");
        list1.add("B");
        list1.add("C");

        List<String> list2 = new ArrayList<String>();
        list2.add("C");
        list2.add("B");
        list2.add("D");
//        // 并集
//        list1.addAll(list2);
        // 去重复并集
//        list2.removeAll(list1);
//        list1.addAll(list2);
        // 交集
        list1.retainAll(list2);
        for (String a :list1 ) {
      System.out.println(a);
        }
        // 差集
        list1.removeAll(list2);


    }

    public static void printStr(List list1){
        for (int i = 0; i < list1.size(); i++) {
            System.out.println(list1.get(i));
        }
    }
}
