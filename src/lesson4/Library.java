package lesson4;

import java.util.Arrays;

public class Library {
    private Book[] books = new Book[10];

    // в библиотеку можно добавить одну книгу
    public void addBook(Book newBook){
        for (int i = 0; i < this.books.length; i++) {
            if (this.books[i] == null) {
                this.books[i] = newBook;
                break; // return;
            }
        }
    }

    // в библиотеку можно добавить сразу несколько книг
    public void addBook(Book ...newBooks) {
         for (int i = 0; i < this.books.length; i++) {
             if (this.books[i] == null) {
                 System.arraycopy(newBooks, 0, this.books,
                         i, newBooks.length);
                 break;
             }
         }
    }

    /*должна быть возможность получить информацию по книге,
    указав ее название
            (получаемая информация: автор, название,
             можно ли забрать домой, доступна ли книга)
    если книга не нйдена, сообщаем, что такой книги нет*/

    public String getInfo(String title) {
        return "Книга найдена. Название: . Автор: . " +
                  "Доступна в читальном зале/для выдачи на дом." +
                  "Для выдачи доступна/пока недоступна";
    }

    // должна быть возможность взять книгу на дом, указав название
    public Book takeHome(String title) {
        Book returnBook = null;

        return returnBook;
    }

    public Book[] getBooks() {
        return books;
    }

    public void setBooks(Book[] books) {
        this.books = books;
    }

    @Override
    public String toString() {
        return "Library{" +
                "books=" + Arrays.toString(books) +
                '}';
    }

}
