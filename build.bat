@ECHO OFF
rem Build
 
mkdir class
 
javac -cp src -d class src\br\com\mvbos\mlipboard\App.java
 
jar cfm mlipboard.jar mf.mf -C class/ .
