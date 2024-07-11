FROM ubuntu
ENV ALPHA=alpha
ENTRYPOINT echo "ALPHA is ${ALPHA}"

# 결과
# ALPHA is alpha

# 런타임 시점에 환경변수 설정하기 (-e)
# docker run -it -e ALPHA=alphaFromRuntime env.runtime
# 결과
# ALPHA is alphaFromRuntime

FROM ubuntu
ENV ALPHA=alpha
ENTRYPOINT echo "ALPHA is ${ALPHA}, BRAVO is ${BRAVO}"

# .env 파일로 런타임 시점에 환경변수 설정하기 ( --env-file [env파일 경로] )
# docker run -it --env-file .env env.runtime
# 결과
# ALPHA is alphaFromEnvFile, BRAVO is barvoFromEnvFile