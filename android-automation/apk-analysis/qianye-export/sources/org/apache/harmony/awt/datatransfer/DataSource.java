package org.apache.harmony.awt.datatransfer;

import java.awt.Graphics;
import java.awt.Image;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.SystemFlavorMap;
import java.awt.datatransfer.Transferable;
import java.awt.image.BufferedImage;
import java.awt.image.DataBufferInt;
import java.awt.image.ImageObserver;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.io.Reader;
import java.io.Serializable;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: loaded from: classes.dex */
public class DataSource implements DataProvider {
    public final Transferable contents;
    private DataFlavor[] flavors;
    private List<String> nativeFormats;

    public DataSource(Transferable transferable) {
        this.contents = transferable;
    }

    private RawBitmap getImageBitmap(Image image) {
        if (image instanceof BufferedImage) {
            BufferedImage bufferedImage = (BufferedImage) image;
            if (bufferedImage.getType() == 1) {
                return getImageBitmap32(bufferedImage);
            }
        }
        int width = image.getWidth((ImageObserver) null);
        int height = image.getHeight((ImageObserver) null);
        if (width <= 0 || height <= 0) {
            return null;
        }
        BufferedImage bufferedImage2 = new BufferedImage(width, height, 1);
        Graphics graphics = bufferedImage2.getGraphics();
        graphics.drawImage(image, 0, 0, (ImageObserver) null);
        graphics.dispose();
        return getImageBitmap32(bufferedImage2);
    }

    private RawBitmap getImageBitmap32(BufferedImage bufferedImage) {
        int[] iArr = new int[bufferedImage.getWidth() * bufferedImage.getHeight()];
        DataBufferInt dataBuffer = bufferedImage.getRaster().getDataBuffer();
        int numBanks = dataBuffer.getNumBanks();
        int[] offsets = dataBuffer.getOffsets();
        int length = 0;
        for (int i = 0; i < numBanks; i++) {
            int[] data = dataBuffer.getData(i);
            System.arraycopy(data, offsets[i], iArr, length, data.length - offsets[i]);
            length += data.length - offsets[i];
        }
        return new RawBitmap(bufferedImage.getWidth(), bufferedImage.getHeight(), bufferedImage.getWidth(), 32, 16711680, 65280, 255, iArr);
    }

    private static List<String> getNativesForFlavors(DataFlavor[] dataFlavorArr) {
        ArrayList arrayList = new ArrayList();
        SystemFlavorMap defaultFlavorMap = SystemFlavorMap.getDefaultFlavorMap();
        for (DataFlavor dataFlavor : dataFlavorArr) {
            for (String str : defaultFlavorMap.getNativesForFlavor(dataFlavor)) {
                if (!arrayList.contains(str)) {
                    arrayList.add(str);
                }
            }
        }
        return arrayList;
    }

    private String getText(boolean z) {
        for (DataFlavor dataFlavor : this.contents.getTransferDataFlavors()) {
            if (dataFlavor.isFlavorTextType() && (!z || isHtmlFlavor(dataFlavor))) {
                try {
                    return String.class.isAssignableFrom(dataFlavor.getRepresentationClass()) ? (String) this.contents.getTransferData(dataFlavor) : getTextFromReader(dataFlavor.getReaderForText(this.contents));
                } catch (Exception unused) {
                }
            }
        }
        return null;
    }

    private String getTextFromReader(Reader reader) throws IOException {
        StringBuilder sb = new StringBuilder();
        char[] cArr = new char[1024];
        while (true) {
            int i = reader.read(cArr);
            if (i <= 0) {
                return sb.toString();
            }
            sb.append(cArr, 0, i);
        }
    }

    private boolean isHtmlFlavor(DataFlavor dataFlavor) {
        return "html".equalsIgnoreCase(dataFlavor.getSubType());
    }

    public DataFlavor[] getDataFlavors() {
        if (this.flavors == null) {
            this.flavors = this.contents.getTransferDataFlavors();
        }
        return this.flavors;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String[] getFileList() {
        try {
            List list = (List) this.contents.getTransferData(DataFlavor.javaFileListFlavor);
            return (String[]) list.toArray(new String[list.size()]);
        } catch (Exception unused) {
            return null;
        }
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getHTML() {
        return getText(true);
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String[] getNativeFormats() {
        return (String[]) getNativeFormatsList().toArray(new String[0]);
    }

    public List<String> getNativeFormatsList() {
        if (this.nativeFormats == null) {
            this.nativeFormats = getNativesForFlavors(getDataFlavors());
        }
        return this.nativeFormats;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public RawBitmap getRawBitmap() {
        DataFlavor[] transferDataFlavors = this.contents.getTransferDataFlavors();
        for (DataFlavor dataFlavor : transferDataFlavors) {
            Class representationClass = dataFlavor.getRepresentationClass();
            if (representationClass != null && Image.class.isAssignableFrom(representationClass) && (dataFlavor.isMimeTypeEqual(DataFlavor.imageFlavor) || dataFlavor.isFlavorSerializedObjectType())) {
                try {
                    return getImageBitmap((Image) this.contents.getTransferData(dataFlavor));
                } catch (Throwable unused) {
                    continue;
                }
            }
        }
        return null;
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public byte[] getSerializedObject(Class<?> cls) {
        try {
            Serializable serializable = (Serializable) this.contents.getTransferData(new DataFlavor(cls, (String) null));
            ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
            new ObjectOutputStream(byteArrayOutputStream).writeObject(serializable);
            return byteArrayOutputStream.toByteArray();
        } catch (Throwable unused) {
            return null;
        }
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getURL() {
        try {
            try {
                try {
                    return ((URL) this.contents.getTransferData(DataProvider.urlFlavor)).toString();
                } catch (Exception unused) {
                    return null;
                }
            } catch (Exception unused2) {
                return new URL(getText()).toString();
            }
        } catch (Exception unused3) {
            return ((URL) this.contents.getTransferData(DataProvider.uriFlavor)).toString();
        }
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public boolean isNativeFormatAvailable(String str) {
        return getNativeFormatsList().contains(str);
    }

    @Override // org.apache.harmony.awt.datatransfer.DataProvider
    public String getText() {
        return getText(false);
    }
}
