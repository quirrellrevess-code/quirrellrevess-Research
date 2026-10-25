package androidx.core.app;

import android.app.Notification;
import android.app.Service;
import android.content.Intent;
import android.os.Build;
import android.os.IBinder;
import android.os.RemoteException;
import android.support.v4.app.INotificationSideChannel;

/* JADX INFO: loaded from: classes.dex */
public abstract class NotificationCompatSideChannelService extends Service {

    public class IL1Iii extends INotificationSideChannel.Stub {
        public IL1Iii() {
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancel(String str, int i, String str2) throws RemoteException {
            NotificationCompatSideChannelService.this.I1I(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.IL1Iii(str, i, str2);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void cancelAll(String str) {
            NotificationCompatSideChannelService.this.I1I(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.ILil(str);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }

        @Override // android.support.v4.app.INotificationSideChannel
        public void notify(String str, int i, String str2, Notification notification) throws RemoteException {
            NotificationCompatSideChannelService.this.I1I(getCallingUid(), str);
            long jClearCallingIdentity = clearCallingIdentity();
            try {
                NotificationCompatSideChannelService.this.m3161IL(str, i, str2, notification);
            } finally {
                restoreCallingIdentity(jClearCallingIdentity);
            }
        }
    }

    public void I1I(int i, String str) {
        for (String str2 : getPackageManager().getPackagesForUid(i)) {
            if (str2.equals(str)) {
                return;
            }
        }
        throw new SecurityException("NotificationSideChannelService: Uid " + i + " is not authorized for package " + str);
    }

    public abstract void IL1Iii(String str, int i, String str2);

    public abstract void ILil(String str);

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public abstract void m3161IL(String str, int i, String str2, Notification notification);

    @Override // android.app.Service
    public IBinder onBind(Intent intent) {
        if (!intent.getAction().equals("android.support.BIND_NOTIFICATION_SIDE_CHANNEL") || Build.VERSION.SDK_INT > 19) {
            return null;
        }
        return new IL1Iii();
    }
}
