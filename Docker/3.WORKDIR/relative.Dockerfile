FROM ubuntu
WORKDIR /some/path
WORKDIR other/path
CMD pwd

# 결과 경로
# /some/path/other/path