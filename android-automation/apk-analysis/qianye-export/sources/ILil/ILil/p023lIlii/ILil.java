package ILil.ILil.p023lIlii;

import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Outline;
import android.graphics.drawable.Drawable;
import androidx.appcompat.widget.ActionBarContainer;

/* JADX INFO: compiled from: ActionBarBackgroundDrawable.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends Drawable {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final ActionBarContainer f3758IL1Iii;

    public ILil(ActionBarContainer actionBarContainer) {
        this.f3758IL1Iii = actionBarContainer;
    }

    @Override // android.graphics.drawable.Drawable
    public void draw(Canvas canvas) {
        ActionBarContainer actionBarContainer = this.f3758IL1Iii;
        if (actionBarContainer.f2334L11I) {
            Drawable drawable = actionBarContainer.f2333IiL;
            if (drawable != null) {
                drawable.draw(canvas);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2336lLi1LL;
        if (drawable2 != null) {
            drawable2.draw(canvas);
        }
        ActionBarContainer actionBarContainer2 = this.f3758IL1Iii;
        Drawable drawable3 = actionBarContainer2.f2335iILLL1;
        if (drawable3 == null || !actionBarContainer2.f2337il) {
            return;
        }
        drawable3.draw(canvas);
    }

    @Override // android.graphics.drawable.Drawable
    public int getOpacity() {
        return 0;
    }

    @Override // android.graphics.drawable.Drawable
    public void getOutline(Outline outline) {
        ActionBarContainer actionBarContainer = this.f3758IL1Iii;
        if (actionBarContainer.f2334L11I) {
            Drawable drawable = actionBarContainer.f2333IiL;
            if (drawable != null) {
                drawable.getOutline(outline);
                return;
            }
            return;
        }
        Drawable drawable2 = actionBarContainer.f2336lLi1LL;
        if (drawable2 != null) {
            drawable2.getOutline(outline);
        }
    }

    @Override // android.graphics.drawable.Drawable
    public void setAlpha(int i) {
    }

    @Override // android.graphics.drawable.Drawable
    public void setColorFilter(ColorFilter colorFilter) {
    }
}
