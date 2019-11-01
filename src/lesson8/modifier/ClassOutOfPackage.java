package lesson8.modifier;

import lesson8.modifier.somepackage.Child;
import lesson8.modifier.somepackage.Parent;

public class ClassOutOfPackage {
    public static void main(String[] args) {
        Child child = new Child();
//        child.protectedVoid();  //недоступен, тк объявлен в другом пакете и не вызывается в дочернем классе
//        child.packagePrivateVoid(); //недоступен, тк объявлен в другом пакете
//        child.privateVoid(); // недоступен, тк вызывается вне класса, в котором был объявлен

        Parent parent = new Parent();
//        parent.protectedVoid(); //недоступен, тк объявлен в другом пакете и не вызывается в дочернем классе
//        parent.packagePrivateVoid(); //недоступен, тк объявлен в другом пакете
        parent.publicVoid(); // доступен для вызова  в рамках программы

    }
}
