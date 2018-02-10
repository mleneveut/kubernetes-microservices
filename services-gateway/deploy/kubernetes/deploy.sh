
  helm upgrade \
    --${1:-install} \
    --wait \
    --kube-context minikube \
    --namespace default \
    --set Env=dev \
    --set DockerImage=services-gateway:1.0.0 \
    services-gateway \
    services-gateway