package controller;

import java.util.ArrayList;

import agent.Agent;
import task.Task;

public class Main {

    public static void main(String[] args) {
        ArrayList<Agent> agents = new ArrayList<Agent>(10);
        for (int i = 0; i < agents.size(); i++) {
            Agent agent = new Agent();
            agents.add(agent);
        }
        ArrayList<Task> tasks = new ArrayList<Task>(3);
        tasks.add(new Task(10, false, 3));
        tasks.add(new Task(10, false, 3));
        tasks.add(new Task(10, false, 3));
        
        Simulation simulation = new Simulation(20, agents, tasks);
    }

}
