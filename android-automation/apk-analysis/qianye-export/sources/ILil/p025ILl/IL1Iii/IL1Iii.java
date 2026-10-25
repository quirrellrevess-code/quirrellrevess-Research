package ILil.p025ILl.IL1Iii;

import ILil.p042lIiI.IiL;
import ILil.p042lIiI.iIi1;
import java.io.FileDescriptor;
import java.io.PrintWriter;

/* JADX INFO: compiled from: LoaderManager.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii {
    public static <T extends IiL & iIi1> IL1Iii ILil(T t) {
        return new ILil(t, t.getViewModelStore());
    }

    public abstract void I1I();

    @Deprecated
    public abstract void IL1Iii(String str, FileDescriptor fileDescriptor, PrintWriter printWriter, String[] strArr);
}
