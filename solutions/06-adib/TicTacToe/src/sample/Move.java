package sample;

public class Move {

    public void classicPlayerMove(int y, int x, Controller controller)
    {
        controller.buttons[y][x].setText("X");
        controller.buttons[y][x].setMouseTransparent(true);
        controller.nextMove(y, x);
    }

    public void forrestPlayerMove(int y, int x, Controller controller)
    {
        controller.buttons[y][x].setText("\uD83C\uDF3C");
        controller.buttons[y][x].setMouseTransparent(true);
        controller.nextMove(y, x);
    }

    public void contrastPlayerMove(int y, int x, Controller controller)
    {
        controller.buttons[y][x].setStyle("-fx-opacity: 1.0;-fx-background-color: black;");
        controller.buttons[y][x].setText("P");
        controller.buttons[y][x].setMouseTransparent(true);
        controller.nextMove(y, x);
    }

    public void classicAIMove(int y, int x, Controller controller) {
        controller.buttons[y][x].setText("O");
        controller.buttons[y][x].setMouseTransparent(true);
        controller.move.finishAImove(y, x, controller);
    }

    public void forrestAIMove(int y, int x, Controller controller) {
        controller.buttons[y][x].setText("\uD83C\uDF44");
        controller.buttons[y][x].setMouseTransparent(true);
        controller.move.finishAImove(y, x, controller);
    }

    public void contrastAIMove(int y, int x, Controller controller) {
        controller.buttons[y][x].setStyle("-fx-opacity: 1.0;-fx-background-color: white;");
        controller.buttons[y][x].setText("AI");
        controller.buttons[y][x].setMouseTransparent(true);
        controller.move.finishAImove(y, x, controller);
    }

    public void finishAImove(int y, int x, Controller controller) {
        controller.filledBox++;
        controller.winCheck[y][x] = 2; // 2 for AI Occupied Cell.
        controller.gameStatusCheck.checkGameStatus(controller);
    }
}
