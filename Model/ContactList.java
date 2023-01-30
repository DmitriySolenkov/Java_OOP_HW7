package Model;

import java.util.ArrayList;

public class ContactList {
    private Agent agent;
    private ArrayList<Contact> list;

    public ContactList(Agent agent, ArrayList<Contact> list) {
        this.agent = agent;
        this.list = list;
    }

    public Agent getAgent() {
        return agent;
    }

    public ArrayList<Contact> getList() {
        return list;
    }

    @Override
    public String toString() {
        StringBuffer sb = new StringBuffer();
        sb.append(agent.toString() + "\n");
        for (Contact contact : list) {
            sb.append("     " + contact.toString() + "\n");
        }
        return sb.toString();
    }

}
