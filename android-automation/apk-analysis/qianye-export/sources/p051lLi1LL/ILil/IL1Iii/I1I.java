package p051lLi1LL.ILil.IL1Iii;

import java.lang.reflect.InvocationTargetException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.ExecutorService;
import java.util.logging.Level;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: compiled from: EventBus.java */
/* JADX INFO: loaded from: classes.dex */
public class I1I {
    public static volatile I1I iIi1;

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public final Map<Class<?>, Object> f5540I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Map<Class<?>, CopyOnWriteArrayList<lIlii>> f5541IL1Iii;
    public final boolean ILL;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final Map<Object, List<Class<?>>> f5542ILil;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final boolean f3034ILl;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final L11I f5543Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final ThreadLocal<C0598I1I> f3035IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public final p051lLi1LL.ILil.IL1Iii.IL1Iii f3036IiL;
    public final boolean Lil;
    public final boolean LlLI1;

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final boolean f3037Ll1;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final llL1ii f3038L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public final p051lLi1LL.ILil.IL1Iii.ILil f3039iILLL1;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final boolean f3040lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final IiL f3041lIlii;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final int f3042llL1ii;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final lIiI f3043lLi1LL;

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public final ExecutorService f3044il;
    public static final IL iIlLiL = new IL();
    public static final Map<Class<?>, List<Class<?>>> I11li1 = new HashMap();

    /* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.I1I$I1I, reason: collision with other inner class name */
    /* JADX INFO: compiled from: EventBus.java */
    public static final class C0598I1I {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public boolean f5544I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final List<Object> f5545IL1Iii = new ArrayList();

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public boolean f5546ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public Object f5547Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public lIlii f3045IL;

        /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
        public boolean f3046lLi1LL;
    }

    /* JADX INFO: compiled from: EventBus.java */
    public class IL1Iii extends ThreadLocal<C0598I1I> {
        public IL1Iii(I1I i1i) {
        }

        @Override // java.lang.ThreadLocal
        /* JADX INFO: renamed from: IL1Iii, reason: merged with bridge method [inline-methods] */
        public C0598I1I initialValue() {
            return new C0598I1I();
        }
    }

