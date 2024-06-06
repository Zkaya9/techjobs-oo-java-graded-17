package org.launchcode.techjobs.oo;

import org.junit.Test;

import java.util.IdentityHashMap;

import static org.junit.Assert.*;

public class JobTest {
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals("ACME", job.getEmployer().getValue());
        assertEquals("Desert", job.getLocation().getValue());
        assertEquals("Quality control", job.getPositionType().getValue());
        assertEquals("Persistence", job.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Job job = new Job("Software Engineer", new Employer("LaunchCode"), new Location("Earth"), new PositionType("Full-Time"), new CoreCompetency("Coding"));

        String expectedResult = String.format(System.lineSeparator() +
                "ID: %d%n" +
                "Name: %s%n" +
                "Employer: %s%n" +
                "Location: %s%n" +
                "Position Type: %s%n" +
                "Core Competency: %s%n", job.getId(), "Software Engineer", "LaunchCode", "Earth", "Full-Time", "Coding");

        assertEquals(expectedResult, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Job job = new Job("Web Developer", new Employer(""), new Location("StL"), new PositionType(""), new CoreCompetency("Java"));
//        Job job = createJob("Web Developer", new Employer(""), "StL", "", "Java");

        String expectedResult = String.format(System.lineSeparator() +
                "ID: %d" + System.lineSeparator() +
                "Name: %s" + System.lineSeparator() +
                "Employer: Data not available" + System.lineSeparator() +
                "Location: %s" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: %s" + System.lineSeparator() , job.getId(), job.getName(), job.getLocation(), job.getCoreCompetency());

        assertEquals(expectedResult, job.toString());
    }

    @Test
    public void testToStringStartsAndEndsWithNewLine () {
        Job job = new Job("Software Engineer", new Employer("LaunchCode"), new Location("StL"), new PositionType("Web Developer"), new CoreCompetency("Java"));

        assertEquals(String.valueOf(job.toString().charAt(0)),System.lineSeparator());
        assertEquals(String.valueOf(job.toString().charAt(job.toString().length() - 1)),System.lineSeparator());
    }
}
