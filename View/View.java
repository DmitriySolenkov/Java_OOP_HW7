package View;

import Model.Writer;
import java.util.ArrayList;
import java.util.Scanner;

import Model.Agent;
import Model.AgentsList;
import Model.Contact;
import Model.ContactList;
import Presenter.Presenter;

public class View {
    public static void main(String[] args) {
        Agent agent1 = new Agent("Пупкин Егор Павлович");
        Contact contact1Agent1 = new Contact("Мобильный телефон", "+375445645248");
        Contact contact2Agent1 = new Contact("Электронная почта", "pupkin@mail.ru");
        Contact contact3Agent1 = new Contact("Адрес", "Минск, пр-кт Дзержинского, 148-111");
        ArrayList<Contact> list1 = new ArrayList<>();
        list1.add(contact1Agent1);
        list1.add(contact2Agent1);
        list1.add(contact3Agent1);
        ContactList contactList1 = new ContactList(agent1, list1);

        Agent agent2 = new Agent("ООО 'Зеленоглазое такси'");
        Contact contact1Agent2 = new Contact("Голубиная почта", "Голубь Евгений");
        Contact contact2Agent2 = new Contact("Городской телефон", "+3752124443322");
        ArrayList<Contact> list2 = new ArrayList<>();
        list2.add(contact1Agent2);
        list2.add(contact2Agent2);
        ContactList contactList2 = new ContactList(agent2, list2);

        Agent agent3 = new Agent("Саня Сантехник");
        Contact contact1Agent3 = new Contact("Рабочий телефон", "+375295537661");
        Contact contact2Agent3 = new Contact("Адрес", "Синяя будка возле ст. метро 'Малиновка'");
        ArrayList<Contact> list3 = new ArrayList<>();
        list3.add(contact1Agent3);
        list3.add(contact2Agent3);
        ContactList contactList3 = new ContactList(agent3, list3);

        ArrayList<ContactList> agentsList = new ArrayList<>();
        agentsList.add(contactList1);
        agentsList.add(contactList2);
        agentsList.add(contactList3);
        AgentsList agents = new AgentsList(agentsList);
        Presenter presenter = new Presenter(agents);
        Menu menu = new Menu(presenter);

        System.out.println("Данные загружены");
        while (true) {
            System.out.println("Для отображения списка агентов введите 1,");
            System.out.println("Для отображения контактов определенного агента введите 2,");
            System.out.println("Для добавления нового агента введите 3,");
            System.out.println("Для удаления уже существующего агента введите 4,");
            System.out.println("Для сохранения данных и выхода из приложения введите 5:");
            Scanner sc = new Scanner(System.in, "cp866");
            String str = sc.nextLine();
            if (str.equals("1")) {
                presenter.printAgents();
            } else if (str.equals("2")) {
                ContactList searched = menu.searchAgent(sc);
                System.out.println(searched);
                while (true) {
                    System.out.println("Для добавления нового контакта введите 1,");
                    System.out.println("Для удаления существующего контакта введите 2,");
                    System.out.println("Для выхода в главное меню введите 3:");
                    String mode = sc.nextLine();
                    if (mode.equals("1")) {
                        menu.addContact(searched, sc);
                        System.out.println(searched);
                    } else if (mode.equals("2")) {
                        menu.deleteContact(searched, sc);
                        System.out.println(searched);
                    } else if (mode.equals("3")) {
                        break;
                    }
                }
            } else if (str.equals("3")) {
                menu.addAgent(agents, sc);
                presenter.printAgents();
            } else if (str.equals("4")) {
                ContactList searched = menu.searchAgent(sc);
                presenter.getAgentsList().getAgentsList().remove(searched);
                presenter.printAgents();

            } else if (str.equals("5")) {
                Writer writer = new Writer("AgentsList.txt");
                writer.writeFile(agents);
                break;
            } else {
                System.out.println("Неверный ввод, попробуйте снова");
            }
        }

    }

}