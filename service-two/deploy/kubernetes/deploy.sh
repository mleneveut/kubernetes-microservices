
  helm upgrade \
    --${1:-install} \
    --wait \
    --debug \
    --kube-context minikube \
    --namespace default \
    --set Env=dev \
    --set DockerImage=service-two:1.0.0 \
    service-two \
    service-two