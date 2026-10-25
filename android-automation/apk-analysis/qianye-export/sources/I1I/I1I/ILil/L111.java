package I1I.I1I.ILil;

import android.graphics.Rect;
import android.os.Binder;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* JADX INFO: renamed from: I1I.I1I.ILil.L11丨丨丨1, reason: invalid class name */
/* JADX INFO: compiled from: IUiObjectProxy.java */
/* JADX INFO: loaded from: classes.dex */
public interface L111 extends IInterface {

    /* JADX INFO: renamed from: I1I.I1I.ILil.L11丨丨丨1$IL1Iii */
    /* JADX INFO: compiled from: IUiObjectProxy.java */
    public static abstract class IL1Iii extends Binder implements L111 {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public static final String f3135ILil = I1I.IL1Iii.IL1Iii(new byte[]{80, 86, 15, 29, 94, 84, 90, 87, 76, 86, 93, 82, 90, 87, 7, 29, 122, 96, 90, 118, 0, 89, 86, 86, 71, 105, 16, 92, 75, 76}, I1I.IL1Iii.IL1Iii(new byte[]{86, 10, 91, 80, 10, 84}, I1I.IL1Iii.IL1Iii(new byte[]{93, 2, 88, 7, 93, 87}, "81add6")));

        /* JADX INFO: renamed from: I1I.I1I.ILil.L11丨丨丨1$IL1Iii$IL1Iii, reason: collision with other inner class name */
        /* JADX INFO: compiled from: IUiObjectProxy.java */
        public static class C0523IL1Iii implements L111 {

            /* JADX INFO: renamed from: I1I, reason: collision with root package name */
            public static L111 f3136I1I;

            /* JADX INFO: renamed from: ILil, reason: collision with root package name */
            public IBinder f3137ILil;

            public C0523IL1Iii(IBinder iBinder) {
                this.f3137ILil = iBinder;
            }

