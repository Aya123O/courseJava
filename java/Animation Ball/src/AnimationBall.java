import java.awt.Graphics;
import java.util.Random;
import javax.swing.JLabel;

public class AnimationBall extends JLabel {
    public static final int LEFT_TO_RIGHT = 1;
    public static final int RIGHT_TO_LEFT = 2;

    private int direction;
    private int speed;
    private int height;
    private int yPosition;

    public AnimationBall(String text, int direction, int speed, int height) {
        this.direction = direction;
        this.speed = speed;
        this.height = height;
        this.setText(text);


        Random random = new Random();
        this.yPosition = random.nextInt(height);
    }

    @Override
    protected void paintComponent(Graphics g) {
        int xPosition;
        long time = System.currentTimeMillis();


        if (direction == LEFT_TO_RIGHT) {
            xPosition = (int) ((time / speed) % (getWidth() * 2) - getWidth());
            yPosition= (int) ((time / speed) % (getHeight() * 2) - getHeight());
        } else {
            xPosition = (int) (getWidth() - (time / speed) % (getWidth() * 2));
            yPosition=  (int) (getHeight() - (time / speed) % (getHeight() * 2));

        }

        // Adjust the translation based on random Y position
        g.translate(xPosition, yPosition);
        super.paintComponent(g);

        // Continuous repaint to ensure animation
        repaint(5);
    }
}
