find . -name "*.java" > sources.txt
javac -sourcepath @sources.txt
java simulator1.AvajLauncher $1
