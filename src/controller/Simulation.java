package controller;

import java.util.ArrayList;
import java.util.Random;

import model.agent.Agent;
import model.task.Task;

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
        for (Task task : this.mandatoryTasks) {
            estimateWorkStrategy(task);
        }
    }
    
    public void estimateWorkStrategy(Task task) {
        Random random = new Random();
        int signe = random.nextInt(2);
        float delay = random.nextFloat();
        if (signe == 1) {
            task.updateWork(task.workUnit + delay);
        } else {
            task.updateWork(task.workUnit - delay);
        }
    }

    public void hiringStrategy(Agent agent) {
        float maxWorkUnit = 0f;
        Task task = null;
        if (agent.getTask() != null) {
            if (agent.getTask().isOver()) {
                agent.removeFromTask();
            }
        }

        // find a mandatory task free
        for (int i = 0; i < this.mandatoryTasks.size(); i++) {
            if ((this.mandatoryTasks.get(i).agents.size() < this.mandatoryTasks.get(i).maximumDevelopers)
                    & (this.mandatoryTasks.get(i).workUnit > maxWorkUnit)) {
                maxWorkUnit = this.mandatoryTasks.get(i).workUnit;
                task = this.mandatoryTasks.get(i);
            }
        }
        if (task != null) {
            agent.attachTask(task);
            task.attachDeveloper(agent);
        }
        // else find an optionnal task free
        else {
            for (int i = 0; i < this.optionnalTasks.size(); i++) {
                if ((this.optionnalTasks.get(i).agents.size() < this.optionnalTasks
                        .get(i).maximumDevelopers)
                        & (this.optionnalTasks.get(i).workUnit > maxWorkUnit)) {
                    maxWorkUnit = this.optionnalTasks.get(i).workUnit;
                    task = this.optionnalTasks.get(i);
                }
            }
            if (task != null) {
                agent.attachTask(task);
                task.attachDeveloper(agent);
            }
        }

    }

}
