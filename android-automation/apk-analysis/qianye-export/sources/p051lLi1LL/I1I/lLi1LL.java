package p051lLi1LL.I1I;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import p051lLi1LL.I1I.p054Ll1.L11I;
import p051lLi1LL.I1I.p057lIiI.IL1Iii;
import p051lLi1LL.I1I.p057lIiI.InterfaceC0674il;
import p051lLi1LL.I1I.p057lIiI.iILLL1;
import p051lLi1LL.I1I.p058il.I1I;

/* JADX INFO: renamed from: l丨Li1LL.I1I.l丨Li1LL, reason: invalid class name */
/* JADX INFO: compiled from: WebSocketListener.java */
/* JADX INFO: loaded from: classes.dex */
public interface lLi1LL {
    InetSocketAddress getLocalSocketAddress(ILil iLil);

    InetSocketAddress getRemoteSocketAddress(ILil iLil);

    L11I onPreparePing(ILil iLil);

    void onWebsocketClose(ILil iLil, int i, String str, boolean z);

    void onWebsocketCloseInitiated(ILil iLil, int i, String str);

    void onWebsocketClosing(ILil iLil, int i, String str, boolean z);

    void onWebsocketError(ILil iLil, Exception exc);

    void onWebsocketHandshakeReceivedAsClient(ILil iLil, IL1Iii iL1Iii, p051lLi1LL.I1I.p057lIiI.L11I l11i) throws I1I;

    InterfaceC0674il onWebsocketHandshakeReceivedAsServer(ILil iLil, p051lLi1LL.I1I.p053IiL.IL1Iii iL1Iii, IL1Iii iL1Iii2) throws I1I;

    void onWebsocketHandshakeSentAsClient(ILil iLil, IL1Iii iL1Iii) throws I1I;

    void onWebsocketMessage(ILil iLil, String str);

    void onWebsocketMessage(ILil iLil, ByteBuffer byteBuffer);

    void onWebsocketOpen(ILil iLil, iILLL1 iilll1);

    void onWebsocketPing(ILil iLil, p051lLi1LL.I1I.p054Ll1.iILLL1 iilll1);

    void onWebsocketPong(ILil iLil, p051lLi1LL.I1I.p054Ll1.iILLL1 iilll1);

    void onWriteDemand(ILil iLil);
}
