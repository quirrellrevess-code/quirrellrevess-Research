package org.opencv.features2d;

import java.util.ArrayList;
import java.util.List;
import org.opencv.core.Mat;
import org.opencv.core.MatOfByte;
import org.opencv.core.MatOfDMatch;
import org.opencv.core.MatOfKeyPoint;
import org.opencv.core.Scalar;
import org.opencv.utils.Converters;

/* JADX INFO: loaded from: classes.dex */
public class Features2d {
    public static final int DrawMatchesFlags_DEFAULT = 0;
    public static final int DrawMatchesFlags_DRAW_OVER_OUTIMG = 1;
    public static final int DrawMatchesFlags_DRAW_RICH_KEYPOINTS = 4;
    public static final int DrawMatchesFlags_NOT_DRAW_SINGLE_POINTS = 2;

    public static void drawKeypoints(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, Scalar scalar, int i) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        double[] dArr = scalar.val;
        drawKeypoints_0(j, j2, j3, dArr[0], dArr[1], dArr[2], dArr[3], i);
    }

    private static native void drawKeypoints_0(long j, long j2, long j3, double d, double d2, double d3, double d4, int i);

    private static native void drawKeypoints_1(long j, long j2, long j3, double d, double d2, double d3, double d4);

    private static native void drawKeypoints_2(long j, long j2, long j3);

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, Scalar scalar, Scalar scalar2, MatOfByte matOfByte, int i) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatches_0(j, j2, j3, j4, j5, j6, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3], matOfByte.nativeObj, i);
    }

    public static void drawMatchesKnn(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, List<MatOfDMatch> list, Mat mat3, Scalar scalar, Scalar scalar2, List<MatOfByte> list2, int i) {
        Mat matVector_vector_DMatch_to_Mat = Converters.vector_vector_DMatch_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        Mat matVector_vector_char_to_Mat = Converters.vector_vector_char_to_Mat(list2, new ArrayList(list2 != null ? list2.size() : 0));
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matVector_vector_DMatch_to_Mat.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatchesKnn_0(j, j2, j3, j4, j5, j6, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3], matVector_vector_char_to_Mat.nativeObj, i);
    }

    private static native void drawMatchesKnn_0(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, long j7, int i);

    private static native void drawMatchesKnn_1(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, long j7);

    private static native void drawMatchesKnn_2(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    private static native void drawMatchesKnn_3(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4);

    private static native void drawMatchesKnn_4(long j, long j2, long j3, long j4, long j5, long j6);

    private static native void drawMatches_0(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, long j7, int i);

    private static native void drawMatches_1(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, long j7);

    private static native void drawMatches_2(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    private static native void drawMatches_3(long j, long j2, long j3, long j4, long j5, long j6, double d, double d2, double d3, double d4);

    private static native void drawMatches_4(long j, long j2, long j3, long j4, long j5, long j6);

    private static native void drawMatches_5(long j, long j2, long j3, long j4, long j5, long j6, int i, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, long j7, int i2);

    private static native void drawMatches_6(long j, long j2, long j3, long j4, long j5, long j6, int i, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8, long j7);

    private static native void drawMatches_7(long j, long j2, long j3, long j4, long j5, long j6, int i, double d, double d2, double d3, double d4, double d5, double d6, double d7, double d8);

    private static native void drawMatches_8(long j, long j2, long j3, long j4, long j5, long j6, int i, double d, double d2, double d3, double d4);

    private static native void drawMatches_9(long j, long j2, long j3, long j4, long j5, long j6, int i);

    public static void drawKeypoints(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, Scalar scalar) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        double[] dArr = scalar.val;
        drawKeypoints_1(j, j2, j3, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, Scalar scalar, Scalar scalar2, MatOfByte matOfByte) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatches_1(j, j2, j3, j4, j5, j6, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3], matOfByte.nativeObj);
    }

    public static void drawKeypoints(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2) {
        drawKeypoints_2(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, Scalar scalar, Scalar scalar2) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatches_2(j, j2, j3, j4, j5, j6, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3]);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, Scalar scalar) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        drawMatches_3(j, j2, j3, j4, j5, j6, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3) {
        drawMatches_4(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, matOfKeyPoint2.nativeObj, matOfDMatch.nativeObj, mat3.nativeObj);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, int i, Scalar scalar, Scalar scalar2, MatOfByte matOfByte, int i2) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatches_5(j, j2, j3, j4, j5, j6, i, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3], matOfByte.nativeObj, i2);
    }

    public static void drawMatchesKnn(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, List<MatOfDMatch> list, Mat mat3, Scalar scalar, Scalar scalar2, List<MatOfByte> list2) {
        Mat matVector_vector_DMatch_to_Mat = Converters.vector_vector_DMatch_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        Mat matVector_vector_char_to_Mat = Converters.vector_vector_char_to_Mat(list2, new ArrayList(list2 != null ? list2.size() : 0));
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matVector_vector_DMatch_to_Mat.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatchesKnn_1(j, j2, j3, j4, j5, j6, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3], matVector_vector_char_to_Mat.nativeObj);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, int i, Scalar scalar, Scalar scalar2, MatOfByte matOfByte) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatches_6(j, j2, j3, j4, j5, j6, i, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3], matOfByte.nativeObj);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, int i, Scalar scalar, Scalar scalar2) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatches_7(j, j2, j3, j4, j5, j6, i, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3]);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, int i, Scalar scalar) {
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matOfDMatch.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        drawMatches_8(j, j2, j3, j4, j5, j6, i, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void drawMatches(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, MatOfDMatch matOfDMatch, Mat mat3, int i) {
        drawMatches_9(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, matOfKeyPoint2.nativeObj, matOfDMatch.nativeObj, mat3.nativeObj, i);
    }

    public static void drawMatchesKnn(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, List<MatOfDMatch> list, Mat mat3, Scalar scalar, Scalar scalar2) {
        Mat matVector_vector_DMatch_to_Mat = Converters.vector_vector_DMatch_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matVector_vector_DMatch_to_Mat.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        double d = dArr[0];
        double d2 = dArr[1];
        double d3 = dArr[2];
        double d4 = dArr[3];
        double[] dArr2 = scalar2.val;
        drawMatchesKnn_2(j, j2, j3, j4, j5, j6, d, d2, d3, d4, dArr2[0], dArr2[1], dArr2[2], dArr2[3]);
    }

    public static void drawMatchesKnn(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, List<MatOfDMatch> list, Mat mat3, Scalar scalar) {
        Mat matVector_vector_DMatch_to_Mat = Converters.vector_vector_DMatch_to_Mat(list, new ArrayList(list != null ? list.size() : 0));
        long j = mat.nativeObj;
        long j2 = matOfKeyPoint.nativeObj;
        long j3 = mat2.nativeObj;
        long j4 = matOfKeyPoint2.nativeObj;
        long j5 = matVector_vector_DMatch_to_Mat.nativeObj;
        long j6 = mat3.nativeObj;
        double[] dArr = scalar.val;
        drawMatchesKnn_3(j, j2, j3, j4, j5, j6, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public static void drawMatchesKnn(Mat mat, MatOfKeyPoint matOfKeyPoint, Mat mat2, MatOfKeyPoint matOfKeyPoint2, List<MatOfDMatch> list, Mat mat3) {
        drawMatchesKnn_4(mat.nativeObj, matOfKeyPoint.nativeObj, mat2.nativeObj, matOfKeyPoint2.nativeObj, Converters.vector_vector_DMatch_to_Mat(list, new ArrayList(list != null ? list.size() : 0)).nativeObj, mat3.nativeObj);
    }
}
