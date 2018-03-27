package com.prolificinteractive.materialcalendarview;

import java.util.ArrayList;

/**
 * Created by renat.shakurov on 26.03.2018.
 */

public class EventDay {

    private CalendarDay calendarDay;
    private int color;

    public EventDay(CalendarDay calendarDay, int color) {
        this.calendarDay = calendarDay;
        this.color = color;
    }

    public CalendarDay getCalendarDay() {
        return calendarDay;
    }

    public void setCalendarDay(CalendarDay calendarDay) {
        this.calendarDay = calendarDay;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public boolean isDayNull() {
        return calendarDay == null ? true : false;
    }
}
