FROM java:8

EXPOSE 8038

VOLUME /tmp

RUN mkdir /root/.m2

COPY . /root/cloud-file
WORKDIR /root/cloud-file

RUN ./mvnw package && ./mvnw install

CMD ./mvnw spring-boot:run
