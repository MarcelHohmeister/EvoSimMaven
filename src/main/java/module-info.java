module com.hohmeister.evosim {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.hohmeister.evosim to javafx.fxml;
    exports com.hohmeister.evosim;
}