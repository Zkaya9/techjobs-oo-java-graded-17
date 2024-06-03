package org.launchcode.techjobs.oo;

import org.junit.Test;

import static org.junit.Assert.*;

public class JobTest {
    //TODO: Create your unit tests here
    @Test
    public void testSettingJobId() {
        Job job1 = new Job();
        Job job2 = new Job();
        assertNotEquals(job1.getId(), job2.getId());
    }

  //  private Employer acmeEmployer = new Employer("ACME");
    @Test
    public void testJobConstructorSetsAllFields() {
        Job job = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertTrue(job.getName() instanceof String);
        assertTrue(job.getEmployer() instanceof Employer);
        assertTrue(job.getLocation() instanceof Location);
        assertTrue(job.getPositionType() instanceof PositionType);
        assertTrue(job.getCoreCompetency() instanceof CoreCompetency);

        assertEquals("Product tester", job.getName());
        assertEquals(new Employer("ACME"), job.getEmployer());
        assertEquals(new Location("Desert"), job.getLocation());
        assertEquals(new PositionType("Quality control"), job.getPositionType());
        assertEquals(new CoreCompetency("Persistence"), job.getCoreCompetency());
    }

    @Test
    public void testJobsForEquality() {
        Job job1 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        Job job2 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));

        assertFalse(job1.equals(job2));
    }

    @Test
    public void testToStringContainsCorrectLabelsAndData() {
        Employer launchCode = new Employer("LaunchCode");
        Location earthLocation = new Location("Earth");
        PositionType fullTimeType = new PositionType("Full-Time");
        CoreCompetency codingCompetency = new CoreCompetency("Coding");

        Job job = new Job("Software Engineer", launchCode, earthLocation, fullTimeType, codingCompetency);

        String expectedResult = System.lineSeparator() +
                "Name: " + job.getName() + System.lineSeparator() +
                "Employer: " + job.getEmployer().toString() + System.lineSeparator() +
                "Location: " + job.getLocation().toString() + System.lineSeparator() +
                "Position Type: " + job.getPositionType().toString() + System.lineSeparator() +
                "Core Competency: " + job.getCoreCompetency().toString() + System.lineSeparator();
        assertEquals(expectedResult, job.toString());
    }

    @Test
    public void testToStringHandlesEmptyField() {
        Employer launchCode = new Employer("LaunchCode");
        Job job = new Job(null, launchCode, null, null, null);

        String expectedResult = System.lineSeparator() +
                "Name: Data not available" + System.lineSeparator() +
                "Employer: LaunchCode" + System.lineSeparator() +
                "Location: Data not available" + System.lineSeparator() +
                "Position Type: Data not available" + System.lineSeparator() +
                "Core Competency: Data not available" + System.lineSeparator();
        assertEquals(expectedResult, job.toString());
    }


}
