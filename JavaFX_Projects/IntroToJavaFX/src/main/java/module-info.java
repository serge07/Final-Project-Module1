module com.example.introtojavafx {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.introtojavafx to javafx.fxml;
    exports com.example.introtojavafx;
}