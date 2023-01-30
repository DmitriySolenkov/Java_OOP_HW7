package Model;

import java.io.FileWriter;
import java.io.IOException;

public class Writer {
    private String pathFile;

    public Writer(String pathFile) {
        this.pathFile = pathFile;
    }

    public void writeFile(AgentsList agentsList) {
        try (FileWriter fw = new FileWriter(pathFile, false)) {
            for (ContactList contactList : agentsList.getAgentsList()) {
                fw.append(contactList.toString());
                fw.append("\n---\n");
            }
            fw.append("\n");
            fw.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }
}
