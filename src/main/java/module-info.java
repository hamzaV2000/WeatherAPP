module com.example.weatherapp {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires org.kordamp.bootstrapfx.core;
    requires json.simple;

    opens com.example.weatherapp to javafx.fxml;
    exports com.example.weatherapp;
}