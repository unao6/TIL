FROM ubuntu
RUN groupadd my-group && \
    useradd -G my-group -u 1001 user1 && \
    useradd -G my-group -u 1002 user2
USER user1:my-group
CMD id