package ILil.p026IL.p027iILLL1;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RectF;

/* JADX INFO: compiled from: CardViewApi17Impl.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii extends I1I {

    /* JADX INFO: renamed from: ILil.I丨L.iI丨LLL1.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CardViewApi17Impl.java */
    public class C0559IL1Iii implements IiL.IL1Iii {
        public C0559IL1Iii(IL1Iii iL1Iii) {
        }

        @Override // ILil.p026IL.p027iILLL1.IiL.IL1Iii
        public void IL1Iii(Canvas canvas, RectF rectF, float f, Paint paint) {
            canvas.drawRoundRect(rectF, f, f, paint);
        }
    }

    @Override // ILil.p026IL.p027iILLL1.I1I, ILil.p026IL.p027iILLL1.lLi1LL
    /* JADX INFO: renamed from: 丨il */
    public void mo1993il() {
        IiL.f1582lIlii = new C0559IL1Iii(this);
    }
}
