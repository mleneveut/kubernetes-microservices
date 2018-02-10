
  helm upgrade \
    --${1:-install} \
    --wait \
    --kube-context minikube \
    --namespace default \
    --set Env=dev \
    --set DockerImage=service-one:1.0.0 \
    service-one \
    service-one