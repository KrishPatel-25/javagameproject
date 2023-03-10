package game.character;

import city.cs.engine.*;
import city.cs.engine.Shape;
public class Character extends Walker {

    private int lives;

    private int sensorContacts;

    private CharacterFacing previousCharacterFacing;

    private CharacterFacing characterFacing;
    private boolean isInAir;

    private int characterHalfWidth = 1;
    private int characterHalfHeight = 2;

    private static Shape studentShape;
    private int coins = 0;

    public int getCredits() {
        return coins;

    }

    public void setCredits(int credits) {
        this.coins = credits;
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
        lives = 3;
    }

    public void loseLife(){
        this.lives -=1 ;
    }

    public int getLives() {
        return lives;
    }

    public void setLives(int lives) {
        this.lives = lives;
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




