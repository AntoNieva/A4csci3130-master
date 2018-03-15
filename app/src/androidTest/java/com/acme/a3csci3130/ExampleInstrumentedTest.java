package com.acme.a3csci3130;

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    final public String name = "Sammy";
    final public String email = "123456789";
    final public String business = "Fish Monger";
    final public String address = "Kent St";
    final public String province = "NS";
    public String name1 = "Liwei Men";
    public String email1 = "987654321";
    public String business1 = "Fisher";
    public String address1 = "Spring Garden";
    public String province1 = "ON";



    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("com.acme.a3csci3130", appContext.getPackageName());
    }
    @Test
    public void testCreate() {
        onView(withId(R.id.submitButton)).perform(click());
        onView(withId(R.id.name)).perform(typeText(name));
        onView(withId(R.id.number)).perform(typeText(email));
        onView(withId(R.id.business)).perform(typeText(business));
        onView(withId(R.id.address)).perform(typeText(address));
        onView(withId(R.id.province)).perform(typeText(province));
        onView((withId(R.id.submitButton))).perform(click());
        onView(withId(R.id.listView)).perform(click());
    }
    @Test
    public void testRead(){
        onView(withId(R.id.name)).check(matches(withText("Sammy")));
        onView(withId(R.id.number)).check(matches(withText("123456789")));
        onView(withId(R.id.business)).check(matches(withText("Fish Monger")));
        onView(withId(R.id.address)).check(matches(withText("Kent St")));
        onView(withId(R.id.province)).check(matches(withText("NS")));

    }
    @Test
    public void testUpdate(){
        onView(withId(R.id.name)).perform(typeText(name1));
        onView(withId(R.id.number)).perform(typeText(email1));
        onView(withId(R.id.business)).perform(typeText(business1));
        onView(withId(R.id.address)).perform(typeText(address1));
        onView(withId(R.id.province)).perform(typeText(province1));
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.updateButton)).perform(click());



    }
    @Test
    public void testDelete(){
        onView(withId(R.id.listView)).perform(click());
        onView(withId(R.id.deleteButton)).perform(click());
    }
}
