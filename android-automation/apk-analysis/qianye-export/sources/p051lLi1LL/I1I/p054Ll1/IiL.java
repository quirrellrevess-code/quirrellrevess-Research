package p051lLi1LL.I1I.p054Ll1;

import java.nio.ByteBuffer;
import p051lLi1LL.I1I.LlLI1.ILil;
import p051lLi1LL.I1I.p055L11I.I1I;

/* JADX INFO: renamed from: l丨Li1LL.I1I.Ll丨1.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: FramedataImpl1.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IiL implements iILLL1 {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public I1I f5463ILil;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public ByteBuffer f5461I1I = ILil.IL1Iii();

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public boolean f5462IL1Iii = true;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean f2999IL = false;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public boolean f5464Ilil = false;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public boolean f3001lLi1LL = false;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public boolean f3000iILLL1 = false;

    /* JADX INFO: renamed from: l丨Li1LL.I1I.Ll丨1.I丨iL$IL1Iii */
    /* JADX INFO: compiled from: FramedataImpl1.java */
    public static /* synthetic */ class IL1Iii {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f5465IL1Iii;

        static {
            int[] iArr = new int[I1I.values().length];
            f5465IL1Iii = iArr;
            try {
                iArr[I1I.PING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5465IL1Iii[I1I.PONG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5465IL1Iii[I1I.TEXT.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5465IL1Iii[I1I.BINARY.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5465IL1Iii[I1I.CLOSING.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                f5465IL1Iii[I1I.CONTINUOUS.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public IiL(I1I i1i) {
        this.f5463ILil = i1i;
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public static IiL m3588iILLL1(I1I i1i) {
        if (i1i == null) {
            throw new IllegalArgumentException("Supplied opcode cannot be null");
        }
        switch (IL1Iii.f5465IL1Iii[i1i.ordinal()]) {
            case 1:
                return new L11I();
            case 2:
                return new C0673il();
            case 3:
                return new ILL();
            case 4:
                return new p051lLi1LL.I1I.p054Ll1.IL1Iii();
            case 5:
                return new ILil();
            case 6:
                return new I1I();
            default:
                throw new IllegalArgumentException("Supplied opcode is invalid");
        }
    }

    @Override // p051lLi1LL.I1I.p054Ll1.iILLL1
    public I1I I1I() {
        return this.f5463ILil;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.iILLL1
    public boolean IL1Iii() {
        return this.f5464Ilil;
    }

    public void ILL(boolean z) {
        this.f5464Ilil = z;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.iILLL1
    public boolean ILil() {
        return this.f3001lLi1LL;
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public void m3589ILl(boolean z) {
        this.f2999IL = z;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.iILLL1
    public boolean Ilil() {
        return this.f5462IL1Iii;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.iILLL1
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public boolean mo3590IL() {
        return this.f3000iILLL1;
    }

    /* JADX INFO: renamed from: I丨iL */
    public abstract void mo3583IiL() throws p051lLi1LL.I1I.p058il.I1I;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public void m3591Ll1(boolean z) {
        this.f3001lLi1LL = z;
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m3592L11I(boolean z) {
        this.f5462IL1Iii = z;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }
        IiL iiL = (IiL) obj;
        if (this.f5462IL1Iii != iiL.f5462IL1Iii || this.f2999IL != iiL.f2999IL || this.f5464Ilil != iiL.f5464Ilil || this.f3001lLi1LL != iiL.f3001lLi1LL || this.f3000iILLL1 != iiL.f3000iILLL1 || this.f5463ILil != iiL.f5463ILil) {
            return false;
        }
        ByteBuffer byteBuffer = this.f5461I1I;
        ByteBuffer byteBuffer2 = iiL.f5461I1I;
        if (byteBuffer != null) {
            return byteBuffer.equals(byteBuffer2);
        }
        return byteBuffer2 == null;
    }

    public int hashCode() {
        int iHashCode = (((this.f5462IL1Iii ? 1 : 0) * 31) + this.f5463ILil.hashCode()) * 31;
        ByteBuffer byteBuffer = this.f5461I1I;
        return ((((((((iHashCode + (byteBuffer != null ? byteBuffer.hashCode() : 0)) * 31) + (this.f2999IL ? 1 : 0)) * 31) + (this.f5464Ilil ? 1 : 0)) * 31) + (this.f3001lLi1LL ? 1 : 0)) * 31) + (this.f3000iILLL1 ? 1 : 0);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public void m3593lIiI(boolean z) {
        this.f3000iILLL1 = z;
    }

    @Override // p051lLi1LL.I1I.p054Ll1.iILLL1
    /* JADX INFO: renamed from: l丨Li1LL */
    public ByteBuffer mo3586lLi1LL() {
        return this.f5461I1I;
    }

    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append("Framedata{ optcode:");
        sb.append(I1I());
        sb.append(", fin:");
        sb.append(Ilil());
        sb.append(", rsv1:");
        sb.append(IL1Iii());
        sb.append(", rsv2:");
        sb.append(ILil());
        sb.append(", rsv3:");
        sb.append(mo3590IL());
        sb.append(", payloadlength:[pos:");
        sb.append(this.f5461I1I.position());
        sb.append(", len:");
        sb.append(this.f5461I1I.remaining());
        sb.append("], payload:");
        sb.append(this.f5461I1I.remaining() > 1000 ? "(too big to display)" : new String(this.f5461I1I.array()));
        sb.append('}');
        return sb.toString();
    }

    /* JADX INFO: renamed from: 丨il */
    public void mo3587il(ByteBuffer byteBuffer) {
        this.f5461I1I = byteBuffer;
    }
}
