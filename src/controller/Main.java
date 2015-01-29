package controller;

import java.util.ArrayList;

import model.agent.Agent;
import model.task.Task;

public class Main {

    public static void main(String[] args) {

        ArrayList<Agent> agents = new ArrayList<Agent>(8); 
        for (int i = 0; i < 8; i++) {
            Agent agent = new Agent();
            agents.add(agent);
        }

        ArrayList<Task> mandatoryTasks = new ArrayList<Task>(3);
        mandatoryTasks.add(new Task(5, true, 3));
        mandatoryTasks.add(new Task(5, true, 3));
        mandatoryTasks.add(new Task(5, true, 3));
        
        ArrayList<Task> optionnalTasks = new ArrayList<Task>(3);
        for (int i = 0; i < agents.size(); i++) {
            Task optTask = new Task(2, false, 3);
            optionnalTasks.add(optTask);
        }
        Simulation simulation = new Simulation(180, agents, mandatoryTasks, optionnalTasks);
        simulation.run();
        
    }
    
}
