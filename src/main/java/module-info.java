module iuyt.test {
    requires javafx.controls;
    requires javafx.fxml;

    opens iuyt.test to javafx.fxml;
    exports iuyt.test;
}
