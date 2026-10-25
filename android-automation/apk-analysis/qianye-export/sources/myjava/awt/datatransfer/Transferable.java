package myjava.awt.datatransfer;

import java.io.IOException;

/* JADX INFO: loaded from: classes.dex */
public interface Transferable {
    Object getTransferData(DataFlavor dataFlavor) throws UnsupportedFlavorException, IOException;

    DataFlavor[] getTransferDataFlavors();

    boolean isDataFlavorSupported(DataFlavor dataFlavor);
}
