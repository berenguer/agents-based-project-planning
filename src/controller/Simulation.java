package controller;

import java.util.ArrayList;

import agent.Agent;
import task.Task;

public class Simulation {

    public int nbTour;

    public int deadline;

    public ArrayList<Agent> agents;

    public ArrayList<Task> mandatoryTasks;

    public ArrayList<Task> optionnalTasks;

    public Simulation(int deadline, ArrayList<Agent> agents,
            ArrayList<Task> mandatoryTasks, ArrayList<Task> optionnalTasks) {
        super();
        this.nbTour = 0;
        this.deadline = deadline;
        this.agents = agents;
        this.mandatoryTasks = mandatoryTasks;
        this.optionnalTasks = optionnalTasks;
    }
    
    public boolean mandatoryFinished() {
        for (int i = 0; i < this.mandatoryTasks.size(); i++) {
            if (!this.mandatoryTasks.get(i).isOver()) {
                return false;
            }
        }
        return true;
    }
    
    public boolean optionnalFinished() {       
        for (int i = 0; i < this.optionnalTasks.size(); i++) {
            if (!this.optionnalTasks.get(i).isOver()) {
                return false;
            }
        }
        return true;
    }
    
    public void run() {
        while (this.deadline > 0) {
            if (mandatoryFinished() & optionnalFinished()) {
                System.out.println("planning complete =)");
                break;
            } else {
                next();
            }
            this.deadline--;
        }
        if(mandatoryFinished())
        {
            System.out.println("Mandatory over =)");
        } else {
            System.out.println("you loose");
        }
    }

    public void next() {
        for (Agent agent : this.agents) {
            
            if ((agent.getTask() == null) || agent.getTask().isOver()) {
                hiringStrategy(agent);
                System.out.println("hiring");
            }
            agent.action();
        }
    }

    public void hiringStrategy(Agent agent) {
        float maxWorkUnit = 0f;
        int task = -1;
        if (agent.getTask() != null) {
            if (agent.getTask().isOver()) {
                agent.removeFromTask();
            }
        }

        // find a mandatory task free
        for (int i = 0; i < this.mandatoryTasks.size(); i++) {
            if ((this.mandatoryTasks.get(i).agents.size() < this.mandatoryTasks
                    .get(i).maximumDevelopers)
                    & (this.mandatoryTasks.get(i).workUnit > maxWorkUnit)) {
                maxWorkUnit = this.mandatoryTasks.get(i).workUnit;
                task = i;
            }
        }
        if (task != -1) {
            System.out.println("ass1");
            this.mandatoryTasks.get(task).attachDeveloper(agent);
        }
        // else find an optionnal task free
        else {
            for (int i = 0; i < this.optionnalTasks.size(); i++) {
                if ((this.optionnalTasks.get(i).agents.size() < this.optionnalTasks
                        .get(i).maximumDevelopers)
                        & (this.optionnalTasks.get(i).workUnit > maxWorkUnit)) {
                    maxWorkUnit = this.optionnalTasks.get(i).workUnit;
                    task = i;
                }
            }
            if (task != -1) {
                System.out.println("ass2");
                this.optionnalTasks.get(task).attachDeveloper(agent);
            }
        }

    }

}
