package com.company.calendarmodel;

import java.util.ArrayList;
import java.util.HashMap;

public final class Calendar {

    /* Класс описывает календарь. */

    private int year;
    private ArrayList<Holiday> holidays;

    public Calendar()
    {
        year = 2020;
        Month.FEBRUARY.setNumberOfDaysInMonth(29);
        holidays = new ArrayList<Holiday>();
    }

    public Calendar(int year, ArrayList<Holiday> holidays) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            Month.FEBRUARY.setNumberOfDaysInMonth(29);
        }
        this.year = year;
        this.holidays = holidays;
    }

    public Calendar(int year) {
        if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
            Month.FEBRUARY.setNumberOfDaysInMonth(29);
        }
        this.year = year;
        holidays = new ArrayList<>();
    }

    public void addHoliday(Holiday holiday)
    {
        if (!holidays.contains(holiday))
            holidays.add(holiday);
    }

    public void addHolidays(Holiday...holidays)
    {
        for (Holiday holiday : holidays)
        {
            this.addHoliday(holiday);
        }
    }

    public void removeHoliday(Holiday holiday)
    {
        holidays.remove(holiday);
    }

    public void fillDayOff()
    {
        // Заполняет календарь выходными днями (суббота и воскресенье).
        for (Month month : Month.values())
        {
            for (int i = 1; i <= month.getNumberOfDaysInMonth(); i++)
            {
                DayOfWeek dayOfWeek = getDayOfWeek(i, month, year);
                if (dayOfWeek.getNumberOfDay() == 0 || dayOfWeek.getNumberOfDay() == 1)
                {
                    new Holiday("DayOff", i, month);
                }
            }
        }
    }

    public void sortHolidaysByNumberOfDays()
    {
        holidays.sort(Holiday::compareTo);
    }

    public void printCalendarMonth(Month month)
    {
        // Выводит в консоль календарь на заданный месяц.
        DisplayCalendar.showMonthForm(month);
        HashMap<DayOfWeek, Integer> posInStr = new HashMap<>();
        int position = 1;
        int step = 6;
        for (DayOfWeek dayOfWeek : DayOfWeek.values())
        {
            posInStr.put(dayOfWeek, position);
            position += step;
        }
        int size = 0;
        for (int i = 1; i <= month.getNumberOfDaysInMonth(); i++)
        {
            DayOfWeek dayOfWeek = getDayOfWeek(i, month, year);
            for (int j = size; j < posInStr.get(dayOfWeek); j++)
                System.out.print(" ");
            if (isHoliday(i, month))
            {
                System.out.printf(DisplayCalendar.ANSI_RED + "%2d" + DisplayCalendar.ANSI_RESET, i);
            }
            else
            {
                System.out.printf(DisplayCalendar.ANSI_BLACK + "%2d" + DisplayCalendar.ANSI_RESET, i);
            }
            if (dayOfWeek.getNumberOfDay() != 0)
            {
                size = posInStr.get(dayOfWeek) + 2;
            }
            else
            {
                size = 0;
                System.out.println();
            }
        }
        System.out.println("\n");
    }

    public void printCalendar()
    {
        // Выводит в консоль весь календарь.
        DisplayCalendar.showCalendarForm(this);
        for (Month month : Month.values())
        {
            printCalendarMonth(month);
        }
        System.out.println();
    }

    public void printHolidaysInfo()
    {
        // Выводит в консоль информацию обо всех выходных и праздниках.
        sortHolidaysByNumberOfDays();
        for (Holiday holiday : holidays)
        {
            holiday.printInfo();
        }
        System.out.println();
    }

    public int getYear() {
        return year;
    }

    public ArrayList<Holiday> getHolidays() {
        return holidays;
    }

    public class Holiday implements Comparable<Holiday> {

        /* Класс описывает выходной/праздничный день. */

        private String name;
        private int numberOfDay;
        private Month month;

        public Holiday()
        {
            name = "";
            numberOfDay = 1;
            month = Month.JULY;
            addHoliday(this);
        }

        public Holiday(String name, int numberOfDay, Month month) {
            if (numberOfDay > 0 && numberOfDay <= month.getNumberOfDaysInMonth()) {
                this.name = name;
                this.numberOfDay = numberOfDay;
                this.month = month;
                addHoliday(this);
            }
        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
        }

        public int getNumberOfDay() {
            return numberOfDay;
        }

        public void setNumberOfDay(int numberOfDay) {
            this.numberOfDay = numberOfDay;
        }

        public Month getMonth() {
            return month;
        }

        public void setMonth(Month month) {
            this.month = month;
        }

        @Override
        public String toString() {
            return numberOfDay + " " + month.getNameOfMonth() + " - " + name;
        }

        public void printInfo()
        {
            System.out.println(toString());
        }

        @Override
        public int compareTo(Holiday o) {
            if (month.getNumberOfMonth() > o.month.getNumberOfMonth())
            {
                return 1;
            }
            else if (month.getNumberOfMonth() < o.month.getNumberOfMonth())
            {
                return -1;
            }
            else if (numberOfDay > o.numberOfDay) {
                return 1;
            }
            else if (numberOfDay < o.numberOfDay) {
                return -1;
            }
            return 0;
        }
    }

    private DayOfWeek getDayOfWeek(int dayOfMonth, Month month, int year) {
        // Возвращает день недели для заданного числа, месяца, года.
        int codeOfMonth;
        if ((year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) && (month == Month.JANUARY || month == Month.FEBRUARY))
        {
            codeOfMonth = month.getCodeOfMonth() - 1;
        }
        else {
            codeOfMonth = month.getCodeOfMonth();
        }
        int codeOfYear = getCodeOfYear(year);
        int codeOfDay = (dayOfMonth + codeOfMonth + codeOfYear) % 7;
        DayOfWeek dayOfWeek = null;
        for (DayOfWeek day : DayOfWeek.values()) {
            if (codeOfDay == day.getNumberOfDay()) {
                dayOfWeek = day;
                break;
            }
        }
        return dayOfWeek;
    }

    private int getCodeOfYear(int year) {
        // Возвращает код года.
        int last2Digits = year % 100;
        int codeOfFirst2Digits = getCodeOfFirst2Digits((year - last2Digits) / 100);
        int code = (codeOfFirst2Digits + last2Digits + last2Digits / 4) % 7;
        return code;
    }

    private int getCodeOfFirst2Digits(int number) {
        // Возвращает код для первых двух цифр года.
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0, j = 6; i < 4; i++, j -= 2)
            map.put(i, j);
        return map.get(number % 4);
    }

    private boolean isHoliday(int numberOfDay, Month month)
    {
        // Проверяет является ли заданный день месяца выходным или праздничным.
        for (Holiday holiday : holidays)
        {
            if (holiday.month.getNumberOfMonth() == month.getNumberOfMonth() && holiday.numberOfDay == numberOfDay)
                return true;
        }
        return false;
    }
}