package com.nytarticles.assessment.view;


import android.os.SystemClock;
import android.support.test.espresso.ViewInteraction;
import android.support.test.filters.LargeTest;
import android.support.test.rule.ActivityTestRule;
import android.support.test.runner.AndroidJUnit4;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;

import com.nytarticles.assessment.R;

import org.hamcrest.Description;
import org.hamcrest.Matcher;
import org.hamcrest.TypeSafeMatcher;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

import static android.support.test.espresso.Espresso.onView;
import static android.support.test.espresso.Espresso.pressBack;
import static android.support.test.espresso.action.ViewActions.click;
import static android.support.test.espresso.contrib.RecyclerViewActions.actionOnItemAtPosition;
import static android.support.test.espresso.matcher.ViewMatchers.withClassName;
import static android.support.test.espresso.matcher.ViewMatchers.withId;
import static org.hamcrest.Matchers.allOf;
import static org.hamcrest.Matchers.is;

@LargeTest
@RunWith(AndroidJUnit4.class)
public class ArticleListActivityTest {

    @Rule
    public ActivityTestRule<ArticleListActivity> mActivityTestRule = new ActivityTestRule<>(ArticleListActivity.class);

    @Test
    public void articleListActivityTest() {
        ViewInteraction recyclerView = onView(
                allOf(withId(R.id.articleListView),
                        childAtPosition(
                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                2)));
        SystemClock.sleep(3000);
        recyclerView.perform(actionOnItemAtPosition(0, click()));
        SystemClock.sleep(3000);
        pressBack();
        SystemClock.sleep(2000);

        ViewInteraction recyclerView2 = onView(
                allOf(withId(R.id.articleListView),
                        childAtPosition(
                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                2)));
        recyclerView2.perform(actionOnItemAtPosition(2, click()));
        SystemClock.sleep(3000);

        pressBack();
        SystemClock.sleep(2000);

        ViewInteraction recyclerView3 = onView(
                allOf(withId(R.id.articleListView),
                        childAtPosition(
                                withClassName(is("android.support.design.widget.CoordinatorLayout")),
                                2)));
        recyclerView3.perform(actionOnItemAtPosition(9, click()));
        SystemClock.sleep(3000);

        pressBack();
        SystemClock.sleep(2000);
    }

    private static Matcher<View> childAtPosition(
            final Matcher<View> parentMatcher, final int position) {

        return new TypeSafeMatcher<View>() {
            @Override
            public void describeTo(Description description) {
                description.appendText("Child at position " + position + " in parent ");
                parentMatcher.describeTo(description);
            }

            @Override
            public boolean matchesSafely(View view) {
                ViewParent parent = view.getParent();
                return parent instanceof ViewGroup && parentMatcher.matches(parent)
                        && view.equals(((ViewGroup) parent).getChildAt(position));
            }
        };
    }
}
