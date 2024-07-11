FROM ubuntu
ENV ALPHA="alpha"
ENV BRAVO=bravo
ENV CHARLIE="Hello \
charlie"
ENV DELTA=delta ECHO="echo"
ENTRYPOINT echo "ALPHA = ${ALPHA} \
BRAVO = ${BRAVO} \
CHARLIE = ${CHARLIE} \
DELTA = ${DELTA} \
ECHO = ${ECHO}"


# 결과
# ALPHA = alpha BRAVO = bravo CHARLIE = Hello charlie DELTA = delta ECHO = echo