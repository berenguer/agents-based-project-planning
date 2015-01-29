package controller;

import java.util.ArrayList;

import model.agent.Agent;
import model.task.Task;

public class Main {

    public static void main(String[] args) {

        ArrayList<Agent> agents = new ArrayList<Agent>(4); 
        for (int i = 0; i < 4; i++) {
            Agent agent = new Agent();
            agents.add(agent);
        }
        
        ArrayList<Task> mandatoryTasks = new ArrayList<Task>(8);
        for (int i = 0; i < 8; i++) {
            mandatoryTasks.add(new Task(5, true, 3));
        }
        
        ArrayList<Task> optionnalTasks = new ArrayList<Task>(20);
        for (int i = 0; i < 20; i++) {
            Task optTask = new Task(3, false, 3);
            optionnalTasks.add(optTask);
        }
        Simulation simulation = new Simulation(40, agents, mandatoryTasks, optionnalTasks);
        simulation.run();
        
    }
    
}
