package com.main.engine;

import I1I.I1I.ILil.llliI;
import android.os.IBinder;
import android.os.RemoteException;

/* JADX INFO: loaded from: classes.dex */
public class UiAccActionNative implements llliI {
    private llliI mProxy;

    public UiAccActionNative(llliI lllii) {
        this.mProxy = lllii;
    }

    @Override // android.os.IInterface
    public IBinder asBinder() {
        return null;
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean click(int i, int i2, int i3) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.click(i, i2, i3);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean dispatchGesture(String str) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.dispatchGesture(str);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean keyPress(int i) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.keyPress(i);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean longClick(int i, int i2) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.longClick(i, i2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setProxy(llliI lllii) {
        this.mProxy = lllii;
    }

    @Override // I1I.I1I.ILil.llliI
    public boolean swipe(int i, int i2, int i3, int i4, int i5) throws RemoteException {
        try {
            if (this.mProxy.asBinder().isBinderAlive()) {
                return this.mProxy.swipe(i, i2, i3, i4, i5);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }
}
