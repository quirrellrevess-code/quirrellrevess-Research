package ILil.p044llL1ii;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.os.Build;
import java.util.ArrayList;

/* JADX INFO: compiled from: AnimatorUtils.java */
/* JADX INFO: loaded from: classes.dex */
public class IL1Iii {

    /* JADX INFO: renamed from: ILil.ll丨L1ii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: AnimatorUtils.java */
    public interface InterfaceC0584IL1Iii {
        void onAnimationPause(Animator animator);

        void onAnimationResume(Animator animator);
    }

    public static void I1I(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.resume();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0584IL1Iii) {
                    ((InterfaceC0584IL1Iii) animatorListener).onAnimationResume(animator);
                }
            }
        }
    }

    public static void IL1Iii(Animator animator, AnimatorListenerAdapter animatorListenerAdapter) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.addPauseListener(animatorListenerAdapter);
        }
    }

    public static void ILil(Animator animator) {
        if (Build.VERSION.SDK_INT >= 19) {
            animator.pause();
            return;
        }
        ArrayList<Animator.AnimatorListener> listeners = animator.getListeners();
        if (listeners != null) {
            int size = listeners.size();
            for (int i = 0; i < size; i++) {
                Animator.AnimatorListener animatorListener = listeners.get(i);
                if (animatorListener instanceof InterfaceC0584IL1Iii) {
                    ((InterfaceC0584IL1Iii) animatorListener).onAnimationPause(animator);
                }
            }
        }
    }
}
