ARG MY_VERSION
FROM nginx:${MY_VERSION}

# 빌드하는 방법
# docker build -t from.arg -f arg.Dockerfile --build-arg MY_VERSION=stable-bookworm-perl .