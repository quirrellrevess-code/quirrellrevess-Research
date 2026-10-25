package ILil.ILL.IL1Iii;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p028IiL.p029ILl.lL;
import ILil.p028IiL.p029ILl.llL1ii;
import android.annotation.SuppressLint;
import android.graphics.Rect;
import android.view.View;
import android.view.ViewGroup;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/* JADX INFO: renamed from: ILil.ILL.IL1Iii.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: FragmentTransitionImpl.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"UnknownNullness"})
public abstract class AbstractC0618ILl {

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.IL丨丨l$I1I */
    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    public class I1I implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Map f3628I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3629ILil;

        public I1I(AbstractC0618ILl abstractC0618ILl, ArrayList arrayList, Map map) {
            this.f3629ILil = arrayList;
            this.f3628I1I = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f3629ILil.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f3629ILil.get(i);
                iIlLiL.m76l(view, (String) this.f3628I1I.get(iIlLiL.llI(view)));
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.IL丨丨l$IL1Iii */
    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    public class IL1Iii implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3630I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ int f3631ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3632Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1217IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public final /* synthetic */ ArrayList f1218lLi1LL;

        public IL1Iii(AbstractC0618ILl abstractC0618ILl, int i, ArrayList arrayList, ArrayList arrayList2, ArrayList arrayList3, ArrayList arrayList4) {
            this.f3631ILil = i;
            this.f3630I1I = arrayList;
            this.f1217IL = arrayList2;
            this.f3632Ilil = arrayList3;
            this.f1218lLi1LL = arrayList4;
        }

        @Override // java.lang.Runnable
        public void run() {
            for (int i = 0; i < this.f3631ILil; i++) {
                iIlLiL.m76l((View) this.f3630I1I.get(i), (String) this.f1217IL.get(i));
                iIlLiL.m76l((View) this.f3632Ilil.get(i), (String) this.f1218lLi1LL.get(i));
            }
        }
    }

    /* JADX INFO: renamed from: ILil.ILL.IL1Iii.IL丨丨l$ILil */
    /* JADX INFO: compiled from: FragmentTransitionImpl.java */
    public class ILil implements Runnable {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final /* synthetic */ Map f3633I1I;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final /* synthetic */ ArrayList f3634ILil;

        public ILil(AbstractC0618ILl abstractC0618ILl, ArrayList arrayList, Map map) {
            this.f3634ILil = arrayList;
            this.f3633I1I = map;
        }

        @Override // java.lang.Runnable
        public void run() {
            int size = this.f3634ILil.size();
            for (int i = 0; i < size; i++) {
                View view = (View) this.f3634ILil.get(i);
                String strLlI = iIlLiL.llI(view);
                if (strLlI != null) {
                    iIlLiL.m76l(view, AbstractC0618ILl.m1466L11I(this.f3633I1I, strLlI));
                }
            }
        }
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public static void m1463IL(List<View> list, View view) {
        int size = list.size();
        if (m1464IiL(list, view, size)) {
            return;
        }
        list.add(view);
        for (int i = size; i < list.size(); i++) {
            View view2 = list.get(i);
            if (view2 instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view2;
                int childCount = viewGroup.getChildCount();
                for (int i2 = 0; i2 < childCount; i2++) {
                    View childAt = viewGroup.getChildAt(i2);
                    if (!m1464IiL(list, childAt, size)) {
                        list.add(childAt);
                    }
                }
            }
        }
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public static boolean m1464IiL(List<View> list, View view, int i) {
        for (int i2 = 0; i2 < i; i2++) {
            if (list.get(i2) == view) {
                return true;
            }
        }
        return false;
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public static boolean m1465Ll1(List list) {
        return list == null || list.isEmpty();
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public static String m1466L11I(Map<String, String> map, String str) {
        for (Map.Entry<String, String> entry : map.entrySet()) {
            if (str.equals(entry.getValue())) {
                return entry.getKey();
            }
        }
        return null;
    }

    public void I11L(View view, ArrayList<View> arrayList, Map<String, String> map) {
        llL1ii.IL1Iii(view, new ILil(this, arrayList, map));
    }

    public abstract void I11li1(Object obj, Rect rect);

    public abstract void I1I(ViewGroup viewGroup, Object obj);

    public abstract void IL1Iii(Object obj, View view);

    public void ILL(View view, Rect rect) {
        int[] iArr = new int[2];
        view.getLocationOnScreen(iArr);
        rect.set(iArr[0], iArr[1], iArr[0] + view.getWidth(), iArr[1] + view.getHeight());
    }

    public abstract void ILil(Object obj, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public abstract Object mo1467ILl(Object obj, Object obj2, Object obj3);

    public abstract boolean Ilil(Object obj);

    public ArrayList<String> Lil(ArrayList<View> arrayList) {
        ArrayList<String> arrayList2 = new ArrayList<>();
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            View view = arrayList.get(i);
            arrayList2.add(iIlLiL.llI(view));
            iIlLiL.m76l(view, null);
        }
        return arrayList2;
    }

    public abstract void LlLI1(Object obj, View view);

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public abstract Object mo1468LlLLL(Object obj);

    public void iIi1(ViewGroup viewGroup, ArrayList<View> arrayList, Map<String, String> map) {
        llL1ii.IL1Iii(viewGroup, new I1I(this, arrayList, map));
    }

    public abstract void iIlLiL(Object obj, Object obj2, ArrayList<View> arrayList, Object obj3, ArrayList<View> arrayList2, Object obj4, ArrayList<View> arrayList3);

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public abstract Object mo1469iILLL1(Object obj);

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public abstract Object mo1470lIiI(Object obj, Object obj2, Object obj3);

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public abstract void mo1471lIlii(Object obj, View view, ArrayList<View> arrayList);

    public void llliI(View view, ArrayList<View> arrayList, ArrayList<View> arrayList2, ArrayList<String> arrayList3, Map<String, String> map) {
        int size = arrayList2.size();
        ArrayList arrayList4 = new ArrayList();
        for (int i = 0; i < size; i++) {
            View view2 = arrayList.get(i);
            String strLlI = iIlLiL.llI(view2);
            arrayList4.add(strLlI);
            if (strLlI != null) {
                iIlLiL.m76l(view2, null);
                String str = map.get(strLlI);
                for (int i2 = 0; i2 < size; i2++) {
                    if (str.equals(arrayList3.get(i2))) {
                        iIlLiL.m76l(arrayList2.get(i2), strLlI);
                        break;
                    }
                }
            }
        }
        llL1ii.IL1Iii(view, new IL1Iii(this, size, arrayList2, arrayList3, arrayList, arrayList4));
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public abstract void mo1472llL1ii(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m1473lLi1LL(ArrayList<View> arrayList, View view) {
        if (view.getVisibility() == 0) {
            if (!(view instanceof ViewGroup)) {
                arrayList.add(view);
                return;
            }
            ViewGroup viewGroup = (ViewGroup) view;
            if (lL.IL1Iii(viewGroup)) {
                arrayList.add(viewGroup);
                return;
            }
            int childCount = viewGroup.getChildCount();
            for (int i = 0; i < childCount; i++) {
                m1473lLi1LL(arrayList, viewGroup.getChildAt(i));
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public void m1474il(Map<String, View> map, View view) {
        if (view.getVisibility() == 0) {
            String strLlI = iIlLiL.llI(view);
            if (strLlI != null) {
                map.put(strLlI, view);
            }
            if (view instanceof ViewGroup) {
                ViewGroup viewGroup = (ViewGroup) view;
                int childCount = viewGroup.getChildCount();
                for (int i = 0; i < childCount; i++) {
                    m1474il(map, viewGroup.getChildAt(i));
                }
            }
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public abstract void mo1475lL(Object obj, View view);

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public abstract void mo1476l(Object obj, View view, ArrayList<View> arrayList);

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public abstract void mo14771(Object obj, ArrayList<View> arrayList, ArrayList<View> arrayList2);
}
