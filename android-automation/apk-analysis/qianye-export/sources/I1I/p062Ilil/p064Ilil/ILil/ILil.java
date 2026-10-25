package I1I.p062Ilil.p064Ilil.ILil;

import android.os.Bundle;

/* JADX INFO: compiled from: ActionArgument.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class ILil {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final String f3535IL1Iii;

    /* JADX INFO: compiled from: ActionArgument.java */
    public static class I1I extends ILil {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final float f3536ILil;

        public I1I(String str, float f) {
            super(str);
            this.f3536ILil = f;
        }

        @Override // I1I.p062Ilil.p064Ilil.ILil.ILil
        public void IL1Iii(Bundle bundle) {
            bundle.putFloat(this.f3535IL1Iii, this.f3536ILil);
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.ILil$ILil, reason: collision with other inner class name */
    /* JADX INFO: compiled from: ActionArgument.java */
    public static class C0542ILil extends ILil {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final CharSequence f3537ILil;

        public C0542ILil(String str, CharSequence charSequence) {
            super(str);
            this.f3537ILil = charSequence;
        }

        @Override // I1I.p062Ilil.p064Ilil.ILil.ILil
        public void IL1Iii(Bundle bundle) {
            bundle.putCharSequence(this.f3535IL1Iii, this.f3537ILil);
        }
    }

    /* JADX INFO: renamed from: I1I.Ilil.Ilil.ILil.ILil$I丨L, reason: invalid class name */
    /* JADX INFO: compiled from: ActionArgument.java */
    public static class IL extends ILil {

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final int f3538ILil;

        public IL(String str, int i) {
            super(str);
            this.f3538ILil = i;
        }

        @Override // I1I.p062Ilil.p064Ilil.ILil.ILil
        public void IL1Iii(Bundle bundle) {
            bundle.putInt(this.f3535IL1Iii, this.f3538ILil);
        }
    }

    public abstract void IL1Iii(Bundle bundle);

    public ILil(String str) {
        this.f3535IL1Iii = str;
    }
}
