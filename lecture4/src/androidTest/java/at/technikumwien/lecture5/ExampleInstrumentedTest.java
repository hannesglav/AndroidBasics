<<<<<<< HEAD:lecture4/src/androidTest/java/at/technikumwien/lecture4/ExampleInstrumentedTest.java
package at.technikumwien.myLecture5;
=======
package at.technikumwien.lecture5;
>>>>>>> AndroidBasics_solution/summerterm2017:lecture4/src/androidTest/java/at/technikumwien/lecture5/ExampleInstrumentedTest.java

import android.content.Context;
import android.support.test.InstrumentationRegistry;
import android.support.test.runner.AndroidJUnit4;

import org.junit.Test;
import org.junit.runner.RunWith;

import static org.junit.Assert.*;

/**
 * Instrumentation test, which will execute on an Android device.
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
@RunWith(AndroidJUnit4.class)
public class ExampleInstrumentedTest {
    @Test
    public void useAppContext() throws Exception {
        // Context of the app under test.
        Context appContext = InstrumentationRegistry.getTargetContext();

        assertEquals("at.technikumwien.lecture4", appContext.getPackageName());
    }
}
