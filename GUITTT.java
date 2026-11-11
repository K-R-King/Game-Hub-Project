import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class GUITTT implements ActionListener{
    private JFrame frame;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JButton[][] buttons;
    private JButton resetButton;
    private JLabel gameText;
    private JLabel resetText;
    private JButton exitButton;
    private JLabel exitText;
    private int X_win;
    private int O_win;


    private String[][] board = new String[3][3];
    boolean turn = false;
    int num_of_times = 9;
    boolean game_over = false;
    JLabel myText = new JLabel();
    String player;


    //  public static void main(String[] args) {
    //   GUITTT ttt = new GUITTT();
    //  }


    public void GUITTT(){


        System.out.println("Tic-Tac-Toe");
        player = "X";
        System.out.println("Turn of Player: " + player);
        myText.setText("Turn of Player: " + player);


        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = " - ";
                System.out.print(board[row][col]);
            }
            System.out.println();
        }


        frame = new JFrame("Tic-Tac-Toe - vs Friend");
        frame.setSize(800, 800);
        // Closing a game window goes back to the Challenges menu instead of quitting
        frame.setDefaultCloseOperation(JFrame.DO_NOTHING_ON_CLOSE);
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent we) {
                System.out.println("Window closed. Returning to Challenges page...");
                new Challenges();
                frame.dispose();
            }
        });
        frame.setLayout(new BorderLayout());


        topPanel = new JPanel();
        topPanel.setBackground(Color.GREEN);
        topPanel.setPreferredSize(new Dimension(800, 100));
        frame.add(topPanel, BorderLayout.NORTH);
        gameText = new JLabel();
        gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
        gameText.setFont(new Font("Ink Free", Font.PLAIN, 44));
        gameText.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.setLayout(new BorderLayout());
        topPanel.add(gameText, BorderLayout.CENTER);


        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(3,3));
        buttons = new JButton[3][3];
        for(int row = 0; row < buttons.length; row++){
            for(int col = 0; col < buttons[row].length; col++){
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground(new Color(187, 217, 255));
                buttons[row][col].setFont(new Font("MV Boli", Font.BOLD, 120));
                buttons[row][col].setFocusable(false);
                buttons[row][col].putClientProperty("rowthis", row);
                buttons[row][col].putClientProperty("colthis", col);
                buttons[row][col].addActionListener(this);
                buttons[row][col].setActionCommand("Play");
                centerPanel.add(buttons[row][col]);
            }
        }


        frame.add(centerPanel, BorderLayout.CENTER);


        bottomPanel = new JPanel();
        bottomPanel.setBackground(Color.RED);
        bottomPanel.setPreferredSize(new Dimension(800, 100));
        frame.add(bottomPanel, BorderLayout.SOUTH);
        resetButton = new JButton();
        resetButton.setBackground(new Color(187, 217, 255));
        resetButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        resetButton.setFocusable(true);
        resetButton.addActionListener(this);
        resetButton.setActionCommand("Reset");
        bottomPanel.add(resetButton);
        resetText = new JLabel();
        resetText.setText("Click to Reset");
        resetText.setFont(new Font("Ink Free", Font.PLAIN, 20));
        resetButton.add(resetText);


        exitButton = new JButton();
        exitButton.setBackground(new Color(187, 217, 255));
        exitButton.setFont(new Font("MV Boli", Font.BOLD, 30));
        exitButton.setFocusable(true);
        exitButton.addActionListener(this);
        exitButton.setActionCommand("Challenges");
        bottomPanel.add(exitButton);
        exitText = new JLabel();
        exitText.setText("Click to go to Challenges page");
        exitText.setFont(new Font("Ink Free", Font.PLAIN, 20));
        exitButton.add(exitText);


        myText.setFont(new Font("Ink Free", Font.PLAIN, 40));


        myText.setHorizontalAlignment(SwingConstants.CENTER);


        myText.setPreferredSize(new Dimension(780, 50));
        bottomPanel.add(myText);

        frame.setLocationRelativeTo(null);
        frame.setVisible(true);
    }


    public void actionPerformed(ActionEvent e){


        int row = 0;
        int col = 0;


        if(e.getActionCommand().equals("Challenges")){
            System.out.println("You are exiting to Challenges page...");
            Challenges Chl = new Challenges();
            frame.dispose();
        }
        else if(e.getActionCommand().equals("Reset")){
            System.out.println("Reset button was pressed. Game is Reset.");
            player = "X";
            System.out.println("Turn of Player: " + player);
            myText.setText("Turn of Player: " + player);


            for(row = 0; row < buttons.length; row++){
                for(col = 0; col < buttons[row].length; col++){
                    buttons[row][col].setText("");
                    buttons[row][col].setBackground(new Color(187, 217, 255));
                }
            }
            for (row = 0; row < board.length; row++) {
                for (col = 0; col < board[0].length; col++) {
                    board[row][col] = " - ";
                    System.out.print(board[row][col]);
                }
                System.out.println();
            }
            num_of_times = 9;
            game_over = false;
        }
        else if(e.getActionCommand().equals("Play") && game_over == false){


            int clickedRow = 0;
            int clickedCol = 0;
            JButton clickedButton = (JButton) e.getSource();
            clickedRow = (int) clickedButton.getClientProperty("rowthis");
            clickedCol = (int) clickedButton.getClientProperty("colthis");


            while (num_of_times >=0 ) {
                if (num_of_times == 0 || num_of_times == 2 || num_of_times == 4 || num_of_times == 6 || num_of_times == 8) {
                    turn = true;
                }
                else {
                    turn = false;
                }
                num_of_times = m_ValidityCheck(num_of_times, clickedRow, clickedCol);
                m_BoardPrint();
                if (num_of_times == 0) {
                    System.out.println("Game ends in a Tie!");
                    myText.setText("Game ends in a Tie!");
                    game_over = true;
                }
                break;
            }
        }
    }


    public int m_ValidityCheck(int num_of_times, int clickedRow, int clickedCol) {


        String player = "";
        String player1 = "";
        if (turn == true) {
            player = " O ";
            player1 = " X ";
            System.out.println("Turn of Player: " + player1);
            myText.setText("Turn of Player: " + player1);
        } else {
            player = " X ";
            player1 = " O ";
            System.out.println("Turn of Player: " + player1);
            myText.setText("Turn of Player: " + player1);
        }


        if (board[clickedRow][clickedCol] == " - ") {
            board[clickedRow][clickedCol] = player;
            buttons[clickedRow][clickedCol].setText(player);
            num_of_times--;
            System.out.println(num_of_times);
            m_WinnerCheck(board, player, clickedRow, clickedCol);
            if (game_over == true){
                num_of_times = -1;
                return num_of_times;
            }
            if (num_of_times == 0){
                return num_of_times;
            }
        }
        else {
            System.out.println("Spot already taken.");
            myText.setText("Spot already taken.");
        }
        return (num_of_times);
    }


    public void m_WinnerCheck(String arr[][], String getPlayer, int clickedRow, int clickedCol) {


        if (game_over == false){
            for (int row = 0; row < 3; row++) {
                if (arr[row][0] == getPlayer && arr[row][1] == getPlayer && arr[row][2] == getPlayer) {
                    m_BoardPrint();
                    System.out.println("Player " + getPlayer.trim() + " wins the game!");
                    myText.setText("Player " + getPlayer.trim() + " wins the game!");
                    game_over = true;
                    buttons[row][0].setBackground(Color.YELLOW);
                    buttons[row][1].setBackground(Color.YELLOW);
                    buttons[row][2].setBackground(Color.YELLOW);


                    if(getPlayer == " X "){
                        X_win++;
                        gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                    }
                    else if(getPlayer == " O "){
                        O_win++;
                        gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                    }
                }
            }
        }
        if(game_over == false){
            for (int col = 0; col < 3; col++) {
                if (arr[0][col] == getPlayer && arr[1][col] == getPlayer && arr[2][col] == getPlayer) {
                    m_BoardPrint();
                    System.out.println("Player " + getPlayer.trim() + " wins the game!");
                    myText.setText("Player " + getPlayer.trim() + " wins the game!");
                    game_over = true;
                    buttons[0][col].setBackground(Color.YELLOW);
                    buttons[1][col].setBackground(Color.YELLOW);
                    buttons[2][col].setBackground(Color.YELLOW);
                    if(getPlayer == " X "){
                        X_win++;
                        gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                    }
                    else if(getPlayer == " O "){
                        O_win++;
                        gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                    }
                }
            }
        }
        if(game_over == false){
            if (arr[0][0] == getPlayer && arr[1][1] == getPlayer && arr[2][2] == getPlayer) {
                m_BoardPrint();
                System.out.println("Player " + getPlayer.trim() + " wins the game!");
                myText.setText("Player " + getPlayer.trim() + " wins the game!");
                game_over = true;
                buttons[0][0].setBackground(Color.YELLOW);
                buttons[1][1].setBackground(Color.YELLOW);
                buttons[2][2].setBackground(Color.YELLOW);
                if(getPlayer == " X "){
                    X_win++;
                    gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                }
                else if(getPlayer == " O "){
                    O_win++;
                    gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                }
            }
        }
        if(game_over == false){
            if (arr[0][2] == getPlayer && arr[1][1] == getPlayer && arr[2][0] == getPlayer) {
                m_BoardPrint();
                System.out.println("Player " + getPlayer.trim() + " wins the game!");
                myText.setText("Player " + getPlayer.trim() + " wins the game!");
                game_over = true;
                buttons[0][2].setBackground(Color.YELLOW);
                buttons[1][1].setBackground(Color.YELLOW);
                buttons[2][0].setBackground(Color.YELLOW);
                if(getPlayer == " X "){
                    X_win++;
                    gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                }
                else if(getPlayer == " O "){
                    O_win++;
                    gameText.setText("X wins: " + X_win + "       Tic-Tac-Toe       " + "O wins: " + O_win);
                }
            }
        }
    }


    public void m_BoardPrint() {
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print((board[i][j]));
            }
            System.out.println();
        }
    }
}
