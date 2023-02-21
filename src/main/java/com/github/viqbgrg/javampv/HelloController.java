package com.github.viqbgrg.javampv;

import com.sun.jna.Pointer;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import com.sun.jna.platform.win32.User32;
import com.sun.jna.platform.win32.WinDef;
import com.sun.jna.ptr.LongByReference;
public class HelloController {
    @FXML
    private Label welcomeText;

    private static final String STAGE_TITLE = "MPV video demo";
    @FXML
    protected void onHelloButtonClick() throws Throwable {
        play("");
        welcomeText.setText("Welcome to JavaFX Application!");
    }
    private void play(String url) {
        // Get interface to MPV DLL
        MPV mpv = MPV.INSTANCE;

        // Create MPV player instance
        long handle = mpv.mpv_create();

        // Get the native window id by looking up a window by title:
        WinDef.HWND hwnd = User32.INSTANCE.FindWindow(null, STAGE_TITLE);

        // Tell MPV on which window video should be displayed:
        LongByReference longByReference =
                new LongByReference(Pointer.nativeValue(hwnd.getPointer()));
        mpv.mpv_set_option(handle, "wid", 4, longByReference.getPointer());

        int error;

        // Initialize MPV after setting basic options:
        if((error = mpv.mpv_initialize(handle)) != 0) {
            throw new IllegalStateException("Initialization failed with error: " + error);
        }

        // Load and play a video:
        if((error = mpv.mpv_command(handle, new String[] {"loadfile", url})) != 0) {
            throw new IllegalStateException("Playback failed with error: " + error);
        }
    }

}