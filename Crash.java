public class Crash{
    int Year;
    String Month;
    int date;
    String Time;
    String DayofWeek;
    String City;
    String crashTypeIntersect;
    String crashTypeHit;
    String Light;
    String Weather;
    Crash(String sentence){
        String[] spilits = sentence.split(",");
        Year = Integer.parseInt(spilits[0]);
        Month = spilits[1];
        date = Integer.parseInt(spilits[2]);
        Time = spilits[3];
        DayofWeek = spilits[4];
        City = spilits[5];
        crashTypeIntersect = spilits[6];
        crashTypeHit = spilits[7];
        Light = spilits[8];
        Weather = spilits[9];
    }

    public int getYear() {
        return Year;
    }
    public void setYear(int year) {
        Year = year;
    }
    public String getMonth() {
        return Month;
    }
    public void setMonth(String month) {
        Month = month;
    }
    public int getDate() {
        return date;
    }
    public void setDate(int date) {
        this.date = date;
    }
    public String getTime() {
        return Time;
    }
    public void setTime(String time) {
        Time = time;
    }
    public String getDayofWeek() {
        return DayofWeek;
    }
    public void setDayofWeek(String dayofWeek) {
        DayofWeek = dayofWeek;
    }
    public String getCity() {
        return City;
    }
    public void setCity(String city) {
        City = city;
    }
    public String getCrashTypeIntersect() {
        return crashTypeIntersect;
    }
    public void setCrashTypeIntersect(String crashTypeIntersect) {
        this.crashTypeIntersect = crashTypeIntersect;
    }
    public String getCrashTypeHit() {
        return crashTypeHit;
    }
    public void setCrashTypeHit(String crashTypeHit) {
        this.crashTypeHit = crashTypeHit;
    }
    public String getLight() {
        return Light;
    }
    public void setLight(String light) {
        Light = light;
    }
    public String getWeather() {
        return Weather;
    }
    public void setWeather(String weather) {
        Weather = weather;
    }
    @Override
    public String toString() {
        return "[" + Year + ", " + Month + ", " + date + ", " + Time + ", "
                + DayofWeek + ", " + City + ", " + crashTypeIntersect + ", "
                + crashTypeHit + ", " + Light + ", " + Weather + "]";
    }
}