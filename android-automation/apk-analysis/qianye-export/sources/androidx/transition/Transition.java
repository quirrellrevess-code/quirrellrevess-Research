package androidx.transition;

import ILil.p028IiL.p029ILl.iIlLiL;
import ILil.p044llL1ii.C1;
import ILil.p044llL1ii.I11li1;
import ILil.p044llL1ii.I1L11L;
import ILil.p044llL1ii.IIi;
import ILil.p044llL1ii.LlLLL;
import ILil.p044llL1ii.llliI;
import ILil.p065Ilil.Lil;
import ILil.p065Ilil.Ll1;
import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.TimeInterpolator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.content.res.XmlResourceParser;
import android.graphics.Path;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.util.SparseArray;
import android.util.SparseIntArray;
import android.view.InflateException;
import android.view.View;
import android.view.ViewGroup;
import android.view.animation.AnimationUtils;
import android.widget.ListView;
import androidx.recyclerview.widget.RecyclerView;
import com.google.android.flexbox.BuildConfig;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.StringTokenizer;

/* JADX INFO: loaded from: classes.dex */
public abstract class Transition implements Cloneable {
    public static final boolean DBG = false;
    private static final String LOG_TAG = "Transition";
    private static final int MATCH_FIRST = 1;
    public static final int MATCH_ID = 3;
    private static final String MATCH_ID_STR = "id";
    public static final int MATCH_INSTANCE = 1;
    private static final String MATCH_INSTANCE_STR = "instance";
    public static final int MATCH_ITEM_ID = 4;
    private static final String MATCH_ITEM_ID_STR = "itemId";
    private static final int MATCH_LAST = 4;
    public static final int MATCH_NAME = 2;
    private static final String MATCH_NAME_STR = "name";
    private ArrayList<C1> mEndValuesList;
    private iILLL1 mEpicenterCallback;
    private Ll1<String, String> mNameOverrides;
    public llliI mPropagation;
    private ArrayList<C1> mStartValuesList;
    private static final int[] DEFAULT_MATCH_ORDER = {2, 1, 3, 4};
    private static final PathMotion STRAIGHT_PATH_MOTION = new IL1Iii();
    private static ThreadLocal<Ll1<Animator, IL>> sRunningAnimators = new ThreadLocal<>();
    private String mName = getClass().getName();
    private long mStartDelay = -1;
    public long mDuration = -1;
    private TimeInterpolator mInterpolator = null;
    public ArrayList<Integer> mTargetIds = new ArrayList<>();
    public ArrayList<View> mTargets = new ArrayList<>();
    private ArrayList<String> mTargetNames = null;
    private ArrayList<Class<?>> mTargetTypes = null;
    private ArrayList<Integer> mTargetIdExcludes = null;
    private ArrayList<View> mTargetExcludes = null;
    private ArrayList<Class<?>> mTargetTypeExcludes = null;
    private ArrayList<String> mTargetNameExcludes = null;
    private ArrayList<Integer> mTargetIdChildExcludes = null;
    private ArrayList<View> mTargetChildExcludes = null;
    private ArrayList<Class<?>> mTargetTypeChildExcludes = null;
    private LlLLL mStartValues = new LlLLL();
    private LlLLL mEndValues = new LlLLL();
    public TransitionSet mParent = null;
    private int[] mMatchOrder = DEFAULT_MATCH_ORDER;
    private ViewGroup mSceneRoot = null;
    public boolean mCanRemoveViews = false;
    public ArrayList<Animator> mCurrentAnimators = new ArrayList<>();
    private int mNumInstances = 0;
    private boolean mPaused = false;
    private boolean mEnded = false;
    private ArrayList<IiL> mListeners = null;
    private ArrayList<Animator> mAnimators = new ArrayList<>();
    private PathMotion mPathMotion = STRAIGHT_PATH_MOTION;

    public class I1I extends AnimatorListenerAdapter {
        public I1I() {
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            Transition.this.end();
            animator.removeListener(this);
        }
    }

    public static class IL1Iii extends PathMotion {
        @Override // androidx.transition.PathMotion
        public Path IL1Iii(float f, float f2, float f3, float f4) {
            Path path = new Path();
            path.moveTo(f, f2);
            path.lineTo(f3, f4);
            return path;
        }
    }

    public class ILil extends AnimatorListenerAdapter {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final /* synthetic */ Ll1 f5186IL1Iii;

        public ILil(Ll1 ll1) {
            this.f5186IL1Iii = ll1;
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationEnd(Animator animator) {
            this.f5186IL1Iii.remove(animator);
            Transition.this.mCurrentAnimators.remove(animator);
        }

        @Override // android.animation.AnimatorListenerAdapter, android.animation.Animator.AnimatorListener
        public void onAnimationStart(Animator animator) {
            Transition.this.mCurrentAnimators.add(animator);
        }
    }

    /* JADX INFO: renamed from: androidx.transition.Transition$I丨L, reason: invalid class name */
    public static class IL {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public C1 f5188I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public View f5189IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public String f5190ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public Transition f5191Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public I1L11L f2775IL;

        public IL(View view, String str, Transition transition, I1L11L i1l11l, C1 c1) {
            this.f5189IL1Iii = view;
            this.f5190ILil = str;
            this.f5188I1I = c1;
            this.f2775IL = i1l11l;
            this.f5191Ilil = transition;
        }
    }

    /* JADX INFO: renamed from: androidx.transition.Transition$I丨iL, reason: invalid class name */
    public interface IiL {
        void I1I(Transition transition);

        void IL1Iii(Transition transition);

        void ILil(Transition transition);

        void Ilil(Transition transition);

