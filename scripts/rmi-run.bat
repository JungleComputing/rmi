@echo off

if "%OS%"=="Windows_NT" @setlocal

rem %~dp0 is expanded pathname of the current script under NT

if "%RMI_HOME%X"=="X" set RMI_HOME=%~dp0..

set RMI_APP_ARGS=

:setupArgs
if ""%1""=="""" goto doneStart
set RMI_APP_ARGS=%RMI_APP_ARGS% %1
shift
goto setupArgs

:doneStart

java -classpath "%CLASSPATH%;%RMI_HOME%\lib\*" -Dlog4j.configuration=file:"%RMI_HOME%"\log4j.properties %RMI_APP_ARGS%

if "%OS%"=="Windows_NT" @endlocal
