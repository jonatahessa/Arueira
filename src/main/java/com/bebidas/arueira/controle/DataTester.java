package com.bebidas.arueira.controle;

import java.time.Duration;

public class DataTester {

    static String formatPeriod(long seconds) {
        if (seconds == 0) {
            return "now";
        }

        long totalDays = seconds / 86400;
        long years = totalDays / 365;
        long remainingDaysAfterYears = totalDays % 365;
        long months = remainingDaysAfterYears / 30;
        long days = remainingDaysAfterYears % 30;

        // Cálculo preciso das horas, minutos e segundos restantes
        long remainingSeconds = seconds % 86400;
        long hours = remainingSeconds / 3600;
        remainingSeconds %= 3600;
        long minutes = remainingSeconds / 60;
        long secondsPart = remainingSeconds % 60;

        String yearsTest = years > 0 ? years + " year" + (years > 1 ? "s" : "") + ", " : "";
        String monthsTest = months > 0 ? months + " month" + (months > 1 ? "s" : "") + ", " : "";
        String daysTest = days > 0 ? days + " day" + (days > 1 ? "s" : "") + ", " : "";
        String hoursTest = hours > 0 ? hours + " hour" + (hours > 1 ? "s" : "") + ", " : "";
        String minutesTest = minutes > 0 ? minutes + " minute" + (minutes > 1 ? "s" : "") + " and " : "";
        String secondsTest = secondsPart > 0 ? secondsPart + " second" + (secondsPart > 1 ? "s" : "") : "";

        return yearsTest + monthsTest + daysTest + hoursTest + minutesTest + secondsTest;

    }
}
