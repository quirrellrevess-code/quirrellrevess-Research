package I1I.I1I.ILil;

import I1I.I1I.p008IL.IiL;
import android.os.IInterface;
import android.view.InputEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: InputManager.java */
/* JADX INFO: loaded from: classes.dex */
public final class llI {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public static final String f3277I1I = "I1I.I1I.ILil.llI";

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IInterface f3278IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public Method f3279ILil;

    public llI(IInterface iInterface) {
        this.f3278IL1Iii = iInterface;
    }

    public final Method IL1Iii() throws NoSuchMethodException {
        if (this.f3279ILil == null) {
            this.f3279ILil = this.f3278IL1Iii.getClass().getMethod(I1I.IL1Iii.IL1Iii(new byte[]{91, 12, 12, 3, 80, 65, 123, 12, 22, 19, 71, 112, 68, 7, 8, 18}, I1I.IL1Iii.IL1Iii(new byte[]{11, 82, 86, 94, 7, 5}, I1I.IL1Iii.IL1Iii(new byte[]{11, 3, 4, 11, 86, 1}, "2343b1"))), InputEvent.class, Integer.TYPE);
        }
        return this.f3279ILil;
    }

    public boolean ILil(InputEvent inputEvent, int i) {
        try {
            return ((Boolean) IL1Iii().invoke(this.f3278IL1Iii, inputEvent, Integer.valueOf(i))).booleanValue();
        } catch (IllegalAccessException | NoSuchMethodException | InvocationTargetException e) {
            IiL.IL1Iii(f3277I1I, I1I.IL1Iii.IL1Iii(new byte[]{117, 95, 70, 10, 86, 18, 88, 95, 71, 70, 91, 92, 64, 95, 88, 3, 18, 95, 83, 68, 91, 9, 86}, I1I.IL1Iii.IL1Iii(new byte[]{83, 85, 2, 82, 7, 80}, I1I.IL1Iii.IL1Iii(new byte[]{86, 1, 9, 2, 7, 4}, "3d862f"))) + e.toString());
            return false;
        }
    }
}
