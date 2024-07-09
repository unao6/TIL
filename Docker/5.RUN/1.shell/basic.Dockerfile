FROM ubuntu
RUN echo "My Home Directory is ${HOME}" > /result.txt


FROM ubuntu
RUN echo "My Home Directory is \
    ${HOME}" > /result.txt \

# 길어지거나 복잡하면 백슬래쉬로 줄바꿈을 할 수 있다.

