import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


public class Connect4 implements ActionListener{
    private JFrame frame;
    private JPanel topPanel;
    private JPanel centerPanel;
    private JPanel bottomPanel;
    private JButton[][] buttons;
    private JButton resetButton;
    private JButton exitButton;
    private JLabel gameText;
    private JLabel resetText;
    private JLabel exitText;
    private int red_win;
    private int blue_win;


    private String[][] board = new String[6][7];
    boolean turn = false;
    int num_of_times = 42;
    boolean game_over = false;
    JLabel myText = new JLabel();
    String player;
    private ImageIcon imageIconDflt;


    //  public static void main(String[] args) {
    //   Connect4 Con4 = new Connect4();
    //  }


    // Loads a piece image from next to the game's class files (or inside a jar),
    // falling back to the current folder, so the images are found no matter
    // which folder the game is started from.
    static ImageIcon loadIcon(String name) {
        java.net.URL url = Connect4.class.getResource(name);
        if (url != null) {
            return new ImageIcon(url);
        }
        return new ImageIcon(name);
    }


    public void Connect4(){


        imageIconDflt = Connect4.loadIcon("whiteIcon.png");
        System.out.println("Connect 4");
        player = "Blue";
        System.out.println("Turn of Player: " + player);
        myText.setText("Turn of Player: " + player);




        for (int row = 0; row < board.length; row++) {
            for (int col = 0; col < board[0].length; col++) {
                board[row][col] = " - ";
                System.out.print(board[row][col]);
            }
            System.out.println();
        }


        frame = new JFrame("Connect 4 - vs Friend");
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


        topPanel.setLayout(new BorderLayout());
        ImageIcon imageIcon = Connect4.loadIcon("redIcon.png");
        Image image = imageIcon.getImage();
        Image scaledImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon = new ImageIcon(scaledImage);
        JLabel imageLabel = new JLabel(scaledIcon);
        topPanel.add(imageLabel, BorderLayout.WEST);


        ImageIcon imageIcon2 = Connect4.loadIcon("blueIcon.png");
        Image image2 = imageIcon2.getImage();
        Image scaledImage2 = image2.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
        ImageIcon scaledIcon2 = new ImageIcon(scaledImage2);
        JLabel imageLabel2 = new JLabel(scaledIcon2);
        imageLabel2.setHorizontalAlignment(SwingConstants.RIGHT);
        topPanel.add(imageLabel2, BorderLayout.EAST);


        gameText = new JLabel();
        gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
        gameText.setFont(new Font("Ink Free", Font.PLAIN, 36));
        gameText.setHorizontalAlignment(SwingConstants.CENTER);
        topPanel.add(gameText, BorderLayout.CENTER);


        centerPanel = new JPanel();
        centerPanel.setLayout(new GridLayout(6,7));
        buttons = new JButton[6][7];
        for(int row = 0; row < buttons.length; row++){
            for(int col = 0; col < buttons[row].length; col++){
                buttons[row][col] = new JButton();
                buttons[row][col].setBackground(new Color(255, 255, 255));
                buttons[row][col].setFont(new Font("MV Boli", Font.BOLD, 120));
                buttons[row][col].setFocusable(false);
                imageIconDflt.setImage(Connect4.loadIcon("whiteIcon.png").getImage());
                Image imageDflt = imageIconDflt.getImage();
                Image scaledImageDflt = imageDflt.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                ImageIcon scaledIconDflt = new ImageIcon(scaledImageDflt);
                buttons[row][col].putClientProperty("rowthis", row);
                buttons[row][col].putClientProperty("colthis", col);
                buttons[row][col].addActionListener(this);
                buttons[row][col].setIcon(null);
                buttons[row][col].setIcon(scaledIconDflt);
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


            for(row = 0; row < buttons.length; row++){
                for(col = 0; col < buttons[row].length; col++){
                    buttons[row][col].setText("");
                    buttons[row][col].setBackground(new Color(255, 255, 255));


                    imageIconDflt.setImage(Connect4.loadIcon("whiteIcon.png").getImage());
                    Image imageDflt = imageIconDflt.getImage();
                    Image scaledImageDflt = imageDflt.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
                    ImageIcon scaledIconDflt = new ImageIcon(scaledImageDflt);
                    buttons[row][col].setIcon(null);
                    buttons[row][col].setIcon(scaledIconDflt);
                }
            }
            for (row = 0; row < board.length; row++) {
                for (col = 0; col < board[0].length; col++) {
                    board[row][col] = " - ";
                    System.out.print(board[row][col]);
                }
                System.out.println();
            }
            num_of_times = 42;
            game_over = false;
            myText.setText("");
            player = "Blue";
            System.out.println("Turn of Player: " + player);
            myText.setText("Turn of Player: " + player);
        }
        else if(e.getActionCommand().equals("Play") && game_over == false){


            int clickedRow = 0;
            int clickedCol = 0;
            JButton clickedButton = (JButton) e.getSource();
            clickedRow = (int) clickedButton.getClientProperty("rowthis");
            clickedCol = (int) clickedButton.getClientProperty("colthis");


            if (board[0][clickedCol] != " - ") {
                System.out.println("Column is full. Pick another column.");
                myText.setText("Column is full!");
                return;
            }


            while (num_of_times >=0 ) {


                if (num_of_times%2 == 0) {
                    turn = true;
                } else {
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
        ImageIcon imageIcon = new ImageIcon();


        boolean chkagain = true;
        boolean chk = true;
        while(chk){
            if(board[clickedRow][clickedCol] != " - "){
                while(chkagain){
                    if(clickedRow == 0){
                        chkagain = false;
                    }
                    clickedRow = clickedRow-1;
                    if(board[clickedRow][clickedCol] == " - "){
                        chkagain = false;
                    }
                }
                chk = false;
            }
            else{
                if(clickedRow != 5 && board[clickedRow + 1][clickedCol] == " - "){
                    clickedRow = clickedRow + 1;
                }
                else{
                    clickedCol = clickedCol;
                    clickedRow = clickedRow;
                    chk = false;
                }
            }
        }


        if (turn == true) {
            player = "Blue";
            player1 = "Red";
            System.out.println("Turn of Player: " + player1);
            myText.setText("Turn of Player: " + player1);
        }
        else {
            player = "Red";
            player1 = "Blue";
            System.out.println("Turn of Player: " + player1);
            myText.setText("Turn of Player: " + player1);
        }


        board[clickedRow][clickedCol] = player;


        if (player == "Blue"){
            imageIcon.setImage(Connect4.loadIcon("blueIcon.png").getImage());
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            buttons[clickedRow][clickedCol].setIcon(scaledIcon);
        }
        else{
            imageIcon.setImage(Connect4.loadIcon("redIcon.png").getImage());
            Image image = imageIcon.getImage();
            Image scaledImage = image.getScaledInstance(75, 75, Image.SCALE_SMOOTH);
            ImageIcon scaledIcon = new ImageIcon(scaledImage);
            buttons[clickedRow][clickedCol].setIcon(scaledIcon);
        }
        System.out.println(player);
        num_of_times--;
        m_WinnerCheck(board, player, clickedRow, clickedCol);
        if (game_over == true){
            num_of_times = -1;
        }
        return (num_of_times);
    }


    public void m_WinnerCheck(String arr[][], String getPlayer, int clickedRow, int clickedCol) {

        if(game_over == false){
            for (int row = 0; row < arr.length; row++) {
                for (int col = 0; col < arr[0].length - 3; col++) {
                    if (arr[row][col] == getPlayer &&
                            arr[row][col + 1] == getPlayer &&
                            arr[row][col + 2] == getPlayer &&
                            arr[row][col + 3] == getPlayer) {
                        m_BoardPrint();
                        System.out.println("Player " + getPlayer.trim() + " wins the game!");
                        myText.setText("Player " + getPlayer.trim() + " wins the game!");
                        game_over = true;
                        buttons[row][col].setBackground(Color.YELLOW);
                        buttons[row][col + 1].setBackground(Color.YELLOW);
                        buttons[row][col + 2].setBackground(Color.YELLOW);
                        buttons[row][col + 3].setBackground(Color.YELLOW);
                        row = arr.length;
                        col = arr[0].length;


                        if(getPlayer == "Red"){
                            red_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                        else if(getPlayer == "Blue"){
                            blue_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                    }
                }
            }
        }


        if(game_over == false){
            for (int col=0; col<arr[0].length; col++) {
                for(int row=0; row<arr.length-3; row++){
                    if (arr[row][col] == getPlayer &&
                            arr[row+1][col] == getPlayer &&
                            arr[row+2][col] == getPlayer &&
                            arr[row+3][col] == getPlayer) {
                        m_BoardPrint();
                        System.out.println("Player " + getPlayer.trim() + " wins the game!");
                        myText.setText("Player " + getPlayer.trim() + " wins the game!");
                        game_over = true;
                        buttons[row][col].setBackground(Color.YELLOW);
                        buttons[row+1][col].setBackground(Color.YELLOW);
                        buttons[row+2][col].setBackground(Color.YELLOW);
                        buttons[row+3][col].setBackground(Color.YELLOW);


                        if(getPlayer == "Red"){
                            red_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                        else if(getPlayer == "Blue"){
                            blue_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                    }
                }
            }
        }


        if(game_over == false){
            for(int row = 0; row < arr.length - 3; row++){
                for(int col = 0; col < arr[0].length - 3; col++){
                    if (arr[row][col] == getPlayer &&
                            arr[row+1][col+1] == getPlayer &&
                            arr[row+2][col+2] == getPlayer &&
                            arr[row+3][col+3] == getPlayer) {
                        m_BoardPrint();
                        System.out.println("Player " + getPlayer.trim() + " wins the game!");
                        myText.setText("Player " + getPlayer.trim() + " wins the game!");
                        game_over = true;
                        buttons[row][col].setBackground(Color.YELLOW);
                        buttons[row + 1][col + 1].setBackground(Color.YELLOW);
                        buttons[row + 2][col + 2].setBackground(Color.YELLOW);
                        buttons[row + 3][col + 3].setBackground(Color.YELLOW);
                        row = arr.length;
                        col = arr[0].length;


                        if(getPlayer == "Red"){
                            red_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                        else if(getPlayer == "Blue"){
                            blue_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                    }
                }
            }
        }


        if(game_over == false){
            for(int row = arr.length/2; row < arr.length; row++){
                for(int col = 0; col < arr[0].length - 3; col++){
                    if (arr[row][col] == getPlayer &&
                            arr[row-1][col+1] == getPlayer &&
                            arr[row-2][col+2] == getPlayer &&
                            arr[row-3][col+3] == getPlayer) {
                        m_BoardPrint();
                        System.out.println("Player " + getPlayer.trim() + " wins the game!");
                        myText.setText("Player " + getPlayer.trim() + " wins the game!");
                        game_over = true;
                        buttons[row][col].setBackground(Color.YELLOW);
                        buttons[row - 1][col + 1].setBackground(Color.YELLOW);
                        buttons[row - 2][col + 2].setBackground(Color.YELLOW);
                        buttons[row - 3][col + 3].setBackground(Color.YELLOW);
                        row = arr.length;
                        col = arr[0].length;


                        if(getPlayer == "Red"){
                            red_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                        else if(getPlayer == "Blue"){
                            blue_win++;
                            gameText.setText("Red wins: " + red_win + "    Connect 4    " + " Blue wins: " + blue_win);
                        }
                    }
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
