package sample;

public class GameStatusCheck {

    public void checkGameStatus(Controller controller) {
        for (int i=0; i<3; i++)
        {
            // Checking for Player Winning in Horizontal.
            if (controller.winCheck[i][0] == 1 && controller.winCheck[i][1] == 1 && controller.winCheck[i][2] == 1)
            {
                controller.gameWon = true;
                controller.playWinAnimation();
                controller.buttonJob.disableBoxButtons(controller);
                break;
            }
            // Checking for Player Winning in Vertical.
            else if (controller.winCheck[0][i] == 1 && controller.winCheck[1][i] == 1 && controller.winCheck[2][i] == 1)
            {
                controller.gameWon = true;
                controller.playWinAnimation();
                controller.buttonJob.disableBoxButtons(controller);
                break;
            }
            // Checking for Player Winning in Diagonal.
            else if (controller.winCheck[0][0] == 1 && controller.winCheck[1][1] == 1 && controller.winCheck[2][2] == 1 || controller.winCheck[2][0] == 1 && controller.winCheck[1][1] == 1 && controller.winCheck[0][2] == 1)
            {
                controller.gameWon = true;
                controller.playWinAnimation();
                controller.buttonJob.disableBoxButtons(controller);
                break;
            }
            // Checking for AI Winning in Horizontal.
            else if (controller.winCheck[i][0] == 2 && controller.winCheck[i][1] == 2 && controller.winCheck[i][2] == 2)
            {
                controller.gameWon = true;
                controller.playWinAnimation();
                controller.buttonJob.disableBoxButtons(controller);
                break;
            }
            // Checking for AI Winning in Vertical.
            else if (controller.winCheck[0][i] == 2 && controller.winCheck[1][i] == 2 && controller.winCheck[2][i] == 2)
            {
                controller.gameWon = true;
                controller.playWinAnimation();
                controller.buttonJob.disableBoxButtons(controller);
                break;
            }
            // Diagonal Checking for AI Winning in Diagonal.
            else if (controller.winCheck[0][0] == 2 && controller.winCheck[1][1] == 2 && controller.winCheck[2][2] == 2 || controller.winCheck[2][0] == 2 && controller.winCheck[1][1] == 2 && controller.winCheck[0][2] == 2)
            {
                controller.gameWon = true;
                controller.playWinAnimation();
                controller.buttonJob.disableBoxButtons(controller);
                break;
            }
        }
        if (controller.filledBox == 9 && !controller.gameWon)
        {
            controller.gameDrawn = true;
            controller.buttonJob.disableBoxButtons(controller);
        }
    }
}