    /* JADX INFO: compiled from: EventBus.java */
    public static /* synthetic */ class ILil {

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public static final /* synthetic */ int[] f5548IL1Iii;

        static {
            int[] iArr = new int[ThreadMode.values().length];
            f5548IL1Iii = iArr;
            try {
                iArr[ThreadMode.POSTING.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                f5548IL1Iii[ThreadMode.MAIN.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                f5548IL1Iii[ThreadMode.MAIN_ORDERED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                f5548IL1Iii[ThreadMode.BACKGROUND.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                f5548IL1Iii[ThreadMode.ASYNC.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public I1I() {
        this(iIlLiL);
    }

    public static I1I I1I() {
        I1I i1i = iIi1;
        if (i1i == null) {
            synchronized (I1I.class) {
                i1i = iIi1;
                if (i1i == null) {
                    i1i = new I1I();
                    iIi1 = i1i;
                }
            }
        }
        return i1i;
    }

    public static void IL1Iii(List<Class<?>> list, Class<?>[] clsArr) {
        for (Class<?> cls : clsArr) {
            if (!list.contains(cls)) {
                list.add(cls);
                IL1Iii(list, cls.getInterfaces());
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public static List<Class<?>> m3661il(Class<?> cls) {
        List<Class<?>> arrayList;
        Map<Class<?>, List<Class<?>>> map = I11li1;
        synchronized (map) {
            arrayList = map.get(cls);
            if (arrayList == null) {
                arrayList = new ArrayList<>();
                for (Class<?> superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
                    arrayList.add(superclass);
                    IL1Iii(arrayList, superclass.getInterfaces());
                }
                I11li1.put(cls, arrayList);
            }
        }
        return arrayList;
    }

    public void ILL(Object obj) {
        C0598I1I c0598i1i = this.f3035IL.get();
        List<Object> list = c0598i1i.f5545IL1Iii;
        list.add(obj);
        if (c0598i1i.f5546ILil) {
            return;
        }
        c0598i1i.f5544I1I = m3666L11I();
        c0598i1i.f5546ILil = true;
        if (c0598i1i.f3046lLi1LL) {
            throw new lLi1LL("Internal error. Abort state was not reset");
        }
        while (!list.isEmpty()) {
            try {
                m3665Ll1(list.remove(0), c0598i1i);
            } catch (Throwable th) {
                c0598i1i.f5546ILil = false;
                c0598i1i.f5544I1I = false;
                throw th;
            }
        }
        c0598i1i.f5546ILil = false;
        c0598i1i.f5544I1I = false;
    }

    public final void ILil(lIlii lilii, Object obj) {
        if (obj != null) {
            m3662ILl(lilii, obj, m3666L11I());
        }
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final void m3662ILl(lIlii lilii, Object obj, boolean z) {
        int i = ILil.f5548IL1Iii[lilii.f5577ILil.f5565ILil.ordinal()];
        if (i == 1) {
            m3664IiL(lilii, obj);
            return;
        }
        if (i == 2) {
            if (z) {
                m3664IiL(lilii, obj);
                return;
            } else {
                this.f3043lLi1LL.IL1Iii(lilii, obj);
                return;
            }
        }
        if (i == 3) {
            lIiI liii = this.f3043lLi1LL;
            if (liii != null) {
                liii.IL1Iii(lilii, obj);
                return;
            } else {
                m3664IiL(lilii, obj);
                return;
            }
        }
        if (i == 4) {
            if (z) {
                this.f3039iILLL1.IL1Iii(lilii, obj);
                return;
            } else {
                m3664IiL(lilii, obj);
                return;
            }
        }
        if (i == 5) {
            this.f3036IiL.IL1Iii(lilii, obj);
            return;
        }
        throw new IllegalStateException("Unknown thread mode: " + lilii.f5577ILil.f5565ILil);
    }

    public IiL Ilil() {
        return this.f3041lIlii;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public ExecutorService m3663IL() {
        return this.f3044il;
    }

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public void m3664IiL(lIlii lilii, Object obj) {
        try {
            lilii.f5577ILil.f5564IL1Iii.invoke(lilii.f5576IL1Iii, obj);
        } catch (IllegalAccessException e) {
            throw new IllegalStateException("Unexpected exception", e);
        } catch (InvocationTargetException e2) {
            m3671lLi1LL(lilii, obj, e2.getCause());
        }
    }

    public void Lil(Object obj) {
        List<LlLI1> listIL1Iii = this.f3038L11I.IL1Iii(obj.getClass());
        synchronized (this) {
            Iterator<LlLI1> it = listIL1Iii.iterator();
            while (it.hasNext()) {
                LlLI1(obj, it.next());
            }
        }
    }

    public final void LlLI1(Object obj, LlLI1 llLI1) {
        Class<?> cls = llLI1.f5563I1I;
        lIlii lilii = new lIlii(obj, llLI1);
        CopyOnWriteArrayList<lIlii> copyOnWriteArrayList = this.f5541IL1Iii.get(cls);
        if (copyOnWriteArrayList == null) {
            copyOnWriteArrayList = new CopyOnWriteArrayList<>();
            this.f5541IL1Iii.put(cls, copyOnWriteArrayList);
        } else if (copyOnWriteArrayList.contains(lilii)) {
            throw new lLi1LL("Subscriber " + obj.getClass() + " already registered to event " + cls);
        }
        int size = copyOnWriteArrayList.size();
        for (int i = 0; i <= size; i++) {
            if (i == size || llLI1.f3057IL > copyOnWriteArrayList.get(i).f5577ILil.f3057IL) {
                copyOnWriteArrayList.add(i, lilii);
                break;
            }
        }
        List<Class<?>> arrayList = this.f5542ILil.get(obj);
        if (arrayList == null) {
            arrayList = new ArrayList<>();
            this.f5542ILil.put(obj, arrayList);
        }
        arrayList.add(cls);
        if (llLI1.f5566Ilil) {
            if (!this.LlLI1) {
                ILil(lilii, this.f5540I1I.get(cls));
                return;
            }
            for (Map.Entry<Class<?>, Object> entry : this.f5540I1I.entrySet()) {
                if (cls.isAssignableFrom(entry.getKey())) {
                    ILil(lilii, entry.getValue());
                }
            }
        }
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final void m3665Ll1(Object obj, C0598I1I c0598i1i) throws Error {
        boolean zM3668lIiI;
        Class<?> cls = obj.getClass();
        if (this.LlLI1) {
            List<Class<?>> listM3661il = m3661il(cls);
            int size = listM3661il.size();
            zM3668lIiI = false;
            for (int i = 0; i < size; i++) {
                zM3668lIiI |= m3668lIiI(obj, c0598i1i, listM3661il.get(i));
            }
        } else {
            zM3668lIiI = m3668lIiI(obj, c0598i1i, cls);
        }
        if (zM3668lIiI) {
            return;
        }
        if (this.f3040lIiI) {
            this.f3041lIlii.IL1Iii(Level.FINE, "No subscribers registered for event " + cls);
        }
        if (!this.Lil || cls == C0679il.class || cls == Lil.class) {
            return;
        }
        ILL(new C0679il(this, obj));
    }

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public final boolean m3666L11I() {
        L11I l11i = this.f5543Ilil;
        return l11i == null || l11i.ILil();
    }

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public void m3667iILLL1(ILL ill) {
        Object obj = ill.f5552IL1Iii;
        lIlii lilii = ill.f5553ILil;
        ILL.ILil(ill);
        if (lilii.f5575I1I) {
            m3664IiL(lilii, obj);
        }
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final boolean m3668lIiI(Object obj, C0598I1I c0598i1i, Class<?> cls) {
        CopyOnWriteArrayList<lIlii> copyOnWriteArrayList;
        synchronized (this) {
            copyOnWriteArrayList = this.f5541IL1Iii.get(cls);
        }
        if (copyOnWriteArrayList == null || copyOnWriteArrayList.isEmpty()) {
            return false;
        }
        for (lIlii lilii : copyOnWriteArrayList) {
            c0598i1i.f5547Ilil = obj;
            c0598i1i.f3045IL = lilii;
            try {
                m3662ILl(lilii, obj, c0598i1i.f5544I1I);
                boolean z = c0598i1i.f3046lLi1LL;
                c0598i1i.f5547Ilil = null;
                c0598i1i.f3045IL = null;
                c0598i1i.f3046lLi1LL = false;
                if (z) {
                    return true;
                }
            } catch (Throwable th) {
                c0598i1i.f5547Ilil = null;
                c0598i1i.f3045IL = null;
                c0598i1i.f3046lLi1LL = false;
                throw th;
            }
        }
        return true;
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public final void m3669lIlii(Object obj, Class<?> cls) {
        CopyOnWriteArrayList<lIlii> copyOnWriteArrayList = this.f5541IL1Iii.get(cls);
        if (copyOnWriteArrayList != null) {
            int size = copyOnWriteArrayList.size();
            int i = 0;
            while (i < size) {
                lIlii lilii = copyOnWriteArrayList.get(i);
                if (lilii.f5576IL1Iii == obj) {
                    lilii.f5575I1I = false;
                    copyOnWriteArrayList.remove(i);
                    i--;
                    size--;
                }
                i++;
            }
        }
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public synchronized void m3670llL1ii(Object obj) {
        List<Class<?>> list = this.f5542ILil.get(obj);
        if (list != null) {
            Iterator<Class<?>> it = list.iterator();
            while (it.hasNext()) {
                m3669lIlii(obj, it.next());
            }
            this.f5542ILil.remove(obj);
        } else {
            this.f3041lIlii.IL1Iii(Level.WARNING, "Subscriber to unregister was not registered before: " + obj.getClass());
        }
    }

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final void m3671lLi1LL(lIlii lilii, Object obj, Throwable th) {
        if (!(obj instanceof Lil)) {
            if (this.ILL) {
                throw new lLi1LL("Invoking subscriber failed", th);
            }
            if (this.f3037Ll1) {
                this.f3041lIlii.ILil(Level.SEVERE, "Could not dispatch event: " + obj.getClass() + " to subscribing class " + lilii.f5576IL1Iii.getClass(), th);
            }
            if (this.f3034ILl) {
                ILL(new Lil(this, th, obj, lilii.f5576IL1Iii));
                return;
            }
            return;
        }
        if (this.f3037Ll1) {
            IiL iiL = this.f3041lIlii;
            Level level = Level.SEVERE;
            iiL.ILil(level, "SubscriberExceptionEvent subscriber " + lilii.f5576IL1Iii.getClass() + " threw an exception", th);
            Lil lil = (Lil) obj;
            this.f3041lIlii.ILil(level, "Initial event " + lil.f5562ILil + " caused exception in " + lil.f5560I1I, lil.f5561IL1Iii);
        }
    }

    public String toString() {
        return "EventBus[indexCount=" + this.f3042llL1ii + ", eventInheritance=" + this.LlLI1 + "]";
    }

    public I1I(IL il) {
        this.f3035IL = new IL1Iii(this);
        this.f3041lIlii = il.ILil();
        this.f5541IL1Iii = new HashMap();
        this.f5542ILil = new HashMap();
        this.f5540I1I = new ConcurrentHashMap();
        L11I l11iI1I = il.I1I();
        this.f5543Ilil = l11iI1I;
        this.f3043lLi1LL = l11iI1I != null ? l11iI1I.IL1Iii(this) : null;
        this.f3039iILLL1 = new p051lLi1LL.ILil.IL1Iii.ILil(this);
        this.f3036IiL = new p051lLi1LL.ILil.IL1Iii.IL1Iii(this);
        List<p051lLi1LL.ILil.IL1Iii.iIlLiL.ILil> list = il.f3056il;
        this.f3042llL1ii = list != null ? list.size() : 0;
        this.f3038L11I = new llL1ii(il.f3056il, il.f3051IiL, il.f3054iILLL1);
        this.f3037Ll1 = il.f5557IL1Iii;
        this.f3040lIiI = il.f5558ILil;
        this.f3034ILl = il.f5556I1I;
        this.Lil = il.f3050IL;
        this.ILL = il.f5559Ilil;
        this.LlLI1 = il.f3055lLi1LL;
        this.f3044il = il.f3053L11I;
    }
}
