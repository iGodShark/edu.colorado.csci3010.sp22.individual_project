package edu.colorado.csci3010.sp22.individual_project.observers;

public interface Observable {
    void addListener(Listener l);
    void removeListener(Listener l);
    void updateListeners(Event e);
}