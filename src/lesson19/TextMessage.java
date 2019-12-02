package lesson19;

import java.io.Serializable;
import java.time.LocalDateTime;

class Message {
    public String title;
    protected LocalDateTime sent;

    public Message(String title) {
        this.title = title;
        sent = LocalDateTime.now();
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public LocalDateTime getSent() {
        return sent;
    }

    public void setSent(LocalDateTime sent) {
        this.sent = sent;
    }

    public void printTitle(){
        System.out.println("Тема сообщения: " + this.title);
    }

    public void printTitle(String data){
        System.out.println("Тема сообщения: " + data);
    }


}

public class TextMessage extends Message implements Serializable {

    private String text;

    public TextMessage(String title, String text) {
        super(title);
        this.text = text;
    }

    private String getMessageInfo(){
        return "Тема сообщения: " + title + ".\n" +
                "Текст сообщения: " + text + ".\n" +
                "Отправлено: " + sent + ".\n";
    }

    public static void someVoid(){
        System.out.println("some static Void");
    }
}

