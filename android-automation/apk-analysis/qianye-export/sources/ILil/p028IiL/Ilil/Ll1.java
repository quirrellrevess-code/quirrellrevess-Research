package ILil.p028IiL.Ilil;

import android.app.Activity;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.util.Log;
import java.util.ArrayList;
import java.util.Iterator;
import org.opencv.videoio.Videoio;

/* JADX INFO: renamed from: ILil.I丨iL.Ilil.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: TaskStackBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public final class Ll1 implements Iterable<Intent> {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Context f4106I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final ArrayList<Intent> f4107ILil = new ArrayList<>();

    /* JADX INFO: renamed from: ILil.I丨iL.Ilil.Ll丨1$IL1Iii */
    /* JADX INFO: compiled from: TaskStackBuilder.java */
    public interface IL1Iii {
        Intent I1I();
    }

    public Ll1(Context context) {
        this.f4106I1I = context;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static Ll1 m2178IL(Context context) {
        return new Ll1(context);
    }

    public Ll1 I1I(ComponentName componentName) {
        int size = this.f4107ILil.size();
        try {
            Intent intentILil = IL.ILil(this.f4106I1I, componentName);
            while (intentILil != null) {
                this.f4107ILil.add(size, intentILil);
                intentILil = IL.ILil(this.f4106I1I, intentILil.getComponent());
            }
            return this;
        } catch (PackageManager.NameNotFoundException e) {
            Log.e("TaskStackBuilder", "Bad ComponentName while traversing activity parent metadata");
            throw new IllegalArgumentException(e);
        }
    }

    public Ll1 IL1Iii(Intent intent) {
        this.f4107ILil.add(intent);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public Ll1 ILil(Activity activity) {
        Intent intentI1I = activity instanceof IL1Iii ? ((IL1Iii) activity).I1I() : null;
        if (intentI1I == null) {
            intentI1I = IL.IL1Iii(activity);
        }
        if (intentI1I != null) {
            ComponentName component = intentI1I.getComponent();
            if (component == null) {
                component = intentI1I.resolveActivity(this.f4106I1I.getPackageManager());
            }
            I1I(component);
            IL1Iii(intentI1I);
        }
        return this;
    }

    public void Ilil() {
        m2179lLi1LL(null);
    }

    @Override // java.lang.Iterable
    @Deprecated
    public Iterator<Intent> iterator() {
        return this.f4107ILil.iterator();
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2179lLi1LL(Bundle bundle) {
        if (this.f4107ILil.isEmpty()) {
            throw new IllegalStateException("No intents added to TaskStackBuilder; cannot startActivities");
        }
        ArrayList<Intent> arrayList = this.f4107ILil;
        Intent[] intentArr = (Intent[]) arrayList.toArray(new Intent[arrayList.size()]);
        intentArr[0] = new Intent(intentArr[0]).addFlags(268484608);
        if (ILil.p028IiL.p035lLi1LL.IL1Iii.m2322iILLL1(this.f4106I1I, intentArr, bundle)) {
            return;
        }
        Intent intent = new Intent(intentArr[intentArr.length - 1]);
        intent.addFlags(Videoio.CAP_INTELPERC_IMAGE_GENERATOR);
        this.f4106I1I.startActivity(intent);
    }
}
