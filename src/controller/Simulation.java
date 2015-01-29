package controller;
import java.util.ArrayList;
import java.util.Collections;

import agent.Agent;
import task.Task;


public class Simulation {
    
    public int nbTour;
    
    public int deadline;
    
    public ArrayList<Agent> agents;
    
    public ArrayList<Task> tasks;
    
    public Simulation(int deadline, ArrayList<Agent> agents,
            ArrayList<Task> tasks) {
        super();
        this.nbTour = 0;
        this.deadline = deadline;
        this.agents = agents;
        this.tasks = tasks;
    }
    
    public void next() {
        for (Agent agent : this.agents) {
            agent.action();
        }
    }

}
