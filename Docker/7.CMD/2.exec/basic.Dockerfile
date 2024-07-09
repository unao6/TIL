FROM ubuntu
# CMD echo "My Home Directory is ${HOME}"
# CMD ["echo", "My Home Directory is ${HOME}"]
CMD ["sh", "-c", "echo My Home Directory is ${HOME} > /result.txt"]

# RUN과 거의 동일하다!

CMD echo "Hello workd 001"
CMD echo "Hello workd 002"
CMD echo "Hello workd 003"
CMD ["sh", "-c", "echo My Home Directory is ${HOME} > /result.txt"]

# 가장 마지막에 쓴 CMD 만 적용된다.

# docker run -it cmd.exec.basic echo "Hello world"
# 이렇게 쓴다면, 마니막에 쓴 명령어가 유효하나 , 터미널에서 작성한 명령어가 실행된다.
# 결과: Hello world