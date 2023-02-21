package com.github.viqbgrg.javampv;

import java.lang.foreign.*;
import java.lang.invoke.MethodHandle;

import static java.lang.foreign.SegmentAllocator.implicitAllocator;
import static java.lang.foreign.ValueLayout.ADDRESS;
import static java.lang.foreign.ValueLayout.JAVA_LONG;

public class MPV {
    public MPV() {
        System.load("E:\\workspaces\\java-mpv\\src\\main\\resources\\libmpv-2.dll");
    }

    public long mpvClientApiVersion() throws Throwable {
        MemorySession memorySession = MemorySession.openConfined();
        SymbolLookup loaderLookup = SymbolLookup.loaderLookup();
        Linker LINKER = Linker.nativeLinker();
        MethodHandle fuse_version$MH = loaderLookup.lookup("mpv_client_api_version").
                map(addr -> LINKER.downcallHandle(addr, FunctionDescriptor.of(JAVA_LONG))).
                get();
        long len = (long)fuse_version$MH.invoke();
        return len;
    }
}
