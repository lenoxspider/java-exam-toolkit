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

## Notes

- Letter grades use the common scale: A (80+), B (70–79), C (60–69), D (50–59), F (<50)
- Final score calculation: `0.3 * midSem + 0.7 * exam`

