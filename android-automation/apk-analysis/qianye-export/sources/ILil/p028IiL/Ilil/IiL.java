package ILil.p028IiL.Ilil;

import android.app.Notification;
import android.app.RemoteInput;
import android.os.Build;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.SparseArray;
import android.widget.RemoteViews;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: ILil.I丨iL.Ilil.I丨iL, reason: invalid class name */
/* JADX INFO: compiled from: NotificationCompatBuilder.java */
/* JADX INFO: loaded from: classes.dex */
public class IiL implements lLi1LL {

    /* JADX INFO: renamed from: I1I, reason: collision with root package name */
    public RemoteViews f4102I1I;

    /* JADX INFO: renamed from: IL1Iii, reason: collision with root package name */
    public final Notification.Builder f4103IL1Iii;

    /* JADX INFO: renamed from: ILil, reason: collision with root package name */
    public final iILLL1.ILil f4104ILil;

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public RemoteViews f1641IL;

    /* JADX INFO: renamed from: I丨iL, reason: contains not printable characters */
    public RemoteViews f1642IiL;

    /* JADX INFO: renamed from: iI丨LLL1, reason: contains not printable characters */
    public int f1643iILLL1;

    /* JADX INFO: renamed from: Ilil, reason: collision with root package name */
    public final List<Bundle> f4105Ilil = new ArrayList();

    /* JADX INFO: renamed from: l丨Li1LL, reason: contains not printable characters */
    public final Bundle f1644lLi1LL = new Bundle();

