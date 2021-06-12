package com.javas.java8.lambda;

import java.util.Arrays;
import java.util.List;

/**
 * Hello world!
 *
 */
public class AppForLambda
{
    public static void main( String[] args )
    {


        System.out.println("-- demo1：lambda 表达式实现 interface 中的接口，直接执行 lambda 表达式--");
        System.out.println(OperationEnum.Addition.operate(10,5));
        System.out.println(OperationEnum.Subtraction.operate(10,5));
        System.out.println(OperationEnum.Multiplication.operate(10,5));

        System.out.println("-- demo2：lambda 表达式实现 interface 中的接口，作为参数给 proxy，proxy 执行 lambda 表达式--");
        OperationProxy proxy = new OperationProxy();
        System.out.println(proxy.operate(10,5,OperationEnum.Addition));
        System.out.println(proxy.operate(10,5,OperationEnum.Subtraction));
        System.out.println(proxy.operate(10,5,OperationEnum.Multiplication));


        System.out.println("-- demo3：foreach 里使用 lambda（多种写法）--");
        Arrays.asList( "a", "b", "d" ).forEach((String e) -> System.out.println( e ) );
        Arrays.asList( "e", "f", "g" ).forEach(e -> System.out.println( e ) );
        Arrays.asList( "h", "i", "j" ).forEach(e -> {
            System.out.println( e );
        } );
        Arrays.asList( "k", "l", "m" ).forEach(System.out::println);


        System.out.println("-- demo4：sort 里使用 lambda（多种写法）--");
        List<String> list = Arrays.asList("a","b","c","d","e","f");

        // 降序
        list.sort( ( e1, e2 ) -> e2.compareTo( e1 ) );
        System.out.println(list);

        // 升序
        list.sort(String::compareTo);
        System.out.println(list);

        // 降序
        list.sort( ( e1, e2 ) -> {
            int result = e2.compareTo( e1 );
            return result;
        } );
        System.out.println(list);

    }
}
