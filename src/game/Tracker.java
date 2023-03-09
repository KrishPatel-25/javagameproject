package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

import java.awt.*;

public class Tracker implements StepListener {
    private GameView view;
    private Character character;
    public Tracker(GameView view, Character character) {
        this.view = view;
        this.character = character;
    }

    @Override
    public void preStep(StepEvent stepEvent) {

    }
    @Override
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(character.getPosition()));

//        view.updateBackground((Graphics2D) view.getGraphics(),character);

    }


}