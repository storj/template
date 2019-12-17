// Copyright (C) 2019 Storj Labs, Inc.
// See LICENSE for copying information.

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

	_, err = file.Write([]byte("Hello"))
	if err != nil {
		panic(err)
	}
}
