FROM ubuntu
#RUN echo "My Home Directory is ${HOME}" > /result.txt

RUN ["echo", "My Home Directory is ${HOME}", ">", "/result.txt"]
# 기본적인 쉘 프로세싱이 일어나지 않아서 원하는대로 동작하지 않는다.
# 실행 파일 형식은 명령어를 JSON 배열로 지정하며, 명령어와 인수를 개별 요소로 나눕니다.
# 이 형식은 쉘을 사용하지 않고, 직접 실행 파일을 호출합니다. 따라서 쉘의 기능을 사용할 수 없습니다.
# 여기서 echo 명령어는 직접 실행되며, >는 echo 명령어의 인수로 취급되기 때문에 리다이렉션이 제대로 동작하지 않습니다.

RUN ["sh", "-c", "echo My Home Directory is ${HOME} > /result.txt"]
# 이러면 정상 동작. sh 쉘을 명시적으로 호출하고, -c 옵션을 사용하여 쉘 명령어를 문자열로 전달
