package controllers;

import actions.SonicStanding;
import actions.SonicStarting;
import graphics.GraphicEngine;

import java.awt.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class KeyboardController implements KeyListener {

    GraphicEngine target;

    public KeyboardController(GraphicEngine target){
        this.target = target;
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_S){
            target.sonic.loadNewAction(new SonicStarting(target.sonic));
        }

    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
