MAKEFLAGS += --warn-undefined-variables
MAKEFLAGS += --no-builtin-rules
MAKEFLAGS += --no-builtin-variables

.DEFAULT_GOAL := all
SHELL := bash

.PHONY: all
all: clean format compile test run

.PHONY: clean
clean:
	sbt clean

.PHONY: format
format:
	sbt scalafmtAll

.PHONY: compile
compile:
	sbt compile

.PHONY: test
test:
	sbt test

.PHONY: run
run:
	sbt run

.PHONY: console
console:
	sbt console
