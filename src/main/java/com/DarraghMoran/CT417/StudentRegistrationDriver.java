package com.DarraghMoran.CT417;

import java.util.ArrayList;
import org.joda.time.LocalDate;

public class StudentRegistrationDriver
{
    public static void main(String args[])
    {
        //A new student is created here with the data provided in the constructor
        LocalDate dob = new LocalDate(1995, 1, 25);
        Student student1 = new Student("Darragh Moran", 21, dob, 13508087);

        LocalDate dob1 = new LocalDate(1998, 4, 21);
        Student student2 = new Student("Shane Moran", 18, dob1, 13598765);

        LocalDate dob2 = new LocalDate(1994, 7, 18);
        Student student3 = new Student("James Hurley", 22, dob2, 12345678);

        LocalDate dob3 = new LocalDate(1994, 1, 1);
        Student student4 = new Student("Paul Kelly", 22, dob3, 13245678);

        LocalDate dob4 = new LocalDate(1995, 6, 15);
        Student student5 = new Student("Ciaran Mcgreal", 21, dob4, 13480870);

        LocalDate dob5 =  new LocalDate(1995, 9, 20);
        Student student6 = new Student("Connor Duignan", 21, dob5, 13678948);


        //Modules are created here
        Module telecoms = new Module("Telecommunication Software Applications", "EE453");
        Module dsp = new Module("Digital Signal Processing", "EE445");
        Module system = new Module("System on a Chip", "EE451");
        Module real = new Module("Real-Time Systems", "CT420");
        Module soft = new Module("Software Engineering III", "CT417");
        Module machine = new Module("Machine Learning & Data Mining", "CT475");

        //ArrayList containing modules in Engineering created and the modules added to it
        ArrayList<Module> electronicEngineeringModules = new ArrayList<Module>();
        electronicEngineeringModules.add(telecoms);
        electronicEngineeringModules.add(dsp);
        electronicEngineeringModules.add(system);
        electronicEngineeringModules.add(soft);

        //ArrayList containing modules in Computer Science created and the modules added to it
        ArrayList<Module> computerModules = new ArrayList<Module>();
        computerModules.add(real);
        computerModules.add(soft);
        computerModules.add(machine);

        //The date for the start and end of the course is entered here using jodaTime
        LocalDate startDate = new LocalDate(2013, 7, 9);
        LocalDate endDate = new LocalDate(2016, 5, 31);

        //College courses are created here
        CourseProgramme electronicEngineering = new CourseProgramme("Electronic and Computer Engineering", startDate, endDate, electronicEngineeringModules);
        CourseProgramme computerScience = new CourseProgramme("Computer Science & Information Technology", startDate, endDate, computerModules);

        //Adds students to the electronic engineering course
        ArrayList<Student> electronicEngineeringStudents = new ArrayList<Student>();
        electronicEngineeringStudents.add(student1);
        electronicEngineeringStudents.add(student3);
        electronicEngineeringStudents.add(student5);

        //Adds students to the electronic engineering course
        ArrayList<Student> computerScienceStudents = new ArrayList<Student>();
        computerScienceStudents.add(student2);
        computerScienceStudents.add(student4);
        computerScienceStudents.add(student6);

        addStudents(electronicEngineering, electronicEngineeringModules, electronicEngineeringStudents);
        addStudents(computerScience, computerModules, computerScienceStudents);

        printStudents(electronicEngineeringStudents);
        printStudents(computerScienceStudents);

    }

    public static void printStudentDetails(Student student) {
        //print out student details
        System.out.println("**********************************************************************");
        System.out.println("Name: " + student.getName());
        System.out.println("Id: " + student.getId());
        System.out.println("Age: " + student.getAge());
        System.out.println("Date of Birth: " + student.getDob());
        System.out.println("Username: " + student.getUsername());
    }

    public static void addStudents(CourseProgramme course, ArrayList<Module> module, ArrayList<Student> students) {
        //Adds students to the modules
        for(Module modules : module) {
            modules.addStudents(students);
        }
        //Adds a student to a course
        for(Student student : students) {
            student.add(course);
        }
    }

    public static void printStudents(ArrayList<Student> students) {
        for(Student student : students) {
            printStudentDetails(student);
            CourseProgramme course = student.getCourse();
            System.out.println("Course Programme: " + course.getCourseName());
            System.out.println("Modules: " + moduleNames(course.getModule()));
            System.out.println("Start Date: " + course.getStartDate());
            System.out.println("End Date: " + course.getEndDate());
        }
    }

    public static String moduleNames(ArrayList<Module> modules) {
        //This is the method to define what will be printed for modules
        String moduleChoice = "";
        for(Module module : modules) {
            moduleChoice += "(" + module.getId() + " - " + module.getModuleName() + ")";
        }
        return moduleChoice;
    }
}
