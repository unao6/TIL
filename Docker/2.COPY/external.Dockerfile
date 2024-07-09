FROM ubuntu
COPY ../external.txt /copied/

# build
# docker build -t copy.external -f external.Dockerfile .
# 바깥에 있기 떄문에 에러가 난다.


# 되게 하려면

FROM ubuntu
COPY external.txt /copied/

# build
# docker build -t copy.external -f external.Dockerfile ..