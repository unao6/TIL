FROM ubuntu
RUN ["sh", "-c", "echo My Home Directory is ${HOME} > /result.txt"]