package com.main.engine;

import I1I.I1I.ILil.InterfaceC0093LLlI1;
import I1I.I1I.ILil.L11I;
import I1I.IL1Iii;
import android.os.Bundle;
import android.os.IBinder;
import android.os.RemoteException;
import android.util.Log;

/* JADX INFO: loaded from: classes.dex */
public class UiSelNative implements InterfaceC0093LLlI1 {
    private InterfaceC0093LLlI1 mProxy;
    private int mNodeMode = -1;
    private boolean bNeedSetNodeMode = false;

    public UiSelNative(InterfaceC0093LLlI1 interfaceC0093LLlI1) {
        this.mProxy = interfaceC0093LLlI1;
    }

    private boolean checkProxyLive() {
        int i;
        try {
            InterfaceC0093LLlI1 interfaceC0093LLlI1 = this.mProxy;
            if (interfaceC0093LLlI1 == null || !interfaceC0093LLlI1.asBinder().isBinderAlive()) {
                L11I.I11L().m108iILLl();
                return false;
            }
            if (!this.bNeedSetNodeMode || (i = this.mNodeMode) == -1) {
                return true;
            }
            this.bNeedSetNodeMode = false;
            setMode(i);
            return true;
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean accessibilityFocus(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
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

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void bounds(long j, int i, int i2, int i3, int i4) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.bounds(j, i, i2, i3, i4);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void boundsContains(long j, int i, int i2, int i3, int i4) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.boundsContains(j, i, i2, i3, i4);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void boundsInside(long j, int i, int i2, int i3, int i4) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.boundsInside(j, i, i2, i3, i4);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void checkable(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.checkable(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void checked(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.checked(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void className(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.className(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void classNameContains(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.classNameContains(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void classNameEndsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.classNameEndsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void classNameMatches(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.classNameMatches(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void classNameStartsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.classNameStartsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean clearAccessibilityFocus(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.clearAccessibilityFocus(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean clearFocus(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.clearFocus(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean click(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.click(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void clickable(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.clickable(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean collapse(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.collapse(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean contextClick(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.contextClick(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean copy(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.copy(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean cut(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.cut(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void depth(long j, int i) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.depth(j, i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void desc(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.desc(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void descContains(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.descContains(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void descEndsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.descEndsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void descMatches(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.descMatches(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void descStartsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.descStartsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean dismiss(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.dismiss(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void drawingOrder(long j, int i) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.drawingOrder(j, i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void enabled(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.enabled(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean expand(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.expand(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public long[] findAll(long j, long j2) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.findAll(j, j2);
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public long findOnce(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.findOnce(j);
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public long findOnceEx(long j, int i) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.findOnceEx(j, i);
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public long findOne(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.findOne(j);
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public long findOneEx(long j, long j2) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.findOneEx(j, j2);
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean focus(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.focus(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void focusable(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.focusable(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void focused(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.focused(j, z);
            }
        } catch (Exception unused) {
        }
    }

    public InterfaceC0093LLlI1 getProxy() {
        return this.mProxy;
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void id(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.id(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void idContains(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.idContains(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void idEndsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.idEndsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void idMatches(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.idMatches(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void idStartsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.idStartsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void index(long j, int i) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.index(j, i);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean longClick(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.longClick(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void longClickable(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.longClickable(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public long obtain() throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.obtain();
            }
            return 0L;
        } catch (Exception unused) {
            return 0L;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public Bundle obtainXml() {
        try {
            if (checkProxyLive()) {
                return this.mProxy.obtainXml();
            }
            return null;
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void packageName(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.packageName(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void packageNameContains(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.packageNameContains(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void packageNameEndsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.packageNameEndsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void packageNameMatches(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.packageNameMatches(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void packageNameStartsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.packageNameStartsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void password(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.password(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean paste(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.paste(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void release(long j) throws RemoteException {
        Log.i(IL1Iii.IL1Iii(new byte[]{47, 60}, IL1Iii.IL1Iii(new byte[]{2, 84, 87, 87, 11, 12}, IL1Iii.IL1Iii(new byte[]{7, 1, 6, 6, 7, 4}, "d17250"))), IL1Iii.IL1Iii(new byte[]{68, 84, 9, 81, 88, 74, 83, 25}, IL1Iii.IL1Iii(new byte[]{7, 80, 80, 6, 13, 11}, IL1Iii.IL1Iii(new byte[]{4, 4, 2, 5, 1, 5}, "5e7757"))) + j + IL1Iii.IL1Iii(new byte[]{72}, IL1Iii.IL1Iii(new byte[]{4, 2, 80, 12, 13, 2}, IL1Iii.IL1Iii(new byte[]{4, 0, 81, 12, 86, 85}, "a1c8be"))));
        try {
            if (checkProxyLive()) {
                this.mProxy.release(j);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean scrollBackward(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.scrollBackward(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean scrollDown(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.scrollDown(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean scrollForward(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.scrollForward(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean scrollLeft(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.scrollLeft(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean scrollRight(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.scrollRight(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean scrollTo(long j, int i, int i2) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.scrollTo(j, i, i2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean scrollUp(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.scrollUp(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void scrollable(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.scrollable(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean select(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.select(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void selected(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.selected(j, z);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public int setMode(int i) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.setMode(i);
            }
            this.mNodeMode = i;
            this.bNeedSetNodeMode = true;
            return 0;
        } catch (Exception unused) {
            return 0;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean setProgress(long j, float f) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.setProgress(j, f);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    public void setProxy(InterfaceC0093LLlI1 interfaceC0093LLlI1) {
        this.mProxy = interfaceC0093LLlI1;
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean setSelection(long j, int i, int i2) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.setSelection(j, i, i2);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean setText(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.setText(j, str);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public boolean show(long j) throws RemoteException {
        try {
            if (checkProxyLive()) {
                return this.mProxy.show(j);
            }
            return false;
        } catch (Exception unused) {
            return false;
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void text(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.text(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void textContains(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.textContains(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void textEndsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.textEndsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void textMatches(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.textMatches(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void textStartsWith(long j, String str) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.textStartsWith(j, str);
            }
        } catch (Exception unused) {
        }
    }

    @Override // I1I.I1I.ILil.InterfaceC0093LLlI1
    public void visibleToUser(long j, boolean z) throws RemoteException {
        try {
            if (checkProxyLive()) {
                this.mProxy.visibleToUser(j, z);
            }
        } catch (Exception unused) {
        }
    }
}
