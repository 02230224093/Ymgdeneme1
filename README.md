Var olan java spring projesini klonlayıp içerisine bir şeyler atma 
1.	Git clone repoAdı
2.	cd projeAdi    bu ikisi de gerçek isimle olsun .
3.	mvn clean package -DskipTests
4.	Dockerfile oluşturmak için ;
touch Dockerfile 
nano Dockerfile 
 içine şu kodu  düzenleyip at
### Temel image
FROM openjdk:17-jdk-slim

 ###Jar dosyasını container içine kopyala
COPY target/proje-adi.jar app.jar

### Uygulamayı başlat
ENTRYPOINT ["java", "-jar", "/app.jar"] 

Kaydetmek için ctrl+o enter çıkmak için ctrl+x

5.	Daha sonra bir docker-compose.yml oluşturacağız
touch docker-compose.yml
nano docker-compose.yml
içine şu kodu düzenleyip at
version: '3.8'
services:
  postgres:
    image: postgres:15
    container_name: postgres_db
    restart: always
    environment:
      POSTGRES_DB: mydb
      POSTGRES_USER: user
      POSTGRES_PASSWORD: password
    ports:
      - "5432:5432"
    volumes:
      - pgdata:/var/lib/postgresql/data

  app:
    build: .
    container_name: spring_app
    depends_on:
      - postgres
    ports:
      - "8080:8080"
    environment:
      SPRING_DATASOURCE_URL: jdbc:postgresql://postgres:5432/mydb
      SPRING_DATASOURCE_USERNAME: user
      SPRING_DATASOURCE_PASSWORD: password

volumes:
  pgdata:

6.	Application properties kısmını düzeltelim
cd src/main/resources 
               nano application.properties
bunda da gerekli düzenlemeleri hallet
7.	Ana klasör dizinine dön
 cd ~/projeadı

8.	docker-compose up - - build yap 
bundan sonra çalışması lazım . Yoksa jar isimlerini ve port çakışmalarını kontrol etmeye git. 
ls target/ yapıp jar isimlerine bak ve docker-compose.yml içine yanlışsa eğer jar ismini düzeltmeye git

Şimdi githuba atalım :
cd ~/projeadı
git init
git add .
git commit –m”ilk commit”
git remote add origin repourl 
git push –u origin main 

Remote origin already exists derse
git remote –v
git remote remove origin
git remote add origin repourl
git push –u origin main 
