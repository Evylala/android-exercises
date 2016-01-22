package fr.android.androidexercises;

import android.app.Activity;
import android.app.Instrumentation;
import android.test.ActivityInstrumentationTestCase2;

import org.assertj.android.api.Assertions;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.model.InitializationError;
import org.mockito.Mockito;
import org.robolectric.Robolectric;
import org.robolectric.shadows.ShadowToast;

@RunWith(CustomRobolectricTestRunner.class)
public class LoginActivityTest {

    LoginActivity activity;

    @Before
    public void setUp() throws Exception {
        activity = Robolectric.setupActivity(LoginActivity.class);
    }
    @Test
     public void should_set_logged_state() throws Exception
    {
        // Given
        // When
        activity.logged();
        // Then
        Assertions.assertThat(activity.loginLayout).isGone();
        Assertions.assertThat(activity.loggedText).isVisible();
    }

    @Test
    public void should_not_set_logged_state() throws Exception
    {
        // Given
        // When
        activity.notLogged();
        // Then
        Assertions.assertThat(activity.loginLayout).isVisible();
        Assertions.assertThat(activity.loggedText).isGone();
    }

    @Test
    public void testMessage() throws Exception {
        activity.message(R.string.action_login);
        String textOfLatestToast = ShadowToast.getTextOfLatestToast();
        org.assertj.core.api.Assertions.assertThat(textOfLatestToast).isEqualTo("log me in");
    }

//    public LoginActivityTest() {
//        super(LoginActivity.class);
//    }
//
//    @Override
//    public void setUp() throws Exception {
//        super.setUp();
//        injectInstrumentation(InstrumentationRegistry.getInstrumentation());
//        getActivity();
//    }
//
//    public void takeScreenshot(String name) {
//        Spoon.screenshot(getCurrentActivity(), name);
//    }
//
//    public Activity getCurrentActivity() {
//        Instrumentation instrumentation = InstrumentationRegistry.getInstrumentation();
//        instrumentation.waitForIdleSync();
//        final Activity[] activity = new Activity[1];
//        instrumentation.runOnMainSync(new Runnable() {
//            @Override
//            public void run() {
//                ActivityLifecycleMonitor activityLifecycleMonitor = ActivityLifecycleMonitorRegistry.getInstance();
//                java.util.Collection<Activity> resumedActivities = activityLifecycleMonitor.getActivitiesInStage(Stage.RESUMED);
//                activity[0] = Iterables.getOnlyElement(resumedActivities);
//            }
//        });
//        return activity[0];
//    }

}