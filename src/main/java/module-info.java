module com.github.viqbgrg.javampv {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.kordamp.bootstrapfx.core;
    requires com.sun.jna;
    requires com.sun.jna.platform;

    opens com.github.viqbgrg.javampv to javafx.fxml;
    exports com.github.viqbgrg.javampv;
}