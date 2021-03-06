package dk.mercantec.javaii.tests;

import dk.mercantec.javaii.Contacts;
import dk.mercantec.javaii.External;
import dk.mercantec.javaii.Internal;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class ContactsTest {

    Contacts contacts;

    @Before
    public void setUp() {
        this.contacts = new Contacts();
    }

    @Test
    public void testAddInternalContact() {
        String name = "John Doe";
        String phone = "31337";
        String email = "john@doe.com";
        String department = "Holding";
        this.contacts.AddInternalContact(name, phone, email, department);

        assertEquals(name, this.contacts.getContacts().get(0).getName());
        assertEquals(phone, this.contacts.getContacts().get(0).getPhone());
        assertEquals(email, this.contacts.getContacts().get(0).getEmail());
        assertEquals(department, ((Internal) this.contacts.getContacts().get(0)).getDepartment());
    }

    @Test
    public void testAddExternalContact() {
        String name = "John Doe";
        String phone = "31337";
        String email = "john@doe.com";
        String company = "FBI";
        this.contacts.AddExternalContact(name, phone, email, company);

        assertEquals(name, this.contacts.getContacts().get(0).getName());
        assertEquals(phone, this.contacts.getContacts().get(0).getPhone());
        assertEquals(email, this.contacts.getContacts().get(0).getEmail());
        assertEquals(company, ((External)this.contacts.getContacts().get(0)).getCompany());
    }
}