package model.task;

import java.util.ArrayList;

import model.agent.Agent;

public class Task {

    /**
     * The equivalent of one man-week necessary.
     */
    public float workUnit;
    
    public int maximumDevelopers;
    
    public ArrayList<Agent> agents;
    
    public boolean isMandatory;
    
    public boolean isOver;
    
    public Task(float workUnit, boolean isMandatory, int maximumDevelopers) {
        super();
        this.workUnit = workUnit;
        this.maximumDevelopers = maximumDevelopers;
        this.agents = new ArrayList<Agent>(maximumDevelopers);
        this.isMandatory = isMandatory;
        this.isOver = false;
    }
    
    public void updateWork(float workUnit) {
        if (!isOver()) {
            this.workUnit = workUnit;
        }
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
