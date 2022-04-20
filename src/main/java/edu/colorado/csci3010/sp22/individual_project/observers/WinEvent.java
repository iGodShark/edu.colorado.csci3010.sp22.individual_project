package edu.colorado.csci3010.sp22.individual_project.observers;

import edu.colorado.csci3010.sp22.individual_project.model.Player;

public class WinEvent extends Event {
    private Player player;

    public WinEvent(Player p) {
        this.player = p;
    }

    public Player getPlayer() {
        return this.player;
    }
}
