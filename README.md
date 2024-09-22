## 컴파일

`javac -d .\class\ .\src\academy\pocu\HelloPocu.java`

## 실행 

`java -classpath .\class\ academy.pocu.HelloPocu`

`java -jar .\lib\hellopocu.jar`

## 라이브러리

`jar -cfm .\lib\hellopocu.jar .\src\Manifest.txt -C .\class\ .`
