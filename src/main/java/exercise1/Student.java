package exercise1;

import java.time.LocalDate;
import java.time.Month;
import java.util.concurrent.ThreadLocalRandom;

import static java.time.LocalDate.ofEpochDay;
import static java.time.Month.DECEMBER;
import static java.time.Month.JANUARY;

public record Student(String name, LocalDate birthDate, int grade) {

    public Student(String name, int age, int grade) {
        this(name, RandomBirthDateGenerator.getRandomBirthDateFromAge(age),  grade);
    }

    private static class RandomBirthDateGenerator {

        private RandomBirthDateGenerator() {}

        public static LocalDate getRandomBirthDateFromAge(int age) {
            return generateRandomBirthDate(age);
        }

        private static LocalDate generateRandomBirthDate(int age) {
            int birthYear = getBirthYear(age);
            long startEpochDay = startOfTheYear(birthYear).toEpochDay();
            long endEpochDay = endOfTheYear(birthYear).toEpochDay();
            long randomDay = ThreadLocalRandom
                    .current()
                    .nextLong(startEpochDay, endEpochDay);
            return ofEpochDay(randomDay);
        }

        private static int getMonthLength(Month month, int birthYear) {
            return month.length(isBirthYearALeapYear(birthYear));
        }

        private static boolean isBirthYearALeapYear(int birthYear) {
            return LocalDate.of(birthYear, 1, 1).isLeapYear();
        }

        private static LocalDate startOfTheYear(int birthYear) {
            return LocalDate.of(birthYear, JANUARY, 1);
        }

        private static LocalDate endOfTheYear(int birthYear) {
            return LocalDate.of(birthYear, DECEMBER, getMonthLength(DECEMBER, birthYear));
        }

        private static int getBirthYear(int age) {
            return LocalDate.now().minusYears(age).getYear();
        }
    }
}
