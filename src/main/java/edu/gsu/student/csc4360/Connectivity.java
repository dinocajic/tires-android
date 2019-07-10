package edu.gsu.student.csc4360;

public class Connectivity {

    public static boolean isOnline() {
        try {
            String command = "ping -c 1 google.com";
            return (Runtime.getRuntime().exec(command).waitFor() == 0);

        } catch (Exception e) {
            return false;
        }
    }
}