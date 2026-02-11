package it.unibo.goldhunt.engine.api;

/**
 * Represents the effect produced by an action executed during tha game.
 * 
 * An {@code ActionEffect} describes how the game state was impacted.
 */
public enum ActionEffect {

    /**
     * The action has been successfully applied.
     */
    APPLIED,
    
    
    REMOVED,
    
    
    BLOCKED,
    
    
    INVALID,
    
    
    NONE;
}
