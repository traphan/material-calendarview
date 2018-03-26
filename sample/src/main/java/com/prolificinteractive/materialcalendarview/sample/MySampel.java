package com.prolificinteractive.materialcalendarview.sample;

import android.app.Activity;
import android.content.Context;
import android.graphics.Color;
import android.graphics.Typeface;
import android.graphics.drawable.Drawable;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.style.RelativeSizeSpan;
import android.text.style.StyleSpan;
import android.widget.ArrayAdapter;

import com.prolificinteractive.materialcalendarview.CalendarDay;
import com.prolificinteractive.materialcalendarview.DayViewDecorator;
import com.prolificinteractive.materialcalendarview.DayViewFacade;
import com.prolificinteractive.materialcalendarview.EventDay;
import com.prolificinteractive.materialcalendarview.EventDayModel;
import com.prolificinteractive.materialcalendarview.MaterialCalendarView;
import com.prolificinteractive.materialcalendarview.OnDateSelectedListener;
import com.prolificinteractive.materialcalendarview.sample.decorators.MySelectorDecorator;
import com.prolificinteractive.materialcalendarview.sample.decorators.OneDayDecorator;

import java.util.ArrayList;
import java.util.Date;

public class MySampel extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_sampel);
        MaterialCalendarView materialCalendarView = (MaterialCalendarView) findViewById(R.id.material_calendar_view);
        materialCalendarView.addDecorator(new CustomBackgroundDecorator(this));
        final OneDayDecoratorSelector oneDayDecorator = new OneDayDecoratorSelector(this);
        ArrayList<CalendarDay> calendarDays = new ArrayList<>();
        calendarDays.add(new CalendarDay(2018, 2, 25));
        calendarDays.add(CalendarDay.today());
        materialCalendarView.setOnDateChangedListener(new OnDateSelectedListener() {
            @Override
            public void onDateSelected(@NonNull MaterialCalendarView widget, @NonNull CalendarDay date, boolean selected) {
                oneDayDecorator.setDate(date.getDate());
                widget.addDecorator(oneDayDecorator);
                widget.invalidateDecorators();
            }
        });
        ArrayList<CalendarDay> calendarDays1 = new ArrayList<>();
        calendarDays1.add(new CalendarDay(2018, 2, 29));
        ArrayList<CalendarDay> calendarDays2 = new ArrayList<>();
        calendarDays2.add(new CalendarDay(2018, 2, 26));
        ArrayList<CalendarDay> calendarDays3 = new ArrayList<>();
        calendarDays3.add(new CalendarDay(2018, 2, 22));
        ArrayList<EventDayModel> eventDayModels = new ArrayList<>();
        eventDayModels.add(new EventDayModel(calendarDays, Color.RED));
        eventDayModels.add(new EventDayModel(calendarDays1, Color.GREEN));
        eventDayModels.add(new EventDayModel(calendarDays2, Color.YELLOW));
        eventDayModels.add(new EventDayModel(calendarDays3, Color.BLACK));
        materialCalendarView.addDecorator(new EventDaysModelDecorator(eventDayModels));
        materialCalendarView.invalidateDecorators();
        materialCalendarView.addDecorator(new EventDaysOneModelDecorator(new EventDay(new CalendarDay(new Date()), Color.MAGENTA)));
        materialCalendarView.invalidateDecorators();
    }




    public class OneDayDecoratorSelector implements DayViewDecorator {

        private CalendarDay date;
        private Drawable drawable;

        public OneDayDecoratorSelector(Context context) {
            date = CalendarDay.today();
            drawable = context.getResources().getDrawable(R.drawable.one_day_background_pressed);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return date != null && day.equals(date);
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.setBackgroundDrawable(drawable);
        }

        /**
         * We're changing the internals, so make sure to call {@linkplain MaterialCalendarView#invalidateDecorators()}
         */
        public void setDate(Date date) {
            this.date = CalendarDay.from(date);
        }
    }

    public class CustomBackgroundDecorator implements DayViewDecorator {

        private final Drawable drawable;

        public CustomBackgroundDecorator(Activity context) {
            drawable = context.getResources().getDrawable(R.drawable.one_day_background);
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return true;
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.setBackgroundDrawable(drawable);
        }
    }

    public class EventDaysModelDecorator implements DayViewDecorator {

        ArrayList<EventDayModel> eventDayModels;

        public EventDaysModelDecorator(ArrayList<EventDayModel> eventDayModels) {
            this.eventDayModels = eventDayModels;
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return true;
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.setEventDayModels(eventDayModels);
        }
    }

    public class EventDaysOneModelDecorator implements DayViewDecorator {

        EventDay eventDay;

        public EventDaysOneModelDecorator(EventDay eventDay) {
            this.eventDay = eventDay;
        }

        @Override
        public boolean shouldDecorate(CalendarDay day) {
            return true;
        }

        @Override
        public void decorate(DayViewFacade view) {
            view.setEventDayModel(eventDay);
        }
    }


}
