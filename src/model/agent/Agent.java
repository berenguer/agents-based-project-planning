package model.agent;
import model.task.Task;


public class Agent {
    /**
     * The tash where the agent works
     */
    public Task task;

    /**
     * to know if this agent is new on a task
     * (if 0 it's the  training phase ALLELUJA)
     */
    public float workUnit;
    
    /**
     * the umber of work unit bring in all task
     * (just for fun)
     */
    public float workUnitAll;
    
    public Agent() {
        // nothing
    }
    
    public Agent(Task task) {
        super();
        this.task = task;
        this.workUnit = 0.5f;
        this.workUnitAll = 0f;
    }

    public void action() {
        if (this.task != null) {
            this.task.develop(this.workUnit);
            this.workUnitAll = this.workUnitAll + this.workUnit;
            this.workUnit = 1;   
        }
    }
    
    public Task getTask() {
        return this.task;
    }

    public void attachTask(Task task) {
        this.task = task;
        this.workUnit = 0.5f;
    }
    
    public void removeFromTask() {
        this.task.agents.remove(this);
        this.task = null;
    }

}
