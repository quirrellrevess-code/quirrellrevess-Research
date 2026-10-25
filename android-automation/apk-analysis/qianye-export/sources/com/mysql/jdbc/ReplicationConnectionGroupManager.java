package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.jmx.ReplicationGroupManager;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ReplicationConnectionGroupManager {
    private static HashMap<String, ReplicationConnectionGroup> GROUP_MAP = new HashMap<>();
    private static ReplicationGroupManager mbean = new ReplicationGroupManager();
    private static boolean hasRegisteredJmx = false;

    public static void addSlaveHost(String str, String str2) throws SQLException {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        while (it.hasNext()) {
            it.next().addSlaveHost(str2);
        }
    }

    public static long getActiveConnectionCount(String str) {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        long activeConnectionCount = 0;
        while (it.hasNext()) {
            activeConnectionCount += it.next().getActiveConnectionCount();
        }
        return activeConnectionCount;
    }

    public static int getConnectionCountWithHostAsMaster(String str, String str2) {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        int connectionCountWithHostAsMaster = 0;
        while (it.hasNext()) {
            connectionCountWithHostAsMaster += it.next().getConnectionCountWithHostAsMaster(str2);
        }
        return connectionCountWithHostAsMaster;
    }

    public static int getConnectionCountWithHostAsSlave(String str, String str2) {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        int connectionCountWithHostAsSlave = 0;
        while (it.hasNext()) {
            connectionCountWithHostAsSlave += it.next().getConnectionCountWithHostAsSlave(str2);
        }
        return connectionCountWithHostAsSlave;
    }

    public static ReplicationConnectionGroup getConnectionGroup(String str) {
        return GROUP_MAP.get(str);
    }

    public static synchronized ReplicationConnectionGroup getConnectionGroupInstance(String str) {
        if (GROUP_MAP.containsKey(str)) {
            return GROUP_MAP.get(str);
        }
        ReplicationConnectionGroup replicationConnectionGroup = new ReplicationConnectionGroup(str);
        GROUP_MAP.put(str, replicationConnectionGroup);
        return replicationConnectionGroup;
    }

    public static Collection<ReplicationConnectionGroup> getGroupsMatching(String str) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(GROUP_MAP.values());
            return hashSet;
        }
        HashSet hashSet2 = new HashSet();
        ReplicationConnectionGroup replicationConnectionGroup = GROUP_MAP.get(str);
        if (replicationConnectionGroup != null) {
            hashSet2.add(replicationConnectionGroup);
        }
        return hashSet2;
    }

    public static Collection<String> getMasterHosts(String str) {
        Collection<ReplicationConnectionGroup> groupsMatching = getGroupsMatching(str);
        ArrayList arrayList = new ArrayList();
        Iterator<ReplicationConnectionGroup> it = groupsMatching.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getMasterHosts());
        }
        return arrayList;
    }

    public static int getNumberOfMasterPromotion(String str) {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        int numberOfSlavePromotions = 0;
        while (it.hasNext()) {
            numberOfSlavePromotions = (int) (((long) numberOfSlavePromotions) + it.next().getNumberOfSlavePromotions());
        }
        return numberOfSlavePromotions;
    }

    public static String getRegisteredReplicationConnectionGroups() {
        Collection<ReplicationConnectionGroup> groupsMatching = getGroupsMatching(null);
        StringBuilder sb = new StringBuilder();
        Iterator<ReplicationConnectionGroup> it = groupsMatching.iterator();
        String str = BuildConfig.FLAVOR;
        while (it.hasNext()) {
            String groupName = it.next().getGroupName();
            sb.append(str);
            sb.append(groupName);
            str = ",";
        }
        return sb.toString();
    }

    public static Collection<String> getSlaveHosts(String str) {
        Collection<ReplicationConnectionGroup> groupsMatching = getGroupsMatching(str);
        ArrayList arrayList = new ArrayList();
        Iterator<ReplicationConnectionGroup> it = groupsMatching.iterator();
        while (it.hasNext()) {
            arrayList.addAll(it.next().getSlaveHosts());
        }
        return arrayList;
    }

    public static long getSlavePromotionCount(String str) throws SQLException {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        long j = 0;
        while (it.hasNext()) {
            long numberOfSlavePromotions = it.next().getNumberOfSlavePromotions();
            if (numberOfSlavePromotions > j) {
                j = numberOfSlavePromotions;
            }
        }
        return j;
    }

    public static long getTotalConnectionCount(String str) {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        long totalConnectionCount = 0;
        while (it.hasNext()) {
            totalConnectionCount += it.next().getTotalConnectionCount();
        }
        return totalConnectionCount;
    }

    public static void promoteSlaveToMaster(String str, String str2) throws SQLException {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        while (it.hasNext()) {
            it.next().promoteSlaveToMaster(str2);
        }
    }

    public static void registerJmx() throws SQLException {
        if (hasRegisteredJmx) {
            return;
        }
        mbean.registerJmx();
        hasRegisteredJmx = true;
    }

    public static void removeMasterHost(String str, String str2) throws SQLException {
        removeMasterHost(str, str2, true);
    }

    public static void removeSlaveHost(String str, String str2) throws SQLException {
        removeSlaveHost(str, str2, true);
    }

    public static void removeMasterHost(String str, String str2, boolean z) throws SQLException {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        while (it.hasNext()) {
            it.next().removeMasterHost(str2, z);
        }
    }

    public static void removeSlaveHost(String str, String str2, boolean z) throws SQLException {
        Iterator<ReplicationConnectionGroup> it = getGroupsMatching(str).iterator();
        while (it.hasNext()) {
            it.next().removeSlaveHost(str2, z);
        }
    }
}
