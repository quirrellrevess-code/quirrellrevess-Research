package com.mysql.jdbc;

import java.sql.SQLException;

/* JADX INFO: loaded from: classes.dex */
public class PacketTooBigException extends SQLException {
    public static final long serialVersionUID = 7248633977685452174L;

    public PacketTooBigException(long j, long j2) {
        super(Messages.getString("PacketTooBigException.0") + j + Messages.getString("PacketTooBigException.1") + j2 + Messages.getString("PacketTooBigException.2") + Messages.getString("PacketTooBigException.3") + Messages.getString("PacketTooBigException.4"), SQLError.SQL_STATE_GENERAL_ERROR);
    }
}