            @Override // I1I.I1I.ILil.L111
            public boolean accessibilityFocus(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{86, 14, 92, 77, 12, 81, 92, 15, 31, 6, 15, 87, 92, 15, 84, 77, 40, 101, 92, 46, 83, 9, 4, 83, 65, 49, 67, 12, 25, 73}, I1I.IL1Iii.IL1Iii(new byte[]{13, 3, 7, 87, 2, 85}, I1I.IL1Iii.IL1Iii(new byte[]{92, 1, 1, 3, 85, 3}, "dc776f"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(20, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zAccessibilityFocus = IL1Iii.m899IL().accessibilityFocus(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zAccessibilityFocus;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // android.os.IInterface
            public IBinder asBinder() {
                return this.f3137ILil;
            }

            @Override // I1I.I1I.ILil.L111
            public Rect bounds(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{2, 87, 15, 79, 84, 84, 8, 86, 76, 4, 87, 82, 8, 86, 7, 79, 112, 96, 8, 119, 0, 11, 92, 86, 21, 104, 16, 14, 65, 76}, I1I.IL1Iii.IL1Iii(new byte[]{84, 15, 80, 87, 13, 2}, I1I.IL1Iii.IL1Iii(new byte[]{83, 85, 84, 15, 81, 86}, "fbf9ea"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(3, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            Rect rectBounds = IL1Iii.m899IL().bounds(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return rectBounds;
                        }
                        parcelObtain2.readException();
                        Rect rect = parcelObtain2.readInt() != 0 ? (Rect) Rect.CREATOR.createFromParcel(parcelObtain2) : null;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return rect;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public Rect boundsInParent(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{91, 94, 85, 28, 84, 85, 81, 95, 22, 87, 87, 83, 81, 95, 93, 28, 112, 97, 81, 126, 90, 88, 92, 87, 76, 97, 74, 93, 65, 77}, I1I.IL1Iii.IL1Iii(new byte[]{92, 9, 1, 11, 88, 81}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 12, 13, 89, 87}, "a95482"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(4, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            Rect rectBoundsInParent = IL1Iii.m899IL().boundsInParent(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return rectBoundsInParent;
                        }
                        parcelObtain2.readException();
                        Rect rect = parcelObtain2.readInt() != 0 ? (Rect) Rect.CREATOR.createFromParcel(parcelObtain2) : null;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return rect;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public int childCount(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{81, 93, 94, 26, 89, 84, 91, 92, 29, 81, 90, 82, 91, 92, 86, 26, 125, 96, 91, 125, 81, 94, 81, 86, 70, 98, 65, 91, 76, 76}, I1I.IL1Iii.IL1Iii(new byte[]{4, 11, 4, 2, 7, 13}, I1I.IL1Iii.IL1Iii(new byte[]{83, 92, 0, 14, 1, 89}, "ee782a"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(2, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            int iChildCount = IL1Iii.m899IL().childCount(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return iChildCount;
                        }
                        parcelObtain2.readException();
                        int i = parcelObtain2.readInt();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public long[] childs(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{87, 91, 14, 25, 94, 80, 93, 90, 77, 82, 93, 86, 93, 90, 6, 25, 122, 100, 93, 123, 1, 93, 86, 82, 64, 100, 17, 88, 75, 72}, I1I.IL1Iii.IL1Iii(new byte[]{87, 0, 5, 6, 82, 84}, I1I.IL1Iii.IL1Iii(new byte[]{80, 6, 94, 9, 86, 87}, "328872"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(12, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            long[] jArrChilds = IL1Iii.m899IL().childs(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return jArrChilds;
                        }
                        parcelObtain2.readException();
                        long[] jArrCreateLongArray = parcelObtain2.createLongArray();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return jArrCreateLongArray;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public String className(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{81, 91, 15, 31, 95, 83, 91, 90, 76, 84, 92, 85, 91, 90, 7, 31, 123, 103, 91, 123, 0, 91, 87, 81, 70, 100, 16, 94, 74, 75}, I1I.IL1Iii.IL1Iii(new byte[]{0, 13, 80, 2, 80, 1}, I1I.IL1Iii.IL1Iii(new byte[]{86, 10, 1, 81, 1, 81}, "d33bcb"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(10, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            String strClassName = IL1Iii.m899IL().className(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return strClassName;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean clearAccessibilityFocus(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{1, 9, 95, 26, 93, 88, 11, 8, 28, 81, 94, 94, 11, 8, 87, 26, 121, 108, 11, 41, 80, 94, 85, 90, 22, 54, 64, 91, 72, 64}, I1I.IL1Iii.IL1Iii(new byte[]{83, 5, 84, 4, 86, 13}, I1I.IL1Iii.IL1Iii(new byte[]{80, 7, 4, 8, 7, 0}, "adb8a4"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(21, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zClearAccessibilityFocus = IL1Iii.m899IL().clearAccessibilityFocus(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zClearAccessibilityFocus;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean clearFocus(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{91, 11, 84, 79, 88, 87, 81, 10, 23, 4, 91, 81, 81, 10, 92, 79, 124, 99, 81, 43, 91, 11, 80, 85, 76, 52, 75, 14, 77, 79}, I1I.IL1Iii.IL1Iii(new byte[]{92, 87, 8, 89, 80, 7}, I1I.IL1Iii.IL1Iii(new byte[]{7, 6, 6, 13, 93, 83}, "c5758b"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(23, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zClearFocus = IL1Iii.m899IL().clearFocus(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zClearFocus;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean click(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{1, 94, 92, 79, 90, 7, 11, 95, 31, 4, 89, 1, 11, 95, 84, 79, 126, 51, 11, 126, 83, 11, 82, 5, 22, 97, 67, 14, 79, 31}, I1I.IL1Iii.IL1Iii(new byte[]{7, 87, 82, 85, 82, 85}, I1I.IL1Iii.IL1Iii(new byte[]{82, 94, 1, 12, 82, 81}, "78b87b"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(18, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zClick = IL1Iii.m899IL().click(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zClick;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean collapse(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 11, 89, 27, 8, 87, 89, 10, 26, 80, 11, 81, 89, 10, 81, 27, 44, 99, 89, 43, 86, 95, 0, 85, 68, 52, 70, 90, 29, 79}, I1I.IL1Iii.IL1Iii(new byte[]{1, 2, 81, 81, 7, 5}, I1I.IL1Iii.IL1Iii(new byte[]{3, 5, 84, 80, 91, 80}, "2c149c"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(28, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zCollapse = IL1Iii.m899IL().collapse(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zCollapse;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean contextClick(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{2, 90, 11, 24, 15, 84, 8, 91, 72, 83, 12, 82, 8, 91, 3, 24, 43, 96, 8, 122, 4, 92, 7, 86, 21, 101, 20, 89, 26, 76}, I1I.IL1Iii.IL1Iii(new byte[]{82, 2, 4, 3, 83, 0}, I1I.IL1Iii.IL1Iii(new byte[]{11, 81, 86, 4, 82, 5}, "8f41c0"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(38, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zContextClick = IL1Iii.m899IL().contextClick(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zContextClick;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean copy(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{86, 14, 89, 22, 93, 81, 92, 15, 26, 93, 94, 87, 92, 15, 81, 22, 121, 101, 92, 46, 86, 82, 85, 83, 65, 49, 70, 87, 72, 73}, I1I.IL1Iii.IL1Iii(new byte[]{12, 82, 2, 90, 81, 1}, I1I.IL1Iii.IL1Iii(new byte[]{14, 6, 3, 7, 89, 83}, "755e8b"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(24, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zCopy = IL1Iii.m899IL().copy(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zCopy;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean cut(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{7, 13, 84, 76, 92, 89, 13, 12, 23, 7, 95, 95, 13, 12, 92, 76, 120, 109, 13, 45, 91, 8, 84, 91, 16, 50, 75, 13, 73, 65}, I1I.IL1Iii.IL1Iii(new byte[]{0, 83, 88, 1, 6, 15}, I1I.IL1Iii.IL1Iii(new byte[]{84, 1, 82, 6, 1, 82}, "003e6e"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(27, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zCut = IL1Iii.m899IL().cut(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zCut;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public int depth(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{85, 10, 90, 23, 12, 82, 95, 11, 25, 92, 15, 84, 95, 11, 82, 23, 40, 102, 95, 42, 85, 83, 4, 80, 66, 53, 69, 86, 25, 74}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 1, 88, 0, 0}, I1I.IL1Iii.IL1Iii(new byte[]{1, 87, 87, 3, 5, 6}, "edabd5"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(14, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            int iDepth = IL1Iii.m899IL().depth(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return iDepth;
                        }
                        parcelObtain2.readException();
                        int i = parcelObtain2.readInt();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public String desc(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{2, 93, 92, 76, 89, 85, 8, 92, 31, 7, 90, 83, 8, 92, 84, 76, 125, 97, 8, 125, 83, 8, 81, 87, 21, 98, 67, 13, 76, 77}, I1I.IL1Iii.IL1Iii(new byte[]{80, 3, 85, 3, 7, 13}, I1I.IL1Iii.IL1Iii(new byte[]{0, 84, 85, 7, 82, 11}, "1e1fa2"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(9, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            String strDesc = IL1Iii.m899IL().desc(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return strDesc;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean dismiss(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{86, 11, 95, 79, 91, 7, 92, 10, 28, 4, 88, 1, 92, 10, 87, 79, 127, 51, 92, 43, 80, 11, 83, 5, 65, 52, 64, 14, 78, 31}, I1I.IL1Iii.IL1Iii(new byte[]{2, 92, 6, 2, 4, 83}, I1I.IL1Iii.IL1Iii(new byte[]{0, 15, 82, 0, 10, 7}, "77fc82"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(30, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zDismiss = IL1Iii.m899IL().dismiss(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zDismiss;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public int drawingOrder(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{2, 92, 88, 77, 93, 7, 8, 93, 27, 6, 94, 1, 8, 93, 80, 77, 121, 51, 8, 124, 87, 9, 85, 5, 21, 99, 71, 12, 72, 31}, I1I.IL1Iii.IL1Iii(new byte[]{3, 80, 87, 83, 84, 5}, I1I.IL1Iii.IL1Iii(new byte[]{81, 86, 84, 3, 7, 1}, "3563cb"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(5, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            int iDrawingOrder = IL1Iii.m899IL().drawingOrder(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return iDrawingOrder;
                        }
                        parcelObtain2.readException();
                        int i = parcelObtain2.readInt();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean expand(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{81, 93, 91, 76, 9, 4, 91, 92, 24, 7, 10, 2, 91, 92, 83, 76, 45, 48, 91, 125, 84, 8, 1, 6, 70, 98, 68, 13, 28, 28}, I1I.IL1Iii.IL1Iii(new byte[]{83, 6, 7, 82, 7, 85}, I1I.IL1Iii.IL1Iii(new byte[]{5, 1, 80, 83, 5, 3}, "d5acf3"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(29, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zExpand = IL1Iii.m899IL().expand(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zExpand;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean focus(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{85, 11, 91, 75, 84, 5, 95, 10, 24, 0, 87, 3, 95, 10, 83, 75, 112, 49, 95, 43, 84, 15, 92, 7, 66, 52, 68, 10, 65, 29}, I1I.IL1Iii.IL1Iii(new byte[]{82, 86, 1, 83, 11, 84}, I1I.IL1Iii.IL1Iii(new byte[]{81, 7, 4, 3, 7, 0}, "553550"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(22, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zFocus = IL1Iii.m899IL().focus(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zFocus;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            /* JADX INFO: renamed from: gc */
            public boolean mo0gc(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 90, 91, 22, 85, 84, 89, 91, 24, 93, 86, 82, 89, 91, 83, 22, 113, 96, 89, 122, 84, 82, 93, 86, 68, 101, 68, 87, 64, 76}, I1I.IL1Iii.IL1Iii(new byte[]{5, 4, 2, 8, 12, 1}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 2, 85, 4, 81}, "de6e0e"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(1, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zMo0gc = IL1Iii.m899IL().mo0gc(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zMo0gc;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public String getText(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{1, 9, 93, 22, 12, 2, 11, 8, 30, 93, 15, 4, 11, 8, 85, 22, 40, 54, 11, 41, 82, 82, 4, 0, 22, 54, 66, 87, 25, 26}, I1I.IL1Iii.IL1Iii(new byte[]{3, 94, 2, 91, 7, 81}, I1I.IL1Iii.IL1Iii(new byte[]{4, 93, 5, 90, 82, 0}, "ee7942"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(8, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            String text = IL1Iii.m899IL().getText(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return text;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            /* JADX INFO: renamed from: id */
            public String mo1id(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{91, 87, 14, 29, 12, 80, 81, 86, 77, 86, 15, 86, 81, 86, 6, 29, 40, 100, 81, 119, 1, 89, 4, 82, 76, 104, 17, 92, 25, 72}, I1I.IL1Iii.IL1Iii(new byte[]{90, 0, 86, 6, 88, 2}, I1I.IL1Iii.IL1Iii(new byte[]{1, 13, 5, 87, 90, 11}, "c50bc8"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(6, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            String strMo1id = IL1Iii.m899IL().mo1id(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return strMo1id;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public int index(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{82, 9, 11, 23, 12, 3, 88, 8, 72, 92, 15, 5, 88, 8, 3, 23, 40, 55, 88, 41, 4, 83, 4, 1, 69, 54, 20, 86, 25, 27}, I1I.IL1Iii.IL1Iii(new byte[]{80, 80, 83, 95, 7, 86}, I1I.IL1Iii.IL1Iii(new byte[]{5, 80, 86, 85, 4, 7}, "dfc3b3"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(15, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            int iIndex = IL1Iii.m899IL().index(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return iIndex;
                        }
                        parcelObtain2.readException();
                        int i = parcelObtain2.readInt();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return i;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean longClick(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{1, 11, 15, 79, 93, 5, 11, 10, 76, 4, 94, 3, 11, 10, 7, 79, 121, 49, 11, 43, 0, 11, 85, 7, 22, 52, 16, 14, 72, 29}, I1I.IL1Iii.IL1Iii(new byte[]{90, 1, 7, 81, 84, 81}, I1I.IL1Iii.IL1Iii(new byte[]{11, 82, 82, 1, 7, 86}, "3771cc"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(19, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zLongClick = IL1Iii.m899IL().longClick(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zLongClick;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public String packageName(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 94, 91, 24, 88, 2, 89, 95, 24, 83, 91, 4, 89, 95, 83, 24, 124, 54, 89, 126, 84, 92, 80, 0, 68, 97, 68, 89, 77, 26}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 1, 3, 7, 6}, I1I.IL1Iii.IL1Iii(new byte[]{87, 82, 6, 3, 6, 83}, "cd1646"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(11, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            String strPackageName = IL1Iii.m899IL().packageName(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return strPackageName;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public long parent(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{85, 94, 85, 27, 14, 5, 95, 95, 22, 80, 13, 3, 95, 95, 93, 27, 42, 49, 95, 126, 90, 95, 6, 7, 66, 97, 74, 90, 27, 29}, I1I.IL1Iii.IL1Iii(new byte[]{6, 6, 91, 0, 84, 93}, I1I.IL1Iii.IL1Iii(new byte[]{84, 82, 87, 80, 6, 88}, "de4e1a"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(13, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            long jParent = IL1Iii.m899IL().parent(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return jParent;
                        }
                        parcelObtain2.readException();
                        long j2 = parcelObtain2.readLong();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return j2;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean paste(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{91, 86, 14, 30, 8, 84, 81, 87, 77, 85, 11, 82, 81, 87, 6, 30, 44, 96, 81, 118, 1, 90, 0, 86, 76, 105, 17, 95, 29, 76}, I1I.IL1Iii.IL1Iii(new byte[]{0, 93, 85, 4, 1, 2}, I1I.IL1Iii.IL1Iii(new byte[]{94, 87, 84, 82, 1, 82}, "f3bfee"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(25, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zPaste = IL1Iii.m899IL().paste(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zPaste;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean performAction(long j, int i) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{1, 92, 88, 25, 8, 86, 11, 93, 27, 82, 11, 80, 11, 93, 80, 25, 44, 98, 11, 124, 87, 93, 0, 84, 22, 99, 71, 88, 29, 78}, I1I.IL1Iii.IL1Iii(new byte[]{0, 2, 0, 5, 4, 4}, I1I.IL1Iii.IL1Iii(new byte[]{87, 85, 4, 10, 2, 0}, "5d18c3"))));
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    try {
                        if (!this.f3137ILil.transact(17, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zPerformAction = IL1Iii.m899IL().performAction(j, i);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zPerformAction;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean performActionEx(long j, int i, Bundle bundle) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{84, 11, 90, 29, 9, 83, 94, 10, 25, 86, 10, 85, 94, 10, 82, 29, 45, 103, 94, 43, 85, 89, 1, 81, 67, 52, 69, 92, 28, 75}, I1I.IL1Iii.IL1Iii(new byte[]{82, 7, 3, 80, 81, 81}, I1I.IL1Iii.IL1Iii(new byte[]{6, 80, 7, 0, 1, 83}, "c33c40"))));
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    if (bundle != null) {
                        parcelObtain.writeInt(1);
                        bundle.writeToParcel(parcelObtain, 0);
                    } else {
                        parcelObtain.writeInt(0);
                    }
                    try {
                        if (!this.f3137ILil.transact(16, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zPerformActionEx = IL1Iii.m899IL().performActionEx(j, i, bundle);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zPerformActionEx;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean scrollBackward(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 14, 90, 76, 8, 86, 89, 15, 25, 7, 11, 80, 89, 15, 82, 76, 44, 98, 89, 46, 85, 8, 0, 84, 68, 49, 69, 13, 29, 78}, I1I.IL1Iii.IL1Iii(new byte[]{4, 5, 14, 0, 83, 85}, I1I.IL1Iii.IL1Iii(new byte[]{6, 5, 12, 81, 0, 80}, "2a5362"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(33, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zScrollBackward = IL1Iii.m899IL().scrollBackward(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zScrollBackward;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean scrollDown(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{6, 91, 88, 25, 11, 89, 12, 90, 27, 82, 8, 95, 12, 90, 80, 25, 47, 109, 12, 123, 87, 93, 3, 91, 17, 100, 71, 88, 30, 65}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 0, 85, 94, 0}, I1I.IL1Iii.IL1Iii(new byte[]{93, 80, 86, 3, 1, 14}, "95ca96"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(35, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zScrollDown = IL1Iii.m899IL().scrollDown(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zScrollDown;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean scrollForward(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{2, 14, 91, 26, 15, 88, 8, 15, 24, 81, 12, 94, 8, 15, 83, 26, 43, 108, 8, 46, 84, 94, 7, 90, 21, 49, 68, 91, 26, 64}, I1I.IL1Iii.IL1Iii(new byte[]{81, 83, 14, 80, 87, 8}, I1I.IL1Iii.IL1Iii(new byte[]{86, 84, 12, 87, 87, 8}, "ff43b9"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(32, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zScrollForward = IL1Iii.m899IL().scrollForward(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zScrollForward;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean scrollLeft(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{81, 95, 88, 75, 85, 7, 91, 94, 27, 0, 86, 1, 91, 94, 80, 75, 113, 51, 91, 127, 87, 15, 93, 5, 70, 96, 71, 10, 64, 31}, I1I.IL1Iii.IL1Iii(new byte[]{3, 84, 84, 83, 1, 81}, I1I.IL1Iii.IL1Iii(new byte[]{0, 0, 84, 14, 1, 2}, "1d5885"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(36, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zScrollLeft = IL1Iii.m899IL().scrollLeft(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zScrollLeft;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean scrollRight(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{82, 13, 88, 24, 95, 83, 88, 12, 27, 83, 92, 85, 88, 12, 80, 24, 123, 103, 88, 45, 87, 92, 87, 81, 69, 50, 71, 89, 74, 75}, I1I.IL1Iii.IL1Iii(new byte[]{87, 87, 13, 5, 80, 1}, I1I.IL1Iii.IL1Iii(new byte[]{83, 83, 1, 86, 87, 81}, "5f9e5b"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(37, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zScrollRight = IL1Iii.m899IL().scrollRight(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zScrollRight;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean scrollTo(long j, int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 90, 88, 28, 93, 83, 89, 91, 27, 87, 94, 85, 89, 91, 80, 28, 121, 103, 89, 122, 87, 88, 85, 81, 68, 101, 71, 93, 72, 75}, I1I.IL1Iii.IL1Iii(new byte[]{3, 5, 1, 2, 8, 83}, I1I.IL1Iii.IL1Iii(new byte[]{87, 1, 3, 9, 14, 0}, "d1796a"))));
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    try {
                        if (!this.f3137ILil.transact(42, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zScrollTo = IL1Iii.m899IL().scrollTo(j, i, i2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zScrollTo;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean scrollUp(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{5, 14, 9, 79, 91, 88, 15, 15, 74, 4, 88, 94, 15, 15, 1, 79, 127, 108, 15, 46, 6, 11, 83, 90, 18, 49, 22, 14, 78, 64}, I1I.IL1Iii.IL1Iii(new byte[]{83, 87, 7, 89, 6, 91}, I1I.IL1Iii.IL1Iii(new byte[]{86, 3, 6, 92, 82, 91}, "c5edb9"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(34, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zScrollUp = IL1Iii.m899IL().scrollUp(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zScrollUp;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean select(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 10, 92, 29, 95, 88, 89, 11, 31, 86, 92, 94, 89, 11, 84, 29, 123, 108, 89, 42, 83, 89, 87, 90, 68, 53, 67, 92, 74, 64}, I1I.IL1Iii.IL1Iii(new byte[]{4, 84, 0, 7, 80, 9}, I1I.IL1Iii.IL1Iii(new byte[]{7, 6, 5, 3, 4, 84}, "3747fd"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(26, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zSelect = IL1Iii.m899IL().select(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zSelect;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean setProgress(long j, float f) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{81, 90, 11, 28, 12, 87, 91, 91, 72, 87, 15, 81, 91, 91, 3, 28, 40, 99, 91, 122, 4, 88, 4, 85, 70, 101, 20, 93, 25, 79}, I1I.IL1Iii.IL1Iii(new byte[]{0, 87, 80, 83, 7, 87}, I1I.IL1Iii.IL1Iii(new byte[]{5, 91, 5, 80, 94, 7}, "79318f"))));
                    parcelObtain.writeLong(j);
                    parcelObtain.writeFloat(f);
                    try {
                        if (!this.f3137ILil.transact(41, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean progress = IL1Iii.m899IL().setProgress(j, f);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return progress;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean setSelection(long j, int i, int i2) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{80, 12, 92, 79, 85, 4, 90, 13, 31, 4, 86, 2, 90, 13, 84, 79, 113, 48, 90, 44, 83, 11, 93, 6, 71, 51, 67, 14, 64, 28}, I1I.IL1Iii.IL1Iii(new byte[]{4, 90, 1, 86, 12, 82}, I1I.IL1Iii.IL1Iii(new byte[]{6, 0, 8, 15, 5, 0}, "198817"))));
                    parcelObtain.writeLong(j);
                    parcelObtain.writeInt(i);
                    parcelObtain.writeInt(i2);
                    try {
                        if (!this.f3137ILil.transact(39, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean selection = IL1Iii.m899IL().setSelection(j, i, i2);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return selection;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean setText(long j, String str) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 88, 91, 75, 94, 84, 89, 89, 24, 0, 93, 82, 89, 89, 83, 75, 122, 96, 89, 120, 84, 15, 86, 86, 68, 103, 68, 10, 75, 76}, I1I.IL1Iii.IL1Iii(new byte[]{81, 84, 6, 87, 85, 2}, I1I.IL1Iii.IL1Iii(new byte[]{2, 1, 3, 2, 85, 85}, "cb303b"))));
                    parcelObtain.writeLong(j);
                    parcelObtain.writeString(str);
                    try {
                        if (!this.f3137ILil.transact(40, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean text = IL1Iii.m899IL().setText(j, str);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return text;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public boolean show(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{85, 90, 95, 23, 8, 80, 95, 91, 28, 92, 11, 86, 95, 91, 87, 23, 44, 100, 95, 122, 80, 83, 0, 82, 66, 101, 64, 86, 29, 72}, I1I.IL1Iii.IL1Iii(new byte[]{84, 81, 0, 92, 86, 85}, I1I.IL1Iii.IL1Iii(new byte[]{1, 81, 1, 81, 81, 0}, "c534bd"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(31, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            boolean zShow = IL1Iii.m899IL().show(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return zShow;
                        }
                        parcelObtain2.readException();
                        boolean z = parcelObtain2.readInt() != 0;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return z;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }

            @Override // I1I.I1I.ILil.L111
            public String text(long j) throws Throwable {
                Parcel parcelObtain = Parcel.obtain();
                Parcel parcelObtain2 = Parcel.obtain();
                try {
                    parcelObtain.writeInterfaceToken(I1I.IL1Iii.IL1Iii(new byte[]{83, 88, 84, 26, 92, 87, 89, 89, 23, 81, 95, 81, 89, 89, 92, 26, 120, 99, 89, 120, 91, 94, 84, 85, 68, 103, 75, 91, 73, 79}, I1I.IL1Iii.IL1Iii(new byte[]{4, 7, 88, 3, 3, 7}, I1I.IL1Iii.IL1Iii(new byte[]{12, 83, 0, 4, 6, 3}, "8ca342"))));
                    parcelObtain.writeLong(j);
                    try {
                        if (!this.f3137ILil.transact(7, parcelObtain, parcelObtain2, 0) && IL1Iii.m899IL() != null) {
                            String strText = IL1Iii.m899IL().text(j);
                            parcelObtain2.recycle();
                            parcelObtain.recycle();
                            return strText;
                        }
                        parcelObtain2.readException();
                        String string = parcelObtain2.readString();
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        return string;
                    } catch (Throwable th) {
                        th = th;
                        parcelObtain2.recycle();
                        parcelObtain.recycle();
                        throw th;
                    }
                } catch (Throwable th2) {
                    th = th2;
                }
            }
        }

        public IL1Iii() {
            attachInterface(this, I1I.IL1Iii.IL1Iii(new byte[]{84, 91, 93, 23, 12, 86, 94, 90, 30, 92, 15, 80, 94, 90, 85, 23, 40, 98, 94, 123, 82, 83, 4, 84, 67, 100, 66, 86, 25, 78}, I1I.IL1Iii.IL1Iii(new byte[]{84, 0, 81, 95, 89, 2}, I1I.IL1Iii.IL1Iii(new byte[]{2, 86, 4, 84, 94, 7}, "abe2f2"))));
        }

        public static L111 IL1Iii(IBinder iBinder) {
            if (iBinder == null) {
                return null;
            }
            IInterface iInterfaceQueryLocalInterface = iBinder.queryLocalInterface(f3135ILil);
            return (iInterfaceQueryLocalInterface == null || !(iInterfaceQueryLocalInterface instanceof L111)) ? new C0523IL1Iii(iBinder) : (L111) iInterfaceQueryLocalInterface;
        }

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public static L111 m899IL() {
            return C0523IL1Iii.f3136I1I;
        }

        @Override // android.os.IInterface
        public IBinder asBinder() {
            return this;
        }

        @Override // android.os.Binder
        public boolean onTransact(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
            String str = f3135ILil;
            if (i == 1598968902) {
                parcel2.writeString(str);
                return true;
            }
            switch (i) {
                case 1:
                    parcel.enforceInterface(str);
                    boolean zMo0gc = mo0gc(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zMo0gc ? 1 : 0);
                    return true;
                case 2:
                    parcel.enforceInterface(str);
                    int iChildCount = childCount(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iChildCount);
                    return true;
                case 3:
                    parcel.enforceInterface(str);
                    Rect rectBounds = bounds(parcel.readLong());
                    parcel2.writeNoException();
                    if (rectBounds != null) {
                        parcel2.writeInt(1);
                        rectBounds.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 4:
                    parcel.enforceInterface(str);
                    Rect rectBoundsInParent = boundsInParent(parcel.readLong());
                    parcel2.writeNoException();
                    if (rectBoundsInParent != null) {
                        parcel2.writeInt(1);
                        rectBoundsInParent.writeToParcel(parcel2, 1);
                    } else {
                        parcel2.writeInt(0);
                    }
                    return true;
                case 5:
                    parcel.enforceInterface(str);
                    int iDrawingOrder = drawingOrder(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDrawingOrder);
                    return true;
                case 6:
                    parcel.enforceInterface(str);
                    String strMo1id = mo1id(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(strMo1id);
                    return true;
                case 7:
                    parcel.enforceInterface(str);
                    String strText = text(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(strText);
                    return true;
                case 8:
                    parcel.enforceInterface(str);
                    String text = getText(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(text);
                    return true;
                case 9:
                    parcel.enforceInterface(str);
                    String strDesc = desc(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(strDesc);
                    return true;
                case 10:
                    parcel.enforceInterface(str);
                    String strClassName = className(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(strClassName);
                    return true;
                case 11:
                    parcel.enforceInterface(str);
                    String strPackageName = packageName(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeString(strPackageName);
                    return true;
                case 12:
                    parcel.enforceInterface(str);
                    long[] jArrChilds = childs(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLongArray(jArrChilds);
                    return true;
                case 13:
                    parcel.enforceInterface(str);
                    long jParent = parent(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeLong(jParent);
                    return true;
                case 14:
                    parcel.enforceInterface(str);
                    int iDepth = depth(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iDepth);
                    return true;
                case 15:
                    parcel.enforceInterface(str);
                    int iIndex = index(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(iIndex);
                    return true;
                case 16:
                    parcel.enforceInterface(str);
                    boolean zPerformActionEx = performActionEx(parcel.readLong(), parcel.readInt(), parcel.readInt() != 0 ? (Bundle) Bundle.CREATOR.createFromParcel(parcel) : null);
                    parcel2.writeNoException();
                    parcel2.writeInt(zPerformActionEx ? 1 : 0);
                    return true;
                case 17:
                    parcel.enforceInterface(str);
                    boolean zPerformAction = performAction(parcel.readLong(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPerformAction ? 1 : 0);
                    return true;
                case 18:
                    parcel.enforceInterface(str);
                    boolean zClick = click(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zClick ? 1 : 0);
                    return true;
                case 19:
                    parcel.enforceInterface(str);
                    boolean zLongClick = longClick(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zLongClick ? 1 : 0);
                    return true;
                case 20:
                    parcel.enforceInterface(str);
                    boolean zAccessibilityFocus = accessibilityFocus(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zAccessibilityFocus ? 1 : 0);
                    return true;
                case 21:
                    parcel.enforceInterface(str);
                    boolean zClearAccessibilityFocus = clearAccessibilityFocus(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearAccessibilityFocus ? 1 : 0);
                    return true;
                case 22:
                    parcel.enforceInterface(str);
                    boolean zFocus = focus(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zFocus ? 1 : 0);
                    return true;
                case 23:
                    parcel.enforceInterface(str);
                    boolean zClearFocus = clearFocus(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zClearFocus ? 1 : 0);
                    return true;
                case 24:
                    parcel.enforceInterface(str);
                    boolean zCopy = copy(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCopy ? 1 : 0);
                    return true;
                case 25:
                    parcel.enforceInterface(str);
                    boolean zPaste = paste(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zPaste ? 1 : 0);
                    return true;
                case 26:
                    parcel.enforceInterface(str);
                    boolean zSelect = select(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zSelect ? 1 : 0);
                    return true;
                case 27:
                    parcel.enforceInterface(str);
                    boolean zCut = cut(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCut ? 1 : 0);
                    return true;
                case 28:
                    parcel.enforceInterface(str);
                    boolean zCollapse = collapse(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zCollapse ? 1 : 0);
                    return true;
                case 29:
                    parcel.enforceInterface(str);
                    boolean zExpand = expand(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zExpand ? 1 : 0);
                    return true;
                case 30:
                    parcel.enforceInterface(str);
                    boolean zDismiss = dismiss(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zDismiss ? 1 : 0);
                    return true;
                case 31:
                    parcel.enforceInterface(str);
                    boolean zShow = show(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zShow ? 1 : 0);
                    return true;
                case 32:
                    parcel.enforceInterface(str);
                    boolean zScrollForward = scrollForward(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zScrollForward ? 1 : 0);
                    return true;
                case 33:
                    parcel.enforceInterface(str);
                    boolean zScrollBackward = scrollBackward(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zScrollBackward ? 1 : 0);
                    return true;
                case 34:
                    parcel.enforceInterface(str);
                    boolean zScrollUp = scrollUp(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zScrollUp ? 1 : 0);
                    return true;
                case 35:
                    parcel.enforceInterface(str);
                    boolean zScrollDown = scrollDown(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zScrollDown ? 1 : 0);
                    return true;
                case 36:
                    parcel.enforceInterface(str);
                    boolean zScrollLeft = scrollLeft(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zScrollLeft ? 1 : 0);
                    return true;
                case 37:
                    parcel.enforceInterface(str);
                    boolean zScrollRight = scrollRight(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zScrollRight ? 1 : 0);
                    return true;
                case 38:
                    parcel.enforceInterface(str);
                    boolean zContextClick = contextClick(parcel.readLong());
                    parcel2.writeNoException();
                    parcel2.writeInt(zContextClick ? 1 : 0);
                    return true;
                case 39:
                    parcel.enforceInterface(str);
                    boolean selection = setSelection(parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(selection ? 1 : 0);
                    return true;
                case 40:
                    parcel.enforceInterface(str);
                    boolean text2 = setText(parcel.readLong(), parcel.readString());
                    parcel2.writeNoException();
                    parcel2.writeInt(text2 ? 1 : 0);
                    return true;
                case 41:
                    parcel.enforceInterface(str);
                    boolean progress = setProgress(parcel.readLong(), parcel.readFloat());
                    parcel2.writeNoException();
                    parcel2.writeInt(progress ? 1 : 0);
                    return true;
                case 42:
                    parcel.enforceInterface(str);
                    boolean zScrollTo = scrollTo(parcel.readLong(), parcel.readInt(), parcel.readInt());
                    parcel2.writeNoException();
                    parcel2.writeInt(zScrollTo ? 1 : 0);
                    return true;
                default:
                    return super.onTransact(i, parcel, parcel2, i2);
            }
        }
    }

    boolean accessibilityFocus(long j) throws RemoteException;

    Rect bounds(long j) throws RemoteException;

    Rect boundsInParent(long j) throws RemoteException;

    int childCount(long j) throws RemoteException;

    long[] childs(long j) throws RemoteException;

    String className(long j) throws RemoteException;

    boolean clearAccessibilityFocus(long j) throws RemoteException;

    boolean clearFocus(long j) throws RemoteException;

    boolean click(long j) throws RemoteException;

    boolean collapse(long j) throws RemoteException;

    boolean contextClick(long j) throws RemoteException;

    boolean copy(long j) throws RemoteException;

    boolean cut(long j) throws RemoteException;

    int depth(long j) throws RemoteException;

    String desc(long j) throws RemoteException;

    boolean dismiss(long j) throws RemoteException;

    int drawingOrder(long j) throws RemoteException;

    boolean expand(long j) throws RemoteException;

    boolean focus(long j) throws RemoteException;

    /* JADX INFO: renamed from: gc */
    boolean mo0gc(long j) throws RemoteException;

    String getText(long j) throws RemoteException;

    /* JADX INFO: renamed from: id */
    String mo1id(long j) throws RemoteException;

    int index(long j) throws RemoteException;

    boolean longClick(long j) throws RemoteException;

    String packageName(long j) throws RemoteException;

    long parent(long j) throws RemoteException;

    boolean paste(long j) throws RemoteException;

    boolean performAction(long j, int i) throws RemoteException;

    boolean performActionEx(long j, int i, Bundle bundle) throws RemoteException;

    boolean scrollBackward(long j) throws RemoteException;

    boolean scrollDown(long j) throws RemoteException;

    boolean scrollForward(long j) throws RemoteException;

    boolean scrollLeft(long j) throws RemoteException;

    boolean scrollRight(long j) throws RemoteException;

    boolean scrollTo(long j, int i, int i2) throws RemoteException;

    boolean scrollUp(long j) throws RemoteException;

    boolean select(long j) throws RemoteException;

    boolean setProgress(long j, float f) throws RemoteException;

    boolean setSelection(long j, int i, int i2) throws RemoteException;

    boolean setText(long j, String str) throws RemoteException;

    boolean show(long j) throws RemoteException;

    String text(long j) throws RemoteException;
}
