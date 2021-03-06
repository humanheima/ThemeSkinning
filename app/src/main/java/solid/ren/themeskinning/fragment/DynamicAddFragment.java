package solid.ren.themeskinning.fragment;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.squareup.leakcanary.RefWatcher;

import java.util.ArrayList;
import java.util.List;

import solid.ren.skinlibrary.attr.base.DynamicAttr;
import solid.ren.skinlibrary.base.SkinBaseFragment;
import solid.ren.themeskinning.App;
import solid.ren.themeskinning.R;

/**
 * Created by _SOLID
 * Date:2016/7/13
 * Time:21:37
 */
public class DynamicAddFragment extends SkinBaseFragment {

    private LinearLayout ll_dynamic_view;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_dynamic_add, container, false);
        ll_dynamic_view = view.findViewById(R.id.ll_dynamic_view);
        createDynamicView();
        return view;
    }

    private void createDynamicView() {
        ImageView imageView = new ImageView(getContext());
        imageView.setBackgroundResource(R.mipmap.mipmap_img);
        imageView.setLayoutParams(new ViewGroup.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT));
        dynamicAddView(imageView, "background", R.mipmap.mipmap_img);
        ll_dynamic_view.addView(imageView);

        List<DynamicAttr> attrList = new ArrayList<>(2);
        attrList.add(new DynamicAttr("textColor", R.color.item_tv_title_color));
        attrList.add(new DynamicAttr("background", R.color.item_tv_title_background));
        for (int i = 0; i < 10; i++) {
            TextView textView1 = new TextView(getContext());
            textView1.setText("我是动态创建的TextView" + i + ",我也可以换肤");
            textView1.setTextColor(getResources().getColor(R.color.item_tv_title_color));
            ViewGroup.MarginLayoutParams params = new ViewGroup.MarginLayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
            params.setMargins(20, 20, 20, 20);
            textView1.setLayoutParams(params);
            dynamicAddView(textView1, attrList);
            ll_dynamic_view.addView(textView1);
            dynamicAddFontView(textView1);
        }
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        RefWatcher refWatcher = App.getRefWatcher(getActivity());
        refWatcher.watch(this);
    }
}
