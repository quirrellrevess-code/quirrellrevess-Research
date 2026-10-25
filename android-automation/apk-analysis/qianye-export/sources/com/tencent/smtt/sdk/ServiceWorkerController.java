package com.tencent.smtt.sdk;

import android.content.Context;
import android.os.Build;
import com.tencent.smtt.export.external.interfaces.IX5CoreServiceWorkerController;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerClient;
import com.tencent.smtt.export.external.interfaces.ServiceWorkerWebSettings;

/* JADX INFO: loaded from: classes.dex */
public abstract class ServiceWorkerController {
    public static ServiceWorkerController getInstance(Context context) {
        C0431u c0431uM530a = C0431u.m530a();
        c0431uM530a.m532a(context);
        if (!c0431uM530a.m534b()) {
            if (Build.VERSION.SDK_INT >= 24) {
                return new C0416j();
            }
            return null;
        }
        final IX5CoreServiceWorkerController iX5CoreServiceWorkerControllerM600q = C0431u.m530a().m535c().m600q();
        if (iX5CoreServiceWorkerControllerM600q != null) {
            return new ServiceWorkerController() { // from class: com.tencent.smtt.sdk.ServiceWorkerController.1
                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public ServiceWorkerWebSettings getServiceWorkerWebSettings() {
                    return iX5CoreServiceWorkerControllerM600q.getServiceWorkerWebSettings();
                }

                @Override // com.tencent.smtt.sdk.ServiceWorkerController
                public void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient) {
                    iX5CoreServiceWorkerControllerM600q.setServiceWorkerClient(serviceWorkerClient);
                }
            };
        }
        return null;
    }

    public abstract ServiceWorkerWebSettings getServiceWorkerWebSettings();

    public abstract void setServiceWorkerClient(ServiceWorkerClient serviceWorkerClient);
}
