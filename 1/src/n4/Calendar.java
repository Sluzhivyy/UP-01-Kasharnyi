package n4;

import java.util.ArrayList;
import java.util.List;

public class Calendar {

    private static class Holiday {
        private String name;
        private int month;
        private int day;

        public Holiday(String name, int month, int day) {
            this.name = name;
            this.month = month;
            this.day = day;
        }

        public String getName() {
            return name;
        }

        public int getMonth() {
            return month;
        }

        public int getDay() {
            return day;
        }
    }

    private List<Holiday> holidays;

    public Calendar() {
        holidays = new ArrayList<>();

        holidays.add(new Holiday("Новый год", 1, 1));
        holidays.add(new Holiday("Рождество", 1, 7));
        holidays.add(new Holiday("День Победы", 5, 9));
    }

    public boolean isHoliday(int month, int day) {
        for (Holiday holiday : holidays) {
            if (holiday.getMonth() == month && holiday.getDay() == day) {
                return true;
            }
        }
        return false;
    }

    public void addHoliday(String name, int month, int day) {
        holidays.add(new Holiday(name, month, day));
    }

    public static void main(String[] args) {
        Calendar calendar = new Calendar();


        System.out.println("1 января - выходной: " + calendar.isHoliday(1, 1));


        calendar.addHoliday("День знаний", 9, 1);
        System.out.println("1 сентября - выходной: " + calendar.isHoliday(9, 1));
    }
}
