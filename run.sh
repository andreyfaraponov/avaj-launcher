find . -name "*.java" > src.txt
javac -sourcepath . @sources.txt
java avaj.simulator.AvajLauncher test.txt
find . -name "*.class" -delete
