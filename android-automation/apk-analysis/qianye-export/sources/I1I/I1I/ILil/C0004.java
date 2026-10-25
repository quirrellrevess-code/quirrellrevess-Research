package I1I.I1I.ILil;

import android.graphics.Bitmap;
import android.media.Image;
import android.util.Log;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.nio.ByteBuffer;

/* JADX INFO: renamed from: I1I.I1I.ILil.丨丨 */
/* JADX INFO: compiled from: ImageWraper.java */
/* JADX INFO: loaded from: classes.dex */
public class C0004 implements Serializable {
    private ByteBuffer mBuffer;
    private int mHeight;
    private int mPixelStride;
    private int mRowStride;
    private int mWidth;

    public C0004(Image image) {
        this.mPixelStride = 0;
        this.mRowStride = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mBuffer = null;
        Image.Plane[] planes = image.getPlanes();
        this.mPixelStride = planes[0].getPixelStride();
        this.mRowStride = planes[0].getRowStride();
        this.mWidth = image.getWidth();
        this.mHeight = image.getHeight();
        ByteBuffer byteBufferAllocate = ByteBuffer.allocate(planes[0].getBuffer().capacity());
        this.mBuffer = byteBufferAllocate;
        byteBufferAllocate.put(planes[0].getBuffer().duplicate());
        image.getFormat();
        this.mBuffer.flip();
    }

    private void readObject(ObjectInputStream objectInputStream) throws IOException, ClassNotFoundException {
        this.mPixelStride = objectInputStream.readInt();
        this.mRowStride = objectInputStream.readInt();
        this.mWidth = objectInputStream.readInt();
        this.mHeight = objectInputStream.readInt();
        int i = objectInputStream.readInt();
        byte[] bArr = new byte[i];
        objectInputStream.readFully(bArr);
        ByteBuffer byteBufferWrap = ByteBuffer.wrap(bArr);
        this.mBuffer = byteBufferWrap;
        byteBufferWrap.limit(i);
    }

    private void writeObject(ObjectOutputStream objectOutputStream) throws IOException {
        objectOutputStream.writeInt(this.mPixelStride);
        objectOutputStream.writeInt(this.mRowStride);
        objectOutputStream.writeInt(this.mWidth);
        objectOutputStream.writeInt(this.mHeight);
        byte[] bArrArray = this.mBuffer.array();
        int iLimit = this.mBuffer.limit();
        objectOutputStream.writeInt(iLimit);
        objectOutputStream.write(bArrArray, 0, iLimit);
    }

    public void copyPixelsToBuffer(ByteBuffer byteBuffer) {
        try {
            if (this.mBuffer == null || byteBuffer.capacity() < this.mBuffer.capacity()) {
                return;
            }
            byteBuffer.put(this.mBuffer.duplicate());
        } catch (Exception unused) {
        }
    }

    public int getHeight() {
        return this.mHeight;
    }

    public int getRowStride() {
        return this.mRowStride;
    }

    public int getWidth() {
        return this.mWidth;
    }

    public Bitmap toBitmap() {
        try {
            ByteBuffer byteBuffer = this.mBuffer;
            if (byteBuffer == null) {
                return null;
            }
            int i = this.mPixelStride;
            int i2 = this.mRowStride;
            int i3 = this.mWidth;
            Bitmap bitmapCreateBitmap = Bitmap.createBitmap(i3 + ((i2 - (i * i3)) / i), this.mHeight, Bitmap.Config.ARGB_8888);
            byteBuffer.position(0);
            bitmapCreateBitmap.copyPixelsFromBuffer(byteBuffer);
            byteBuffer.position(0);
            return bitmapCreateBitmap;
        } catch (Exception e) {
            Log.i(I1I.IL1Iii.IL1Iii(new byte[]{118, 105}, I1I.IL1Iii.IL1Iii(new byte[]{92, 1, 3, 9, 84, 0}, I1I.IL1Iii.IL1Iii(new byte[]{2, 7, 2, 8, 7, 2}, "f740ec"))), I1I.IL1Iii.IL1Iii(new byte[]{77, 14, 112, 12, 16, 94, 88, 17}, I1I.IL1Iii.IL1Iii(new byte[]{0, 85, 81, 93, 2, 5}, I1I.IL1Iii.IL1Iii(new byte[]{13, 80, 6, 1, 82, 6}, "4de940"))) + e.toString());
            return null;
        }
    }

    public C0004(Bitmap bitmap) {
        this.mPixelStride = 0;
        this.mRowStride = 0;
        this.mWidth = 0;
        this.mHeight = 0;
        this.mBuffer = null;
        this.mRowStride = bitmap.getRowBytes();
        this.mWidth = bitmap.getWidth();
        this.mHeight = bitmap.getHeight();
        this.mPixelStride = 4;
        ByteBuffer byteBufferAllocateDirect = ByteBuffer.allocateDirect(bitmap.getRowBytes() * bitmap.getHeight());
        this.mBuffer = byteBufferAllocateDirect;
        bitmap.copyPixelsToBuffer(byteBufferAllocateDirect);
        this.mBuffer.flip();
    }
}
