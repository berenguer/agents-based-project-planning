package controller;

import java.util.ArrayList;

import model.agent.Agent;
import model.task.Task;

public class LoggerSoup {
    
    public ArrayList<Agent> agents;

    public ArrayList<Task> mandatoryTasks;

    public ArrayList<Task> optionnalTasks;

    public LoggerSoup(ArrayList<Agent> agents, ArrayList<Task> mandatoryTasks,
            ArrayList<Task> optionnalTasks) {
        super();
        this.agents = agents;
        this.mandatoryTasks = mandatoryTasks;
        this.optionnalTasks = optionnalTasks;
    }
    
    public void printTaskOver(int nbTour) {
        int countMandatory = 0;
        int countOptionnal = 0;
        for (Task tata : this.mandatoryTasks) {
            if (tata.isOver()) {
                countMandatory++;
            }
        }
        for (Task toto : this.optionnalTasks) {
            if (toto.isOver()) {
                countOptionnal++;
            }
        }
        int nbTask = countMandatory + countOptionnal;
        System.out.println(nbTask);
    }

}
