package lesson8.finaloperator;

public class Writer {

    public final String ip; //= "444.444.444";

    public Writer(String ip) {
//        ip = "765897635876";
        this.ip = ip;
    }


    public final void sendMessage(final Message message) {
        //message = new Message("y", "o", "p");
        message.from = "new from";
//        ip = "555.555.555"; // нельзя изменить значение final переменных
        System.out.println("Send message... " +
                "from: " + message.getFrom() +
                " to: " + message.getTo() +
                " " + message.getDateSend());
    }
}

class VoiceWriter extends Writer {
    public VoiceWriter(String ip) {
        super(ip);
    }
//    @Override
//    public void sendMessage(Message message) {
//        System.out.println("Отправка голосового сообщения");
//    }
}

class SomeMessage extends VoiceWriter {
    public SomeMessage(String ip) {
        super(ip);
    }
//    public void sendMessage(Message message) {
//        System.out.println("Send message... " +
//                "from: " + message.getFrom() +
//                " to: " + message.getTo() +
//                " " + message.getDateSend());
//    }
}
