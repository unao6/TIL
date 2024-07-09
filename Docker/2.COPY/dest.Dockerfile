FROM ubuntu
COPY origins/a.txt origins/b.txt /copied

# 파일들을 directory가 아닌 파일에 복사하면, 앞의 것은 다 무시하고 마지막 파일이 복사가 된다.
# 의도한 바가 아니기 때문에 복수개의 소스를 복사할 때에는 명시적으로 / 표시하는것을 유의해야 한다.
