import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class MyFrame extends JFrame {

    private JButton button;
    private MyPanel p1;
    Scanner scan;
    File file;
    private static final int WIDTH = 700;
    private static final int HEIGHT = 700;
    private static final int HEADER_HEIGHT = HEIGHT / 3;
    private static final int HEADER_WIDTH = WIDTH;
    private static final int BODY_HEIGHT = HEIGHT / 2;
    private static final int BTN_WIDTH = 210;
    private static final int BTN_HEIGHT = 70;
    private static final int BTN_Y = (HEADER_HEIGHT - BTN_HEIGHT) / 2;
    private static final int BTN_X = (HEADER_WIDTH - BTN_WIDTH) / 2;

    public MyFrame() {
        button = new JButton("Select File");
        button.addActionListener(e -> {
            // deletes all the p1's components
            p1.removeAll();
            if (e.getSource() == button) {
                JFileChooser fileChooser = new JFileChooser();
                //sets current directory
                fileChooser.setCurrentDirectory(new File("C://Users//"));
                //select file to open
                int response = fileChooser.showOpenDialog(null);
                if (response == JFileChooser.APPROVE_OPTION) {
                    file = new File(fileChooser.getSelectedFile().getAbsolutePath());
                }
            }
            try {
                scan = new Scanner(file, "UTF-8");
            } catch (FileNotFoundException | NullPointerException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            String textContent = "";
            while (scan.hasNextLine()) {
                textContent = textContent.concat(scan.nextLine() + "\n");
            }
            try {
                p1.addLabelsToPanel(file.getAbsolutePath());
            } catch (IOException e1) {
                // TODO Auto-generated catch block
                e1.printStackTrace();
            }
            // refreshes the p1 JPanel component
            p1.revalidate();
        });
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(MyFrame.WIDTH, MyFrame.HEIGHT);
        setLocationRelativeTo(null);
        setLayout(new BorderLayout());
        JPanel header = new JPanel();
        header.setPreferredSize(new Dimension(MyFrame.WIDTH, HEADER_HEIGHT));
        header.setLayout(null);
        header.setBackground(Color.gray);
        button.setBounds(BTN_X, BTN_Y, BTN_WIDTH, BTN_HEIGHT);
        button.setFont(new Font("Calibri", Font.PLAIN, 25));
        button.setFocusable(false);
        header.add(button);
        JLabel lb = new JLabel("Click to find out how many times the words appear in the text file. Ex.: word(number of times.)");
        lb.setFont(new Font("Arial", Font.PLAIN, 14));
        lb.setBounds(HEADER_WIDTH / 10, HEADER_HEIGHT - 60, HEADER_WIDTH, 25);
        header.add(lb);
        JPanel body = new JPanel();
        body.setPreferredSize(new Dimension(WIDTH, BODY_HEIGHT));
        body.setLayout(new BorderLayout());
        body.setBackground(Color.black);
        p1 = new MyPanel();
        p1.setLayout(new WrapLayout());
        p1.setBackground(Color.WHITE);
        JScrollPane scroll = new JScrollPane(p1);
        scroll.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_AS_NEEDED);
        scroll.getVerticalScrollBar().setUnitIncrement(16);
        scroll.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        body.add(scroll, BorderLayout.CENTER);
        add(header, BorderLayout.NORTH);
        add(body, BorderLayout.CENTER);
        setVisible(true);
    }
}
