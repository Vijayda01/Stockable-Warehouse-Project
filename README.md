# Stockable Warehouse Project

## Problem statement
Create an interface Stockable with method restock(). Implement it in a class WarehouseItem.

## About
A Java console application to create one warehouse item, view its stock,
restock a configured amount, and issue available units.
Demonstrates interfaces, overriding, encapsulation, constructors and polymorphism.
No external libraries needed. Data is in memory and resets when the program closes.

## Files
- src/Stockable.java: interface declaring restock().
- src/WarehouseItem.java: implementation and inventory logic.
- src/Main.java: interactive menu and validated input.
- run.bat: Windows compile-and-run launcher.
- START-HERE.txt: setup and GitHub upload steps.

## Run (JDK 17 or newer)
On Windows, extract the ZIP and double-click run.bat.
Or open a terminal in this folder and run:

```sh
javac -d out src/Stockable.java src/WarehouseItem.java src/Main.java
java -cp out Main
```

## Example check
Create WH101 / Keyboard / starting stock 20 / restock amount 10.
Choose 2: stock becomes 30.
Choose 3, then 5: stock becomes 25.
Choose 3, then 100: insufficient stock; quantity remains 25.
Choose 1 to view details, and 4 to exit.
Invalid numbers are rejected; stock cannot go negative or overflow on restock.
