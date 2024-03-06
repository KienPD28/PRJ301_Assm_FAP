/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.time.temporal.WeekFields;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 *
 * @author DELL
 */
public class DateHelper {

    public static List<DateTime> DateOfYear(int year) {
        List<DateTime> list = new ArrayList<>();
        LocalDate date = LocalDate.of(year, 1, 1);
        WeekFields weekFields = WeekFields.of(Locale.forLanguageTag("vi-VN"));
        int firstWeekOfYear = date.get(weekFields.weekOfWeekBasedYear());

        do {
            LocalDate firstDayOfWeek = date.with(weekFields.dayOfWeek(), 1);
            LocalDate lastDayOfWeek = date.with(weekFields.dayOfWeek(), 7);

            StringBuilder rs = new StringBuilder();
            rs.append(firstDayOfWeek.format(DateTimeFormatter.ofPattern("dd/MM")));
            rs.append(" to ");
            rs.append(lastDayOfWeek.format(DateTimeFormatter.ofPattern("dd/MM")));

            DateTime dayDT = new DateTime(date.get(weekFields.weekOfWeekBasedYear()), rs.toString(), DateInRange(firstDayOfWeek, lastDayOfWeek));
            list.add(dayDT);

            date = date.plusWeeks(1);
        } while (date.get(weekFields.weekOfWeekBasedYear()) != firstWeekOfYear);

        return list;
    }

   
    public static List<SessionDate> DateInRange(LocalDate start, LocalDate end) {
        List<SessionDate> total = new ArrayList<>();
        while (!start.isAfter(end)) {
            total.add(new SessionDate(start, null));
            start = start.plusDays(1);
        }
        return total;
    }

   
    public static int Weeks(List<DateTime> list, LocalDate date) {
        for (DateTime dt : list) {
            if (dt.selectedWeek(date)) {
                return dt.getWeek();
            }
        }
        return -1; 
    }
    
    public static int IndexByWeeks(List<DateTime> list, int week) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i).getWeek() == week) {
                return i;
            }
        }
        return -1;
    }    
    
}
