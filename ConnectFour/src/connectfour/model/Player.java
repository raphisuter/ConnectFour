/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package connectfour.model;

import java.awt.Color;

/**
 *
 * @author Alex
 */
public class Player {
    
    private int id;
    
    private String name;
    
    private Color color;

    public Player(int id, String name, Color color) {
        this.id = id;
        this.name = name;
        this.color = color;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void setColor(Color color) {
        this.color = color;
    }
    
    public Color getColor() {
        return color;
    }
    
    public static Player createPlayer1() {
        return new Player(1, "Spieler 1", Color.red);
    }
    
    public static Player createPlayer2() {
        return new Player(2, "Spieler 2", Color.yellow);
    }
    
}
