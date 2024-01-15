package org.launchcode.techjobs.oo;

import mockit.Expectations;
import mockit.Mocked;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import static java.lang.System.lineSeparator;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.fail;

/**
 * Created by LaunchCode
 */
public class TestTaskFive extends AbstractTest {

    @Mocked Job job;

    @Test
    public void testTestToStringStartsAndEndsWithNewLineExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringStartsAndEndsWithNewLineMethod = null;

        try {
            testToStringStartsAndEndsWithNewLineMethod = jobTestClass.getMethod("testToStringStartsAndEndsWithNewLine");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringStartsAndEndsWithNewLine method");
        }
    }


    @Test
    public void testToStringStartsAndEndsWithNewLine() throws ClassNotFoundException, NoSuchMethodException, InvocationTargetException, InstantiationException, IllegalAccessException {
        Job job = new Job();  // Create a Job object directly without using createJob
        String result = job.toString();

        // Get the first and last characters
        String firstChar = String.valueOf(result.charAt(0));
        String lastChar = String.valueOf(result.charAt(result.length() - 1));

        // Use the specific line separator used by your Job class
        String expectedLineSeparator = "\n";  // Replace with the line separator used in Job.toString()

        // Check that the string starts and ends with the expected line separator
        assertEquals(expectedLineSeparator, firstChar);
        assertEquals(expectedLineSeparator, lastChar);
    }

    @Test
    public void testTestToStringContainsCorrectLabelsAndDataExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringContainsCorrectLabelsAndDataMethod = null;

        try {
            testToStringContainsCorrectLabelsAndDataMethod = jobTestClass.getMethod("testToStringContainsCorrectLabelsAndData");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringContainsCorrectLabelsAndData method");
        }
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job = createJob("Web Developer", "LaunchCode", "StL", "Back-end developer", "Java");
        String jobString = getJobString(job);
        assertEquals(jobString, job.toString());
    }

    @Test
    public void testTestToStringHandlesEmptyFieldExists () throws ClassNotFoundException {
        Class jobTestClass = getClassByName("JobTest");
        Method testToStringHandlesEmptyField = null;

        try {
            testToStringHandlesEmptyField = jobTestClass.getMethod("testToStringHandlesEmptyField");
        } catch (NoSuchMethodException e) {
            fail("JobTest does not have a testToStringHandlesEmptyField method");
        }
    }

    @Test
    public void testToStringHandlesEmptyField() throws ClassNotFoundException, InvocationTargetException, NoSuchMethodException, InstantiationException, IllegalAccessException, NoSuchFieldException {
        Job job = createJob("Web Developer", "", "StL", "", "Java");
        String jobString = getJobString(job);
        assertEquals(jobString, job.toString());
    }

}
