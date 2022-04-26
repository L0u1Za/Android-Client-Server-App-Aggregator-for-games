import psycopg2
from psycopg2 import Error
from psycopg2.extensions import ISOLATION_LEVEL_AUTOCOMMIT


class RemoveApp:
    def __init__(self, name="", url="", desc="", id=None):
        self.db_name = 'postgres_db'
        self.name = name
        self.url = url
        self.desc = desc
        self.id = id
        self.connect()
        self.info()
        self.remove()
        self.disconnect()

    def connect(self):
        try:
            # Подключение к существующей базе данных
            self.connection = psycopg2.connect(user="postgres",
                                            # пароль, который указали при установке PostgreSQL
                                            password="Luizyaka123",
                                            host="127.0.0.1",
                                            port="5433",
                                            database=self.db_name)
            self.connection.set_isolation_level(ISOLATION_LEVEL_AUTOCOMMIT)
            self.cursor = self.connection.cursor()
            create_table_query = f'CREATE TABLE {self.db_name} (ID INT PRIMARY KEY NOT NULL, name TEXT NOT NULL, url TEXT, description TEXT);'
            # Выполнение команды: это создает новую таблицу
            self.cursor.execute(create_table_query)
            self.connection.commit()
            print("Таблица успешно создана в PostgreSQL")
        except (Exception, Error) as error:
            print("Ошибка при работе с PostgreSQL", error)
        else:
            print("Успешное подключение")

    def disconnect(self):
        if self.connection:
            self.cursor.close()
            self.connection.close()
            print("Соединение с PostgreSQL закрыто")
    
    def info(self):
        print("Информация о сервере PostgreSQL")
        print(self.connection.get_dsn_parameters(), "\n")

    def remove(self):
        if (self.id is not None):
            delete_query = f"Delete from {self.db_name} where id = {self.id}"
        else:
            return
        self.cursor.execute(delete_query)
        self.connection.commit()
        print("Запись успешно удалена")
        # Получить результат
        self.cursor.execute(f"SELECT * from {self.db_name} ORDER BY ID DESC LIMIT 5")
        record = self.cursor.fetchall()
        print("Результат", record)

RemoveApp(id=3)