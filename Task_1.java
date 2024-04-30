import java.util.HashMap;
import java.util.HashSet;
import java.util.SortedSet;
import java.util.TreeSet;

class PhoneBook {
    
  private static HashMap<String, HashSet<Integer>> phoneBook = new HashMap<>();
  
  // Инициализация нового имени в телефонной книге
  public void initial(String name) {
    HashSet<Integer> values = new HashSet<Integer>();
    phoneBook.put(name, values);

  }

  // Добавление телефонного номера
  public void add(String name, Integer phoneNum) {
    if (phoneBook.get(name) == null) { initial(name); }
    phoneBook.get(name).add(phoneNum);
    
  }

  // Поиск имени в телефонной книги. Вывод в HashSet.
  public HashSet<Integer> find(String name) {
    if (phoneBook.get(name) == null) { 
      return new HashSet<Integer>(); 
    } else {
      return phoneBook.get(name);
    }

  }

  // Поиск имени в телефонной книги. Вывод в String.
  public String findString(String name) {
    
    String resString = "";
    Integer resInt = 1;
    
    if (phoneBook.get(name) == null) { 
      resString = "Для имени '" + name + "' не найдены телефонные номера."; 
    } else {
      resString = "Для имени '" + name + "' найдены следующие телефонные номера:";
      for (Integer item: phoneBook.get(name)) {
        resString += "\n" + resInt.toString() + ": " + item.toString();
        resInt += 1;
      }
    }
    
    return resString;

  }
   
  // Возврат всей структуры телефонной книги
  public static HashMap<String, HashSet<Integer>> getPhoneBook() {
    return phoneBook;
  }

  // Возврат всей телефонной книги с сортировкой по количеству телефонов
  public String getPhoneBookString() {
    
    HashMap<Integer, HashSet<String>> phoneBookVol = new HashMap<>();
    SortedSet<Integer> SortedVol = new TreeSet<Integer>(java.util.Collections.reverseOrder());
    
    Integer vol;

    for (String nameItem: phoneBook.keySet()) {
      
      vol = phoneBook.get(nameItem).size();
      
      if (phoneBookVol.get(vol) == null) {
        phoneBookVol.put(vol, new HashSet<String>()); 
      }
      
      phoneBookVol.get(vol).add(nameItem);

      SortedVol.add(vol);

    }

    String resString = "Содержание телефонной книги с сортировкой по убыванию числа телефонов: ";
    
    for (Integer item_1: SortedVol) {
      
      for (String item_2: phoneBookVol.get(item_1)) {
        resString += "\n" + findString(item_2);
      }
    
    }
   
    return resString;
    
  }

}

public class Task_1 {
    public static void main(String[] args) {
        String name1;
        String name2;
        String name3;
        String name4;
        int phone1;
        int phone2;
        int phone3;
        int phone4;

        if (args.length == 0) {
            name1 = "Ivanov";
            name2 = "Petrov";
            name3 = "Averieyanova";
            name4 = "Vasnytsova";
            phone1 = 123456;
            phone2 = 654321;
            phone3 = 987654;
            phone4 = 567890;
        } else {
            name1 = args[0];
            name2 = args[1];
            name3 = args[2];
            name4 = args[3];
            phone1 = Integer.parseInt(args[3]);
            phone2 = Integer.parseInt(args[4]);
            phone3 = Integer.parseInt(args[5]);
            phone4 = Integer.parseInt(args[6]);
        }

        PhoneBook myPhoneBook = new PhoneBook();
        myPhoneBook.add(name1, phone1);
        myPhoneBook.add(name1, phone2);
        myPhoneBook.add(name2, phone2);
        myPhoneBook.add(name3, phone1);
        myPhoneBook.add(name3, phone2);
        myPhoneBook.add(name3, phone3);
        myPhoneBook.add(name4, phone3);
        myPhoneBook.add(name4, phone4);

        System.out.println("> Поиск одного имени в телефонной книге: ");
        System.out.println(myPhoneBook.findString(name1));
        System.out.println("> --------- ");
        System.out.println("> Вывод всех имен из телефонной книги: ");
        System.out.println(myPhoneBook.getPhoneBookString());
        System.out.println("> --------- ");
        System.out.println("> Поиск несуществующего имени в телефонной книге: ");
        System.out.println(myPhoneBook.findString("Me"));
        System.out.println("> --------- ");
      }
}