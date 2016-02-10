# endpoints-objectify-oauth2-scala-scalajs

This is a small example of how to implement Angular and Google Endpoints with Scala JS.

https://master-dot-io-cenet-scalajs-concept.appspot.com

ScalaJS
-------

Build ScalaJS including Google Endpoints and Angular:

1) $ sbt

2) fastOptJS

Maven
-----

1) Build ScalaJS (above)

2) Run with (no hot deploy) $ mvn appengine:devserver

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

3) Build webapp folder. Compile into webapp/WEB-INF/classes and copy dependency libs to webapp/WEB-INF/lib

4) Start with address and port as parameters $ %APPENGINE_SDK_HOME%/bin/dev_appserver -a localhost -p 8080 target/.../webapp

5) Optional: Add flag to start Java remote debugger
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

Either use

1 Google Oauth2 with Google Endpoints. See https://cloud.google.com/appengine/docs/java/endpoints/consume_js

2 Use another provider and send the token in either with Google Endpoints generated Javascript See https://developers.google.com/api-client-library/javascript/reference/referencedocs#gapiauthsettokentoken

```
gapi.auth.setToken({access_token: token});
```

3 Activate sessions in Google Endpoints backend and use a authenticator (below). Remember that Endpoints may not use a custom domain and authorization is per domain! See http://stackoverflow.com/a/28745414/671188

```
auth = @ApiAuth(allowCookieAuth = AnnotationBoolean.TRUE)
``` 


Example of Scala Authenticator:

https://github.com/AIMMOTH/endpoints-objectify-oauth2-scala-scalajs-angular/blob/master/src/main/scala/io/cenet/endpoints/ScalaAuthenticator.scala

Foundation
----------

Foundation frontend framework by Zurb.

Eclipse
-------
1) Install Scala IDE plugin

```
http://scala-ide.org/download/current.html
```

2) Import as Maven projects


References
----------

* Angulate https://github.com/jokade/scalajs-angulate
* Endpoints client Javascript https://developers.google.com/eclipse/docs/endpoints-jspoints/consume_js 
* Endpoints tutorial https://cloud.google.com/appengine/docs/java/endpoints
* Scala JS scala-js.org
* Scala http://www.artima.com/pins1ed/a-scalable-language.html
* App Engine https://cloud.google.com/appengine/docs/java/
* Zurb Foundation http://foundation.zurb.com/sites/docs/kitchen-sink.html
