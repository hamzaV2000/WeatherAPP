package com.example.weatherapp;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;
import java.net.URLConnection;



public class HelloController {
    private WeatherMoment moment;
    String country="amman";
    @FXML
    private Label cityLabel,tempLabel,ftempLabel,humidityLabel,windLabel,conditionLabel,uvLabel;
    @FXML
    private ImageView weatherIcon;
    @FXML
    private Button fBtn;
    public void initialize() throws IOException {
        HttpURLConnection connection = (HttpURLConnection)
                new URL("http://api.weatherapi.com/v1/current.json?key=cb0eb89d0732424cbc3141158210805&q="
                        +country+"&aqi=no").openConnection();
        BufferedReader reader=new BufferedReader(
                new InputStreamReader(connection.getInputStream()));
        String s=reader.readLine();
        moment=new WeatherMoment(s);
        URL url = new URL("http:"+moment.getIcon());
        URLConnection conn = url.openConnection();
        InputStream in = conn.getInputStream();
        weatherIcon.setImage(new Image(in));
        cityLabel.setText(moment.getRegion());
        tempLabel.setText(moment.getTempC()+"°");
        ftempLabel.setText("Feels like "+moment.getF_tempC()+"°");
        humidityLabel.setText("Humidity "+moment.getHumidity()+"%");
        windLabel.setText("Wind "+moment.getWind_kph()+" km/h");
        conditionLabel.setText(moment.getConditionText());
        uvLabel.setText("UV "+moment.getUv()+"");

    }

    public void changeToFehrnhight(ActionEvent actionEvent) {
        if(fBtn.getText().equals("F")){
            tempLabel.setText(moment.getTempC()+"°");
            ftempLabel.setText("Feels like "+moment.getF_tempC()+"°");
            fBtn.setText("C");
        }
        else{
            tempLabel.setText(moment.getTempF()+"");
            ftempLabel.setText("Feels like "+moment.getF_tempF());
            fBtn.setText("F");
        }


    }
}