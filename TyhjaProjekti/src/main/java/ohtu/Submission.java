package ohtu;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Submission {

    private String student_number;
    private int week;
    private int hours;
    private boolean a1 = false;
    private boolean a2 = false;
    private boolean a3 = false;
    private boolean a4 = false;
    private boolean a5 = false;
    private boolean a6 = false;
    private boolean a7 = false;
    private boolean a8 = false;
    private boolean a9 = false;
    private boolean a10 = false;
    private boolean a11 = false;
    private boolean a12 = false;
    private String doneExercises = "";
    private int totalExercises = 0;

    public int getTotalExercises() {
        if (a1) {
            totalExercises++;
            doneExercises += "1 ";
            a1 = false;
        }
        if (a2) {
            totalExercises++;
            doneExercises += "2 ";
            a2 = false;
        }
        if (a3) {
            totalExercises++;
            doneExercises += "3 ";
            a3 = false;
        }
        if (a4) {
            totalExercises++;
            doneExercises += "4 ";
            a4 = false;
        }
        if (a5) {
            totalExercises++;
            doneExercises += "5 ";
            a5 = false;
        }
        if (a6) {
            totalExercises++;
            doneExercises += "6 ";
            a6 = false;
        }
        if (a7) {
            totalExercises++;
            doneExercises += "7 ";
            a7 = false;
        }
        if (a8) {
            totalExercises++;
            doneExercises += "8 ";
            a8 = false;
        }
        if (a9) {
            totalExercises++;
            doneExercises += "9 ";
            a9 = false;
        }
        if (a10) {
            totalExercises++;
            doneExercises += "10 ";
            a10 = false;
        }
        if (a11) {
            totalExercises++;
            doneExercises += "11 ";
            a11 = false;
        }
        if (a12) {
            totalExercises++;
            doneExercises += "12 ";
            a12 = false;
        }

        return totalExercises;
    }

    public String getStudent_number() {
        return student_number;
    }

    public void setStudent_number(String student_number) {
        this.student_number = student_number;
    }

    @Override
    public String toString() {
        return "viikko " + week + ": tehtyjä tehtäviä yhteensä: " + getTotalExercises() + ", aikaa kului "
                + hours + " tuntia, tehdyt tehtävät:" + doneExercises;
    }

    public int getWeek() {
        return week;
    }

    public void setWeek(int week) {
        this.week = week;
    }

    public int getHours() {
        return hours;
    }

    public void setHours(int hours) {
        this.hours = hours;
    }

    public Boolean isA1() {
        return a1;
    }

    public void setA1(Boolean a1) {
        this.a1 = a1;
        System.out.println(a1);
    }

    public boolean isA2() {
        return a2;
    }

    public void setA2(boolean a2) {
        this.a2 = a2;
    }

    public boolean isA3() {
        return a3;
    }

    public void setA3(boolean a3) {
        this.a3 = a3;
    }

    public boolean isA4() {
        return a4;
    }

    public void setA4(boolean a4) {
        this.a4 = a4;
    }

    public boolean isA5() {
        return a5;
    }

    public void setA5(boolean a5) {
        this.a5 = a5;
    }

    public boolean isA6() {
        return a6;
    }

    public void setA6(boolean a6) {
        this.a6 = a6;
    }

    public boolean isA7() {
        return a7;
    }

    public void setA7(boolean a7) {
        this.a7 = a7;
    }

    public boolean isA8() {
        return a8;
    }

    public void setA8(boolean a8) {
        this.a8 = a8;
    }

    public boolean isA9() {
        return a9;
    }

    public void setA9(boolean a9) {
        this.a9 = a9;
    }

    public boolean isA10() {
        return a10;
    }

    public void setA10(boolean a10) {
        this.a10 = a10;
    }

    public boolean isA11() {
        return a11;
    }

    public void setA11(boolean a11) {
        this.a11 = a11;
    }

    public boolean isA12() {
        return a12;
    }

    public void setA12(boolean a12) {
        this.a12 = a12;
    }

}
