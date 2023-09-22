FROM ubuntu:20.04

# install java 20
COPY ./jdk-20_linux-x64_bin.deb java20.deb
RUN apt-get update && apt-get install -y ./java20.deb

# install the font
RUN apt-get install -y ttf-mscorefonts-installer fontconfig

ENV JAVA_HOME=/usr/lib/jvm/jdk-20

WORKDIR /app
COPY . .
EXPOSE 8080

# preinstall gradlew
RUN /app/gradlew check
ENTRYPOINT ["/app/gradlew", "bootRun"]



