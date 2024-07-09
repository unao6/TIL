FROM nginx
COPY config/nginx.conf /etc/nginx/nginx.conf

# docker build -t my-nginx .
# docker run -d --name my-nginx my-nginx
# docker exec my-nginx /bin/bash  ( 명령 실행해보기 - 이렇게하면 접속이 됐다가 바로 끊김 )
# docker exec -it my-nginx /bin/bash  ( -it 옵션을 주면 접속이 끊기지 않고 표준 입출력으로 계속 유지됨 )
# 나올 때는 exit


FROM nginx
COPY config/nginx.conf /etc/nginx/nginx.conf
WORKDIR /etc/nginx

# 작업을 편하게 하기 위해서 nginx가 있는 경로로 workdir 설정
# 이런 편의도 파일을 작성할 때 고려해볼 수 있다!