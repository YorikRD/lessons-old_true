package lesson9;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;
import java.time.temporal.ChronoUnit;

public class Lalala {
    public static void main(String[] args) {
        DateTimeFormatter formatter =
                DateTimeFormatter.ofPattern("dd MMMM yyyy / HH:mm");
        LocalDateTime localDateTime = LocalDateTime.of(2019,12,31,19,0);

        ZonedDateTime sydney = localDateTime.atZone(ZoneId.of("Australia/Sydney"));

        ZonedDateTime ch = sydney
                .plusHours(15)
                .plusMinutes(35)
                .withZoneSameInstant(ZoneId.of("America/Chicago"));
        System.out.println(formatter.format(ch)+"Хьюстон");

        ZonedDateTime waitingInCh = ch.plusHours(1).plusMinutes(45);
        System.out.println(formatter.format(waitingInCh)+"вылет из Хьюстона");

        ZonedDateTime vash = waitingInCh.plusHours(2)
                .plusMinutes(49)
                .withZoneSameInstant(ZoneId.of("America/New_York"));
        System.out.println(formatter.format(vash)+"Вашингтон");

        ZonedDateTime waitingInVash = vash.plusHours(1)
                .plusMinutes(6);
        System.out.println(formatter.
                format(waitingInVash)+"вылет из Вашингтона");

        ZonedDateTime ottawa = waitingInVash.plusHours(1)
                .plusMinutes(39)
                .withZoneSameInstant(ZoneId.of("America/Toronto"));
        System.out.println(formatter.format(ottawa)+"Оттава");

         long result = ChronoUnit.MINUTES.between(sydney, ottawa);
         ZonedDateTime christmas = LocalDateTime
                 .of(2019, 12,31, 23, 59)
                 .atZone(ZoneId.of("America/Toronto"));
        System.out.println(formatter.format(christmas
                .minusMinutes(result).withZoneSameInstant(ZoneId
                        .of("Australia/Sydney"))));






    }
}
