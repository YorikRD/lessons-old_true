package lesson8.modifier.somepackage;

public class Child extends Parent {

    private void privateVoid(){
        System.out.println("privateVoid");
    }

    void someVoid(){
        packagePrivateVoid(); //доступен в рамках одного пакета (доступен, тк вызывается в пакете, в котором был объявлен)
        protectedVoid(); // доступен во всех дочерних классах и в рамках одного пакета (сейчас доступен, тк вызывается в дочернем классе)

        privateVoid(); // доступен в рамках класса, в котором был объявлен
        publicVoid(); // доступен для вызова  в рамках программы (в данном случае унаследован от родителя)
    }
}
