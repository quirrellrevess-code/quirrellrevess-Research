package p051lLi1LL.ILil.IL1Iii;

import java.lang.annotation.Documented;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import org.greenrobot.eventbus.ThreadMode;

/* JADX INFO: renamed from: l丨Li1LL.ILil.IL1Iii.IL丨丨l, reason: invalid class name and case insensitive filesystem */
/* JADX INFO: compiled from: Subscribe.java */
/* JADX INFO: loaded from: classes.dex */
@Target({ElementType.METHOD})
@Documented
@Retention(RetentionPolicy.RUNTIME)
public @interface InterfaceC0678ILl {
    int priority() default 0;

    boolean sticky() default false;

    ThreadMode threadMode() default ThreadMode.POSTING;
}
