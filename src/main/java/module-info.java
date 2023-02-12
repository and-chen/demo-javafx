module com.demo {
    requires javafx.controls;
    requires javafx.fxml;


    opens com.andchen to javafx.fxml;
    exports com.andchen;
    exports com.andchen.model;
    opens com.andchen.model to javafx.fxml;
}