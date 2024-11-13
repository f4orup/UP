# Computer Club
Приложение создано для учета работ компьютерного клуба

### Основные функции:
- Разграничение прав доступа
- Создание сессий пользователям
- Учет брони на определенное место
- Просмотр всех активных сессий
- Учет магазина клуба
- Просмотр зарегистрированных пользователей
- Разделение пользователей: Админы и посетители клуба

### Примечание:
Пользователь не может зайти в свой аккаунт без баланса. Нужно с аккаунта админа создать сессию для этого пользователя, после чего вход будет успешным

### Порядок действий:
1) BD
- Создать папку, куда будет загружен проект
- В папке shift + ПКМ -> PowerShell
- ```git clone https://github.com/f4orup/UP.git```
- ```cd UP-master/database/```
- ```docker compose up```
2) Java APP
- Открыть IntelliJ IDEA
- file -> Open -> Путь до вашей папки, куда сохраняли проект
- ПКМ по контроллеру в директории libs -> Add as lib
- Прочитать примечание выше
- Открыть класс HelloAplication -> Скомпилировать проект

  