package com.deepankur.example.weatherhistory;

import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ActivityTest {

    @Rule
    public ActivityTestRule<WeatherActivity> mActivityRule = new ActivityTestRule<>(
            WeatherActivity.class);


    @Before
    public void setUp() throws Exception {
        //Before Test case execution
    }

    @Test
    public void retryNotVisibleInitially() {
        onView(withText("retry")).check(matches(not(isDisplayed())));
    }

    @Test
    public void loadingNotVisibleInitially() {
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())));
    }

    /**
     * We'll generate tomorrows day ie . monday/tuesday by shifting time to 24 hrs later
     * and assert whether this is actually the second item in recycler view
     */
    @Test
    public void aatestCorrectDay(){
        onView(TestUtils.withRecyclerView(R.id.recyclerView)
                .atPositionOnView(1, R.id.day))
                .check(matches(withText(TestUtils.getommorow(System.currentTimeMillis()))));
    }
    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}