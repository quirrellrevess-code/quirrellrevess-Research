package org.opencv.android;

import I1I.IL1Iii;
import android.util.Log;
import com.google.android.flexbox.BuildConfig;
import java.util.StringTokenizer;
import org.opencv.core.Core;

/* JADX INFO: loaded from: classes.dex */
public class StaticHelper {
    private static final String TAG = IL1Iii.IL1Iii(new byte[]{42, 22, 1, 88, 116, 102, 74, 53, 16, 87, 67, 89, 6, 46, 1, 90, 71, 85, 23}, IL1Iii.IL1Iii(new byte[]{86, 2, 84, 4, 83, 86}, IL1Iii.IL1Iii(new byte[]{7, 85, 81, 1, 93, 80}, "41a396")));

    private static native String getLibraryList();

    public static boolean initOpenCV(boolean z) {
        String libraryList;
        if (z) {
            loadLibrary(IL1Iii.IL1Iii(new byte[]{91, 19, 80, 5, 66, 65}, IL1Iii.IL1Iii(new byte[]{15, 5, 86, 85, 5, 86}, IL1Iii.IL1Iii(new byte[]{82, 2, 87, 85, 0, 1}, "ea5d5b"))));
            loadLibrary(IL1Iii.IL1Iii(new byte[]{8, 22, 70, 6}, IL1Iii.IL1Iii(new byte[]{4, 5, 85, 85, 81, 1}, IL1Iii.IL1Iii(new byte[]{82, 81, 81, 6, 87, 81}, "022625"))));
            loadLibrary(IL1Iii.IL1Iii(new byte[]{13, 17, 73, 8}, IL1Iii.IL1Iii(new byte[]{84, 86, 92, 87, 92, 7}, IL1Iii.IL1Iii(new byte[]{1, 14, 86, 5, 2, 2}, "6933ff"))));
            loadLibrary(IL1Iii.IL1Iii(new byte[]{93, 67, 67, 65}, IL1Iii.IL1Iii(new byte[]{2, 5, 85, 0, 0, 80}, IL1Iii.IL1Iii(new byte[]{7, 14, 3, 83, 85, 85}, "68ea03"))));
            loadLibrary(IL1Iii.IL1Iii(new byte[]{5, 22, 84, 81, 69}, IL1Iii.IL1Iii(new byte[]{85, 6, 87, 0, 0, 86}, IL1Iii.IL1Iii(new byte[]{82, 80, 82, 85, 1, 3}, "a57b03"))));
            loadLibrary(IL1Iii.IL1Iii(new byte[]{0, 66, 3, 9, 2, 75}, IL1Iii.IL1Iii(new byte[]{83, 0, 84, 87, 84, 90}, IL1Iii.IL1Iii(new byte[]{1, 81, 84, 7, 83, 90}, "1fa5d8"))));
        }
        Log.d(TAG, IL1Iii.IL1Iii(new byte[]{53, 19, 64, 80, 88, 1, 65, 21, 86, 25, 81, 3, 21, 65, 85, 80, 84, 20, 0, 19, 64, 25, 90, 15, 18, 21}, IL1Iii.IL1Iii(new byte[]{80, 81, 10, 9, 1, 81}, IL1Iii.IL1Iii(new byte[]{3, 3, 87, 86, 2, 84}, "23df5c"))));
        try {
            System.loadLibrary(IL1Iii.IL1Iii(new byte[]{93, 21, 93, 91, 0, 23, 109, 12, 86, 83, 12}, IL1Iii.IL1Iii(new byte[]{7, 93, 10, 80, 85, 88}, IL1Iii.IL1Iii(new byte[]{3, 89, 83, 0, 5, 9}, "6aae30"))));
            libraryList = getLibraryList();
        } catch (UnsatisfiedLinkError unused) {
            Log.e(TAG, IL1Iii.IL1Iii(new byte[]{42, 65, 81, 10, 39, 50, 69, 84, 70, 22, 11, 22, 95, 17, 119, 5, 10, 10, 10, 69, 20, 8, 11, 5, 1, 17, 93, 10, 2, 11, 69, 93, 93, 6, 22, 5, 23, 72, 20, 2, 11, 22, 69, 126, 68, 1, 10, 39, 51}, IL1Iii.IL1Iii(new byte[]{86, 9, 1, 82, 85, 84}, IL1Iii.IL1Iii(new byte[]{81, 91, 83, 84, 84, 9}, "bcfbe9"))));
            libraryList = BuildConfig.FLAVOR;
        }
        String str = TAG;
        Log.d(str, IL1Iii.IL1Iii(new byte[]{42, 12, 80, 75, 3, 64, 31, 69, 94, 80, 17, 70, 92, 69, 16}, IL1Iii.IL1Iii(new byte[]{83, 3, 84, 95, 1, 81}, IL1Iii.IL1Iii(new byte[]{81, 85, 86, 87, 7, 1}, "d301db"))) + libraryList + IL1Iii.IL1Iii(new byte[]{20}, IL1Iii.IL1Iii(new byte[]{0, 80, 82, 13, 2, 1}, IL1Iii.IL1Iii(new byte[]{5, 95, 85, 80, 10, 14}, "397e96"))));
        Log.d(str, IL1Iii.IL1Iii(new byte[]{32, 93, 65, 65, 69, 19, 7, 64, 71, 87, 92, 67, 18, 20, 71, 93, 17, 95, 9, 85, 87, 18, 93, 90, 4, 71}, IL1Iii.IL1Iii(new byte[]{87, 82, 11, 10, 9, 6}, IL1Iii.IL1Iii(new byte[]{9, 81, 94, 14, 11, 87}, "87f63b"))));
        if (!initOpenCVLibs(libraryList)) {
            Log.d(str, IL1Iii.IL1Iii(new byte[]{36, 93, 65, 23, 17, 25, 3, 64, 71, 1, 8, 73, 22, 20, 71, 11, 69, 85, 13, 85, 87, 68, 9, 80, 0, 71, 19, 2, 4, 80, 14, 71}, IL1Iii.IL1Iii(new byte[]{81, 85, 6, 85, 92, 14}, IL1Iii.IL1Iii(new byte[]{10, 2, 3, 1, 91, 6}, "9c60b1"))));
            return false;
        }
        Log.d(str, IL1Iii.IL1Iii(new byte[]{126, 80, 68, 68, 22, 24, 89, 77, 66, 82, 15, 72, 76, 25, 66, 88, 66, 84, 87, 88, 82, 23, 14, 81, 90, 74, 22, 94, 17, 24, 119, 114}, IL1Iii.IL1Iii(new byte[]{0, 11, 7, 81, 84, 89}, IL1Iii.IL1Iii(new byte[]{93, 2, 2, 85, 83, 84}, "e033e5"))));
        for (String str2 : Core.getBuildInformation().split(System.getProperty(IL1Iii.IL1Iii(new byte[]{85, 11, 10, 7, 79, 17, 92, 18, 5, 16, 0, 22, 86, 16}, IL1Iii.IL1Iii(new byte[]{12, 0, 83, 82, 86, 91}, IL1Iii.IL1Iii(new byte[]{7, 81, 86, 1, 83, 88}, "23a1da")))))) {
            Log.i(TAG, str2);
        }
        return true;
    }

