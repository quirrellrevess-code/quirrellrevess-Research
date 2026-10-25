package com.tencent.smtt.services;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import android.os.SystemClock;
import android.text.TextUtils;
import com.tencent.smtt.export.external.interfaces.IX5ChildProcessService;
import dalvik.system.DexClassLoader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.io.StringWriter;

/* JADX INFO: loaded from: classes.dex */
public class ChildProcessService extends Service {

    /* JADX INFO: renamed from: a */
    private IX5ChildProcessService f663a;

    public static class Privileged extends ChildProcessService {
    }

    public static final class Privileged0 extends Privileged {
    }

    public static final class Privileged1 extends Privileged {
    }

    public static final class Privileged2 extends Privileged {
    }

    public static final class Privileged3 extends Privileged {
    }

    public static final class Privileged4 extends Privileged {
    }

    public static final class Privileged5 extends Privileged {
    }

    public static final class Privileged6 extends Privileged {
    }

    public static final class Privileged7 extends Privileged {
    }

    public static final class Privileged8 extends Privileged {
    }

    public static final class Privileged9 extends Privileged {
    }

    public static class Sandboxed extends ChildProcessService {
    }

    public static final class Sandboxed0 extends Sandboxed {
    }

    public static final class Sandboxed1 extends Sandboxed {
    }

    public static final class Sandboxed2 extends Sandboxed {
    }

    public static final class Sandboxed3 extends Sandboxed {
    }

    public static final class Sandboxed4 extends Sandboxed {
    }

    public static final class Sandboxed5 extends Sandboxed {
    }

    public static final class Sandboxed6 extends Sandboxed {
    }

    public static final class Sandboxed7 extends Sandboxed {
    }

    public static final class Sandboxed8 extends Sandboxed {
    }

    public static final class Sandboxed9 extends Sandboxed {
    }

    @SuppressLint({"NewApi"})
    /* JADX INFO: renamed from: a */
    private void m610a(Intent intent, Throwable th) throws Throwable {
        IBinder binder;
        StringWriter stringWriter = new StringWriter();
        th.printStackTrace(new PrintWriter(stringWriter));
        String string = stringWriter.toString();
        Bundle extras = intent.getExtras();
        if (extras == null || (binder = extras.getBinder(IX5ChildProcessService.ERROR_CALLBACK_KEY)) == null) {
            return;
        }
        Parcel parcel = null;
        try {
            try {
                Parcel parcelObtain = Parcel.obtain();
                try {
                    parcelObtain.writeString(string);
                    binder.transact(1, parcelObtain, null, 0);
                    if (parcelObtain != null) {
                        parcelObtain.recycle();
                    }
                } catch (RemoteException e) {
                    e = e;
                    parcel = parcelObtain;
                    e.printStackTrace();
                    if (parcel != null) {
                        parcel.recycle();
                    }
                } catch (Throwable th2) {
                    th = th2;
                    parcel = parcelObtain;
                    if (parcel != null) {
                        parcel.recycle();
                    }
                    throw th;
                }
            } catch (Throwable th3) {
                th = th3;
            }
        } catch (RemoteException e2) {
            e = e2;
        }
        throw new RuntimeException(th);
    }

    @Override // android.app.Service
    public IBinder onBind(Intent intent) throws Throwable {
        if (this.f663a == null) {
            try {
                String stringExtra = intent.getStringExtra(IX5ChildProcessService.INSTALLATION_DIRECTORY_KEY);
                String stringExtra2 = intent.getStringExtra(IX5ChildProcessService.ENTRY_DEX_FILE_KEY);
                String stringExtra3 = intent.getStringExtra(IX5ChildProcessService.ENTRY_CLASS_NAME_KEY);
                if (!TextUtils.isEmpty(stringExtra) && !TextUtils.isEmpty(stringExtra2) && !TextUtils.isEmpty(stringExtra3)) {
                    File file = new File(stringExtra, stringExtra2);
                    String absolutePath = file.getAbsolutePath();
                    if (!file.exists()) {
                        m610a(intent, new FileNotFoundException(absolutePath));
                        return null;
                    }
                    SystemClock.elapsedRealtime();
                    IX5ChildProcessService iX5ChildProcessService = (IX5ChildProcessService) new DexClassLoader(absolutePath, stringExtra, stringExtra, ChildProcessService.class.getClassLoader()).loadClass(stringExtra3).newInstance();
                    this.f663a = iX5ChildProcessService;
                    iX5ChildProcessService.onCreate(this, intent);
                }
                m610a(intent, new IllegalArgumentException("installationDirectory: " + stringExtra + ", dexFile: " + stringExtra2 + ", className: " + stringExtra3));
                return null;
            } catch (Throwable th) {
                m610a(intent, th);
                return null;
            }
        }
        return this.f663a.onBind(this, intent);
    }

    @Override // android.app.Service
    public void onCreate() {
        IX5ChildProcessService iX5ChildProcessService = this.f663a;
        if (iX5ChildProcessService != null) {
            iX5ChildProcessService.onCreate(this, null);
        }
    }

    @Override // android.app.Service
    public void onDestroy() {
        IX5ChildProcessService iX5ChildProcessService = this.f663a;
        if (iX5ChildProcessService != null) {
            iX5ChildProcessService.onDestroy(this);
            this.f663a = null;
        }
    }
}
