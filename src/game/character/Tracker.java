package game.character;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import game.GameView;
import game.character.Character;
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
        view.setCentre(new Vec2(character.getPosition().x, character.getPosition().y + 20));

//        view.setCentre(character.getPosition());



//        view.updateBackground((Graphics2D) view.getGraphics(),character);

    }


}