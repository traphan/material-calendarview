package com.prolificinteractive.materialcalendarview;

import java.util.ArrayList;

/**
 * Created by renat.shakurov on 13.03.2018.
 */

public class EventDayModel {

    private ArrayList<CalendarDay> calendarDays;
    private int color;

    public EventDayModel(ArrayList<CalendarDay> calendarDays, int color) {
        this.calendarDays = calendarDays;
        this.color = color;
    }

    public ArrayList<CalendarDay> getCalendarDays() {
        return calendarDays;
    }

    public void setCalendarDays(ArrayList<CalendarDay> calendarDays) {
        this.calendarDays = calendarDays;
    }

    public int getColor() {
        return color;
    }

    public void setColor(int color) {
        this.color = color;
    }
}
