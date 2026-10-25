package ILil.ILil.p023lIlii;

import android.view.View;
import android.view.ViewParent;
import android.view.inputmethod.EditorInfo;
import android.view.inputmethod.InputConnection;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: AppCompatHintHelper.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL {
    public static InputConnection IL1Iii(InputConnection inputConnection, EditorInfo editorInfo, View view) {
        if (inputConnection != null && editorInfo.hintText == null) {
            for (ViewParent parent = view.getParent(); parent instanceof View; parent = parent.getParent()) {
                if (parent instanceof InterfaceC0556) {
                    editorInfo.hintText = ((InterfaceC0556) parent).IL1Iii();
                    break;
                }
            }
        }
        return inputConnection;
    }
}
