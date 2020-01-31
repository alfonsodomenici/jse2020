module it.tss.javafx {
    requires javafx.controls;
    requires javafx.fxml;

    opens it.tss.javafx to javafx.fxml;
    exports it.tss.javafx;
}