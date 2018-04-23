package ru.softwerke.controller.sort;

import ru.softwerke.controller.InitController;
import ru.softwerke.model.Client;
import ru.softwerke.model.dao.ClientList;
import ru.softwerke.tools.ReadWriter;
import ru.softwerke.tools.comparators.client.ClientBDayComparator;
import ru.softwerke.tools.comparators.client.ClientNameComparator;
import ru.softwerke.tools.comparators.client.ClientSurnameComparator;

import java.util.Comparator;
import java.util.TreeSet;

public class ClientSortController extends InitController {
    private static ClientSortController clientSortController = new ClientSortController();

    public ClientSortController() {}

    public static ClientSortController getClientSortController() {
        return clientSortController;
    }

    public void sortByName() {
        Comparator<Client> comparator1 = new ClientNameComparator();
        clientSortController.sorter(comparator1);
    }


    public void sortBySurname() {
        Comparator<Client> comparator2 = new ClientSurnameComparator();
        clientSortController.sorter(comparator2);
    }

    public void sortByBDay() {
        Comparator<Client> comparator3 = new ClientBDayComparator();
        clientSortController.sorter(comparator3);
    }

    private void sorter(Comparator<Client> comparator) {
        TreeSet<Client> clients1 = new TreeSet<>(comparator);
        ClientList.getClientsList().forEach(s -> clients1.add(s));
        for (Client client: clients1) {
            ReadWriter.printLine(client);
        }
        initMenu.showInitMenu();
    }
}