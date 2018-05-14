package solid.ren.themeskinning;

import android.content.Context;

import com.squareup.leakcanary.LeakCanary;
import com.squareup.leakcanary.RefWatcher;

import solid.ren.skinlibrary.SkinConfig;
import solid.ren.skinlibrary.base.SkinBaseApplication;
import solid.ren.themeskinning.custom_attr.BsbThumbColorAttr;
import solid.ren.themeskinning.custom_attr.BsbTrackColorAttr;
import solid.ren.themeskinning.custom_attr.RadioButtonAttr;
import solid.ren.themeskinning.custom_attr.TabLayoutIndicatorAttr;
import solid.ren.themeskinning.custom_attr.TabLayoutSelectedTextAttr;

/**
 * Created by _SOLID
 * Date:2016/7/5
 * Time:10:06
 */
public class App extends SkinBaseApplication {

    private RefWatcher refWatcher;

    @Override
    public void onCreate() {
        super.onCreate();
        SkinConfig.setCanChangeStatusColor(true);
        SkinConfig.setCanChangeFont(true);
        SkinConfig.setDebug(true);
        SkinConfig.addSupportAttr("tabIndicatorColor", new TabLayoutIndicatorAttr());
        SkinConfig.addSupportAttr("tabSelectedTextColor", new TabLayoutSelectedTextAttr());
        SkinConfig.addSupportAttr("button", new RadioButtonAttr());
        SkinConfig.addSupportAttr("bsb_thumb_color", new BsbThumbColorAttr());
        SkinConfig.addSupportAttr("bsb_track_color", new BsbTrackColorAttr());
        SkinConfig.enableGlobalSkinApply();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            refWatcher = RefWatcher.DISABLED;
            return;
        }
        refWatcher = LeakCanary.install(this);
    }

    public static RefWatcher getRefWatcher(Context context) {
        App leakApplication = (App) context.getApplicationContext();
        return leakApplication.refWatcher;
    }
}
