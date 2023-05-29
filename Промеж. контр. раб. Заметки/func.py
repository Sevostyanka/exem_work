import datetime
import json

def start():
    try:
        base = load_base()
    except:
        base = create_base()
    return base

def create_base():
    notes = {"notes":[]}
    with open('file.json', 'w', encoding="UTF-8") as file:
        base = json.dump(notes,file)
    return base

# загрузка базы +
def load_base():
    with open("file.json", "r") as file:
        base = json.load(file)
    return base

base = start()

# показать меню +
def show_menu():
    global base
    print("\nМЕНЮ\n"
          "1. Найти заметку.\n"
          "2. Показать всю базу заметок.\n"
          "3. Показать названия заметок.\n"
          "4. Новая заметка.\n"
          "5. Выход.\n") 

# выбор пользователя +
def user_choise():
    num = int(input("Введите цифру пункта меню:_"))
    print("\n")
    return num

def switcher(a) -> int:
    match a:
        case 1: 
            # найти заметку
            note_ = find_note()
            if note_ == "0":
                exit
            else:
                print('ИЗМЕНИТЬ ЗАМЕТКУ?\n'
                  '"1" - Да\n'
                  '"2" - Нет')
                match user_choise():
                    case 1:
                        change_note(note_)
                        exit
                    case 2:
                        exit
                
        case 2: 
            # показать всю базу заметок +
            create_base()
            print_base()
        case 3:
            # показать названия заметок 
            print_names_of_notes()
        case 4:
            # создать новую заметку +
            new_note()      


# путь к файлу +
path = "file.json"   

# создание новой заметки +
def new_note():
    global base
    global path
    fields = ("id", "title", "text", "date and time")
    id = input("Введите уникальный id:_")
    title = input("Введите заголовок:_")
    text = input("Введите текст заметки:_")
    time = str(datetime.datetime.today().strftime("%d.%m.%Y %H:%M"))
    info = []
    info.append(id)
    info.append(title)
    info.append(text)
    info.append(time)
    note = dict(zip(fields, info))
    base.get("notes").append(note)
    
    with open (path, "w", encoding='UTF-8') as file:
        json.dump(base, file)
    print("Заметка добавлена.\n")
   

# вывод всех пунктов базы в консоль +
def print_base():
    global base
    if len(base.get("notes")) == 0:
        print("База пуста.")
    else:
        for item in base.get('notes'):
            print("")
            for k,v in item.items():
                print(f"{k}: {v},")


# вывод в консоль только названия и времени создания +
def print_names_of_notes():
    global base
    if len(base.get("notes")) == 0:
        print("Заметок нет")
    else:
        for item in base.get("notes"):
            print("")
            for k,v in item.items():
                if (k == "title") or (k == "date and time"):
                    print(f"{k}: {v},")
           

# поиск заметок с вариантами по id или названию
def find_note():
    global base
    if len(base.get("notes")) == 0:
        print("База заметок пуста.")
        return "0"
    else:
        print('ВАРИАНТ ПОИСКА:\n'
                '"1" - По id\n'
                '"2" - По названию')
    user_1 = input("Выберите вариант поиска:_")
    flag = False
    match user_1:
        case "1":
            user_choise_2 = input("Введите id:_")
            print("")
            for item in base.get("notes"):
                try:
                    for k,v in item.items():
                        if user_choise_2 == item.get("id"):
                            print_note(item)
                            return item
                except:
                    print("Такой заметки не нашлось.")   
                    return "0"
        case "2":
            user_choise_2 = input("Введите название:_")
            print("")
            for item in base.get("notes"):
                try:
                    for k,v in item.items():
                        if user_choise_2 == item.get("title"):
                            print_note(item)
                            return item
                except:
                    print("Такой заметки не нашлось.")   
                    return "0"

# вывести в консоль одну заметку со всей инфой +            
def print_note(note):
    for k,v in note.items():
        print(f"{k}: {v}")
      
# редактирование одной заметки
def change_note(note: dict):
    while True:
        print('РЕЖИМ РЕДАКТИРОВАНИЯ:\n'
            '"1" - Изменить название\n'
            '"2" - Изменить текст заметки\n'
            '"3" - Удалить заметку\n'
            '"4" - Сохранить изменения\n'
            '"5" - Закрыть режим редактирования\n')
        user_case = input("\nВыберите вариант:_")
        if user_case == "5":
            False
            break
        else:
            global base
            match user_case:
                case "1": #изменение названия
                    new_name = input("Новое название:_")
                    for item in base.get("notes"):
                        if note.get("title") == item.get("title"):
                            item["title"] = new_name
                            item["date and time"] = str(datetime.datetime.today().strftime("%d.%m.%Y %H:%M"))
                            print("Название изменено.\nНе забудьте сохранить изменения")
                case "2": #изменение текста
                    new_name = input("Новый текст:_")
                    for item in base.get("notes"):
                        if note.get("text") == item.get("text"):
                            item["text"] = new_name
                            item["date and time"] = str(datetime.datetime.today().strftime("%d.%m.%Y %H:%M"))
                            print("Текст изменен.\nНе забудьте сохранить изменения")
                case "3":
                    for item in base.get("notes"):
                        if note.get("id") == item.get("id"):
                            base.get("notes").remove(item)
                            print("ЗАМЕТКА БЫЛА УДАЛЕНА.\n Не забудьте сохранить изменения.")
                case "4":
                    with open (path, "w", encoding='UTF-8') as file:
                        json.dump(base, file)
                    print("ИЗМЕНЕНИЯ СОХРАНЕНЫ В ФАЙЛ.\n")
                    

               
        
 
    
    
        
    