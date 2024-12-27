import java.util.*;

class Student {
    int id;
    String name;
    String course;

    public Student(int id, String name, String course) {
        this.id = id;
        this.name = name;
        this.course = course;
    }

    public String getName() {
        return name;
    }

    public int getId() {
        return id;
    }

    public String getCourse() {
        return course;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCourse(String course) {
        this.course = course;
    }

    public String toString() {
        return id + " " + name + " " + course;
    }

}

class Management {
    List<Student> li = new ArrayList<Student>();

    public void addStudent(int id, String name, String course ) 
    {
        Student s = new Student(id,name,course);
        li.add(s);
        System.out.println("Student added Succesfully");
    }

    public void displayStudent(int id) {
        boolean found = false;
        for (Student student : li) {
            if (student.getId() == id) {
                System.out.println("ID: " + student.getId() + ", Name: " + student.getName() + ", Course: " + student.getCourse());
                found = true;
                break;
            }
        }
        if (!found) {
            System.out.println("Student with ID " + id + " not found.");
        }
    }


    public void deleteStudent(int id) {
        li.removeIf(s -> s.getId() == id);

    }

    public void updateStudent(int id, String newName, String newCourse) {
        for (Student student : li) {
            if (student.getId() == id) {
                student.setName(newName);
                student.setCourse(newCourse);
            }
        }
    }

}

public class Info {
    public static void main(String[] args) {
        
        Scanner sc = new Scanner(System.in);
        Management mg = new Management();
        while(true){
        System.out.println("----WELCOME TO STUDENT MANAGEMENT SYSTEM----");
        System.out.println("ENTER 1 : TO CREATE NEW STUDENT"+'\n'+"ENTER 2 : TO UPDATE STUDENT DATA"+'\n'+"ENTER 3 : TO DELETE STUDENT DATA"+'\n'+"ENTER 4 : TO DISPLAY STUDENT DATA");
        int input = sc.nextInt();

        switch (input) {
            case 1:
                System.out.println("Enter Student ID:");
                int newId = sc.nextInt();
                sc.nextLine(); 
                System.out.println("Enter Student Name:");
                String newName = sc.nextLine();
                System.out.println("Enter Student Course:");
                String newCourse = sc.nextLine();
                mg.addStudent(newId, newName, newCourse);
                break;

            case 2:
                System.out.println("Enter the ID of the student to update:");
                int updateId = sc.nextInt();
                sc.nextLine(); // Consume newline
                System.out.println("Enter the new name:");
                String updateName = sc.nextLine();
                System.out.println("Enter the new course:");
                String updateCourse = sc.nextLine();
                mg.updateStudent(updateId, updateName, updateCourse);
                break;

            case 3:
                System.out.println("Enter the ID of the student to delete:");
                int deleteId = sc.nextInt();
                mg.deleteStudent(deleteId);
                break;

            case 4:
                System.out.println("Enter the ID of the student to display:");
                int displayId = sc.nextInt();
                mg.displayStudent(displayId);
                break;

            case 5:
                System.out.println("PROGRAM IS TERMINATED");
                return;

            default:
                System.out.println("Invalid input. Please try again.");
        }
    }
}

}