package lesson20.task;

import lesson20.task.diContainer.ConfigClass;
import lesson20.task.diContainer.InitClass;
import lesson20.task.diContainer.InitProp;
import lesson20.task.diContainer.RunMethod;

@InitClass
public class SomeClass {
    @InitProp
    private Server server;

    @RunMethod
    public void someVoid(){
        System.out.println("someVoid " + server.toString());
    }
}
