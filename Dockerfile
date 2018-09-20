FROM java:8

EXPOSE 8038

RUN mkdir /root/.m2
COPY ./maven-settings.xml /root/.m2/settings.xml

COPY . /root/cloud-file
WORKDIR /root/cloud-file

RUN unzip -o -d src/main/resources/fonts libs/fonts.zip && rm libs/fonts.zip
RUN ./mvnw package && ./mvnw install

CMD ./mvnw spring-boot:run

