package ILil.p042lIiI;

/* JADX INFO: renamed from: ILil.lIi丨I.ll丨L1ii, reason: invalid class name */
/* JADX INFO: compiled from: ViewModelProvider.java */
/* JADX INFO: loaded from: classes.dex */
public class llL1ii {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final IL1Iii f4355IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final lIlii f4356ILil;

    /* JADX INFO: renamed from: ILil.lIi丨I.ll丨L1ii$IL1Iii */
    /* JADX INFO: compiled from: ViewModelProvider.java */
    public interface IL1Iii {
        <T extends LlLI1> T IL1Iii(Class<T> cls);
    }

    /* JADX INFO: renamed from: ILil.lIi丨I.ll丨L1ii$ILil */
    /* JADX INFO: compiled from: ViewModelProvider.java */
    public static abstract class ILil implements IL1Iii {
        @Override // ILil.p042lIiI.llL1ii.IL1Iii
        public <T extends LlLI1> T IL1Iii(Class<T> cls) {
            throw new UnsupportedOperationException("create(String, Class<?>) must be called on implementaions of KeyedFactory");
        }

        public abstract <T extends LlLI1> T ILil(String str, Class<T> cls);
    }

    public llL1ii(lIlii lilii, IL1Iii iL1Iii) {
        this.f4355IL1Iii = iL1Iii;
        this.f4356ILil = lilii;
    }

    public <T extends LlLI1> T IL1Iii(Class<T> cls) {
        String canonicalName = cls.getCanonicalName();
        if (canonicalName == null) {
            throw new IllegalArgumentException("Local and anonymous classes can not be ViewModels");
        }
        return (T) ILil("androidx.lifecycle.ViewModelProvider.DefaultKey:" + canonicalName, cls);
    }

    /* JADX WARN: Type inference fix 'apply assigned field type' failed
    java.lang.UnsupportedOperationException: ArgType.getObject(), call class: class jadx.core.dex.instructions.args.ArgType$UnknownArg
    	at jadx.core.dex.instructions.args.ArgType.getObject(ArgType.java:596)
    	at jadx.core.dex.attributes.nodes.ClassTypeVarsAttr.getTypeVarsMapFor(ClassTypeVarsAttr.java:35)
    	at jadx.core.dex.nodes.utils.TypeUtils.replaceClassGenerics(TypeUtils.java:177)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.insertExplicitUseCast(FixTypesVisitor.java:397)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.tryFieldTypeWithNewCasts(FixTypesVisitor.java:359)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.applyFieldType(FixTypesVisitor.java:309)
    	at jadx.core.dex.visitors.typeinference.FixTypesVisitor.visit(FixTypesVisitor.java:94)
     */
    public <T extends LlLI1> T ILil(String str, Class<T> cls) {
        T t = (T) this.f4356ILil.ILil(str);
        if (cls.isInstance(t)) {
            return t;
        }
        IL1Iii iL1Iii = this.f4355IL1Iii;
        T t2 = iL1Iii instanceof ILil ? (T) ((ILil) iL1Iii).ILil(str, cls) : (T) iL1Iii.IL1Iii(cls);
        this.f4356ILil.I1I(str, t2);
        return t2;
    }
}
