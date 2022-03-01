package sample;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;

public class Controller {

    Button[][] buttons = new Button[3][3];
    int filledBox = 0, yPosition, xPosition;
    String currentTheme = "classic", currentAI ="null";
    boolean gameWon = false, gameDrawn = false;
    int[] randomAISelectingFreeBox = new int[3];
    int[][] winCheck = new int[3][3];

    ButtonJob buttonJob = new ButtonJob();
    Move move = new Move();
    GameStatusCheck gameStatusCheck = new GameStatusCheck();
    AI ai = new AI();


    @FXML
    private Button button00, button10, button20, button01, button11, button21, button02, button12, button22, startWithDefensiveAI, startWithRandomAI;
    @FXML
    private AnchorPane AnchorPaneRight;
    @FXML
    private GridPane GridPane01;

    @FXML
    void startWithDefensiveAIClicked()
    {
        initialiseButtons();
        currentAI = "defensive";
        startNewGame();
    }
    @FXML
    void startWithRandomAIClicked()
    {
        initialiseButtons();
        currentAI = "random";
        startNewGame();
    }

    @FXML
    void tileButtonPressed()
    {
        button00.setOnAction(e -> makeMove(0, 0));
        button10.setOnAction(e -> makeMove(1, 0));
        button20.setOnAction(e -> makeMove(2, 0));
        button01.setOnAction(e -> makeMove(0, 1));
        button11.setOnAction(e -> makeMove(1, 1));
        button21.setOnAction(e -> makeMove(2, 1));
        button02.setOnAction(e -> makeMove(0, 2));
        button12.setOnAction(e -> makeMove(1, 2));
        button22.setOnAction(e -> makeMove(2, 2));
    }

    public void makeMove(int y, int x)
    {
        initialiseButtons();
        putX(y, x);
    }

    public void initialiseButtons()
    {
        buttons[0][0] = button00; buttons[1][0] = button10;
        buttons[2][0] = button20; buttons[0][1] = button01;
        buttons[1][1] = button11; buttons[2][1] = button21;
        buttons[0][2] = button02; buttons[1][2] = button12;
        buttons[2][2] = button22;
    }

    public void putX(int y, int x)
    {
        switch (currentTheme) {
            case "classic":
                move.classicPlayerMove(y, x, this);
                break;
            case "forrest":
                move.forrestPlayerMove(y, x, this);
                break;
            case "highContrast":
                move.contrastPlayerMove(y, x, this);
                break;
        }
    }


    public void nextMove(int y, int x)
    {
        filledBox++;
        winCheck[y][x] = 1; // 1 for Player
        gameStatusCheck.checkGameStatus(this);
        if (!gameWon && !gameDrawn)
        {
            ai.callAI(this);
        }
        else buttonJob.disableBoxButtons(this);
    }

    public void checkIfBoxOccupied(int y, int x) {
        if (winCheck[y][x] == 0)
        {
            randomAISelectingFreeBox[0] = y;
            randomAISelectingFreeBox[1] = x;
        }
        else
            {
            for (int i=0; i<3; i++)
            {
                for (int j=0; j<3; j++)
                {
                    if (winCheck[j][i] == 0)
                    {
                        randomAISelectingFreeBox[0] = j;
                        randomAISelectingFreeBox[1] = i;
                        break;
                    }
                }
            }
            }
    }

    public void checkDefensiveAICondition()
    {
        for (int i=0; i<3; i++) {
            for (int j=0; j<3; j++) {
                // if (winCheck[j][0]==1)
            }
        }
    }

    public void placeO(int[] arr) {
        yPosition = arr[0];
        xPosition = arr[1];
        switch (currentTheme) {
            case "classic":
                move.classicAIMove(yPosition, xPosition, this);
                break;
            case "forrest":
                move.forrestAIMove(yPosition, xPosition, this);
                break;
            case "highContrast":
                move.contrastAIMove(yPosition, xPosition, this);
                break;
        }
    }


    public void playWinAnimation() {
        //implementation;
    }


    public void startNewGame() {
        for (int i=0; i<3; i++)
        {
            for (int j=0; j<3; j++)
            {
                winCheck[i][j] = 0;
            }
        }
        buttonJob.enableBoxButtons(this);
        buttonJob.resetButtonText(this);
        if (currentTheme.equals("highContrast"))
        {
            buttonJob.resetButtonColor(this);
        }
        filledBox = 0;
        gameWon = false;
        gameDrawn = false;
    }

    @FXML
    void changeThemeToClassic() {
        currentTheme = "classic";
        GridPane01.setStyle("-fx-opacity: 1.0;-fx-background-color: black;");
        for (Button[] innerArray : buttons)
        {
            for (Button val : innerArray)
            {
                val.setStyle("-fx-opacity: 1.0;-fx-background-color: white;");
            }
        }
        AnchorPaneRight.setStyle("-fx-opacity: 1.0;-fx-background-color: white;");
        startWithDefensiveAI.setStyle("-fx-opacity: 1.0;-fx-background-color: black;");
        startWithRandomAI.setStyle("-fx-opacity: 1.0;-fx-background-color: black;");
        startNewGame();
    }

    @FXML
    void changeThemeToForrest() {
        currentTheme = "forrest";
        GridPane01.setStyle("-fx-opacity: 1.0;-fx-background-color: forestgreen;");
        for (Button[] innerArray : buttons)
        {
            for (Button val : innerArray)
            {
                val.setStyle("-fx-opacity: 1.0;-fx-background-color: darkseagreen;");
            }
        }
        AnchorPaneRight.setStyle("-fx-opacity: 1.0;-fx-background-color: darkseagreen;");
        startWithDefensiveAI.setStyle("-fx-opacity: 1.0;-fx-background-color: darkgreen;");
        startWithRandomAI.setStyle("-fx-opacity: 1.0;-fx-background-color: darkgreen;");
        startNewGame();
    }

    @FXML
    void changeThemeToHighContrast() {
        currentTheme = "highContrast";
        GridPane01.setStyle("-fx-opacity: 1.0;-fx-background-color: lightgray;");
        for (Button[] innerArray : buttons)
        {
            for (Button val : innerArray)
            {
                val.setStyle("-fx-opacity: 1.0;-fx-background-color: darkgray;");
            }
        }
        AnchorPaneRight.setStyle("-fx-opacity: 1.0;-fx-background-color: darkgray;");
        startWithDefensiveAI.setStyle("-fx-opacity: 1.0;-fx-background-color: lightgray;-fx-text-fill: black");
        startWithRandomAI.setStyle("-fx-opacity: 1.0;-fx-background-color: lightgray;-fx-text-fill: black");
        startNewGame();
    }
}