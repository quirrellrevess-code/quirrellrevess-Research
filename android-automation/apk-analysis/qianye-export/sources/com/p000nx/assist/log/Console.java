package com.p000nx.assist.log;

import I1I.I1I.p008IL.lIlii;
import android.content.Context;
import com.p000nx.assist.log.standout.ConsoleWindow;

/* JADX INFO: loaded from: classes.dex */
public class Console {
    private static final Console mConsole = new Console();
    private ConsoleWindow mConsoleWindow = null;

    public static Console getInstance() {
        return mConsole;
    }

    public void clearLog() {
        this.mConsoleWindow.clearLog(1);
    }

    public void hide() {
        lIlii.LIlIlIL(new Runnable() { // from class: com.nx.assist.log.Console.2
            @Override // java.lang.Runnable
            public void run() {
                Console.this.mConsoleWindow.hide(1);
            }
        });
    }

    public void init(Context context) {
        this.mConsoleWindow = new ConsoleWindow(context);
    }

    public void lock(final boolean z) {
        lIlii.LIlIlIL(new Runnable() { // from class: com.nx.assist.log.Console.3
            @Override // java.lang.Runnable
            public void run() {
                if (z) {
                    Console.this.mConsoleWindow.lock(1);
                } else {
                    Console.this.mConsoleWindow.unlock(1);
                }
            }
        });
    }

    public void println(final int i, final String str) {
        lIlii.LIlIlIL(new Runnable() { // from class: com.nx.assist.log.Console.5
            @Override // java.lang.Runnable
            public void run() {
                Console.this.mConsoleWindow.println(1, i, str);
            }
        });
    }

    public void setPos(final int i, final int i2, final int i3, final int i4) {
        lIlii.LIlIlIL(new Runnable() { // from class: com.nx.assist.log.Console.6
            @Override // java.lang.Runnable
            public void run() {
                Console.this.mConsoleWindow.setPos(1, i, i2, i3, i4);
            }
        });
    }

    public void setTitle(String str) {
        this.mConsoleWindow.setTitle(1, str);
    }

    public void show(final float f) {
        lIlii.LIlIlIL(new Runnable() { // from class: com.nx.assist.log.Console.1
            @Override // java.lang.Runnable
            public void run() {
                Console.this.mConsoleWindow.show(1, f);
                Console.this.mConsoleWindow.unlock(1);
                Console.this.mConsoleWindow.play(1);
            }
        });
    }

    public void showTitle(final boolean z) {
        lIlii.LIlIlIL(new Runnable() { // from class: com.nx.assist.log.Console.4
            @Override // java.lang.Runnable
            public void run() {
                Console.this.mConsoleWindow.showTitle(1, z);
            }
        });
    }
}
