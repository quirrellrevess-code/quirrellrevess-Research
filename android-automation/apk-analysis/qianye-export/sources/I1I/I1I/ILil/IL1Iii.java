package I1I.I1I.ILil;

import android.app.IAccessibServiceProxy;
import android.os.RemoteException;
import android.view.accessibility.AccessibilityNodeInfo;
import java.util.List;

/* JADX INFO: compiled from: AccessibServiceProxy.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends IAccessibServiceProxy.Stub {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public I1I.p062Ilil.p064Ilil.ILil.IL1Iii f3095ILil;

    public IL1Iii(I1I.p062Ilil.p064Ilil.ILil.IL1Iii iL1Iii) {
        this.f3095ILil = iL1Iii;
    }

    @Override // android.app.IAccessibServiceProxy
    public AccessibilityNodeInfo getRootInActiveWindow() throws RemoteException {
        I1I.p062Ilil.p064Ilil.ILil.IL1Iii iL1Iii = this.f3095ILil;
        if (iL1Iii == null) {
            return null;
        }
        iL1Iii.IL1Iii();
        return this.f3095ILil.I1I();
    }

    @Override // android.app.IAccessibServiceProxy
    public List<AccessibilityNodeInfo> getWindows() throws RemoteException {
        I1I.p062Ilil.p064Ilil.ILil.IL1Iii iL1Iii = this.f3095ILil;
        if (iL1Iii == null) {
            return null;
        }
        iL1Iii.IL1Iii();
        return this.f3095ILil.mo858iILLL1();
    }
}
