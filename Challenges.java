import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.net.URI;


public class Challenges implements ActionListener{
    private JFrame frame;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JButton TicTacToeButton;
    private JButton TTTCompuButton;
    private JButton TicTacToeRulesButton;
    private JButton Con4Button;
    private JButton Con4RulesButton;
    private JButton ComputerButton;
    private JButton exitButton;
    private JLabel gameText;
    private JLabel TicTacToeText;
    private JLabel TicTacToeRulesText;
    private JLabel Con4Text;
    private JLabel ComputerText;
    private JLabel Con4RulesText;
    private JLabel exitText;
    private JLabel TTTCompuText;
    private JLabel gameTTTText;
    private JLabel gameC4Text;


    public static void main(String[] args) {
        Challenges Chl = new Challenges();
    }


    public Challenges(){


        frame = new JFrame("Challenges");
        frame.setSize(1100, 720);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout());


        topPanel = new JPanel();
        topPanel.setBackground(Color.GREEN);
        topPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 10, 10));
        topPanel.setPreferredSize(new Dimension(1100, 130));
        frame.add(topPanel, BorderLayout.NORTH);


        // Tic-Tac-Toe and Connect-4 sections side by side so both are always visible
        centerPanel = new JPanel(new GridLayout(1, 2, 30, 0));
        centerPanel.setBorder(BorderFactory.createEmptyBorder(30, 30, 30, 30));
        centerPanel.setBackground(Color.CYAN);
        JPanel leftPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        leftPanel.setBackground(Color.pink);
        centerPanel.add(leftPanel);
        JPanel rightPanel = new JPanel(new FlowLayout(FlowLayout.CENTER, 25, 25));
        rightPanel.setBackground(Color.ORANGE);
        centerPanel.add(rightPanel);
        frame.add(centerPanel);


        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.RED);
        bottomPanel.setLayout(new FlowLayout(FlowLayout.CENTER, 20, 20));
        bottomPanel.setPreferredSize(new Dimension(1100, 80));
        frame.add(bottomPanel, BorderLayout.SOUTH);


        gameText = new JLabel();
        gameText.setText("Challenges");
        gameText.setFont(new Font("Ink Free", Font.PLAIN, 85));
        gameText.setHorizontalAlignment(SwingConstants.CENTER);
        gameText.setVerticalAlignment(SwingConstants.CENTER);
        topPanel.add(gameText, BorderLayout.CENTER);


        gameTTTText = new JLabel();
        gameTTTText.setText("Tic-Tac-Toe Challenge");
        gameTTTText.setFont(new Font("Ink Free", Font.PLAIN, 42));
        gameTTTText.setHorizontalAlignment(SwingConstants.CENTER);
        gameTTTText.setVerticalAlignment(SwingConstants.CENTER);
        leftPanel.add(gameTTTText, BorderLayout.CENTER);


        TicTacToeButton = new JButton();
        TicTacToeButton.setBackground(new Color(187, 217, 255));
        TicTacToeButton.setFont(new Font("MV Boli", Font.BOLD, 40));
        TicTacToeButton.setFocusable(true);
        TicTacToeButton.addActionListener(this);
        TicTacToeButton.setActionCommand("Tic-Tac-Toe Challenge Friend");
        leftPanel.add(TicTacToeButton);
        TicTacToeText = new JLabel();
        TicTacToeText.setText("Click to Challenge Friend");
        TicTacToeText.setFont(new Font("Ink Free", Font.PLAIN, 30));
        TicTacToeButton.add(TicTacToeText);


        TTTCompuButton = new JButton();
        TTTCompuButton.setBackground(new Color(187, 217, 255));
        TTTCompuButton.setFont(new Font("MV Boli", Font.BOLD, 40));
        TTTCompuButton.setFocusable(true);
        TTTCompuButton.addActionListener(this);
        TTTCompuButton.setActionCommand("Tic-Tac-Toe Challenge Computer");
        leftPanel.add(TTTCompuButton);
        TTTCompuText = new JLabel();
        TTTCompuText.setText("Click to Challenge Computer");
        TTTCompuText.setFont(new Font("Ink Free", Font.PLAIN, 30));
        TTTCompuButton.add(TTTCompuText);


        gameC4Text = new JLabel();
        gameC4Text.setText("Connect-4 Challenge");
        gameC4Text.setFont(new Font("Ink Free", Font.PLAIN, 42));
        gameC4Text.setHorizontalAlignment(SwingConstants.CENTER);
        gameC4Text.setVerticalAlignment(SwingConstants.CENTER);
        rightPanel.add(gameC4Text, BorderLayout.CENTER);


        Con4Button = new JButton();
        Con4Button.setBackground(new Color(187, 217, 255));
        Con4Button.setFont(new Font("MV Boli", Font.BOLD, 40));
        Con4Button.setFocusable(true);
        Con4Button.addActionListener(this);
        Con4Button.setActionCommand("Connect-4 Challenge Friend");
        rightPanel.add(Con4Button);
        Con4Text = new JLabel();
        Con4Text.setText("Click to Challenge Friend");
        Con4Text.setFont(new Font("Ink Free", Font.PLAIN, 30));
        Con4Button.add(Con4Text);


        ComputerButton = new JButton();
        ComputerButton.setBackground(new Color(187, 217, 255));
        ComputerButton.setFont(new Font("MV Boli", Font.BOLD, 40));
        ComputerButton.setFocusable(true);
        ComputerButton.addActionListener(this);
        ComputerButton.setActionCommand("Connect-4 Challenge Computer");
        rightPanel.add(ComputerButton);
        ComputerText = new JLabel();
        ComputerText.setText("Click to Challenge Computer");
        ComputerText.setFont(new Font("Ink Free", Font.PLAIN, 30));
        ComputerButton.add(ComputerText);


        TicTacToeRulesButton = new JButton();
        TicTacToeRulesButton.setBackground(new Color(0, 255, 0));
        TicTacToeRulesButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        TicTacToeRulesButton.setFocusable(true);
        TicTacToeRulesButton.addActionListener(this);
        TicTacToeRulesButton.setActionCommand("Tic-Tac-Toe Info");
        leftPanel.add(TicTacToeRulesButton);
        TicTacToeRulesText = new JLabel();
        TicTacToeRulesText.setText("Click for Tic-Tac-Toe Info");
        TicTacToeRulesText.setFont(new Font("Ink Free", Font.PLAIN, 24));
        TicTacToeRulesButton.add(TicTacToeRulesText);


        Con4RulesButton = new JButton();
        Con4RulesButton.setBackground(new Color(0,255,0));
        Con4RulesButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        Con4RulesButton.setFocusable(true);
        Con4RulesButton.addActionListener(this);
        Con4RulesButton.setActionCommand("Connect-4 Info");
        rightPanel.add(Con4RulesButton);
        Con4RulesText = new JLabel();
        Con4RulesText.setText("Click for Connect-4 Info");
        Con4RulesText.setFont(new Font("Ink Free", Font.PLAIN, 24));
        Con4RulesButton.add(Con4RulesText);


        exitButton = new JButton();
        exitButton.setBackground(new Color(255, 255, 0));
        exitButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        exitButton.setFocusable(true);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Exit");
        bottomPanel.add(exitButton);
        exitText = new JLabel();
        exitText.setText("Click to Exit from Challenges");
        exitText.setFont(new Font("Ink Free", Font.PLAIN, 30));
        exitButton.add(exitText);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){


        if(e.getActionCommand().equals("Exit")){
            System.out.println("Exit button was pressed. You are exiting...");
            System.exit(0);
        }


        if(e.getActionCommand().equals("Connect-4 Challenge Friend")){
            Connect4 connect = new Connect4();
            connect.Connect4();
            frame.dispose();
        }


        if(e.getActionCommand().equals("Connect-4 Challenge Computer")){
            Connect4Comp connectComp = new Connect4Comp();
            connectComp.Connect4Comp();
            frame.dispose();
        }


        if(e.getActionCommand().equals("Tic-Tac-Toe Challenge Friend")){
            GUITTT TicTacToe = new GUITTT();
            TicTacToe.GUITTT();
            frame.dispose();
        }


        if(e.getActionCommand().equals("Tic-Tac-Toe Challenge Computer")){
            GUITTTComp TicTacToeComp = new GUITTTComp();
            TicTacToeComp.GUITTTComp();
            frame.dispose();
        }


        if(e.getActionCommand().equals("Connect-4 Info")){
            try {
                Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Connect_Four"));
            }
            catch(Exception excptn){
                excptn.printStackTrace();
            }
        }


        if(e.getActionCommand().equals("Tic-Tac-Toe Info")){
            try {
                Desktop.getDesktop().browse(new URI("https://en.wikipedia.org/wiki/Tic-tac-toe"));
            }
            catch(Exception excptn){
                excptn.printStackTrace();
            }
        }
    }
}