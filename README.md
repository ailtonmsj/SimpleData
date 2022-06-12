# SimpleData

## A simple spring boot aplication to return a current date.

<br>

# Endpoints

## To get de date:

```
http://<LOAD-BALANCER-DNS>:80/simpledata
```

## To control the http status response code:

### To change http status from "/simple" to 500, use:
```
http://<LOAD-BALANCER-DNS>:80/simpledata/healthstatus?isHealth=false
```

### To change http status from "/simple" to 200, use:
```
http://<LOAD-BALANCER-DNS>:80/simpledata/healthstatus?isHealth=true
```


# To build a docker image:

## Single arch
```
mvn clean install
docker build -t <DOCKERHUB-USERNAME>/simpledata:<TAG-NAME>
```

## Build in multiarch (Linux arm64 AND amd64):
```
docker buildx build -t <DOCKERHUB-USERNAME>/simpledata:<TAG-NAME> --platform linux/arm64/v8,linux/amd64 --push .
```


# To run as Docker:
```
docker container run -p8080:8080 <DOCKERHUB-USERNAME>/simpledata:<TAG-NAME>
```
Eg:
```
docker container run -p8080:8080 ailtonmsj/simpledata:v1
```

# To Deploy as Kubernetes
```
kubectl apply -f ./k8s/
```
