FROM ubuntu
ENV ALPHA=alpha
RUN echo "ALPHA_BRAVO is $ALPHA_BRAVO" >> /result.txt
RUN echo "ALPHA_BRAVO is ${ALPHA}_BRAVO" >> /result.txt
RUN echo "ALPHA with default is ${ALPHA:-DefaultAlpha}" >> /result.txt
RUN echo "ALPHA with default is ${ALPHA:+DefaultAlpha}" >> /result.txt
RUN echo "BRAVO with default is ${BRAVO:-DefaultBRAVO}" >> /result.txt
RUN echo "BRAVO with default is ${BRAVO:+DefaultBRAVO}" >> /result.txt
ENTRYPOINT cat /result.txt

# 결과
# ALPHA_BRAVO is
# ALPHA_BRAVO is alpha_BRAVO
# ALPHA with default is alpha
# ALPHA with default is DefaultAlpha
# BRAVO with default is DefaultBRAVO
# BRAVO with default is

# BRAVO가 없으면(-) DefaultBRAVO
# BRAVO가 있으면(+) DefaultBRAVO => 없기 때문에 빈 문자열이 들어옴
