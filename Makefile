# FinVerse Production Build & Orchestration Makefile
.PHONY: all install build test run docker-up docker-down clean

all: build test

install:
	cd frontend && npm install
	cd backend && mvn dependency:go-offline

build:
	cd backend && mvn clean package -DskipTests
	cd frontend && npm run build

test:
	cd backend && mvn clean test
	cd frontend && npm run test:run

run:
	docker compose up -d

docker-up:
	docker compose up -d --build

docker-down:
	docker compose down

clean:
	cd backend && mvn clean
	cd frontend && rm -rf dist node_modules
