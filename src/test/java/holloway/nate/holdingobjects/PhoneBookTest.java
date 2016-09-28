package holloway.nate.holdingobjects;

import org.junit.Assert;
import org.junit.Test;

import java.util.List;

/**
 * Created by nathanielholloway on 9/28/16.
 * This class tests the phonebook model.
 */
public class PhoneBookTest {

    @Test
    public void addTest(){
        PhoneBook phoneBook = new PhoneBook();
        boolean actualValue = phoneBook.add("Nate Holloway", "302-302-3023");
        Assert.assertTrue(actualValue);
    }

    @Test
    public void removeTest(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nate Holloway", "302-302-3023");
        boolean actualValue = phoneBook.remove("Nate Holloway");
        Assert.assertTrue(actualValue);

    }

    @Test
    public void lookupTest(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nate Holloway", "302-302-3023");
        phoneBook.add("Jaimir Holloway", "302-345-6788");
        List<String> actualValue = phoneBook.lookup("Jaimir Holloway");
        Assert.assertNotNull("302-345-6788",actualValue);

    }

    @Test
    public void reverseLookupTest(){
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nate Holloway", "302-302-3023");
        phoneBook.add("Jaimir Holloway", "302-345-6788");
        String actualValue = phoneBook.reverseLookup("302-302-3023");
        Assert.assertSame("Nate Holloway", actualValue);
    }
}
