import java.util.Objects;

public class Time {
    private int days, hours, minutes, seconds;
    public static final int SECONDS_PER_MINUTE = 60;
    public static final int MINUTES_PER_HOUR = 60;
    public static final int HOURS_PER_DAY = 24;
    public static final Time ZERO = new Time();
    public static final Time ONE_SECOND = new Time(0,0,0,1);
    public static final Time ONE_MINUTE = new Time(0,0,1,0);
    public static final Time ONE_HOUR = new Time(0,1,0,0);
    public static final Time ONE_DAY = new Time(1,0,0,0);
    public static final Time ONE_YEAR = new Time(365,0,0,0);

    public Time() {
        days = 0;
        hours = 0;
        minutes = 0;
        seconds = 0;
    }
    public Time(int daysArg, int hoursArg, int minutesArg, int secondsArg){
        days = daysArg;
        hours = hoursArg;
        minutes = minutesArg;
        seconds = secondsArg;
    }

    public static Time timeOf(String str) {
        String[] splitted = str.split(":");
        return new Time(Integer.parseInt(splitted[0]), Integer.parseInt(splitted[1]), Integer.parseInt(splitted[2]), Integer.parseInt(splitted[3]));
    }

    public Time copyOf(Time obj) {
        return new Time(obj.days, obj.hours, obj.minutes, obj.seconds);
    }

    // funkcja ktora konwertuje podany format czasowy na liczbe sekund
    public static int convertToTotal(int daysArg, int hoursArg, int minutesArg, int secondsArg){
        return daysArg * HOURS_PER_DAY * MINUTES_PER_HOUR * SECONDS_PER_MINUTE + hoursArg * MINUTES_PER_HOUR * SECONDS_PER_MINUTE + minutesArg * SECONDS_PER_MINUTE + secondsArg;
    }

    //funkcja ktora na podstawie liczby sekund tworzy obiek time z odpowiednio sformatowanymi danymi
    public static Time convertFromTotal(int totalTime){
        // nie zdazylem dopisac logiki, ta funkcja ma zamieniac calkowita liczbe sekund na odpowiedni format czasu
        Time result = new Time();
        return result;
    }

    // wszystkie funckje add napisalbym na podstawie logiki z convertToTotal oraz convertFromTotal ale nie zdążylem
    public void addSeconds(int val) {
    }

    public void addMinutes(int val) {
    }

    public void addHours(int val) {
    }

    public void addDays(int val) {
    }

    public void setDays(int val) {
        if(val >= 0 && val < 24) days = val;
        else System.out.println("Błędna liczba dni do ustawienia: " + val);
    }

    public void setHours(int val) {
        if(val >= 0 && val < 60) hours = val;
        else System.out.println("Błędna liczba godzin do ustawienia: " + val);
    }

    public void setMinutes(int val) {
        if(val >= 0 && val < 60) minutes = val;
        else System.out.println("Błędna liczba minut do ustawienia: " + val);
    }

    public void setSeconds(int val) {
        if(val >= 0 && val < 60) seconds = val;
        else System.out.println("Błędna liczba sekund do ustawienia: " + val);
    }

    public int getHours() {
        return hours;
    }
    public int getDays() {
        return days;
    }
    public int getSeconds() {
        return seconds;
    }
    public int getMinutes() {
        return minutes;
    }

    public static String plusTime(Time o1, Time o2) {
        Time temp = new Time (o1.days + o2.days, o1.hours + o2.hours, o1.minutes + o2.minutes, o1.seconds + o2.seconds);
        return temp.toString();
    }

    public static String times(Time o, int multiplier) {
        int totalTime = convertToTotal(o.days, o.hours, o.minutes, o.seconds);
        totalTime = totalTime * multiplier;
        Time result = convertFromTotal(totalTime);
        return result.toString();
    }

    @Override
    public String toString() {
        return days + ":" + hours + ":" + minutes + ":" + seconds;
    }

    @Override
    public boolean equals(Object o) {
        if(this == o) return true;
        if(o == null) return false;
        if(this.getClass() != o.getClass()) return false;
        Time converted = (Time) o;
        return seconds == converted.seconds && minutes == converted.minutes && hours == converted.hours && days == converted.hours;
    }

    @Override
    public int hashCode() {
        return Objects.hash(seconds, minutes, days, hours);
    }
}
