package com.javas.jdks.reflection;

import com.sun.xml.internal.ws.developer.Serialization;

import java.util.Arrays;

public class ReflectionDemo {

  private final static String LINE = "   ";

  public static void main(String[] args) throws Exception {
    test1();
    test2();
    test3();
    test4();
    test5();
  }

  /**
   * Class 的三种获取方式
   */
  private static void test1() throws ClassNotFoundException {

    printLine("1. 类名.class");
    print(Person.class);

    printLine("2. 对象.getClass()");
    Person person = new Person();
    print(person.getClass());

    printLine("3. Class.forName(\"类的完全限定名\")");
    print(Class.forName("com.javas.jdks.reflection.Person"));
  }


  /**
   * 获取构造器
   */
  private static void test2() throws NoSuchMethodException {
    Class clazz = Person.class;

    printLine("1. 获取 public 构造器");
    Arrays.stream(clazz.getConstructors()).forEach(ReflectionDemo::print);

    printLine("2. 获取所有构造器");
    Arrays.stream(clazz.getDeclaredConstructors()).forEach(ReflectionDemo::print);

    printLine("3. 获取指定签名的 public 构造器");
    print(clazz.getConstructor(String.class));

    printLine("4. 获取指定签名的构造器(public/非public)");
    print(clazz.getDeclaredConstructor(String.class, int.class));

    printLine("5. 没看懂！！！！！！！！！！！！！！！！");
    print(clazz.getEnclosingConstructor());

  }


  /**
   * 获取方法
   */
  private static void test3() throws NoSuchMethodException {
    Class clazz = Person.class;

    printLine("1. 获取当前类+父类的所有 public 方法");
    Arrays.stream(clazz.getMethods()).forEach(ReflectionDemo::print);

    printLine("2. 获取当前类所有 public+非public 方法");
    Arrays.stream(clazz.getDeclaredMethods()).forEach(ReflectionDemo::print);

    printLine("3. 获取当前类+父类指定 public 方法");
    print(clazz.getMethod("sayHello"));
    print(clazz.getMethod("sayHello", int.class));

    printLine("4. 获取当前类指定 public+非public 方法");
    print(clazz.getDeclaredMethod("sayBye"));

    printLine("5. 没看懂！！！！！！！！！！！！！！！！");
    print(clazz.getEnclosingMethod());

  }

  /**
   * 获取属性
   */
  private static void test4() throws NoSuchFieldException {
    Class clazz = Person.class;

    printLine("1. 获取当前类+父类的所有 public 属性");
    Arrays.stream(clazz.getFields()).forEach(ReflectionDemo::print);

    printLine("2. 获取当前类的所有 public+非public 属性");
    Arrays.stream(clazz.getDeclaredFields()).forEach(ReflectionDemo::print);

    printLine("3. 获取当前类+父类指定 public 属性");
    print(clazz.getField("name"));

    printLine("4. 获取当前类指定 public+非public 属性");
    print(clazz.getDeclaredField("age"));
  }

  /**
   * TODO：内部类、外部类、接口，略
   */

  /**
   * 包名、类名、父类、注解
   */
  private static void test5() {

    Class clazz = Person.class;

    printLine("1. 获取所在包");
    print(clazz.getPackage());

    printLine("2. 获取完全限定名");
    print(clazz.getName());

    printLine("3. 获取类名（不包含包名）");
    print(clazz.getSimpleName());

    printLine("4. 获取注解");
    Arrays.stream(clazz.getAnnotations()).forEach(ReflectionDemo::print);
    print(clazz.getAnnotation(Serialization.class));

    printLine("5. 是否是注解");
    print(clazz.isAnnotation());

    printLine("6. 是否是接口");
    print(clazz.isInterface());

    printLine("7. 是否为java基类型");
    print(clazz.isPrimitive());

    printLine("8. 是否为数组");
    print(clazz.isArray());

    printLine("9. 获取父类");
    print(clazz.getSuperclass());

    printLine("10. 获取类加载器");
    print(clazz.getClassLoader());

  }


  private static void printLine(String o) {
    System.out.println(o);
  }

  private static void print(Object o) {
    System.out.println(LINE + (o == null ? o : o.toString()));
  }
}
