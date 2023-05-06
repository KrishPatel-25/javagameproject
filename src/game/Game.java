package game;

import city.cs.engine.*;
import game.character.CharacterController;
import game.character.Tracker;

import javax.swing.JFrame;

/**
 * Your main game entry point
 */
public class Game {


    public static JFrame frame;

    /** Initialise a new Game. */
    public Game() {

        // World world = new World();
        GameWorld world = new GameWorld();




        //3. make a view to look into the game world
        GameView view = new GameView(world, 800, 600);
//        view.setZoom(10);



        world.addStepListener(new Tracker(view,world.getCharacter()));

        CharacterController controller = new CharacterController(world.getCharacter());
        view.addKeyListener(controller);

        //optional: draw a 1-metre grid over the view
//         view.setGridResolution(1);




        //4. create a Java window (frame) and add the game
        //   view to it
        frame = new JFrame("Mario Remix");
        frame.add(view);
        frame.addKeyListener(new CharacterController(world.getCharacter()));


        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.pack();
        // finally, make the frame visible
        frame.setVisible(true);

        world.start();

        //optional: uncomment this to make a debugging view
//         JFrame debugView = new DebugViewer(world, 800, 600);

        //none of the images or gifs used are mine and I will not use them for commercial purposes. They are strictly used for my coursework.
// https://youtu.be/RamzJVJ2pxk is where i got the background music from and it says it is copyright free

    }


    /** Run the game. */
    public static void main(String[] args) {

        new MenuScreen();


    }
}

