public class Task_01 {
    public static void main(String[] args) {
        Student student1 = new Student(1,"firstname","secondname","fathersname","20.05.1987",
                                         "Burgerburg,Meat str.,apt.2","+3(24)8-800-555-3535",
                                         "MAT",2,44);

        Student student2 = new Student(1,"firstname","secondname","fathersname","20.05.1987",
                                             "Burgerburg,Meat str.,apt.2","+3(24)8-800-555-3535",
                                              "Philology",2,44);

        Student student3 = new Student(1,"firstname","secondname","fathersname","20.05.1987",
                                             "Burgerburg,Meat str.,apt.2","+3(24)8-800-555-3535",
                                              "MAT",2,44);
        student3.setFaculty("Biology");

        Student student4 = new Student(1,"firstname","secondname","fathersname","20.05.1987",
                                             "Burgerburg,Meat str.,apt.2","+3(24)8-800-555-3535",
                                              "MAT",2,44);
        student4.setName("Spork");

        Student[] students = new Student[4];
        students[0] = student1;
        students[1] = student2;
        students[2] = student3;
        students[3] = student4;
        for (Student student: students){
            if (student.getFaculty().equals("MAT")){
                System.out.println(student.getName());
                System.out.println(student.getSurname());
                System.out.println(student.getGroupNumber());
            }
        }
    }
}

class Student{
    private int id;
    private String surname;
    private String name;
    private String patronymic;
    private String birthDate;
    private String address;
    private String phoneNumber;
    private String faculty;
    private int course;
    private int groupNumber;

    public Student(){}

    public Student(int id, String surname, String name, String patronymic,
                   String birthDate, String address, String phoneNumber,
                   String faculty, int course, int groupNumber) {
        this.id = id;
        this.surname = surname;
        this.name = name;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.phoneNumber = phoneNumber;
        this.faculty = faculty;
        this.course = course;
        this.groupNumber = groupNumber;
    }

    public int getId() {
        return id;
    }

    public String getSurname() {
        return surname;
    }

    public String getName() {
        return name;
    }

    public String getPatronymic() {
        return patronymic;
    }

    public String getBirthDate() {
        return birthDate;
    }

    public String getAddress() {
        return address;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public String getFaculty() {
        return faculty;
    }

    public int getCourse() {
        return course;
    }

    public int getGroupNumber() {
        return groupNumber;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPantronymic(String patronymic) {
        this.patronymic = patronymic;
    }

    public void setAdress(String address) {
        this.address = address;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }

    public void setCourse(int course) {
        this.course = course;
    }

    public void setGroupNumber(int groupNumber) {
        this.groupNumber = groupNumber;
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", surname='" + surname + '\'' +
                ", name='" + name + '\'' +
                ", patronymic='" + patronymic + '\'' +
                ", birthDate='" + birthDate + '\'' +
                ", address='" + address + '\'' +
                ", phoneNumber='" + phoneNumber + '\'' +
                ", faculty='" + faculty + '\'' +
                ", course=" + course +
                ", groupNumber=" + groupNumber +
                '}';
    }
}

