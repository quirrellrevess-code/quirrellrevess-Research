package okhttp3.internal.p005io;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import p066Ilil.I11li1;
import p066Ilil.iIlLiL;
import p066Ilil.lIiI;

/* JADX INFO: loaded from: classes.dex */
public interface FileSystem {
    public static final FileSystem SYSTEM = new FileSystem() { // from class: okhttp3.internal.io.FileSystem.1
        @Override // okhttp3.internal.p005io.FileSystem
        public iIlLiL appendingSink(File file) throws FileNotFoundException {
            try {
                return lIiI.IL1Iii(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return lIiI.IL1Iii(file);
            }
        }

        @Override // okhttp3.internal.p005io.FileSystem
        public void delete(File file) throws IOException {
            if (file.delete() || !file.exists()) {
                return;
            }
            throw new IOException("failed to delete " + file);
        }

        @Override // okhttp3.internal.p005io.FileSystem
        public void deleteContents(File file) throws IOException {
            File[] fileArrListFiles = file.listFiles();
            if (fileArrListFiles == null) {
                throw new IOException("not a readable directory: " + file);
            }
            for (File file2 : fileArrListFiles) {
                if (file2.isDirectory()) {
                    deleteContents(file2);
                }
                if (!file2.delete()) {
                    throw new IOException("failed to delete " + file2);
                }
            }
        }

        @Override // okhttp3.internal.p005io.FileSystem
        public boolean exists(File file) {
            return file.exists();
        }

        @Override // okhttp3.internal.p005io.FileSystem
        public void rename(File file, File file2) throws IOException {
            delete(file2);
            if (file.renameTo(file2)) {
                return;
            }
            throw new IOException("failed to rename " + file + " to " + file2);
        }

        @Override // okhttp3.internal.p005io.FileSystem
        public iIlLiL sink(File file) throws FileNotFoundException {
            try {
                return lIiI.m2832lLi1LL(file);
            } catch (FileNotFoundException unused) {
                file.getParentFile().mkdirs();
                return lIiI.m2832lLi1LL(file);
            }
        }

        @Override // okhttp3.internal.p005io.FileSystem
        public long size(File file) {
            return file.length();
        }

        @Override // okhttp3.internal.p005io.FileSystem
        public I11li1 source(File file) throws FileNotFoundException {
            return lIiI.m2833il(file);
        }
    };

    iIlLiL appendingSink(File file) throws FileNotFoundException;

    void delete(File file) throws IOException;

    void deleteContents(File file) throws IOException;

    boolean exists(File file);

    void rename(File file, File file2) throws IOException;

    iIlLiL sink(File file) throws FileNotFoundException;

    long size(File file);

    I11li1 source(File file) throws FileNotFoundException;
}
