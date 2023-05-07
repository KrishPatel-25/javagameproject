package game.character;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.mainGame.GameView;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private GameView view;
    private Character character;

    public Tracker(GameView view, Character character) {
        this.view = view;
        this.character = character;
    }

    @Override
    public void preStep(StepEvent e) {

    }

    @Override
    public void postStep(StepEvent e) {
        if (character.getPosition().x < 20) {
            view.setCentre(new Vec2(20,35));
            return;
        }


        view.setCentre(new Vec2(character.getPosition().x, 35));

    }

}






