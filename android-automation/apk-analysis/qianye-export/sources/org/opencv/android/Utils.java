package org.opencv.android;

import I1I.IL1Iii;
import android.content.Context;
import android.graphics.Bitmap;
import java.io.ByteArrayOutputStream;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import org.opencv.core.CvException;
import org.opencv.core.Mat;
import org.opencv.imgcodecs.Imgcodecs;

/* JADX INFO: loaded from: classes.dex */
public class Utils {
    public static void bitmapToMat(Bitmap bitmap, Mat mat, boolean z) {
        if (bitmap == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{91, 12, 69, 66, 88, 13, 25, 15, 64, 14, 9}, IL1Iii.IL1Iii(new byte[]{11, 88, 12, 83, 1, 9}, IL1Iii.IL1Iii(new byte[]{80, 91, 12, 4, 86, 0}, "bb5529"))));
        }
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{95, 5, 71, 66, 9, 10, 18, 10, 70, 14, 88}, IL1Iii.IL1Iii(new byte[]{81, 92, 11, 87, 6, 81}, IL1Iii.IL1Iii(new byte[]{7, 15, 0, 3, 80, 95}, "d786b9"))));
        }
        nBitmapToMat2(bitmap, mat.nativeObj, z);
    }

    public static String exportResource(Context context, int i) {
        return exportResource(context, i, IL1Iii.IL1Iii(new byte[]{126, 73, 4, 91, 122, 102, 110, 93, 0, 65, 88}, IL1Iii.IL1Iii(new byte[]{8, 9, 84, 80, 8, 85}, IL1Iii.IL1Iii(new byte[]{12, 3, 86, 85, 3, 87}, "53c022"))));
    }

    public static Mat loadResource(Context context, int i) throws IOException {
        return loadResource(context, i, -1);
    }

    public static void matToBitmap(Mat mat, Bitmap bitmap, boolean z) {
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{93, 82, 70, 25, 92, 95, 16, 93, 71, 85, 13}, IL1Iii.IL1Iii(new byte[]{7, 81, 81, 95, 86, 6}, IL1Iii.IL1Iii(new byte[]{86, 4, 83, 81, 82, 83}, "af07e7"))));
        }
        if (bitmap == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{83, 92, 70, 19, 94, 92, 17, 95, 67, 95, 15}, IL1Iii.IL1Iii(new byte[]{80, 87, 6, 4, 0, 83}, IL1Iii.IL1Iii(new byte[]{2, 3, 84, 86, 1, 2}, "cedab0"))));
        }
        nMatToBitmap2(mat.nativeObj, bitmap, z);
    }

    private static native void nBitmapToMat2(Bitmap bitmap, long j, boolean z);

    private static native void nMatToBitmap2(long j, Bitmap bitmap, boolean z);

    public static String exportResource(Context context, int i, String str) {
        String string = context.getResources().getString(i);
        String strSubstring = string.substring(string.lastIndexOf(IL1Iii.IL1Iii(new byte[]{30}, IL1Iii.IL1Iii(new byte[]{6, 81, 6, 9, 9, 3}, IL1Iii.IL1Iii(new byte[]{7, 85, 84, 9, 7, 1}, "0fc071")))) + 1);
        try {
            InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
            File file = new File(context.getDir(str, 0), strSubstring);
            FileOutputStream fileOutputStream = new FileOutputStream(file);
            byte[] bArr = new byte[4096];
            while (true) {
                int i2 = inputStreamOpenRawResource.read(bArr);
                if (i2 == -1) {
                    inputStreamOpenRawResource.close();
                    fileOutputStream.close();
                    return file.getAbsolutePath();
                }
                fileOutputStream.write(bArr, 0, i2);
            }
        } catch (IOException e) {
            e.printStackTrace();
            throw new CvException(IL1Iii.IL1Iii(new byte[]{115, 89, 10, 85, 7, 81, 21, 76, 12, 25, 7, 77, 69, 87, 17, 77, 66, 71, 80, 75, 12, 76, 16, 86, 80, 24}, IL1Iii.IL1Iii(new byte[]{86, 90, 0, 12, 85, 87}, IL1Iii.IL1Iii(new byte[]{91, 3, 81, 6, 7, 0}, "8a230b"))) + strSubstring + IL1Iii.IL1Iii(new byte[]{30, 22, 113, 76, 85, 82, 64, 66, 93, 91, 88, 23, 68, 94, 70, 91, 65, 89, 10, 22}, IL1Iii.IL1Iii(new byte[]{81, 15, 86, 3, 85, 86}, IL1Iii.IL1Iii(new byte[]{85, 9, 86, 4, 82, 80}, "404311"))) + e);
        }
    }

    public static Mat loadResource(Context context, int i, int i2) throws IOException {
        InputStream inputStreamOpenRawResource = context.getResources().openRawResource(i);
        ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream(inputStreamOpenRawResource.available());
        byte[] bArr = new byte[4096];
        while (true) {
            int i3 = inputStreamOpenRawResource.read(bArr);
            if (i3 == -1) {
                inputStreamOpenRawResource.close();
                Mat mat = new Mat(1, byteArrayOutputStream.size(), 0);
                mat.put(0, 0, byteArrayOutputStream.toByteArray());
                byteArrayOutputStream.close();
                Mat matImdecode = Imgcodecs.imdecode(mat, i2);
                mat.release();
                return matImdecode;
            }
            byteArrayOutputStream.write(bArr, 0, i3);
        }
    }

    public static void bitmapToMat(Bitmap bitmap, Mat mat) {
        bitmapToMat(bitmap, mat, false);
    }

    public static void matToBitmap(Mat mat, Bitmap bitmap) {
        matToBitmap(mat, bitmap, false);
    }
}
