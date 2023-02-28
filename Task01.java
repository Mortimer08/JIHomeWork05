/*
 * Реализуйте структуру телефонной книги с помощью HashMap,
 * учитывая, что 1 человек может иметь несколько телефонов.
 */
public class Task01 {

    public static void main(String[] args) {
        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add("Иван", "123");
        myPhoneBook.add("Иван", "432");
        myPhoneBook.showPhoneNumbers("Иван");
        myPhoneBook.add("Пётр", "098");
        myPhoneBook.showPhoneNumbers("Пётр");
        myPhoneBook.showPhoneNumbers("Сергей");
        myPhoneBook.showAll();
    }
}