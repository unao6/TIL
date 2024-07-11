FROM ubuntu
RUN echo "HOME origin is ${HOME}" >> /results.txt
ENV HOME=HelloWorld
RUN echo "HOME current is ${HOME}" >> /results.txt
ENTRYPOINT cat /results.txt

# 결과
# HOME origin is /root
# HOME current is HelloWorld
# => 매우 위험하다! 그러니 환경변수가 있는지 이미 있는지 확인해보고
# MY_HOME 등의 형식으로 접두사를 주어서 덮어쓰지 않도록 사용하자.