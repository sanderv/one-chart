# One chart to rule them all
This repo is part of my blogpost with the same title: https://sanderverbruggen.com/one-chart-to-rule-them-all/

After reading it, come back to play with this setup and try the different approaches from the post by yourself. 

# Building and running the Spring Boot application
```shell
./gradlew bootRun
```
will result in an error because of missing property as mentioned in the blogpost.
You'll need to provide a Spring profile to run it locally. 
The pro file `local` has been provided. To run the app with this, do:
```shell
./gradlew bootRun --args='--spring.profiles.active=local'
```
This will give you two endpoints to `curl` or open in your browser:
- http://localhost:8080/messages/motd
- http://localhost:8080/messages/quote

If you play around with the `application-local.yaml` you can enable either/both of these endpoints:
- http://localhost:8080/alpha/awesomeResult
- http://localhost:8080/beta/quiteStable

# Setting up a local Kubernetes cluster
You'll need docker, but I presume you have that running or now how to install it.

[k3d](https://k3d.io) is a simple, lightweight Kubernetes cluster manager for local clusters.
The simplest way to install it is through [Homebrew](https://brew.sh). 
After installing Homebrew, run this from the project folder:
```shell
brew install k3d helm kubectl
k3d cluster create one-chart -p "8090:30080@agent:0" --agents 2
```
After a few seconds, you will have your cluster up and running.

## Installing the app using the helm chart
The go to the `helm/one-chart` folder and run
```shell
helm install one-chart . -f values.yaml
```
This will pull the docker image of the Spring Boot app and run it using the `values.yaml` in this folder.
You now have access to the same 4 endpoints as listed above, only now they're running on port `8090` (e.g. http://localhost:8090/messages/motd)

Now you can play with the contents of `values.yaml`. 
After saving it, use helm to `upgrade` (`install` is only for the first time) your deployed app:
```shell
helm upgrade one-chart . -f values.yaml
```
After a few seconds the app should be working with your changed settings!

# Done with all of this?
Time to clean up:
```shell
k3d cluster delete one-chart
```