    public IiL(iILLL1.ILil iLil) {
        ArrayList<String> arrayList;
        this.f4104ILil = iLil;
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            this.f4103IL1Iii = new Notification.Builder(iLil.f4116IL1Iii, iLil.f1658L1l);
        } else {
            this.f4103IL1Iii = new Notification.Builder(iLil.f4116IL1Iii);
        }
        Notification notification = iLil.f1675;
        this.f4103IL1Iii.setWhen(notification.when).setSmallIcon(notification.icon, notification.iconLevel).setContent(notification.contentView).setTicker(notification.tickerText, iLil.f1653IiL).setVibrate(notification.vibrate).setLights(notification.ledARGB, notification.ledOnMS, notification.ledOffMS).setOngoing((notification.flags & 2) != 0).setOnlyAlertOnce((notification.flags & 8) != 0).setAutoCancel((notification.flags & 16) != 0).setDefaults(notification.defaults).setContentTitle(iLil.f1652IL).setContentText(iLil.f4118Ilil).setContentInfo(iLil.f1670il).setContentIntent(iLil.f1668lLi1LL).setDeleteIntent(notification.deleteIntent).setFullScreenIntent(iLil.f1661iILLL1, (notification.flags & 128) != 0).setLargeIcon(iLil.f1659L11I).setNumber(iLil.ILL).setProgress(iLil.f1666lIlii, iLil.iIi1, iLil.iIlLiL);
        if (i < 21) {
            this.f4103IL1Iii.setSound(notification.sound, notification.audioStreamType);
        }
        if (i >= 16) {
            this.f4103IL1Iii.setSubText(iLil.LlLI1).setUsesChronometer(iLil.f1650ILl).setPriority(iLil.f1657Ll1);
            Iterator<iILLL1.IL1Iii> it = iLil.f4117ILil.iterator();
            while (it.hasNext()) {
                IL1Iii(it.next());
            }
            Bundle bundle = iLil.f1665lIII;
            if (bundle != null) {
                this.f1644lLi1LL.putAll(bundle);
            }
            if (Build.VERSION.SDK_INT < 20) {
                if (iLil.llliI) {
                    this.f1644lLi1LL.putBoolean("android.support.localOnly", true);
                }
                String str = iLil.I11li1;
                if (str != null) {
                    this.f1644lLi1LL.putString("android.support.groupKey", str);
                    if (iLil.f1671lL) {
                        this.f1644lLi1LL.putBoolean("android.support.isGroupSummary", true);
                    } else {
                        this.f1644lLi1LL.putBoolean("android.support.useSideChannel", true);
                    }
                }
                String str2 = iLil.I11L;
                if (str2 != null) {
                    this.f1644lLi1LL.putString("android.support.sortKey", str2);
                }
            }
            this.f4102I1I = iLil.f8;
            this.f1641IL = iLil.llI;
        }
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 19) {
            this.f4103IL1Iii.setShowWhen(iLil.f1664lIiI);
            if (i2 < 21 && (arrayList = iLil.f1654L11) != null && !arrayList.isEmpty()) {
                Bundle bundle2 = this.f1644lLi1LL;
                ArrayList<String> arrayList2 = iLil.f1654L11;
                bundle2.putStringArray("android.people", (String[]) arrayList2.toArray(new String[arrayList2.size()]));
            }
        }
        if (i2 >= 20) {
            this.f4103IL1Iii.setLocalOnly(iLil.llliI).setGroup(iLil.I11li1).setGroupSummary(iLil.f1671lL).setSortKey(iLil.I11L);
            this.f1643iILLL1 = iLil.f1662ill;
        }
        if (i2 >= 21) {
            this.f4103IL1Iii.setCategory(iLil.f1660LlLLL).setColor(iLil.LL1IL).setVisibility(iLil.f1655L111).setPublicVersion(iLil.f1673LLlI1).setSound(notification.sound, notification.audioAttributes);
            Iterator<String> it2 = iLil.f1654L11.iterator();
            while (it2.hasNext()) {
                this.f4103IL1Iii.addPerson(it2.next());
            }
            this.f1642IiL = iLil.f1663l1IIi1;
            if (iLil.f4115I1I.size() > 0) {
                Bundle bundle3 = iLil.ILil().getBundle("android.car.EXTENSIONS");
                bundle3 = bundle3 == null ? new Bundle() : bundle3;
                Bundle bundle4 = new Bundle();
                for (int i3 = 0; i3 < iLil.f4115I1I.size(); i3++) {
                    bundle4.putBundle(Integer.toString(i3), L11I.ILil(iLil.f4115I1I.get(i3)));
                }
                bundle3.putBundle("invisible_actions", bundle4);
                iLil.ILil().putBundle("android.car.EXTENSIONS", bundle3);
                this.f1644lLi1LL.putBundle("android.car.EXTENSIONS", bundle3);
            }
        }
        int i4 = Build.VERSION.SDK_INT;
        if (i4 >= 24) {
            this.f4103IL1Iii.setExtras(iLil.f1665lIII).setRemoteInputHistory(iLil.f1667llL1ii);
            RemoteViews remoteViews = iLil.f8;
            if (remoteViews != null) {
                this.f4103IL1Iii.setCustomContentView(remoteViews);
            }
            RemoteViews remoteViews2 = iLil.llI;
            if (remoteViews2 != null) {
                this.f4103IL1Iii.setCustomBigContentView(remoteViews2);
            }
            RemoteViews remoteViews3 = iLil.f1663l1IIi1;
            if (remoteViews3 != null) {
                this.f4103IL1Iii.setCustomHeadsUpContentView(remoteViews3);
            }
        }
        if (i4 >= 26) {
            this.f4103IL1Iii.setBadgeIconType(iLil.f1669iILLl).setShortcutId(iLil.f1651IIi).setTimeoutAfter(iLil.f1656LIll).setGroupAlertBehavior(iLil.f1662ill);
            if (iLil.f16741) {
                this.f4103IL1Iii.setColorized(iLil.f1672l);
            }
            if (TextUtils.isEmpty(iLil.f1658L1l)) {
                return;
            }
            this.f4103IL1Iii.setSound(null).setDefaults(0).setLights(0, 0, 0).setVibrate(null);
        }
    }

    public Notification I1I() {
        int i = Build.VERSION.SDK_INT;
        if (i >= 26) {
            return this.f4103IL1Iii.build();
        }
        if (i >= 24) {
            Notification notificationBuild = this.f4103IL1Iii.build();
            if (this.f1643iILLL1 != 0) {
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) != 0 && this.f1643iILLL1 == 2) {
                    m2177IL(notificationBuild);
                }
                if (notificationBuild.getGroup() != null && (notificationBuild.flags & 512) == 0 && this.f1643iILLL1 == 1) {
                    m2177IL(notificationBuild);
                }
            }
            return notificationBuild;
        }
        if (i >= 21) {
            this.f4103IL1Iii.setExtras(this.f1644lLi1LL);
            Notification notificationBuild2 = this.f4103IL1Iii.build();
            RemoteViews remoteViews = this.f4102I1I;
            if (remoteViews != null) {
                notificationBuild2.contentView = remoteViews;
            }
            RemoteViews remoteViews2 = this.f1641IL;
            if (remoteViews2 != null) {
                notificationBuild2.bigContentView = remoteViews2;
            }
            RemoteViews remoteViews3 = this.f1642IiL;
            if (remoteViews3 != null) {
                notificationBuild2.headsUpContentView = remoteViews3;
            }
            if (this.f1643iILLL1 != 0) {
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) != 0 && this.f1643iILLL1 == 2) {
                    m2177IL(notificationBuild2);
                }
                if (notificationBuild2.getGroup() != null && (notificationBuild2.flags & 512) == 0 && this.f1643iILLL1 == 1) {
                    m2177IL(notificationBuild2);
                }
            }
            return notificationBuild2;
        }
        if (i >= 20) {
            this.f4103IL1Iii.setExtras(this.f1644lLi1LL);
            Notification notificationBuild3 = this.f4103IL1Iii.build();
            RemoteViews remoteViews4 = this.f4102I1I;
            if (remoteViews4 != null) {
                notificationBuild3.contentView = remoteViews4;
            }
            RemoteViews remoteViews5 = this.f1641IL;
            if (remoteViews5 != null) {
                notificationBuild3.bigContentView = remoteViews5;
            }
            if (this.f1643iILLL1 != 0) {
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) != 0 && this.f1643iILLL1 == 2) {
                    m2177IL(notificationBuild3);
                }
                if (notificationBuild3.getGroup() != null && (notificationBuild3.flags & 512) == 0 && this.f1643iILLL1 == 1) {
                    m2177IL(notificationBuild3);
                }
            }
            return notificationBuild3;
        }
        if (i >= 19) {
            SparseArray<Bundle> sparseArrayIL1Iii = L11I.IL1Iii(this.f4105Ilil);
            if (sparseArrayIL1Iii != null) {
                this.f1644lLi1LL.putSparseParcelableArray("android.support.actionExtras", sparseArrayIL1Iii);
            }
            this.f4103IL1Iii.setExtras(this.f1644lLi1LL);
            Notification notificationBuild4 = this.f4103IL1Iii.build();
            RemoteViews remoteViews6 = this.f4102I1I;
            if (remoteViews6 != null) {
                notificationBuild4.contentView = remoteViews6;
            }
            RemoteViews remoteViews7 = this.f1641IL;
            if (remoteViews7 != null) {
                notificationBuild4.bigContentView = remoteViews7;
            }
            return notificationBuild4;
        }
        if (i < 16) {
            return this.f4103IL1Iii.getNotification();
        }
        Notification notificationBuild5 = this.f4103IL1Iii.build();
        Bundle bundleIL1Iii = iILLL1.IL1Iii(notificationBuild5);
        Bundle bundle = new Bundle(this.f1644lLi1LL);
        for (String str : this.f1644lLi1LL.keySet()) {
            if (bundleIL1Iii.containsKey(str)) {
                bundle.remove(str);
            }
        }
        bundleIL1Iii.putAll(bundle);
        SparseArray<Bundle> sparseArrayIL1Iii2 = L11I.IL1Iii(this.f4105Ilil);
        if (sparseArrayIL1Iii2 != null) {
            iILLL1.IL1Iii(notificationBuild5).putSparseParcelableArray("android.support.actionExtras", sparseArrayIL1Iii2);
        }
        RemoteViews remoteViews8 = this.f4102I1I;
        if (remoteViews8 != null) {
            notificationBuild5.contentView = remoteViews8;
        }
        RemoteViews remoteViews9 = this.f1641IL;
        if (remoteViews9 != null) {
            notificationBuild5.bigContentView = remoteViews9;
        }
        return notificationBuild5;
    }

    public final void IL1Iii(iILLL1.IL1Iii iL1Iii) {
        int i = Build.VERSION.SDK_INT;
        if (i < 20) {
            if (i >= 16) {
                this.f4105Ilil.add(L11I.m2181lLi1LL(this.f4103IL1Iii, iL1Iii));
                return;
            }
            return;
        }
        Notification.Action.Builder builder = new Notification.Action.Builder(iL1Iii.Ilil(), iL1Iii.m2185L11I(), iL1Iii.IL1Iii());
        if (iL1Iii.m2187lLi1LL() != null) {
            for (RemoteInput remoteInput : C0635il.ILil(iL1Iii.m2187lLi1LL())) {
                builder.addRemoteInput(remoteInput);
            }
        }
        Bundle bundle = iL1Iii.m2183IL() != null ? new Bundle(iL1Iii.m2183IL()) : new Bundle();
        bundle.putBoolean("android.support.allowGeneratedReplies", iL1Iii.ILil());
        int i2 = Build.VERSION.SDK_INT;
        if (i2 >= 24) {
            builder.setAllowGeneratedReplies(iL1Iii.ILil());
        }
        bundle.putInt("android.support.action.semanticAction", iL1Iii.m2186iILLL1());
        if (i2 >= 28) {
            builder.setSemanticAction(iL1Iii.m2186iILLL1());
        }
        bundle.putBoolean("android.support.action.showsUserInterface", iL1Iii.m2184IiL());
        builder.addExtras(bundle);
        this.f4103IL1Iii.addAction(builder.build());
    }

    public Notification ILil() {
        Bundle bundleIL1Iii;
        RemoteViews remoteViewsIlil;
        RemoteViews remoteViewsI1I;
        iILLL1.I1I i1i = this.f4104ILil.Lil;
        if (i1i != null) {
            i1i.ILil(this);
        }
        RemoteViews remoteViewsM2182IL = i1i != null ? i1i.m2182IL(this) : null;
        Notification notificationI1I = I1I();
        if (remoteViewsM2182IL != null) {
            notificationI1I.contentView = remoteViewsM2182IL;
        } else {
            RemoteViews remoteViews = this.f4104ILil.f8;
            if (remoteViews != null) {
                notificationI1I.contentView = remoteViews;
            }
        }
        int i = Build.VERSION.SDK_INT;
        if (i >= 16 && i1i != null && (remoteViewsI1I = i1i.I1I(this)) != null) {
            notificationI1I.bigContentView = remoteViewsI1I;
        }
        if (i >= 21 && i1i != null && (remoteViewsIlil = this.f4104ILil.Lil.Ilil(this)) != null) {
            notificationI1I.headsUpContentView = remoteViewsIlil;
        }
        if (i >= 16 && i1i != null && (bundleIL1Iii = iILLL1.IL1Iii(notificationI1I)) != null) {
            i1i.IL1Iii(bundleIL1Iii);
        }
        return notificationI1I;
    }

    /* JADX INFO: renamed from: I丨L, reason: contains not printable characters */
    public final void m2177IL(Notification notification) {
        notification.sound = null;
        notification.vibrate = null;
        int i = notification.defaults & (-2);
        notification.defaults = i;
        notification.defaults = i & (-3);
    }
}
