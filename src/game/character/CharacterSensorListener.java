package game.character;

import city.cs.engine.Body;
import city.cs.engine.BodyImage;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class CharacterSensorListener implements SensorListener {

    private Character character;

    public CharacterSensorListener(Character character) {
        this.character = character;
    }

    @Override
    public void beginContact(SensorEvent sensorEvent) {
        Body body = sensorEvent.getSensor().getBody();
        if(body instanceof Character character){
            character.setSensorContacts(character.getSensorContacts()+1);


            if(character.isInAir()){
                character.setInAir(false);
                character.startWalking(0);

                if((character.getCharacterFacing() == null && character.getPreviousCharacterFacing() == CharacterFacing.LEFT)) {
                    character.removeAllImages();
                    character.addImage(new BodyImage("data/mario left.png", character.getCharacterHalfHeight() * 2));
                    return;
                }

                if((character.getCharacterFacing() == null && character.getPreviousCharacterFacing() == CharacterFacing.RIGHT)){
                    character.removeAllImages();
                    character.addImage(new BodyImage("data/mario right.png", character.getCharacterHalfHeight() * 2));
                    return;

                }
                if(character.getCharacterFacing() == CharacterFacing.LEFT){
                    character.removeAllImages();
                    character.addImage(new BodyImage("data/mario left.png", character.getCharacterHalfHeight() * 2));
                    return;


                }

                if(character.getCharacterFacing() == CharacterFacing.RIGHT) {
                    character.removeAllImages();
                    character.addImage(new BodyImage("data/mario right.png", character.getCharacterHalfHeight() * 2));
                    return;
                }
            }
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {
        Body body = sensorEvent.getSensor().getBody();
        if(body instanceof Character character){
            character.setSensorContacts(character.getSensorContacts()-1);
        }

    }


}
