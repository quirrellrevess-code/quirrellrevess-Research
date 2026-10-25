package com.mysql.jdbc;

import com.google.android.flexbox.BuildConfig;
import com.mysql.jdbc.jmx.LoadBalanceConnectionGroupManager;
import java.sql.SQLException;
import java.util.Collection;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: loaded from: classes.dex */
public class ConnectionGroupManager {
    private static HashMap<String, ConnectionGroup> GROUP_MAP = new HashMap<>();
    private static LoadBalanceConnectionGroupManager mbean = new LoadBalanceConnectionGroupManager();
    private static boolean hasRegisteredJmx = false;

    public static void addHost(String str, String str2, boolean z) {
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        while (it.hasNext()) {
            it.next().addHost(str2, z);
        }
    }

    public static int getActiveHostCount(String str) {
        HashSet hashSet = new HashSet();
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        while (it.hasNext()) {
            hashSet.addAll(it.next().getInitialHosts());
        }
        return hashSet.size();
    }

    public static String getActiveHostLists(String str) {
        Collection<ConnectionGroup> groupsMatching = getGroupsMatching(str);
        HashMap map = new HashMap();
        Iterator<ConnectionGroup> it = groupsMatching.iterator();
        while (it.hasNext()) {
            for (String str2 : it.next().getInitialHosts()) {
                Integer num = (Integer) map.get(str2);
                map.put(str2, num == null ? 1 : Integer.valueOf(num.intValue() + 1));
            }
        }
        StringBuilder sb = new StringBuilder();
        String str3 = BuildConfig.FLAVOR;
        for (String str4 : map.keySet()) {
            sb.append(str3);
            sb.append(str4);
            sb.append('(');
            sb.append(map.get(str4));
            sb.append(')');
            str3 = ",";
        }
        return sb.toString();
    }

    public static long getActiveLogicalConnectionCount(String str) {
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        int activeLogicalConnectionCount = 0;
        while (it.hasNext()) {
            activeLogicalConnectionCount = (int) (((long) activeLogicalConnectionCount) + it.next().getActiveLogicalConnectionCount());
        }
        return activeLogicalConnectionCount;
    }

    public static long getActivePhysicalConnectionCount(String str) {
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        int activePhysicalConnectionCount = 0;
        while (it.hasNext()) {
            activePhysicalConnectionCount = (int) (((long) activePhysicalConnectionCount) + it.next().getActivePhysicalConnectionCount());
        }
        return activePhysicalConnectionCount;
    }

    public static ConnectionGroup getConnectionGroup(String str) {
        return GROUP_MAP.get(str);
    }

    public static synchronized ConnectionGroup getConnectionGroupInstance(String str) {
        if (GROUP_MAP.containsKey(str)) {
            return GROUP_MAP.get(str);
        }
        ConnectionGroup connectionGroup = new ConnectionGroup(str);
        GROUP_MAP.put(str, connectionGroup);
        return connectionGroup;
    }

    private static Collection<ConnectionGroup> getGroupsMatching(String str) {
        if (str == null || str.equals(BuildConfig.FLAVOR)) {
            HashSet hashSet = new HashSet();
            hashSet.addAll(GROUP_MAP.values());
            return hashSet;
        }
        HashSet hashSet2 = new HashSet();
        ConnectionGroup connectionGroup = GROUP_MAP.get(str);
        if (connectionGroup != null) {
            hashSet2.add(connectionGroup);
        }
        return hashSet2;
    }

    public static String getRegisteredConnectionGroups() {
        Collection<ConnectionGroup> groupsMatching = getGroupsMatching(null);
        StringBuilder sb = new StringBuilder();
        Iterator<ConnectionGroup> it = groupsMatching.iterator();
        String str = BuildConfig.FLAVOR;
        while (it.hasNext()) {
            String groupName = it.next().getGroupName();
            sb.append(str);
            sb.append(groupName);
            str = ",";
        }
        return sb.toString();
    }

    public static int getTotalHostCount(String str) {
        Collection<ConnectionGroup> groupsMatching = getGroupsMatching(str);
        HashSet hashSet = new HashSet();
        for (ConnectionGroup connectionGroup : groupsMatching) {
            hashSet.addAll(connectionGroup.getInitialHosts());
            hashSet.addAll(connectionGroup.getClosedHosts());
        }
        return hashSet.size();
    }

    public static long getTotalLogicalConnectionCount(String str) {
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        long totalLogicalConnectionCount = 0;
        while (it.hasNext()) {
            totalLogicalConnectionCount += it.next().getTotalLogicalConnectionCount();
        }
        return totalLogicalConnectionCount;
    }

    public static long getTotalPhysicalConnectionCount(String str) {
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        long totalPhysicalConnectionCount = 0;
        while (it.hasNext()) {
            totalPhysicalConnectionCount += it.next().getTotalPhysicalConnectionCount();
        }
        return totalPhysicalConnectionCount;
    }

    public static long getTotalTransactionCount(String str) {
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        long totalTransactionCount = 0;
        while (it.hasNext()) {
            totalTransactionCount += it.next().getTotalTransactionCount();
        }
        return totalTransactionCount;
    }

    public static void registerJmx() throws SQLException {
        if (hasRegisteredJmx) {
            return;
        }
        mbean.registerJmx();
        hasRegisteredJmx = true;
    }

    public static void removeHost(String str, String str2) throws SQLException {
        removeHost(str, str2, false);
    }

    public static void removeHost(String str, String str2, boolean z) throws SQLException {
        Iterator<ConnectionGroup> it = getGroupsMatching(str).iterator();
        while (it.hasNext()) {
            it.next().removeHost(str2, z);
        }
    }
}
