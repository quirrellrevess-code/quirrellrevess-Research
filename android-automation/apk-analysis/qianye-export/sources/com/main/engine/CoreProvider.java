package com.main.engine;

import I1I.I1I.ILil.C1;
import I1I.I1I.ILil.LLL;
import I1I.I1I.ILil.LlLI1;
import I1I.I1I.ILil.iIilII1;
import I1I.IL1Iii;
import android.app.INXCoreNative;
import android.content.ContentProvider;
import android.content.ContentValues;
import android.database.Cursor;
import android.net.Uri;
import android.os.Bundle;
import android.text.TextUtils;

/* JADX INFO: loaded from: classes.dex */
public class CoreProvider extends ContentProvider {
    @Override // android.content.ContentProvider
    public synchronized Bundle call(String str, String str2, Bundle bundle) {
        INXCoreNative.Stub stub;
        if (!TextUtils.isEmpty(str)) {
            if (str.compareTo(IL1Iii.IL1Iii(new byte[]{74, 81, 88, 6, 98, 68, 92, 70, 101, 7, 69, 65, 80, 87, 83}, IL1Iii.IL1Iii(new byte[]{0, 86, 1, 0, 81, 14}, IL1Iii.IL1Iii(new byte[]{12, 90, 15, 0, 2, 8}, "588bd1")))) == 0) {
                stub = (INXCoreNative.Stub) LlLI1.m925IL().Ilil();
            } else if (str.compareTo(IL1Iii.IL1Iii(new byte[]{74, 81, 95, 80, 102, 21, 92, 70, 98, 81, 65, 16, 80, 87, 84, 117, 80, 5}, IL1Iii.IL1Iii(new byte[]{95, 3, 3, 86, 5, 87}, IL1Iii.IL1Iii(new byte[]{81, 4, 11, 90, 1, 84}, "73987e")))) == 0) {
                stub = (INXCoreNative.Stub) LlLI1.m925IL().IL1Iii();
            } else if (str.compareTo(IL1Iii.IL1Iii(new byte[]{74, 3, 10, 7, 99, 65, 92, 20, 55, 6, 68, 68, 80, 5, 1, 48, 85, 64, 80, 22, 16}, IL1Iii.IL1Iii(new byte[]{10, 87, 93, 2, 14, 6}, IL1Iii.IL1Iii(new byte[]{6, 6, 10, 89, 15, 87}, "57387c")))) == 0) {
                stub = (INXCoreNative.Stub) LlLI1.m925IL().m927lLi1LL();
            } else {
                if (str.compareTo(IL1Iii.IL1Iii(new byte[]{68, 82, 13, 0, 102, 69, 82, 69, 48, 1, 65, 64, 94, 84, 6, 52, 65, 89, 79, 78}, IL1Iii.IL1Iii(new byte[]{4, 6, 82, 6, 86, 85}, IL1Iii.IL1Iii(new byte[]{0, 0, 3, 1, 3, 86}, "312cf5")))) == 0) {
                    INXCoreNative.Stub stub2 = (INXCoreNative.Stub) LlLI1.m925IL().m927lLi1LL();
                    iIilII1.LLL().m989lIIiIlL(bundle);
                    Bundle bundle2 = new Bundle();
                    bundle2.putParcelable(IL1Iii.IL1Iii(new byte[]{91, 90, 85, 30, 12, 74, 22, 86, 87, 66, 7, 28, 79, 71, 89, 64, 18, 87, 74, 70, 22, 89, 12, 70, 93, 91, 76, 30, 7, 74, 76, 71, 89, 30, 32, 123, 118, 113, 125, 98}, IL1Iii.IL1Iii(new byte[]{9, 81, 0, 81, 0, 5}, IL1Iii.IL1Iii(new byte[]{4, 82, 1, 0, 84, 2}, "569a65"))), new BinderContainer(stub2));
                    bundle2.putString(IL1Iii.IL1Iii(new byte[]{82, 87, 91, 75, 88, 30, 31, 91, 89, 23, 83, 72, 69, 87, 93, 0, 88}, IL1Iii.IL1Iii(new byte[]{85, 1, 15, 80, 14, 2}, IL1Iii.IL1Iii(new byte[]{6, 88, 91, 87, 14, 7}, "babb6c"))), IL1Iii.IL1Iii(new byte[]{11, 7, 85, 95, 86}, IL1Iii.IL1Iii(new byte[]{91, 91, 11, 10, 91, 5}, IL1Iii.IL1Iii(new byte[]{8, 13, 87, 11, 86, 85}, "04e24f"))));
                    return bundle2;
                }
                if (str.compareTo(IL1Iii.IL1Iii(new byte[]{22, 6, 15, 2, 49, 18, 0, 17, 50, 3, 22, 23, 12, 0, 4, 51, 13, 32, 16, 23, 14}, IL1Iii.IL1Iii(new byte[]{82, 81, 85, 0, 7, 83}, IL1Iii.IL1Iii(new byte[]{2, 2, 82, 83, 1, 80}, "50f5bb")))) == 0) {
                    INXCoreNative.Stub stub3 = (INXCoreNative.Stub) LlLI1.m925IL().m927lLi1LL();
                    iIilII1.LLL().LiL1(bundle);
                    Bundle bundle3 = new Bundle();
                    bundle3.putParcelable(IL1Iii.IL1Iii(new byte[]{84, 89, 91, 26, 88, 77, 25, 85, 89, 70, 83, 27, 64, 68, 87, 68, 70, 80, 69, 69, 24, 93, 88, 65, 82, 88, 66, 26, 83, 77, 67, 68, 87, 26, 116, 124, 121, 114, 115, 102}, IL1Iii.IL1Iii(new byte[]{14, 85, 82, 4, 84, 86}, IL1Iii.IL1Iii(new byte[]{9, 0, 84, 82, 4, 0}, "0c0bfc"))), new BinderContainer(stub3));
                    bundle3.putString(IL1Iii.IL1Iii(new byte[]{0, 10, 85, 26, 93, 25, 77, 6, 87, 70, 86, 79, 23, 10, 83, 81, 93}, IL1Iii.IL1Iii(new byte[]{6, 6, 91, 13, 4, 88}, IL1Iii.IL1Iii(new byte[]{83, 82, 7, 10, 7, 13}, "61d304"))), IL1Iii.IL1Iii(new byte[]{81, 82, 94, 14, 94}, IL1Iii.IL1Iii(new byte[]{15, 15, 0, 82, 2, 5}, IL1Iii.IL1Iii(new byte[]{80, 93, 80, 4, 5, 6}, "feb46e"))));
                    return bundle3;
                }
                if (str.compareTo(IL1Iii.IL1Iii(new byte[]{17, 82, 88, 80, 100, 21, 7, 69, 101, 81, 67, 16, 11, 84, 83, 103, 89, 3, 14, 91}, IL1Iii.IL1Iii(new byte[]{91, 3, 87, 82, 82, 2}, IL1Iii.IL1Iii(new byte[]{12, 86, 2, 3, 1, 6}, "5bcebb")))) == 0) {
                    LLL lllM926iILLL1 = LlLI1.m925IL().m926iILLL1();
                    lllM926iILLL1.m921lIiI(getContext(), bundle);
                    Bundle bundle4 = new Bundle();
                    bundle4.putBinder(IL1Iii.IL1Iii(new byte[]{90, 87, 85, 29, 91, 79, 23, 91, 87, 65, 80, 25, 78, 74, 89, 67, 69, 82, 75, 75, 22, 90, 91, 67, 92, 86, 76, 29, 80, 79, 77, 74, 89, 29, 119, 126, 119, 124, 125, 97}, IL1Iii.IL1Iii(new byte[]{10, 92, 90, 87, 2, 6}, IL1Iii.IL1Iii(new byte[]{1, 1, 91, 83, 1, 2}, "2e9763"))), lllM926iILLL1);
                    bundle4.putString(IL1Iii.IL1Iii(new byte[]{82, 13, 93, 77, 91, 26, 31, 1, 95, 17, 80, 76, 69, 13, 91, 6, 91}, IL1Iii.IL1Iii(new byte[]{2, 85, 86, 80, 83, 81}, IL1Iii.IL1Iii(new byte[]{5, 6, 7, 0, 85, 86}, "61a33e"))), IL1Iii.IL1Iii(new byte[]{90, 4, 85, 84, 90}, IL1Iii.IL1Iii(new byte[]{11, 81, 11, 12, 6, 91}, IL1Iii.IL1Iii(new byte[]{11, 1, 0, 80, 80, 6}, "212dce"))));
                    return bundle4;
                }
                stub = null;
            }
            if (stub != null) {
                ((C1) stub).mo848IL(getContext(), bundle);
                Bundle bundle5 = new Bundle();
                bundle5.putParcelable(IL1Iii.IL1Iii(new byte[]{81, 95, 11, 77, 87, 25, 28, 83, 9, 17, 92, 79, 69, 66, 7, 19, 73, 4, 64, 67, 72, 10, 87, 21, 87, 94, 18, 77, 92, 25, 70, 66, 7, 77, 123, 40, 124, 116, 35, 49}, IL1Iii.IL1Iii(new byte[]{0, 2, 80, 81, 1, 86}, IL1Iii.IL1Iii(new byte[]{5, 87, 5, 6, 13, 0}, "7e3457"))), new BinderContainer(stub));
                bundle5.putString(IL1Iii.IL1Iii(new byte[]{7, 88, 95, 27, 8, 73, 74, 84, 93, 71, 3, 31, 16, 88, 89, 80, 8}, IL1Iii.IL1Iii(new byte[]{1, 7, 7, 86, 7, 7}, IL1Iii.IL1Iii(new byte[]{1, 83, 7, 1, 84, 82}, "dc2b5d"))), IL1Iii.IL1Iii(new byte[]{95, 4, 95, 13, 10}, IL1Iii.IL1Iii(new byte[]{5, 86, 11, 85, 0, 80}, IL1Iii.IL1Iii(new byte[]{87, 86, 91, 1, 87, 90}, "eac528"))));
                return bundle5;
            }
        }
        return null;
    }

    @Override // android.content.ContentProvider
    public int delete(Uri uri, String str, String[] strArr) {
        return 0;
    }

    @Override // android.content.ContentProvider
    public String getType(Uri uri) {
        return null;
    }

    @Override // android.content.ContentProvider
    public Uri insert(Uri uri, ContentValues contentValues) {
        return null;
    }

    @Override // android.content.ContentProvider
    public boolean onCreate() {
        return false;
    }

    @Override // android.content.ContentProvider
    public Cursor query(Uri uri, String[] strArr, String str, String[] strArr2, String str2) {
        return null;
    }

    @Override // android.content.ContentProvider
    public int update(Uri uri, ContentValues contentValues, String str, String[] strArr) {
        return 0;
    }
}
