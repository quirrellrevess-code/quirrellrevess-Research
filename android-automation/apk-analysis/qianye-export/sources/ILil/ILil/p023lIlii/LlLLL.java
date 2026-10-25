package ILil.ILil.p023lIlii;

import ILil.ILil.iILLL1;
import ILil.p039L11I.IL1Iii.I1I;
import android.R;
import android.annotation.SuppressLint;
import android.app.SearchableInfo;
import android.content.ComponentName;
import android.content.Context;
import android.content.pm.ActivityInfo;
import android.content.pm.PackageManager;
import android.content.res.ColorStateList;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.text.SpannableString;
import android.text.TextUtils;
import android.text.style.TextAppearanceSpan;
import android.util.Log;
import android.util.TypedValue;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.widget.SearchView;
import com.google.android.flexbox.BuildConfig;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
import java.util.WeakHashMap;

/* JADX INFO: renamed from: ILil.ILil.lI丨lii.L丨lLLL, reason: invalid class name */
/* JADX INFO: compiled from: SuggestionsAdapter.java */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"RestrictedAPI"})
public class LlLLL extends I1I implements View.OnClickListener {
    public int I11L;
    public int I11li1;

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final SearchableInfo f1367ILl;
    public final Context Lil;
    public final WeakHashMap<String, Drawable.ConstantState> LlLI1;
    public int iIi1;
    public ColorStateList iIlLiL;

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final SearchView f1368lIiI;

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public boolean f1369lIlii;
    public int llliI;

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final int f1370llL1ii;

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public int f1371lL;

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public int f1372l;

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public int f13731;

    /* JADX INFO: renamed from: ILil.ILil.lI丨lii.L丨lLLL$IL1Iii */
    /* JADX INFO: compiled from: SuggestionsAdapter.java */
    public static final class IL1Iii {

        /* JADX INFO: renamed from: I1I, reason: collision with root package name */
        public final ImageView f3781I1I;

        /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
        public final TextView f3782IL1Iii;

        /* JADX INFO: renamed from: ILil, reason: collision with root package name */
        public final TextView f3783ILil;

        /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
        public final ImageView f3784Ilil;

        /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
        public final ImageView f1374IL;

        public IL1Iii(View view) {
            this.f3782IL1Iii = (TextView) view.findViewById(R.id.text1);
            this.f3783ILil = (TextView) view.findViewById(R.id.text2);
            this.f3781I1I = (ImageView) view.findViewById(R.id.icon1);
            this.f1374IL = (ImageView) view.findViewById(R.id.icon2);
            this.f3784Ilil = (ImageView) view.findViewById(iILLL1.edit_query);
        }
    }

    public LlLLL(Context context, SearchView searchView, SearchableInfo searchableInfo, WeakHashMap<String, Drawable.ConstantState> weakHashMap) {
        super(context, searchView.getSuggestionRowLayout(), null, true);
        this.f1369lIlii = false;
        this.iIi1 = 1;
        this.I11li1 = -1;
        this.f1371lL = -1;
        this.I11L = -1;
        this.llliI = -1;
        this.f1372l = -1;
        this.f13731 = -1;
        this.f1368lIiI = searchView;
        this.f1367ILl = searchableInfo;
        this.f1370llL1ii = searchView.getSuggestionCommitIconResId();
        this.Lil = context;
        this.LlLI1 = weakHashMap;
    }

