package ILil.p039L11I.IL1Iii;

import android.content.Context;
import android.database.ContentObserver;
import android.database.Cursor;
import android.database.DataSetObserver;
import android.os.Handler;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.Filter;
import android.widget.Filterable;

/* JADX INFO: compiled from: CursorAdapter.java */
/* JADX INFO: loaded from: classes.dex */
public abstract class IL1Iii extends BaseAdapter implements Filterable, ILil.L丨1丨1丨I.IL1Iii.ILil.IL1Iii {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public boolean f4318I1I;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public boolean f4319ILil;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public Context f4320Ilil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Cursor f1781IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public DataSetObserver f1782IiL;

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public ILil.p039L11I.IL1Iii.ILil f1783L11I;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public C0579IL1Iii f1784iILLL1;

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public int f1785lLi1LL;

    /* JADX INFO: renamed from: ILil.L丨1丨1丨I.IL1Iii.IL1Iii$IL1Iii, reason: collision with other inner class name */
    /* JADX INFO: compiled from: CursorAdapter.java */
    public class C0579IL1Iii extends ContentObserver {
        public C0579IL1Iii() {
            super(new Handler());
        }

        @Override // android.database.ContentObserver
        public boolean deliverSelfNotifications() {
            return true;
        }

        @Override // android.database.ContentObserver
        public void onChange(boolean z) {
            IL1Iii.this.m2451L11I();
        }
    }

    /* JADX INFO: compiled from: CursorAdapter.java */
    public class ILil extends DataSetObserver {
        public ILil() {
        }

        @Override // android.database.DataSetObserver
        public void onChanged() {
            IL1Iii iL1Iii = IL1Iii.this;
            iL1Iii.f4319ILil = true;
            iL1Iii.notifyDataSetChanged();
        }

        @Override // android.database.DataSetObserver
        public void onInvalidated() {
            IL1Iii iL1Iii = IL1Iii.this;
            iL1Iii.f4319ILil = false;
            iL1Iii.notifyDataSetInvalidated();
        }
    }

    public IL1Iii(Context context, Cursor cursor, boolean z) {
        m2452lLi1LL(context, cursor, z ? 1 : 2);
    }

    public abstract CharSequence I1I(Cursor cursor);

    public void IL1Iii(Cursor cursor) {
        Cursor cursorM2453il = m2453il(cursor);
        if (cursorM2453il != null) {
            cursorM2453il.close();
        }
    }

    @Override // ILil.L丨1丨1丨I.IL1Iii.ILil.IL1Iii
    public Cursor ILil() {
        return this.f1781IL;
    }

    public abstract void Ilil(View view, Context context, Cursor cursor);

    /* JADX INFO: renamed from: I丨iL */
    public abstract View mo1764IiL(Context context, Cursor cursor, ViewGroup viewGroup);

    /* JADX INFO: renamed from: L丨1丨1丨I, reason: contains not printable characters */
    public void m2451L11I() {
        Cursor cursor;
        if (!this.f4318I1I || (cursor = this.f1781IL) == null || cursor.isClosed()) {
            return;
        }
        this.f4319ILil = this.f1781IL.requery();
    }

    @Override // android.widget.Adapter
    public int getCount() {
        Cursor cursor;
        if (!this.f4319ILil || (cursor = this.f1781IL) == null) {
            return 0;
        }
        return cursor.getCount();
    }

    @Override // android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        if (!this.f4319ILil) {
            return null;
        }
        this.f1781IL.moveToPosition(i);
        if (view == null) {
            view = mo2450iILLL1(this.f4320Ilil, this.f1781IL, viewGroup);
        }
        Ilil(view, this.f4320Ilil, this.f1781IL);
        return view;
    }

    @Override // android.widget.Filterable
    public Filter getFilter() {
        if (this.f1783L11I == null) {
            this.f1783L11I = new ILil.p039L11I.IL1Iii.ILil(this);
        }
        return this.f1783L11I;
    }

    @Override // android.widget.Adapter
    public Object getItem(int i) {
        Cursor cursor;
        if (!this.f4319ILil || (cursor = this.f1781IL) == null) {
            return null;
        }
        cursor.moveToPosition(i);
        return this.f1781IL;
    }

    @Override // android.widget.Adapter
    public long getItemId(int i) {
        Cursor cursor;
        if (this.f4319ILil && (cursor = this.f1781IL) != null && cursor.moveToPosition(i)) {
            return this.f1781IL.getLong(this.f1785lLi1LL);
        }
        return 0L;
    }

    @Override // android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        if (!this.f4319ILil) {
            throw new IllegalStateException("this should only be called when the cursor is valid");
        }
        if (this.f1781IL.moveToPosition(i)) {
            if (view == null) {
                view = mo1764IiL(this.f4320Ilil, this.f1781IL, viewGroup);
            }
            Ilil(view, this.f4320Ilil, this.f1781IL);
            return view;
        }
        throw new IllegalStateException("couldn't move cursor to position " + i);
    }

    /* JADX INFO: renamed from: iI丨LLL1 */
    public abstract View mo2450iILLL1(Context context, Cursor cursor, ViewGroup viewGroup);

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public void m2452lLi1LL(Context context, Cursor cursor, int i) {
        if ((i & 1) == 1) {
            i |= 2;
            this.f4318I1I = true;
        } else {
            this.f4318I1I = false;
        }
        boolean z = cursor != null;
        this.f1781IL = cursor;
        this.f4319ILil = z;
        this.f4320Ilil = context;
        this.f1785lLi1LL = z ? cursor.getColumnIndexOrThrow("_id") : -1;
        if ((i & 2) == 2) {
            this.f1784iILLL1 = new C0579IL1Iii();
            this.f1782IiL = new ILil();
        } else {
            this.f1784iILLL1 = null;
            this.f1782IiL = null;
        }
        if (z) {
            C0579IL1Iii c0579IL1Iii = this.f1784iILLL1;
            if (c0579IL1Iii != null) {
                cursor.registerContentObserver(c0579IL1Iii);
            }
            DataSetObserver dataSetObserver = this.f1782IiL;
            if (dataSetObserver != null) {
                cursor.registerDataSetObserver(dataSetObserver);
            }
        }
    }

    /* JADX INFO: renamed from: 丨il, reason: contains not printable characters */
    public Cursor m2453il(Cursor cursor) {
        Cursor cursor2 = this.f1781IL;
        if (cursor == cursor2) {
            return null;
        }
        if (cursor2 != null) {
            C0579IL1Iii c0579IL1Iii = this.f1784iILLL1;
            if (c0579IL1Iii != null) {
                cursor2.unregisterContentObserver(c0579IL1Iii);
            }
            DataSetObserver dataSetObserver = this.f1782IiL;
            if (dataSetObserver != null) {
                cursor2.unregisterDataSetObserver(dataSetObserver);
            }
        }
        this.f1781IL = cursor;
        if (cursor != null) {
            C0579IL1Iii c0579IL1Iii2 = this.f1784iILLL1;
            if (c0579IL1Iii2 != null) {
                cursor.registerContentObserver(c0579IL1Iii2);
            }
            DataSetObserver dataSetObserver2 = this.f1782IiL;
            if (dataSetObserver2 != null) {
                cursor.registerDataSetObserver(dataSetObserver2);
            }
            this.f1785lLi1LL = cursor.getColumnIndexOrThrow("_id");
            this.f4319ILil = true;
            notifyDataSetChanged();
        } else {
            this.f1785lLi1LL = -1;
            this.f4319ILil = false;
            notifyDataSetInvalidated();
        }
        return cursor2;
    }
}
