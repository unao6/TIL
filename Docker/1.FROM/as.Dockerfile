FROM ubuntu AS a-stage
RUN echo "Hello A Stage." && touch /app.js

FROM ubuntu AS b-stage
RUN echo "Hello B Stage."
COPY --from=a-stage /app.js /a-app.js

FROM ubuntu AS c-stage
RUN echo "Hello C Stage."


# 빌드 방법 -> 마지막에 쓴 c-stage만 빌드
# docker build -t from.as -f as.Dockerfile .

# 특정 빌드 -> b-stage 타겟 빌드 (a-stage의 소스를 참조하기때문에 a-stage도 빌드됨)
# docker build -t from.as -f as.Dockerfile --target b-stage .