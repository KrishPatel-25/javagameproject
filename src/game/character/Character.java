package game.character;

import city.cs.engine.*;
import city.cs.engine.Shape;
import game.mainGame.GameSaverLoader;
import org.jbox2d.common.Timer;

import static game.mainGame.GameSaverLoader.loadedCoins;
import static game.mainGame.GameSaverLoader.loadedLives;

public class Character extends Walker {

    public boolean end = false;

    public static int lives = 3;

    public static int coins = 0;

    private int sensorContacts;

    private CharacterFacing previousCharacterFacing;

    private CharacterFacing characterFacing;
    private boolean isInAir;

    private int characterHalfWidth = 1;
    private int characterHalfHeight = 2;

    private int previousJumpSpeed;

    public int getPreviousJumpSpeed() {
        return previousJumpSpeed;
    }

    public void setPreviousJumpSpeed(int previousJumpSpeed) {
        this.previousJumpSpeed = previousJumpSpeed;
    }

    private static Shape studentShape;

    private Timer boostTimer;

    public Timer getBoostTimer() {
        return boostTimer;
    }

    public void setBoostTimer(Timer boostTimer) {
        this.boostTimer = boostTimer;
    }



    private boolean jumpBoost = false;

    public boolean isJumpBoost() {
        return jumpBoost;
    }
    public void setJumpBoost(boolean jumpBoost) {
        this.jumpBoost = jumpBoost;
    }

    public int jumpingSpeed = 12;

    public int getJumpingSpeed() {
        return jumpingSpeed;
    }

    public void setJumpingSpeed(int jumpingSpeed) {
        this.jumpingSpeed = jumpingSpeed;
    }



    private static final BodyImage image =
            new BodyImage("data/mario right.png", 4f);


    public CharacterFacing getCharacterFacing() {
        return characterFacing;
    }

    public void setCharacterFacing(CharacterFacing characterFacing) {
        this.characterFacing = characterFacing;
    }

    public Character(World world, Shape studentShape) {
        super(world, studentShape);
        addImage(image);
        Shape shape = new PolygonShape(-0.54f,-1.57f, -0.56f,-2.2f, 0.4f,-2.2f, 0.39f,-1.61f );
        Sensor sensor = new Sensor(this, shape);
        sensor.addSensorListener(new CharacterSensorListener(this));
        sensorContacts = 0;
        isInAir = false;
        characterFacing = null;
        previousCharacterFacing = CharacterFacing.RIGHT;
        this.boostTimer = new Timer();
        this.previousJumpSpeed = jumpingSpeed;
        if(GameSaverLoader.loadedGame){
            setLives(loadedLives);
            setCoins(loadedCoins);


        }

    }




    public static int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
    }

    public static int getCoins() {
        return coins;
    }

    public void setCoins(int coins) {
        this.coins = coins;
    }

    public CharacterFacing getPreviousCharacterFacing() {
        return previousCharacterFacing;
    }

    public void setPreviousCharacterFacing(CharacterFacing previousCharacterFacing) {
        this.previousCharacterFacing = previousCharacterFacing;
    }

    public boolean isInAir() {
        return isInAir;
    }

    public void setInAir(boolean inAir) {
        isInAir = inAir;
    }

    public int getSensorContacts() {
        return sensorContacts;
    }

    public void setSensorContacts(int sensorContacts) {
        this.sensorContacts = sensorContacts;
    }

    public int getCharacterHalfHeight() {
        return characterHalfHeight;
    }



}




