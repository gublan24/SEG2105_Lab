package com.example.mysqldatabaseapplication;

import android.app.Fragment;
import android.content.Context;

import androidx.test.espresso.ViewInteraction;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.platform.app.InstrumentationRegistry;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.rule.ActivityTestRule;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.util.ArrayList;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.action.ViewActions.typeText;
import static androidx.test.espresso.matcher.ViewMatchers.isClickable;
import static androidx.test.espresso.matcher.ViewMatchers.withId;
import static org.junit.Assert.*;

/**
 * Instrumented test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {

    @Rule
    public ActivityTestRule<MainActivity> activityActivityTestRule = new ActivityTestRule<MainActivity>(MainActivity.class);

    @Before
    public void init(){
        activityActivityTestRule.getActivity()
                .getSupportFragmentManager().beginTransaction();
    }

    @Test
    public void addProductTest()
    {
        MyDBHandler dbHandler = new MyDBHandler(activityActivityTestRule.getActivity());
        //ListView listView = findViewById(R.id.prodctListView);
        int sizeBefore =  dbHandler.getAllProducts().size();
        onView(withId(R.id.productName))
                .perform(typeText("Apple Tv"));
        onView(withId(R.id.productSku))
                .perform(typeText("341"));

        onView(withId(R.id.addButton))
                .perform(click());
        int sizeAfter =  dbHandler.getAllProducts().size();

        assertEquals(sizeBefore+1,sizeAfter);
    }

    @Test
    public void useAppContext() {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getInstrumentation().getTargetContext();

        assertEquals("com.example.mysqldatabaseapplication", appContext.getPackageName());
    }
}
