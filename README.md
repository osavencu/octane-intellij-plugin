# alm-octane-intellij-plugin

##Proof of concept:
Now building old octane plugin with gradle, using the https://github.com/JetBrains/gradle-intellij-plugin

###How to build:
Go to the project main folder and run: 
```
gradle buildPlugin
```

**Note:** you still need access to the sdk jar from the HPE nexus. <br>

**Note:** if you are experiencing issues inside the hpe network when gradle tries to download dependencies, create a gradle.properties file in the ~/.gradle folder. Inside you need to add your hpe proxy server, ex: <br>
```
systemProp.http.proxyHost=<proxy-server>
systemProp.http.proxyPort=<port>
systemProp.https.proxyHost=<proxy-server>
systemProp.https.proxyPort=<port>
```
###How to debug: 
```
gradle runIdea
```
If you want to use breakpoints I recommend importing the code into Intellij and running the runIdea gradle task with debug.
