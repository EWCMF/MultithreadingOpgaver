package Exercise1;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;

public class Exercise1 extends Application {
    static TextArea textArea;

    @Override
    public void start(Stage stage) throws Exception {
        textArea = new TextArea();
        // Uden denne laves der ikke linjeskift.
        textArea.setWrapText(true);
        Scene scene = new Scene(textArea, 300, 200);
        stage.setScene(scene);
        stage.show();

        // Create tasks
        PrintChar printA = new PrintChar('a', 100);
        PrintChar printB = new PrintChar('b', 100);
        PrintNum print100 = new PrintNum(100);

        // Create threads
        Thread thread1 = new Thread(printA);
        Thread thread2 = new Thread(printB);
        Thread thread3 = new Thread(print100);

        // Start threads
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public static void main(String[] args) {
        Application.launch(args);
    }

    // Metode lavet til at opdater textArea. For at gøre det nemmere er både metoden og variablen statiske.
    public static void updateTextArea(String text) {
        textArea.appendText(text);
    }
}

// Taget fra Liang bogen.
// The task for printing a specified character in specified times
class PrintChar implements Runnable {
    private char charToPrint; // The character to print
    private int times; // The times to repeat

    /** Construct a task with specified character and number of
     *  times to print the character
     */
    public PrintChar(char c, int t) {
        charToPrint = c;
        times = t;
    }

    @Override /** Override the run() method to tell the system
     *  what the task to perform
     */
    public void run() {
        for (int i = 0; i < times; i++) {
            // Platform.runLater er nødvendig da der kommer fejl uden.
            // Kun tråden med JavaFX må opdaterer JavaFX ting og dette kan Platform klassen faciliterer.
            Platform.runLater(() -> Exercise1.updateTextArea("" + charToPrint));
        }
    }
}

// Taget fra Liang bogen.
// The task class for printing number from 1 to n for a given n
class PrintNum implements Runnable {
    private int lastNum;

    /** Construct a task for printing 1, 2, ... i */
    public PrintNum(int n) {
        lastNum = n;
    }

    @Override /** Tell the thread how to run */
    public void run() {
        for (int i = 1; i <= lastNum; i++) {
            int finalI = i;
            Platform.runLater(() -> Exercise1.updateTextArea("" + finalI));
        }
    }
}
