# endpoints-objectify-oauth2-scala-scalajs

ScalaJS
-------

Build ScalaJS including Google Endpoints and Angular:

1) $ SBT

2) fastOptJS

Maven
-----

1) Build ScalaJS (above)

2) Run with $ mvn appengine:devserver

Upload
------

Publish to Google Appengine with maven

1) Build ScalaJS (above)

2) $ mvn -Dapp.id=your-app-id -Dapp.version=your-app-version appengine:update

App Engine Devserver
--------------------

Run locally with Appengine SDK.

1) Build ScalaJS (above)

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

Oauth2
------

Sooooon ...

Foundation
----------

By Zurb for frontend framework.


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

6) Copy all libs from Maven build (target/enpoints.../WEB-INF/lib/*) to source (src/main/webapp/WEB-INF/lib/)

7) Run with App Engine Devserver (above) but with your source.

References
----------

* Angulate https://github.com/jokade/scalajs-angulate
* Endpoints client Javascript https://developers.google.com/eclipse/docs/endpoints-jspoints/consume_js 
* Endpoints tutorial https://cloud.google.com/appengine/docs/java/endpoints
* Scala JS scala-js.org
* Scala http://www.artima.com/pins1ed/a-scalable-language.html
* App Engine https://cloud.google.com/appengine/docs/java/
