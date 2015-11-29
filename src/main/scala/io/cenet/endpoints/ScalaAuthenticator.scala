package io.cenet.endpoints

import java.util.logging.Logger
import java.util.regex.Pattern

import org.apache.commons.codec.binary.Base64

import com.auth0.jwt.JWTVerifier
import com.google.api.server.spi.auth.common.{ User => SecureUser }
import com.google.api.server.spi.config.Authenticator
import com.google.gson.Gson

import javax.servlet.http.HttpServletRequest

/**
 * Scala translation of:
 * https://auth0.com/docs/server-apis/java
 */
class ScalaAuthenticator extends Authenticator {
  
  val log = Logger.getLogger(classOf[ScalaAuthenticator].getName())

  val secret = new Base64(true).decode("seceret");
  val jwtVerifier = new JWTVerifier(secret, "clientId");;

  override def authenticate(request: HttpServletRequest) = {
    val token = getToken(request)

    try {
      val decoded = jwtVerifier.verify(token);
      val gson = new Gson();
      val json = gson.toJson(decoded);
      log.info(json);
      new SecureUser("userId", "email");
    } catch {
      case e : Throwable =>
        throw new RuntimeException(e)
    }
  }

  def getToken(httpRequest : HttpServletRequest) = {
    val authorizationHeader = httpRequest.getHeader("authorization");
    if (authorizationHeader == null) {
        throw new RuntimeException("Unauthorized: No Authorization header was found");
    }

    val parts = authorizationHeader.split(" ");
    if (parts.length != 2) {
        throw new RuntimeException("Unauthorized: Format is Authorization: Bearer [token]");
    }

    val scheme = parts(0)
    val credentials = parts(1)

    val pattern = Pattern.compile("^Bearer$", Pattern.CASE_INSENSITIVE);
    if (pattern.matcher(scheme).matches()) {
        credentials
    } else {
      null
    }
  }
}