package com.github.viqbgrg.javampv;

import javafx.fxml.FXML;
import javafx.scene.control.Label;

import java.lang.foreign.FunctionDescriptor;
import java.lang.foreign.Linker;
import java.lang.foreign.MemorySegment;
import java.lang.foreign.SymbolLookup;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.ValueLayout.*;

public class HelloController {
    @FXML
    private Label welcomeText;

    @FXML
    protected void onHelloButtonClick() throws Throwable {
        MPV mpv = new MPV();
        long l = mpv.mpvClientApiVersion();
        System.out.println(l);
        welcomeText.setText("Welcome to JavaFX Application!");
    }
}