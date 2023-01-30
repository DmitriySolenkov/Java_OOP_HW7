package Presenter;

import Model.AgentsList;
import Model.ContactList;

public class Presenter {
    private AgentsList agentsList;

    public Presenter(AgentsList agentsList) {
        this.agentsList = agentsList;
    }

    public AgentsList getAgentsList() {
        return agentsList;
    }

    public void printAgents() {
        int count = 1;
        for (ContactList contactList : agentsList.getAgentsList()) {
            System.out.println(count + ". " + contactList.getAgent());
            count++;
        }
    }

    public ContactList getAgentByIndex(int index) {
        return agentsList.getAgentsList().get(index);
    }

    public ContactList getAgentByString(String searchedStr) {
        for (ContactList contactList : agentsList.getAgentsList()) {
            if (contactList.getAgent().getName().contains(searchedStr)) {
                return contactList;
            }
        }
        return null;
    }

}
