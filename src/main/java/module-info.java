module de.jmuelbert.jmbde {
    requires javafx.controls;
    requires javafx.fxml;

    opens de.jmuelbert.jmbde to javafx.fxml;
    exports de.jmuelbert.jmbde;
}
