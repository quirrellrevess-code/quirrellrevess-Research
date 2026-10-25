package com.p000nx.uiauto.notification;

import I1I.p062Ilil.p064Ilil.IL1Iii.L11I;
import android.service.notification.StatusBarNotification;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* JADX INFO: loaded from: classes.dex */
public class NotificationListenerService extends android.service.notification.NotificationListenerService {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public CopyOnWriteArrayList<L11I> f5430ILil = new CopyOnWriteArrayList<>();

    @Override // android.app.Service
    public void onCreate() {
        super.onCreate();
    }

    @Override // android.service.notification.NotificationListenerService, android.app.Service
    public void onDestroy() {
        super.onDestroy();
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification, android.service.notification.NotificationListenerService.RankingMap rankingMap) {
        onNotificationPosted(statusBarNotification);
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification) {
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationRemoved(StatusBarNotification statusBarNotification, android.service.notification.NotificationListenerService.RankingMap rankingMap) {
    }

    @Override // android.service.notification.NotificationListenerService
    public void onNotificationPosted(StatusBarNotification statusBarNotification) {
        Iterator<L11I> it = this.f5430ILil.iterator();
        while (it.hasNext()) {
            it.next().ILil(Notification.ILil(statusBarNotification.getNotification(), statusBarNotification.getPackageName()));
        }
    }
}
