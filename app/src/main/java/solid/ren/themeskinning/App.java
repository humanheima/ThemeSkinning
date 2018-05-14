package solid.ren.themeskinning;

import com.squareup.leakcanary.LeakCanary;

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
    @Override
    public void onCreate() {
        super.onCreate();
        if (LeakCanary.isInAnalyzerProcess(this)) {
            return;
        }
        LeakCanary.install(this);
        SkinConfig.setCanChangeStatusColor(true);
        SkinConfig.setCanChangeFont(true);
        SkinConfig.setDebug(true);
        SkinConfig.addSupportAttr("tabIndicatorColor", new TabLayoutIndicatorAttr());
        SkinConfig.addSupportAttr("tabSelectedTextColor", new TabLayoutSelectedTextAttr());
        SkinConfig.addSupportAttr("button", new RadioButtonAttr());
        SkinConfig.addSupportAttr("bsb_thumb_color", new BsbThumbColorAttr());
        SkinConfig.addSupportAttr("bsb_track_color", new BsbTrackColorAttr());
        SkinConfig.enableGlobalSkinApply();
    }
}
