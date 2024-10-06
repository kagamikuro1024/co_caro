import java.util.*;



public class gameplay {
    static ArrayList<Integer> player1Positions = new ArrayList<Integer>();
    static ArrayList<Integer> player2Positions = new ArrayList<Integer>();

    public static void main(String[] args){
        char[][]    gameBoard = {{' ', '|', ' ', '|',' '},
                                 {'-', '+', '-', '+','-'},                        
                                 {' ', '|', ' ', '|',' '},
                                 {'-', '+', '-', '+','-'},
                                 {' ', '|', ' ', '|',' '}};
        Scanner sc = new Scanner(System.in);
        Random rand = new Random(); 
        int pl1, pl2, check;
        String checkStr;        
        System.out.println("Start game:");  
        printGameBoard(gameBoard);      
        System.out.println("Play with computer or another player(0 or 1)?");
        check = sc.nextInt();
        if(check == 0){
            System.out.println(" ");
            System.out.println("You want to play first?(YES/NO)");
            checkStr = sc.next();
            if(checkStr.equals("YES")){
                while(true){
                    System.out.println("Player1: Which position will you put a X at (1-9)?");
                    pl1 = sc.nextInt();
                    while(player1Positions.contains(pl1)||player2Positions.contains(pl1)){
                        System.out.println("Position taken!!! Please enter a correct position: ");
                        pl1 = sc.nextInt();
                    }
                    makeDecision(gameBoard, pl1, "player1");
                    printGameBoard(gameBoard);  
                    //System.out.println("Player2: Which position will you put a O at (1-9)?");

                    pl2 = rand.nextInt(9) +1;
                    while(player1Positions.contains(pl2)||player2Positions.contains(pl2)){
                        //System.out.println("Position taken!!! Please enter a correct position: ");
                        pl2 = rand.nextInt(9)+1;
                    }
                    makeDecision(gameBoard, pl2, "player2");
                    System.out.println("Computer play: ");
                    printGameBoard(gameBoard);
                    String result = checkWinner();
                    if(result.length() > 0){
                        if(result.equals("Player2 win:333")) 
                            System.out.println("Computer win:333");
                        else 
                            System.out.println("You win:333");
                        break;
                    } 
                }
            }
            else if(checkStr.equals("NO")){
                while(true){
                    //System.out.println("Player1: Which position will you put a X at (1-9)?");
                    pl1 = rand.nextInt(9) + 1;
                    while(player1Positions.contains(pl1)||player2Positions.contains(pl1)){
                        //System.out.println("Position taken!!! Please enter a correct position: ");
                        pl1 = rand.nextInt(9)+1;
                    }
                    makeDecision(gameBoard, pl1, "player1");
                    System.out.println("Computer play: ");
                    printGameBoard(gameBoard);  
                    System.out.println("Player2: Which position will you put a O at (1-9)?");

                    pl2 = sc.nextInt();
                    while(player1Positions.contains(pl2)||player2Positions.contains(pl2)){
                        System.out.println("Position taken!!! Please enter a correct position: ");
                        pl2 = sc.nextInt();
                    }
                    makeDecision(gameBoard, pl2, "player2");
                    printGameBoard(gameBoard);
                    String result = checkWinner();
                    if(result.length() > 0){
                        if(result.equals("Player1 win:333")) 
                            System.out.println("Computer win:333");
                        else 
                            System.out.println("You win:333");
                        break;
                    } 
                }
            }
        }
        else if(check == 1){
            while(true){
                System.out.println("Player1: Which position will you put a X at (1-9)?");
                pl1 = sc.nextInt();
                while(player1Positions.contains(pl1)||player2Positions.contains(pl1)){
                    System.out.println("Position taken!!! Please enter a correct position: ");
                    pl1 = sc.nextInt();
                }
                makeDecision(gameBoard, pl1, "player1");
                printGameBoard(gameBoard);  
                String result = checkWinner();
                if(result.length() > 0){
                    System.out.println(checkWinner());
                    break;
                } 
                System.out.println("Player2: Which position will you put a O at (1-9)?");
                pl2 = sc.nextInt();
                while(player1Positions.contains(pl2)||player2Positions.contains(pl2)){
                    System.out.println("Position taken!!! Please enter a correct position: ");
                    pl2 = sc.nextInt();
                }
                makeDecision(gameBoard, pl2, "player2");
                printGameBoard(gameBoard);
               
            }
        }
        sc.close();

        
    }
    public static void printGameBoard(char[][] gameBoard){
        for(char[] row : gameBoard ){
            for(char c: row){
                System.out.print(c);
            }
            System.out.println();
        }
    }
    public static void makeDecision(char[][] gameBoard, int a, String User){
        char symbol =' ';
        if(User.equals("player1")){
            symbol = 'X';
            player1Positions.add(a);
        }
        else if(User.equals("player2")){
            symbol = 'O';
            player2Positions.add(a);
        }
        switch(a){
            case 1:
                gameBoard[0][0] = symbol;
                break;
            case 2:
                gameBoard[0][2] = symbol;
                break;
            case 3:
                gameBoard[0][4] = symbol;
                break;
            case 4:
                gameBoard[2][0] = symbol;
                break;
            case 5:
                gameBoard[2][2] = symbol;
                break;
            case 6:
                gameBoard[2][4] = symbol;
                break;
            case 7:
                gameBoard[4][0] = symbol;
                break;
            case 8:
                gameBoard[4][2] = symbol;
                break;
            case 9:
                gameBoard[4][4] = symbol;
                break;
            default:
                break;

        }
    }
    public static String checkWinner(){
        List topRow = Arrays.asList(1, 2, 3);
        List midRow = Arrays.asList(4, 5, 6);
        List botRow = Arrays.asList(7, 8, 9);
        List leftCol = Arrays.asList(1, 4, 7);
        List midCol = Arrays.asList(2, 5, 6);
        List rightCol = Arrays.asList(3, 6, 9);
        List mainCross = Arrays.asList(1, 5, 9);
        List minorCross = Arrays.asList(7, 5, 3);
        List<List> winner = new ArrayList<List>();
        winner.add(topRow);
        winner.add(midRow);
        winner.add(botRow);
        winner.add(leftCol);
        winner.add(midCol);
        winner.add(rightCol);
        winner.add(mainCross);
        winner.add(minorCross);
        for(List l : winner) {
            if(player1Positions.containsAll(l)){
                return "Player1 win:333";
            }
            else if(player2Positions.containsAll(l)){
                return "Player2 win:333";
            }
            else if(player1Positions.size() + player2Positions.size() == 9){
                return "Tie..."; 
            } 
        }
        return "";

    }
}
