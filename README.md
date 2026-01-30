1. 로컬에서 이미지 빌드하고 docker compose -> 로드 밸런싱
2. 로컬의 이미지 -> ghcr 이미지로 푸시(태그 변경-> PAT login -> 푸시)
3. 원격 클라우드 -> docker 설치 -> ghcr 로그인 -> 이미지 pull
4. 설정파일, .env -> git에서 pull할 수 있는건 pull 하고, 아닌건 작성
5. 구동 후 접속 (해당 IP:8080)으로 진행

### 이지 빌드 및 테스트
```sh
# 이미 Dockerfile 파일이 있음
docker build -t boot-server:latest .
# mac은 arm64 빌드를하고, ec2 -> amd64. -> 멀티 플랫폼을 위한 빌드
# macOS만 아래로 빌드
docker buildx build --platform linux/arm64,linux/amd64 -t boot-server:latest .
```