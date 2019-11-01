package lesson8.modifier.somepackage;

public class ClassInPackage {
    public static void main(String[] args) {
        Child child = new Child();
        child.protectedVoid(); // доступен во всех дочерних классах и в рамках одного пакета (доступен, тк вызывается в пакете, в котором был объявлен)
        child.packagePrivateVoid(); //доступен в рамках одного пакета

        Parent parent = new Parent();
        parent.protectedVoid(); // доступен во всех дочерних классах и в рамках одного пакета (доступен, тк вызывается в пакете, в котором был объявлен)
        parent.packagePrivateVoid(); //доступен в рамках одного пакета

        parent.publicVoid(); // доступен для вызова  в рамках программы
    }
}
