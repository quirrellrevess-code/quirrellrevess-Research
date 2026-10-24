package com.main.engine;

import I1I.I1I.p000IL.lIlii;
import I1I.IL1Iii;
import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.ContentResolver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.content.IntentSender;
import android.content.ServiceConnection;
import android.content.SharedPreferences;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageManager;
import android.content.res.AssetManager;
import android.content.res.Configuration;
import android.content.res.Resources;
import android.database.DatabaseErrorHandler;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Bitmap;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.view.Display;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/* JADX INFO: loaded from: classes.dex */
public class NativeContext extends Context {
    private Context mContext;

    public NativeContext(Context context) {
        this.mContext = null;
        this.mContext = context;
    }

    @Override // android.content.Context
    public boolean bindService(Intent intent, ServiceConnection serviceConnection, int i) {
        return false;
    }

    @Override // android.content.Context
    public int checkCallingOrSelfPermission(String str) {
        return 0;
    }

    @Override // android.content.Context
    public int checkCallingOrSelfUriPermission(Uri uri, int i) {
        return 0;
    }

    @Override // android.content.Context
    public int checkCallingPermission(String str) {
        return 0;
    }

    @Override // android.content.Context
    public int checkCallingUriPermission(Uri uri, int i) {
        return 0;
    }

    @Override // android.content.Context
    public int checkPermission(String str, int i, int i2) {
        return 0;
    }

    @Override // android.content.Context
    public int checkSelfPermission(String str) {
        return 0;
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, int i, int i2, int i3) {
        return 0;
    }

    @Override // android.content.Context
    public int checkUriPermission(Uri uri, String str, String str2, int i, int i2, int i3) {
        return 0;
    }

    @Override // android.content.Context
    public void clearWallpaper() throws IOException {
    }

    @Override // android.content.Context
    public Context createConfigurationContext(Configuration configuration) {
        return null;
    }

    @Override // android.content.Context
    public Context createContextForSplit(String str) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.Context
    public Context createDeviceProtectedStorageContext() {
        return null;
    }

    @Override // android.content.Context
    public Context createDisplayContext(Display display) {
        return null;
    }

    @Override // android.content.Context
    public Context createPackageContext(String str, int i) throws PackageManager.NameNotFoundException {
        return null;
    }

    @Override // android.content.Context
    public String[] databaseList() {
        return new String[0];
    }

    @Override // android.content.Context
    public boolean deleteDatabase(String str) {
        return false;
    }

    @Override // android.content.Context
    public boolean deleteFile(String str) {
        return false;
    }

    @Override // android.content.Context
    public boolean deleteSharedPreferences(String str) {
        return false;
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfPermission(String str, String str2) {
    }

    @Override // android.content.Context
    public void enforceCallingOrSelfUriPermission(Uri uri, int i, String str) {
    }

    @Override // android.content.Context
    public void enforceCallingPermission(String str, String str2) {
    }

    @Override // android.content.Context
    public void enforceCallingUriPermission(Uri uri, int i, String str) {
    }

    @Override // android.content.Context
    public void enforcePermission(String str, int i, int i2, String str2) {
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, int i, int i2, int i3, String str) {
    }

    @Override // android.content.Context
    public void enforceUriPermission(Uri uri, String str, String str2, int i, int i2, int i3, String str3) {
    }

    @Override // android.content.Context
    public String[] fileList() {
        return new String[0];
    }

    @Override // android.content.Context
    public Context getApplicationContext() {
        return this.mContext.getApplicationContext();
    }

    @Override // android.content.Context
    public ApplicationInfo getApplicationInfo() {
        return null;
    }

    @Override // android.content.Context
    public AssetManager getAssets() {
        return this.mContext.getAssets();
    }

    @Override // android.content.Context
    public File getCacheDir() {
        return null;
    }

    @Override // android.content.Context
    public ClassLoader getClassLoader() {
        return this.mContext.getClassLoader();
    }

    @Override // android.content.Context
    public File getCodeCacheDir() {
        return null;
    }

    @Override // android.content.Context
    public ContentResolver getContentResolver() {
        return this.mContext.getContentResolver();
    }

    @Override // android.content.Context
    public File getDataDir() {
        return null;
    }

    @Override // android.content.Context
    public File getDatabasePath(String str) {
        return null;
    }

    @Override // android.content.Context
    public File getDir(String str, int i) {
        return null;
    }

    @Override // android.content.Context
    public File getExternalCacheDir() {
        return null;
    }

    @Override // android.content.Context
    public File[] getExternalCacheDirs() {
        return new File[0];
    }

    @Override // android.content.Context
    public File getExternalFilesDir(String str) {
        return null;
    }

    @Override // android.content.Context
    public File[] getExternalFilesDirs(String str) {
        return new File[0];
    }

    @Override // android.content.Context
    public File[] getExternalMediaDirs() {
        return new File[0];
    }

    @Override // android.content.Context
    public File getFileStreamPath(String str) {
        return null;
    }

    @Override // android.content.Context
    public File getFilesDir() {
        File file = new File(new File(lIlii.m340lIII()).getParentFile(), IL1Iii.IL1Iii(new byte[]{2, 89, 95, 7, 67}, IL1Iii.IL1Iii(new byte[]{86, 83, 87, 80, 4, 2}, IL1Iii.IL1Iii(new byte[]{84, 91, 92, 86, 87, 4}, "f88dc1"))));
        if (!file.exists() || !file.isDirectory()) {
            file.mkdirs();
        }
        return file;
    }

    @Override // android.content.Context
    public Looper getMainLooper() {
        return this.mContext.getMainLooper();
    }

    @Override // android.content.Context
    public File getNoBackupFilesDir() {
        return null;
    }

    @Override // android.content.Context
    public File getObbDir() {
        return null;
    }

    @Override // android.content.Context
    public File[] getObbDirs() {
        return new File[0];
    }

    @Override // android.content.Context
    public String getPackageCodePath() {
        return null;
    }

    @Override // android.content.Context
    public PackageManager getPackageManager() {
        return this.mContext.getPackageManager();
    }

    @Override // android.content.Context
    public String getPackageName() {
        return lIlii.LiL1();
    }

    @Override // android.content.Context
    public String getPackageResourcePath() {
        return null;
    }

    @Override // android.content.Context
    public Resources getResources() {
        return this.mContext.getResources();
    }

    @Override // android.content.Context
    public SharedPreferences getSharedPreferences(String str, int i) {
        return null;
    }

    @Override // android.content.Context
    public Object getSystemService(String str) {
        return null;
    }

    @Override // android.content.Context
    public String getSystemServiceName(Class<?> cls) {
        return null;
    }

    @Override // android.content.Context
    public Resources.Theme getTheme() {
        return null;
    }

    @Override // android.content.Context
    public Drawable getWallpaper() {
        return null;
    }

    @Override // android.content.Context
    public int getWallpaperDesiredMinimumHeight() {
        return 0;
    }

    @Override // android.content.Context
    public int getWallpaperDesiredMinimumWidth() {
        return 0;
    }

    @Override // android.content.Context
    public void grantUriPermission(String str, Uri uri, int i) {
    }

    @Override // android.content.Context
    public boolean isDeviceProtectedStorage() {
        return false;
    }

    @Override // android.content.Context
    public boolean moveDatabaseFrom(Context context, String str) {
        return false;
    }

    @Override // android.content.Context
    public boolean moveSharedPreferencesFrom(Context context, String str) {
        return false;
    }

    @Override // android.content.Context
    public FileInputStream openFileInput(String str) throws FileNotFoundException {
        return null;
    }

    @Override // android.content.Context
    public FileOutputStream openFileOutput(String str, int i) throws FileNotFoundException {
        return null;
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory) {
        return null;
    }

    @Override // android.content.Context
    public SQLiteDatabase openOrCreateDatabase(String str, int i, SQLiteDatabase.CursorFactory cursorFactory, DatabaseErrorHandler databaseErrorHandler) {
        return null;
    }

    @Override // android.content.Context
    public Drawable peekWallpaper() {
        return null;
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter) {
        return null;
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, int i) {
        return null;
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler) {
        return null;
    }

    @Override // android.content.Context
    public Intent registerReceiver(BroadcastReceiver broadcastReceiver, IntentFilter intentFilter, String str, Handler handler, int i) {
        return null;
    }

    @Override // android.content.Context
    public void removeStickyBroadcast(Intent intent) {
    }

    @Override // android.content.Context
    public void removeStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
    }