        /* JADX INFO: renamed from: I丨L */
        void mo2573IL(Transition transition);
    }

    /* JADX INFO: renamed from: androidx.transition.Transition$iI丨LLL1, reason: invalid class name */
    public static abstract class iILLL1 {
        public abstract Rect IL1Iii(Transition transition);
    }

    /* JADX INFO: renamed from: androidx.transition.Transition$l丨Li1LL, reason: invalid class name */
    public static class lLi1LL {
        public static <T> ArrayList<T> IL1Iii(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                arrayList = new ArrayList<>();
            }
            if (!arrayList.contains(t)) {
                arrayList.add(t);
            }
            return arrayList;
        }

        public static <T> ArrayList<T> ILil(ArrayList<T> arrayList, T t) {
            if (arrayList == null) {
                return arrayList;
            }
            arrayList.remove(t);
            if (arrayList.isEmpty()) {
                return null;
            }
            return arrayList;
        }
    }

    public Transition() {
    }

    private void addUnmatched(Ll1<View, C1> ll1, Ll1<View, C1> ll2) {
        for (int i = 0; i < ll1.size(); i++) {
            C1 c1M1975lIiI = ll1.m1975lIiI(i);
            if (isValidTarget(c1M1975lIiI.f4477ILil)) {
                this.mStartValuesList.add(c1M1975lIiI);
                this.mEndValuesList.add(null);
            }
        }
        for (int i2 = 0; i2 < ll2.size(); i2++) {
            C1 c1M1975lIiI2 = ll2.m1975lIiI(i2);
            if (isValidTarget(c1M1975lIiI2.f4477ILil)) {
                this.mEndValuesList.add(c1M1975lIiI2);
                this.mStartValuesList.add(null);
            }
        }
    }

    private static void addViewValues(LlLLL llLLL, View view, C1 c1) {
        llLLL.f4432IL1Iii.put(view, c1);
        int id = view.getId();
        if (id >= 0) {
            if (llLLL.f4433ILil.indexOfKey(id) >= 0) {
                llLLL.f4433ILil.put(id, null);
            } else {
                llLLL.f4433ILil.put(id, view);
            }
        }
        String strLlI = iIlLiL.llI(view);
        if (strLlI != null) {
            if (llLLL.f1859IL.containsKey(strLlI)) {
                llLLL.f1859IL.put(strLlI, null);
            } else {
                llLLL.f1859IL.put(strLlI, view);
            }
        }
        if (view.getParent() instanceof ListView) {
            ListView listView = (ListView) view.getParent();
            if (listView.getAdapter().hasStableIds()) {
                long itemIdAtPosition = listView.getItemIdAtPosition(listView.getPositionForView(view));
                if (llLLL.f4431I1I.m1944L11I(itemIdAtPosition) < 0) {
                    iIlLiL.Liil1L1l(view, true);
                    llLLL.f4431I1I.ILL(itemIdAtPosition, view);
                    return;
                }
                View viewM1947lLi1LL = llLLL.f4431I1I.m1947lLi1LL(itemIdAtPosition);
                if (viewM1947lLi1LL != null) {
                    iIlLiL.Liil1L1l(viewM1947lLi1LL, false);
                    llLLL.f4431I1I.ILL(itemIdAtPosition, null);
                }
            }
        }
    }

    private static boolean alreadyContains(int[] iArr, int i) {
        int i2 = iArr[i];
        for (int i3 = 0; i3 < i; i3++) {
            if (iArr[i3] == i2) {
                return true;
            }
        }
        return false;
    }

