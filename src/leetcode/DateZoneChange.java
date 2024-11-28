package leetcode;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

public class DateZoneChange {

    public static void main(String[] args) {

        String dateTime = "2024-11-28 15:30:00"; // Input time
        String source = "America/New_York"; // Source timezone
        String target = "Asia/Kolkata"; // Target timezone

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
        LocalDateTime localDateTime = LocalDateTime.parse(dateTime,formatter);

        ZoneId sourceZone = ZoneId.of(source);
        ZoneId targetZone = ZoneId.of(target);

        ZonedDateTime sourceZonalDateTime = localDateTime.atZone(sourceZone);
        ZonedDateTime targetZonalDateTime = sourceZonalDateTime.withZoneSameInstant(targetZone);

        System.out.println(targetZonalDateTime.format(formatter));

    }
}
