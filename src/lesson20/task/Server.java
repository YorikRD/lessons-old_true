package lesson20.task;

import lesson20.task.diContainer.InitClass;
import lesson20.task.diContainer.InitProp;
import lesson20.task.diContainer.RunMethod;

@InitClass
public class Server {
    @InitProp
    private ServerSettings settings;

    @RunMethod
    public void start(){
        System.out.println("Server is running on..."
                + settings.getIp() + " " + settings.getPort());
    }
}
