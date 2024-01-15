package org.launchcode.techjobs.oo;

import org.junit.Test;
import org.launchcode.techjobs.oo.Job;

import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;


public class JobTest {
    //TODO: Create your unit tests here
        @Test
        public void testSettingJobId() {
            // Create two Job objects using the empty constructor
            Job job1 = new Job();
            Job job2 = new Job();

            // Use assertNotEquals to verify that the IDs of the two objects are distinct
            assertNotEquals(job1.getId(), job2.getId());
        }

    @Test
    public void testJobConstructorSetsAllFields() {
        // Declare and initialize a new Job object with the specified data
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"),
                new PositionType("Quality control"), new CoreCompetency("Persistence"));

        // Use assertTrue and assertEquals statements to test the constructor
        assertTrue(job instanceof Job);

        // Test each field for correct assignment
        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }
    @Test
    public void testJobsForEquality() {
        // Generate two Job objects with identical field values EXCEPT for id
        Job job1 = new Job("Software Developer", new Employer("Tech Corp"), new Location("City Center"),
                new PositionType("Full Stack"), new CoreCompetency("Java"));
        Job job2 = new Job("Software Developer", new Employer("Tech Corp"), new Location("City Center"),
                new PositionType("Full Stack"), new CoreCompetency("Java"));

        // Test that equals returns false
        assertFalse(job1.equals(job2));
    }
    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        //Create a Job object with default data
        Job job = new Job();

        // Get the result of toString()
        String result = job.toString();

        // Check that the string starts and ends with a newline
        assertTrue(result.startsWith("\n"));
        assertTrue(result.endsWith("\n"));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job.resetNextId();
        // Create a Job object with specific data
        Job job = new Job("Software Developer", new Employer("Tech Corp"), new Location("City Center"),
                new PositionType("Full Stack"), new CoreCompetency("Java"));

        // Get the result of toString()
        String result = job.toString();

        // Check that the string contains correct labels and data
        assertEquals("\nID: 1\n" +
                "Name: Software Developer\n" +
                "Employer: Tech Corp\n" +
                "Location: City Center\n" +
                "Position Type: Full Stack\n" +
                "Core Competency: Java\n" , result);
    }

    @Test
    public void testToStringHandlesEmptyField() {
        // Create a Job object with some fields set to null or empty values
        Job job = new Job("", null, new Location(""), new PositionType(""), new CoreCompetency(""));

        // Get the result of toString()
        String result = job.toString();

        // Check that the string contains "Data not available" for empty fields
        assertTrue(result.contains("Name: Data not available"));
        assertTrue(result.contains("Employer: Data not available"));
        assertTrue(result.contains("Location: Data not available"));
        assertTrue(result.contains("Position Type: Data not available"));
        assertTrue(result.contains("Core Competency: Data not available"));
    }

}
