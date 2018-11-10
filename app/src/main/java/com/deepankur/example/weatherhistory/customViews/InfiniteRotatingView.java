package com.deepankur.example.weatherhistory.customViews;

import android.content.Context;
import android.util.AttributeSet;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;

import com.deepankur.example.weatherhistory.R;

public class InfiniteRotatingView extends android.support.v7.widget.AppCompatImageView {
    private Animation rotation;
    public InfiniteRotatingView(Context context) {
        super(context);
        init(context);
    }

    public InfiniteRotatingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init(context);
    }

    public InfiniteRotatingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init(context);
    }

    @Override
    public void setVisibility(int visibility) {
        if (visibility == VISIBLE) {
            startAnimation(rotation);
        } else {
            clearAnimation();
        }
        super.setVisibility(visibility);
    }



    private void init(Context context) {
        rotation = AnimationUtils.loadAnimation(context, R.anim.rotate);
        rotation.setFillAfter(true);

    }
}
