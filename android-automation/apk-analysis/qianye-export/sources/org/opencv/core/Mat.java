package org.opencv.core;

import I1I.IL1Iii;
import com.google.android.flexbox.BuildConfig;
import java.nio.ByteBuffer;

/* JADX INFO: loaded from: classes.dex */
public class Mat {
    public final long nativeObj;

    public interface Atable<T> {
        T getV();

        Tuple2<T> getV2c();

        Tuple3<T> getV3c();

        Tuple4<T> getV4c();

        void setV(T t);

        void setV2c(Tuple2<T> tuple2);

        void setV3c(Tuple3<T> tuple3);

        void setV4c(Tuple4<T> tuple4);
    }

    public static class AtableByte extends AtableBase implements Atable<Byte> {
        public AtableByte(Mat mat, int i, int i2) {
            super(mat, i, i2);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Byte> getV2c() {
            byte[] bArr = new byte[2];
            this.mat.get(this.indices, bArr);
            return new Tuple2<>(Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Byte> getV3c() {
            byte[] bArr = new byte[3];
            this.mat.get(this.indices, bArr);
            return new Tuple3<>(Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Byte> getV4c() {
            byte[] bArr = new byte[4];
            this.mat.get(this.indices, bArr);
            return new Tuple4<>(Byte.valueOf(bArr[0]), Byte.valueOf(bArr[1]), Byte.valueOf(bArr[2]), Byte.valueOf(bArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Byte> tuple2) {
            this.mat.put(this.indices, new byte[]{((Byte) ((Tuple2) tuple2).f889_0).byteValue(), ((Byte) ((Tuple2) tuple2).f890_1).byteValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Byte> tuple3) {
            this.mat.put(this.indices, new byte[]{((Byte) ((Tuple3) tuple3).f891_0).byteValue(), ((Byte) ((Tuple3) tuple3).f892_1).byteValue(), ((Byte) ((Tuple3) tuple3).f893_2).byteValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Byte> tuple4) {
            this.mat.put(this.indices, new byte[]{((Byte) ((Tuple4) tuple4).f894_0).byteValue(), ((Byte) ((Tuple4) tuple4).f895_1).byteValue(), ((Byte) ((Tuple4) tuple4).f896_2).byteValue(), ((Byte) ((Tuple4) tuple4).f897_3).byteValue()});
        }

        public AtableByte(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Byte getV() {
            byte[] bArr = new byte[1];
            this.mat.get(this.indices, bArr);
            return Byte.valueOf(bArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Byte b) {
            this.mat.put(this.indices, new byte[]{b.byteValue()});
        }
    }

    public static class AtableDouble extends AtableBase implements Atable<Double> {
        public AtableDouble(Mat mat, int i, int i2) {
            super(mat, i, i2);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Double> getV2c() {
            double[] dArr = new double[2];
            this.mat.get(this.indices, dArr);
            return new Tuple2<>(Double.valueOf(dArr[0]), Double.valueOf(dArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Double> getV3c() {
            double[] dArr = new double[3];
            this.mat.get(this.indices, dArr);
            return new Tuple3<>(Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Double> getV4c() {
            double[] dArr = new double[4];
            this.mat.get(this.indices, dArr);
            return new Tuple4<>(Double.valueOf(dArr[0]), Double.valueOf(dArr[1]), Double.valueOf(dArr[2]), Double.valueOf(dArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Double> tuple2) {
            this.mat.put(this.indices, ((Double) ((Tuple2) tuple2).f889_0).doubleValue(), ((Double) ((Tuple2) tuple2).f890_1).doubleValue());
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Double> tuple3) {
            this.mat.put(this.indices, ((Double) ((Tuple3) tuple3).f891_0).doubleValue(), ((Double) ((Tuple3) tuple3).f892_1).doubleValue(), ((Double) ((Tuple3) tuple3).f893_2).doubleValue());
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Double> tuple4) {
            this.mat.put(this.indices, ((Double) ((Tuple4) tuple4).f894_0).doubleValue(), ((Double) ((Tuple4) tuple4).f895_1).doubleValue(), ((Double) ((Tuple4) tuple4).f896_2).doubleValue(), ((Double) ((Tuple4) tuple4).f897_3).doubleValue());
        }

        public AtableDouble(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Double getV() {
            double[] dArr = new double[1];
            this.mat.get(this.indices, dArr);
            return Double.valueOf(dArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Double d) {
            this.mat.put(this.indices, d.doubleValue());
        }
    }

    public static class AtableFloat extends AtableBase implements Atable<Float> {
        public AtableFloat(Mat mat, int i, int i2) {
            super(mat, i, i2);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Float> getV2c() {
            float[] fArr = new float[2];
            this.mat.get(this.indices, fArr);
            return new Tuple2<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Float> getV3c() {
            float[] fArr = new float[3];
            this.mat.get(this.indices, fArr);
            return new Tuple3<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Float> getV4c() {
            float[] fArr = new float[4];
            this.mat.get(this.indices, fArr);
            return new Tuple4<>(Float.valueOf(fArr[0]), Float.valueOf(fArr[1]), Float.valueOf(fArr[2]), Float.valueOf(fArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Float> tuple2) {
            this.mat.put(this.indices, new float[]{((Float) ((Tuple2) tuple2).f889_0).floatValue(), ((Float) ((Tuple2) tuple2).f890_1).floatValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Float> tuple3) {
            this.mat.put(this.indices, new float[]{((Float) ((Tuple3) tuple3).f891_0).floatValue(), ((Float) ((Tuple3) tuple3).f892_1).floatValue(), ((Float) ((Tuple3) tuple3).f893_2).floatValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Float> tuple4) {
            this.mat.put(this.indices, ((Float) ((Tuple4) tuple4).f894_0).floatValue(), ((Float) ((Tuple4) tuple4).f895_1).floatValue(), ((Float) ((Tuple4) tuple4).f896_2).floatValue(), ((Float) ((Tuple4) tuple4).f897_3).floatValue());
        }

        public AtableFloat(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Float getV() {
            float[] fArr = new float[1];
            this.mat.get(this.indices, fArr);
            return Float.valueOf(fArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Float f) {
            this.mat.put(this.indices, new float[]{f.floatValue()});
        }
    }

    public static class AtableInteger extends AtableBase implements Atable<Integer> {
        public AtableInteger(Mat mat, int i, int i2) {
            super(mat, i, i2);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Integer> getV2c() {
            int[] iArr = new int[2];
            this.mat.get(this.indices, iArr);
            return new Tuple2<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Integer> getV3c() {
            int[] iArr = new int[3];
            this.mat.get(this.indices, iArr);
            return new Tuple3<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Integer> getV4c() {
            int[] iArr = new int[4];
            this.mat.get(this.indices, iArr);
            return new Tuple4<>(Integer.valueOf(iArr[0]), Integer.valueOf(iArr[1]), Integer.valueOf(iArr[2]), Integer.valueOf(iArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Integer> tuple2) {
            this.mat.put(this.indices, new int[]{((Integer) ((Tuple2) tuple2).f889_0).intValue(), ((Integer) ((Tuple2) tuple2).f890_1).intValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Integer> tuple3) {
            this.mat.put(this.indices, new int[]{((Integer) ((Tuple3) tuple3).f891_0).intValue(), ((Integer) ((Tuple3) tuple3).f892_1).intValue(), ((Integer) ((Tuple3) tuple3).f893_2).intValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Integer> tuple4) {
            this.mat.put(this.indices, new int[]{((Integer) ((Tuple4) tuple4).f894_0).intValue(), ((Integer) ((Tuple4) tuple4).f895_1).intValue(), ((Integer) ((Tuple4) tuple4).f896_2).intValue(), ((Integer) ((Tuple4) tuple4).f897_3).intValue()});
        }

        public AtableInteger(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        /* JADX WARN: Can't rename method to resolve collision */
        @Override // org.opencv.core.Mat.Atable
        public Integer getV() {
            int[] iArr = new int[1];
            this.mat.get(this.indices, iArr);
            return Integer.valueOf(iArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Integer num) {
            this.mat.put(this.indices, new int[]{num.intValue()});
        }
    }

    public static class AtableShort extends AtableBase implements Atable<Short> {
        public AtableShort(Mat mat, int i, int i2) {
            super(mat, i, i2);
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple2<Short> getV2c() {
            short[] sArr = new short[2];
            this.mat.get(this.indices, sArr);
            return new Tuple2<>(Short.valueOf(sArr[0]), Short.valueOf(sArr[1]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple3<Short> getV3c() {
            short[] sArr = new short[3];
            this.mat.get(this.indices, sArr);
            return new Tuple3<>(Short.valueOf(sArr[0]), Short.valueOf(sArr[1]), Short.valueOf(sArr[2]));
        }

        @Override // org.opencv.core.Mat.Atable
        public Tuple4<Short> getV4c() {
            short[] sArr = new short[4];
            this.mat.get(this.indices, sArr);
            return new Tuple4<>(Short.valueOf(sArr[0]), Short.valueOf(sArr[1]), Short.valueOf(sArr[2]), Short.valueOf(sArr[3]));
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV2c(Tuple2<Short> tuple2) {
            this.mat.put(this.indices, new short[]{((Short) ((Tuple2) tuple2).f889_0).shortValue(), ((Short) ((Tuple2) tuple2).f890_1).shortValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV3c(Tuple3<Short> tuple3) {
            this.mat.put(this.indices, new short[]{((Short) ((Tuple3) tuple3).f891_0).shortValue(), ((Short) ((Tuple3) tuple3).f892_1).shortValue(), ((Short) ((Tuple3) tuple3).f893_2).shortValue()});
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV4c(Tuple4<Short> tuple4) {
            this.mat.put(this.indices, new short[]{((Short) ((Tuple4) tuple4).f894_0).shortValue(), ((Short) ((Tuple4) tuple4).f895_1).shortValue(), ((Short) ((Tuple4) tuple4).f896_2).shortValue(), ((Short) ((Tuple4) tuple4).f897_3).shortValue()});
        }

        public AtableShort(Mat mat, int[] iArr) {
            super(mat, iArr);
        }

        @Override // org.opencv.core.Mat.Atable
        public Short getV() {
            short[] sArr = new short[1];
            this.mat.get(this.indices, sArr);
            return Short.valueOf(sArr[0]);
        }

        @Override // org.opencv.core.Mat.Atable
        public void setV(Short sh) {
            this.mat.put(this.indices, new short[]{sh.shortValue()});
        }
    }

    public static class Tuple2<T> {

        /* JADX INFO: renamed from: _0 */
        private final T f889_0;

        /* JADX INFO: renamed from: _1 */
        private final T f890_1;

        public Tuple2(T t, T t2) {
            this.f889_0 = t;
            this.f890_1 = t2;
        }

        public T get_0() {
            return this.f889_0;
        }

        public T get_1() {
            return this.f890_1;
        }
    }

    public static class Tuple3<T> {

        /* JADX INFO: renamed from: _0 */
        private final T f891_0;

        /* JADX INFO: renamed from: _1 */
        private final T f892_1;

        /* JADX INFO: renamed from: _2 */
        private final T f893_2;

        public Tuple3(T t, T t2, T t3) {
            this.f891_0 = t;
            this.f892_1 = t2;
            this.f893_2 = t3;
        }

        public T get_0() {
            return this.f891_0;
        }

        public T get_1() {
            return this.f892_1;
        }

        public T get_2() {
            return this.f893_2;
        }
    }

    public static class Tuple4<T> {

        /* JADX INFO: renamed from: _0 */
        private final T f894_0;

        /* JADX INFO: renamed from: _1 */
        private final T f895_1;

        /* JADX INFO: renamed from: _2 */
        private final T f896_2;

        /* JADX INFO: renamed from: _3 */
        private final T f897_3;

        public Tuple4(T t, T t2, T t3, T t4) {
            this.f894_0 = t;
            this.f895_1 = t2;
            this.f896_2 = t3;
            this.f897_3 = t4;
        }

        public T get_0() {
            return this.f894_0;
        }

        public T get_1() {
            return this.f895_1;
        }

        public T get_2() {
            return this.f896_2;
        }

        public T get_3() {
            return this.f897_3;
        }
    }

    public Mat(long j) {
        if (j == 0) {
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{119, 86, 22, 12, 16, 86, 25, 88, 0, 15, 3, 80, 77, 23, 3, 1, 2, 65, 92, 68, 17, 69, 15, 64, 25, 121, 55, 41, 42}, IL1Iii.IL1Iii(new byte[]{91, 6, 90, 82, 83, 80}, IL1Iii.IL1Iii(new byte[]{81, 87, 93, 82, 87, 83}, "3feeb0"))));
        }
        this.nativeObj = j;
    }

    public static Mat eye(int i, int i2, int i3) {
        return new Mat(n_eye(i, i2, i3));
    }

    private static native void locateROI_0(long j, double[] dArr, double[] dArr2);

    private static native String nDump(long j);

    private static native double[] nGet(long j, int i, int i2);

    private static native int nGetB(long j, int i, int i2, int i3, byte[] bArr);

    private static native int nGetBIdx(long j, int[] iArr, int i, byte[] bArr);

    private static native int nGetD(long j, int i, int i2, int i3, double[] dArr);

    private static native int nGetDIdx(long j, int[] iArr, int i, double[] dArr);

    private static native int nGetF(long j, int i, int i2, int i3, float[] fArr);

    private static native int nGetFIdx(long j, int[] iArr, int i, float[] fArr);

    private static native int nGetI(long j, int i, int i2, int i3, int[] iArr);

    private static native int nGetIIdx(long j, int[] iArr, int i, int[] iArr2);

    private static native double[] nGetIdx(long j, int[] iArr);

    private static native int nGetS(long j, int i, int i2, int i3, short[] sArr);

    private static native int nGetSIdx(long j, int[] iArr, int i, short[] sArr);

    private static native int nPutB(long j, int i, int i2, int i3, byte[] bArr);

    private static native int nPutBIdx(long j, int[] iArr, int i, byte[] bArr);

    private static native int nPutBwIdxOffset(long j, int[] iArr, int i, int i2, byte[] bArr);

    private static native int nPutBwOffset(long j, int i, int i2, int i3, int i4, byte[] bArr);

    private static native int nPutD(long j, int i, int i2, int i3, double[] dArr);

    private static native int nPutDIdx(long j, int[] iArr, int i, double[] dArr);

    private static native int nPutF(long j, int i, int i2, int i3, float[] fArr);

    private static native int nPutFIdx(long j, int[] iArr, int i, float[] fArr);

    private static native int nPutI(long j, int i, int i2, int i3, int[] iArr);

    private static native int nPutIIdx(long j, int[] iArr, int i, int[] iArr2);

    private static native int nPutS(long j, int i, int i2, int i3, short[] sArr);

    private static native int nPutSIdx(long j, int[] iArr, int i, short[] sArr);

    private static native long n_Mat();

    private static native long n_Mat(double d, double d2, int i);

    private static native long n_Mat(double d, double d2, int i, double d3, double d4, double d5, double d6);

    private static native long n_Mat(int i, int i2, int i3);

    private static native long n_Mat(int i, int i2, int i3, double d, double d2, double d3, double d4);

    private static native long n_Mat(int i, int i2, int i3, ByteBuffer byteBuffer);

    private static native long n_Mat(int i, int i2, int i3, ByteBuffer byteBuffer, long j);

    private static native long n_Mat(int i, int[] iArr, int i2);

    private static native long n_Mat(int i, int[] iArr, int i2, double d, double d2, double d3, double d4);

    private static native long n_Mat(long j, int i, int i2);

    private static native long n_Mat(long j, int i, int i2, int i3, int i4);

    private static native long n_Mat(long j, Range[] rangeArr);

    private static native long n_adjustROI(long j, int i, int i2, int i3, int i4);

    private static native void n_assignTo(long j, long j2);

    private static native void n_assignTo(long j, long j2, int i);

    private static native int n_channels(long j);

    private static native int n_checkVector(long j, int i);

    private static native int n_checkVector(long j, int i, int i2);

    private static native int n_checkVector(long j, int i, int i2, boolean z);

    private static native long n_clone(long j);

    private static native long n_col(long j, int i);

    private static native long n_colRange(long j, int i, int i2);

    private static native int n_cols(long j);

    private static native void n_convertTo(long j, long j2, int i);

    private static native void n_convertTo(long j, long j2, int i, double d);

    private static native void n_convertTo(long j, long j2, int i, double d, double d2);

    private static native void n_copySize(long j, long j2);

    private static native void n_copyTo(long j, long j2);

    private static native void n_copyTo(long j, long j2, long j3);

    private static native void n_create(long j, double d, double d2, int i);

    private static native void n_create(long j, int i, int i2, int i3);

    private static native void n_create(long j, int i, int[] iArr, int i2);

    private static native long n_cross(long j, long j2);

    private static native long n_dataAddr(long j);

    private static native void n_delete(long j);

    private static native int n_depth(long j);

    private static native long n_diag(long j);

    private static native long n_diag(long j, int i);

    private static native int n_dims(long j);

    private static native double n_dot(long j, long j2);

    private static native long n_elemSize(long j);

    private static native long n_elemSize1(long j);

    private static native boolean n_empty(long j);

    private static native long n_eye(double d, double d2, int i);

    private static native long n_eye(int i, int i2, int i3);

    private static native long n_inv(long j);

    private static native long n_inv(long j, int i);

    private static native boolean n_isContinuous(long j);

    private static native boolean n_isSubmatrix(long j);

    private static native long n_mul(long j, long j2);

    private static native long n_mul(long j, long j2, double d);

    private static native long n_ones(double d, double d2, int i);

    private static native long n_ones(int i, int i2, int i3);

    private static native long n_ones(int i, int[] iArr, int i2);

    private static native void n_push_back(long j, long j2);

    private static native void n_release(long j);

    private static native long n_reshape(long j, int i);

    private static native long n_reshape(long j, int i, int i2);

    private static native long n_reshape_1(long j, int i, int i2, int[] iArr);

    private static native long n_row(long j, int i);

    private static native long n_rowRange(long j, int i, int i2);

    private static native int n_rows(long j);

    private static native long n_setTo(long j, double d, double d2, double d3, double d4);

    private static native long n_setTo(long j, double d, double d2, double d3, double d4, long j2);

    private static native long n_setTo(long j, long j2);

    private static native long n_setTo(long j, long j2, long j3);

    private static native double[] n_size(long j);

    private static native int n_size_i(long j, int i);

    private static native long n_step1(long j);

    private static native long n_step1(long j, int i);

    private static native long n_submat(long j, int i, int i2, int i3, int i4);

    private static native long n_submat_ranges(long j, Range[] rangeArr);

    private static native long n_submat_rr(long j, int i, int i2, int i3, int i4);

    private static native long n_t(long j);

    private static native long n_total(long j);

    private static native int n_type(long j);

    private static native long n_zeros(double d, double d2, int i);

    private static native long n_zeros(int i, int i2, int i3);

    private static native long n_zeros(int i, int[] iArr, int i2);

    public static Mat ones(int i, int i2, int i3) {
        return new Mat(n_ones(i, i2, i3));
    }

    public static Mat zeros(int i, int i2, int i3) {
        return new Mat(n_zeros(i, i2, i3));
    }

    public Mat adjustROI(int i, int i2, int i3, int i4) {
        return new Mat(n_adjustROI(this.nativeObj, i, i2, i3, i4));
    }

    public void assignTo(Mat mat, int i) {
        n_assignTo(this.nativeObj, mat.nativeObj, i);
    }

    /* JADX INFO: renamed from: at */
    public <T> Atable<T> m830at(Class<T> cls, int i, int i2) {
        if (cls == Byte.class || cls == Byte.TYPE) {
            return new AtableByte(this, i, i2);
        }
        if (cls == Double.class || cls == Double.TYPE) {
            return new AtableDouble(this, i, i2);
        }
        if (cls == Float.class || cls == Float.TYPE) {
            return new AtableFloat(this, i, i2);
        }
        if (cls == Integer.class || cls == Integer.TYPE) {
            return new AtableInteger(this, i, i2);
        }
        if (cls == Short.class || cls == Short.TYPE) {
            return new AtableShort(this, i, i2);
        }
        throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{55, 94, 23, 67, 18, 17, 13, 66, 16, 83, 6, 65, 1, 92, 5, 69, 17, 65, 22, 73, 20, 83}, IL1Iii.IL1Iii(new byte[]{84, 9, 86, 82, 84, 83}, IL1Iii.IL1Iii(new byte[]{1, 15, 6, 87, 85, 1}, "7643c3"))));
    }

    public int channels() {
        return n_channels(this.nativeObj);
    }

    public int checkVector(int i, int i2, boolean z) {
        return n_checkVector(this.nativeObj, i, i2, z);
    }

    public Mat col(int i) {
        return new Mat(n_col(this.nativeObj, i));
    }

    public Mat colRange(int i, int i2) {
        return new Mat(n_colRange(this.nativeObj, i, i2));
    }

    public int cols() {
        return n_cols(this.nativeObj);
    }

    public void convertTo(Mat mat, int i, double d, double d2) {
        n_convertTo(this.nativeObj, mat.nativeObj, i, d, d2);
    }

    public void copySize(Mat mat) {
        n_copySize(this.nativeObj, mat.nativeObj);
    }

    public void copyTo(Mat mat) {
        n_copyTo(this.nativeObj, mat.nativeObj);
    }

    public void create(int i, int i2, int i3) {
        n_create(this.nativeObj, i, i2, i3);
    }

    public Mat cross(Mat mat) {
        return new Mat(n_cross(this.nativeObj, mat.nativeObj));
    }

    public long dataAddr() {
        return n_dataAddr(this.nativeObj);
    }

    public int depth() {
        return n_depth(this.nativeObj);
    }

    public Mat diag(int i) {
        return new Mat(n_diag(this.nativeObj, i));
    }

    public int dims() {
        return n_dims(this.nativeObj);
    }

    public double dot(Mat mat) {
        return n_dot(this.nativeObj, mat.nativeObj);
    }

    public String dump() {
        return nDump(this.nativeObj);
    }

    public long elemSize() {
        return n_elemSize(this.nativeObj);
    }

    public long elemSize1() {
        return n_elemSize1(this.nativeObj);
    }

    public boolean empty() {
        return n_empty(this.nativeObj);
    }

    public void finalize() throws Throwable {
        n_delete(this.nativeObj);
        super.finalize();
    }

    public int get(int i, int i2, byte[] bArr) {
        int iType = type();
        if (bArr == null || bArr.length % CvType.channels(iType) != 0) {
            StringBuilder sb = new StringBuilder();
            sb.append(IL1Iii.IL1Iii(new byte[]{96, 22, 12, 18, 15, 80, 85, 0, 67, 0, 7, 64, 81, 68, 6, 8, 3, 89, 85, 10, 23, 68, 8, 65, 93, 6, 6, 22, 70, 28}, IL1Iii.IL1Iii(new byte[]{86, 85, 90, 7, 84, 7}, IL1Iii.IL1Iii(new byte[]{7, 84, 92, 7, 0, 4}, "aeed27"))));
            sb.append(bArr == null ? 0 : bArr.length);
            sb.append(IL1Iii.IL1Iii(new byte[]{16, 18, 64, 9, 92, 68, 85, 86, 19, 3, 86, 17, 84, 71, 95, 21, 90, 65, 85, 87, 19, 14, 85, 17, 77, 90, 86, 65, 126, 80, 77, 18, 80, 9, 82, 95, 87, 87, 95, 18, 19, 82, 86, 71, 93, 21, 19, 25}, IL1Iii.IL1Iii(new byte[]{1, 1, 5, 89, 85, 2}, IL1Iii.IL1Iii(new byte[]{9, 2, 6, 91, 86, 87}, "110c0d"))));
            sb.append(CvType.channels(iType));
            sb.append(IL1Iii.IL1Iii(new byte[]{16}, IL1Iii.IL1Iii(new byte[]{92, 1, 87, 85, 2, 12}, IL1Iii.IL1Iii(new byte[]{86, 14, 2, 86, 14, 7}, "38d483"))));
            throw new UnsupportedOperationException(sb.toString());
        }
        if (CvType.depth(iType) == 0 || CvType.depth(iType) == 1) {
            return nGetB(this.nativeObj, i, i2, bArr.length, bArr);
        }
        throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{127, 3, 23, 21, 7, 7, 70, 3, 67, 65, 26, 22, 87, 66, 10, 70, 67, 8, 93, 22, 67, 86, 12, 11, 66, 3, 23, 92, 1, 10, 87, 88, 67}, IL1Iii.IL1Iii(new byte[]{11, 85, 91, 1, 90, 4}, IL1Iii.IL1Iii(new byte[]{91, 0, 15, 0, 11, 83}, "b77421"))) + iType);
    }

    public long getNativeObjAddr() {
        return this.nativeObj;
    }

    public int height() {
        return rows();
    }

    public Mat inv(int i) {
        return new Mat(n_inv(this.nativeObj, i));
    }

    public boolean isContinuous() {
        return n_isContinuous(this.nativeObj);
    }

    public boolean isSubmatrix() {
        return n_isSubmatrix(this.nativeObj);
    }

    public void locateROI(Size size, Point point) {
        double[] dArr = new double[2];
        double[] dArr2 = new double[2];
        locateROI_0(this.nativeObj, dArr, dArr2);
        if (size != null) {
            size.width = dArr[0];
            size.height = dArr[1];
        }
        if (point != null) {
            point.f898x = dArr2[0];
            point.f899y = dArr2[1];
        }
    }

    public Mat mul(Mat mat, double d) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj, d));
    }

    public void push_back(Mat mat) {
        n_push_back(this.nativeObj, mat.nativeObj);
    }

    public int put(int i, int i2, double... dArr) {
        int iType = type();
        if (dArr != null && dArr.length % CvType.channels(iType) == 0) {
            return nPutD(this.nativeObj, i, i2, dArr.length, dArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{49, 66, 14, 64, 88, 81, 4, 84, 65, 82, 80, 65, 0, 16, 4, 90, 84, 88, 4, 94, 21, 22, 95, 64, 12, 82, 4, 68, 17, 29}, IL1Iii.IL1Iii(new byte[]{3, 6, 81, 14, 2, 0}, IL1Iii.IL1Iii(new byte[]{81, 2, 0, 92, 87, 7}, "340dd2"))));
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{16, 66, 17, 88, 94, 20, 85, 6, 66, 82, 84, 65, 84, 23, 14, 68, 88, 17, 85, 7, 66, 95, 87, 65, 77, 10, 7, 16, 124, 0, 77, 66, 1, 88, 80, 15, 87, 7, 14, 67, 17, 2, 86, 23, 12, 68, 17, 73}, IL1Iii.IL1Iii(new byte[]{1, 7, 6, 86, 0, 82}, IL1Iii.IL1Iii(new byte[]{91, 85, 0, 2, 0, 5}, "c0dd16"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{29}, IL1Iii.IL1Iii(new byte[]{0, 86, 7, 2, 86, 3}, IL1Iii.IL1Iii(new byte[]{13, 12, 80, 3, 87, 82}, "99154c"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public void release() {
        n_release(this.nativeObj);
    }

    public Mat reshape(int i, int i2) {
        return new Mat(n_reshape(this.nativeObj, i, i2));
    }

    public Mat row(int i) {
        return new Mat(n_row(this.nativeObj, i));
    }

    public Mat rowRange(int i, int i2) {
        return new Mat(n_rowRange(this.nativeObj, i, i2));
    }

    public int rows() {
        return n_rows(this.nativeObj);
    }

    public Mat setTo(Scalar scalar) {
        long j = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j, dArr[0], dArr[1], dArr[2], dArr[3]));
    }

    public Size size() {
        return new Size(n_size(this.nativeObj));
    }

    public long step1(int i) {
        return n_step1(this.nativeObj, i);
    }

    public Mat submat(int i, int i2, int i3, int i4) {
        return new Mat(n_submat_rr(this.nativeObj, i, i2, i3, i4));
    }

    /* JADX INFO: renamed from: t */
    public Mat m832t() {
        return new Mat(n_t(this.nativeObj));
    }

    public String toString() {
        String strIL1Iii = dims() > 0 ? BuildConfig.FLAVOR : IL1Iii.IL1Iii(new byte[]{26, 5, 31, 79, 87, 30}, IL1Iii.IL1Iii(new byte[]{0, 13, 5, 6, 82, 7}, IL1Iii.IL1Iii(new byte[]{3, 0, 84, 83, 80, 2}, "49d7d1")));
        for (int i = 0; i < dims(); i++) {
            strIL1Iii = strIL1Iii + size(i) + IL1Iii.IL1Iii(new byte[]{31}, IL1Iii.IL1Iii(new byte[]{87, 2, 10, 8, 10, 7}, IL1Iii.IL1Iii(new byte[]{3, 5, 6, 3, 86, 86}, "a542d5")));
        }
        return IL1Iii.IL1Iii(new byte[]{47, 81, 77, 22, 57, 69}, IL1Iii.IL1Iii(new byte[]{83, 8, 90, 7, 87, 84}, IL1Iii.IL1Iii(new byte[]{87, 14, 80, 9, 83, 0}, "f638f1"))) + strIL1Iii + CvType.typeToString(type()) + IL1Iii.IL1Iii(new byte[]{29, 18, 80, 18, 122, 92, 95, 70, 4}, IL1Iii.IL1Iii(new byte[]{85, 1, 8, 83, 12, 6}, IL1Iii.IL1Iii(new byte[]{7, 80, 87, 86, 2, 6}, "ccfd73"))) + isContinuous() + IL1Iii.IL1Iii(new byte[]{20, 23, 10, 69, 55, 17, 90, 90, 2, 66, 89}, IL1Iii.IL1Iii(new byte[]{90, 86, 87, 5, 84, 92}, IL1Iii.IL1Iii(new byte[]{4, 4, 2, 3, 3, 89}, "fe603a"))) + isSubmatrix() + IL1Iii.IL1Iii(new byte[]{79, 69, 15, 86, 17, 95, 21, 0, 46, 85, 15, 11, 83, 29}, IL1Iii.IL1Iii(new byte[]{91, 85, 84, 0, 81, 80}, IL1Iii.IL1Iii(new byte[]{89, 86, 0, 84, 86, 7}, "af5cba"))) + Long.toHexString(this.nativeObj) + IL1Iii.IL1Iii(new byte[]{79, 20, 2, 0, 64, 4, 34, 80, 2, 19, 9, 85, 27}, IL1Iii.IL1Iii(new byte[]{84, 85, 82, 84, 6, 82}, IL1Iii.IL1Iii(new byte[]{85, 5, 86, 12, 84, 1}, "bdb9f6"))) + Long.toHexString(dataAddr()) + IL1Iii.IL1Iii(new byte[]{68, 63}, IL1Iii.IL1Iii(new byte[]{93, 81, 1, 85, 1, 81}, IL1Iii.IL1Iii(new byte[]{91, 86, 86, 6, 83, 83}, "bed2cf")));
    }

    public long total() {
        return n_total(this.nativeObj);
    }

    public int type() {
        return n_type(this.nativeObj);
    }

    public int width() {
        return cols();
    }

    public static Mat eye(Size size, int i) {
        return new Mat(n_eye(size.width, size.height, i));
    }

    public static Mat ones(Size size, int i) {
        return new Mat(n_ones(size.width, size.height, i));
    }

    public static Mat zeros(Size size, int i) {
        return new Mat(n_zeros(size.width, size.height, i));
    }

    public void assignTo(Mat mat) {
        n_assignTo(this.nativeObj, mat.nativeObj);
    }

    public int checkVector(int i, int i2) {
        return n_checkVector(this.nativeObj, i, i2);
    }

    public Mat clone() {
        return new Mat(n_clone(this.nativeObj));
    }

    public Mat colRange(Range range) {
        return new Mat(n_colRange(this.nativeObj, range.start, range.end));
    }

    public void convertTo(Mat mat, int i, double d) {
        n_convertTo(this.nativeObj, mat.nativeObj, i, d);
    }

    public void copyTo(Mat mat, Mat mat2) {
        n_copyTo(this.nativeObj, mat.nativeObj, mat2.nativeObj);
    }

    public void create(Size size, int i) {
        n_create(this.nativeObj, size.width, size.height, i);
    }

    public Mat diag() {
        return new Mat(n_diag(this.nativeObj, 0));
    }

    public Mat inv() {
        return new Mat(n_inv(this.nativeObj));
    }

    public Mat mul(Mat mat) {
        return new Mat(n_mul(this.nativeObj, mat.nativeObj));
    }

    public Mat reshape(int i) {
        return new Mat(n_reshape(this.nativeObj, i));
    }

    public Mat rowRange(Range range) {
        return new Mat(n_rowRange(this.nativeObj, range.start, range.end));
    }

    public Mat setTo(Scalar scalar, Mat mat) {
        long j = this.nativeObj;
        double[] dArr = scalar.val;
        return new Mat(n_setTo(j, dArr[0], dArr[1], dArr[2], dArr[3], mat.nativeObj));
    }

    public int size(int i) {
        return n_size_i(this.nativeObj, i);
    }

    public long step1() {
        return n_step1(this.nativeObj);
    }

    public Mat submat(Range range, Range range2) {
        return new Mat(n_submat_rr(this.nativeObj, range.start, range.end, range2.start, range2.end));
    }

    public static class AtableBase {
        public final int[] indices;
        public final Mat mat;

        public AtableBase(Mat mat, int i, int i2) {
            this.mat = mat;
            this.indices = new int[]{i, i2};
        }

        public AtableBase(Mat mat, int[] iArr) {
            this.mat = mat;
            this.indices = iArr;
        }
    }

    public static Mat diag(Mat mat) {
        return new Mat(n_diag(mat.nativeObj));
    }

    public static Mat ones(int[] iArr, int i) {
        return new Mat(n_ones(iArr.length, iArr, i));
    }

    public static Mat zeros(int[] iArr, int i) {
        return new Mat(n_zeros(iArr.length, iArr, i));
    }

    public int checkVector(int i) {
        return n_checkVector(this.nativeObj, i);
    }

    public void convertTo(Mat mat, int i) {
        n_convertTo(this.nativeObj, mat.nativeObj, i);
    }

    public void create(int[] iArr, int i) {
        n_create(this.nativeObj, iArr.length, iArr, i);
    }

    public Mat reshape(int i, int[] iArr) {
        return new Mat(n_reshape_1(this.nativeObj, i, iArr.length, iArr));
    }

    public Mat setTo(Mat mat, Mat mat2) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj, mat2.nativeObj));
    }

    public Mat submat(Range[] rangeArr) {
        return new Mat(n_submat_ranges(this.nativeObj, rangeArr));
    }

    public Mat() {
        this.nativeObj = n_Mat();
    }

    public Mat setTo(Mat mat) {
        return new Mat(n_setTo(this.nativeObj, mat.nativeObj));
    }

    public Mat submat(Rect rect) {
        return new Mat(n_submat(this.nativeObj, rect.f903x, rect.f904y, rect.width, rect.height));
    }

    public Mat(int i, int i2, int i3) {
        this.nativeObj = n_Mat(i, i2, i3);
    }

    public int put(int[] iArr, double... dArr) {
        int iType = type();
        if (dArr != null && dArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                return nPutDIdx(this.nativeObj, iArr, dArr.length, dArr);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{112, 88, 2, 11, 65, 20, 92, 85, 21, 68, 93, 19, 84, 84, 4, 22, 19, 9, 95, 22, 8, 10, 87, 15, 90, 83, 18}, IL1Iii.IL1Iii(new byte[]{15, 80, 83, 1, 7, 2}, IL1Iii.IL1Iii(new byte[]{0, 82, 7, 86, 12, 2}, "64538f"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{97, 17, 95, 78, 91, 82, 84, 7, 16, 92, 83, 66, 80, 67, 85, 84, 87, 91, 84, 13, 68, 24, 92, 67, 92, 1, 85, 74, 18, 30}, IL1Iii.IL1Iii(new byte[]{6, 91, 4, 11, 0, 4}, IL1Iii.IL1Iii(new byte[]{15, 1, 0, 10, 1, 6}, "894934"))));
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{25, 18, 68, 81, 92, 66, 92, 86, 23, 91, 86, 23, 93, 71, 91, 77, 90, 71, 92, 87, 23, 86, 85, 23, 68, 90, 82, 25, 126, 86, 68, 18, 84, 81, 82, 89, 94, 87, 91, 74, 19, 84, 95, 71, 89, 77, 19, 31}, IL1Iii.IL1Iii(new byte[]{0, 6, 3, 10, 10, 86}, IL1Iii.IL1Iii(new byte[]{85, 85, 85, 80, 12, 86}, "eaac57"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{17}, IL1Iii.IL1Iii(new byte[]{15, 87, 3, 82, 83, 0}, IL1Iii.IL1Iii(new byte[]{84, 81, 87, 4, 0, 11}, "c35329"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(int i, int i2, int i3, ByteBuffer byteBuffer) {
        this.nativeObj = n_Mat(i, i2, i3, byteBuffer);
    }

    public int get(int[] iArr, byte[] bArr) {
        int iType = type();
        if (bArr != null && bArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                    throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{122, 81, 66, 23, 83, 88, 67, 81, 22, 67, 78, 73, 82, 16, 95, 68, 23, 87, 88, 68, 22, 84, 88, 84, 71, 81, 66, 94, 85, 85, 82, 10, 22}, IL1Iii.IL1Iii(new byte[]{81, 0, 4, 5, 85, 8}, IL1Iii.IL1Iii(new byte[]{2, 2, 0, 4, 1, 80}, "d226ca"))) + iType);
                }
                return nGetBIdx(this.nativeObj, iArr, bArr.length, bArr);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{125, 15, 6, 14, 16, 20, 81, 2, 17, 65, 12, 19, 89, 3, 0, 19, 66, 9, 82, 65, 12, 15, 6, 15, 87, 4, 22}, IL1Iii.IL1Iii(new byte[]{85, 84, 80, 87, 7, 95}, IL1Iii.IL1Iii(new byte[]{4, 4, 5, 82, 6, 92}, "e10dce"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{54, 19, 10, 78, 8, 6, 3, 5, 69, 92, 0, 22, 7, 65, 0, 84, 4, 15, 3, 15, 17, 24, 15, 23, 11, 3, 0, 74, 65, 74}, IL1Iii.IL1Iii(new byte[]{3, 7, 92, 92, 82, 83}, IL1Iii.IL1Iii(new byte[]{1, 87, 15, 5, 3, 1}, "d16a00"))));
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{77, 21, 22, 80, 92, 17, 8, 81, 69, 90, 86, 68, 9, 64, 9, 76, 90, 20, 8, 80, 69, 87, 85, 68, 16, 93, 0, 24, 126, 5, 16, 21, 6, 80, 82, 10, 10, 80, 9, 75, 19, 7, 11, 64, 11, 76, 19, 76}, IL1Iii.IL1Iii(new byte[]{83, 6, 4, 94, 0, 83}, IL1Iii.IL1Iii(new byte[]{82, 87, 85, 83, 6, 82}, "ed455e"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{72}, IL1Iii.IL1Iii(new byte[]{83, 3, 88, 4, 84, 84}, IL1Iii.IL1Iii(new byte[]{80, 4, 92, 3, 0, 5}, "b6e2a3"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(int i, int i2, int i3, ByteBuffer byteBuffer, long j) {
        this.nativeObj = n_Mat(i, i2, i3, byteBuffer, j);
    }

    public Mat(Size size, int i) {
        this.nativeObj = n_Mat(size.width, size.height, i);
    }

    /* JADX INFO: renamed from: at */
    public <T> Atable<T> m831at(Class<T> cls, int[] iArr) {
        if (cls != Byte.class && cls != Byte.TYPE) {
            if (cls != Double.class && cls != Double.TYPE) {
                if (cls != Float.class && cls != Float.TYPE) {
                    if (cls != Integer.class && cls != Integer.TYPE) {
                        if (cls != Short.class && cls != Short.TYPE) {
                            throw new RuntimeException(IL1Iii.IL1Iii(new byte[]{109, 12, 18, 22, 19, 22, 87, 16, 21, 6, 7, 70, 91, 14, 0, 16, 16, 70, 72, 3, 19, 2, 14, 3, 76, 7, 19}, IL1Iii.IL1Iii(new byte[]{94, 90, 82, 6, 90, 3}, IL1Iii.IL1Iii(new byte[]{85, 91, 11, 0, 91, 1}, "3c8ebd"))));
                        }
                        return new AtableShort(this, iArr);
                    }
                    return new AtableInteger(this, iArr);
                }
                return new AtableFloat(this, iArr);
            }
            return new AtableDouble(this, iArr);
        }
        return new AtableByte(this, iArr);
    }

    public int put(int i, int i2, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 5) {
                return nPutF(this.nativeObj, i, i2, fArr.length, fArr);
            }
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{41, 88, 23, 69, 93, 86, 16, 88, 67, 17, 64, 71, 1, 25, 10, 22, 25, 89, 11, 77, 67, 6, 86, 90, 20, 88, 23, 12, 91, 91, 1, 3, 67}, IL1Iii.IL1Iii(new byte[]{92, 8, 7, 83, 88, 4}, IL1Iii.IL1Iii(new byte[]{90, 1, 83, 85, 80, 4}, "b07c17"))) + iType);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{103, 17, 10, 20, 12, 93, 82, 7, 69, 6, 4, 77, 86, 67, 0, 14, 0, 84, 82, 13, 17, 66, 11, 76, 90, 1, 0, 16, 69, 17}, IL1Iii.IL1Iii(new byte[]{81, 0, 93, 87, 85, 90}, IL1Iii.IL1Iii(new byte[]{86, 1, 94, 5, 83, 82}, "0bf0c1"))));
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{77, 25, 70, 10, 88, 77, 8, 93, 21, 0, 82, 24, 9, 76, 89, 22, 94, 72, 8, 92, 21, 13, 81, 24, 16, 81, 80, 66, 122, 89, 16, 25, 86, 10, 86, 86, 10, 92, 89, 17, 23, 91, 11, 76, 91, 22, 23, 16}, IL1Iii.IL1Iii(new byte[]{81, 92, 81, 90, 0, 8}, IL1Iii.IL1Iii(new byte[]{81, 93, 83, 9, 83, 5}, "d871d5"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{25}, IL1Iii.IL1Iii(new byte[]{6, 87, 6, 81, 6, 13}, IL1Iii.IL1Iii(new byte[]{2, 81, 7, 81, 84, 83}, "451ccf"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(int[] iArr, int i) {
        this.nativeObj = n_Mat(iArr.length, iArr, i);
    }

    public Mat(int i, int i2, int i3, Scalar scalar) {
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(i, i2, i3, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public int get(int i, int i2, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{122, 7, 71, 19, 6, 2, 67, 7, 19, 71, 27, 19, 82, 70, 90, 64, 66, 13, 88, 18, 19, 80, 13, 14, 71, 7, 71, 90, 0, 15, 82, 92, 19}, IL1Iii.IL1Iii(new byte[]{0, 85, 6, 1, 91, 80}, IL1Iii.IL1Iii(new byte[]{6, 6, 4, 87, 13, 2}, "151e41"))) + iType);
            }
            return nGetS(this.nativeObj, i, i2, sArr.length, sArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{54, 19, 91, 23, 15, 5, 3, 5, 20, 5, 7, 21, 7, 65, 81, 13, 3, 12, 3, 15, 64, 65, 8, 20, 11, 3, 81, 19, 70, 73}, IL1Iii.IL1Iii(new byte[]{86, 84, 1, 2, 5, 4}, IL1Iii.IL1Iii(new byte[]{82, 86, 13, 86, 7, 0}, "bc85de"))));
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{17, 24, 71, 94, 10, 67, 84, 92, 20, 84, 0, 22, 85, 77, 88, 66, 12, 70, 84, 93, 20, 89, 3, 22, 76, 80, 81, 22, 40, 87, 76, 24, 87, 94, 4, 88, 86, 93, 88, 69, 69, 85, 87, 77, 90, 66, 69, 30}, IL1Iii.IL1Iii(new byte[]{10, 89, 12, 15, 86, 1}, IL1Iii.IL1Iii(new byte[]{0, 80, 93, 0, 86, 1}, "21e9e6"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{29}, IL1Iii.IL1Iii(new byte[]{82, 14, 82, 85, 6, 9}, IL1Iii.IL1Iii(new byte[]{82, 13, 81, 87, 0, 92}, "444c2d"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(Size size, int i, Scalar scalar) {
        double d = size.width;
        double d2 = size.height;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(d, d2, i, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public Mat(int[] iArr, int i, Scalar scalar) {
        int length = iArr.length;
        double[] dArr = scalar.val;
        this.nativeObj = n_Mat(length, iArr, i, dArr[0], dArr[1], dArr[2], dArr[3]);
    }

    public int put(int[] iArr, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 5) {
                    return nPutFIdx(this.nativeObj, iArr, fArr.length, fArr);
                }
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{120, 87, 64, 20, 2, 3, 65, 87, 20, 64, 31, 18, 80, 22, 93, 71, 70, 12, 90, 66, 20, 87, 9, 15, 69, 87, 64, 93, 4, 14, 80, 12, 20}, IL1Iii.IL1Iii(new byte[]{0, 80, 87, 3, 86, 1}, IL1Iii.IL1Iii(new byte[]{81, 80, 90, 85, 0, 0}, "d69b0c"))) + iType);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{125, 91, 5, 88, 70, 20, 81, 86, 18, 23, 90, 19, 89, 87, 3, 69, 20, 9, 82, 21, 15, 89, 80, 15, 87, 80, 21}, IL1Iii.IL1Iii(new byte[]{86, 0, 2, 15, 87, 83}, IL1Iii.IL1Iii(new byte[]{7, 1, 7, 90, 1, 6}, "e4cbb3"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{105, 23, 94, 79, 81, 92, 92, 1, 17, 93, 89, 76, 88, 69, 84, 85, 93, 85, 92, 11, 69, 25, 86, 77, 84, 7, 84, 75, 24, 16}, IL1Iii.IL1Iii(new byte[]{0, 0, 4, 14, 10, 12}, IL1Iii.IL1Iii(new byte[]{9, 87, 12, 85, 2, 81}, "029b0e"))));
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{77, 25, 21, 90, 10, 76, 8, 93, 70, 80, 0, 25, 9, 76, 10, 70, 12, 73, 8, 92, 70, 93, 3, 25, 16, 81, 3, 18, 40, 88, 16, 25, 5, 90, 4, 87, 10, 92, 10, 65, 69, 90, 11, 76, 8, 70, 69, 17}, IL1Iii.IL1Iii(new byte[]{81, 9, 80, 10, 82, 91}, IL1Iii.IL1Iii(new byte[]{13, 7, 87, 10, 0, 86}, "87a274"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{31}, IL1Iii.IL1Iii(new byte[]{0, 3, 6, 0, 6, 85}, IL1Iii.IL1Iii(new byte[]{15, 86, 84, 1, 6, 1}, "9c7860"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(Mat mat, Range range, Range range2) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end, range2.start, range2.end);
    }

    public Mat(Mat mat, Range range) {
        this.nativeObj = n_Mat(mat.nativeObj, range.start, range.end);
    }

    public int get(int[] iArr, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                    throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{120, 89, 70, 69, 2, 85, 65, 89, 18, 17, 31, 68, 80, 24, 91, 22, 70, 90, 90, 76, 18, 6, 9, 89, 69, 89, 70, 12, 4, 88, 80, 2, 18}, IL1Iii.IL1Iii(new byte[]{5, 8, 11, 87, 87, 81}, IL1Iii.IL1Iii(new byte[]{85, 6, 15, 81, 1, 93}, "e66c08"))) + iType);
                }
                return nGetSIdx(this.nativeObj, iArr, sArr.length, sArr);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{47, 87, 86, 13, 68, 23, 3, 90, 65, 66, 88, 16, 11, 91, 80, 16, 22, 10, 0, 25, 92, 12, 82, 12, 5, 92, 70}, IL1Iii.IL1Iii(new byte[]{87, 90, 3, 6, 14, 87}, IL1Iii.IL1Iii(new byte[]{3, 82, 4, 80, 10, 5}, "212427"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{102, 64, 88, 79, 11, 84, 83, 86, 23, 93, 3, 68, 87, 18, 82, 85, 7, 93, 83, 92, 67, 25, 12, 69, 91, 80, 82, 75, 66, 24}, IL1Iii.IL1Iii(new byte[]{14, 10, 84, 13, 1, 3}, IL1Iii.IL1Iii(new byte[]{15, 14, 5, 0, 87, 3}, "76f440"))));
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{77, 69, 75, 95, 95, 67, 8, 1, 24, 85, 85, 22, 9, 16, 84, 67, 89, 70, 8, 0, 24, 88, 86, 22, 16, 13, 93, 23, 125, 87, 16, 69, 91, 95, 81, 88, 10, 0, 84, 68, 16, 85, 11, 16, 86, 67, 16, 30}, IL1Iii.IL1Iii(new byte[]{6, 80, 91, 83, 83, 6}, IL1Iii.IL1Iii(new byte[]{0, 4, 85, 6, 1, 4}, "b16bb4"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{17}, IL1Iii.IL1Iii(new byte[]{89, 10, 1, 84, 2, 2}, IL1Iii.IL1Iii(new byte[]{82, 5, 87, 4, 7, 83}, "36e22c"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public Mat(Mat mat, Range[] rangeArr) {
        this.nativeObj = n_Mat(mat.nativeObj, rangeArr);
    }

    public Mat(Mat mat, Rect rect) {
        long j = mat.nativeObj;
        int i = rect.f904y;
        int i2 = i + rect.height;
        int i3 = rect.f903x;
        this.nativeObj = n_Mat(j, i, i2, i3, i3 + rect.width);
    }

    public int put(int i, int i2, int[] iArr) {
        int iType = type();
        if (iArr != null && iArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 4) {
                return nPutI(this.nativeObj, i, i2, iArr.length, iArr);
            }
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{123, 84, 67, 65, 7, 82, 66, 84, 23, 21, 26, 67, 83, 21, 94, 18, 67, 93, 89, 65, 23, 2, 12, 94, 70, 84, 67, 8, 1, 95, 83, 15, 23}, IL1Iii.IL1Iii(new byte[]{0, 84, 84, 86, 5, 10}, IL1Iii.IL1Iii(new byte[]{85, 89, 6, 0, 83, 0}, "c8e759"))) + iType);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{53, 70, 13, 16, 80, 83, 0, 80, 66, 2, 88, 67, 4, 20, 7, 10, 92, 90, 0, 90, 22, 70, 87, 66, 8, 86, 7, 20, 25, 31}, IL1Iii.IL1Iii(new byte[]{80, 2, 81, 84, 92, 3}, IL1Iii.IL1Iii(new byte[]{5, 4, 80, 81, 7, 0}, "02ccb4"))));
        sb.append(iArr == null ? 0 : iArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{26, 23, 22, 80, 93, 69, 95, 83, 69, 90, 87, 16, 94, 66, 9, 76, 91, 64, 95, 82, 69, 87, 84, 16, 71, 95, 0, 24, 127, 81, 71, 23, 6, 80, 83, 94, 93, 82, 9, 75, 18, 83, 92, 66, 11, 76, 18, 24}, IL1Iii.IL1Iii(new byte[]{81, 4, 87, 0, 6, 83}, IL1Iii.IL1Iii(new byte[]{1, 87, 4, 8, 85, 90}, "cd60a9"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{76}, IL1Iii.IL1Iii(new byte[]{80, 85, 9, 13, 81, 4}, IL1Iii.IL1Iii(new byte[]{1, 0, 90, 10, 0, 4}, "47b2db"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int i, int i2, int[] iArr) {
        int iType = type();
        if (iArr != null && iArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 4) {
                return nGetI(this.nativeObj, i, i2, iArr.length, iArr);
            }
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{125, 5, 23, 67, 2, 88, 68, 5, 67, 23, 31, 73, 85, 68, 10, 16, 70, 87, 95, 16, 67, 0, 9, 84, 64, 5, 23, 10, 4, 85, 85, 94, 67}, IL1Iii.IL1Iii(new byte[]{4, 85, 86, 90, 95, 10}, IL1Iii.IL1Iii(new byte[]{86, 7, 6, 1, 91, 2}, "b638b1"))) + iType);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{51, 69, 90, 64, 93, 92, 6, 83, 21, 82, 85, 76, 2, 23, 80, 90, 81, 85, 6, 89, 65, 22, 90, 77, 14, 85, 80, 68, 20, 16}, IL1Iii.IL1Iii(new byte[]{86, 14, 81, 83, 2, 0}, IL1Iii.IL1Iii(new byte[]{86, 1, 83, 3, 84, 1}, "c87fb9"))));
        sb.append(iArr == null ? 0 : iArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{77, 23, 65, 91, 89, 68, 8, 83, 18, 81, 83, 17, 9, 66, 94, 71, 95, 65, 8, 82, 18, 92, 80, 17, 16, 95, 87, 19, 123, 80, 16, 23, 81, 91, 87, 95, 10, 82, 94, 64, 22, 82, 11, 66, 92, 71, 22, 25}, IL1Iii.IL1Iii(new byte[]{84, 83, 10, 80, 5, 0}, IL1Iii.IL1Iii(new byte[]{85, 83, 9, 82, 82, 7}, "e711a6"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{30}, IL1Iii.IL1Iii(new byte[]{82, 85, 85, 15, 5, 90}, IL1Iii.IL1Iii(new byte[]{0, 14, 3, 83, 89, 0}, "e90e8b"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int[] iArr, int[] iArr2) {
        int iType = type();
        if (iArr2 != null && iArr2.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 4) {
                    return nPutIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
                }
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{122, 4, 64, 65, 87, 89, 67, 4, 20, 21, 74, 72, 82, 69, 93, 18, 19, 86, 88, 17, 20, 2, 92, 85, 71, 4, 64, 8, 81, 84, 82, 95, 20}, IL1Iii.IL1Iii(new byte[]{83, 85, 3, 3, 6, 0}, IL1Iii.IL1Iii(new byte[]{93, 84, 3, 4, 1, 91}, "9d4f4c"))) + iType);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{42, 90, 0, 88, 20, 20, 6, 87, 23, 23, 8, 19, 14, 86, 6, 69, 70, 9, 5, 20, 10, 89, 2, 15, 0, 81, 16}, IL1Iii.IL1Iii(new byte[]{7, 13, 90, 82, 5, 85}, IL1Iii.IL1Iii(new byte[]{81, 14, 92, 82, 6, 2}, "57e7e1"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{98, 74, 86, 16, 80, 87, 87, 92, 25, 2, 88, 71, 83, 24, 92, 10, 92, 94, 87, 86, 77, 70, 87, 70, 95, 90, 92, 20, 25, 27}, IL1Iii.IL1Iii(new byte[]{4, 0, 8, 80, 91, 3}, IL1Iii.IL1Iii(new byte[]{84, 12, 84, 80, 1, 7}, "b4efc7"))));
        sb.append(iArr2 == null ? 0 : iArr2.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{31, 17, 16, 95, 93, 76, 90, 85, 67, 85, 87, 25, 91, 68, 15, 67, 91, 73, 90, 84, 67, 88, 84, 25, 66, 89, 6, 23, 127, 88, 66, 17, 0, 95, 83, 87, 88, 84, 15, 68, 18, 90, 89, 68, 13, 67, 18, 17}, IL1Iii.IL1Iii(new byte[]{15, 8, 85, 14, 84, 14}, IL1Iii.IL1Iii(new byte[]{95, 14, 15, 11, 5, 83}, "f792cd"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{28}, IL1Iii.IL1Iii(new byte[]{7, 3, 90, 1, 81, 92}, IL1Iii.IL1Iii(new byte[]{83, 4, 10, 0, 81, 84}, "a03531"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int[] iArr, int[] iArr2) {
        int iType = type();
        if (iArr2 != null && iArr2.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 4) {
                    return nGetIIdx(this.nativeObj, iArr, iArr2.length, iArr2);
                }
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{121, 2, 23, 18, 82, 5, 64, 2, 67, 70, 79, 20, 81, 67, 10, 65, 22, 10, 91, 23, 67, 81, 89, 9, 68, 2, 23, 91, 84, 8, 81, 89, 67}, IL1Iii.IL1Iii(new byte[]{80, 80, 86, 10, 85, 93}, IL1Iii.IL1Iii(new byte[]{82, 6, 84, 93, 86, 15}, "65ae56"))) + iType);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{122, 93, 5, 13, 66, 68, 86, 80, 18, 66, 94, 67, 94, 81, 3, 16, 16, 89, 85, 19, 15, 12, 84, 95, 80, 86, 21}, IL1Iii.IL1Iii(new byte[]{2, 80, 86, 83, 5, 80}, IL1Iii.IL1Iii(new byte[]{3, 91, 2, 85, 86, 95}, "282dc9"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{96, 19, 92, 16, 11, 86, 85, 5, 19, 2, 3, 70, 81, 65, 86, 10, 7, 95, 85, 15, 71, 70, 12, 71, 93, 3, 86, 20, 66, 26}, IL1Iii.IL1Iii(new byte[]{81, 89, 5, 4, 3, 2}, IL1Iii.IL1Iii(new byte[]{88, 93, 82, 81, 87, 4}, "9ed364"))));
        sb.append(iArr2 == null ? 0 : iArr2.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{74, 18, 21, 12, 94, 67, 15, 86, 70, 6, 84, 22, 14, 71, 10, 16, 88, 70, 15, 87, 70, 11, 87, 22, 23, 90, 3, 68, 124, 87, 23, 18, 5, 12, 80, 88, 13, 87, 10, 23, 17, 85, 12, 71, 8, 16, 17, 30}, IL1Iii.IL1Iii(new byte[]{1, 84, 80, 0, 85, 7}, IL1Iii.IL1Iii(new byte[]{0, 85, 80, 83, 7, 8}, "b3f7c9"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{28}, IL1Iii.IL1Iii(new byte[]{0, 83, 86, 84, 87, 5}, IL1Iii.IL1Iii(new byte[]{5, 7, 86, 81, 7, 5}, "0b3d21"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int i, int i2, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{124, 7, 68, 17, 81, 87, 69, 7, 16, 69, 76, 70, 84, 70, 89, 66, 21, 88, 94, 18, 16, 82, 90, 91, 65, 7, 68, 88, 87, 90, 84, 92, 16}, IL1Iii.IL1Iii(new byte[]{5, 2, 82, 7, 84, 1}, IL1Iii.IL1Iii(new byte[]{86, 0, 81, 85, 87, 3}, "bd3c64"))) + iType);
            }
            return nPutS(this.nativeObj, i, i2, sArr.length, sArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{52, 68, 87, 23, 95, 5, 1, 82, 24, 5, 87, 21, 5, 22, 93, 13, 83, 12, 1, 88, 76, 65, 88, 20, 9, 84, 93, 19, 22, 73}, IL1Iii.IL1Iii(new byte[]{86, 4, 94, 4, 82, 7}, IL1Iii.IL1Iii(new byte[]{87, 5, 94, 1, 92, 84}, "e78d82"))));
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{27, 24, 22, 14, 88, 70, 94, 92, 69, 4, 82, 19, 95, 77, 9, 18, 94, 67, 94, 93, 69, 9, 81, 19, 70, 80, 0, 70, 122, 82, 70, 24, 6, 14, 86, 93, 92, 93, 9, 21, 23, 80, 93, 77, 11, 18, 23, 27}, IL1Iii.IL1Iii(new byte[]{83, 91, 81, 82, 4, 3}, IL1Iii.IL1Iii(new byte[]{84, 6, 0, 80, 6, 85}, "5e4d5e"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{74}, IL1Iii.IL1Iii(new byte[]{86, 86, 90, 91, 7, 87}, IL1Iii.IL1Iii(new byte[]{6, 86, 92, 90, 4, 7}, "3ceb2a"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int i, int i2, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 5) {
                return nGetF(this.nativeObj, i, i2, fArr.length, fArr);
            }
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{41, 82, 77, 66, 82, 85, 16, 82, 25, 22, 79, 68, 1, 19, 80, 17, 22, 90, 11, 71, 25, 1, 89, 89, 20, 82, 77, 11, 84, 88, 1, 9, 25}, IL1Iii.IL1Iii(new byte[]{80, 1, 14, 80, 87, 4}, IL1Iii.IL1Iii(new byte[]{7, 80, 86, 7, 3, 1}, "3ba5b1"))) + iType);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{51, 23, 95, 78, 13, 93, 6, 1, 16, 92, 5, 77, 2, 69, 85, 84, 1, 84, 6, 11, 68, 24, 10, 76, 14, 7, 85, 74, 68, 17}, IL1Iii.IL1Iii(new byte[]{87, 93, 4, 92, 7, 88}, IL1Iii.IL1Iii(new byte[]{81, 1, 82, 2, 83, 7}, "e9ff0f"))));
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{77, 23, 74, 89, 10, 19, 8, 83, 25, 83, 0, 70, 9, 66, 85, 69, 12, 22, 8, 82, 25, 94, 3, 70, 16, 95, 92, 17, 40, 7, 16, 23, 90, 89, 4, 8, 10, 82, 85, 66, 69, 5, 11, 66, 87, 69, 69, 78}, IL1Iii.IL1Iii(new byte[]{2, 3, 92, 3, 84, 3}, IL1Iii.IL1Iii(new byte[]{82, 12, 1, 84, 0, 81}, "48df14"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{16}, IL1Iii.IL1Iii(new byte[]{92, 7, 80, 93, 87, 14}, IL1Iii.IL1Iii(new byte[]{80, 81, 6, 85, 7, 85}, "50412c"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int[] iArr, short[] sArr) {
        int iType = type();
        if (sArr != null && sArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 2 && CvType.depth(iType) != 3) {
                    throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{117, 87, 17, 65, 82, 0, 76, 87, 69, 21, 79, 17, 93, 22, 12, 18, 22, 15, 87, 66, 69, 2, 89, 12, 72, 87, 17, 8, 84, 13, 93, 12, 69}, IL1Iii.IL1Iii(new byte[]{15, 5, 85, 89, 7, 4}, IL1Iii.IL1Iii(new byte[]{86, 2, 83, 11, 2, 82}, "a1c337"))) + iType);
                }
                return nPutSIdx(this.nativeObj, iArr, sArr.length, sArr);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{126, 91, 85, 94, 65, 65, 82, 86, 66, 17, 93, 70, 90, 87, 83, 67, 19, 92, 81, 21, 95, 95, 87, 90, 84, 80, 69}, IL1Iii.IL1Iii(new byte[]{83, 13, 87, 5, 86, 10}, IL1Iii.IL1Iii(new byte[]{87, 92, 3, 1, 80, 91}, "3db55b"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{105, 70, 95, 21, 89, 2, 92, 80, 16, 7, 81, 18, 88, 20, 85, 15, 85, 11, 92, 90, 68, 67, 94, 19, 84, 86, 85, 17, 16, 78}, IL1Iii.IL1Iii(new byte[]{14, 7, 2, 1, 6, 94}, IL1Iii.IL1Iii(new byte[]{3, 2, 3, 0, 87, 1}, "411ba9"))));
        sb.append(sArr == null ? 0 : sArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{28, 67, 64, 12, 10, 68, 89, 7, 19, 6, 0, 17, 88, 22, 95, 16, 12, 65, 89, 6, 19, 11, 3, 17, 65, 11, 86, 68, 40, 80, 65, 67, 80, 12, 4, 95, 91, 6, 95, 23, 69, 82, 90, 22, 93, 16, 69, 25}, IL1Iii.IL1Iii(new byte[]{2, 87, 6, 1, 7, 87}, IL1Iii.IL1Iii(new byte[]{84, 81, 7, 86, 6, 80}, "ce23d6"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{72}, IL1Iii.IL1Iii(new byte[]{85, 82, 87, 81, 0, 93}, IL1Iii.IL1Iii(new byte[]{0, 1, 0, 82, 1, 90}, "46b79b"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int[] iArr, float[] fArr) {
        int iType = type();
        if (fArr != null && fArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 5) {
                    return nGetFIdx(this.nativeObj, iArr, fArr.length, fArr);
                }
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{124, 7, 22, 22, 0, 4, 69, 7, 66, 66, 29, 21, 84, 70, 11, 69, 68, 11, 94, 18, 66, 85, 11, 8, 65, 7, 22, 95, 6, 9, 84, 92, 66}, IL1Iii.IL1Iii(new byte[]{7, 82, 86, 14, 93, 1}, IL1Iii.IL1Iii(new byte[]{83, 7, 86, 90, 1, 1}, "e3bb8e"))) + iType);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{122, 12, 91, 95, 68, 75, 86, 1, 76, 16, 88, 76, 94, 0, 93, 66, 22, 86, 85, 66, 81, 94, 82, 80, 80, 7, 75}, IL1Iii.IL1Iii(new byte[]{11, 1, 10, 1, 7, 90}, IL1Iii.IL1Iii(new byte[]{15, 0, 2, 85, 6, 85}, "7c0d76"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{101, 23, 94, 16, 92, 5, 80, 1, 17, 2, 84, 21, 84, 69, 84, 10, 80, 12, 80, 11, 69, 70, 91, 20, 88, 7, 84, 20, 21, 73}, IL1Iii.IL1Iii(new byte[]{4, 3, 7, 4, 7, 86}, IL1Iii.IL1Iii(new byte[]{80, 5, 4, 86, 80, 14}, "ac24b9"))));
        sb.append(fArr == null ? 0 : fArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{77, 24, 16, 93, 14, 16, 8, 92, 67, 87, 4, 69, 9, 77, 15, 65, 8, 21, 8, 93, 67, 90, 7, 69, 16, 80, 6, 21, 44, 4, 16, 24, 0, 93, 0, 11, 10, 93, 15, 70, 65, 6, 11, 77, 13, 65, 65, 77}, IL1Iii.IL1Iii(new byte[]{93, 89, 0, 7, 4, 81}, IL1Iii.IL1Iii(new byte[]{88, 81, 87, 3, 1, 3}, "a041d7"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{31}, IL1Iii.IL1Iii(new byte[]{0, 83, 0, 83, 5, 84}, IL1Iii.IL1Iii(new byte[]{7, 85, 83, 7, 2, 85}, "1c764b"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int i, int i2, byte[] bArr) {
        int iType = type();
        if (bArr != null && bArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{123, 87, 64, 69, 80, 88, 66, 87, 20, 17, 77, 73, 83, 22, 93, 22, 20, 87, 89, 66, 20, 6, 91, 84, 70, 87, 64, 12, 86, 85, 83, 12, 20}, IL1Iii.IL1Iii(new byte[]{83, 1, 0, 80, 80, 90}, IL1Iii.IL1Iii(new byte[]{83, 85, 81, 3, 87, 90}, "6be639"))) + iType);
            }
            return nPutB(this.nativeObj, i, i2, bArr.length, bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{53, 75, 90, 65, 89, 87, 0, 93, 21, 83, 81, 71, 4, 25, 80, 91, 85, 94, 0, 87, 65, 23, 94, 70, 8, 91, 80, 69, 16, 27}, IL1Iii.IL1Iii(new byte[]{86, 0, 4, 83, 6, 86}, IL1Iii.IL1Iii(new byte[]{7, 93, 3, 84, 14, 3}, "4d208f"))));
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{24, 70, 65, 10, 88, 68, 93, 2, 18, 0, 82, 17, 92, 19, 94, 22, 94, 65, 93, 3, 18, 13, 81, 17, 69, 14, 87, 66, 122, 80, 69, 70, 81, 10, 86, 95, 95, 3, 94, 17, 23, 82, 94, 19, 92, 22, 23, 25}, IL1Iii.IL1Iii(new byte[]{2, 87, 84, 81, 86, 84}, IL1Iii.IL1Iii(new byte[]{1, 7, 80, 4, 80, 81}, "266714"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{25}, IL1Iii.IL1Iii(new byte[]{1, 4, 2, 5, 83, 1}, IL1Iii.IL1Iii(new byte[]{85, 82, 12, 87, 83, 85}, "de84dc"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int i, int i2, double[] dArr) {
        int iType = type();
        if (dArr != null && dArr.length % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) == 6) {
                return nGetD(this.nativeObj, i, i2, dArr.length, dArr);
            }
            throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{44, 4, 21, 17, 93, 88, 21, 4, 65, 69, 64, 73, 4, 69, 8, 66, 25, 87, 14, 17, 65, 82, 86, 84, 17, 4, 21, 88, 91, 85, 4, 95, 65}, IL1Iii.IL1Iii(new byte[]{3, 85, 87, 7, 9, 91}, IL1Iii.IL1Iii(new byte[]{90, 85, 1, 6, 0, 91}, "8e7009"))) + iType);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{103, 20, 13, 79, 91, 6, 82, 2, 66, 93, 83, 22, 86, 70, 7, 85, 87, 15, 82, 8, 22, 25, 92, 23, 90, 4, 7, 75, 18, 74}, IL1Iii.IL1Iii(new byte[]{3, 83, 82, 93, 80, 83}, IL1Iii.IL1Iii(new byte[]{12, 3, 8, 87, 7, 7}, "8683e6"))));
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{28, 17, 64, 94, 87, 17, 89, 85, 19, 84, 93, 68, 88, 68, 95, 66, 81, 20, 89, 84, 19, 89, 94, 68, 65, 89, 86, 22, 117, 5, 65, 17, 80, 94, 89, 10, 91, 84, 95, 69, 24, 7, 90, 68, 93, 66, 24, 76}, IL1Iii.IL1Iii(new byte[]{0, 85, 0, 1, 10, 93}, IL1Iii.IL1Iii(new byte[]{86, 2, 0, 0, 3, 14}, "cf3717"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{76}, IL1Iii.IL1Iii(new byte[]{81, 13, 6, 2, 94, 8}, IL1Iii.IL1Iii(new byte[]{4, 92, 0, 82, 14, 4}, "0e6664"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int[] iArr, byte[] bArr) {
        int iType = type();
        if (bArr != null && bArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                    throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{43, 82, 70, 18, 86, 87, 18, 82, 18, 70, 75, 70, 3, 19, 91, 65, 18, 88, 9, 71, 18, 81, 93, 91, 22, 82, 70, 91, 80, 90, 3, 9, 18}, IL1Iii.IL1Iii(new byte[]{5, 82, 3, 86, 11, 85}, IL1Iii.IL1Iii(new byte[]{5, 81, 2, 0, 93, 84}, "f03dd7"))) + iType);
                }
                return nPutBIdx(this.nativeObj, iArr, bArr.length, bArr);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{47, 87, 84, 86, 19, 66, 3, 90, 67, 25, 15, 69, 11, 91, 82, 75, 65, 95, 0, 25, 94, 87, 5, 89, 5, 92, 68}, IL1Iii.IL1Iii(new byte[]{94, 91, 0, 15, 81, 86}, IL1Iii.IL1Iii(new byte[]{90, 84, 15, 84, 2, 94}, "b68b28"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{102, 69, 93, 69, 92, 86, 83, 83, 18, 87, 84, 70, 87, 23, 87, 95, 80, 95, 83, 89, 70, 19, 91, 71, 91, 85, 87, 65, 21, 26}, IL1Iii.IL1Iii(new byte[]{87, 2, 1, 1, 80, 81}, IL1Iii.IL1Iii(new byte[]{3, 6, 87, 0, 83, 84}, "b3d267"))));
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{27, 70, 66, 94, 95, 19, 94, 2, 17, 84, 85, 70, 95, 19, 93, 66, 89, 22, 94, 3, 17, 89, 86, 70, 70, 14, 84, 22, 125, 7, 70, 70, 82, 94, 81, 8, 92, 3, 93, 69, 16, 5, 93, 19, 95, 66, 16, 78}, IL1Iii.IL1Iii(new byte[]{1, 80, 6, 80, 5, 4}, IL1Iii.IL1Iii(new byte[]{0, 2, 85, 84, 4, 81}, "34b213"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{74}, IL1Iii.IL1Iii(new byte[]{0, 86, 86, 0, 5, 7}, IL1Iii.IL1Iii(new byte[]{2, 84, 81, 1, 4, 14}, "a5b6e8"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int get(int[] iArr, double[] dArr) {
        int iType = type();
        if (dArr != null && dArr.length % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) == 6) {
                    return nGetDIdx(this.nativeObj, iArr, dArr.length, dArr);
                }
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{46, 80, 65, 16, 5, 89, 23, 80, 21, 68, 24, 72, 6, 17, 92, 67, 65, 86, 12, 69, 21, 83, 14, 85, 19, 80, 65, 89, 3, 84, 6, 11, 21}, IL1Iii.IL1Iii(new byte[]{83, 84, 87, 86, 83, 15}, IL1Iii.IL1Iii(new byte[]{82, 84, 1, 82, 80, 0}, "b1c4b7"))) + iType);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{127, 87, 0, 95, 65, 20, 83, 90, 23, 16, 93, 19, 91, 91, 6, 66, 19, 9, 80, 25, 10, 94, 87, 15, 85, 92, 16}, IL1Iii.IL1Iii(new byte[]{85, 88, 81, 84, 0, 85}, IL1Iii.IL1Iii(new byte[]{80, 89, 6, 82, 7, 6}, "384645"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{49, 16, 11, 18, 12, 83, 4, 6, 68, 0, 4, 67, 0, 66, 1, 8, 0, 90, 4, 12, 16, 68, 11, 66, 12, 0, 1, 22, 69, 31}, IL1Iii.IL1Iii(new byte[]{85, 3, 87, 87, 4, 1}, IL1Iii.IL1Iii(new byte[]{6, 82, 87, 0, 86, 5}, "23d373"))));
        sb.append(dArr == null ? 0 : dArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{27, 67, 65, 13, 10, 67, 94, 7, 18, 7, 0, 22, 95, 22, 94, 17, 12, 70, 94, 6, 18, 10, 3, 22, 70, 11, 87, 69, 40, 87, 70, 67, 81, 13, 4, 88, 92, 6, 94, 22, 69, 85, 93, 22, 92, 17, 69, 30}, IL1Iii.IL1Iii(new byte[]{83, 7, 2, 92, 4, 3}, IL1Iii.IL1Iii(new byte[]{85, 1, 83, 13, 5, 13}, "4ec4d8"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{31}, IL1Iii.IL1Iii(new byte[]{87, 82, 0, 9, 2, 86}, IL1Iii.IL1Iii(new byte[]{88, 81, 81, 0, 83, 7}, "9f392b"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public int put(int i, int i2, byte[] bArr, int i3, int i4) {
        int iType = type();
        if (bArr != null && i4 % CvType.channels(iType) == 0) {
            if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{123, 80, 23, 19, 85, 5, 66, 80, 67, 71, 72, 20, 83, 17, 10, 64, 17, 10, 89, 69, 67, 80, 94, 9, 70, 80, 23, 90, 83, 8, 83, 11, 67}, IL1Iii.IL1Iii(new byte[]{4, 82, 84, 85, 7, 82}, IL1Iii.IL1Iii(new byte[]{0, 83, 5, 4, 2, 6}, "202b40"))) + iType);
            }
            return nPutBwOffset(this.nativeObj, i, i2, i4, i3, bArr);
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{54, 71, 86, 21, 90, 0, 3, 81, 25, 7, 82, 16, 7, 21, 92, 15, 86, 9, 3, 91, 77, 67, 93, 17, 11, 87, 92, 17, 19, 76}, IL1Iii.IL1Iii(new byte[]{87, 81, 91, 6, 6, 1}, IL1Iii.IL1Iii(new byte[]{4, 86, 90, 92, 81, 92}, "5289d9"))));
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{17, 68, 74, 91, 90, 68, 84, 0, 25, 81, 80, 17, 85, 17, 85, 71, 92, 65, 84, 1, 25, 92, 83, 17, 76, 12, 92, 19, 120, 80, 76, 68, 90, 91, 84, 95, 86, 1, 85, 64, 21, 82, 87, 17, 87, 71, 21, 25}, IL1Iii.IL1Iii(new byte[]{0, 86, 13, 4, 6, 4}, IL1Iii.IL1Iii(new byte[]{93, 6, 85, 14, 5, 12}, "e4a969"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{27}, IL1Iii.IL1Iii(new byte[]{4, 90, 1, 5, 82, 4}, IL1Iii.IL1Iii(new byte[]{7, 10, 0, 86, 4, 82}, "13ec30"))));
        throw new UnsupportedOperationException(sb.toString());
    }

    public double[] get(int i, int i2) {
        return nGet(this.nativeObj, i, i2);
    }

    public double[] get(int[] iArr) {
        if (iArr.length == dims()) {
            return nGetIdx(this.nativeObj, iArr);
        }
        throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{45, 13, 7, 9, 71, 66, 1, 0, 16, 70, 91, 69, 9, 1, 1, 20, 21, 95, 2, 67, 13, 8, 81, 89, 7, 6, 23}, IL1Iii.IL1Iii(new byte[]{82, 1, 86, 82, 3, 82}, IL1Iii.IL1Iii(new byte[]{83, 84, 81, 2, 3, 1}, "e6c65c"))));
    }

    public int put(int[] iArr, byte[] bArr, int i, int i2) {
        int iType = type();
        if (bArr != null && i2 % CvType.channels(iType) == 0) {
            if (iArr.length == dims()) {
                if (CvType.depth(iType) != 0 && CvType.depth(iType) != 1) {
                    throw new UnsupportedOperationException(IL1Iii.IL1Iii(new byte[]{126, 80, 70, 68, 86, 2, 71, 80, 18, 16, 75, 19, 86, 17, 91, 23, 18, 13, 92, 69, 18, 7, 93, 14, 67, 80, 70, 13, 80, 15, 86, 11, 18}, IL1Iii.IL1Iii(new byte[]{3, 82, 4, 6, 81, 86}, IL1Iii.IL1Iii(new byte[]{86, 81, 2, 82, 84, 2}, "f24077"))) + iType);
                }
                return nPutBwIdxOffset(this.nativeObj, iArr, i2, i, bArr);
            }
            throw new IllegalArgumentException(IL1Iii.IL1Iii(new byte[]{45, 88, 84, 13, 64, 16, 1, 85, 67, 66, 92, 23, 9, 84, 82, 16, 18, 13, 2, 22, 94, 12, 86, 11, 7, 83, 68}, IL1Iii.IL1Iii(new byte[]{85, 0, 82, 87, 87, 83}, IL1Iii.IL1Iii(new byte[]{7, 14, 92, 4, 81, 4}, "689145"))));
        }
        StringBuilder sb = new StringBuilder();
        sb.append(IL1Iii.IL1Iii(new byte[]{97, 66, 88, 78, 80, 83, 84, 84, 23, 92, 88, 67, 80, 16, 82, 84, 92, 90, 84, 94, 67, 24, 87, 66, 92, 82, 82, 74, 25, 31}, IL1Iii.IL1Iii(new byte[]{8, 83, 82, 91, 10, 81}, IL1Iii.IL1Iii(new byte[]{11, 91, 82, 90, 7, 2}, "28794d"))));
        sb.append(bArr == null ? 0 : bArr.length);
        sb.append(IL1Iii.IL1Iii(new byte[]{26, 69, 68, 89, 13, 19, 95, 1, 23, 83, 7, 70, 94, 16, 91, 69, 11, 22, 95, 0, 23, 94, 4, 70, 71, 13, 82, 17, 47, 7, 71, 69, 84, 89, 3, 8, 93, 0, 91, 66, 66, 5, 92, 16, 89, 69, 66, 78}, IL1Iii.IL1Iii(new byte[]{85, 85, 86, 87, 90, 80}, IL1Iii.IL1Iii(new byte[]{82, 81, 83, 86, 89, 4}, "4a20a2"))));
        sb.append(CvType.channels(iType));
        sb.append(IL1Iii.IL1Iii(new byte[]{25}, IL1Iii.IL1Iii(new byte[]{9, 86, 4, 81, 85, 4}, IL1Iii.IL1Iii(new byte[]{13, 7, 2, 0, 81, 1}, "4f7cec"))));
        throw new UnsupportedOperationException(sb.toString());
    }
}
