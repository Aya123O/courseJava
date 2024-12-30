import javax.swing.*;
import java.awt.*;
import java.util.Date;

public class DateTimeApp extends JFrame implements Runnable {
    private Thread th;
    private JLabel timeLabel = new JLabel();

    public DateTimeApp() {
        this.setTitle("Date & Time Frame Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


        timeLabel.setHorizontalAlignment(JLabel.CENTER);
        timeLabel.setText(new Date().toString());
        this.add(timeLabel, BorderLayout.CENTER);


        th = new Thread(this);
        th.start();
    }

    public void run() {
        try {
            while (true) {

                timeLabel.setText(new Date().toString());
                Thread.sleep(1000);
            }
        } catch (InterruptedException e) {

            System.err.println("Thread interrupted: " + e.getMessage());
        }
    }
}
