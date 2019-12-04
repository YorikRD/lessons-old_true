package lesson20.annotations;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;
import java.util.Arrays;

@ClassInfo
public class AnnotationsLesson {

    private String string;

    public AnnotationsLesson(@ParamsInfo String string) {
        this.string = string;
    }

    @MethodInfo(author = "ifmo", version = 2)
    public void someVoid(){
        System.out.println("someVoid");
    }

    @Override
    @MethodInfo(author = "object")
    public String toString() {
        return "AnnotationsLesson{" +
                "string='" + string + '\'' +
                '}';
    }

    public static void main(String[] args) {

        AnnotationsLesson lesson = new AnnotationsLesson("Lesson");
        Method[] methods = lesson.getClass().getDeclaredMethods();
        for (Method method: methods) {
            Annotation[] annotations = method.getDeclaredAnnotations();
            System.out.println(Arrays.toString(annotations));

            method.isAnnotationPresent(MethodInfo.class);

            MethodInfo info = method.getDeclaredAnnotation(MethodInfo.class);
            if (info != null) {
                System.out.println(info.author());
                System.out.println(info.version());
            }
        }
    }
}


//class SomeClass {
//    аннотация для полей класса
//    private String name;
////    private Some some;
//    private int data;
//}

// написать рефлексивный static toString();
// "название some : значение"
// "название data : значение"
