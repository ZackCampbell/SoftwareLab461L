package utexas;

import java.io.Serializable;

public class ExamResult implements Serializable{
    private String idNumber;
    private String studentName;
    private String exam1Grade;
    private String exam2Grade;

    public ExamResult() {}
    public ExamResult(String id, String name, String ex1, String ex2) {
        this.idNumber = id;
        this.studentName = name;
        this.exam1Grade = ex1;
        this.exam2Grade = ex2;
    }

    public String getIdNumber() { return idNumber; }
    public String getExam1Grade() { return exam1Grade; }
    public String getStudentName() { return studentName; }
    public String getExam2Grade() { return exam2Grade; }

    public void setExam1Grade(String exam1Grade) { this.exam1Grade = exam1Grade; }
    public void setExam2Grade(String exam2Grade) { this.exam2Grade = exam2Grade; }
    public void setIdNumber(String idNumber) { this.idNumber = idNumber; }
    public void setStudentName(String studentName) { this.studentName = studentName; }
}
