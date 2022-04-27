package godzhell.model.content.dialogue.impl;

import godzhell.definitions.NpcID;
import godzhell.model.content.dialogue.Dialogue;
import godzhell.model.content.dialogue.DialogueManager;
import godzhell.model.content.dialogue.Emotion;

public class StarterDialogue extends Dialogue {
    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                DialogueManager.sendNpcChat(getPlayer(), NpcID.GIELINOR_GUIDE_9476, Emotion.DEFAULT, "Welcome to GodzHell a custom Oldschool server", "I am here to show you around the server", "the mystical wizard has teleports.");
                setNext(1);
                break;
            case 1:
                DialogueManager.sendNpcChat(getPlayer(), NpcID.GIELINOR_GUIDE_9476, Emotion.DEFAULT, "there is some shops at home but most are all over", "the world, this way you can get all items.");
                setNext(2);
                break;
            case 2:
                DialogueManager.sendNpcChat(getPlayer(), NpcID.GIELINOR_GUIDE_9476, Emotion.DEFAULT, "We also have 1000+ customs. for all your fashion needs and your rare", "collecting needs, the world is all", " yours to do what ever you want.");
                setNext(3);
                break;
            case 3:
                DialogueManager.sendNpcChat(getPlayer(), NpcID.GIELINOR_GUIDE_9476, Emotion.DEFAULT, "We have some game modes for you to", "pick from to start enjoying the server", "what do you want to be?");
                break;
        }
    }
}
