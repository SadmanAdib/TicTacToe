package sample;

public class AI {
    public void callAI(Controller controller)
    {
        int y = (int) (Math.random() * ((3 - 1) + 1));
        int x = (int) (Math.random() * ((3 - 1) + 1));
        controller.checkIfBoxOccupied(y, x);

        if (!controller.currentAI.equals("random")) {
            controller.checkDefensiveAICondition();
        }
        controller.placeO(controller.randomAISelectingFreeBox);
    }
}
