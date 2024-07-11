FROM ubuntu
ARG ALPHA_ARG
ENV ALPHA=${ALPHA_ARG}
ENTRYPOINT echo "ALPHA is ${ALPHA}"

# 빌드시점에 환경변수 설정
# docker build -t env.buildtime --build-arg ALPHA_ARG=alpha -f buildtime.Dockerfile .
# 결과
# ALPHA is alpha