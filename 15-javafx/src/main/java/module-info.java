module it.tss.javafx {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.base;
    requires java.sql;
    
    opens it.tss.javafx to javafx.fxml;
    exports it.tss.javafx;
}