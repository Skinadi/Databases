/**
 * Created by skinadi on 03.05.18.
 */
/**
 * Created by skinadi on 03.05.18.
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class SignUpPanel extends JPanel implements ActionListener{

    public static final int HEIGHT = 100;
    public static final int WIDTH = 300;
    private JButton greenButton;
    private JButton blueButton;
    private JButton redButton;

    MainFrame parent;
    public SignUpPanel(MainFrame parent) {
        this.parent=parent;
        greenButton = new JButton("Green");
        blueButton = new JButton("Blue");
        redButton = new JButton("Red");

        greenButton.addActionListener(this);
        blueButton.addActionListener(this);
        redButton.addActionListener(this);

        setLayout(new FlowLayout());
        setPreferredSize(new Dimension(WIDTH, HEIGHT));
        add(greenButton);
        add(blueButton);
        add(redButton);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        Object source = e.getSource();

        if(source == greenButton)
            setBackground(Color.YELLOW);

        else if(source == blueButton)
            setBackground(Color.BLUE);

        else if(source == redButton)
            setBackground(Color.RED);
    }
}
