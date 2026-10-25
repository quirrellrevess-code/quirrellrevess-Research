package com.sun.mail.handlers;

import javax.activation.ActivationDataFlavor;

/* JADX INFO: loaded from: classes.dex */
public class text_xml extends text_plain {
    private static ActivationDataFlavor myDF = new ActivationDataFlavor(String.class, "text/xml", "XML String");

    @Override // com.sun.mail.handlers.text_plain
    public ActivationDataFlavor getDF() {
        return myDF;
    }
}
