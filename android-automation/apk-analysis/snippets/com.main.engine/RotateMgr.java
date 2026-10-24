package com.main.engine;

import I1I.I1I.ILil.i1;
import I1I.I1I.ILil.l1Lll;
import android.os.Parcel;
import android.os.RemoteException;
import android.util.Log;
import android.view.IRotationWatcher;

/* JADX INFO: loaded from: classes.dex */
public class RotateMgr extends IRotationWatcher.Stub {

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static final String f1994IL = I1I.IL1Iii.IL1Iii(new byte[]{0, 91, 87, 71, 10, 15, 5, 27, 69, 92, 0, 17, 79, 124, 97, 90, 17, 7, 21, 92, 92, 91, 50, 7, 21, 86, 91, 80, 23}, I1I.IL1Iii.IL1Iii(new byte[]{2, 5, 5, 4, 1, 4}, I1I.IL1Iii.IL1Iii(new byte[]{5, 84, 0, 82, 86, 80}, "fd6c22")));

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public static RotateMgr f4458Ilil = new RotateMgr();

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public int f4460ILil = 0;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public IL1Iii f4459I1I = null;

    public interface IL1Iii {
        void IL1Iii(int i);
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static RotateMgr m2708IL() {
        return f4458Ilil;
    }

    public int IL1Iii() {
        return this.f4460ILil;
    }

    public void Ilil(IL1Iii iL1Iii) {
        try {
            this.f4459I1I = iL1Iii;
            l1Lll l1lllM116IiL = i1.Ilil().m116IiL();
            l1lllM116IiL.IL1Iii(this);
            int iI1I = l1lllM116IiL.I1I();
            this.f4460ILil = iI1I;
            this.f4459I1I.IL1Iii(iI1I);
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{124, 111}, I1I.IL1Iii.IL1Iii(new byte[]{5, 83, 83, 81, 81, 85}, I1I.IL1Iii.IL1Iii(new byte[]{3, 81, 6, 86, 83, 85}, "45ca1b"))), I1I.IL1Iii.IL1Iii(new byte[]{7, 74, 20, 12}, I1I.IL1Iii.IL1Iii(new byte[]{87, 9, 7, 6, 84, 87}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 85, 8, 87, 91}, "5f48e8"))) + e.toString());
        }
    }

    @Override // android.view.IRotationWatcher
    public void onRotationChanged(int i) throws RemoteException {
    }

    @Override // android.view.IRotationWatcher.Stub, android.os.Binder
    public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        String str = f1994IL;
        if (i != 1) {
            if (i != 1598968902) {
                return super.onTransact(i, parcel, parcel2, i2);
            }
            parcel2.writeString(str);
            return true;
        }
        parcel.enforceInterface(str);
        int i3 = parcel.readInt();
        this.f4460ILil = i3;
        this.f4459I1I.IL1Iii(i3);
        parcel2.writeNoException();
        return true;
    }
}
