package ru.job4j.profession;

/**.
 *
 */
class Profession {
    /**.
     *
     */
    private String name;
    /**.
     *
     */
    private String specialisation;
    /**.
     *
     */
    private String level;
    /**.
     *
     */
    private String almamater;
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     */
    Profession(String name, String specialisation, String level) {
        this.name = name;
        this.specialisation = specialisation;
        this.level = level;
    }
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     * @param almamater String
     */
     Profession(String name, String specialisation, String level, String almamater) {
        this.name = name;
        this.specialisation = specialisation;
        this.level = level;
        this.almamater = almamater;
    }

    /**.
     *
     * @return String
     */
    String getName() {
        return name;
    }

    /**.
     *
     * @return String
     */
    String getSpecialisation() {
        return specialisation;
    }

    /**.
     *
     * @return String
     */
    String getLevel() {
        return  level;
    }

    /**.
     *
     * @return String
     */
    String getAlmamater() {
        return almamater;
    }
}

/**.
 *
 */
class Task { }
/**.
 *
 */
class Student extends Profession {
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     */
    Student(String name, String specialisation, String level) {
        super(name, specialisation, level);
    }
}

/**.
 *
 */
class Pacient extends Profession {
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     */
    Pacient(String name, String specialisation, String level) {
        super(name, specialisation, level);
    }
}

/**.
 *
 */
class Visitor extends Profession {
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     */
    Visitor(String name, String specialisation, String level) {
        super(name, specialisation, level);
    }
}

/**.
 *
 */
class Teacher extends Profession {
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     */
    Teacher(String name, String specialisation, String level) {
        super(name, specialisation, level);
    }
    /**.
     *
     * @param student Student
     * @return int
     */
    int learn(Student student) {
        return 0;
    }
    /**.
     *
     * @param student Student
     * @return int
     */
    int estimate(Student student) {
        return 0;
    }
    /**.
     *
     * @param student Student
     * @return int
     */
    int settask(Student student) {
        return 0;
    }
    /**.
     *
     * @param student Student
     * @return int
     */
    int exams(Student student) {
        return 0;
    }
}

/**.
 *
 */
class Engeneer extends Profession {
    /**.
     *
     */
    private String gender;
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     * @param almamater String
     * @param gender String
     */
    Engeneer(String name, String specialisation, String level, String almamater, String gender) {
        super(name, specialisation, level, almamater);
        this.gender = gender;
    }
    /**.
     *
     * @param t Task
     * @return int
     */
    public int fix(Task t) {
        return 0;
    }
    /**.
     *
     * @param t Task
     * @return int
     */
    public int report(Task t) {
        return 0;
    }
}

/**.
 *
 */
class Diagnose {
    /**.
     *
     */
    private String description;

    /**.
     *
     * @param pacient Pacient
     * @param diagnose String
     */
    Diagnose(Pacient pacient, String diagnose) {
        this.description = diagnose;
    }

    /**.
     *
     * @return String
     */
    String info() {
        return description;
    }
}
/**.
 *
 */
class Doctor extends Profession {
    /**.
     *
     */
    private String license;
    /**.
     *
     */
    private boolean practicises;
    /**.
     *
     * @param name String
     * @param specialisation String
     * @param level String
     * @param almamater String
     * @param license String
     * @param practicises String
     */
    Doctor(String name, String specialisation, String level, String almamater, String license, boolean practicises) {
        super(name, specialisation, level, almamater);
        this.license = license;
        this.practicises = practicises;
    }

    /**.
     *
     * @param pacient Pacient
     * @return String
     */
    public String heal(Pacient pacient) {
        return "Doctor " + getName() + " heals " + pacient.getName();
    }

    /**.
     *
     * @param pacient Pacient
     * @param description String
     * @return Diagnose
     */
    public Diagnose heal(Pacient pacient, String description) {
        description = String.format("Доктор %s лечит %s от %s", this.getName(), pacient.getName(), description);
        Diagnose d = new Diagnose(pacient, description);
        return d;
    }

    /**.
     *
     * @param t Task
     * @return int
     */
    public int report(Task t) {
        return 0;
    }
    /**.
     *
     * @param v Visitor
     * @return int
     */
    public int consult(Visitor v) {
        return 0;
    }
}