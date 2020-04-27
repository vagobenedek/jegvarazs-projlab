@echo off
SET /p var=Which test do you want to run? If you would like to run one specific test, give it's number. If you want to run all tests, give 'all' then a space and then the numer of tests you have. 
javac Main.java && java Main %var%
javac Comparator.java && java Comparator %var%
PAUSE
