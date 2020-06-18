package com.company.calendarmodel;

public enum  DayOfWeek {

    SUNDAY ("Sunday", 1),
    MONDAY ("Monday", 2),
    TUESDAY ("Tuesday", 3),
    WEDNESDAY ("Wednesday", 4),
    THURSDAY ("Thursday", 5),
    FRIDAY ("Friday", 6),
    SATURDAY ("Saturday", 0);

    private String nameOfDay;
    private int numberOfDay;

    DayOfWeek(String nameOfDay, int numberOfDay) {
        this.nameOfDay = nameOfDay;
        this.numberOfDay = numberOfDay;
    }

    public String getNameOfDay() {
        return nameOfDay;
    }

    public int getNumberOfDay() {
        return numberOfDay;
    }

    @Override
    public String toString() {
        return nameOfDay.toString();
    }

}