    private void captureHierarchy(View view, boolean z) {
        if (view == null) {
            return;
        }
        int id = view.getId();
        ArrayList<Integer> arrayList = this.mTargetIdExcludes;
        if (arrayList == null || !arrayList.contains(Integer.valueOf(id))) {
            ArrayList<View> arrayList2 = this.mTargetExcludes;
            if (arrayList2 == null || !arrayList2.contains(view)) {
                ArrayList<Class<?>> arrayList3 = this.mTargetTypeExcludes;
                if (arrayList3 != null) {
                    int size = arrayList3.size();
                    for (int i = 0; i < size; i++) {
                        if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                            return;
                        }
                    }
                }
                if (view.getParent() instanceof ViewGroup) {
                    C1 c1 = new C1(view);
                    if (z) {
                        captureStartValues(c1);
                    } else {
                        captureEndValues(c1);
                    }
                    c1.f4475I1I.add(this);
                    capturePropagationValues(c1);
                    if (z) {
                        addViewValues(this.mStartValues, view, c1);
                    } else {
                        addViewValues(this.mEndValues, view, c1);
                    }
                }
                if (view instanceof ViewGroup) {
                    ArrayList<Integer> arrayList4 = this.mTargetIdChildExcludes;
                    if (arrayList4 == null || !arrayList4.contains(Integer.valueOf(id))) {
                        ArrayList<View> arrayList5 = this.mTargetChildExcludes;
                        if (arrayList5 == null || !arrayList5.contains(view)) {
                            ArrayList<Class<?>> arrayList6 = this.mTargetTypeChildExcludes;
                            if (arrayList6 != null) {
                                int size2 = arrayList6.size();
                                for (int i2 = 0; i2 < size2; i2++) {
                                    if (this.mTargetTypeChildExcludes.get(i2).isInstance(view)) {
                                        return;
                                    }
                                }
                            }
                            ViewGroup viewGroup = (ViewGroup) view;
                            for (int i3 = 0; i3 < viewGroup.getChildCount(); i3++) {
                                captureHierarchy(viewGroup.getChildAt(i3), z);
                            }
                        }
                    }
                }
            }
        }
    }

    private ArrayList<Integer> excludeId(ArrayList<Integer> arrayList, int i, boolean z) {
        if (i > 0) {
            return z ? lLi1LL.IL1Iii(arrayList, Integer.valueOf(i)) : lLi1LL.ILil(arrayList, Integer.valueOf(i));
        }
        return arrayList;
    }

    private static <T> ArrayList<T> excludeObject(ArrayList<T> arrayList, T t, boolean z) {
        if (t != null) {
            return z ? lLi1LL.IL1Iii(arrayList, t) : lLi1LL.ILil(arrayList, t);
        }
        return arrayList;
    }

    private ArrayList<Class<?>> excludeType(ArrayList<Class<?>> arrayList, Class<?> cls, boolean z) {
        if (cls != null) {
            return z ? lLi1LL.IL1Iii(arrayList, cls) : lLi1LL.ILil(arrayList, cls);
        }
        return arrayList;
    }

    private ArrayList<View> excludeView(ArrayList<View> arrayList, View view, boolean z) {
        if (view != null) {
            return z ? lLi1LL.IL1Iii(arrayList, view) : lLi1LL.ILil(arrayList, view);
        }
        return arrayList;
    }

    private static Ll1<Animator, IL> getRunningAnimators() {
        Ll1<Animator, IL> ll1 = sRunningAnimators.get();
        if (ll1 != null) {
            return ll1;
        }
        Ll1<Animator, IL> ll2 = new Ll1<>();
        sRunningAnimators.set(ll2);
        return ll2;
    }

    private static boolean isValidMatch(int i) {
        return i >= 1 && i <= 4;
    }

    private static boolean isValueChanged(C1 c1, C1 c2, String str) {
        Object obj = c1.f4476IL1Iii.get(str);
        Object obj2 = c2.f4476IL1Iii.get(str);
        if (obj == null && obj2 == null) {
            return false;
        }
        if (obj == null || obj2 == null) {
            return true;
        }
        return true ^ obj.equals(obj2);
    }

    private void matchIds(Ll1<View, C1> ll1, Ll1<View, C1> ll2, SparseArray<View> sparseArray, SparseArray<View> sparseArray2) {
        View view;
        int size = sparseArray.size();
        for (int i = 0; i < size; i++) {
            View viewValueAt = sparseArray.valueAt(i);
            if (viewValueAt != null && isValidTarget(viewValueAt) && (view = sparseArray2.get(sparseArray.keyAt(i))) != null && isValidTarget(view)) {
                C1 c1 = ll1.get(viewValueAt);
                C1 c2 = ll2.get(view);
                if (c1 != null && c2 != null) {
                    this.mStartValuesList.add(c1);
                    this.mEndValuesList.add(c2);
                    ll1.remove(viewValueAt);
                    ll2.remove(view);
                }
            }
        }
    }

    private void matchInstances(Ll1<View, C1> ll1, Ll1<View, C1> ll2) {
        C1 c1Remove;
        for (int size = ll1.size() - 1; size >= 0; size--) {
            View viewM1973L11I = ll1.m1973L11I(size);
            if (viewM1973L11I != null && isValidTarget(viewM1973L11I) && (c1Remove = ll2.remove(viewM1973L11I)) != null && isValidTarget(c1Remove.f4477ILil)) {
                this.mStartValuesList.add(ll1.ILL(size));
                this.mEndValuesList.add(c1Remove);
            }
        }
    }

    private void matchItemIds(Ll1<View, C1> ll1, Ll1<View, C1> ll2, Lil<View> lil, Lil<View> lil2) {
        View viewM1947lLi1LL;
        int iM1941ILl = lil.m1941ILl();
        for (int i = 0; i < iM1941ILl; i++) {
            View viewLil = lil.Lil(i);
            if (viewLil != null && isValidTarget(viewLil) && (viewM1947lLi1LL = lil2.m1947lLi1LL(lil.m1948il(i))) != null && isValidTarget(viewM1947lLi1LL)) {
                C1 c1 = ll1.get(viewLil);
                C1 c2 = ll2.get(viewM1947lLi1LL);
                if (c1 != null && c2 != null) {
                    this.mStartValuesList.add(c1);
                    this.mEndValuesList.add(c2);
                    ll1.remove(viewLil);
                    ll2.remove(viewM1947lLi1LL);
                }
            }
        }
    }

    private void matchNames(Ll1<View, C1> ll1, Ll1<View, C1> ll2, Ll1<String, View> ll3, Ll1<String, View> ll4) {
        View view;
        int size = ll3.size();
        for (int i = 0; i < size; i++) {
            View viewM1975lIiI = ll3.m1975lIiI(i);
            if (viewM1975lIiI != null && isValidTarget(viewM1975lIiI) && (view = ll4.get(ll3.m1973L11I(i))) != null && isValidTarget(view)) {
                C1 c1 = ll1.get(viewM1975lIiI);
                C1 c2 = ll2.get(view);
                if (c1 != null && c2 != null) {
                    this.mStartValuesList.add(c1);
                    this.mEndValuesList.add(c2);
                    ll1.remove(viewM1975lIiI);
                    ll2.remove(view);
                }
            }
        }
    }

    private void matchStartAndEnd(LlLLL llLLL, LlLLL llLLL2) {
        Ll1<View, C1> ll1 = new Ll1<>(llLLL.f4432IL1Iii);
        Ll1<View, C1> ll2 = new Ll1<>(llLLL2.f4432IL1Iii);
        int i = 0;
        while (true) {
            int[] iArr = this.mMatchOrder;
            if (i >= iArr.length) {
                addUnmatched(ll1, ll2);
                return;
            }
            int i2 = iArr[i];
            if (i2 == 1) {
                matchInstances(ll1, ll2);
            } else if (i2 == 2) {
                matchNames(ll1, ll2, llLLL.f1859IL, llLLL2.f1859IL);
            } else if (i2 == 3) {
                matchIds(ll1, ll2, llLLL.f4433ILil, llLLL2.f4433ILil);
            } else if (i2 == 4) {
                matchItemIds(ll1, ll2, llLLL.f4431I1I, llLLL2.f4431I1I);
            }
            i++;
        }
    }

    private static int[] parseMatchOrder(String str) {
        StringTokenizer stringTokenizer = new StringTokenizer(str, ",");
        int[] iArr = new int[stringTokenizer.countTokens()];
        int i = 0;
        while (stringTokenizer.hasMoreTokens()) {
            String strTrim = stringTokenizer.nextToken().trim();
            if (MATCH_ID_STR.equalsIgnoreCase(strTrim)) {
                iArr[i] = 3;
            } else if (MATCH_INSTANCE_STR.equalsIgnoreCase(strTrim)) {
                iArr[i] = 1;
            } else if (MATCH_NAME_STR.equalsIgnoreCase(strTrim)) {
                iArr[i] = 2;
            } else if (MATCH_ITEM_ID_STR.equalsIgnoreCase(strTrim)) {
                iArr[i] = 4;
            } else {
                if (!strTrim.isEmpty()) {
                    throw new InflateException("Unknown match type in matchOrder: '" + strTrim + "'");
                }
                int[] iArr2 = new int[iArr.length - 1];
                System.arraycopy(iArr, 0, iArr2, 0, i);
                i--;
                iArr = iArr2;
            }
            i++;
        }
        return iArr;
    }

    private void runAnimator(Animator animator, Ll1<Animator, IL> ll1) {
        if (animator != null) {
            animator.addListener(new ILil(ll1));
            animate(animator);
        }
    }

    public Transition addListener(IiL iiL) {
        if (this.mListeners == null) {
            this.mListeners = new ArrayList<>();
        }
        this.mListeners.add(iiL);
        return this;
    }

    public Transition addTarget(View view) {
        this.mTargets.add(view);
        return this;
    }

    public void animate(Animator animator) {
        if (animator == null) {
            end();
            return;
        }
        if (getDuration() >= 0) {
            animator.setDuration(getDuration());
        }
        if (getStartDelay() >= 0) {
            animator.setStartDelay(getStartDelay() + animator.getStartDelay());
        }
        if (getInterpolator() != null) {
            animator.setInterpolator(getInterpolator());
        }
        animator.addListener(new I1I());
        animator.start();
    }

    public void cancel() {
        for (int size = this.mCurrentAnimators.size() - 1; size >= 0; size--) {
            this.mCurrentAnimators.get(size).cancel();
        }
        ArrayList<IiL> arrayList = this.mListeners;
        if (arrayList == null || arrayList.size() <= 0) {
            return;
        }
        ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
        int size2 = arrayList2.size();
        for (int i = 0; i < size2; i++) {
            ((IiL) arrayList2.get(i)).mo2573IL(this);
        }
    }

    public abstract void captureEndValues(C1 c1);

    public void capturePropagationValues(C1 c1) {
        String[] strArrILil;
        if (this.mPropagation == null || c1.f4476IL1Iii.isEmpty() || (strArrILil = this.mPropagation.ILil()) == null) {
            return;
        }
        boolean z = false;
        int i = 0;
        while (true) {
            if (i >= strArrILil.length) {
                z = true;
                break;
            } else if (!c1.f4476IL1Iii.containsKey(strArrILil[i])) {
                break;
            } else {
                i++;
            }
        }
        if (z) {
            return;
        }
        this.mPropagation.IL1Iii(c1);
    }

    public abstract void captureStartValues(C1 c1);

    public void captureValues(ViewGroup viewGroup, boolean z) {
        ArrayList<String> arrayList;
        ArrayList<Class<?>> arrayList2;
        Ll1<String, String> ll1;
        clearValues(z);
        if ((this.mTargetIds.size() > 0 || this.mTargets.size() > 0) && (((arrayList = this.mTargetNames) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetTypes) == null || arrayList2.isEmpty()))) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                View viewFindViewById = viewGroup.findViewById(this.mTargetIds.get(i).intValue());
                if (viewFindViewById != null) {
                    C1 c1 = new C1(viewFindViewById);
                    if (z) {
                        captureStartValues(c1);
                    } else {
                        captureEndValues(c1);
                    }
                    c1.f4475I1I.add(this);
                    capturePropagationValues(c1);
                    if (z) {
                        addViewValues(this.mStartValues, viewFindViewById, c1);
                    } else {
                        addViewValues(this.mEndValues, viewFindViewById, c1);
                    }
                }
            }
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                View view = this.mTargets.get(i2);
                C1 c2 = new C1(view);
                if (z) {
                    captureStartValues(c2);
                } else {
                    captureEndValues(c2);
                }
                c2.f4475I1I.add(this);
                capturePropagationValues(c2);
                if (z) {
                    addViewValues(this.mStartValues, view, c2);
                } else {
                    addViewValues(this.mEndValues, view, c2);
                }
            }
        } else {
            captureHierarchy(viewGroup, z);
        }
        if (z || (ll1 = this.mNameOverrides) == null) {
            return;
        }
        int size = ll1.size();
        ArrayList arrayList3 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            arrayList3.add(this.mStartValues.f1859IL.remove(this.mNameOverrides.m1973L11I(i3)));
        }
        for (int i4 = 0; i4 < size; i4++) {
            View view2 = (View) arrayList3.get(i4);
            if (view2 != null) {
                this.mStartValues.f1859IL.put(this.mNameOverrides.m1975lIiI(i4), view2);
            }
        }
    }

    public void clearValues(boolean z) {
        if (z) {
            this.mStartValues.f4432IL1Iii.clear();
            this.mStartValues.f4433ILil.clear();
            this.mStartValues.f4431I1I.ILil();
        } else {
            this.mEndValues.f4432IL1Iii.clear();
            this.mEndValues.f4433ILil.clear();
            this.mEndValues.f4431I1I.ILil();
        }
    }

    public Animator createAnimator(ViewGroup viewGroup, C1 c1, C1 c2) {
        return null;
    }

    /* JADX WARN: Code duplicated, block: B:15:0x0043  */
    public void createAnimators(ViewGroup viewGroup, LlLLL llLLL, LlLLL llLLL2, ArrayList<C1> arrayList, ArrayList<C1> arrayList2) {
        Animator animatorCreateAnimator;
        int i;
        int i2;
        View view;
        Animator animator;
        C1 c1;
        Animator animator2;
        C1 c2;
        Ll1<Animator, IL> runningAnimators = getRunningAnimators();
        SparseIntArray sparseIntArray = new SparseIntArray();
        int size = arrayList.size();
        long jMin = RecyclerView.FOREVER_NS;
        int i3 = 0;
        while (i3 < size) {
            C1 c3 = arrayList.get(i3);
            C1 c4 = arrayList2.get(i3);
            if (c3 != null && !c3.f4475I1I.contains(this)) {
                c3 = null;
            }
            if (c4 != null && !c4.f4475I1I.contains(this)) {
                c4 = null;
            }
            if (c3 == null && c4 == null) {
                i = size;
                i2 = i3;
            } else if (!(c3 == null || c4 == null || isTransitionRequired(c3, c4)) || (animatorCreateAnimator = createAnimator(viewGroup, c3, c4)) == null) {
                i = size;
                i2 = i3;
            } else {
                if (c4 != null) {
                    view = c4.f4477ILil;
                    String[] transitionProperties = getTransitionProperties();
                    if (transitionProperties != null && transitionProperties.length > 0) {
                        c2 = new C1(view);
                        i = size;
                        C1 c5 = llLLL2.f4432IL1Iii.get(view);
                        if (c5 != null) {
                            int i4 = 0;
                            while (i4 < transitionProperties.length) {
                                c2.f4476IL1Iii.put(transitionProperties[i4], c5.f4476IL1Iii.get(transitionProperties[i4]));
                                i4++;
                                i3 = i3;
                                c5 = c5;
                            }
                        }
                        i2 = i3;
                        int size2 = runningAnimators.size();
                        int i5 = 0;
                        while (true) {
                            if (i5 >= size2) {
                                animator2 = animatorCreateAnimator;
                                break;
                            }
                            IL il = runningAnimators.get(runningAnimators.m1973L11I(i5));
                            if (il.f5188I1I != null && il.f5189IL1Iii == view && il.f5190ILil.equals(getName()) && il.f5188I1I.equals(c2)) {
                                animator2 = null;
                                break;
                            }
                            i5++;
                        }
                    } else {
                        i = size;
                        i2 = i3;
                        animator2 = animatorCreateAnimator;
                        c2 = null;
                    }
                    animator = animator2;
                    c1 = c2;
                } else {
                    i = size;
                    i2 = i3;
                    view = c3.f4477ILil;
                    animator = animatorCreateAnimator;
                    c1 = null;
                }
                if (animator != null) {
                    llliI lllii = this.mPropagation;
                    if (lllii != null) {
                        long jI1I = lllii.I1I(viewGroup, this, c3, c4);
                        sparseIntArray.put(this.mAnimators.size(), (int) jI1I);
                        jMin = Math.min(jI1I, jMin);
                    }
                    runningAnimators.put(animator, new IL(view, getName(), this, IIi.m2553IL(viewGroup), c1));
                    this.mAnimators.add(animator);
                    jMin = jMin;
                }
            }
            i3 = i2 + 1;
            size = i;
        }
        if (sparseIntArray.size() != 0) {
            for (int i6 = 0; i6 < sparseIntArray.size(); i6++) {
                Animator animator3 = this.mAnimators.get(sparseIntArray.keyAt(i6));
                animator3.setStartDelay((((long) sparseIntArray.valueAt(i6)) - jMin) + animator3.getStartDelay());
            }
        }
    }

    public void end() {
        int i = this.mNumInstances - 1;
        this.mNumInstances = i;
        if (i == 0) {
            ArrayList<IiL> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i2 = 0; i2 < size; i2++) {
                    ((IiL) arrayList2.get(i2)).I1I(this);
                }
            }
            for (int i3 = 0; i3 < this.mStartValues.f4431I1I.m1941ILl(); i3++) {
                View viewLil = this.mStartValues.f4431I1I.Lil(i3);
                if (viewLil != null) {
                    iIlLiL.Liil1L1l(viewLil, false);
                }
            }
            for (int i4 = 0; i4 < this.mEndValues.f4431I1I.m1941ILl(); i4++) {
                View viewLil2 = this.mEndValues.f4431I1I.Lil(i4);
                if (viewLil2 != null) {
                    iIlLiL.Liil1L1l(viewLil2, false);
                }
            }
            this.mEnded = true;
        }
    }

    public Transition excludeChildren(View view, boolean z) {
        this.mTargetChildExcludes = excludeView(this.mTargetChildExcludes, view, z);
        return this;
    }

    public Transition excludeTarget(View view, boolean z) {
        this.mTargetExcludes = excludeView(this.mTargetExcludes, view, z);
        return this;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public void forceToEnd(ViewGroup viewGroup) {
        Ll1<Animator, IL> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        if (viewGroup == null || size == 0) {
            return;
        }
        I1L11L i1l11lM2553IL = IIi.m2553IL(viewGroup);
        Ll1 ll1 = new Ll1(runningAnimators);
        runningAnimators.clear();
        for (int i = size - 1; i >= 0; i--) {
            IL il = (IL) ll1.m1975lIiI(i);
            if (il.f5189IL1Iii != null && i1l11lM2553IL != null && i1l11lM2553IL.equals(il.f2775IL)) {
                ((Animator) ll1.m1973L11I(i)).end();
            }
        }
    }

    public long getDuration() {
        return this.mDuration;
    }

    public Rect getEpicenter() {
        iILLL1 iilll1 = this.mEpicenterCallback;
        if (iilll1 == null) {
            return null;
        }
        return iilll1.IL1Iii(this);
    }

    public iILLL1 getEpicenterCallback() {
        return this.mEpicenterCallback;
    }

    public TimeInterpolator getInterpolator() {
        return this.mInterpolator;
    }

    public C1 getMatchedTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getMatchedTransitionValues(view, z);
        }
        ArrayList<C1> arrayList = z ? this.mStartValuesList : this.mEndValuesList;
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        int i = -1;
        for (int i2 = 0; i2 < size; i2++) {
            C1 c1 = arrayList.get(i2);
            if (c1 == null) {
                return null;
            }
            if (c1.f4477ILil == view) {
                i = i2;
                break;
            }
        }
        if (i >= 0) {
            return (z ? this.mEndValuesList : this.mStartValuesList).get(i);
        }
        return null;
    }

    public String getName() {
        return this.mName;
    }

    public PathMotion getPathMotion() {
        return this.mPathMotion;
    }

    public llliI getPropagation() {
        return this.mPropagation;
    }

    public long getStartDelay() {
        return this.mStartDelay;
    }

    public List<Integer> getTargetIds() {
        return this.mTargetIds;
    }

    public List<String> getTargetNames() {
        return this.mTargetNames;
    }

    public List<Class<?>> getTargetTypes() {
        return this.mTargetTypes;
    }

    public List<View> getTargets() {
        return this.mTargets;
    }

    public String[] getTransitionProperties() {
        return null;
    }

    public C1 getTransitionValues(View view, boolean z) {
        TransitionSet transitionSet = this.mParent;
        if (transitionSet != null) {
            return transitionSet.getTransitionValues(view, z);
        }
        return (z ? this.mStartValues : this.mEndValues).f4432IL1Iii.get(view);
    }

    public boolean isTransitionRequired(C1 c1, C1 c2) {
        if (c1 == null || c2 == null) {
            return false;
        }
        String[] transitionProperties = getTransitionProperties();
        if (transitionProperties == null) {
            Iterator<String> it = c1.f4476IL1Iii.keySet().iterator();
            while (it.hasNext()) {
                if (isValueChanged(c1, c2, it.next())) {
                }
            }
            return false;
        }
        for (String str : transitionProperties) {
            if (!isValueChanged(c1, c2, str)) {
            }
        }
        return false;
        return true;
    }

    public boolean isValidTarget(View view) {
        ArrayList<Class<?>> arrayList;
        ArrayList<String> arrayList2;
        int id = view.getId();
        ArrayList<Integer> arrayList3 = this.mTargetIdExcludes;
        if (arrayList3 != null && arrayList3.contains(Integer.valueOf(id))) {
            return false;
        }
        ArrayList<View> arrayList4 = this.mTargetExcludes;
        if (arrayList4 != null && arrayList4.contains(view)) {
            return false;
        }
        ArrayList<Class<?>> arrayList5 = this.mTargetTypeExcludes;
        if (arrayList5 != null) {
            int size = arrayList5.size();
            for (int i = 0; i < size; i++) {
                if (this.mTargetTypeExcludes.get(i).isInstance(view)) {
                    return false;
                }
            }
        }
        if (this.mTargetNameExcludes != null && iIlLiL.llI(view) != null && this.mTargetNameExcludes.contains(iIlLiL.llI(view))) {
            return false;
        }
        if ((this.mTargetIds.size() == 0 && this.mTargets.size() == 0 && (((arrayList = this.mTargetTypes) == null || arrayList.isEmpty()) && ((arrayList2 = this.mTargetNames) == null || arrayList2.isEmpty()))) || this.mTargetIds.contains(Integer.valueOf(id)) || this.mTargets.contains(view)) {
            return true;
        }
        ArrayList<String> arrayList6 = this.mTargetNames;
        if (arrayList6 != null && arrayList6.contains(iIlLiL.llI(view))) {
            return true;
        }
        if (this.mTargetTypes != null) {
            for (int i2 = 0; i2 < this.mTargetTypes.size(); i2++) {
                if (this.mTargetTypes.get(i2).isInstance(view)) {
                    return true;
                }
            }
        }
        return false;
    }

    public void pause(View view) {
        if (this.mEnded) {
            return;
        }
        Ll1<Animator, IL> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        I1L11L i1l11lM2553IL = IIi.m2553IL(view);
        for (int i = size - 1; i >= 0; i--) {
            IL ilM1975lIiI = runningAnimators.m1975lIiI(i);
            if (ilM1975lIiI.f5189IL1Iii != null && i1l11lM2553IL.equals(ilM1975lIiI.f2775IL)) {
                ILil.p044llL1ii.IL1Iii.ILil(runningAnimators.m1973L11I(i));
            }
        }
        ArrayList<IiL> arrayList = this.mListeners;
        if (arrayList != null && arrayList.size() > 0) {
            ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
            int size2 = arrayList2.size();
            for (int i2 = 0; i2 < size2; i2++) {
                ((IiL) arrayList2.get(i2)).ILil(this);
            }
        }
        this.mPaused = true;
    }

    public void playTransition(ViewGroup viewGroup) {
        IL il;
        this.mStartValuesList = new ArrayList<>();
        this.mEndValuesList = new ArrayList<>();
        matchStartAndEnd(this.mStartValues, this.mEndValues);
        Ll1<Animator, IL> runningAnimators = getRunningAnimators();
        int size = runningAnimators.size();
        I1L11L i1l11lM2553IL = IIi.m2553IL(viewGroup);
        for (int i = size - 1; i >= 0; i--) {
            Animator animatorM1973L11I = runningAnimators.m1973L11I(i);
            if (animatorM1973L11I != null && (il = runningAnimators.get(animatorM1973L11I)) != null && il.f5189IL1Iii != null && i1l11lM2553IL.equals(il.f2775IL)) {
                C1 c1 = il.f5188I1I;
                View view = il.f5189IL1Iii;
                C1 transitionValues = getTransitionValues(view, true);
                C1 matchedTransitionValues = getMatchedTransitionValues(view, true);
                if (transitionValues == null && matchedTransitionValues == null) {
                    matchedTransitionValues = this.mEndValues.f4432IL1Iii.get(view);
                }
                if (!(transitionValues == null && matchedTransitionValues == null) && il.f5191Ilil.isTransitionRequired(c1, matchedTransitionValues)) {
                    if (animatorM1973L11I.isRunning() || animatorM1973L11I.isStarted()) {
                        animatorM1973L11I.cancel();
                    } else {
                        runningAnimators.remove(animatorM1973L11I);
                    }
                }
            }
        }
        createAnimators(viewGroup, this.mStartValues, this.mEndValues, this.mStartValuesList, this.mEndValuesList);
        runAnimators();
    }

    public Transition removeListener(IiL iiL) {
        ArrayList<IiL> arrayList = this.mListeners;
        if (arrayList == null) {
            return this;
        }
        arrayList.remove(iiL);
        if (this.mListeners.size() == 0) {
            this.mListeners = null;
        }
        return this;
    }

    public Transition removeTarget(View view) {
        this.mTargets.remove(view);
        return this;
    }

    public void resume(View view) {
        if (this.mPaused) {
            if (!this.mEnded) {
                Ll1<Animator, IL> runningAnimators = getRunningAnimators();
                int size = runningAnimators.size();
                I1L11L i1l11lM2553IL = IIi.m2553IL(view);
                for (int i = size - 1; i >= 0; i--) {
                    IL ilM1975lIiI = runningAnimators.m1975lIiI(i);
                    if (ilM1975lIiI.f5189IL1Iii != null && i1l11lM2553IL.equals(ilM1975lIiI.f2775IL)) {
                        ILil.p044llL1ii.IL1Iii.I1I(runningAnimators.m1973L11I(i));
                    }
                }
                ArrayList<IiL> arrayList = this.mListeners;
                if (arrayList != null && arrayList.size() > 0) {
                    ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                    int size2 = arrayList2.size();
                    for (int i2 = 0; i2 < size2; i2++) {
                        ((IiL) arrayList2.get(i2)).Ilil(this);
                    }
                }
            }
            this.mPaused = false;
        }
    }

    public void runAnimators() {
        start();
        Ll1<Animator, IL> runningAnimators = getRunningAnimators();
        for (Animator animator : this.mAnimators) {
            if (runningAnimators.containsKey(animator)) {
                start();
                runAnimator(animator, runningAnimators);
            }
        }
        this.mAnimators.clear();
        end();
    }

    public void setCanRemoveViews(boolean z) {
        this.mCanRemoveViews = z;
    }

    public Transition setDuration(long j) {
        this.mDuration = j;
        return this;
    }

    public void setEpicenterCallback(iILLL1 iilll1) {
        this.mEpicenterCallback = iilll1;
    }

    public Transition setInterpolator(TimeInterpolator timeInterpolator) {
        this.mInterpolator = timeInterpolator;
        return this;
    }

    public void setMatchOrder(int... iArr) {
        if (iArr == null || iArr.length == 0) {
            this.mMatchOrder = DEFAULT_MATCH_ORDER;
            return;
        }
        for (int i = 0; i < iArr.length; i++) {
            if (!isValidMatch(iArr[i])) {
                throw new IllegalArgumentException("matches contains invalid value");
            }
            if (alreadyContains(iArr, i)) {
                throw new IllegalArgumentException("matches contains a duplicate value");
            }
        }
        this.mMatchOrder = (int[]) iArr.clone();
    }

    public void setPathMotion(PathMotion pathMotion) {
        if (pathMotion == null) {
            this.mPathMotion = STRAIGHT_PATH_MOTION;
        } else {
            this.mPathMotion = pathMotion;
        }
    }

    public void setPropagation(llliI lllii) {
        this.mPropagation = lllii;
    }

    public Transition setSceneRoot(ViewGroup viewGroup) {
        this.mSceneRoot = viewGroup;
        return this;
    }

    public Transition setStartDelay(long j) {
        this.mStartDelay = j;
        return this;
    }

    public void start() {
        if (this.mNumInstances == 0) {
            ArrayList<IiL> arrayList = this.mListeners;
            if (arrayList != null && arrayList.size() > 0) {
                ArrayList arrayList2 = (ArrayList) this.mListeners.clone();
                int size = arrayList2.size();
                for (int i = 0; i < size; i++) {
                    ((IiL) arrayList2.get(i)).IL1Iii(this);
                }
            }
            this.mEnded = false;
        }
        this.mNumInstances++;
    }

    public String toString() {
        return toString(BuildConfig.FLAVOR);
    }

    public Transition addTarget(int i) {
        if (i != 0) {
            this.mTargetIds.add(Integer.valueOf(i));
        }
        return this;
    }

    @Override // 
    /* JADX INFO: renamed from: clone, reason: merged with bridge method [inline-methods] */
    public Transition mo3370clone() {
        try {
            Transition transition = (Transition) super.clone();
            transition.mAnimators = new ArrayList<>();
            transition.mStartValues = new LlLLL();
            transition.mEndValues = new LlLLL();
            transition.mStartValuesList = null;
            transition.mEndValuesList = null;
            return transition;
        } catch (CloneNotSupportedException unused) {
            return null;
        }
    }

    public Transition excludeChildren(int i, boolean z) {
        this.mTargetIdChildExcludes = excludeId(this.mTargetIdChildExcludes, i, z);
        return this;
    }

    public Transition excludeTarget(int i, boolean z) {
        this.mTargetIdExcludes = excludeId(this.mTargetIdExcludes, i, z);
        return this;
    }

    public Transition removeTarget(int i) {
        if (i != 0) {
            this.mTargetIds.remove(Integer.valueOf(i));
        }
        return this;
    }

    public String toString(String str) {
        String str2 = str + getClass().getSimpleName() + "@" + Integer.toHexString(hashCode()) + ": ";
        if (this.mDuration != -1) {
            str2 = str2 + "dur(" + this.mDuration + ") ";
        }
        if (this.mStartDelay != -1) {
            str2 = str2 + "dly(" + this.mStartDelay + ") ";
        }
        if (this.mInterpolator != null) {
            str2 = str2 + "interp(" + this.mInterpolator + ") ";
        }
        if (this.mTargetIds.size() <= 0 && this.mTargets.size() <= 0) {
            return str2;
        }
        String str3 = str2 + "tgts(";
        if (this.mTargetIds.size() > 0) {
            for (int i = 0; i < this.mTargetIds.size(); i++) {
                if (i > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargetIds.get(i);
            }
        }
        if (this.mTargets.size() > 0) {
            for (int i2 = 0; i2 < this.mTargets.size(); i2++) {
                if (i2 > 0) {
                    str3 = str3 + ", ";
                }
                str3 = str3 + this.mTargets.get(i2);
            }
        }
        return str3 + ")";
    }

    public Transition addTarget(String str) {
        if (this.mTargetNames == null) {
            this.mTargetNames = new ArrayList<>();
        }
        this.mTargetNames.add(str);
        return this;
    }

    public Transition excludeChildren(Class<?> cls, boolean z) {
        this.mTargetTypeChildExcludes = excludeType(this.mTargetTypeChildExcludes, cls, z);
        return this;
    }

    public Transition excludeTarget(String str, boolean z) {
        this.mTargetNameExcludes = excludeObject(this.mTargetNameExcludes, str, z);
        return this;
    }

    public Transition removeTarget(String str) {
        ArrayList<String> arrayList = this.mTargetNames;
        if (arrayList != null) {
            arrayList.remove(str);
        }
        return this;
    }

    public Transition excludeTarget(Class<?> cls, boolean z) {
        this.mTargetTypeExcludes = excludeType(this.mTargetTypeExcludes, cls, z);
        return this;
    }

    public Transition removeTarget(Class<?> cls) {
        ArrayList<Class<?>> arrayList = this.mTargetTypes;
        if (arrayList != null) {
            arrayList.remove(cls);
        }
        return this;
    }

    public Transition addTarget(Class<?> cls) {
        if (this.mTargetTypes == null) {
            this.mTargetTypes = new ArrayList<>();
        }
        this.mTargetTypes.add(cls);
        return this;
    }

    @SuppressLint({"RestrictedApi"})
    public Transition(Context context, AttributeSet attributeSet) {
        TypedArray typedArrayObtainStyledAttributes = context.obtainStyledAttributes(attributeSet, I11li1.f4401IL1Iii);
        XmlResourceParser xmlResourceParser = (XmlResourceParser) attributeSet;
        long jM2316iILLL1 = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArrayObtainStyledAttributes, xmlResourceParser, "duration", 1, -1);
        if (jM2316iILLL1 >= 0) {
            setDuration(jM2316iILLL1);
        }
        long jM2316iILLL2 = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2316iILLL1(typedArrayObtainStyledAttributes, xmlResourceParser, "startDelay", 2, -1);
        if (jM2316iILLL2 > 0) {
            setStartDelay(jM2316iILLL2);
        }
        int iM2313IiL = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2313IiL(typedArrayObtainStyledAttributes, xmlResourceParser, "interpolator", 0, 0);
        if (iM2313IiL > 0) {
            setInterpolator(AnimationUtils.loadInterpolator(context, iM2313IiL));
        }
        String strM2315L11I = ILil.p028IiL.p035lLi1LL.I1I.IiL.m2315L11I(typedArrayObtainStyledAttributes, xmlResourceParser, "matchOrder", 3);
        if (strM2315L11I != null) {
            setMatchOrder(parseMatchOrder(strM2315L11I));
        }
        typedArrayObtainStyledAttributes.recycle();
    }
}
