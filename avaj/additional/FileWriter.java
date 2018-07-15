package avaj.additional;

import java.io.*;

public class FileWriter {
    private static PrintStream out;
    public static void Log(String logString) {        
        try {
            if (out == null) {
                out = new PrintStream(new FileOutputStream(new File("simulation.txt")));
            }
        }
        catch (Exception err) {
            System.out.println("Can't create output file.");
            System.out.println("Output: " + logString);
        }
        out.print(logString);
        out.print(System.getProperty("line.separator"));
    }
    public static void CloseLogFile() {
        if (out != null) {
            out.close();
        }
    }
}