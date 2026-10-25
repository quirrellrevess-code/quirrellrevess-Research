package com.main.app;

import I1I.I1I.ILil.IIi;
import I1I.I1I.p008IL.C0610il;
import android.inputmethodservice.InputMethodService;
import android.inputmethodservice.KeyboardView;
import android.util.Log;
import android.view.KeyEvent;
import android.view.View;
import android.view.inputmethod.InputConnection;
import java.util.concurrent.Callable;

/* JADX INFO: loaded from: classes.dex */
public class ImeInput extends InputMethodService {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static ImeInput f5282I1I = null;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public KeyboardView f5283ILil;

    public class I1I implements Callable<Boolean> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ int f5285IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f5286ILil;

        public I1I(int i, int i2) {
            this.f5285IL1Iii = i;
            this.f5286ILil = i2;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                return Boolean.valueOf(ImeInput.this.getCurrentInputConnection().sendKeyEvent(new KeyEvent(this.f5285IL1Iii, this.f5286ILil)));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    public class IL1Iii implements Callable<Boolean> {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ String f5287IL1Iii;

        public IL1Iii(String str) {
            this.f5287IL1Iii = str;
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                InputConnection currentInputConnection = ImeInput.this.getCurrentInputConnection();
                String str = this.f5287IL1Iii;
                return Boolean.valueOf(currentInputConnection.commitText(str, str.length()));
            } catch (Exception e) {
                e.printStackTrace();
                return Boolean.FALSE;
            }
        }
    }

    public class ILil implements Callable<Boolean> {
        public ILil() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                return Boolean.valueOf(ImeInput.this.getCurrentInputConnection() != null);
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.ImeInput$I丨L, reason: invalid class name */
    public class IL implements Callable<Boolean> {
        public IL() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                return Boolean.valueOf(ImeInput.this.getCurrentInputConnection().deleteSurroundingText(1, 0));
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    /* JADX INFO: renamed from: com.main.app.ImeInput$l丨Li1LL, reason: invalid class name */
    public class lLi1LL implements Callable<Boolean> {
        public lLi1LL() {
        }

        @Override // java.util.concurrent.Callable
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public Boolean call() throws Exception {
            try {
                return Boolean.valueOf(ImeInput.this.getCurrentInputConnection().finishComposingText());
            } catch (Exception unused) {
                return Boolean.FALSE;
            }
        }
    }

    public static ImeInput I1I() {
        return f5282I1I;
    }

    public boolean IL1Iii() {
        return ((Boolean) new C0610il().ILil(new IL())).booleanValue();
    }

    public boolean ILil() {
        return ((Boolean) new C0610il().ILil(new lLi1LL())).booleanValue();
    }

    public boolean Ilil() {
        return ((Boolean) new C0610il().ILil(new ILil())).booleanValue();
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean m3446IL(String str) {
        return ((Boolean) new C0610il().ILil(new IL1Iii(str))).booleanValue();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean m3447lLi1LL(int i, int i2) {
        return ((Boolean) new C0610il().ILil(new I1I(i, i2))).booleanValue();
    }

    @Override // android.inputmethodservice.InputMethodService, android.app.Service
    public void onCreate() {
        super.onCreate();
        f5282I1I = this;
        p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(104, I1I.IL1Iii.IL1Iii(new byte[]{83}, I1I.IL1Iii.IL1Iii(new byte[]{85, 85, 83, 7, 1, 4}, I1I.IL1Iii.IL1Iii(new byte[]{3, 82, 80, 7, 8, 86}, "4d458c"))), I1I.IL1Iii.IL1Iii(new byte[]{5}, I1I.IL1Iii.IL1Iii(new byte[]{13, 2, 9, 5, 2, 6}, I1I.IL1Iii.IL1Iii(new byte[]{91, 2, 87, 83, 7, 1}, "c2ff44")))));
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{125, 105}, I1I.IL1Iii.IL1Iii(new byte[]{5, 6, 6, 89, 1, 0}, I1I.IL1Iii.IL1Iii(new byte[]{84, 4, 7, 11, 12, 88}, "b3b39a"))), I1I.IL1Iii.IL1Iii(new byte[]{95, 72, 81, 94, 25, 85, 66, 24, 93, 93, 92, 24, 17, 25}, I1I.IL1Iii.IL1Iii(new byte[]{84, 90, 81, 2, 91, 12}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 81, 1, 1, 12}, "7d43c9"))));
    }

    @Override // android.inputmethodservice.InputMethodService
    public View onCreateInputView() {
        return this.f5283ILil;
    }

    @Override // android.inputmethodservice.InputMethodService, android.inputmethodservice.AbstractInputMethodService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
        Log.i(I1I.IL1Iii.IL1Iii(new byte[]{123, 58}, I1I.IL1Iii.IL1Iii(new byte[]{2, 3, 4, 4, 9, 1}, I1I.IL1Iii.IL1Iii(new byte[]{2, 5, 4, 80, 0, 83}, "5d159b"))), I1I.IL1Iii.IL1Iii(new byte[]{127, 91, 18, 16, 68, 100, 83, 77, 22, 69, 116, 85, 69, 65, 13, 23, 73, 17, 23, 20}, I1I.IL1Iii.IL1Iii(new byte[]{85, 7, 80, 93, 6, 2}, I1I.IL1Iii.IL1Iii(new byte[]{83, 3, 6, 8, 80, 83}, "0140fa"))));
        p051lLi1LL.ILil.IL1Iii.I1I.I1I().ILL(new IIi(104, I1I.IL1Iii.IL1Iii(new byte[]{1}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 86, 93, 3, 1}, I1I.IL1Iii.IL1Iii(new byte[]{86, 6, 87, 9, 0, 3}, "b05140"))), I1I.IL1Iii.IL1Iii(new byte[]{0}, I1I.IL1Iii.IL1Iii(new byte[]{8, 86, 7, 86, 6, 87}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 85, 80, 82, 4}, "943da2")))));
        f5282I1I = null;
    }

    @Override // android.inputmethodservice.InputMethodService
    public boolean onEvaluateFullscreenMode() {
        return false;
    }

    @Override // android.inputmethodservice.InputMethodService
    public void onFinishInputView(boolean z) {
        super.onFinishInputView(z);
    }
}
