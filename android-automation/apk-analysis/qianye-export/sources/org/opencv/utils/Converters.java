package org.opencv.utils;

import I1I.IL1Iii;
import com.mysql.jdbc.MysqlDefs;
import java.util.ArrayList;
import java.util.List;
import org.opencv.core.CvType;
import org.opencv.core.DMatch;
import org.opencv.core.KeyPoint;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.MatOfPoint;
import org.opencv.core.MatOfPoint2f;
import org.opencv.core.MatOfPoint3f;
import org.opencv.core.Point;
import org.opencv.core.Point3;
import org.opencv.core.Rect;
import org.opencv.core.Rect2d;
import org.opencv.core.RotatedRect;
import org.opencv.core.Size;

/* JADX INFO: loaded from: classes.dex */
public class Converters {
    public static void Mat_to_vector_DMatch(Mat mat, List<DMatch> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{121, 66, 21, 19, 68, 17, 22, 123, 8, 16, 69, 69, 85, 86, 15, 68, 69, 69, 84, 82, 65, 13, 68, 9, 90}, IL1Iii.IL1Iii(new byte[]{6, 86, 82, 85, 8, 87}, IL1Iii.IL1Iii(new byte[]{85, 82, 85, 15, 0, 1}, "e3f993"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{119, 20, 53, 28, 17, 80, 26, 33, 55, 58, 87, 1, 114, 33, 85, 69, 64, 8, 20, 15, 79, 17, 24, 69, 81, 74, 72, 69, 29, 73, 20, 66, 12, 75, 2, 90, 88, 17, 73, 76, 64, 8, 5, 104}, IL1Iii.IL1Iii(new byte[]{7, 6, 2, 87, 89, 84}, IL1Iii.IL1Iii(new byte[]{6, 82, 7, 84, 93, 85}, "56dfe4"))) + mat);
        }
        list.clear();
        double[] dArr = new double[iRows * 4];
        mat.get(0, 0, dArr);
        for (int i = 0; i < iRows; i++) {
            int i2 = i * 4;
            list.add(new DMatch((int) dArr[i2], (int) dArr[i2 + 1], (int) dArr[i2 + 2], (float) dArr[i2 + 3]));
        }
    }

    public static void Mat_to_vector_KeyPoint(Mat mat, List<KeyPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{44, 77, 67, 73, 20, 16, 67, 116, 94, 74, 21, 68, 0, 89, 89, 30, 21, 68, 1, 93, 23, 87, 20, 8, 15}, IL1Iii.IL1Iii(new byte[]{80, 94, 3, 1, 7, 5}, IL1Iii.IL1Iii(new byte[]{10, 94, 13, 15, 82, 88}, "989749"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC(7) != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{39, 23, 50, 24, 66, 6, 74, 34, 48, 62, 4, 87, 34, 34, 78, 86, 27, 67, 69, 92, 70, 12, 28, 23, 29, 17, 3, 73, 27, 67, 24, 29, 70, 65, 95, 77, 7, 14, 10, 18, 26, 74, 69, 92, 87, 107}, IL1Iii.IL1Iii(new byte[]{2, 5, 3, 4, 10, 1}, IL1Iii.IL1Iii(new byte[]{5, 82, 83, 87, 8, 4}, "c6620f"))) + mat);
        }
        list.clear();
        double[] dArr = new double[iRows * 7];
        mat.get(0, 0, dArr);
        for (int i = 0; i < iRows; i++) {
            int i2 = i * 7;
            list.add(new KeyPoint((float) dArr[i2], (float) dArr[i2 + 1], (float) dArr[i2 + 2], (float) dArr[i2 + 3], (float) dArr[i2 + 4], (int) dArr[i2 + 5], (int) dArr[i2 + 6]));
        }
    }

    public static void Mat_to_vector_Mat(Mat mat, List<Mat> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{88, 89, 23, 17, 69, 94, 8, 24, 13, 23, 9, 15}, IL1Iii.IL1Iii(new byte[]{87, 12, 81, 80, 0, 7}, IL1Iii.IL1Iii(new byte[]{91, 6, 84, 10, 81, 87}, "92f843"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_32SC2 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{39, 69, 100, 73, 20, 7, 74, 112, 102, 111, 87, 80, 55, 112, 2, 16, 69, 95, 68, 94, 30, 68, 29, 18, 1, 27, 25, 16, 24, 30, 68, 19, 93, 30, 7, 13, 8, 64, 24, 25, 69, 95, 85, 57}, IL1Iii.IL1Iii(new byte[]{1, 87, 86, 9, 84, 1}, IL1Iii.IL1Iii(new byte[]{7, 85, 0, 91, 83, 84}, "b1fbc7"))) + mat);
        }
        list.clear();
        int[] iArr = new int[iRows * 2];
        mat.get(0, 0, iArr);
        for (int i = 0; i < iRows; i++) {
            int i2 = i * 2;
            list.add(new Mat((((long) iArr[i2]) << 32) | (((long) iArr[i2 + 1]) & MysqlDefs.LENGTH_LONGBLOB)));
        }
    }

    public static void Mat_to_vector_Point(Mat mat, List<Point> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{127, 20, 76, 22, 22, 67, 16, 45, 81, 21, 23, 23, 83, 0, 86, 65, 23, 23, 82, 4, 24, 8, 22, 91, 92}, IL1Iii.IL1Iii(new byte[]{3, 87, 94, 80, 87, 85}, IL1Iii.IL1Iii(new byte[]{5, 5, 81, 6, 7, 85}, "637037"))));
        }
        int iRows = mat.rows();
        int iType = mat.type();
        if (mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{44, 91, 65, 17, 22, 65, 40, 84, 69, 68, 17, 9, 10, 64, 93, 0, 66, 9, 4, 67, 84, 68, 13, 15, 0, 21, 82, 11, 14, 20, 8, 91, 59}, IL1Iii.IL1Iii(new byte[]{7, 81, 87, 92, 83, 87}, IL1Iii.IL1Iii(new byte[]{4, 93, 80, 90, 84, 85}, "f96bec"))) + mat);
        }
        list.clear();
        int i = 0;
        if (iType == CvType.CV_32SC2) {
            int[] iArr = new int[iRows * 2];
            mat.get(0, 0, iArr);
            while (i < iRows) {
                int i2 = i * 2;
                list.add(new Point(iArr[i2], iArr[i2 + 1]));
                i++;
            }
            return;
        }
        if (iType == CvType.CV_32FC2) {
            float[] fArr = new float[iRows * 2];
            mat.get(0, 0, fArr);
            while (i < iRows) {
                int i3 = i * 2;
                list.add(new Point(fArr[i3], fArr[i3 + 1]));
                i++;
            }
            return;
        }
        if (iType != CvType.CV_64FC2) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{44, 92, 68, 16, 77, 25, 40, 83, 64, 69, 74, 81, 10, 71, 88, 1, 25, 91, 0, 18, 91, 3, 25, 122, 51, 109, 7, 87, 106, 122, 87, 30, 20, 38, 111, 102, 86, 0, 114, 38, 11, 25, 10, 64, 20, 38, 111, 102, 83, 6, 114, 38, 11, 25, 17, 75, 68, 0, 51}, IL1Iii.IL1Iii(new byte[]{85, 7, 4, 93, 92, 1}, IL1Iii.IL1Iii(new byte[]{6, 87, 3, 14, 81, 11}, "6b3643"))) + mat);
        }
        double[] dArr = new double[iRows * 2];
        mat.get(0, 0, dArr);
        while (i < iRows) {
            int i4 = i * 2;
            list.add(new Point(dArr[i4], dArr[i4 + 1]));
            i++;
        }
    }

    public static void Mat_to_vector_Point2d(Mat mat, List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }

    public static void Mat_to_vector_Point2f(Mat mat, List<Point> list) {
        Mat_to_vector_Point(mat, list);
    }

    public static void Mat_to_vector_Point3(Mat mat, List<Point3> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{124, 17, 69, 64, 19, 21, 19, 40, 88, 67, 18, 65, 80, 5, 95, 23, 18, 65, 81, 1, 17, 94, 19, 13, 95}, IL1Iii.IL1Iii(new byte[]{7, 85, 5, 6, 94, 3}, IL1Iii.IL1Iii(new byte[]{7, 6, 4, 0, 9, 86}, "370614"))));
        }
        int iRows = mat.rows();
        int iType = mat.type();
        if (mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{113, 12, 18, 64, 65, 23, 117, 3, 22, 21, 70, 95, 87, 23, 14, 81, 21, 95, 89, 20, 7, 21, 90, 89, 93, 66, 1, 90, 89, 66, 85, 12, 104}, IL1Iii.IL1Iii(new byte[]{14, 83, 83, 5, 12, 7}, IL1Iii.IL1Iii(new byte[]{2, 4, 4, 2, 12, 2}, "455252"))) + mat);
        }
        list.clear();
        int i = 0;
        if (iType == CvType.CV_32SC3) {
            int[] iArr = new int[iRows * 3];
            mat.get(0, 0, iArr);
            while (i < iRows) {
                int i2 = i * 3;
                list.add(new Point3(iArr[i2], iArr[i2 + 1], iArr[i2 + 2]));
                i++;
            }
            return;
        }
        if (iType == CvType.CV_32FC3) {
            float[] fArr = new float[iRows * 3];
            mat.get(0, 0, fArr);
            while (i < iRows) {
                int i3 = i * 3;
                list.add(new Point3(fArr[i3], fArr[i3 + 1], fArr[i3 + 2]));
                i++;
            }
            return;
        }
        if (iType != CvType.CV_64FC3) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{125, 8, 17, 17, 65, 21, 121, 7, 21, 68, 70, 93, 91, 19, 13, 0, 21, 87, 81, 70, 14, 2, 21, 118, 98, 57, 82, 86, 102, 118, 7, 74, 65, 39, 99, 106, 7, 84, 39, 39, 6, 21, 91, 20, 65, 39, 99, 106, 2, 82, 39, 39, 6, 21, 64, 31, 17, 1, 63}, IL1Iii.IL1Iii(new byte[]{87, 81, 5, 80, 84, 3}, IL1Iii.IL1Iii(new byte[]{84, 86, 86, 82, 5, 7}, "7a2fd1"))) + mat);
        }
        double[] dArr = new double[iRows * 3];
        mat.get(0, 0, dArr);
        while (i < iRows) {
            int i4 = i * 3;
            list.add(new Point3(dArr[i4], dArr[i4 + 1], dArr[i4 + 2]));
            i++;
        }
    }

    public static void Mat_to_vector_Point3d(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Point3f(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Point3i(Mat mat, List<Point3> list) {
        Mat_to_vector_Point3(mat, list);
    }

    public static void Mat_to_vector_Rect(Mat mat, List<Rect> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{71, 67, 25, 12, 91, 67, 91, 69, 85, 93}, IL1Iii.IL1Iii(new byte[]{2, 8, 12, 6, 3, 90}, IL1Iii.IL1Iii(new byte[]{3, 1, 2, 85, 87, 0}, "497b29"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_32SC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{116, 66, 100, 27, 18, 7, 25, 119, 102, 61, 81, 80, 100, 119, 4, 66, 67, 95, 23, 89, 30, 22, 27, 18, 82, 28, 25, 66, 30, 30, 23, 20, 93, 76, 16, 13, 64, 71, 24, 75, 67, 95, 6, 62}, IL1Iii.IL1Iii(new byte[]{83, 81, 6, 84, 83, 82}, IL1Iii.IL1Iii(new byte[]{6, 1, 0, 1, 85, 83}, "bd67dc"))) + mat);
        }
        list.clear();
        int[] iArr = new int[iRows * 4];
        mat.get(0, 0, iArr);
        for (int i = 0; i < iRows; i++) {
            int i2 = i * 4;
            list.add(new Rect(iArr[i2], iArr[i2 + 1], iArr[i2 + 2], iArr[i2 + 3]));
        }
    }

    public static void Mat_to_vector_Rect2d(Mat mat, List<Rect2d> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{68, 66, 70, 8, 91, 68, 88, 68, 10, 89}, IL1Iii.IL1Iii(new byte[]{2, 83, 2, 12, 95, 86}, IL1Iii.IL1Iii(new byte[]{5, 81, 6, 88, 15, 84}, "13ba6f"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC4 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{116, 21, 54, 64, 20, 87, 25, 32, 52, 102, 82, 6, 113, 32, 86, 25, 69, 15, 23, 14, 76, 77, 29, 66, 82, 75, 75, 25, 24, 78, 23, 67, 15, 23, 22, 93, 64, 16, 74, 16, 69, 15, 6, 105}, IL1Iii.IL1Iii(new byte[]{6, 0, 85, 14, 2, 83}, IL1Iii.IL1Iii(new byte[]{6, 81, 15, 0, 4, 83}, "7287b2"))) + mat);
        }
        list.clear();
        double[] dArr = new double[iRows * 4];
        mat.get(0, 0, dArr);
        for (int i = 0; i < iRows; i++) {
            int i2 = i * 4;
            list.add(new Rect2d(dArr[i2], dArr[i2 + 1], dArr[i2 + 2], dArr[i2 + 3]));
        }
    }

    public static void Mat_to_vector_RotatedRect(Mat mat, List<RotatedRect> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{23, 69, 65, 15, 9, 21, 11, 67, 13, 94}, IL1Iii.IL1Iii(new byte[]{80, 7, 2, 10, 12, 86}, IL1Iii.IL1Iii(new byte[]{13, 6, 84, 89, 91, 87}, "877ac4"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_32FC(5) != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{123, 64, 109, 27, 17, 92, 22, 117, 111, 61, 82, 11, 126, 117, 12, 66, 64, 4, 24, 91, 23, 22, 24, 73, 93, 30, 16, 66, 29, 69, 24, 22, 84, 76, 19, 86, 79, 69, 17, 75, 64, 4, 9, 60}, IL1Iii.IL1Iii(new byte[]{13, 84, 11, 86, 4, 13}, IL1Iii.IL1Iii(new byte[]{81, 3, 80, 81, 80, 81}, "dabe5e"))) + mat);
        }
        list.clear();
        float[] fArr = new float[iRows * 5];
        mat.get(0, 0, fArr);
        for (int i = 0; i < iRows; i++) {
            int i2 = i * 5;
            list.add(new RotatedRect(new Point(fArr[i2], fArr[i2 + 1]), new Size(fArr[i2 + 2], fArr[i2 + 3]), fArr[i2 + 4]));
        }
    }

    public static void Mat_to_vector_char(Mat mat, List<Byte> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{43, 71, 71, 21, 66, 77, 68, 126, 90, 22, 67, 25, 7, 83, 93, 66, 67, 25, 6, 87, 19, 11, 66, 85, 8}, IL1Iii.IL1Iii(new byte[]{5, 84, 2, 80, 82, 88}, IL1Iii.IL1Iii(new byte[]{84, 86, 84, 86, 6, 5}, "50eccd"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_8SC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{33, 71, 54, 29, 18, 87, 76, 114, 52, 59, 90, 97, 33, 0, 66, 69, 95, 18, 15, 31, 22, 29, 18, 87, 74, 24, 66, 24, 30, 18, 66, 92, 76, 7, 13, 94, 17, 25, 75, 69, 95, 3, 104}, IL1Iii.IL1Iii(new byte[]{86, 85, 91, 84, 90, 7}, IL1Iii.IL1Iii(new byte[]{1, 83, 1, 84, 91, 84}, "578dca"))) + mat);
        }
        list.clear();
        byte[] bArr = new byte[iRows];
        mat.get(0, 0, bArr);
        for (int i = 0; i < iRows; i++) {
            list.add(Byte.valueOf(bArr[i]));
        }
    }

    public static void Mat_to_vector_double(Mat mat, List<Double> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{82, 71, 16, 9, 9, 19, 88, 65, 92, 88}, IL1Iii.IL1Iii(new byte[]{1, 7, 85, 82, 13, 2}, IL1Iii.IL1Iii(new byte[]{3, 4, 4, 84, 1, 84}, "47a28e"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_64FC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{118, 16, 53, 31, 67, 0, 27, 37, 55, 57, 5, 81, 115, 37, 80, 70, 18, 88, 21, 11, 79, 18, 74, 21, 80, 78, 72, 70, 79, 25, 21, 70, 12, 72, 80, 10, 89, 21, 73, 79, 18, 88, 4, 108}, IL1Iii.IL1Iii(new byte[]{83, 0, 81, 95, 86, 84}, IL1Iii.IL1Iii(new byte[]{80, 85, 84, 15, 84, 84}, "63d61e"))) + mat);
        }
        list.clear();
        double[] dArr = new double[iRows];
        mat.get(0, 0, dArr);
        for (int i = 0; i < iRows; i++) {
            list.add(Double.valueOf(dArr[i]));
        }
    }

    public static void Mat_to_vector_float(Mat mat, List<Float> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{80, 22, 18, 91, 15, 68, 88, 16, 94, 10}, IL1Iii.IL1Iii(new byte[]{83, 83, 3, 82, 84, 5}, IL1Iii.IL1Iii(new byte[]{92, 14, 4, 3, 5, 2}, "9857cc"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_32FC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{116, 69, 108, 72, 64, 3, 25, 112, 110, 110, 3, 84, 113, 112, 9, 17, 17, 91, 23, 94, 22, 69, 73, 22, 82, 27, 17, 17, 76, 26, 23, 19, 85, 31, 83, 9, 91, 64, 16, 24, 17, 91, 6, 57}, IL1Iii.IL1Iii(new byte[]{1, 10, 13, 82, 85, 0}, IL1Iii.IL1Iii(new byte[]{85, 8, 0, 1, 85, 3}, "c15b0e"))) + mat);
        }
        list.clear();
        float[] fArr = new float[iRows];
        mat.get(0, 0, fArr);
        for (int i = 0; i < iRows; i++) {
            list.add(Float.valueOf(fArr[i]));
        }
    }

    public static void Mat_to_vector_int(Mat mat, List<Integer> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{8, 68, 22, 12, 9, 25, 15, 66, 90, 93}, IL1Iii.IL1Iii(new byte[]{87, 4, 83, 9, 5, 9}, IL1Iii.IL1Iii(new byte[]{2, 86, 1, 90, 84, 5}, "4edbe5"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_32SC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{116, 64, 54, 64, 22, 92, 25, 117, 52, 102, 85, 11, 100, 117, 83, 25, 71, 4, 23, 91, 76, 77, 31, 73, 82, 30, 75, 25, 26, 69, 23, 22, 15, 23, 5, 86, 91, 69, 74, 16, 71, 4, 6, 60}, IL1Iii.IL1Iii(new byte[]{4, 2, 90, 9, 4, 88}, IL1Iii.IL1Iii(new byte[]{7, 82, 89, 84, 90, 5}, "4fad8d"))) + mat);
        }
        list.clear();
        int[] iArr = new int[iRows];
        mat.get(0, 0, iArr);
        for (int i = 0; i < iRows; i++) {
            list.add(Integer.valueOf(iArr[i]));
        }
    }

    public static void Mat_to_vector_uchar(Mat mat, List<Byte> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{45, 65, 66, 22, 66, 23, 66, 120, 95, 21, 67, 67, 1, 85, 88, 65, 67, 67, 0, 81, 22, 8, 66, 15, 14}, IL1Iii.IL1Iii(new byte[]{85, 87, 80, 3, 85, 91}, IL1Iii.IL1Iii(new byte[]{7, 6, 3, 92, 84, 13}, "0ee965"))));
        }
        int iRows = mat.rows();
        if (CvType.CV_8UC1 != mat.type() || mat.cols() != 1) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{33, 18, 50, 77, 21, 81, 76, 39, 48, 107, 93, 97, 33, 85, 70, 21, 88, 20, 15, 74, 18, 77, 21, 81, 74, 77, 70, 72, 25, 20, 66, 9, 72, 87, 10, 88, 17, 76, 79, 21, 88, 5, 104}, IL1Iii.IL1Iii(new byte[]{4, 80, 4, 87, 92, 6}, IL1Iii.IL1Iii(new byte[]{94, 85, 85, 86, 8, 80}, "8a751b"))) + mat);
        }
        list.clear();
        byte[] bArr = new byte[iRows];
        mat.get(0, 0, bArr);
        for (int i = 0; i < iRows; i++) {
            list.add(Byte.valueOf(bArr[i]));
        }
    }

    public static void Mat_to_vector_vector_DMatch(Mat mat, List<MatOfDMatch> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{46, 23, 18, 72, 65, 22, 65, 46, 15, 75, 64, 66, 2, 3, 8, 31, 64, 66, 3, 7, 70, 86, 65, 14, 13}, IL1Iii.IL1Iii(new byte[]{82, 85, 94, 14, 13, 86}, IL1Iii.IL1Iii(new byte[]{0, 0, 89, 3, 13, 2}, "37a546"))));
        }
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{127, 90, 73, 19, 21, 67, 123, 85, 77, 70, 2, 2, 88, 19, 77, 70, 3, 6, 22, 90, 76, 10, 13}, IL1Iii.IL1Iii(new byte[]{82, 81, 15, 0, 0, 90}, IL1Iii.IL1Iii(new byte[]{81, 86, 3, 4, 80, 91}, "535b1b"))));
        }
        ArrayList<Mat> arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        list.clear();
        for (Mat mat2 : arrayList) {
            list.add(new MatOfDMatch(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_KeyPoint(Mat mat, List<MatOfKeyPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{41, 65, 18, 19, 19, 18, 70, 120, 15, 16, 18, 70, 5, 85, 8, 68, 18, 70, 4, 81, 70, 13, 19, 10, 10}, IL1Iii.IL1Iii(new byte[]{83, 81, 7, 2, 0, 84}, IL1Iii.IL1Iii(new byte[]{3, 80, 88, 86, 5, 81}, "6597cc"))));
        }
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{124, 95, 72, 70, 77, 66, 120, 80, 76, 19, 90, 3, 91, 22, 76, 19, 91, 7, 21, 95, 77, 95, 85}, IL1Iii.IL1Iii(new byte[]{7, 2, 15, 87, 88, 4}, IL1Iii.IL1Iii(new byte[]{87, 11, 15, 82, 89, 86}, "e88680"))));
        }
        ArrayList<Mat> arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        for (Mat mat2 : arrayList) {
            list.add(new MatOfKeyPoint(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_Point(Mat mat, List<MatOfPoint> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{125, 71, 21, 18, 70, 16, 18, 126, 8, 17, 71, 68, 81, 83, 15, 69, 71, 68, 80, 87, 65, 12, 70, 8, 94}, IL1Iii.IL1Iii(new byte[]{0, 10, 84, 91, 85, 5}, IL1Iii.IL1Iii(new byte[]{83, 13, 12, 12, 94, 83}, "a59582"))));
        }
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{113, 88, 71, 66, 69, 69, 117, 87, 67, 23, 82, 4, 86, 17, 67, 23, 83, 0, 24, 88, 66, 91, 93}, IL1Iii.IL1Iii(new byte[]{13, 3, 2, 84, 3, 6}, IL1Iii.IL1Iii(new byte[]{84, 1, 4, 1, 7, 1}, "a41b5b"))));
        }
        ArrayList<Mat> arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        for (Mat mat2 : arrayList) {
            list.add(new MatOfPoint(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_Point2f(Mat mat, List<MatOfPoint2f> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{42, 68, 22, 19, 69, 18, 69, 125, 11, 16, 68, 70, 6, 80, 12, 68, 68, 70, 7, 84, 66, 13, 69, 10, 9}, IL1Iii.IL1Iii(new byte[]{83, 4, 6, 91, 82, 87}, IL1Iii.IL1Iii(new byte[]{82, 5, 0, 12, 81, 3}, "d0d432"))));
        }
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{124, 87, 19, 67, 70, 19, 120, 88, 23, 22, 81, 82, 91, 30, 23, 22, 80, 86, 21, 87, 22, 90, 94}, IL1Iii.IL1Iii(new byte[]{80, 88, 82, 5, 80, 5}, IL1Iii.IL1Iii(new byte[]{82, 85, 6, 86, 80, 2}, "747e24"))));
        }
        ArrayList<Mat> arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        for (Mat mat2 : arrayList) {
            list.add(new MatOfPoint2f(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_Point3f(Mat mat, List<MatOfPoint3f> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{120, 23, 66, 73, 22, 68, 23, 46, 95, 74, 23, 16, 84, 3, 88, 30, 23, 16, 85, 7, 22, 87, 22, 92, 91}, IL1Iii.IL1Iii(new byte[]{2, 6, 3, 0, 81, 86}, IL1Iii.IL1Iii(new byte[]{0, 87, 7, 92, 83, 4}, "532eab"))));
        }
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{124, 13, 66, 71, 18, 22, 120, 2, 70, 18, 5, 87, 91, 68, 70, 18, 4, 83, 21, 13, 71, 94, 10}, IL1Iii.IL1Iii(new byte[]{0, 91, 87, 6, 83, 14}, IL1Iii.IL1Iii(new byte[]{7, 89, 0, 82, 5, 91}, "2aef0c"))));
        }
        ArrayList<Mat> arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        for (Mat mat2 : arrayList) {
            list.add(new MatOfPoint3f(mat2));
            mat2.release();
        }
        arrayList.clear();
    }

    public static void Mat_to_vector_vector_char(Mat mat, List<List<Byte>> list) {
        if (list == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{46, 70, 16, 18, 19, 65, 65, 127, 13, 17, 18, 21, 2, 82, 10, 69, 18, 21, 3, 86, 68, 12, 19, 89, 13}, IL1Iii.IL1Iii(new byte[]{7, 4, 85, 6, 7, 1}, IL1Iii.IL1Iii(new byte[]{94, 1, 9, 1, 5, 7}, "868ed3"))));
        }
        if (mat == null) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{127, 87, 73, 76, 70, 20, 123, 88, 77, 25, 81, 85, 88, 30, 77, 25, 80, 81, 22, 87, 76, 85, 94}, IL1Iii.IL1Iii(new byte[]{85, 15, 1, 9, 2, 3}, IL1Iii.IL1Iii(new byte[]{82, 14, 8, 4, 7, 84}, "18047c"))));
        }
        ArrayList<Mat> arrayList = new ArrayList(mat.rows());
        Mat_to_vector_Mat(mat, arrayList);
        for (Mat mat2 : arrayList) {
            ArrayList arrayList2 = new ArrayList();
            Mat_to_vector_char(mat2, arrayList2);
            list.add(arrayList2);
            mat2.release();
        }
        arrayList.clear();
    }

    public static Mat vector_DMatch_to_Mat(List<DMatch> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC4);
        double[] dArr = new double[size * 4];
        for (int i = 0; i < size; i++) {
            DMatch dMatch = list.get(i);
            int i2 = i * 4;
            dArr[i2] = dMatch.queryIdx;
            dArr[i2 + 1] = dMatch.trainIdx;
            dArr[i2 + 2] = dMatch.imgIdx;
            dArr[i2 + 3] = dMatch.distance;
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_KeyPoint_to_Mat(List<KeyPoint> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC(7));
        double[] dArr = new double[size * 7];
        for (int i = 0; i < size; i++) {
            KeyPoint keyPoint = list.get(i);
            int i2 = i * 7;
            Point point = keyPoint.f888pt;
            dArr[i2] = point.f898x;
            dArr[i2 + 1] = point.f899y;
            dArr[i2 + 2] = keyPoint.size;
            dArr[i2 + 3] = keyPoint.angle;
            dArr[i2 + 4] = keyPoint.response;
            dArr[i2 + 5] = keyPoint.octave;
            dArr[i2 + 6] = keyPoint.class_id;
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_Mat_to_Mat(List<Mat> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32SC2);
        int[] iArr = new int[size * 2];
        for (int i = 0; i < size; i++) {
            long j = list.get(i).nativeObj;
            int i2 = i * 2;
            iArr[i2] = (int) (j >> 32);
            iArr[i2 + 1] = (int) (j & (-1));
        }
        mat.put(0, 0, iArr);
        return mat;
    }

    public static Mat vector_Point2d_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 6);
    }

    public static Mat vector_Point2f_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 5);
    }

    public static Mat vector_Point3_to_Mat(List<Point3> list, int i) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        if (i == 4) {
            Mat mat = new Mat(size, 1, CvType.CV_32SC3);
            int[] iArr = new int[size * 3];
            for (int i2 = 0; i2 < size; i2++) {
                Point3 point3 = list.get(i2);
                int i3 = i2 * 3;
                iArr[i3] = (int) point3.f900x;
                iArr[i3 + 1] = (int) point3.f901y;
                iArr[i3 + 2] = (int) point3.f902z;
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        if (i == 5) {
            Mat mat2 = new Mat(size, 1, CvType.CV_32FC3);
            float[] fArr = new float[size * 3];
            for (int i4 = 0; i4 < size; i4++) {
                Point3 point4 = list.get(i4);
                int i5 = i4 * 3;
                fArr[i5] = (float) point4.f900x;
                fArr[i5 + 1] = (float) point4.f901y;
                fArr[i5 + 2] = (float) point4.f902z;
            }
            mat2.put(0, 0, fArr);
            return mat2;
        }
        if (i != 6) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{17, 16, 64, 20, 1, 125, 83, 20, 77, 12, 67, 25, 85, 5, 87, 68, 6, 92, 22, 39, 111, 59, 87, 11, 101, 72, 25, 39, 50, 102, 5, 86, 127, 68, 11, 75, 22, 39, 111, 59, 82, 13, 112}, IL1Iii.IL1Iii(new byte[]{1, 92, 1, 7, 0, 13}, IL1Iii.IL1Iii(new byte[]{1, 89, 13, 84, 6, 82}, "6a57bf"))));
        }
        Mat mat3 = new Mat(size, 1, CvType.CV_64FC3);
        double[] dArr = new double[size * 3];
        for (int i6 = 0; i6 < size; i6++) {
            Point3 point5 = list.get(i6);
            int i7 = i6 * 3;
            dArr[i7] = point5.f900x;
            dArr[i7 + 1] = point5.f901y;
            dArr[i7 + 2] = point5.f902z;
        }
        mat3.put(0, 0, dArr);
        return mat3;
    }

    public static Mat vector_Point3d_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 6);
    }

    public static Mat vector_Point3f_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 5);
    }

    public static Mat vector_Point3i_to_Mat(List<Point3> list) {
        return vector_Point3_to_Mat(list, 4);
    }

    public static Mat vector_Point_to_Mat(List<Point> list) {
        return vector_Point_to_Mat(list, 4);
    }

    public static Mat vector_Rect2d_to_Mat(List<Rect2d> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC4);
        double[] dArr = new double[size * 4];
        for (int i = 0; i < size; i++) {
            Rect2d rect2d = list.get(i);
            int i2 = i * 4;
            dArr[i2] = rect2d.f905x;
            dArr[i2 + 1] = rect2d.f906y;
            dArr[i2 + 2] = rect2d.width;
            dArr[i2 + 3] = rect2d.height;
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_Rect_to_Mat(List<Rect> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32SC4);
        int[] iArr = new int[size * 4];
        for (int i = 0; i < size; i++) {
            Rect rect = list.get(i);
            int i2 = i * 4;
            iArr[i2] = rect.f903x;
            iArr[i2 + 1] = rect.f904y;
            iArr[i2 + 2] = rect.width;
            iArr[i2 + 3] = rect.height;
        }
        mat.put(0, 0, iArr);
        return mat;
    }

    public static Mat vector_RotatedRect_to_Mat(List<RotatedRect> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32FC(5));
        float[] fArr = new float[size * 5];
        for (int i = 0; i < size; i++) {
            RotatedRect rotatedRect = list.get(i);
            int i2 = i * 5;
            Point point = rotatedRect.center;
            fArr[i2] = (float) point.f898x;
            fArr[i2 + 1] = (float) point.f899y;
            Size size2 = rotatedRect.size;
            fArr[i2 + 2] = (float) size2.width;
            fArr[i2 + 3] = (float) size2.height;
            fArr[i2 + 4] = (float) rotatedRect.angle;
        }
        mat.put(0, 0, fArr);
        return mat;
    }

    public static Mat vector_char_to_Mat(List<Byte> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_8SC1);
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = list.get(i).byteValue();
        }
        mat.put(0, 0, bArr);
        return mat;
    }

    public static Mat vector_double_to_Mat(List<Double> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_64FC1);
        double[] dArr = new double[size];
        for (int i = 0; i < size; i++) {
            dArr[i] = list.get(i).doubleValue();
        }
        mat.put(0, 0, dArr);
        return mat;
    }

    public static Mat vector_float_to_Mat(List<Float> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32FC1);
        float[] fArr = new float[size];
        for (int i = 0; i < size; i++) {
            fArr[i] = list.get(i).floatValue();
        }
        mat.put(0, 0, fArr);
        return mat;
    }

    public static Mat vector_int_to_Mat(List<Integer> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_32SC1);
        int[] iArr = new int[size];
        for (int i = 0; i < size; i++) {
            iArr[i] = list.get(i).intValue();
        }
        mat.put(0, 0, iArr);
        return mat;
    }

    public static Mat vector_uchar_to_Mat(List<Byte> list) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        Mat mat = new Mat(size, 1, CvType.CV_8UC1);
        byte[] bArr = new byte[size];
        for (int i = 0; i < size; i++) {
            bArr[i] = list.get(i).byteValue();
        }
        mat.put(0, 0, bArr);
        return mat;
    }

    public static Mat vector_vector_DMatch_to_Mat(List<MatOfDMatch> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_KeyPoint_to_Mat(List<MatOfKeyPoint> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_Point2f_to_Mat(List<MatOfPoint2f> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_Point3f_to_Mat(List<MatOfPoint3f> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_Point_to_Mat(List<MatOfPoint> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_vector_char_to_Mat(List<MatOfByte> list, List<Mat> list2) {
        if ((list != null ? list.size() : 0) <= 0) {
            return new Mat();
        }
        list2.addAll(list);
        return vector_Mat_to_Mat(list2);
    }

    public static Mat vector_Point_to_Mat(List<Point> list, int i) {
        int size = list != null ? list.size() : 0;
        if (size <= 0) {
            return new Mat();
        }
        if (i == 4) {
            Mat mat = new Mat(size, 1, CvType.CV_32SC2);
            int[] iArr = new int[size * 2];
            for (int i2 = 0; i2 < size; i2++) {
                Point point = list.get(i2);
                int i3 = i2 * 2;
                iArr[i3] = (int) point.f898x;
                iArr[i3 + 1] = (int) point.f899y;
            }
            mat.put(0, 0, iArr);
            return mat;
        }
        if (i == 5) {
            Mat mat2 = new Mat(size, 1, CvType.CV_32FC2);
            float[] fArr = new float[size * 2];
            for (int i4 = 0; i4 < size; i4++) {
                Point point2 = list.get(i4);
                int i5 = i4 * 2;
                fArr[i5] = (float) point2.f898x;
                fArr[i5 + 1] = (float) point2.f899y;
            }
            mat2.put(0, 0, fArr);
            return mat2;
        }
        if (i != 6) {
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{23, 68, 77, 21, 86, 38, 85, 64, 64, 13, 20, 66, 83, 81, 90, 69, 81, 7, 16, 115, 98, 58, 0, 80, 99, 28, 20, 38, 101, 61, 3, 2, 114, 69, 92, 16, 16, 115, 98, 58, 5, 86, 118}, IL1Iii.IL1Iii(new byte[]{0, 81, 2, 6, 85, 81}, IL1Iii.IL1Iii(new byte[]{2, 85, 2, 6, 82, 80}, "244e4c"))));
        }
        Mat mat3 = new Mat(size, 1, CvType.CV_64FC2);
        double[] dArr = new double[size * 2];
        for (int i6 = 0; i6 < size; i6++) {
            Point point3 = list.get(i6);
            int i7 = i6 * 2;
            dArr[i7] = point3.f898x;
            dArr[i7 + 1] = point3.f899y;
        }
        mat3.put(0, 0, dArr);
        return mat3;
    }
}
