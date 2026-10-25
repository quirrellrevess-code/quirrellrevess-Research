package ILil.ILil.p023lIlii;

import ILil.p028IiL.p034lIiI.L11I;
import android.view.textclassifier.TextClassificationManager;
import android.view.textclassifier.TextClassifier;
import android.widget.TextView;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.Ll丨1, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatTextClassifierHelper.java */
/* JADX INFO: loaded from: classes.dex */
public final class Ll1 {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public TextView f3776IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public TextClassifier f3777ILil;

    public Ll1(TextView textView) {
        L11I.m2295IL(textView);
        this.f3776IL1Iii = textView;
    }

    public TextClassifier IL1Iii() {
        TextClassifier textClassifier = this.f3777ILil;
        if (textClassifier != null) {
            return textClassifier;
        }
        TextClassificationManager textClassificationManager = (TextClassificationManager) this.f3776IL1Iii.getContext().getSystemService(TextClassificationManager.class);
        return textClassificationManager != null ? textClassificationManager.getTextClassifier() : TextClassifier.NO_OP;
    }

    public void ILil(TextClassifier textClassifier) {
        this.f3777ILil = textClassifier;
    }
}
