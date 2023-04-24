package com.yxb.think;

/**
 * 我用这个示例看看内部类的加载方式
 */
public class InnerClassLoad {

    public interface TestClass {
        int getCount();

        void addCount();
    }

    private class InnerClass implements TestClass {
        private                                                                                                                                                           int sInnerClassCount = 0;

        public int getCount() {
            return sInnerClassCount;
        }

        public void addCount() {
            sInnerClassCount++;
        }
    }

    private void testLocalInnerClass() {
        class LocalInnerClass implements TestClass {
            private static int sLocalInnerClassCount = 0;

            public int getCount() {
                return sLocalInnerClassCount;
            }

            public void addCount() {
                sLocalInnerClassCount++;
            }
        }

        LocalInnerClass obj = new LocalInnerClass();
        obj.addCount();
        System.out.println("LocalInnerClass : " + obj.getClass());
        System.out.println("LocalInnerClass 计数 : " + obj.getCount());
    }

    public void testInnerClass() {
        InnerClass obj = new InnerClass();
        obj.addCount();
        System.out.println("InnerClass : " + obj.getClass());
        System.out.println("InnerClass 计数 : " + obj.getCount());
    }

    public void testAnonymousInnerClass() {
        TestClass obj = new TestClass() {

            private static int sAnonymousInnerClassCount = 0;

            @Override
            public int getCount() {
                return sAnonymousInnerClassCount;
            }

            @Override
            public void addCount() {
                sAnonymousInnerClassCount++;
            }
        };
        obj.addCount();
        System.out.println("LocalInnerClass : " + obj.getClass());
        System.out.println("LocalInnerClass 计数 : " + obj.getCount());
    }

    public static void main(String[] args) {
        InnerClassLoad tester = new InnerClassLoad();
        System.out.println("第一次加载 InnerClass");
        tester.testInnerClass();
        System.out.println("第二次加载 InnerClass");
        tester.testInnerClass();
        System.out.println("第一次加载 LocalInnerClass");
        tester.testLocalInnerClass();
        System.out.println("第二次加载 LocalInnerClass");
        tester.testLocalInnerClass();
        System.out.println("第一次加载 AnonymousInnerClass");
        tester.testAnonymousInnerClass();
        System.out.println("第二次加载 AnonymousInnerClass");
        tester.testAnonymousInnerClass();
    }
}
