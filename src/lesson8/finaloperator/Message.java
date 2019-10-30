package lesson8.finaloperator;

import java.time.LocalDateTime;

public final class Message {
    public String from;
    private String to;
    private String text;
    // для работы с датой и временем (начиная с 8 версии)
    private LocalDateTime dateSend;

    public Message(String from, String to, String text) {
        this.from = from;
        this.to = to;
        this.text = text;
        dateSend = LocalDateTime.now();
    }

    public String getFrom() {
        return from;
    }

    public String getTo() {
        return to;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getDateSend() {
        return dateSend;
    }


}

//class VoiceMessage extends Message {
//
//    public VoiceMessage(String from, String to, String text) {
//        super(from, to, text);
//    }
//}