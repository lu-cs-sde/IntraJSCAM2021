FROM ubuntu:18.04

RUN apt-get update
RUN rm /bin/sh && ln -s /bin/bash /bin/sh
RUN apt install software-properties-common -y
RUN add-apt-repository ppa:deadsnakes/ppa


RUN ln -snf /usr/share/zoneinfo/$CONTAINER_TIMEZONE /etc/localtime && echo $CONTAINER_TIMEZONE > /etc/timezone


RUN apt-get update && apt-get -y install \
    bash \
    zsh \
    git \
    curl \
    unzip \
    zip \
    python3.9 \
    python3-pip\
    bc\
    sudo

RUN apt-get install -y locales locales-all
ENV LC_ALL en_US.UTF-8
ENV LANG en_US.UTF-8
ENV LANGUAGE en_US.UTF-8


RUN useradd -ms /bin/bash SCAM2021



RUN zsh

RUN sudo ln -s /usr/bin/pip3 /usr/bin/pip
RUN sudo ln -s /usr/bin/python3.9 /usr/bin/python



RUN mkdir -p /workspace
RUN cd workspace && git clone https://github.com/lu-cs-sde/IntraJSCAM2021.git intraj
RUN pip install 'numpy==1.19.5' 'pandas==1.1.5' 'matplotlib==3.3.4' 'seaborn==0.11.1' 'ipython==7.16.0' 'PyPDF2==1.26.0'
ENV SDKMAN_DIR=/home/SCAM2021/.sdkman

RUN curl -s "https://get.sdkman.io" | bash
RUN  bash -c "source $SDKMAN_DIR/bin/sdkman-init.sh && sdk install java 11.0.9.fx-zulu  && sdk install java 7.0.292-zulu && cd workspace/intraj && sdk use java 7.0.292-zulu &&./gradlew build"
ENV JAVA_HOME="$SDKMAN_DIR/candidates/java/current"
ENV PATH="$JAVA_HOME/bin:~/.sdkman:$PATH"



RUN chmod 777 /workspace/**/*
RUN echo "SCAM2021:SCAM2021" | chpasswd && adduser SCAM2021 sudo
RUN chown -R SCAM2021 /workspace/
RUN chown -R SCAM2021 $SDKMAN_DIR
USER SCAM2021

# RUN cd workspace/intraj && sdk use java 7.0.292-zulu &&./gradlew build

