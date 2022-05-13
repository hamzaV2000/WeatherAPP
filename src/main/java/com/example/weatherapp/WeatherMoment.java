package com.example.weatherapp;

import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

public class WeatherMoment {
    private String loc_name,region,country,localTime;
    private double tempC,tempF,F_tempC,F_tempF;
    private String conditionText,icon;
    private double wind_mph;
    private double wind_kph;
    private String wind_dir;
    private double humidity;
    private double uv;

    public String getLoc_name() {
        return loc_name;
    }

    public String getRegion() {
        return region;
    }

    public String getCountry() {
        return country;
    }

    public String getLocalTime() {
        return localTime;
    }

    public double getTempC() {
        return tempC;
    }

    public double getTempF() {
        return tempF;
    }

    public double getF_tempC() {
        return F_tempC;
    }

    public double getF_tempF() {
        return F_tempF;
    }

    public String getConditionText() {
        return conditionText;
    }

    public String getIcon() {
        return icon;
    }

    public double getWind_mph() {
        return wind_mph;
    }

    public double getWind_kph() {
        return wind_kph;
    }

    public String getWind_dir() {
        return wind_dir;
    }

    public double getHumidity() {
        return humidity;
    }

    public double getUv() {
        return uv;
    }

    public WeatherMoment(String s) {
        Object obj = JSONValue.parse(s);
        JSONObject o1=(JSONObject) obj;
        //location
        JSONObject location=(JSONObject) o1.get("location");
        this.loc_name=(String)location.get("name");
        this.region=(String)location.get("region");
        this.country=(String)location.get("country");
        this.localTime=(String)location.get("localtime");
        //current
        JSONObject current=(JSONObject) o1.get("current");
        this.tempC=(double)current.get("temp_c");
        this.tempF=(double)current.get("temp_f");
        //condition
        JSONObject condition=(JSONObject) current.get("condition");
        this.conditionText=(String)condition.get("text");
        this.icon=(String)condition.get("icon");

        //current
        this.wind_dir=(String)current.get("wind_dir");
        this.wind_kph=(double)current.get("wind_kph");
        this.wind_mph=(double)current.get("wind_mph");
        this.humidity=(long)current.get("humidity");
        this.uv=(double)current.get("uv");
        this.F_tempC=(double)current.get("feelslike_c");
        this.F_tempF=(double)current.get("feelslike_f");


    }

    @Override
    public String toString() {
        return "WeatherMoment{" +
                "\nloc_name='" + loc_name + '\'' +
                ", \nregion='" + region + '\'' +
                ", \ncountry='" + country + '\'' +
                ", \nlocalTime='" + localTime + '\'' +
                ", \ntempC='" + tempC + '\'' +
                ", \ntempF='" + tempF + '\'' +
                ", \nF_tempC='" + F_tempC + '\'' +
                ", \nF_tempF='" + F_tempF + '\'' +
                ", \nconditionText='" + conditionText + '\'' +
                ", \nicon='" + icon + '\'' +
                ", \nwind_mph='" + wind_mph + '\'' +
                ", \nwind_kph='" + wind_kph + '\'' +
                ", \nwind_dir='" + wind_dir + '\'' +
                ", \nhumidity='" + humidity + '\'' +
                ", \nuv='" + uv + '\'' +
                '}';
    }
}
