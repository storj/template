package main

import (
	"fmt"
	"os"
)

func main() {
	fmt.Println("hello world")

	file, err := os.Create("example.txt")
	if err != nil {
		panic(err)
	}

	defer func() {
		if err := file.Close(); err != nil {
			panic(err)
		}
	}()

	if err := file.Write("Hello"); err != nil {
		panic(err)
	}
}
