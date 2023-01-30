package Model;

import java.util.ArrayList;

public class AgentsList {
    private ArrayList<ContactList> agentsList;

    public AgentsList(ArrayList<ContactList> agentsList) {
        this.agentsList = agentsList;
    }

    public ArrayList<ContactList> getAgentsList() {
        return agentsList;
    }
}
