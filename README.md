# endpoints-objectify-oauth2-scala-scalajs

Maven
-----

1) Build Scala JS with 1.1) $ SBT 1.2) fastOptJS

2) Run with $ mvn appengine:devserver

App Engine Devserver
--------------------

Run locally with Appengine SDK.

1) Build with maven $ mvn package

2) Optional: Download Appengine SDK or look for it in Maven repostiory

3) Start with address and port as parameters $ %APPENGINE_SDK_HOME%/bin/dev_appserver -a localhost -p 8080 target/.../webapp

4) Optional: Add flag to start Java remote debugger

```
--jvm_flag=-agentlib:jdwp=transport=dt_socket,address=8000,server=y,suspend=n
```

API Discover
------------

Check the API by starting it locally and go to (activate "insecure" scripts):

```
http://localhost:8080/_ah/api/explorer
``` 

Eclipse
-------

Create Eclipse project with some modifications and import

1) Install Scala IDE plugin

```
http://scala-ide.org/download/current.html
```

2) $ mvn eclipse:eclipse

3) Edit .project and replace builder and nature. You can create a new Eclipse Scala Project, open the .project file and use it as reference.

```
	<buildSpec>
		<buildCommand>
			<name>org.scala-ide.sdt.core.scalabuilder</name>
			<arguments>
			</arguments>
		</buildCommand>
	</buildSpec>
	<natures>
		<nature>org.scala-ide.sdt.core.scalanature</nature>
		<nature>org.eclipse.jdt.core.javanature</nature>
	</natures>
```
4) Import in Eclipse

5) Set source and target output

Notes
-----

- Remove RestService
- Move EndpointsFacade to endpoints pacakge
- Set source for Scala JS to src/main/scalajs and remove Objectify dependency in SBT scalaSource in Compile := baseDirectory.value / "src"
- Make it work and make sure it works on App Engine. Needs Java 7 compilation!
