package controller;

import java.util.ArrayList;

import model.agent.Agent;
import model.task.Task;

public class Main {

    public static void main(String[] args) {

        ArrayList<Agent> agents = new ArrayList<Agent>(2); 
        for (int i = 0; i < 2; i++) {
            Agent agent = new Agent();
            agents.add(agent);
        }
        
        ArrayList<Task> mandatoryTasks = new ArrayList<Task>(12);
        for (int i = 0; i < 8; i++) {
            mandatoryTasks.add(new Task(5, true, 3));
        }
        
        ArrayList<Task> optionnalTasks = new ArrayList<Task>(30);
        
        for (int i = 0; i < 30; i++) {
            Task optTask = new Task(3, false, 3);
            optionnalTasks.add(optTask);
        }

        Simulation simulation = new Simulation(30, agents, mandatoryTasks, optionnalTasks);
        simulation.run();
        
    }
    
}
