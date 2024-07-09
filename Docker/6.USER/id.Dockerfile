FROM ubuntu
RUN groupadd my-group && \
    useradd -G my-group -u 1001 user1 && \
    useradd -G my-group -u 1002 user2
USER 1002
CMD id