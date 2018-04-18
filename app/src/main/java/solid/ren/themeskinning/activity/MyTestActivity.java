package solid.ren.themeskinning.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import solid.ren.skinlibrary.base.SkinBaseActivity;
import solid.ren.themeskinning.R;

public class MyTestActivity extends SkinBaseActivity {

    public static void launch(Context context) {
        Intent intent = new Intent(context, MyTestActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_test);
    }
}
