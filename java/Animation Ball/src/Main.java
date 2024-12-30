import javax.swing.JFrame;

public class Main {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Animation Ball");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(600, 600);

        AnimationBall marqueeLabel = new AnimationBall("X", AnimationBall.RIGHT_TO_LEFT, 10, 300);

        marqueeLabel.setBounds(0, 0, 600, 50);
        frame.add(marqueeLabel);

        frame.setVisible(true);
    }
}
