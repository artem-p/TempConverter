package ru.artempugachev.tempconverter;

/**
 * Created by artem on 10.05.15.
 */
import android.support.test.InstrumentationRegistry;
import android.test.ActivityInstrumentationTestCase2;

import org.junit.Before;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.action.ViewActions.closeSoftKeyboard;
import static android.support.test.espresso.action.ViewActions.typeText;
import static android.support.test.espresso.assertion.ViewAssertions.matches;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static android.support.test.espresso.matcher.ViewMatchers.withText;

public class GuiTest
        extends ActivityInstrumentationTestCase2<MainActivity> {

    private MainActivity mActivity;

    public GuiTest() {
        super(MainActivity.class);
    }

    @Before
    public void setUp() throws Exception {
        super.setUp();
        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
        mActivity = getActivity();
    }

    public void testRefreshButton() {
        onView(withId(R.id.tvCelsius)).perform(typeText("25.55"), closeSoftKeyboard());
        onView(withId(R.id.tvFahr)).perform(typeText("-50.5"), closeSoftKeyboard());
        onView(withId(R.id.btnRefresh)).perform(click());

        onView(withId(R.id.tvCelsius)).check(matches(withText("")));
        onView(withId(R.id.tvFahr)).check(matches(withText("")));
    }

    public void testCelsiusToFahr() {
        onView(withId(R.id.tvCelsius))
                .perform(typeText("0"), closeSoftKeyboard());
        onView(withId(R.id.btnCtoF)).perform(click());
        onView(withId(R.id.tvFahr)).check(matches(withText("32.0")));
        onView(withId(R.id.btnRefresh)).perform(click());

        onView(withId(R.id.tvCelsius))
                .perform(typeText("25"), closeSoftKeyboard());
        onView(withId(R.id.btnCtoF)).perform(click());
        onView(withId(R.id.tvFahr)).check(matches(withText("77.0")));
        onView(withId(R.id.btnRefresh)).perform(click());

        onView(withId(R.id.tvCelsius))
                .perform(typeText("15.75"), closeSoftKeyboard());
        onView(withId(R.id.btnCtoF)).perform(click());
        onView(withId(R.id.tvFahr)).check(matches(withText("60.35")));
        onView(withId(R.id.btnRefresh)).perform(click());

        onView(withId(R.id.tvCelsius))
                .perform(typeText("-27.3"), closeSoftKeyboard());
        onView(withId(R.id.btnCtoF)).perform(click());
        onView(withId(R.id.tvFahr)).check(matches(withText("-17.14")));
        onView(withId(R.id.btnRefresh)).perform(click());
    }

    public void testFahrToCelsius() {
        onView(withId(R.id.tvFahr)).perform(typeText("451"), closeSoftKeyboard());
        onView(withId(R.id.btnFtoC)).perform(click());
        onView(withId(R.id.tvCelsius)).check(matches(withText("232.77777")));
        onView(withId(R.id.btnRefresh)).perform(click());

        onView(withId(R.id.tvFahr)).perform(typeText("-33.33333"), closeSoftKeyboard());
        onView(withId(R.id.btnFtoC)).perform(click());
        onView(withId(R.id.tvCelsius)).check(matches(withText("-36.29629")));
        onView(withId(R.id.btnRefresh)).perform(click());

        onView(withId(R.id.tvFahr)).perform(typeText("42"), closeSoftKeyboard());
        onView(withId(R.id.btnFtoC)).perform(click());
        onView(withId(R.id.tvCelsius)).check(matches(withText("5.5555553")));
        onView(withId(R.id.btnRefresh)).perform(click());
    }

}
