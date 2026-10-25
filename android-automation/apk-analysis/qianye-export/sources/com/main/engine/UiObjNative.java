package com.main.engine;

import I1I.I1I.ILil.L111;
import I1I.IL1Iii;
import android.graphics.Rect;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class UiObjNative implements L111 {
    private L111 mProxy;

    public UiObjNative(L111 l111) {
        this.mProxy = l111;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean accessibilityFocus(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.accessibilityFocus(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // I1I.I1I.ILil.L111
    public Rect bounds(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.bounds(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public Rect boundsInParent(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.boundsInParent(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public int childCount(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.childCount(j);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public long[] childs(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.childs(j);
            }
        } catch (Exception unused) {
        }
        return new long[0];
    }

    @Override // I1I.I1I.ILil.L111
    public String className(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.className(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean clearAccessibilityFocus(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.clearAccessibilityFocus(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean clearFocus(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.clearFocus(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean click(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.click(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean collapse(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.collapse(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean contextClick(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.contextClick(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean copy(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.copy(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean cut(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.cut(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public int depth(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.depth(j);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public String desc(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.desc(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean dismiss(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.dismiss(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public int drawingOrder(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.drawingOrder(j);
            }
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean expand(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.expand(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean focus(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.focus(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    /* JADX INFO: renamed from: gc */
    public boolean mo0gc(long j) throws RemoteException {
        Log.i(IL1Iii.IL1Iii(new byte[]{44, 107}, IL1Iii.IL1Iii(new byte[]{0, 82, 87, 87, 4, 80}, IL1Iii.IL1Iii(new byte[]{81, 87, 80, 6, 1, 5}, "36a35d"))), IL1Iii.IL1Iii(new byte[]{91, 0, 82, 3, 5, 73}, IL1Iii.IL1Iii(new byte[]{87, 81, 91, 2, 86, 89}, IL1Iii.IL1Iii(new byte[]{81, 1, 6, 95, 82, 94}, "22e9bf"))) + j + IL1Iii.IL1Iii(new byte[]{77}, IL1Iii.IL1Iii(new byte[]{84, 2, 13, 84, 2, 0}, IL1Iii.IL1Iii(new byte[]{8, 83, 91, 1, 5, 6}, "87b732"))));
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.mo0gc(j);
            }
        } catch (Exception unused) {
        }
        return false;
    }

    @Override // I1I.I1I.ILil.L111
    public String getText(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.getText(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.L111
    /* JADX INFO: renamed from: id */
    public String mo1id(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.mo1id(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public int index(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.index(j);
            }
            return -1;
        } catch (Exception unused) {
            return -1;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean longClick(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.longClick(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public String packageName(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.packageName(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public long parent(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.parent(j);
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean paste(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.paste(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean performAction(long j, int i) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.performAction(j, i);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean performActionEx(long j, int i, Bundle bundle) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.performActionEx(j, i, bundle);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollBackward(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.scrollBackward(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollDown(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.scrollDown(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollForward(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.scrollForward(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollLeft(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.scrollLeft(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollRight(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.scrollRight(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollTo(long j, int i, int i2) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.scrollTo(j, i, i2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean scrollUp(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.scrollUp(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean select(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.select(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean setProgress(long j, float f) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.setProgress(j, f);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setProxy(L111 l111) {
        this.mProxy = l111;
    }

    @Override // I1I.I1I.ILil.L111
    public boolean setSelection(long j, int i, int i2) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.setSelection(j, i, i2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean setText(long j, String str) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.setText(j, str);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public boolean show(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.show(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.L111
    public String text(long j) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.text(j);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }
}
