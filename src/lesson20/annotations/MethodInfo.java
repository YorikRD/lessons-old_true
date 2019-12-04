package lesson20.annotations;

import java.lang.annotation.*;

//@Target(ElementType.TYPE) аннотация для классов
//@Target(ElementType.CONSTRUCTOR) аннотация для конструкторов
//@Target(ElementType.METHOD) аннотация для методов
//@Target(ElementType.FIELD) аннотация для полей
//@Target(ElementType.PARAMETER) аннотация для параметров метода
//@Target(ElementType.LOCAL_VARIABLE)
//@Target(ElementType.PACKAGE) аннотация для пакета
//@Target({ElementType.CONSTRUCTOR, ElementType.METHOD}) аннотация для конструкторов и для методов
//аннотацию можнои спользовать во время выполнения программы
// @Retention(RetentionPolicy.RUNTIME)
// @Retention(RetentionPolicy.CLASS)
// @Retention(RetentionPolicy.SOURCE)

@Target(ElementType.METHOD)
@Retention(RetentionPolicy.RUNTIME)
public @interface MethodInfo {
    // строки, примитивы и перечисления (enum)
    // при использовании аннотации значении author указывать обязательно
    String author();
    // при использовании аннотации значении version указывать не обязательно
    int version() default 1;
}
@Inherited // аннотация передается всем потомкам класса
@Target(ElementType.TYPE)
@Retention(RetentionPolicy.RUNTIME)
@interface ClassInfo {}
//@ClassInfo
//class Parent {}
//class Child extends Parent {}

@Target(ElementType.PARAMETER)
@Retention(RetentionPolicy.RUNTIME)
@interface ParamsInfo{}