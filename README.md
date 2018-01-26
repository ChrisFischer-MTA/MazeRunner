### MazeRunner

## Introduction
Reimaged this project (https://github.com/ChrisFischer-MTA/MazeRunner-BFS) that I made at CompSci @ UCF. Overall, it's identitcal in functionality (although the version that is public of the last project is bugged) - however is a lot more effective now that I actually know Java.

## Instructins and Arguments
Simply place a red dot at the start and a purple dot at finish (or vice-versa) and save the image in the directory of the program and call it input.png

The program has two potential arguments. hardmode, where any color that is not true black is assumed to be movable space and bold which bolds the line instead of doing a pixel-by-pixel shortest path possible.

## Classes
The programs classes and purposes are as follows:

> cleaner - go through the image, find distance between colors and make guesses, and convert the maze into a 2d char array for faster processing.

> point - an object used to track any x,y and past path

> solver - the object that contains the logic of the program - for instance where to move 

> exporter - the portion of the program that converts the 2d character array, after processing, into a BufferedImage and writes it to disk.

## Purpose
This program is desigend to work on a video game, aMaze, and will be released (again) in conjunction with my next project which will play the game autonomously. 

## Time
Overall main was created the 25th at 6:00PM and the final commit was the 26th at 12:30 PM which is pretty OK time for something like this.

## Author

Christopher R. Fischer

Freedom High School / Valencia Community College

Cisco Certified Progressional / Oracle Certified / Microsoft Technology Associate / CompTia Certified / NAUI SCUBA Diver Certified.

Best way to contact me is via my GitHub.

