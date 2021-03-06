package com.deepankur.example.weatherhistory;

import android.content.Intent;
import android.os.Build;
import android.widget.Button;
import android.widget.TextView;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.Robolectric;
import org.robolectric.RobolectricTestRunner;
import org.robolectric.annotation.Config;
import org.robolectric.manifest.AndroidManifest;
import org.robolectric.shadows.ShadowActivity;
import org.robolectric.shadows.ShadowIntent;

import static junit.framework.TestCase.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.robolectric.Shadows.shadowOf;

//No such manifest file: build/intermediates/bundles/debug/some/build/path/AndroidManifest.xml
// 1
@Config( sdk = Build.VERSION_CODES.LOLLIPOP_MR1 )

// 2
@RunWith(RobolectricTestRunner.class)
public class WeatherActivityTest {

    WeatherActivity activity;

    // 3
    @Before
    public void setup() {
        activity = Robolectric.buildActivity(WeatherActivity.class).create().get();
    }


    @Test // 4
    public void validateTextViewContent() {
/*        TextView textView = (TextView) activity.findViewById(R.id.hello_TV);

        // 5
        assertNotNull("TextView is null", textView);
        // 6
        assertTrue("TextView's text does not match.", "Hello World!".equals(textView.getText().toString()));*/
    }


    @Test
    public void validateButtonClick() {
      /*  Button button = (Button) activity.findViewById(R.id.button_simple);

        // 7
        button.performClick();
        // 8
        ShadowActivity shadowActivity = shadowOf(activity);
        // 9
        Intent startedIntent = shadowActivity.getNextStartedActivity();
        // 10
        ShadowIntent shadowIntent = shadowOf(startedIntent);
        // 11
        assertThat(shadowIntent.getIntentClass().getName(), equalTo(HomeActivity.class.getName()));*/
    }

}
