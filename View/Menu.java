package View;

import java.util.ArrayList;
import java.util.Scanner;

import Model.Agent;
import Model.AgentsList;
import Model.Contact;
import Model.ContactList;
import Presenter.Presenter;

public class Menu {
    public Presenter presenter;

    public Menu(Presenter presenter) {
        this.presenter = presenter;
    }

    public ContactList searchAgent(Scanner sc) {
        ContactList searched = null;
        while (true) {
            System.out.println("Если хотите выбрать агента по номеру в списке, введите 1,");
            System.out.println("Если хотите найти агента через поиск, введите 2,");
            System.out.println("Если хотите вернуться в главное меню, введите 3:");
            String str = sc.nextLine();
            if (str.equals("1")) {
                while (true) {
                    System.out.println("Введите номер агента:");
                    try {
                        int index = Integer.parseInt(sc.nextLine());
                        searched = presenter.getAgentByIndex(index - 1);
                        break;
                    } catch (Exception e) {
                        System.out.println("Неверный ввод, попробуйте еще раз!");
                    }
                }
                break;
            } else if (str.equals("2")) {
                while (true) {
                    System.out.println("Введите строку для поиска:");
                    String searchedStr = sc.nextLine();
                    ContactList value = presenter.getAgentByString(searchedStr);
                    if (value != null) {
                        return value;
                    } else {
                        System.out.println("По заданным параметрам ничего не найдено, попробуйте еще раз!");
                    }
                    break;
                }
            } else if (str.equals("3")) {
                break;
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
            }
        }
        return searched;
    }

    public void addContact(ContactList contactList, Scanner sc) {
        System.out.println("Введите способ для связи (телефон, адрес, и т.д.):");
        String contactName = sc.nextLine();
        System.out.println("Введите сам контакт:");
        String contact = sc.nextLine();
        contactList.getList().add(new Contact(contactName, contact));
    }

    public void deleteContact(ContactList contactList, Scanner sc) {
        System.out.println("Введите номер контакта, который необходимо удалить:");
        int count = 0;
        for (Contact contact : contactList.getList()) {
            count++;
            System.out.println(count + ". " + contact);
        }
        try {
            int index = Integer.parseInt(sc.nextLine());
            contactList.getList().remove(index - 1);
        } catch (Exception e) {
            System.out.println("Неверный ввод, попробуйте еще раз!");
        }
    }

    public void addAgent(AgentsList agentsList, Scanner sc) {
        System.out.println("Введите ФИО человека/название компании и т.д.");
        String agentName = sc.nextLine();
        Agent agent = new Agent(agentName);
        System.out.println("Необходимо указать как минимум один контакт");
        System.out.println("Введите способ для связи (телефон, адрес, и т.д.):");
        String contactName = sc.nextLine();
        System.out.println("Введите сам контакт:");
        String contact = sc.nextLine();
        Contact newContact = new Contact(contactName, contact);
        ArrayList<Contact> list = new ArrayList<>();
        list.add(newContact);
        ContactList contactList = new ContactList(agent, list);
        agentsList.getAgentsList().add(contactList);
    }
}
