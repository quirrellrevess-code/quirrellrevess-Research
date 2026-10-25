package p051lLi1LL.I1I;

import p051lLi1LL.I1I.p054Ll1.C0673il;
import p051lLi1LL.I1I.p054Ll1.L11I;
import p051lLi1LL.I1I.p054Ll1.iILLL1;
import p051lLi1LL.I1I.p057lIiI.IL1Iii;
import p051lLi1LL.I1I.p057lIiI.InterfaceC0674il;
import p051lLi1LL.I1I.p057lIiI.lLi1LL;

/* JADX INFO: compiled from: WebSocketAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class I1I implements lLi1LL {
    private L11I pingFrame;

    @Override // p051lLi1LL.I1I.lLi1LL
    public L11I onPreparePing(ILil iLil) {
        if (this.pingFrame == null) {
            this.pingFrame = new L11I();
        }
        return this.pingFrame;
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public void onWebsocketHandshakeReceivedAsClient(ILil iLil, IL1Iii iL1Iii, p051lLi1LL.I1I.p057lIiI.L11I l11i) throws p051lLi1LL.I1I.p058il.I1I {
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public InterfaceC0674il onWebsocketHandshakeReceivedAsServer(ILil iLil, p051lLi1LL.I1I.p053IiL.IL1Iii iL1Iii, IL1Iii iL1Iii2) throws p051lLi1LL.I1I.p058il.I1I {
        return new lLi1LL();
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public void onWebsocketHandshakeSentAsClient(ILil iLil, IL1Iii iL1Iii) throws p051lLi1LL.I1I.p058il.I1I {
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public void onWebsocketPing(ILil iLil, iILLL1 iilll1) {
        iLil.sendFrame(new C0673il((L11I) iilll1));
    }

    @Override // p051lLi1LL.I1I.lLi1LL
    public void onWebsocketPong(ILil iLil, iILLL1 iilll1) {
    }
}
