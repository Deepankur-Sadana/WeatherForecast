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
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.isDisplayed;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;
import static org.hamcrest.CoreMatchers.not;

/**
 * This suit tests offline behaviour of application
 */
@RunWith(AndroidJUnit4.class)
@LargeTest
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OfflineActivityTest {

    @Rule
    public ActivityTestRule<WeatherActivity> mActivityRule = new ActivityTestRule<>(
            WeatherActivity.class);


    @Before
    public void setUp() throws Exception {
        //Before Test case execution
    }

    @Test
    public void retyButtonVisibleInOffline() {
        onView(withText("retry")).check(matches((isDisplayed())));
    }

    /**
     * loader is not visible in offline mode initally as we have no network to fetch data from
     */
    @Test
    public void loadingNotVisibleInitially() {
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())));
    }

    /**
     * In offline adter clicking retry loader should not be visible as we have no network to fetch data from
     */
    @Test
    public void performClickInOfflineMode(){
        onView(withId(R.id.retryTV)).perform(click());
        onView(withId(R.id.loading)).check(matches(not(isDisplayed())));
    }

    @After
    public void tearDown() throws Exception {
        //After Test case Execution
    }
}