    public static String I11L(Cursor cursor, int i) {
        if (i == -1) {
            return null;
        }
        try {
            return cursor.getString(i);
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "unexpected error retrieving valid column from cursor, did the remote process die?", e);
            return null;
        }
    }

    public static String Lil(Cursor cursor, String str) {
        return I11L(cursor, cursor.getColumnIndex(str));
    }

    public final Drawable I11li1(Cursor cursor) {
        int i = this.f1372l;
        if (i == -1) {
            return null;
        }
        return iIi1(cursor.getString(i));
    }

    @Override // ILil.p039L11I.IL1Iii.IL1Iii, ILil.L丨1丨1丨I.IL1Iii.ILil.IL1Iii
    public CharSequence I1I(Cursor cursor) {
        String strLil;
        String strLil2;
        if (cursor == null) {
            return null;
        }
        String strLil3 = Lil(cursor, "suggest_intent_query");
        if (strLil3 != null) {
            return strLil3;
        }
        if (this.f1367ILl.shouldRewriteQueryFromData() && (strLil2 = Lil(cursor, "suggest_intent_data")) != null) {
            return strLil2;
        }
        if (!this.f1367ILl.shouldRewriteQueryFromText() || (strLil = Lil(cursor, "suggest_text_1")) == null) {
            return null;
        }
        return strLil;
    }

    @Override // ILil.p039L11I.IL1Iii.IL1Iii, ILil.L丨1丨1丨I.IL1Iii.ILil.IL1Iii
    public void IL1Iii(Cursor cursor) {
        if (this.f1369lIlii) {
            Log.w("SuggestionsAdapter", "Tried to change cursor after adapter was closed.");
            if (cursor != null) {
                cursor.close();
                return;
            }
            return;
        }
        try {
            super.IL1Iii(cursor);
            if (cursor != null) {
                this.I11li1 = cursor.getColumnIndex("suggest_text_1");
                this.f1371lL = cursor.getColumnIndex("suggest_text_2");
                this.I11L = cursor.getColumnIndex("suggest_text_2_url");
                this.llliI = cursor.getColumnIndex("suggest_icon_1");
                this.f1372l = cursor.getColumnIndex("suggest_icon_2");
                this.f13731 = cursor.getColumnIndex("suggest_flags");
            }
        } catch (Exception e) {
            Log.e("SuggestionsAdapter", "error changing cursor and caching columns", e);
        }
    }

    public final Drawable ILL(String str) {
        Drawable.ConstantState constantState = this.LlLI1.get(str);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable();
    }

    /* JADX INFO: renamed from: IL丨丨l, reason: contains not printable characters */
    public final Drawable m1762ILl(ComponentName componentName) {
        String strFlattenToShortString = componentName.flattenToShortString();
        if (!this.LlLI1.containsKey(strFlattenToShortString)) {
            Drawable drawableM1767lIiI = m1767lIiI(componentName);
            this.LlLI1.put(strFlattenToShortString, drawableM1767lIiI != null ? drawableM1767lIiI.getConstantState() : null);
            return drawableM1767lIiI;
        }
        Drawable.ConstantState constantState = this.LlLI1.get(strFlattenToShortString);
        if (constantState == null) {
            return null;
        }
        return constantState.newDrawable(this.Lil.getResources());
    }

    @Override // ILil.p039L11I.IL1Iii.IL1Iii
    public void Ilil(View view, Context context, Cursor cursor) {
        IL1Iii iL1Iii = (IL1Iii) view.getTag();
        int i = this.f13731;
        int i2 = i != -1 ? cursor.getInt(i) : 0;
        if (iL1Iii.f3782IL1Iii != null) {
            m17731(iL1Iii.f3782IL1Iii, I11L(cursor, this.I11li1));
        }
        if (iL1Iii.f3783ILil != null) {
            String strI11L = I11L(cursor, this.I11L);
            CharSequence charSequenceM1765Ll1 = strI11L != null ? m1765Ll1(strI11L) : I11L(cursor, this.f1371lL);
            if (TextUtils.isEmpty(charSequenceM1765Ll1)) {
                TextView textView = iL1Iii.f3782IL1Iii;
                if (textView != null) {
                    textView.setSingleLine(false);
                    iL1Iii.f3782IL1Iii.setMaxLines(2);
                }
            } else {
                TextView textView2 = iL1Iii.f3782IL1Iii;
                if (textView2 != null) {
                    textView2.setSingleLine(true);
                    iL1Iii.f3782IL1Iii.setMaxLines(1);
                }
            }
            m17731(iL1Iii.f3783ILil, charSequenceM1765Ll1);
        }
        ImageView imageView = iL1Iii.f3781I1I;
        if (imageView != null) {
            m1772l(imageView, iIlLiL(cursor), 4);
        }
        ImageView imageView2 = iL1Iii.f1374IL;
        if (imageView2 != null) {
            m1772l(imageView2, I11li1(cursor), 8);
        }
        int i3 = this.iIi1;
        if (i3 != 2 && (i3 != 1 || (i2 & 1) == 0)) {
            iL1Iii.f3784Ilil.setVisibility(8);
            return;
        }
        iL1Iii.f3784Ilil.setVisibility(0);
        iL1Iii.f3784Ilil.setTag(iL1Iii.f3782IL1Iii.getText());
        iL1Iii.f3784Ilil.setOnClickListener(this);
    }

    @Override // ILil.L丨1丨1丨I.IL1Iii.ILil.IL1Iii
    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public Cursor mo1763IL(CharSequence charSequence) {
        String string = charSequence == null ? BuildConfig.FLAVOR : charSequence.toString();
        if (this.f1368lIiI.getVisibility() == 0 && this.f1368lIiI.getWindowVisibility() == 0) {
            try {
                Cursor cursorM1771lL = m1771lL(this.f1367ILl, string, 50);
                if (cursorM1771lL != null) {
                    cursorM1771lL.getCount();
                    return cursorM1771lL;
                }
            } catch (RuntimeException e) {
                Log.w("SuggestionsAdapter", "Search suggestions query threw an exception.", e);
            }
        }
        return null;
    }

    @Override // ILil.p039L11I.IL1Iii.I1I, ILil.p039L11I.IL1Iii.IL1Iii
    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public View mo1764IiL(Context context, Cursor cursor, ViewGroup viewGroup) {
        View viewMo1764IiL = super.mo1764IiL(context, cursor, viewGroup);
        viewMo1764IiL.setTag(new IL1Iii(viewMo1764IiL));
        ((ImageView) viewMo1764IiL.findViewById(iILLL1.edit_query)).setImageResource(this.f1370llL1ii);
        return viewMo1764IiL;
    }

    public final Drawable LlLI1(Cursor cursor) {
        Drawable drawableM1762ILl = m1762ILl(this.f1367ILl.getSearchActivity());
        return drawableM1762ILl != null ? drawableM1762ILl : this.f4320Ilil.getPackageManager().getDefaultActivityIcon();
    }

    /* JADX INFO: renamed from: Ll丨1, reason: contains not printable characters */
    public final CharSequence m1765Ll1(CharSequence charSequence) {
        if (this.iIlLiL == null) {
            TypedValue typedValue = new TypedValue();
            this.f4320Ilil.getTheme().resolveAttribute(ILil.ILil.IL1Iii.textColorSearchUrl, typedValue, true);
            this.iIlLiL = this.f4320Ilil.getResources().getColorStateList(typedValue.resourceId);
        }
        SpannableString spannableString = new SpannableString(charSequence);
        spannableString.setSpan(new TextAppearanceSpan(null, 0, 0, this.iIlLiL, null), 0, charSequence.length(), 33);
        return spannableString;
    }

    /* JADX INFO: renamed from: L丨lLLL, reason: contains not printable characters */
    public final void m1766LlLLL(String str, Drawable drawable) {
        if (drawable != null) {
            this.LlLI1.put(str, drawable.getConstantState());
        }
    }

    @Override // ILil.p039L11I.IL1Iii.IL1Iii, android.widget.BaseAdapter, android.widget.SpinnerAdapter
    public View getDropDownView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getDropDownView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewMo2450iILLL1 = mo2450iILLL1(this.f4320Ilil, this.f1781IL, viewGroup);
            if (viewMo2450iILLL1 != null) {
                ((IL1Iii) viewMo2450iILLL1.getTag()).f3782IL1Iii.setText(e.toString());
            }
            return viewMo2450iILLL1;
        }
    }

    @Override // ILil.p039L11I.IL1Iii.IL1Iii, android.widget.Adapter
    public View getView(int i, View view, ViewGroup viewGroup) {
        try {
            return super.getView(i, view, viewGroup);
        } catch (RuntimeException e) {
            Log.w("SuggestionsAdapter", "Search suggestions cursor threw exception.", e);
            View viewMo1764IiL = mo1764IiL(this.f4320Ilil, this.f1781IL, viewGroup);
            if (viewMo1764IiL != null) {
                ((IL1Iii) viewMo1764IiL.getTag()).f3782IL1Iii.setText(e.toString());
            }
            return viewMo1764IiL;
        }
    }

    @Override // android.widget.BaseAdapter, android.widget.Adapter
    public boolean hasStableIds() {
        return false;
    }

    public final Drawable iIi1(String str) {
        if (str == null || str.isEmpty() || "0".equals(str)) {
            return null;
        }
        try {
            int i = Integer.parseInt(str);
            String str2 = "android.resource://" + this.Lil.getPackageName() + "/" + i;
            Drawable drawableILL = ILL(str2);
            if (drawableILL != null) {
                return drawableILL;
            }
            Drawable drawableM2321IL = ILil.p028IiL.p035lLi1LL.IL1Iii.m2321IL(this.Lil, i);
            m1766LlLLL(str2, drawableM2321IL);
            return drawableM2321IL;
        } catch (Resources.NotFoundException unused) {
            Log.w("SuggestionsAdapter", "Icon resource not found: " + str);
            return null;
        } catch (NumberFormatException unused2) {
            Drawable drawableILL2 = ILL(str);
            if (drawableILL2 != null) {
                return drawableILL2;
            }
            Drawable drawableM1770llL1ii = m1770llL1ii(Uri.parse(str));
            m1766LlLLL(str, drawableM1770llL1ii);
            return drawableM1770llL1ii;
        }
    }

    public final Drawable iIlLiL(Cursor cursor) {
        int i = this.llliI;
        if (i == -1) {
            return null;
        }
        Drawable drawableIIi1 = iIi1(cursor.getString(i));
        return drawableIIi1 != null ? drawableIIi1 : LlLI1(cursor);
    }

    /* JADX INFO: renamed from: lIi丨I, reason: contains not printable characters */
    public final Drawable m1767lIiI(ComponentName componentName) {
        PackageManager packageManager = this.f4320Ilil.getPackageManager();
        try {
            ActivityInfo activityInfo = packageManager.getActivityInfo(componentName, 128);
            int iconResource = activityInfo.getIconResource();
            if (iconResource == 0) {
                return null;
            }
            Drawable drawable = packageManager.getDrawable(componentName.getPackageName(), iconResource, activityInfo.applicationInfo);
            if (drawable != null) {
                return drawable;
            }
            Log.w("SuggestionsAdapter", "Invalid icon resource " + iconResource + " for " + componentName.flattenToShortString());
            return null;
        } catch (PackageManager.NameNotFoundException e) {
            Log.w("SuggestionsAdapter", e.toString());
            return null;
        }
    }

    /* JADX INFO: renamed from: lI丨II, reason: contains not printable characters */
    public final void m1768lIII(Cursor cursor) {
        Bundle extras = cursor != null ? cursor.getExtras() : null;
        if (extras == null || extras.getBoolean("in_progress")) {
        }
    }

    /* JADX INFO: renamed from: lI丨lii, reason: contains not printable characters */
    public Drawable m1769lIlii(Uri uri) throws FileNotFoundException {
        int identifier;
        String authority = uri.getAuthority();
        if (TextUtils.isEmpty(authority)) {
            throw new FileNotFoundException("No authority: " + uri);
        }
        try {
            Resources resourcesForApplication = this.f4320Ilil.getPackageManager().getResourcesForApplication(authority);
            List<String> pathSegments = uri.getPathSegments();
            if (pathSegments == null) {
                throw new FileNotFoundException("No path: " + uri);
            }
            int size = pathSegments.size();
            if (size == 1) {
                try {
                    identifier = Integer.parseInt(pathSegments.get(0));
                } catch (NumberFormatException unused) {
                    throw new FileNotFoundException("Single path segment is not a resource ID: " + uri);
                }
            } else {
                if (size != 2) {
                    throw new FileNotFoundException("More than two path segments: " + uri);
                }
                identifier = resourcesForApplication.getIdentifier(pathSegments.get(1), pathSegments.get(0), authority);
            }
            if (identifier != 0) {
                return resourcesForApplication.getDrawable(identifier);
            }
            throw new FileNotFoundException("No resource found for: " + uri);
        } catch (PackageManager.NameNotFoundException unused2) {
            throw new FileNotFoundException("No package found for authority: " + uri);
        }
    }

    public void llliI(int i) {
        this.iIi1 = i;
    }

    /* JADX INFO: renamed from: ll丨L1ii, reason: contains not printable characters */
    public final Drawable m1770llL1ii(Uri uri) {
        try {
            if ("android.resource".equals(uri.getScheme())) {
                try {
                    return m1769lIlii(uri);
                } catch (Resources.NotFoundException unused) {
                    throw new FileNotFoundException("Resource does not exist: " + uri);
                }
            }
            InputStream inputStreamOpenInputStream = this.Lil.getContentResolver().openInputStream(uri);
            if (inputStreamOpenInputStream == null) {
                throw new FileNotFoundException("Failed to open " + uri);
            }
            try {
                Drawable drawableCreateFromStream = Drawable.createFromStream(inputStreamOpenInputStream, null);
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e);
                }
                return drawableCreateFromStream;
            } catch (Throwable th) {
                try {
                    inputStreamOpenInputStream.close();
                } catch (IOException e2) {
                    Log.e("SuggestionsAdapter", "Error closing icon stream for " + uri, e2);
                }
                throw th;
            }
        } catch (FileNotFoundException e3) {
            Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
            return null;
        }
        Log.w("SuggestionsAdapter", "Icon not found: " + uri + ", " + e3.getMessage());
        return null;
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetChanged() {
        super.notifyDataSetChanged();
        m1768lIII(ILil());
    }

    @Override // android.widget.BaseAdapter
    public void notifyDataSetInvalidated() {
        super.notifyDataSetInvalidated();
        m1768lIII(ILil());
    }

    @Override // android.view.View.OnClickListener
    public void onClick(View view) {
        Object tag = view.getTag();
        if (tag instanceof CharSequence) {
            this.f1368lIiI.I11L((CharSequence) tag);
        }
    }

    /* JADX INFO: renamed from: 丨lL, reason: contains not printable characters */
    public Cursor m1771lL(SearchableInfo searchableInfo, String str, int i) {
        String suggestAuthority;
        String[] strArr = null;
        if (searchableInfo == null || (suggestAuthority = searchableInfo.getSuggestAuthority()) == null) {
            return null;
        }
        Uri.Builder builderFragment = new Uri.Builder().scheme("content").authority(suggestAuthority).query(BuildConfig.FLAVOR).fragment(BuildConfig.FLAVOR);
        String suggestPath = searchableInfo.getSuggestPath();
        if (suggestPath != null) {
            builderFragment.appendEncodedPath(suggestPath);
        }
        builderFragment.appendPath("search_suggest_query");
        String suggestSelection = searchableInfo.getSuggestSelection();
        if (suggestSelection != null) {
            strArr = new String[]{str};
        } else {
            builderFragment.appendPath(str);
        }
        String[] strArr2 = strArr;
        if (i > 0) {
            builderFragment.appendQueryParameter("limit", String.valueOf(i));
        }
        return this.f4320Ilil.getContentResolver().query(builderFragment.build(), null, suggestSelection, strArr2, null);
    }

    /* JADX INFO: renamed from: 丨l丨, reason: contains not printable characters */
    public final void m1772l(ImageView imageView, Drawable drawable, int i) {
        imageView.setImageDrawable(drawable);
        if (drawable == null) {
            imageView.setVisibility(i);
            return;
        }
        imageView.setVisibility(0);
        drawable.setVisible(false, false);
        drawable.setVisible(true, false);
    }

    /* JADX INFO: renamed from: 丨丨丨1丨, reason: contains not printable characters */
    public final void m17731(TextView textView, CharSequence charSequence) {
        textView.setText(charSequence);
        if (TextUtils.isEmpty(charSequence)) {
            textView.setVisibility(8);
        } else {
            textView.setVisibility(0);
        }
    }
}
