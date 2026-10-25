package ILil.p039L11I.IL1Iii;

import android.database.Cursor;
import android.widget.Filter;

/* JADX INFO: compiled from: CursorFilter.java */
/* JADX INFO: loaded from: classes.dex */
public class ILil extends Filter {

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public IL1Iii f4323IL1Iii;

    /* JADX INFO: compiled from: CursorFilter.java */
    public interface IL1Iii {
        CharSequence I1I(Cursor cursor);

        void IL1Iii(Cursor cursor);

        Cursor ILil();

        /* JADX INFO: renamed from: I丨L */
        Cursor mo1763IL(CharSequence charSequence);
    }

    public ILil(IL1Iii iL1Iii) {
        this.f4323IL1Iii = iL1Iii;
    }

    @Override // android.widget.Filter
    public CharSequence convertResultToString(Object obj) {
        return this.f4323IL1Iii.I1I((Cursor) obj);
    }

    @Override // android.widget.Filter
    public Filter.FilterResults performFiltering(CharSequence charSequence) {
        Cursor cursorMo1763IL = this.f4323IL1Iii.mo1763IL(charSequence);
        Filter.FilterResults filterResults = new Filter.FilterResults();
        if (cursorMo1763IL != null) {
            filterResults.count = cursorMo1763IL.getCount();
            filterResults.values = cursorMo1763IL;
        } else {
            filterResults.count = 0;
            filterResults.values = null;
        }
        return filterResults;
    }

    @Override // android.widget.Filter
    public void publishResults(CharSequence charSequence, Filter.FilterResults filterResults) {
        Cursor cursorILil = this.f4323IL1Iii.ILil();
        Object obj = filterResults.values;
        if (obj == null || obj == cursorILil) {
            return;
        }
        this.f4323IL1Iii.IL1Iii((Cursor) obj);
    }
}
