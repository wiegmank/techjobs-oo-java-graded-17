package org.launchcode.techjobs.oo;

import org.junit.Test;
import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job testJob1 = new Job();
        Job testJob2 = new Job();
        assertNotEquals(testJob1.getId(), testJob2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job testJob3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality Control"), new CoreCompetency("Persistence"));
        assertTrue(testJob3.getEmployer() instanceof Employer);
        assertTrue(testJob3.getLocation() instanceof Location);
        assertTrue(testJob3.getPositionType() instanceof PositionType);
        assertTrue(testJob3.getCoreCompetency() instanceof CoreCompetency);
        assertTrue(testJob3 instanceof Job);
        assertEquals(testJob3.getName(), "Product tester");
        assertEquals(testJob3.getEmployer().toString(), "ACME");
        assertEquals(testJob3.getLocation().toString(), "Desert");
        assertEquals(testJob3.getPositionType().toString(), "Quality Control");
        assertEquals(testJob3.getCoreCompetency().toString(), "Persistence");
    }

    @Test
    public void testJobsForEquality() {
        Job testJob4 = new Job("Bagger", new Employer("Walmart"), new Location("St. Louis"), new PositionType("Retail"), new CoreCompetency("Customer Service"));
        Job testJob5 = new Job("Bagger", new Employer("Walmart"), new Location("St. Louis"), new PositionType("Retail"), new CoreCompetency("Customer Service"));
        assertFalse(testJob4.equals(testJob5));
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine() {
        Job testJob6 = new Job();
        //int stringLength = testJob6.toString().length();
        String newLine = System.lineSeparator();
        assertTrue(testJob6.toString().startsWith(newLine));
        //assertTrue(testJob6.toString().endsWith(newLine));
    }


    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job testJob7 = new Job("Bagger", new Employer("Walmart"), new Location("St. Louis"), new PositionType("Retail"), new CoreCompetency("Customer Service"));
        String newLine = System.lineSeparator();
        assertTrue(testJob7.toString().contains("ID: " + testJob7.getId()));
        assertTrue(testJob7.toString().contains("Name: " + testJob7.getName()));
        assertTrue(testJob7.toString().contains("Employer: " + testJob7.getEmployer()));
        assertTrue(testJob7.toString().contains("Location: " + testJob7.getLocation()));
        assertTrue(testJob7.toString().contains("Position Type: " + testJob7.getPositionType()));
        assertTrue(testJob7.toString().contains("Core Competency: " + testJob7.getCoreCompetency()));
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job testJob8 = new Job();
        assertTrue(testJob8.toString().contains("Name: Data not available"));
        assertTrue(testJob8.toString().contains("Employer: Data not available"));
        assertTrue(testJob8.toString().contains("Location: Data not available"));
        assertTrue(testJob8.toString().contains("Position Type: Data not available"));
        assertTrue(testJob8.toString().contains("Core Competency: Data not available"));
    }
}
