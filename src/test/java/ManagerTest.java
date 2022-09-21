import org.junit.jupiter.api.Assertions;

import org.junit.jupiter.api.Test;


public class ManagerTest {
    protected int id;
    protected int t;

    @Test
    public void testAdd() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket("Москва", "Казань", 1299, 12, 95);
        Ticket ticket2 = new Ticket("Москва", "Казань", 1399, 9, 95);
        Ticket ticket3 = new Ticket("Москва", "Казань", 1499, 15, 95);
        Ticket ticket4 = new Ticket("Москва", "Казань", 1099, 120, 95);
        Ticket ticket5 = new Ticket("Москва", "Казань", 1199, 110, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = repo.findAll();
        Ticket[] expected = {ticket1, ticket2, ticket3, ticket4, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testRemoveById() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket("Москва", "Казань", 1299, 12, 95);
        Ticket ticket2 = new Ticket("Москва", "Казань", 1399, 9, 95);
        Ticket ticket3 = new Ticket("Москва", "Казань", 1499, 15, 95);
        Ticket ticket4 = new Ticket("Москва", "Казань", 1099, 120, 95);
        Ticket ticket5 = new Ticket("Москва", "Казань", 1199, 110, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = repo.removeById(ticket2.getId());
        Ticket[] expected = {ticket1, ticket3, ticket4, ticket5};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testSearchBy() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket("Москва", "Казань", 1299, 12, 95);
        Ticket ticket2 = new Ticket("Санкт-Питербург", "Казань", 1399, 9, 95);
        Ticket ticket3 = new Ticket("Москва", "Казань", 1499, 15, 95);
        Ticket ticket4 = new Ticket("Москва", "Краснодар", 1099, 120, 95);
        Ticket ticket5 = new Ticket("Москва", "Казань", 1199, 110, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);

        Ticket[] actual = manager.searchBy("Москва", "Казань");
        Ticket[] expected = {ticket5, ticket1, ticket3};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindById() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket("Москва", "Казань", 1299, 12, 95);
        Ticket ticket2 = new Ticket("Москва", "Казань", 1399, 9, 95);
        Ticket ticket3 = new Ticket("Москва", "Казань", 1499, 15, 95);
        Ticket ticket4 = new Ticket("Москва", "Казань", 1099, 120, 95);
        Ticket ticket5 = new Ticket("Москва", "Казань", 1199, 110, 95);

        manager.add(ticket1);
        manager.add(ticket2);
        manager.add(ticket3);
        manager.add(ticket4);
        manager.add(ticket5);


        Ticket[] actual = repo.getId(ticket2.getId());
        Ticket[] expected = new Ticket[9];

        Assertions.assertArrayEquals(expected, actual);


    }

    @Test
    public void testNotTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket("Москва", "Казань", 1299, 12, 95);
        Ticket ticket2 = new Ticket("Москва", "Казань", 1399, 9, 95);
        Ticket ticket3 = new Ticket("Москва", "Казань", 1499, 15, 95);


        Ticket[] actual = repo.findAll();
        Ticket[] expected = {};

        Assertions.assertArrayEquals(expected, actual);
    }

    @Test
    public void testFindTicket() {
        Repository repo = new Repository();
        Manager manager = new Manager(repo);

        Ticket ticket1 = new Ticket("Москва", "Казань", 1299, 12, 95);
        Ticket ticket2 = new Ticket("Москва", "Казань", 1399, 9, 95);
        Ticket ticket3 = new Ticket("Москва", "Казань", 1499, 15, 95);


        Ticket[] actual = repo.add(ticket2);
        Ticket[] expected = {ticket2};

        Assertions.assertArrayEquals(expected, actual);
    }

}
