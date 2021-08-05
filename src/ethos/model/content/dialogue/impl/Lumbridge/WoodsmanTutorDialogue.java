package ethos.model.content.dialogue.impl.Lumbridge;

import ethos.model.content.dialogue.Dialogue;
import ethos.model.content.dialogue.DialogueConstants;
import ethos.model.content.dialogue.DialogueManager;
import ethos.model.content.dialogue.Emotion;

public class WoodsmanTutorDialogue extends Dialogue {
    @Override
    public void execute() {
        switch(getNext()){
            case 0:
                if(getPlayer().playerLevel[getPlayer().playerWoodcutting] >= 99) {
                DialogueManager.sendNpcChat(getPlayer(), 3226, Emotion.CALM, "Wow! It's not often I meet somebody as accomplished", "as me in Woodcutting! Seeing as youre so skilled,", "maybe you are interested in buying a Skillcape of", "Woodcutting?");
            } else {
                DialogueManager.sendOption(getPlayer(),  "Tell me about different trees and axes.", "What is that cape you're wearing?", "Goodbye.");
            }
                break;
            case 1:
                DialogueManager.sendOption(getPlayer(), "Oak and Willow", "Maple and Yew", "Magic and other trees", "Axes", "Go back to teaching");

                break;
        }
    }
    @Override
    public boolean clickButton(int id) {
        switch(id) {
            case DialogueConstants.OPTIONS_3_1:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Tell me about different trees and axes.");
                setNext(1);
                break;
            case DialogueConstants.OPTIONS_3_2:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "What is that cape you're wearing");
                setNext(4);
                break;
            case DialogueConstants.OPTIONS_3_3:
                DialogueManager.sendPlayerChat(getPlayer(), Emotion.CALM, "Goodbye.");
                setNext(6);
                break;
            case DialogueConstants.OPTIONS_5_1:
                DialogueManager.sendItem4(getPlayer(), "Almost every tree can be chopped down. Normal logs", "will be produced by chopping 'Trees' and Oak logs will", "come from chopping 'Oak Trees' You can find Oak", "trees in amongst normal trees scatterd about the", 1511, 1521);
                break;
        }
        return false;

    }
}
