/**
 * 默认方法 + 静态方法
 *
 * interface 定义中，加了 default 修饰的方法可以直接在 interface 里给出默认实现
 * 其实现类默认继承默认方法，当然也可以 override 默认方法给出自己的实现
 *
 * 默认方法 在官方库中的应用是：给java.util.Collection接口添加新方法，如stream()、parallelStream()、forEach()和removeIf()等等。
 *
 * 默认方法的官方文档：https://docs.oracle.com/javase/tutorial/java/IandI/defaultmethods.html
 *
 */
package com.javas.java8.defaultable;