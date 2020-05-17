package com.haydikodlayalim.lombok;

public class LombokApplication {
    public static void main(String[] args) {
        System.out.println("Mesaj");
        Person p = new Person();
        p.setId(123L);
        p.setName("Test");

        Person person = Person.builder().name("Test Name").build();
        System.out.println(person);

        PersonWithoutLombok personWithoutLombok = new PersonWithoutLombok();


        PersonData personData = new PersonData();
        //personData.

        System.out.println(StringUtility.trim("value "));

        StringUtility.trimPerson(null);
        //StringUtility sf = new StringUtility();
    }
}
