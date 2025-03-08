import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;
import java.time.zone.ZoneRules;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.TreeMap;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

import static java.time.format.DateTimeFormatter.*;
import static java.time.format.DateTimeFormatter.ofPattern;

//This program gives the possible meeting times between two people in different timezones
//This program takes an example of an Australian and American employee

public class Main {

    private record Employee(String name, Locale locale, ZoneId zone) {

        public Employee(String name, String locale, String zone) {
            this(name, Locale.forLanguageTag(locale), ZoneId.of(zone));
        }

        public Employee(String name, Locale locale, String zone) {
            this(name, locale, ZoneId.of(zone));
        }

        String getDateInfo(ZonedDateTime zdt, DateTimeFormatter dtf) {
            return "%s [%s] : %s".formatted(name, zone, zdt.format(dtf.localizedBy(locale)));
        }
    }

    public static void main(String[] args) {

        Employee usaEmployee = new Employee("usaEmployee", Locale.US, "America/New_York");
        Employee auEmployee  = new Employee("auEmployee", "en-AU", "Australia/Sydney");

        ZoneRules auRules = auEmployee.zone.getRules();
        ZoneRules usaRules = usaEmployee.zone.getRules();
        System.out.println(usaEmployee + " " + usaRules);
        System.out.println(auEmployee + " " + auEmployee);

        ZonedDateTime usaEmployeeNow = ZonedDateTime.now(usaEmployee.zone);
        ZonedDateTime auEmployeeNow = ZonedDateTime.of(usaEmployeeNow.toLocalDateTime(), auEmployee.zone);
        long hoursBetween = Duration.between(auEmployeeNow, usaEmployeeNow).toHours();
        long minutesBetween = Duration.between(auEmployeeNow, usaEmployeeNow).toMinutesPart();
        System.out.println("AuEmployee is " + Math.abs(hoursBetween) + " hours " +
                ((hoursBetween < 0) ? "behind" : "ahead"));

        System.out.println("Is the auEmployee in daylight savings? " +
                auRules.isDaylightSavings(auEmployeeNow.toInstant()) + " " +
                auRules.getDaylightSavings(auEmployeeNow.toInstant()) + ": " +
                auEmployeeNow.format(ofPattern("zzzz z")));


        System.out.println("Is the usaEmployee in daylight savings? " +
                usaRules.isDaylightSavings(usaEmployeeNow.toInstant()) + " " +
                usaRules.getDaylightSavings(usaEmployeeNow.toInstant()) + ": " +
                usaEmployeeNow.format(ofPattern("zzzz z")));

        int days = 10;
        var map = schedule(auEmployee, usaEmployee, days);
        DateTimeFormatter dtf = ofLocalizedDateTime(FormatStyle.FULL, FormatStyle.SHORT);

        for (LocalDate ldt : map.keySet()) {
            System.out.println(ldt.format(ofLocalizedDate(FormatStyle.FULL)));
            for (ZonedDateTime zdt : map.get(ldt)) {
                System.out.println("\t" + usaEmployee.getDateInfo(zdt, dtf) + "<---->" +
                        auEmployee.getDateInfo(zdt.withZoneSameInstant(auEmployee.zone()), dtf));
            }
        }
    }

    private static Map<LocalDate, List<ZonedDateTime>>
    schedule(Employee first, Employee second, int days) {

        Predicate<ZonedDateTime> rules = zdt ->
                zdt.getDayOfWeek() != DayOfWeek.SATURDAY
                && zdt.getDayOfWeek() != DayOfWeek.SUNDAY
                && zdt.getHour() >= 7 && zdt.getHour() < 21;

        LocalDate startingDate = LocalDate.now().plusDays(2);

        return startingDate.datesUntil(startingDate.plusDays(days + 1))
                .map(dt -> dt.atStartOfDay(first.zone()))
                .flatMap(dt -> IntStream.range(0 , 24).mapToObj(dt::withHour))
                .filter(rules)
                .map(dtz -> dtz.withZoneSameInstant(second.zone()))
                .filter(rules)
                .collect(Collectors.groupingBy(ZonedDateTime::toLocalDate, TreeMap::new, Collectors.toList()));


    }


}