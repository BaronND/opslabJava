package Guava.base;

import com.google.common.base.Optional;
import com.google.common.base.Strings;
import org.junit.Test;


public class NullTest {
    @Test
    public void test() {
        /*
		 * Guava用Optional<T>表示可能为null的T类型引用。
		 * 一个Optional实例可能包含非null的引用（我们称之为引用存在），也可能什么也不包括（称之为引用缺失）。
		 * 它从不说包含的是null值，而是用存在或缺失来表示。 但Optional从不会包含null值引用。
		 */
        Optional<Integer> possible = Optional.of(5);
        // Optional.of(T)----
        // 创建指定引用的Optional实例，若引用为null则快速失败,抛出java.lang.NullPointerException
        // Optional.absent()-----创建引用缺失的Optional实例
        // Optional.fromNullable(T)-----
        // 创建指定引用的Optional实例，若引用为null则表示缺失(即Optional.absent())

        // .isPresent()---
        // 如果Optional包含非null的引用（引用存在），返回true
        possible.isPresent();
        System.out.println(possible.isPresent());// returns true

        // .get()---
        // 返回Optional所包含的引用，若引用缺失，则抛出java.lang.IllegalStateException
        possible.get();
        System.out.println(possible.get());// returns 5

        // .or(T)---
        // 返回Optional所包含的引用，若引用缺失，返回指定的值
        possible.or(1);

        // .orNull()---
        // 返回Optional所包含的引用，若引用缺失，返回null
        possible.orNull();


    }

    @Test
    public void testNull() {
        // 处理null或空字符
        String aString = "";
        String bString = null;
        String cString = "aaa";
        System.out.println(Strings.emptyToNull(aString));//null
        System.out.println(Strings.emptyToNull(bString));//null
        System.out.println(Strings.emptyToNull(cString));//aaa
        System.out.println(Strings.nullToEmpty(aString));//空("")
        System.out.println(Strings.nullToEmpty(bString));//空("")
        System.out.println(Strings.nullToEmpty(cString));//aaa
        System.out.println(Strings.isNullOrEmpty(aString));//true
        System.out.println(Strings.isNullOrEmpty(bString));//true
        System.out.println(Strings.isNullOrEmpty(cString));//false
    }

/*
    @Test
    public void testNullable(){
        testfunction(null);
    }

    private void testfunction(@Nullable String str){
        System.out.println(str) ;
    }
    */
}
