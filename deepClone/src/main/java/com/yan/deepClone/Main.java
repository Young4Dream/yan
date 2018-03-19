package com.yan.deepClone;

import com.yan.models.A;
import com.yan.models.B;
import com.yan.models.C;
import com.yan.util.BeanUtil;

import java.util.*;

import static com.yan.util.BeanUtil.deepClone;
import static com.yan.util.BeanUtil.deepCloneList;

public class Main {
    private C c = new C("c");
    private B b = new B("b", Collections.singletonList(new C("c")));
    private A a = new A("a", b);

    public static void main(String[] args) throws Exception {
        Main main = new Main();
        main.a.setDate(new Date());
        List<A> as = new ArrayList<>();
        for (int i = 0; i < 10000; i++) {
            as.add(main.a);
        }

        long start = System.currentTimeMillis();
        List<A> as1 = deepCloneList(as);
        A[] asss = new A[]{main.a};
        A[] assss = BeanUtil.deepClone(asss);
        assss[0].getB().setValue("xixi");
        List<A> ress = new ArrayList<>();
        A a = as1.get(0);

        a.getB().setValue("haha");

//        ress.get(0).setB(new B("bb", Collections.singletonList(new C("cc"))));
//        System.out.println(Objects.equals(as.get(0).getB().getValue(), as1.get(0).getB().getValue()));
//        long end = System.currentTimeMillis();
//        System.out.println(end - start);
//        System.out.println("b:" + a.getB().equals(main.b));
//        a.setValue("aa");
//        a.setAnInt(1);
//        a.setInteger(2);
//        a.setB(new B("bb", new C("cc")));
//        a.setDate(new Date());
//        /**
//         * 测试基础类型
//         */
//        System.out.println(Objects.equals(main.a.getValue(), a.getValue()));
//        System.out.println(Objects.equals(main.a.getAnInt(), a.getAnInt()));
//        System.out.println(Objects.equals(main.a.getInteger(), a.getInteger()));
//        /**
//         * 测试已有类型
//         */
//        System.out.println(Objects.equals(main.a.getDate(), a.getDate()));
//        /**
//         * 测试自定义类型
//         */
//        System.out.println(Objects.equals(main.a.getB().getValue(), a.getB().getValue()));
//        System.out.println(Objects.equals(main.a.getB().getC().getValue(), a.getB().getC().getValue()));
    }
}
