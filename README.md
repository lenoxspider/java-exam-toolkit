# Java Exam Toolkit

A small Java console toolkit based on exam-style exercises:

- Generate student index numbers to a file
- Compute weighted final scores + letter grades
- Analyze a student/subject score matrix (totals, averages, grade distribution, highest score, and per-student lookup)

## Run

From the `java-exam-toolkit` folder:

```powershell
javac -d out src\*.java
java -cp out Main
```

## Example Output

### Weighted final grades

```text
| Index No. | Final Score | Grade |
|----------|------------:|:-----:|
| 10021007 | 74.10 | B |
| 10021107 | 52.20 | D |
| 10021207 | 69.60 | C |
...
```

### Generate index numbers

Creates an `indexnumbers.txt` file (one index number per line).

```text
Wrote index numbers to indexnumbers.txt
```

Example file contents:

```text
10021007
10021107
10021207
10021307
10021407
```

### Score matrix analysis

```text
Student 1: 97 72 62 65 | Total: 296 | Avg: 74.00
Student 2: 43 68 24 3 | Total: 138 | Avg: 34.50
Student 3: 9 85 92 77 | Total: 263 | Avg: 65.75

Highest score: 97
Found at Student 1, Subject 1

Grade Distribution:
A: 3
B: 2
C: 3
D: 0
F: 4
```

## Notes

- Letter grades use the common scale: A (80+), B (70–79), C (60–69), D (50–59), F (<50)
- Final score calculation: `0.3 * midSem + 0.7 * exam`
