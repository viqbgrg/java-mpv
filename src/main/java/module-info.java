module com.github.viqbgrg.javampv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;

    opens com.github.viqbgrg.javampv to javafx.fxml;
    exports com.github.viqbgrg.javampv;
}