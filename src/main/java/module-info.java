module com.hohmeister.evosim {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.management;


    opens com.hohmeister.evosim to javafx.fxml;
    exports com.hohmeister.evosim;
}