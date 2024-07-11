FROM ubuntu AS parent
ENV ALPHA=alpha

FROM parent
ENV BRAVO=bravo
ENTRYPOINT echo "ALPHA from parent = ${ALPHA}, BRAVO = ${BRAVO}"

# 결과
# ALPHA from parent = alpha, BRAVO = bravo

FROM parent
ENV ALPHA=redefined
ENV BRAVO=bravo
ENTRYPOINT echo "ALPHA from parent = ${ALPHA}, BRAVO = ${BRAVO}"

# 결과
# ALPHA from parent = redefined, BRAVO = bravo
# 다시 정의하면 덮어써지는 것을 볼 수 있다.