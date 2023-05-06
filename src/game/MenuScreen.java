package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MenuScreen extends JFrame implements ActionListener {

    private final JPanel MenuScreen;
    private final JButton loadButton;
    private final JButton playButton;
    private final JButton howToPlayButton;
    private final JButton quitButton;
    private JPanel howToPlayScreen;
    private JLabel controls;
    private JButton goBack;

    public MenuScreen() {



        MenuScreen = new JPanel();
        MenuScreen.setLayout(new BoxLayout(MenuScreen, BoxLayout.Y_AXIS));
        setResizable(false);
        setLocationByPlatform(true);

        JLabel titleLabel = new JLabel("Mario Remix!");
        titleLabel.setFont(new Font("Algerian", Font.BOLD, 32));
        titleLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        MenuScreen.add(titleLabel);



        MenuScreen.add(Box.createVerticalStrut(10));



        playButton = new JButton("Play Game");
        playButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        playButton.setBackground(new Color(0, 200, 255));
        playButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        playButton.addActionListener(this);
        MenuScreen.add(playButton);


        MenuScreen.add(Box.createVerticalStrut(20));


        loadButton = new JButton("Load Game");
        loadButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        loadButton.setBackground(new Color(0, 255, 0));
        loadButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        loadButton.addActionListener(this);
        MenuScreen.add(loadButton);

        MenuScreen.add(Box.createVerticalStrut(20));


        howToPlayButton = new JButton("How to Play");
        howToPlayButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        howToPlayButton.setBackground(new Color(255, 100, 25));
        howToPlayButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        howToPlayButton.addActionListener(this);
        MenuScreen.add(howToPlayButton);


        MenuScreen.add(Box.createVerticalStrut(20));

        quitButton = new JButton("Quit Game");
        quitButton.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
        quitButton.setBackground(new Color(255, 0, 0));
        quitButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        quitButton.addActionListener(this);
        MenuScreen.add(quitButton);


        add(MenuScreen);

        // Sets frame properties
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setSize(800, 600);
        setLocationRelativeTo(null);
        setVisible(true);


    }


    @Override
    public void actionPerformed(ActionEvent e) {

        if (e.getSource() == playButton) {
            setVisible(false);
            new Game();
        }

        if (e.getSource() == quitButton) {
            System.exit(0);
        }

        if (e.getSource() == howToPlayButton) {
            howToPlayScreen = new JPanel();
            howToPlayScreen.setPreferredSize(new Dimension(800, 600));
            howToPlayScreen.setLayout(new BoxLayout(howToPlayScreen, BoxLayout.Y_AXIS));


            controls = new JLabel("To jump use W, UP Arrow or Space");
            controls.setAlignmentX(Component.CENTER_ALIGNMENT);
            controls.setFont(new Font("Arial", Font.BOLD, 25));
            howToPlayScreen.add(controls);

            controls = new JLabel("To go left use A or LEFT Arrow");
            controls.setAlignmentX(Component.CENTER_ALIGNMENT);
            controls.setFont(new Font("Arial", Font.BOLD, 25));
            howToPlayScreen.add(controls);

            controls = new JLabel("To go right use D or RIGHT Arrow");
            controls.setAlignmentX(Component.CENTER_ALIGNMENT);
            controls.setFont(new Font("Arial", Font.BOLD, 25));
            howToPlayScreen.add(controls);

            controls = new JLabel("To sprint hold SHIFT");
            controls.setAlignmentX(Component.CENTER_ALIGNMENT);
            controls.setFont(new Font("Arial", Font.BOLD, 25));
            howToPlayScreen.add(controls);

            goBack = new JButton("Go Back");
            goBack.setFont(new Font("Arial Rounded MT Bold", Font.BOLD, 18));
            goBack.setBackground(new Color(244, 194, 194));
            goBack.setAlignmentX(Component.CENTER_ALIGNMENT);
            goBack.addActionListener(this);
            howToPlayScreen.add(goBack);

            setContentPane(howToPlayScreen);
            pack();
            setVisible(true);


        } else if (e.getSource() == goBack) {
            howToPlayScreen.setVisible(false);
            setContentPane(MenuScreen);


        }
    }
}