package solid.ren.themeskinning.custom_attr;

import android.view.View;

import com.xw.repo.BubbleSeekBar;

import solid.ren.skinlibrary.attr.base.SkinAttr;
import solid.ren.skinlibrary.utils.SkinResourcesUtils;

/**
 * Created by _SOLID
 * Date:2017/6/26
 * Time:13:51
 * Desc:
 */

public class BsbThumbColorAttr extends SkinAttr {
    @Override
    protected void applySkin(View view) {
        if (view instanceof BubbleSeekBar) {
            if (isColor()) {
                BubbleSeekBar bubbleSeekBar = (BubbleSeekBar) view;
                int color = SkinResourcesUtils.getColor(attrValueRefId);
                bubbleSeekBar.setThumbColor(color);
            }

        }
    }
}
