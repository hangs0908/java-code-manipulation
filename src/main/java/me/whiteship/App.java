package me.whiteship;

import java.lang.reflect.*;
import java.util.Arrays;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws ClassNotFoundException, NoSuchFieldException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {

//        ClassLoader classLoader = App.class.getClassLoader();
//        System.out.println(classLoader);
//        System.out.println(classLoader.getParent());
//        System.out.println(classLoader.getParent().getParent());

        // 해당 클래스 타입의 클래스 객체를 만드는 여려가지 방법
//        Book book = new Book();
//        Class<? extends Book> aClass = book.getClass();
//
//        Class<?> aClass1 = Class.forName("me.whiteship.Book");
        Class<Book> bookClass = Book.class;
        Book book = new Book();
        Arrays.stream(bookClass.getFields()).forEach(System.out::println); // getFields는  public한것만 return함
        Arrays.stream(bookClass.getDeclaredFields()).forEach(System.out::println);// 모든 필드 가져오는것
        System.out.println("--------------------");
        Field bookField = bookClass.getDeclaredField("B");
        System.out.println(bookField);
        System.out.println("--------------------");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            try {
                f.setAccessible(true); // 접근 불가능한 필드에 대해 접근할 수 있게 해준다.
                System.out.printf("%s & %s\n",f,f.get(book));
            } catch (IllegalAccessException e) {
                throw new RuntimeException(e);
            }
        });
        System.out.println("--------------------");
        Arrays.stream(bookClass.getDeclaredMethods()).forEach(System.out::println);
        System.out.println("--------------------");
        Arrays.stream(bookClass.getDeclaredConstructors()).forEach(System.out::println);

        Class<? super MyBook> superclass = MyBook.class.getSuperclass();
        System.out.println(superclass);
        System.out.println("--------------------");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            int modifiers = f.getModifiers();
            System.out.println(f);
            System.out.println(Modifier.isPrivate(modifiers));
            System.out.println(Modifier.isStatic(modifiers));
        });

        System.out.println("--------------------");
        Arrays.stream(bookClass.getAnnotations()).forEach(System.out::println);
        Arrays.stream(MyBook.class.getAnnotations()).forEach(System.out::println);
        Arrays.stream(MyBook.class.getDeclaredAnnotations()).forEach(System.out::println);
        System.out.println("--------------------");
        Arrays.stream(bookClass.getDeclaredFields()).forEach(f -> {
            Arrays.stream(f.getAnnotations()).forEach(a -> {
                if(a instanceof MyAnnotation) {
                    MyAnnotation myAnnotation = (MyAnnotation) a;
                    System.out.println(myAnnotation.name());
                    System.out.println(myAnnotation.number());
                }
            });
        });

        /*
            리플랙션 2 : 클래스 정보 수정
         */
        Class<?> bookClass1 = Class.forName("me.whiteship.Book");
        Constructor<?> constructor = bookClass1.getConstructor(String.class);
        Book book1 = (Book) constructor.newInstance("myBook");
        System.out.println(book1);

        Field f = Book.class.getDeclaredField("A");
        System.out.println(f.get(null)); // 이 필드는 static한 필드니까 null
        f.set(null,"AAAAA");
        System.out.println(f.get(null));

        Field b = Book.class.getDeclaredField("B");
        b.setAccessible(true);
        System.out.println(b.get(book1));
        b.set(book1, "BBBB");
        System.out.println(b.get(book1));

        Method c = Book.class.getDeclaredMethod("c");
        c.setAccessible(true);
        c.invoke(book1);

        Method sum = Book.class.getDeclaredMethod("sum", int.class, int.class);
        int invoke = (int) sum.invoke(book1, 1, 2);
        System.out.println(invoke);

        /*
            연습
         */

    }
}
