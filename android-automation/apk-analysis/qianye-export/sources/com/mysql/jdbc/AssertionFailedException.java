package com.mysql.jdbc;

/* JADX INFO: loaded from: classes.dex */
public class AssertionFailedException extends RuntimeException {
    private static final long serialVersionUID = 1;

    public AssertionFailedException(Exception exc) {
        super(Messages.getString("AssertionFailedException.0") + exc.toString() + Messages.getString("AssertionFailedException.1"));
    }

    public static void shouldNotHappen(Exception exc) throws AssertionFailedException {
        throw new AssertionFailedException(exc);
    }
}
