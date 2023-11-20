package com.cruning.testroborzzi

import android.view.View
import android.widget.Button
import androidx.test.core.app.ActivityScenario
import androidx.test.espresso.Espresso.onView
import androidx.test.espresso.matcher.ViewMatchers
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.github.takahirom.roborazzi.RobolectricDeviceQualifiers
import com.github.takahirom.roborazzi.captureRoboImage
import junit.framework.TestCase.assertEquals
import org.junit.Test
import org.junit.runner.RunWith
import org.robolectric.Robolectric
import org.robolectric.RobolectricTestRunner
import org.robolectric.annotation.Config
import org.robolectric.annotation.GraphicsMode


/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * See [testing documentation](http://d.android.com/tools/testing).
 */
@RunWith(RobolectricTestRunner::class)
class WelcomeActivityTest {
    @Test
    fun clickingLogin_shouldStartLoginActivity() {
        Robolectric.buildActivity(WelcomeActivity::class.java).use { controller ->
            controller.setup()
            val activity = controller.get()
            activity.findViewById<View>(R.id.login).performClick()
            Robolectric.buildActivity(LoginActivity::class.java).use { controller2 ->
                controller2.setup()
                val activity2 = controller2.get()
                assertEquals(
                    activity2.findViewById<Button>(R.id.login).text,
                    "qwer"
                )
            }
        }
    }
}

@RunWith(AndroidJUnit4::class)
@GraphicsMode(GraphicsMode.Mode.NATIVE)
@Config(
    sdk = [30],
    qualifiers = RobolectricDeviceQualifiers.NexusOne
)
class NoComposeManualTest {
    @Test
    @Config(qualifiers = "+land")
    fun captureRoboImageSample() {
        // launch
        ActivityScenario.launch(WelcomeActivity::class.java)
        // screen level image
        onView(ViewMatchers.isRoot())
            .captureRoboImage()
    }
}

