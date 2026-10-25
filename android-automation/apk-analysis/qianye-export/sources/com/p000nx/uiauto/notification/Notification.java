package com.p000nx.uiauto.notification;

import I1I.IL1Iii;
import android.os.Build;

/* JADX INFO: loaded from: classes.dex */
public class Notification extends android.app.Notification {

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public String f5429ILil;

    public Notification(String str) {
        this.f5429ILil = str;
    }

    public static void IL1Iii(android.app.Notification notification, android.app.Notification notification2) {
        notification2.when = notification.when;
        notification2.icon = notification.icon;
        notification2.iconLevel = notification.iconLevel;
        notification2.number = notification.number;
        notification2.contentIntent = notification.contentIntent;
        notification2.deleteIntent = notification.deleteIntent;
        notification2.fullScreenIntent = notification.fullScreenIntent;
        notification2.tickerText = notification.tickerText;
        notification2.tickerView = notification.tickerView;
        notification2.contentView = notification.contentView;
        notification2.bigContentView = notification.bigContentView;
        int i = Build.VERSION.SDK_INT;
        if (i >= 21) {
            notification2.headsUpContentView = notification.headsUpContentView;
            notification2.audioAttributes = notification.audioAttributes;
            notification2.color = notification.color;
            notification2.visibility = notification.visibility;
            notification2.category = notification.category;
            notification2.publicVersion = notification.publicVersion;
        }
        notification2.largeIcon = notification.largeIcon;
        notification2.sound = notification.sound;
        notification2.audioStreamType = notification.audioStreamType;
        notification2.vibrate = notification.vibrate;
        notification2.ledARGB = notification.ledARGB;
        notification2.ledOnMS = notification.ledOnMS;
        notification2.ledOffMS = notification.ledOffMS;
        notification2.defaults = notification.defaults;
        notification2.flags = notification.flags;
        notification2.priority = notification.priority;
        if (i >= 19) {
            notification2.extras = notification.extras;
            notification2.actions = notification.actions;
        }
    }

    public static Notification ILil(android.app.Notification notification, String str) {
        Notification notification2 = new Notification(str);
        IL1Iii(notification, notification2);
        return notification2;
    }

    public String I1I() {
        return ((android.app.Notification) this).extras.getString(IL1Iii.IL1Iii(new byte[]{80, 13, 1, 74, 10, 15, 85, 77, 17, 93, 29, 18}, IL1Iii.IL1Iii(new byte[]{6, 86, 93, 15, 84, 3}, IL1Iii.IL1Iii(new byte[]{85, 3, 91, 81, 7, 82}, "b6cf67"))));
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public String m3506IL() {
        return ((android.app.Notification) this).extras.getString(IL1Iii.IL1Iii(new byte[]{88, 12, 0, 75, 12, 91, 93, 76, 16, 80, 23, 94, 92}, IL1Iii.IL1Iii(new byte[]{92, 86, 81, 93, 91, 84}, IL1Iii.IL1Iii(new byte[]{80, 87, 2, 85, 1, 4}, "5c719b"))));
    }

    @Override // android.app.Notification
    public String toString() {
        if (Build.VERSION.SDK_INT < 19) {
            return super.toString();
        }
        return IL1Iii.IL1Iii(new byte[]{125, 9, 23, 92, 7, 88, 80, 7, 23, 92, 14, 95, 72, 22, 2, 86, 10, 80, 84, 3, 45, 84, 12, 84, 14, 65}, IL1Iii.IL1Iii(new byte[]{10, 2, 81, 2, 83, 87}, IL1Iii.IL1Iii(new byte[]{14, 82, 11, 2, 0, 3}, "76952e"))) + this.f5429ILil + IL1Iii.IL1Iii(new byte[]{67, 29, 23, 68, 8, 22, 8, 84, 10, 23}, IL1Iii.IL1Iii(new byte[]{84, 3, 82, 7, 83, 87}, IL1Iii.IL1Iii(new byte[]{81, 86, 93, 86, 4, 84}, "ad8a6a"))) + m3506IL() + IL1Iii.IL1Iii(new byte[]{26, 16, 21, 4, 65, 16, 11, 23}, IL1Iii.IL1Iii(new byte[]{14, 85, 86, 82, 13, 7}, IL1Iii.IL1Iii(new byte[]{91, 1, 84, 86, 81, 85}, "cdcee6"))) + I1I() + IL1Iii.IL1Iii(new byte[]{68, 77, 16}, IL1Iii.IL1Iii(new byte[]{5, 7, 3, 6, 92, 80}, IL1Iii.IL1Iii(new byte[]{5, 81, 7, 87, 1, 6}, "cf4b87")));
    }
}