    private static boolean initOpenCVLibs(String str) {
        String str2 = TAG;
        Log.d(str2, IL1Iii.IL1Iii(new byte[]{100, 75, 75, 81, 88, 87, 16, 77, 93, 24, 95, 94, 89, 77, 18, 119, 70, 85, 94, 122, 100, 24, 90, 89, 82, 74}, IL1Iii.IL1Iii(new byte[]{7, 8, 3, 0, 80, 81}, IL1Iii.IL1Iii(new byte[]{15, 1, 1, 13, 3, 80}, "8005e1"))));
        if (str == null || str.length() == 0) {
            return loadLibrary(IL1Iii.IL1Iii(new byte[]{93, 20, 1, 91, 83, 19, 109, 14, 5, 67, 81, 81}, IL1Iii.IL1Iii(new byte[]{84, 84, 93, 1, 7, 86}, IL1Iii.IL1Iii(new byte[]{81, 82, 10, 6, 14, 80}, "7b329c"))));
        }
        Log.d(str2, IL1Iii.IL1Iii(new byte[]{108, 69, 72, 10, 93, 84, 24, 67, 94, 67, 95, 92, 89, 83, 17, 15, 90, 81, 75, 23, 83, 26, 19, 87, 93, 71, 84, 13, 87, 86, 86, 84, 72, 67, 95, 90, 75, 67}, IL1Iii.IL1Iii(new byte[]{9, 5, 6, 91, 3, 4}, IL1Iii.IL1Iii(new byte[]{3, 87, 6, 92, 6, 3}, "2e1d64"))));
        boolean zLoadLibrary = true;
        StringTokenizer stringTokenizer = new StringTokenizer(str, IL1Iii.IL1Iii(new byte[]{8}, IL1Iii.IL1Iii(new byte[]{86, 7, 1, 7, 87, 4}, IL1Iii.IL1Iii(new byte[]{3, 7, 5, 80, 7, 4}, "fdabaa"))));
        while (stringTokenizer.hasMoreTokens()) {
            zLoadLibrary &= loadLibrary(stringTokenizer.nextToken());
        }
        return zLoadLibrary;
    }

    private static boolean loadLibrary(String str) {
        String str2 = TAG;
        Log.d(str2, IL1Iii.IL1Iii(new byte[]{97, 70, 74, 10, 86, 94, 21, 64, 92, 67, 84, 86, 84, 80, 19, 15, 81, 91, 71, 85, 65, 26, 24}, IL1Iii.IL1Iii(new byte[]{12, 7, 86, 6, 10, 11}, IL1Iii.IL1Iii(new byte[]{13, 3, 80, 80, 5, 81}, "40557c"))) + str);
        try {
            System.loadLibrary(str);
            Log.d(str2, IL1Iii.IL1Iii(new byte[]{116, 12, 91, 16, 3, 17, 65, 69}, IL1Iii.IL1Iii(new byte[]{11, 92, 88, 80, 86, 82}, IL1Iii.IL1Iii(new byte[]{85, 1, 0, 7, 3, 84}, "f8a57e"))) + str + IL1Iii.IL1Iii(new byte[]{68, 10, 95, 80, 93, 80, 0}, IL1Iii.IL1Iii(new byte[]{7, 7, 81, 8, 93, 87}, IL1Iii.IL1Iii(new byte[]{85, 5, 82, 11, 5, 80}, "6d32a2"))));
            return true;
        } catch (UnsatisfiedLinkError e) {
            Log.d(TAG, IL1Iii.IL1Iii(new byte[]{33, 89, 11, 91, 88, 64, 66, 84, 10, 84, 83, 20, 14, 81, 7, 71, 86, 70, 27, 24, 71}, IL1Iii.IL1Iii(new byte[]{84, 12, 84, 83, 85, 6}, IL1Iii.IL1Iii(new byte[]{7, 3, 80, 94, 90, 4}, "17a886"))) + str + IL1Iii.IL1Iii(new byte[]{67}, IL1Iii.IL1Iii(new byte[]{0, 1, 95, 5, 2, 85}, IL1Iii.IL1Iii(new byte[]{86, 15, 95, 82, 4, 6}, "799d25"))));
            e.printStackTrace();
            return false;
        }
    }
}
