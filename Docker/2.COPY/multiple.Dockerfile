FROM ubuntu
COPY origins/a.txt origins/b.txt /copied/

# build
# docker build -t copy.multiple -f multiple.Dockerfile .

# run
# docker run -it copy.multiple