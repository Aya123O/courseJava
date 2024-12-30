import javax.swing.*;
import java.awt.*;

public class MarqueeApp extends JFrame implements Runnable {
    private Thread th;
    private JLabel marqueeLabel;
    private String text = "Hello World";
    private int position;
    private int direction = 1;  // 1 for left to right, -1 for right to left
    private final int SPEED = 10;  // Speed of movement

    public MarqueeApp() {
        this.setTitle("Marquee String Application");
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(600, 100);

        marqueeLabel = new JLabel(text);
        marqueeLabel.setHorizontalAlignment(JLabel.LEFT);
        this.add(marqueeLabel, BorderLayout.CENTER);

        th = new Thread(this);
        th.start();
    }

    @Override
    public void run() {
        while (true) {
            if (direction == 1) {  // Moving from left to right
                position++;
                if (position > getWidth()) {  // If the text moves out of the screen
                    position = -marqueeLabel.getWidth();  // Reset position to start from the left again
                }
            } else {  // Moving from right to left
                position--;
                if (position < -marqueeLabel.getWidth()) {  // If the text moves out of the screen
                    position = getWidth();  // Reset position to start from the right again
                }
            }

            // Update the label text with the appropriate number of leading spaces
            final int currentPosition = Math.max(0, position);
            SwingUtilities.invokeLater(new Runnable() {
                @Override
                public void run() {
                    marqueeLabel.setText(" ".repeat(currentPosition) + text);  // Update label text with spaces
                }
            });

            // Repaint the frame
            repaint();

            try {
                Thread.sleep(SPEED);  // Control the speed of movement
            } catch (InterruptedException e) {
                System.err.println("Thread interrupted: " + e.getMessage());
            }
        }
    }

    public static void main(String[] args) {
        MarqueeApp app = new MarqueeApp();
        app.setVisible(true);
    }
}
