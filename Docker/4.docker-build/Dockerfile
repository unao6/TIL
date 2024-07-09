FROM nginx
COPY config/nginx.conf /etc/nginx/nginx.conf

# build
# docker build -t my-nginx .
# Dockerfile이 하나라면 알아서 이 철자로 이루어진 도커파일을 실행함

FROM nginx
ARG MY_CONFIG
COPY config/${MY_CONFIG} /etc/nginx/nginx.conf

# config가 여러개라면 이런식으로 환경변수로 받아서 처리할 수도 있다.
# docker build -t my-nginx --build-arg MY_CONFIG=b.conf .


FROM nginx AS dynamic-nginx
ARG MY_CONFIG
COPY config/${MY_CONFIG} /etc/nginx/nginx.conf

FROM nginx AS static-nginx
COPY config/nginx.conf /etc/nginx/nginx.conf

# 위의 두개가 있을때 아무 옵션을 주지않으면 마지막에 선언된 스테이지를 빌드하고 해당 스테디지를 빌드하려면 --target옵션 사용

# --------URL 기반 Build Context
# nginx의 깃헙에서 원하는 브랜치의 폴더를 직접 그 폴더가 있는 것처럼 빌드해 올 수도 있다. 깃주소/#브랜치명:해당폴더
# docker build -t remote-nginx https://github.com/nginxinc/docker-nginx.git/#master:stable/alpine-slim

# --------STDIN 기반 Build Context (standard in)
# docker build -t stdin-nginx - <<EDF  (<<EDF는 유닉스 계열에서 여러 문장을 사용할 수 있게 해주는 문법)
# FROM nginx AS static-nginx
# COPY config/nginx.conf /etc/nginx/nginx.conf
# EDF (이 문장이 끝났다는 표시)
# 이렇게 하면 이 도커 파일을 가지고 build가 이루어진다. but 에러가 날 것임. 왜냐면 COPY같은것이 안됨. 빼면 정상구동 된다.
