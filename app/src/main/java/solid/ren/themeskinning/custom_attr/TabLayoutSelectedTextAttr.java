package solid.ren.themeskinning.custom_attr;

import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.view.View;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

public class TabLayoutSelectedTextAttr extends SkinAttr {

    @Override
    protected void applySkin(View view) {
        if (view instanceof TabLayout) {
            TabLayout tl = (TabLayout) view;
            if (isColor()) {
                int color = SkinResourcesUtils.getColor(attrValueRefId);
                tl.setTabTextColors(Color.parseColor("#6c6b6b"), color);
            }
        }
    }
}
