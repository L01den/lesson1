package ru.geekbrains.lesson6;

import ru.geekbrains.lesson6.database.NotesDatabase;
import ru.geekbrains.lesson6.notes.core.application.ConcreteNoteEditor;
import ru.geekbrains.lesson6.notes.core.domain.Note;
import ru.geekbrains.lesson6.notes.infrastructure.persistance.NotesDbContext;
import ru.geekbrains.lesson6.notes.presentation.queries.controllers.NotesController;
import ru.geekbrains.lesson6.notes.presentation.queries.views.NotesConsolePresenter;

import java.util.Date;
import java.util.Scanner;


public class Program {

    public static void main(String[] args) {
        NotesController controller = new NotesController(
                new ConcreteNoteEditor(new NotesDbContext(new NotesDatabase()), new NotesConsolePresenter()));

        Scanner scanner = new Scanner(System.in);
        boolean f = true;
        while (f) {
            System.out.println("*** ЗАМЕТКИ ***");
            System.out.println("=======================");
            System.out.println("1. Посмотреть все заметки");
            System.out.println("2. Добавить заметку");
            System.out.println("0. ЗАВЕРШЕНИЕ РАБОТЫ ПРИЛОЖЕНИЯ");
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
                            controller.routeGetAll();
                            break;
                        case 2:
                            System.out.print("Напишите текст заметки ->  ");
                                String text = scanner.nextLine();
                                Note note = new Note(101, 001, "Name", text, new Date());
                                controller.routeAddNote(note);
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
