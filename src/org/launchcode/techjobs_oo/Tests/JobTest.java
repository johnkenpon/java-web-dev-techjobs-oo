package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {

    Job job1;
    Job job2;
    Job job3;

    @Before
    public void createJobObject(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
    }

    @Test
    public void testSettingJobId(){
        assertEquals(job1.getId(), job2.getId(), 1);
    }

    @Test
    public void testJobConstructorSetsAllFields(){
        assertEquals("Product tester", job3.getName());
        assertEquals("ACME", job3.getEmployer().getValue());
        assertEquals("Desert", job3.getLocation().getValue());
        assertEquals("Quality control", job3.getPositionType().getValue());
        assertEquals("Persistence", job3.getCoreCompetency().getValue());
    }

    @Test
    public void testJobsForEquality(){
        assertFalse(job1.equals(job2));
    }

    @Test
    public void testJobToString(){
        String testString = "\n" + "ID: " + job3.getId() + "\n" + "Name: " + job3.getName() + "\n" + "Employer: " + job3.getEmployer() +
                "\n" + "Location: " + job3.getLocation() + "\n" + "Position Type: " + job3.getPositionType() + "\n" + "Core Compentency: " + job3.getCoreCompetency();
        assertTrue(testString.equals(job3.toString()));

        String testStringBlank = "\n" + "ID: " + job3.getId() + "\n" + "Name: Data not available" + "\n" + "Employer: Data not available " +
                "\n" + "Location: Data not available" + "\n" + "Position Type: Data not available" + "\n" + "Core Compentency: Data not available";
        assertTrue(testStringBlank.equals(testStringBlank));



    }
}