    @Override // android.content.Context
    public void revokeUriPermission(Uri uri, int i) {
    }

    @Override // android.content.Context
    public void revokeUriPermission(String str, Uri uri, int i) {
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent) {
    }

    @Override // android.content.Context
    public void sendBroadcast(Intent intent, String str) {
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle) {
    }

    @Override // android.content.Context
    public void sendBroadcastAsUser(Intent intent, UserHandle userHandle, String str) {
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str) {
    }

    @Override // android.content.Context
    public void sendOrderedBroadcast(Intent intent, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
    }

    @Override // android.content.Context
    public void sendOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, String str, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str2, Bundle bundle) {
    }

    @Override // android.content.Context
    public void sendStickyBroadcast(Intent intent) {
    }

    @Override // android.content.Context
    public void sendStickyBroadcastAsUser(Intent intent, UserHandle userHandle) {
    }

    @Override // android.content.Context
    public void sendStickyOrderedBroadcast(Intent intent, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
    }

    @Override // android.content.Context
    public void sendStickyOrderedBroadcastAsUser(Intent intent, UserHandle userHandle, BroadcastReceiver broadcastReceiver, Handler handler, int i, String str, Bundle bundle) {
    }

    @Override // android.content.Context
    public void setTheme(int i) {
    }

    @Override // android.content.Context
    public void setWallpaper(Bitmap bitmap) throws IOException {
    }

    @Override // android.content.Context
    public void setWallpaper(InputStream inputStream) throws IOException {
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr) {
    }

    @Override // android.content.Context
    public void startActivities(Intent[] intentArr, Bundle bundle) {
    }

    @Override // android.content.Context
    public void startActivity(Intent intent) {
    }

    @Override // android.content.Context
    public void startActivity(Intent intent, Bundle bundle) {
    }

    @Override // android.content.Context
    public ComponentName startForegroundService(Intent intent) {
        return null;
    }

    @Override // android.content.Context
    public boolean startInstrumentation(ComponentName componentName, String str, Bundle bundle) {
        return false;
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3) throws IntentSender.SendIntentException {
    }

    @Override // android.content.Context
    public void startIntentSender(IntentSender intentSender, Intent intent, int i, int i2, int i3, Bundle bundle) throws IntentSender.SendIntentException {
    }

    @Override // android.content.Context
    public ComponentName startService(Intent intent) {
        return null;
    }

    @Override // android.content.Context
    public boolean stopService(Intent intent) {
        return false;
    }

    @Override // android.content.Context
    public void unbindService(ServiceConnection serviceConnection) {
    }

    @Override // android.content.Context
    public void unregisterReceiver(BroadcastReceiver broadcastReceiver) {
    }
}
