package game.mainGame;


import game.character.Character;

import java.io.*;

public class GameSaverLoader {

    public static int loadedLives;
    public static int loadedCoins;
    public static int loadedTimer;
    public static float loadedX;
    public static float loadedY;
    public static boolean loadedGame = false;

    // Initialises save file name
    static public String fileName = "data/saver.txt";
    static File saveFile = new File(fileName);





    // Method for saving the current game
    public static void save(String fileName) throws IOException {
        boolean append = true;
        GameWorld.getCharacterPosition();
        // Saves the stats in the format lives,coins,timer, character x position, character y position
        try (FileWriter writer = new FileWriter(fileName, append)) {
            writer.write( Character.getLives() + "," + Character.getCoins() + "," + GameTimer.getTimer() + "," + GameWorld.x + "," + GameWorld.y + "\n");
        }
    }

    // Method for loading the last saved game
    public static void load(String fileName) throws IOException {
        int lives = 0;
        int coins = 0;
        int timer = 0;
        float x = 0;
        float y = 0;
        FileReader fr = null;
        BufferedReader reader = null;

        try {
            System.out.println("Reading " + fileName + " ...");
            fr = new FileReader(saveFile);
            reader = new BufferedReader(fr);
            String line = reader.readLine();

            while (line != null) {
                // Splits the saved data and stores them in variables
                String[] tokens = line.split(",");
                lives = Integer.parseInt(tokens[0]);
                coins = Integer.parseInt(tokens[1]);
                timer = Integer.parseInt(tokens[2]);
                x = Float.parseFloat(tokens[3]);
                y = Float.parseFloat(tokens[4]);

                line = reader.readLine();
            }

            loadedLives = lives;
            loadedCoins = coins;
            loadedTimer = timer;
            loadedX = x;
            loadedY= y;
            // Sets to true so GameLevel knows we are using the saved version
            loadedGame = true;

            new Game();

        }
        // Closes file after previous save has been loaded
        finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
    }


}