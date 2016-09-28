package holloway.nate.holdingobjects;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by nathanielholloway on 9/28/16.
 * This class models the phonebook.
 */
public class PhoneBook {
    String name;
    List<String> phoneNumbers;

    private HashMap<String, List<String>> phoneBook;

    public PhoneBook(){
        phoneBook = new HashMap<String, List<String>>();
    }

    public boolean add(String name, String number){
        if(!phoneBook.containsKey(name)){
            phoneNumbers = new ArrayList<String>();
            phoneBook.put(name,phoneNumbers);
        }
        return phoneNumbers.add(number);

    }

    public boolean remove(String name){
        boolean returnedString = false;
         if(phoneBook.remove(name) != null){
             returnedString = true;
         }
         return returnedString;
    }

    public boolean remove(String name, String number){
        boolean returnedString = false;
        if(phoneBook.containsKey(name)) {
            returnedString = phoneNumbers.remove(number);
        }

        return returnedString;
    }

    public void listAllNames(){
        System.out.println("Names are: ");
        for (Map.Entry<String, List<String>> phonebookEntry : phoneBook.entrySet()) {

            System.out.println(phonebookEntry.getKey() );
        }

    }

    public void listAllEntries(){

        System.out.println("Entries are: ");
        for (Map.Entry<String,List<String>> phonebookEntry : phoneBook.entrySet()) {

            System.out.println(phonebookEntry.getKey());
            for (String e:phonebookEntry.getValue()) {
                System.out.println(e);
            }
        }
    }

    public List<String> lookup(String name){
        return phoneBook.get(name);
    }

    public String reverseLookup(String value){
        for (Map.Entry<String,List<String>> phonebookEntry : phoneBook.entrySet()) {

            List<String >contactList = phonebookEntry.getValue();
            for (String e: contactList) {
                if (e.equals(value)){
                    return "This person is "+phonebookEntry.getKey();
            }
            }
        }
        return null;

    }

    public static void main(String[] args) {
        PhoneBook phoneBook = new PhoneBook();
        phoneBook.add("Nate Holloway", "302-302-3023");
        phoneBook.add("Jaimir Holloway", "302-345-6788");
        phoneBook.add("Jaimir Holloway", "302-555-6788");

        System.out.println("List all names");
        phoneBook.listAllNames();
        System.out.println();

        System.out.println("List all entries");
        phoneBook.listAllEntries();
        System.out.println();

        System.out.println("Lookup Jaimir "+phoneBook.lookup("Jaimir Holloway"));
        System.out.println("reverse lookup Jaimir "+ phoneBook.reverseLookup("302-555-6788"));
        System.out.println("No one "+phoneBook.reverseLookup("456-345-7889"));

    }
}
