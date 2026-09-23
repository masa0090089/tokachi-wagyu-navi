# --- ステージ1: Reactのビルド ---
FROM node:20-alpine AS react-build
WORKDIR /app/tokachi-wagyu-app
COPY tokachi-wagyu-app/package*.json ./
RUN npm install
COPY tokachi-wagyu-app/ ./
RUN npm run build

# --- ステージ2: Spring Bootのビルド ---
FROM eclipse-temurin:17-jdk-alpine AS build
WORKDIR /app

# Spring Bootのファイルをコピー
COPY . .

# ステージ1でビルドしたReactの成果物を、Spring Bootの静的リソース配置先へコピーする
COPY --from=react-build /app/tokachi-wagyu-app/dist /app/src/main/resources/static

RUN chmod +x gradlew
RUN ./gradlew bootJar -x test

# --- ステージ3: 実行ステージ ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app

COPY --from=build /app/build/libs/*.jar app.jar

EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]