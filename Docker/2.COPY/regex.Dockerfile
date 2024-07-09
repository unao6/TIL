FROM ubuntu
COPY origins/*.txt /copied/

# build
# docker build -t copy.regex -f regex.Dockerfile .

# run
# docker run -it copy.regex