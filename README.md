# SimpleData

## A simple spring boot aplication to return a current date.

### To build a docker image:
$ docker build -t ROOT-NAME/IMAGE-NAME:TAG-VERSION


### To run:
$ docker container run -p8080:8080 ROOT-NAME/IMAGE-NAME:TAG-VERSION

Eg:

$ docker container run -p8080:8080 ailtonmsj/simpledata:v1


### To run (detached):
$ docker container run -p8080:8080 --detach --name test ROOT-NAME/IMAGE-NAME:TAG-VERSION

Eg:

$ docker container run -p8080:8080 --detach --name test ailtonmsj/simpledata:v1


### URL to test:

http://localhost:8080/


### .yaml manisfests to consume only inside the cluster:

http://simpledata.demo-circuitbreaker.svc.cluster.local/8080