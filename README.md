# cft_test_server
Java 11.0.10 Maven 3.6.3

Задание:

Сервер: Java, 3 API.
1.	GET, получить список файлов на сервере в папке /tmp
2.	GET, получить по имени файла из папки /tmp файл
3.	PUT, положить файл в папку /tmp
Собрать в Docker. Командой через docker-compose должен подниматься контейнер, к которому можно обращаться по API


----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Api:

-http://localhost:8080/api/allFiles -получить Список файлов GET-method - public List<File> listOfFiles()

-http://localhost:8080/api/getFile/{fileName} - Получить файл GET-method - public Resource download(@PathVariable("fileName") String fileName)

-http://localhost:8080/api/putFile/{fileName} - Отдать файл PUT-method -  public ResponseEntity<Void> upload(@RequestBody Resource resource, @PathVariable("fileName")

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
Сценрий:

-Получить список файлов. Обращается к серверу, получает список файлов, выводит на экран список: java -jar / app.jar / get_files_list

-Записать на сервер файл. Обращается к серверу, отдает файл на запись, выводит результат Ок/НеОк: java -jar / app.jar / put_file / local_file_name

-Прочитать файл с сервера и записать на клиента. Обращается к серверу, получает файл по имени, записывает по указанному пути: java -jar / app.jar / get_file / server_file_name / local_file_name

----------------------------------------------------------------------------------------------------------------------------------------------------------------------------
cmd cli : https://github.com/NaybaVladimir/cft_test_client/tree/master