package game;


import game.character.Character;

import java.io.*;

public class GameSaverLoader {

    // Variable initialisation
    public static int loadedLives;
    public static int loadedCoins;
    static int loadedTimer;
    public static boolean loadedGame = false;

    // Initialises save file name and object
    static public String fileName = "data/saver.txt";
    static File saveFile = new File(fileName);





    // Method for saving the current game
    public static void save(String fileName) throws IOException {
        boolean append = true;
        // Saves the stats in the format lives,coins,timer
        try (FileWriter writer = new FileWriter(fileName, append)) {
            writer.write( Character.getLives() + "," + Character.getCoins() + "," + GameTimer.getTimer() + "\n");
        }
    }

    // Method for loading the last saved game
    public static void load(String fileName) throws IOException {
        int lives = 0;
        int coins = 0;
        int timer = 0;
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

                line = reader.readLine();
            }
            // Assigns the saved data to variables to be passed into
            loadedLives = lives;
            loadedCoins = coins;
            loadedTimer = timer;
            // Sets to true so GameLevel knows we are using imported stats
            loadedGame = true;

            new Game();

        }
        // Closes file after done
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