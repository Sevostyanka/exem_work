import func

func.start()

while True:
    func.show_menu()
    a = func.user_choise()
    func.switcher(a)
    
    if a == 5:
        print("ЗАВЕРШЕНИЕ РАБОТЫ")
        False
        break
    
