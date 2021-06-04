package org.launchcode.techjobs_oo.Tests;

import org.junit.Before;
import org.junit.Test;
import org.launchcode.techjobs_oo.*;

import static org.junit.Assert.*;

public class JobTest {
    private Job job1, job2, job3, job4, job5;

    @Before
    public void createJobObject(){
        job1 = new Job();
        job2 = new Job();
        job3 = new Job("Product tester", new Employer("ACME"), new Location("Desert"), new PositionType("Quality control"), new CoreCompetency("Persistence"));
        job4 = new Job( "", new Employer(""), new Location(""), new PositionType(""), new CoreCompetency(""));
        job5 = new Job("Product tester", new Employer(""), new Location("Desert"), new PositionType(""), new CoreCompetency("Persistence"));
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

    // Testing that toString starts and ends with a new line
    // Testing that toString contains correct labels and data**
    // Testing that toString handles an empty field
    @Test
    public void testJobToString(){
        String testString = "\n" + "ID: " + job3.getId() + "\n" + "Name: " + job3.getName() + "\n" + "Employer: " + job3.getEmployer() +
                "\n" + "Location: " + job3.getLocation() + "\n" + "Position Type: " + job3.getPositionType() + "\n" + "Core Competency: " + job3.getCoreCompetency() + "\n";
        assertEquals(testString, job3.toString());
    }

    @Test
    public void testHandlesEmptyField(){
        String testStringBlank = "\n" + "ID: " + job5.getId() + "\n" + "Name: " + job5.getName() + "\n" + "Employer: Data not available" +
                "\n" + "Location: " + job5.getLocation() + "\n" + "Position Type: Data not available"  + "\n" + "Core Competency: " + job5.getCoreCompetency() + "\n";
        assertEquals(testStringBlank, job5.toString());

        System.out.println(job5.getLocation());
    }
    @Test
    public void stringStartsAndEndsWithNewLine(){
        char newLine = job5.toString().charAt(0);
        char newLine2 = job5.toString().charAt(job5.toString().length() - 1);
        assertEquals(newLine, newLine2);
    }
}
