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
	file.Write("Hello")
	file.Close()
}
