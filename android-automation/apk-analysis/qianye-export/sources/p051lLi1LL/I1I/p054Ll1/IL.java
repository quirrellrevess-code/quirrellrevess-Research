package p051lLi1LL.I1I.p054Ll1;

import p051lLi1LL.I1I.p055L11I.I1I;
import p051lLi1LL.I1I.p058il.lLi1LL;

/* JADX INFO: renamed from: l丨Li1LL.I1I.Ll丨1.I丨L, reason: invalid class name */
/* JADX INFO: compiled from: ControlFrame.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL extends IiL {
    public IL(I1I i1i) {
        super(i1i);
    }

    @Override // p051lLi1LL.I1I.p054Ll1.IiL
    /* JADX INFO: renamed from: I丨iL */
    public void mo3583IiL() throws p051lLi1LL.I1I.p058il.I1I {
        if (!Ilil()) {
            throw new lLi1LL("Control frame cant have fin==false set");
        }
        if (IL1Iii()) {
            throw new lLi1LL("Control frame cant have rsv1==true set");
        }
        if (ILil()) {
            throw new lLi1LL("Control frame cant have rsv2==true set");
        }
        if (mo3590IL()) {
            throw new lLi1LL("Control frame cant have rsv3==true set");
        }
    }
}
