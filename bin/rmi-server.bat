@echo off

if "%OS%"=="Windows_NT" @setlocal

rem %~dp0 is expanded pathname of the current script under NT

if "%RMI_HOME%X"=="X" set RMI_HOME=%~dp0..

set SERVER_ARGS=

:setupArgs

if ""%1""=="""" goto doneArgs

set SERVER_ARGS=%SERVER_ARGS% "%1"

shift
goto setupArgs

rem This label provides a place for the argument list loop to break out
rem and for NT handling to skip to.

:doneArgs

java -classpath "%CLASSPATH%;%RMI_HOME%\lib\*" -Dlog4j.configuration=file:"%RMI_HOME%"\log4j.properties ibis.ipl.server.Server %SERVER_ARGS%

if "%OS%"=="Windows_NT" @endlocal
