package ru.geekbrains.lesson8;

import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson8.models.TableModel;
import ru.geekbrains.lesson8.presenters.BookingPresenter;
import ru.geekbrains.lesson8.presenters.Model;
import ru.geekbrains.lesson8.presenters.View;
import ru.geekbrains.lesson8.views.BookingView;

import java.util.Date;
import java.util.Scanner;

public class Main {

    /**
     * TODO: ДОМАШНЕЕ ЗАДАНИЕ: Метод changeReservationTable ДОЛЖЕН ЗАРАБОТАТЬ!
     * @param args
     */
    public static void main(String[] args) {

        View view = new BookingView();
        Model model = new TableModel();
        BookingPresenter presenter = new BookingPresenter(model, view);

        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("*** Ресторан 888  ***");
            System.out.println("=======================");
            System.out.println("1. Бронь столика");
            System.out.println("2. Изменить бронь столика");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
            System.out.println("Доступные к брони столики");
            presenter.updateUIShowTables();
            System.out.println();
            System.out.print("Пожалуйста, выберите пункт меню: ");
            if (scanner.hasNextInt()) {
                int no = scanner.nextInt();
                scanner.nextLine();
                try {
                    switch (no) {
                        case 0:
                            System.out.println("Завершение работы приложения");
                            f = false;
                            break;
                        case 1:
                            System.out.print("Напишите ваше имя ");
                            String name = scanner.nextLine();
                            System.out.print("Напишите номер столика ");
                            int number = scanner.nextInt();

                            view.reservationTable(new Date(), number, name);
                            break;
                        case 2:
                            System.out.print("Напишите ваше имя ");
                            String name1 = scanner.nextLine();
                            System.out.print("Напишите номер старой брони ");
                            int noReserv = scanner.nextInt();
                            System.out.print("Напишите номер нового столика ");
                            int number1 = scanner.nextInt();

                            view.changeReservationTable(noReserv, new Date(), number1, name1);
                            break;
                        default:
                            System.out.println("Укажите корректный пункт меню.");
                    }
                } catch (Exception e) {
                    System.out.println(e.getMessage());
                }
            } else {
                System.out.println("Укажите корректный пункт меню.");
                scanner.nextLine();
            }
        }
    }

}
