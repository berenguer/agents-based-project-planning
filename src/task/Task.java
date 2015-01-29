package task;

import java.util.ArrayList;

import agent.Agent;

public class Task {

    public float workUnit;
    
    public int maximumDevelopers;
    
    public ArrayList<Agent> agents;
    
    public boolean isOptionnal;
    
    public Task(float workUnit, boolean isOptionnal, int maximumDevelopers) {
        super();
        this.workUnit = workUnit;
        this.maximumDevelopers = maximumDevelopers;
        this.agents = new ArrayList<Agent>(maximumDevelopers);
        this.isOptionnal = isOptionnal;
    }

    public void develop(float workUnit) {
        this.workUnit = this.workUnit - workUnit;
    }
    
    public boolean isOver() {
        return this.workUnit <= 0;
    }
    
    public boolean isFull() {
        return this.agents.size() == this.maximumDevelopers;
    }
    
    public void attachDeveloper(Agent agent) {
        this.agents.add(agent);
    }

}
